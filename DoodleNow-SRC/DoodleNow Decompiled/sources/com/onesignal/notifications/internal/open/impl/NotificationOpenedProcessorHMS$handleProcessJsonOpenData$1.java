package com.onesignal.notifications.internal.open.impl;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.json.JSONObject;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.open.impl.NotificationOpenedProcessorHMS", f = "NotificationOpenedProcessorHMS.kt", i = {0, 0, 0}, l = {62, 66}, m = "handleProcessJsonOpenData", n = {"this", "activity", "jsonData"}, s = {"L$0", "L$1", "L$2"})
/* compiled from: NotificationOpenedProcessorHMS.kt */
final class NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationOpenedProcessorHMS this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1(NotificationOpenedProcessorHMS notificationOpenedProcessorHMS, Continuation<? super NotificationOpenedProcessorHMS$handleProcessJsonOpenData$1> continuation) {
        super(continuation);
        this.this$0 = notificationOpenedProcessorHMS;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleProcessJsonOpenData((Activity) null, (JSONObject) null, this);
    }
}
