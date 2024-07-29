package com.onesignal.notifications.internal.lifecycle.impl;

import com.onesignal.notifications.INotificationClickListener;
import com.onesignal.notifications.internal.NotificationClickEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/onesignal/notifications/INotificationClickListener;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationLifecycleService.kt */
final class NotificationLifecycleService$addExternalClickListener$1 extends Lambda implements Function1<INotificationClickListener, Unit> {
    final /* synthetic */ NotificationClickEvent $openedResult;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationLifecycleService$addExternalClickListener$1(NotificationClickEvent notificationClickEvent) {
        super(1);
        this.$openedResult = notificationClickEvent;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((INotificationClickListener) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(INotificationClickListener iNotificationClickListener) {
        Intrinsics.checkNotNullParameter(iNotificationClickListener, "it");
        iNotificationClickListener.onClick(this.$openedResult);
    }
}
