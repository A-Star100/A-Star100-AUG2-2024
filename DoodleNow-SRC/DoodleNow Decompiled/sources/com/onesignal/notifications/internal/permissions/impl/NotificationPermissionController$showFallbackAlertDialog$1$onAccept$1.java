package com.onesignal.notifications.internal.permissions.impl;

import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/onesignal/notifications/internal/permissions/impl/NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1", "Lcom/onesignal/core/internal/application/ApplicationLifecycleHandlerBase;", "onFocus", "", "firedOnSubscribe", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationPermissionController.kt */
public final class NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1 extends ApplicationLifecycleHandlerBase {
    final /* synthetic */ NotificationPermissionController this$0;

    NotificationPermissionController$showFallbackAlertDialog$1$onAccept$1(NotificationPermissionController notificationPermissionController) {
        this.this$0 = notificationPermissionController;
    }

    public void onFocus(boolean z) {
        if (!z) {
            super.onFocus(false);
            this.this$0._applicationService.removeApplicationLifecycleHandler(this);
            this.this$0.permissionPromptCompleted(AndroidUtils.INSTANCE.hasPermission("android.permission.POST_NOTIFICATIONS", true, this.this$0._applicationService));
        }
    }
}
