package com.onesignal.notifications.internal.summary.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", i = {0, 1}, l = {88, 90}, m = "restoreSummary", n = {"this", "this"}, s = {"L$0", "L$0"})
/* compiled from: NotificationSummaryManager.kt */
final class NotificationSummaryManager$restoreSummary$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationSummaryManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationSummaryManager$restoreSummary$1(NotificationSummaryManager notificationSummaryManager, Continuation<? super NotificationSummaryManager$restoreSummary$1> continuation) {
        super(continuation);
        this.this$0 = notificationSummaryManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.restoreSummary((String) null, this);
    }
}
