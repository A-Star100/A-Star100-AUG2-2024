package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDismissed$1", f = "InAppMessagesManager.kt", i = {}, l = {627}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$onMessageWasDismissed$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessage $message;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$onMessageWasDismissed$1(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, Continuation<? super InAppMessagesManager$onMessageWasDismissed$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessagesManager;
        this.$message = inAppMessage;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$onMessageWasDismissed$1(this.this$0, this.$message, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$onMessageWasDismissed$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            InAppMessagesManager inAppMessagesManager = this.this$0;
            InAppMessage inAppMessage = this.$message;
            this.label = 1;
            if (InAppMessagesManager.messageWasDismissed$default(inAppMessagesManager, inAppMessage, false, this, 2, (Object) null) == coroutine_suspended) {
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
