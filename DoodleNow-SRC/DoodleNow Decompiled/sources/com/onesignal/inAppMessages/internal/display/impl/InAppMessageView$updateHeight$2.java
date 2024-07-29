package com.onesignal.inAppMessages.internal.display.impl;

import android.view.ViewGroup;
import android.webkit.WebView;
import com.onesignal.debug.internal.logging.Logging;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$updateHeight$2", f = "InAppMessageView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessageView.kt */
final class InAppMessageView$updateHeight$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $pageHeight;
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageView$updateHeight$2(InAppMessageView inAppMessageView, int i, Continuation<? super InAppMessageView$updateHeight$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppMessageView;
        this.$pageHeight = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppMessageView$updateHeight$2(this.this$0, this.$pageHeight, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppMessageView$updateHeight$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.webView == null) {
                Logging.warn$default("WebView height update skipped, new height will be used once it is displayed.", (Throwable) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            WebView access$getWebView$p = this.this$0.webView;
            Intrinsics.checkNotNull(access$getWebView$p);
            ViewGroup.LayoutParams layoutParams = access$getWebView$p.getLayoutParams();
            if (layoutParams == null) {
                Logging.warn$default("WebView height update skipped because of null layoutParams, new height will be used once it is displayed.", (Throwable) null, 2, (Object) null);
                return Unit.INSTANCE;
            }
            layoutParams.height = this.$pageHeight;
            WebView access$getWebView$p2 = this.this$0.webView;
            Intrinsics.checkNotNull(access$getWebView$p2);
            access$getWebView$p2.setLayoutParams(layoutParams);
            if (this.this$0.draggableRelativeLayout != null) {
                DraggableRelativeLayout access$getDraggableRelativeLayout$p = this.this$0.draggableRelativeLayout;
                Intrinsics.checkNotNull(access$getDraggableRelativeLayout$p);
                InAppMessageView inAppMessageView = this.this$0;
                access$getDraggableRelativeLayout$p.setParams(inAppMessageView.createDraggableLayoutParams(this.$pageHeight, inAppMessageView.getDisplayPosition(), this.this$0.disableDragDismiss));
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
