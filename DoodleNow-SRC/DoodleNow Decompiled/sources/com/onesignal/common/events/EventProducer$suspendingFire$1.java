package com.onesignal.common.events;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.common.events.EventProducer", f = "EventProducer.kt", i = {0}, l = {79}, m = "suspendingFire", n = {"callback"}, s = {"L$0"})
/* compiled from: EventProducer.kt */
final class EventProducer$suspendingFire$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EventProducer<THandler> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventProducer$suspendingFire$1(EventProducer<THandler> eventProducer, Continuation<? super EventProducer$suspendingFire$1> continuation) {
        super(continuation);
        this.this$0 = eventProducer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.suspendingFire((Function2) null, this);
    }
}
