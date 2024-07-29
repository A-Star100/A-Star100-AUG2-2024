package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.DraggableRelativeLayout;
import com.onesignal.inAppMessages.internal.display.impl.WebViewManager;
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
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppMessageView$showDraggableView$2", f = "InAppMessageView.kt", i = {}, l = {263}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppMessageView.kt */
final class InAppMessageView$showDraggableView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewManager.Position $displayLocation;
    final /* synthetic */ RelativeLayout.LayoutParams $draggableRelativeLayoutParams;
    final /* synthetic */ RelativeLayout.LayoutParams $relativeLayoutParams;
    final /* synthetic */ DraggableRelativeLayout.Params $webViewLayoutParams;
    int label;
    final /* synthetic */ InAppMessageView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessageView$showDraggableView$2(InAppMessageView inAppMessageView, RelativeLayout.LayoutParams layoutParams, RelativeLayout.LayoutParams layoutParams2, DraggableRelativeLayout.Params params, WebViewManager.Position position, Continuation<? super InAppMessageView$showDraggableView$2> continuation) {
        super(2, continuation);
        this.this$0 = inAppMessageView;
        this.$relativeLayoutParams = layoutParams;
        this.$draggableRelativeLayoutParams = layoutParams2;
        this.$webViewLayoutParams = params;
        this.$displayLocation = position;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppMessageView$showDraggableView$2(this.this$0, this.$relativeLayoutParams, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams, this.$displayLocation, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppMessageView$showDraggableView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.this$0.webView == null) {
                return Unit.INSTANCE;
            }
            WebView access$getWebView$p = this.this$0.webView;
            Intrinsics.checkNotNull(access$getWebView$p);
            access$getWebView$p.setLayoutParams(this.$relativeLayoutParams);
            InAppMessageView inAppMessageView = this.this$0;
            Activity access$getCurrentActivity$p = inAppMessageView.currentActivity;
            Intrinsics.checkNotNull(access$getCurrentActivity$p);
            inAppMessageView.setUpDraggableLayout(access$getCurrentActivity$p, this.$draggableRelativeLayoutParams, this.$webViewLayoutParams);
            InAppMessageView inAppMessageView2 = this.this$0;
            Activity access$getCurrentActivity$p2 = inAppMessageView2.currentActivity;
            Intrinsics.checkNotNull(access$getCurrentActivity$p2);
            inAppMessageView2.setUpParentRelativeLayout(access$getCurrentActivity$p2);
            InAppMessageView inAppMessageView3 = this.this$0;
            RelativeLayout access$getParentRelativeLayout$p = inAppMessageView3.parentRelativeLayout;
            Intrinsics.checkNotNull(access$getParentRelativeLayout$p);
            inAppMessageView3.createPopupWindow(access$getParentRelativeLayout$p);
            if (this.this$0.messageController != null) {
                InAppMessageView inAppMessageView4 = this.this$0;
                WebViewManager.Position position = this.$displayLocation;
                DraggableRelativeLayout access$getDraggableRelativeLayout$p = inAppMessageView4.draggableRelativeLayout;
                Intrinsics.checkNotNull(access$getDraggableRelativeLayout$p);
                RelativeLayout access$getParentRelativeLayout$p2 = this.this$0.parentRelativeLayout;
                Intrinsics.checkNotNull(access$getParentRelativeLayout$p2);
                inAppMessageView4.animateInAppMessage(position, access$getDraggableRelativeLayout$p, access$getParentRelativeLayout$p2);
            }
            this.label = 1;
            if (this.this$0.startDismissTimerIfNeeded(this) == coroutine_suspended) {
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
