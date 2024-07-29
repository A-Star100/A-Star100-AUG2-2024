package com.onesignal.session.internal.session.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.session.impl.SessionListener$onSessionEnded$1", f = "SessionListener.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SessionListener.kt */
final class SessionListener$onSessionEnded$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ long $durationInSeconds;
    int label;
    final /* synthetic */ SessionListener this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionListener$onSessionEnded$1(SessionListener sessionListener, long j, Continuation<? super SessionListener$onSessionEnded$1> continuation) {
        super(1, continuation);
        this.this$0 = sessionListener;
        this.$durationInSeconds = j;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SessionListener$onSessionEnded$1(this.this$0, this.$durationInSeconds, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SessionListener$onSessionEnded$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0._outcomeEventsController.sendSessionEndOutcomeEvent(this.$durationInSeconds, this) == coroutine_suspended) {
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
