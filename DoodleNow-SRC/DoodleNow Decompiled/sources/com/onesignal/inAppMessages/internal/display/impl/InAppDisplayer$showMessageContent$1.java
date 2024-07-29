package com.onesignal.inAppMessages.internal.display.impl;

import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", i = {0, 0, 0, 0, 3, 3, 3}, l = {105, 107, 109, 114, 115}, m = "showMessageContent", n = {"this", "message", "content", "currentActivity", "this", "message", "content"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2"})
/* compiled from: InAppDisplayer.kt */
final class InAppDisplayer$showMessageContent$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppDisplayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppDisplayer$showMessageContent$1(InAppDisplayer inAppDisplayer, Continuation<? super InAppDisplayer$showMessageContent$1> continuation) {
        super(continuation);
        this.this$0 = inAppDisplayer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.showMessageContent((InAppMessage) null, (InAppMessageContent) null, this);
    }
}
