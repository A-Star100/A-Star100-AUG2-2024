package com.onesignal.common.events;

import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0000H@"}, d2 = {"THandler", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.common.events.EventProducer$fireOnMain$1", f = "EventProducer.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventProducer.kt */
final class EventProducer$fireOnMain$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<THandler, Unit> $callback;
    int label;
    final /* synthetic */ EventProducer<THandler> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventProducer$fireOnMain$1(EventProducer<THandler> eventProducer, Function1<? super THandler, Unit> function1, Continuation<? super EventProducer$fireOnMain$1> continuation) {
        super(1, continuation);
        this.this$0 = eventProducer;
        this.$callback = function1;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new EventProducer$fireOnMain$1(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((EventProducer$fireOnMain$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        List<Object> list;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List access$getSubscribers$p = this.this$0.subscribers;
            EventProducer<THandler> eventProducer = this.this$0;
            synchronized (access$getSubscribers$p) {
                list = CollectionsKt.toList(eventProducer.subscribers);
            }
            for (Object invoke : list) {
                this.$callback.invoke(invoke);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
