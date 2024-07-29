package com.onesignal.notifications.internal.data.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.data.impl.NotificationRepository", f = "NotificationRepository.kt", i = {0}, l = {515}, m = "getAndroidIdForGroup", n = {"recentId"}, s = {"L$0"})
/* compiled from: NotificationRepository.kt */
final class NotificationRepository$getAndroidIdForGroup$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationRepository this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationRepository$getAndroidIdForGroup$1(NotificationRepository notificationRepository, Continuation<? super NotificationRepository$getAndroidIdForGroup$1> continuation) {
        super(continuation);
        this.this$0 = notificationRepository;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getAndroidIdForGroup((String) null, false, this);
    }
}
