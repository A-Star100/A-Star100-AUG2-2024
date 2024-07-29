package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", i = {0, 1, 1, 1, 2, 2}, l = {353, 894, 383, 390, 393}, m = "attemptToShowInAppMessage", n = {"this", "this", "messageToDisplay", "$this$withLock_u24default$iv", "this", "messageToDisplay"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0", "L$1"})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$attemptToShowInAppMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$attemptToShowInAppMessage$1(InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$attemptToShowInAppMessage$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagesManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.attemptToShowInAppMessage(this);
    }
}
