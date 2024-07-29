package com.onesignal.notifications.internal.permissions.impl;

import com.onesignal.notifications.internal.permissions.INotificationPermissionChangedHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/internal/permissions/INotificationPermissionChangedHandler;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationPermissionController.kt */
final class NotificationPermissionController$permissionPromptCompleted$1 extends Lambda implements Function1<INotificationPermissionChangedHandler, Unit> {
    final /* synthetic */ boolean $enabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationPermissionController$permissionPromptCompleted$1(boolean z) {
        super(1);
        this.$enabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((INotificationPermissionChangedHandler) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(INotificationPermissionChangedHandler iNotificationPermissionChangedHandler) {
        Intrinsics.checkNotNullParameter(iNotificationPermissionChangedHandler, "it");
        iNotificationPermissionChangedHandler.onNotificationPermissionChanged(this.$enabled);
    }
}
