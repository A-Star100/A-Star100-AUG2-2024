package com.onesignal.common.events;

import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"THandler", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.common.events.EventProducer$suspendingFireOnMain$2", f = "EventProducer.kt", i = {}, l = {93}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: EventProducer.kt */
final class EventProducer$suspendingFireOnMain$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<THandler, Continuation<? super Unit>, Object> $callback;
    Object L$0;
    int label;
    final /* synthetic */ EventProducer<THandler> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EventProducer$suspendingFireOnMain$2(EventProducer<THandler> eventProducer, Function2<? super THandler, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super EventProducer$suspendingFireOnMain$2> continuation) {
        super(2, continuation);
        this.this$0 = eventProducer;
        this.$callback = function2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EventProducer$suspendingFireOnMain$2(this.this$0, this.$callback, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EventProducer$suspendingFireOnMain$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Iterator it;
        List list;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            List access$getSubscribers$p = this.this$0.subscribers;
            EventProducer<THandler> eventProducer = this.this$0;
            synchronized (access$getSubscribers$p) {
                list = CollectionsKt.toList(eventProducer.subscribers);
            }
            it = list.iterator();
        } else if (i == 1) {
            it = (Iterator) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        while (it.hasNext()) {
            Object next = it.next();
            Function2<THandler, Continuation<? super Unit>, Object> function2 = this.$callback;
            this.L$0 = it;
            this.label = 1;
            if (function2.invoke(next, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return Unit.INSTANCE;
    }
}
