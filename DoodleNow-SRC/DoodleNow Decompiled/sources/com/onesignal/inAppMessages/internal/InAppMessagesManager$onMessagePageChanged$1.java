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
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessagePageChanged$1", f = "InAppMessagesManager.kt", i = {}, l = {613}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$onMessagePageChanged$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessage $message;
    final /* synthetic */ InAppMessagePage $page;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$onMessagePageChanged$1(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, InAppMessagePage inAppMessagePage, Continuation<? super InAppMessagesManager$onMessagePageChanged$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessagesManager;
        this.$message = inAppMessage;
        this.$page = inAppMessagePage;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$onMessagePageChanged$1(this.this$0, this.$message, this.$page, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$onMessagePageChanged$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.fireRESTCallForPageChange(this.$message, this.$page, this) == coroutine_suspended) {
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
