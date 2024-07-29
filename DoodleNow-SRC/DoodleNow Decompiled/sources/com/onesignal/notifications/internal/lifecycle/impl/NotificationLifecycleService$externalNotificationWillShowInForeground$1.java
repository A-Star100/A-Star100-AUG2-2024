package com.onesignal.notifications.internal.lifecycle.impl;

import com.onesignal.notifications.INotificationLifecycleListener;
import com.onesignal.notifications.INotificationWillDisplayEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/INotificationLifecycleListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationLifecycleService.kt */
final class NotificationLifecycleService$externalNotificationWillShowInForeground$1 extends Lambda implements Function1<INotificationLifecycleListener, Unit> {
    final /* synthetic */ INotificationWillDisplayEvent $willDisplayEvent;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationLifecycleService$externalNotificationWillShowInForeground$1(INotificationWillDisplayEvent iNotificationWillDisplayEvent) {
        super(1);
        this.$willDisplayEvent = iNotificationWillDisplayEvent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((INotificationLifecycleListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(INotificationLifecycleListener iNotificationLifecycleListener) {
        Intrinsics.checkNotNullParameter(iNotificationLifecycleListener, "it");
        iNotificationLifecycleListener.onWillDisplay(this.$willDisplayEvent);
    }
}
