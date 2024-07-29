package com.onesignal;

import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001e\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0016ø\u0001\u0000¢\u0006\u0002\u0010\nR\u0014\u0010\u0002\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"com/onesignal/Continue$with$1", "Lkotlin/coroutines/Continuation;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Continue.kt */
public final class Continue$with$1 implements Continuation<R> {
    final /* synthetic */ CoroutineContext $context;
    final /* synthetic */ Consumer<ContinueResult<R>> $onFinished;

    public CoroutineContext getContext() {
        return this.$context;
    }

    Continue$with$1(CoroutineContext coroutineContext, Consumer<ContinueResult<R>> consumer) {
        this.$context = coroutineContext;
        this.$onFinished = consumer;
    }

    public void resumeWith(Object obj) {
        this.$onFinished.accept(new ContinueResult(Result.m1237isSuccessimpl(obj), Result.m1236isFailureimpl(obj) ? null : obj, Result.m1233exceptionOrNullimpl(obj)));
    }
}
