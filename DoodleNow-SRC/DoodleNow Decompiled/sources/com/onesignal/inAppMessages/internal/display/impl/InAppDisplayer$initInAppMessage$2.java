package com.onesignal.inAppMessages.internal.display.impl;

import android.app.Activity;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.inAppMessages.internal.InAppMessageContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.display.impl.InAppDisplayer$initInAppMessage$2", f = "InAppDisplayer.kt", i = {}, l = {148}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: InAppDisplayer.kt */
final class InAppDisplayer$initInAppMessage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $base64Str;
    final /* synthetic */ InAppMessageContent $content;
    final /* synthetic */ Activity $currentActivity;
    final /* synthetic */ WebViewManager $webViewManager;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppDisplayer$initInAppMessage$2(WebViewManager webViewManager, Activity activity, String str, InAppMessageContent inAppMessageContent, Continuation<? super InAppDisplayer$initInAppMessage$2> continuation) {
        super(2, continuation);
        this.$webViewManager = webViewManager;
        this.$currentActivity = activity;
        this.$base64Str = str;
        this.$content = inAppMessageContent;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InAppDisplayer$initInAppMessage$2(this.$webViewManager, this.$currentActivity, this.$base64Str, this.$content, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InAppDisplayer$initInAppMessage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            WebViewManager webViewManager = this.$webViewManager;
            Activity activity = this.$currentActivity;
            String str = this.$base64Str;
            Intrinsics.checkNotNullExpressionValue(str, "base64Str");
            this.label = 1;
            if (webViewManager.setupWebView(activity, str, this.$content.isFullBleed(), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Exception e) {
                if (e.getMessage() != null) {
                    String message = e.getMessage();
                    Intrinsics.checkNotNull(message);
                    if (StringsKt.contains$default((CharSequence) message, (CharSequence) "No WebView installed", false, 2, (Object) null)) {
                        Logging.error("Error setting up WebView: ", e);
                    }
                }
                throw e;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
