package com.onesignal.common.events;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"THandler", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.common.events.CallbackProducer$suspendingFireOnMain$2", f = "CallbackProducer.kt", i = {}, l = {75}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: CallbackProducer.kt */
final class CallbackProducer$suspendingFireOnMain$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<THandler, Continuation<? super Unit>, Object> $callback;
    int label;
    final /* synthetic */ CallbackProducer<THandler> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CallbackProducer$suspendingFireOnMain$2(Function2<? super THandler, ? super Continuation<? super Unit>, ? extends Object> function2, CallbackProducer<THandler> callbackProducer, Continuation<? super CallbackProducer$suspendingFireOnMain$2> continuation) {
        super(2, continuation);
        this.$callback = function2;
        this.this$0 = callbackProducer;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CallbackProducer$suspendingFireOnMain$2(this.$callback, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CallbackProducer$suspendingFireOnMain$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Function2<THandler, Continuation<? super Unit>, Object> function2 = this.$callback;
            Object access$getCallback$p = this.this$0.callback;
            Intrinsics.checkNotNull(access$getCallback$p);
            this.label = 1;
            if (function2.invoke(access$getCallback$p, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
