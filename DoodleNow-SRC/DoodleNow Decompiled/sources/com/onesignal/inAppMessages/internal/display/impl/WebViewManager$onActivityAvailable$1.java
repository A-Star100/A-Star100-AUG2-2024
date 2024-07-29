package com.onesignal.inAppMessages.internal.display.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$onActivityAvailable$1", f = "WebViewManager.kt", i = {}, l = {256, 263, 267}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WebViewManager.kt */
final class WebViewManager$onActivityAvailable$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $lastActivityName;
    int label;
    final /* synthetic */ WebViewManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewManager$onActivityAvailable$1(String str, WebViewManager webViewManager, Continuation<? super WebViewManager$onActivityAvailable$1> continuation) {
        super(1, continuation);
        this.$lastActivityName = str;
        this.this$0 = webViewManager;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new WebViewManager$onActivityAvailable$1(this.$lastActivityName, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((WebViewManager$onActivityAvailable$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$lastActivityName;
            if (str == null) {
                this.label = 1;
                if (this.this$0.showMessageView((Integer) null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (Intrinsics.areEqual((Object) str, (Object) this.this$0.currentActivityName)) {
                this.label = 3;
                if (this.this$0.calculateHeightAndShowWebViewAfterNewActivity(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (!this.this$0.closing) {
                if (this.this$0.messageView != null) {
                    InAppMessageView access$getMessageView$p = this.this$0.messageView;
                    Intrinsics.checkNotNull(access$getMessageView$p);
                    access$getMessageView$p.removeAllViews();
                }
                WebViewManager webViewManager = this.this$0;
                this.label = 2;
                if (webViewManager.showMessageView(webViewManager.lastPageHeight, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i == 1 || i == 2 || i == 3) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
