package com.onesignal.inAppMessages.internal.display.impl;

import android.webkit.ValueCallback;
import com.onesignal.common.ViewUtils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.WebViewManager$updateSafeAreaInsets$2", f = "WebViewManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: WebViewManager.kt */
final class WebViewManager$updateSafeAreaInsets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ WebViewManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WebViewManager$updateSafeAreaInsets$2(WebViewManager webViewManager, Continuation<? super WebViewManager$updateSafeAreaInsets$2> continuation) {
        super(2, continuation);
        this.this$0 = webViewManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewManager$updateSafeAreaInsets$2(this.this$0, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewManager$updateSafeAreaInsets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            int[] cutoutAndStatusBarInsets = ViewUtils.INSTANCE.getCutoutAndStatusBarInsets(this.this$0.activity);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(WebViewManager.SAFE_AREA_JS_OBJECT, Arrays.copyOf(new Object[]{Boxing.boxInt(cutoutAndStatusBarInsets[0]), Boxing.boxInt(cutoutAndStatusBarInsets[1]), Boxing.boxInt(cutoutAndStatusBarInsets[2]), Boxing.boxInt(cutoutAndStatusBarInsets[3])}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format(WebViewManager.SET_SAFE_AREA_INSETS_JS_FUNCTION, Arrays.copyOf(new Object[]{format}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            OSWebView access$getWebView$p = this.this$0.webView;
            Intrinsics.checkNotNull(access$getWebView$p);
            access$getWebView$p.evaluateJavascript(format2, (ValueCallback) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
