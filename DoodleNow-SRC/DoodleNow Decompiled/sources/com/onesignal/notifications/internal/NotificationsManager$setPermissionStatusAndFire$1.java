package com.onesignal.notifications.internal;

import com.onesignal.notifications.IPermissionObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/IPermissionObserver;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationsManager.kt */
final class NotificationsManager$setPermissionStatusAndFire$1 extends Lambda implements Function1<IPermissionObserver, Unit> {
    final /* synthetic */ boolean $isEnabled;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationsManager$setPermissionStatusAndFire$1(boolean z) {
        super(1);
        this.$isEnabled = z;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IPermissionObserver) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(IPermissionObserver iPermissionObserver) {
        Intrinsics.checkNotNullParameter(iPermissionObserver, "it");
        iPermissionObserver.onNotificationPermissionChange(this.$isEnabled);
    }
}
