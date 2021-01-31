// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.autofill;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import org.chromium.base.annotations.CalledByNative;
import org.chromium.base.annotations.JNINamespace;
import org.chromium.chrome.R;
import org.chromium.chrome.browser.ChromeActivity;
import org.chromium.chrome.browser.ResourceId;
import org.chromium.chrome.browser.autofill.keyboard_accessory.AccessoryAction;
import org.chromium.chrome.browser.autofill.keyboard_accessory.KeyboardAccessoryData;
import org.chromium.chrome.browser.autofill.keyboard_accessory.KeyboardAccessoryMetricsRecorder;
import org.chromium.chrome.browser.autofill.keyboard_accessory.ManualFillingCoordinator;
import org.chromium.components.autofill.AutofillDelegate;
import org.chromium.components.autofill.AutofillSuggestion;
import org.chromium.components.autofill.PopupItemId;
import org.chromium.ui.DropdownItem;
import org.chromium.ui.base.WindowAndroid;

import java.util.ArrayList;
import java.util.List;

/**
* JNI call glue for AutofillExternalDelagate C++ and Java objects.
* This provides an alternative UI for Autofill suggestions, and replaces AutofillPopupBridge when
* --enable-autofill-keyboard-accessory-view is passed on the command line.
*/
@JNINamespace("autofill")
public class AutofillKeyboardAccessoryBridge
        implements AutofillDelegate, DialogInterface.OnClickListener {
    private long mNativeAutofillKeyboardAccessory;
    private ManualFillingCoordinator mManualFillingCoordinator;
    private Context mContext;
    private final KeyboardAccessoryData.Provider<KeyboardAccessoryData.Action[]> mChipProvider =
            new KeyboardAccessoryData.PropertyProvider<>(AccessoryAction.AUTOFILL_SUGGESTION);

    private AutofillKeyboardAccessoryBridge() {
    }

    @CalledByNative
    private static AutofillKeyboardAccessoryBridge create() {
        return new AutofillKeyboardAccessoryBridge();
    }

    @Override
    public void dismissed() {
        if (mNativeAutofillKeyboardAccessory == 0) return;
        nativeViewDismissed(mNativeAutofillKeyboardAccessory);
    }

    @Override
    public void suggestionSelected(int listIndex) {
        KeyboardAccessoryMetricsRecorder.recordActionSelected(AccessoryAction.AUTOFILL_SUGGESTION);
        mManualFillingCoordinator.dismiss();
        if (mNativeAutofillKeyboardAccessory == 0) return;
        nativeSuggestionSelected(mNativeAutofillKeyboardAccessory, listIndex);
    }

    @Override
    public void deleteSuggestion(int listIndex) {
        if (mNativeAutofillKeyboardAccessory == 0) return;
        nativeDeletionRequested(mNativeAutofillKeyboardAccessory, listIndex);
    }

    @Override
    public void accessibilityFocusCleared() {}

    @Override
    public void onClick(DialogInterface dialog, int which) {
        assert which == DialogInterface.BUTTON_POSITIVE;
        if (mNativeAutofillKeyboardAccessory == 0) return;
        nativeDeletionConfirmed(mNativeAutofillKeyboardAccessory);
    }

    /**
     * Initializes this object.
     * This function should be called at most one time.
     * @param nativeAutofillKeyboardAccessory Handle to the native counterpart.
     * @param windowAndroid The window on which to show the suggestions.
     * @param animationDurationMillis If 0, do not animate. Otherwise, animation duration in each
     *                                direction. We reverse animation to scroll the first suggestion
     *                                (which is a hint to call attention to the accessory) out of
     *                                the viewport at the end of the reversed animation.
     * @param shouldLimitLabelWidth If true, limit suggestion label width to 1/2 device's width.
     */
    @CalledByNative
    private void init(long nativeAutofillKeyboardAccessory, WindowAndroid windowAndroid,
            int animationDurationMillis, boolean shouldLimitLabelWidth) {
        mContext = windowAndroid.getActivity().get();
        assert mContext != null;
        if (mContext instanceof ChromeActivity) {
            mManualFillingCoordinator = ((ChromeActivity) mContext).getManualFillingController();
            if (mManualFillingCoordinator.getKeyboardAccessory() != null) {
                mManualFillingCoordinator.getKeyboardAccessory().registerActionProvider(
                        mChipProvider);
            }
        }

        mNativeAutofillKeyboardAccessory = nativeAutofillKeyboardAccessory;
    }

    /**
     * Clears the reference to the native view.
     */
    @CalledByNative
    private void resetNativeViewPointer() {
        mNativeAutofillKeyboardAccessory = 0;
    }

    /**
     * Hides the Autofill view.
     */
    @CalledByNative
    private void dismiss() {
        mChipProvider.notifyObservers(new KeyboardAccessoryData.Action[0]);
        mContext = null;
    }

    /**
     * Shows an Autofill view with specified suggestions.
     * @param suggestions Autofill suggestions to be displayed.
     */
    @CalledByNative
    private void show(AutofillSuggestion[] suggestions, boolean isRtl) {
        mChipProvider.notifyObservers(convertSuggestionsToChips(suggestions));
    }

    private KeyboardAccessoryData.Action[] convertSuggestionsToChips(
            AutofillSuggestion[] suggestions) {
        List<KeyboardAccessoryData.Action> suggestionChips = new ArrayList<>();
        for (int i = 0; i < suggestions.length; ++i) {
            AutofillSuggestion suggestion = suggestions[i];
            // The accessory doesn't need any special options like clearing or managing for now.
            if (suggestion.getSuggestionId() == PopupItemId.ITEM_ID_ALL_SAVED_PASSWORDS_ENTRY
                    || suggestion.getSuggestionId() == PopupItemId.ITEM_ID_CLEAR_FORM
                    || suggestion.getSuggestionId() == PopupItemId.ITEM_ID_SEPARATOR
                    || suggestion.getSuggestionId() == PopupItemId.ITEM_ID_AUTOFILL_OPTIONS) {
                continue;
            }
            final int triggerPosition = i;
            suggestionChips.add(new KeyboardAccessoryData.Action(suggestion.getLabel(),
                    AccessoryAction.AUTOFILL_SUGGESTION,
                    result -> suggestionSelected(triggerPosition)));
        }
        return suggestionChips.toArray(new KeyboardAccessoryData.Action[suggestionChips.size()]);
    }

    // Helper methods for AutofillSuggestion. These are copied from AutofillPopupBridge (which
    // should
    // eventually disappear).

    @CalledByNative
    private void confirmDeletion(String title, String body) {
        new AlertDialog.Builder(mContext, R.style.AlertDialogTheme)
                .setTitle(title)
                .setMessage(body)
                .setNegativeButton(R.string.cancel, null)
                .setPositiveButton(R.string.ok, this)
                .create()
                .show();
    }

    @CalledByNative
    private static AutofillSuggestion[] createAutofillSuggestionArray(int size) {
        return new AutofillSuggestion[size];
    }

    /**
     * @param array AutofillSuggestion array that should get a new suggestion added.
     * @param index Index in the array where to place a new suggestion.
     * @param label Suggested text. The text that's going to be filled in the focused field, with a
     *              few exceptions:
     *              <ul>
     *                  <li>Credit card numbers are elided, e.g. "Visa ****-1234."</li>
     *                  <li>The text "CLEAR FORM" will clear the filled in text.</li>
     *                  <li>Empty text can be used to display only icons, e.g. for credit card scan
     *                      or editing autofill settings.</li>
     *              </ul>
     * @param sublabel Hint for the suggested text. The text that's going to be filled in the
     *                 unfocused fields of the form. If {@see label} is empty, then this must be
     *                 empty too.
     * @param iconId The resource ID for the icon associated with the suggestion, or 0 for no icon.
     * @param suggestionId Identifier for the suggestion type.
     * @param isDeletable Whether the item can be deleted by the user.
     */
    @CalledByNative
    private static void addToAutofillSuggestionArray(AutofillSuggestion[] array, int index,
            String label, String sublabel, int iconId, int suggestionId, boolean isDeletable) {
        int drawableId = iconId == 0 ? DropdownItem.NO_ICON : ResourceId.mapToDrawableId(iconId);
        array[index] = new AutofillSuggestion(label, sublabel, drawableId,
                false /* isIconAtStart */, suggestionId, isDeletable, false /* isMultilineLabel */,
                false /* isBoldLabel */);
    }

    private native void nativeViewDismissed(long nativeAutofillKeyboardAccessoryView);
    private native void nativeSuggestionSelected(
            long nativeAutofillKeyboardAccessoryView, int listIndex);
    private native void nativeDeletionRequested(
            long nativeAutofillKeyboardAccessoryView, int listIndex);
    private native void nativeDeletionConfirmed(long nativeAutofillKeyboardAccessoryView);
}
