package com.onesignal.notifications.internal.generation.impl;

import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.generation.impl.NotificationGenerationProcessor", f = "NotificationGenerationProcessor.kt", i = {0, 0}, l = {173, 191, 196}, m = "processHandlerResponse", n = {"this", "notificationJob"}, s = {"L$0", "L$1"})
/* compiled from: NotificationGenerationProcessor.kt */
final class NotificationGenerationProcessor$processHandlerResponse$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationGenerationProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationGenerationProcessor$processHandlerResponse$1(NotificationGenerationProcessor notificationGenerationProcessor, Continuation<? super NotificationGenerationProcessor$processHandlerResponse$1> continuation) {
        super(continuation);
        this.this$0 = notificationGenerationProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.processHandlerResponse((NotificationGenerationJob) null, false, false, this);
    }
}
