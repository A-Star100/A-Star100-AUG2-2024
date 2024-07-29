package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.threading.WaiterWithValue;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$2", f = "PushRegistratorHMS.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: PushRegistratorHMS.kt */
final class PushRegistratorHMS$getHMSTokenTask$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $pushToken;
    Object L$0;
    int label;
    final /* synthetic */ PushRegistratorHMS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PushRegistratorHMS$getHMSTokenTask$2(Ref.ObjectRef<String> objectRef, PushRegistratorHMS pushRegistratorHMS, Continuation<? super PushRegistratorHMS$getHMSTokenTask$2> continuation) {
        super(2, continuation);
        this.$pushToken = objectRef;
        this.this$0 = pushRegistratorHMS;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PushRegistratorHMS$getHMSTokenTask$2(this.$pushToken, this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PushRegistratorHMS$getHMSTokenTask$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(T t) {
        Ref.ObjectRef<String> objectRef;
        T t2;
        Ref.ObjectRef<String> objectRef2;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            objectRef = this.$pushToken;
            WaiterWithValue access$getWaiter$p = this.this$0.waiter;
            if (access$getWaiter$p != null) {
                this.L$0 = objectRef;
                this.label = 1;
                T waitForWake = access$getWaiter$p.waitForWake(this);
                if (waitForWake == coroutine_suspended) {
                    return coroutine_suspended;
                }
                objectRef2 = objectRef;
                t = waitForWake;
            } else {
                t2 = null;
                objectRef.element = t2;
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        Ref.ObjectRef<String> objectRef3 = objectRef2;
        t2 = (String) t;
        objectRef = objectRef3;
        objectRef.element = t2;
        return Unit.INSTANCE;
    }
}
