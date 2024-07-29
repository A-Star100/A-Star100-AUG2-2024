package com.onesignal.notifications.bridges;

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
@DebugMetadata(c = "com.onesignal.notifications.bridges.OneSignalHmsEventBridge$onNewToken$1", f = "OneSignalHmsEventBridge.kt", i = {}, l = {43}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: OneSignalHmsEventBridge.kt */
final class OneSignalHmsEventBridge$onNewToken$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<IPushRegistratorCallback> $registerer;
    final /* synthetic */ String $token;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OneSignalHmsEventBridge$onNewToken$1(Ref.ObjectRef<IPushRegistratorCallback> objectRef, String str, Continuation<? super OneSignalHmsEventBridge$onNewToken$1> continuation) {
        super(1, continuation);
        this.$registerer = objectRef;
        this.$token = str;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new OneSignalHmsEventBridge$onNewToken$1(this.$registerer, this.$token, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((OneSignalHmsEventBridge$onNewToken$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (((IPushRegistratorCallback) this.$registerer.element).fireCallback(this.$token, this) == coroutine_suspended) {
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
