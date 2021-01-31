// Copyright 2018 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

package org.chromium.chrome.browser.notifications;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import org.chromium.base.ContextUtils;
import org.chromium.base.Log;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Class to intercept {@link PendingIntent}s from notifications, including
 * {@link Notification#contentIntent}, {@link Notification.Action#actionIntent} and
 * {@link Notification#deleteIntent} with broadcast receivers.
 */
public class NotificationIntentInterceptor {
    private static final String TAG = "IntentInterceptor";
    private static final String EXTRA_PENDING_INTENT =
            "notifications.NotificationIntentInterceptor.EXTRA_PENDING_INTENT";
    private static final String EXTRA_INTENT_TYPE =
            "notifications.NotificationIntentInterceptor.EXTRA_INTENT_TYPE";
    private static final String EXTRA_NOTIFICATION_TYPE =
            "notifications.NotificationIntentInterceptor.EXTRA_NOTIFICATION_TYPE";
    private static final String EXTRA_ACTION_TYPE =
            "notifications.NotificationIntentInterceptor.EXTRA_ACTION_TYPE";

    /**
     * Enum that defines type of notification intent.
     */
    @IntDef({IntentType.UNKNOWN, IntentType.CONTENT_INTENT, IntentType.ACTION_INTENT,
            IntentType.DELETE_INTENT})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IntentType {
        int UNKNOWN = -1;
        int CONTENT_INTENT = 0;
        int ACTION_INTENT = 1;
        int DELETE_INTENT = 2;
    }

    /**
     * Receives the event when the user taps on the notification body, notification action, or
     * dismiss notification.
     * {@link Notification#contentIntent}, {@link Notification#deleteIntent}
     * {@link Notification.Action#actionIntent} will be delivered to this broadcast receiver.
     */
    public static final class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            @IntentType
            int intentType = intent.getIntExtra(EXTRA_INTENT_TYPE, IntentType.UNKNOWN);
            @NotificationUmaTracker.SystemNotificationType
            int notificationType = intent.getIntExtra(
                    EXTRA_NOTIFICATION_TYPE, NotificationUmaTracker.SystemNotificationType.UNKNOWN);

            switch (intentType) {
                case IntentType.UNKNOWN:
                    break;
                case IntentType.CONTENT_INTENT:
                    NotificationUmaTracker.getInstance().onNotificationContentClick(
                            notificationType);
                    break;
                case IntentType.DELETE_INTENT:
                    NotificationUmaTracker.getInstance().onNotificationDismiss(notificationType);
                    break;
                case IntentType.ACTION_INTENT:
                    int actionType = intent.getIntExtra(
                            EXTRA_ACTION_TYPE, NotificationUmaTracker.ActionType.UNKNOWN);
                    NotificationUmaTracker.getInstance().onNotificationActionClick(actionType);
                    break;
            }

            forwardPendingIntent(intent);
        }
    }

    private NotificationIntentInterceptor() {}

    /**
     * Wraps the notification {@link PendingIntent} into another PendingIntent, to intercept clicks
     * and dismiss events for metrics purpose.
     * @param intentType The type of the pending intent to intercept.
     * @param intentId The unique ID of the {@link PendingIntent}, used to distinguish action
     *                 intents.
     * @param metadata The metadata including notification id, tag, type, etc.
     * @param pendingIntentProvider Provides the {@link PendingIntent} to launch Chrome.
     *
     */
    public static PendingIntent createInterceptPendingIntent(@IntentType int intentType,
            int intentId, NotificationMetadata metadata,
            @Nullable PendingIntentProvider pendingIntentProvider) {
        PendingIntent pendingIntent = null;
        int flags = 0;
        if (pendingIntentProvider != null) {
            pendingIntent = pendingIntentProvider.getPendingIntent();
            flags = pendingIntentProvider.getFlags();
        }
        Context applicationContext = ContextUtils.getApplicationContext();
        Intent intent = new Intent(applicationContext, Receiver.class);
        intent.putExtra(EXTRA_PENDING_INTENT, pendingIntent);
        intent.putExtra(EXTRA_INTENT_TYPE, intentType);
        intent.putExtra(EXTRA_NOTIFICATION_TYPE, metadata.type);
        if (intentType == IntentType.ACTION_INTENT) {
            intent.putExtra(EXTRA_ACTION_TYPE, intentId);
        }

        // This flag ensures the broadcast is delivered with foreground priority to speed up the
        // broadcast delivery.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);
        }
        // Use request code to distinguish different PendingIntents on Android.
        int requestCode = computeHashCode(metadata, intentType, intentId);
        return PendingIntent.getBroadcast(applicationContext, requestCode, intent, flags);
    }

    /**
     * Get the default delete PendingIntent used to track the notification metrics.
     * @param metadata The metadata including notification id, tag, type, etc.
     * @return The {@link PendingIntent} triggered when the user dismiss the notification.
     */
    public static PendingIntent getDefaultDeletePendingIntent(NotificationMetadata metadata) {
        return NotificationIntentInterceptor.createInterceptPendingIntent(
                NotificationIntentInterceptor.IntentType.DELETE_INTENT, 0 /* intentId */, metadata,
                null /* pendingIntentProvider */);
    }

    // Launches the notification's pending intent, which will perform Chrome feature related tasks.
    private static void forwardPendingIntent(Intent intent) {
        if (intent == null) {
            Log.e(TAG, "Intent to forward is null.");
            return;
        }

        PendingIntent pendingIntent =
                intent.getParcelableExtra(EXTRA_PENDING_INTENT);
        if (pendingIntent == null) {
            Log.d(TAG, "The notification's PendingIntent is null.");
            return;
        }

        try {
            pendingIntent.send();
        } catch (PendingIntent.CanceledException e) {
            Log.e(TAG, "The PendingIntent to fire is canceled.");
            e.printStackTrace();
        }
    }

    /**
     * Computes an unique hash code to identify the intercept {@link PendingIntent} that wraps the
     * notification's {@link PendingIntent}.
     * @param metadata Notification metadata including notification id, tag, etc.
     * @param intentType The type of the {@link PendingIntent}.
     * @param intentId The unique ID of the {@link PendingIntent}, used to distinguish action
     *                 intents.
     * @return The hashcode for the intercept {@link PendingIntent}.
     */
    private static int computeHashCode(
            NotificationMetadata metadata, @IntentType int intentType, int intentId) {
        assert metadata != null;
        int hashcode = metadata.type;
        hashcode = hashcode * 31 + intentType;
        hashcode = hashcode * 31 + intentId;
        hashcode = hashcode * 31 + (metadata.tag == null ? 0 : metadata.tag.hashCode());
        hashcode = hashcode * 31 + metadata.id;
        return hashcode;
    }
}
