package com.onesignal.notifications.internal.summary.impl;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager", f = "NotificationSummaryManager.kt", i = {0}, l = {25, 28}, m = "updatePossibleDependentSummaryOnDismiss", n = {"this"}, s = {"L$0"})
/* compiled from: NotificationSummaryManager.kt */
final class NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationSummaryManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1(NotificationSummaryManager notificationSummaryManager, Continuation<? super NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1> continuation) {
        super(continuation);
        this.this$0 = notificationSummaryManager;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updatePossibleDependentSummaryOnDismiss(0, this);
    }
}
