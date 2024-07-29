package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnMessage$1", f = "InAppMessagesManager.kt", i = {}, l = {595, 596, 598, 600}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$onMessageActionOccurredOnMessage$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ InAppMessageClickResult $action;
    final /* synthetic */ InAppMessage $message;
    int label;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$onMessageActionOccurredOnMessage$1(InAppMessageClickResult inAppMessageClickResult, InAppMessage inAppMessage, InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$onMessageActionOccurredOnMessage$1> continuation) {
        super(1, continuation);
        this.$action = inAppMessageClickResult;
        this.$message = inAppMessage;
        this.this$0 = inAppMessagesManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new InAppMessagesManager$onMessageActionOccurredOnMessage$1(this.$action, this.$message, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((InAppMessagesManager$onMessageActionOccurredOnMessage$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r8.label
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L_0x002d
            if (r1 == r5) goto L_0x0029
            if (r1 == r4) goto L_0x0025
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x009d
        L_0x0019:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L_0x0021:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x007c
        L_0x0025:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0063
        L_0x0029:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x004d
        L_0x002d:
            kotlin.ResultKt.throwOnFailure(r9)
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r9 = r8.$action
            com.onesignal.inAppMessages.internal.InAppMessage r1 = r8.$message
            boolean r1 = r1.takeActionAsUnique()
            r9.setFirstClick(r1)
            com.onesignal.inAppMessages.internal.InAppMessagesManager r9 = r8.this$0
            com.onesignal.inAppMessages.internal.InAppMessage r1 = r8.$message
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r6 = r8.$action
            r7 = r8
            kotlin.coroutines.Continuation r7 = (kotlin.coroutines.Continuation) r7
            r8.label = r5
            java.lang.Object r9 = r9.firePublicClickHandler(r1, r6, r7)
            if (r9 != r0) goto L_0x004d
            return r0
        L_0x004d:
            com.onesignal.inAppMessages.internal.InAppMessagesManager r9 = r8.this$0
            com.onesignal.inAppMessages.internal.InAppMessage r1 = r8.$message
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r5 = r8.$action
            java.util.List r5 = r5.getPrompts()
            r6 = r8
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r8.label = r4
            java.lang.Object r9 = r9.beginProcessingPrompts(r1, r5, r6)
            if (r9 != r0) goto L_0x0063
            return r0
        L_0x0063:
            com.onesignal.inAppMessages.internal.InAppMessagesManager r9 = r8.this$0
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r1 = r8.$action
            r9.fireClickAction(r1)
            com.onesignal.inAppMessages.internal.InAppMessagesManager r9 = r8.this$0
            com.onesignal.inAppMessages.internal.InAppMessage r1 = r8.$message
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r4 = r8.$action
            r5 = r8
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r8.label = r3
            java.lang.Object r9 = r9.fireRESTCallForClick(r1, r4, r5)
            if (r9 != r0) goto L_0x007c
            return r0
        L_0x007c:
            com.onesignal.inAppMessages.internal.InAppMessagesManager r9 = r8.this$0
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r1 = r8.$action
            r9.fireTagCallForClick(r1)
            com.onesignal.inAppMessages.internal.InAppMessagesManager r9 = r8.this$0
            com.onesignal.inAppMessages.internal.InAppMessage r1 = r8.$message
            java.lang.String r1 = r1.getMessageId()
            com.onesignal.inAppMessages.internal.InAppMessageClickResult r3 = r8.$action
            java.util.List r3 = r3.getOutcomes()
            r4 = r8
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r8.label = r2
            java.lang.Object r9 = r9.fireOutcomesForClick(r1, r3, r4)
            if (r9 != r0) goto L_0x009d
            return r0
        L_0x009d:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.inAppMessages.internal.InAppMessagesManager$onMessageActionOccurredOnMessage$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
