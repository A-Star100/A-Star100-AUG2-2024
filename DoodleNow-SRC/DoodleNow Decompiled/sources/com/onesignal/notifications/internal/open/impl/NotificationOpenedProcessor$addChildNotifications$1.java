package com.onesignal.notifications.internal.open.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONArray;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessor", f = "NotificationOpenedProcessor.kt", i = {0}, l = {179}, m = "addChildNotifications", n = {"dataArray"}, s = {"L$0"})
/* compiled from: NotificationOpenedProcessor.kt */
final class NotificationOpenedProcessor$addChildNotifications$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationOpenedProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationOpenedProcessor$addChildNotifications$1(NotificationOpenedProcessor notificationOpenedProcessor, Continuation<? super NotificationOpenedProcessor$addChildNotifications$1> continuation) {
        super(continuation);
        this.this$0 = notificationOpenedProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addChildNotifications((JSONArray) null, (String) null, this);
    }
}
