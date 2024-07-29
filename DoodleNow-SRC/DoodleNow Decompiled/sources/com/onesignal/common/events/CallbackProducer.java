package com.onesignal.common.events;

import com.onesignal.common.threading.ThreadUtilsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\fJ\u001a\u0010\r\u001a\u00020\u000b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\fJ\u0017\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0010J5\u0010\u0011\u001a\u00020\u000b2\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J5\u0010\u0016\u001a\u00020\u000b2\"\u0010\u0004\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u0012\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/common/events/CallbackProducer;", "THandler", "Lcom/onesignal/common/events/ICallbackNotifier;", "()V", "callback", "Ljava/lang/Object;", "hasCallback", "", "getHasCallback", "()Z", "fire", "", "Lkotlin/Function1;", "fireOnMain", "set", "handler", "(Ljava/lang/Object;)V", "suspendingFire", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "suspendingFireOnMain", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CallbackProducer.kt */
public class CallbackProducer<THandler> implements ICallbackNotifier<THandler> {
    /* access modifiers changed from: private */
    public THandler callback;

    public boolean getHasCallback() {
        return this.callback != null;
    }

    public void set(THandler thandler) {
        this.callback = thandler;
    }

    public final void fire(Function1<? super THandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        THandler thandler = this.callback;
        if (thandler != null) {
            Intrinsics.checkNotNull(thandler);
            function1.invoke(thandler);
        }
    }

    public final void fireOnMain(Function1<? super THandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        ThreadUtilsKt.suspendifyOnMain(new CallbackProducer$fireOnMain$1(this, function1, (Continuation<? super CallbackProducer$fireOnMain$1>) null));
    }

    public final Object suspendingFire(Function2<? super THandler, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        THandler thandler = this.callback;
        if (thandler == null) {
            return Unit.INSTANCE;
        }
        Intrinsics.checkNotNull(thandler);
        Object invoke = function2.invoke(thandler, continuation);
        return invoke == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? invoke : Unit.INSTANCE;
    }

    public final Object suspendingFireOnMain(Function2<? super THandler, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super Unit> continuation) {
        if (this.callback == null) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new CallbackProducer$suspendingFireOnMain$2(function2, this, (Continuation<? super CallbackProducer$suspendingFireOnMain$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
