package com.onesignal.notifications.services;

import com.onesignal.notifications.internal.registration.impl.IPushRegistratorCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.notifications.services.ADMMessageHandlerJob$onRegistrationError$1", f = "ADMMessageHandlerJob.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ADMMessageHandlerJob.kt */
final class ADMMessageHandlerJob$onRegistrationError$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<IPushRegistratorCallback> $registerer;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ADMMessageHandlerJob$onRegistrationError$1(Ref.ObjectRef<IPushRegistratorCallback> objectRef, Continuation<? super ADMMessageHandlerJob$onRegistrationError$1> continuation) {
        super(1, continuation);
        this.$registerer = objectRef;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ADMMessageHandlerJob$onRegistrationError$1(this.$registerer, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ADMMessageHandlerJob$onRegistrationError$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((IPushRegistratorCallback) this.$registerer.element).fireCallback((String) null, this) == coroutine_suspended) {
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
