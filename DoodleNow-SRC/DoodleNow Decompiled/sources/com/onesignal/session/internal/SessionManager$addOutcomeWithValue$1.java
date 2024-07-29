package com.onesignal.session.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.session.internal.SessionManager$addOutcomeWithValue$1", f = "SessionManager.kt", i = {}, l = {35}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SessionManager.kt */
final class SessionManager$addOutcomeWithValue$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $name;
    final /* synthetic */ float $value;
    int label;
    final /* synthetic */ SessionManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SessionManager$addOutcomeWithValue$1(SessionManager sessionManager, String str, float f, Continuation<? super SessionManager$addOutcomeWithValue$1> continuation) {
        super(1, continuation);
        this.this$0 = sessionManager;
        this.$name = str;
        this.$value = f;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new SessionManager$addOutcomeWithValue$1(this.this$0, this.$name, this.$value, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((SessionManager$addOutcomeWithValue$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0._outcomeController.sendOutcomeEventWithValue(this.$name, this.$value, this) == coroutine_suspended) {
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
