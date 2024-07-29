package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import com.onesignal.inAppMessages.internal.InAppMessage;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer", f = "InAppDisplayer.kt", i = {}, l = {145}, m = "initInAppMessage", n = {}, s = {})
/* compiled from: InAppDisplayer.kt */
final class InAppDisplayer$initInAppMessage$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppDisplayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppDisplayer$initInAppMessage$1(InAppDisplayer inAppDisplayer, Continuation<? super InAppDisplayer$initInAppMessage$1> continuation) {
        super(continuation);
        this.this$0 = inAppDisplayer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initInAppMessage((Activity) null, (InAppMessage) null, (InAppMessageContent) null, this);
    }
}
