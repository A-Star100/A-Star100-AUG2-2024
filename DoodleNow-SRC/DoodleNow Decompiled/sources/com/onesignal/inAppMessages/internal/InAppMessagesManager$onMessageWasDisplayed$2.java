package com.onesignal.inAppMessages.internal;

import com.onesignal.common.exceptions.BackendException;
import com.onesignal.core.internal.config.ConfigModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageWasDisplayed$2", f = "InAppMessagesManager.kt", i = {}, l = {560}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$onMessageWasDisplayed$2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessage $message;
    final /* synthetic */ String $variantId;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$onMessageWasDisplayed$2(InAppMessagesManager inAppMessagesManager, String str, InAppMessage inAppMessage, Continuation<? super InAppMessagesManager$onMessageWasDisplayed$2> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessagesManager;
        this.$variantId = str;
        this.$message = inAppMessage;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$onMessageWasDisplayed$2(this.this$0, this.$variantId, this.$message, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$onMessageWasDisplayed$2) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0._backend.sendIAMImpression(((ConfigModel) this.this$0._configModelStore.getModel()).getAppId(), this.this$0._subscriptionManager.getSubscriptions().getPush().getId(), this.$variantId, this.$message.getMessageId(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (BackendException unused) {
                this.this$0.impressionedMessages.remove(this.$message.getMessageId());
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.this$0._prefs.setImpressionesMessagesId(this.this$0.impressionedMessages);
        return Unit.INSTANCE;
    }
}
