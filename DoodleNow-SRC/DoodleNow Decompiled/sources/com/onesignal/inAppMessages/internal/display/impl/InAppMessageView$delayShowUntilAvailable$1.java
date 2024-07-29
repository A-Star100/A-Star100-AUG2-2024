package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView", f = "InAppMessageView.kt", i = {1, 1}, l = {437, 441, 442}, m = "delayShowUntilAvailable", n = {"this", "currentActivity"}, s = {"L$0", "L$1"})
/* compiled from: InAppMessageView.kt */
final class InAppMessageView$delayShowUntilAvailable$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageView$delayShowUntilAvailable$1(InAppMessageView inAppMessageView, Continuation<? super InAppMessageView$delayShowUntilAvailable$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessageView;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.delayShowUntilAvailable((Activity) null, this);
    }
}
