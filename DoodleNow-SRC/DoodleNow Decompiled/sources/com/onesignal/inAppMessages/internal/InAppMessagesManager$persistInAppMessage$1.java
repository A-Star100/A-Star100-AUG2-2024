package com.onesignal.inAppMessages.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.InAppMessagesManager", f = "InAppMessagesManager.kt", i = {0, 0}, l = {474}, m = "persistInAppMessage", n = {"this", "message"}, s = {"L$0", "L$1"})
/* compiled from: InAppMessagesManager.kt */
final class InAppMessagesManager$persistInAppMessage$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagesManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagesManager$persistInAppMessage$1(InAppMessagesManager inAppMessagesManager, Continuation<? super InAppMessagesManager$persistInAppMessage$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagesManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.persistInAppMessage((InAppMessage) null, this);
    }
}
