package com.onesignal.inAppMessages.internal.preview;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.inAppMessages.internal.preview.InAppMessagePreviewHandler", f = "InAppMessagePreviewHandler.kt", i = {0, 0, 1}, l = {60, 63}, m = "canOpenNotification", n = {"this", "previewUUID", "this"}, s = {"L$0", "L$1", "L$0"})
/* compiled from: InAppMessagePreviewHandler.kt */
final class InAppMessagePreviewHandler$canOpenNotification$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ InAppMessagePreviewHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    InAppMessagePreviewHandler$canOpenNotification$1(InAppMessagePreviewHandler inAppMessagePreviewHandler, Continuation<? super InAppMessagePreviewHandler$canOpenNotification$1> continuation) {
        super(continuation);
        this.this$0 = inAppMessagePreviewHandler;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.canOpenNotification((Activity) null, (JSONObject) null, this);
    }
}
