package com.onesignal.notifications.internal.display.impl;

import com.onesignal.notifications.internal.common.NotificationGenerationJob;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.onesignal.notifications.internal.display.impl.SummaryNotificationDisplayer", f = "SummaryNotificationDisplayer.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {267}, m = "createGrouplessSummaryNotification", n = {"this", "notificationJob", "intentGenerator", "fcmJson", "random", "group", "summaryMessage", "grouplessNotifCount", "groupAlertBehavior", "summaryNotificationId"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "I$1", "I$2"})
/* compiled from: SummaryNotificationDisplayer.kt */
final class SummaryNotificationDisplayer$createGrouplessSummaryNotification$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SummaryNotificationDisplayer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SummaryNotificationDisplayer$createGrouplessSummaryNotification$1(SummaryNotificationDisplayer summaryNotificationDisplayer, Continuation<? super SummaryNotificationDisplayer$createGrouplessSummaryNotification$1> continuation) {
        super(continuation);
        this.this$0 = summaryNotificationDisplayer;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.createGrouplessSummaryNotification((NotificationGenerationJob) null, (IntentGeneratorForAttachingToNotifications) null, 0, 0, this);
    }
}
