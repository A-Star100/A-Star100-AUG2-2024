package com.onesignal.notifications.internal.permissions.impl;

import android.app.Activity;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/onesignal/notifications/internal/permissions/impl/NotificationPermissionController$showFallbackAlertDialog$1", "Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings$Callback;", "onAccept", "", "onDecline", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationPermissionController.kt */
public final class NotificationPermissionController$showFallbackAlertDialog$1 implements AlertDialogPrepromptForAndroidSettings.Callback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ NotificationPermissionController this$0;

    NotificationPermissionController$showFallbackAlertDialog$1(NotificationPermissionController notificationPermissionController, Activity activity) {
        this.this$0 = notificationPermissionController;
        this.$activity = activity;
    }

    public void onAccept() {
        this.this$0._applicationService.addApplicationLifecycleHandler(new NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1(this.this$0));
        NavigateToAndroidSettingsForNotifications.INSTANCE.show(this.$activity);
    }

    public void onDecline() {
        this.this$0.permissionPromptCompleted(false);
    }
}
