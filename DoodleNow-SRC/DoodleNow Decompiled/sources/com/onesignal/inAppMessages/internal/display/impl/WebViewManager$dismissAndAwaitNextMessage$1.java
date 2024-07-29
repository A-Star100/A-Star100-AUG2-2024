package com.onesignal.inAppMessages.internal.display.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager", f = "WebViewManager.kt", i = {0}, l = {419}, m = "dismissAndAwaitNextMessage", n = {"this"}, s = {"L$0"})
/* compiled from: WebViewManager.kt */
final class WebViewManager$dismissAndAwaitNextMessage$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebViewManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewManager$dismissAndAwaitNextMessage$1(WebViewManager webViewManager, Continuation<? super WebViewManager$dismissAndAwaitNextMessage$1> continuation) {
        super(continuation);
        this.this$0 = webViewManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.dismissAndAwaitNextMessage(this);
    }
}
