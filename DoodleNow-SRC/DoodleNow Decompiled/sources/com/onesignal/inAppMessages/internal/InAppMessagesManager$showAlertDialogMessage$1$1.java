package com.onesignal.inAppMessages.internal;

import com.onesignal.inAppMessages.internal.prompt.impl.InAppMessagePrompt;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$showAlertDialogMessage$1$1", f = "InAppMessagesManager.kt", i = {}, l = {880}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$showAlertDialogMessage$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessage $inAppMessage;
    final /* synthetic */ List<InAppMessagePrompt> $prompts;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$showAlertDialogMessage$1$1(InAppMessagesManager inAppMessagesManager, InAppMessage inAppMessage, List<? extends InAppMessagePrompt> list, Continuation<? super InAppMessagesManager$showAlertDialogMessage$1$1> continuation) {
        super(1, continuation);
        this.this$0 = inAppMessagesManager;
        this.$inAppMessage = inAppMessage;
        this.$prompts = list;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$showAlertDialogMessage$1$1(this.this$0, this.$inAppMessage, this.$prompts, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$showAlertDialogMessage$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (this.this$0.showMultiplePrompts(this.$inAppMessage, this.$prompts, this) == coroutine_suspended) {
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
