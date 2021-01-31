// Copyright 2015 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.snackbar;

import android.app.Activity;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import org.chromium.base.ActivityState;
import org.chromium.base.ApplicationStatus;
import org.chromium.base.ApplicationStatus.ActivityStateListener;
import org.chromium.base.VisibleForTesting;
import org.chromium.base.metrics.RecordHistogram;
import org.chromium.chrome.browser.infobar.InfoBar;
import org.chromium.chrome.browser.infobar.InfoBarContainer;
import org.chromium.chrome.browser.util.AccessibilityUtil;

/**
 * Manager for the snackbar showing at the bottom of activity. There should be only one
 * SnackbarManager and one snackbar in the activity.
 * <p/>
 * When action button is clicked, this manager will call {@link SnackbarController#onAction(Object)}
 * in corresponding listener, and show the next entry. Otherwise if no action is taken by user
 * during {@link #DEFAULT_SNACKBAR_DURATION_MS} milliseconds, it will call
 * {@link SnackbarController#onDismissNoAction(Object)}. Note, snackbars of
 * {@link Snackbar#TYPE_PERSISTENT} do not get automatically dismissed after a timeout.
 */
public class SnackbarManager implements OnClickListener, InfoBarContainer.InfoBarContainerObserver,
                                        ActivityStateListener {
    /**
     * Interface that shows the ability to provide a snackbar manager.
     */
    public interface SnackbarManageable {
        /**
         * @return The snackbar manager that has a proper anchor view.
         */
        SnackbarManager getSnackbarManager();
    }

    /**
     * Controller that post entries to snackbar manager and interact with snackbar manager during
     * dismissal and action click event.
     */
    public interface SnackbarController {
        /**
         * Called when the user clicks the action button on the snackbar.
         * @param actionData Data object passed when showing this specific snackbar.
         */
        default void onAction(Object actionData) { }

        /**
         * Called when the snackbar is dismissed by timeout or UI environment change.
         * @param actionData Data object associated with the dismissed snackbar entry.
         */
        default void onDismissNoAction(Object actionData) { }
    }

    public static final int DEFAULT_SNACKBAR_DURATION_MS = 3000;
    private static final int ACCESSIBILITY_MODE_SNACKBAR_DURATION_MS = 10000;

    // Used instead of the constant so tests can override the value.
    private static int sSnackbarDurationMs = DEFAULT_SNACKBAR_DURATION_MS;
    private static int sAccessibilitySnackbarDurationMs = ACCESSIBILITY_MODE_SNACKBAR_DURATION_MS;

    private final Activity mActivity;
    private SnackbarView mView;
    private final Handler mUIThreadHandler;
    private final SnackbarCollection mSnackbars = new SnackbarCollection();
    private boolean mActivityInForeground;
    private boolean mIsDisabledForTesting;
    private final ViewGroup mSnackbarParentView;
    private final Runnable mHideRunnable = new Runnable() {
        @Override
        public void run() {
            mSnackbars.removeCurrentDueToTimeout();
            updateView();
        }
    };

    /**
     * Constructs a SnackbarManager to show snackbars in the given window.
     * @param activity The embedding activity.
     * @param snackbarParentView The ViewGroup used to display snackbars. If this is null, the
     *                           {@link SnackbarView} will determine where to attach the snackbar.
     */
    public SnackbarManager(Activity activity, @Nullable ViewGroup snackbarParentView) {
        mActivity = activity;
        mUIThreadHandler = new Handler();
        mSnackbarParentView = snackbarParentView;

        ApplicationStatus.registerStateListenerForActivity(this, mActivity);
        if (ApplicationStatus.getStateForActivity(mActivity) == ActivityState.STARTED) {
            onStart();
        }
    }

    @Override
    public void onActivityStateChange(Activity activity, @ActivityState int newState) {
        assert activity == mActivity;
        if (newState == ActivityState.STARTED) {
            onStart();
        } else if (newState == ActivityState.STOPPED) {
            onStop();
        }
    }

    /**
     * Notifies the snackbar manager that the activity is running in foreground now.
     */
    private void onStart() {
        mActivityInForeground = true;
    }

    /**
     * Notifies the snackbar manager that the activity has been pushed to background.
     */
    private void onStop() {
        mSnackbars.clear();
        updateView();
        mActivityInForeground = false;
    }

    /**
     * Shows a snackbar at the bottom of the screen, or above the keyboard if the keyboard is
     * visible.
     */
    public void showSnackbar(Snackbar snackbar) {
        if (!mActivityInForeground || mIsDisabledForTesting) return;
        RecordHistogram.recordSparseHistogram("Snackbar.Shown", snackbar.getIdentifier());

        mSnackbars.add(snackbar);
        updateView();
        mView.announceforAccessibility();
    }

    /** Dismisses all snackbars. */
    public void dismissAllSnackbars() {
        if (mSnackbars.isEmpty()) return;

        mSnackbars.clear();
        updateView();
    }

    /**
     * Dismisses snackbars that are associated with the given {@link SnackbarController}.
     *
     * @param controller Only snackbars with this controller will be removed.
     */
    public void dismissSnackbars(SnackbarController controller) {
        if (mSnackbars.removeMatchingSnackbars(controller)) {
            updateView();
        }
    }

    /**
     * Dismisses snackbars that have a certain controller and action data.
     *
     * @param controller Only snackbars with this controller will be removed.
     * @param actionData Only snackbars whose action data is equal to actionData will be removed.
     */
    public void dismissSnackbars(SnackbarController controller, Object actionData) {
        if (mSnackbars.removeMatchingSnackbars(controller, actionData)) {
            updateView();
        }
    }

    /**
     * Handles click event for action button at end of snackbar.
     */
    @Override
    public void onClick(View v) {
        mSnackbars.removeCurrentDueToAction();
        updateView();
    }

    // InfoBarContainerObserver implementation.
    @Override
    public void onAddInfoBar(InfoBarContainer container, InfoBar infoBar, boolean isFirst) {
        // Bring Snackbars to the foreground so that it's not blocked by infobars.
        if (isShowing()) {
            mView.bringToFront();
        }
    }

    @Override
    public void onRemoveInfoBar(InfoBarContainer container, InfoBar infoBar, boolean isLast) {}

    @Override
    public void onInfoBarContainerAttachedToWindow(boolean hasInfobars) {}

    @Override
    public void onInfoBarContainerShownRatioChanged(InfoBarContainer container, float shownRatio) {}

    /**
     * Temporarily changes the parent {@link ViewGroup} of the snackbar. If a snackbar is currently
     * showing, this method removes the snackbar from its original parent, and attaches it to the
     * given parent. If <code>null</code> is given, the snackbar will be reattached to its original
     * parent.
     *
     * @param overridingParent The temporary parent of the snackbar. If null, previous calls of this
     *                         method will be reverted.
     */
    public void overrideParent(ViewGroup overridingParent) {
        if (mView != null) mView.overrideParent(overridingParent);
    }

    /**
     * @return Whether there is a snackbar on screen.
     */
    public boolean isShowing() {
        return mView != null && mView.isShowing();
    }

    /**
     * Updates the {@link SnackbarView} to reflect the value of mSnackbars.currentSnackbar(), which
     * may be null. This might show, change, or hide the view.
     */
    private void updateView() {
        if (!mActivityInForeground) return;
        Snackbar currentSnackbar = mSnackbars.getCurrent();
        if (currentSnackbar == null) {
            mUIThreadHandler.removeCallbacks(mHideRunnable);
            if (mView != null) {
                mView.dismiss();
                mView = null;
            }
        } else {
            boolean viewChanged = true;
            if (mView == null) {
                mView = new SnackbarView(mActivity, this, currentSnackbar, mSnackbarParentView);
                mView.show();
            } else {
                viewChanged = mView.update(currentSnackbar);
            }

            if (viewChanged) {
                mUIThreadHandler.removeCallbacks(mHideRunnable);
                if (!currentSnackbar.isTypePersistent()) {
                    int durationMs = getDuration(currentSnackbar);
                    mUIThreadHandler.postDelayed(mHideRunnable, durationMs);
                }
                mView.announceforAccessibility();
            }
        }

    }

    private int getDuration(Snackbar snackbar) {
        int durationMs = snackbar.getDuration();
        if (durationMs == 0) durationMs = sSnackbarDurationMs;

        if (AccessibilityUtil.isAccessibilityEnabled()) {
            durationMs *= 2;
            if (durationMs < sAccessibilitySnackbarDurationMs)
                durationMs = sAccessibilitySnackbarDurationMs;
        }

        return durationMs;
    }

    /**
     * Disables the snackbar manager. This is only intended for testing purposes.
     */
    @VisibleForTesting
    public void disableForTesting() {
        mIsDisabledForTesting = true;
    }

    /**
     * Overrides the default snackbar duration with a custom value for testing.
     * @param durationMs The duration to use in ms.
     */
    @VisibleForTesting
    public static void setDurationForTesting(int durationMs) {
        sSnackbarDurationMs = durationMs;
        sAccessibilitySnackbarDurationMs = durationMs;
    }

    /**
     * @return The currently showing snackbar. For testing only.
     */
    @VisibleForTesting
    public Snackbar getCurrentSnackbarForTesting() {
        return mSnackbars.getCurrent();
    }
}
