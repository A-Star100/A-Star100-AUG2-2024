package com.onesignal.notifications.internal.lifecycle.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.lifecycle.impl.NotificationLifecycleService", f = "NotificationLifecycleService.kt", i = {0}, l = {78}, m = "canReceiveNotification", n = {"canReceive"}, s = {"L$0"})
/* compiled from: NotificationLifecycleService.kt */
final class NotificationLifecycleService$canReceiveNotification$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationLifecycleService this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationLifecycleService$canReceiveNotification$1(NotificationLifecycleService notificationLifecycleService, Continuation<? super NotificationLifecycleService$canReceiveNotification$1> continuation) {
        super(continuation);
        this.this$0 = notificationLifecycleService;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.canReceiveNotification((JSONObject) null, this);
    }
}
