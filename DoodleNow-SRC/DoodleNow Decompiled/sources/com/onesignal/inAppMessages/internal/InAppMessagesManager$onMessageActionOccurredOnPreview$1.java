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
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnPreview$1", f = "InAppMessagesManager.kt", i = {}, l = {582, 583}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$onMessageActionOccurredOnPreview$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessageClickResult $action;
    final /* synthetic */ InAppMessage $message;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$onMessageActionOccurredOnPreview$1(InAppMessageClickResult inAppMessageClickResult, InAppMessage inAppMessage, InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$onMessageActionOccurredOnPreview$1> continuation) {
        super(1, continuation);
        this.$action = inAppMessageClickResult;
        this.$message = inAppMessage;
        this.this$0 = inAppMessagesManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$onMessageActionOccurredOnPreview$1(this.$action, this.$message, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$onMessageActionOccurredOnPreview$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.$action.setFirstClick(this.$message.takeActionAsUnique());
            this.label = 1;
            if (this.this$0.firePublicClickHandler(this.$message, this.$action, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            this.this$0.fireClickAction(this.$action);
            this.this$0.logInAppMessagePreviewActions(this.$action);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.label = 2;
        if (this.this$0.beginProcessingPrompts(this.$message, this.$action.getPrompts(), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0.fireClickAction(this.$action);
        this.this$0.logInAppMessagePreviewActions(this.$action);
        return Unit.INSTANCE;
    }
}
