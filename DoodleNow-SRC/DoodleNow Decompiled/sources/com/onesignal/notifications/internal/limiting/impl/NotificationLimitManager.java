package com.onesignal.notifications.internal.limiting.impl;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.limiting.INotificationLimitManager;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u0019\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"Lcom/onesignal/notifications/internal/limiting/impl/NotificationLimitManager;", "Lcom/onesignal/notifications/internal/limiting/INotificationLimitManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_notificationSummaryManager", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "(Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;)V", "clearOldestOverLimit", "", "notificationsToMakeRoomFor", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearOldestOverLimitStandard", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationLimitManager.kt */
public final class NotificationLimitManager implements INotificationLimitManager {
    private final IApplicationService _applicationService;
    private final INotificationRepository _dataController;
    private final INotificationSummaryManager _notificationSummaryManager;

    public NotificationLimitManager(INotificationRepository iNotificationRepository, IApplicationService iApplicationService, INotificationSummaryManager iNotificationSummaryManager) {
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_dataController");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationSummaryManager, "_notificationSummaryManager");
        this._dataController = iNotificationRepository;
        this._applicationService = iApplicationService;
        this._notificationSummaryManager = iNotificationSummaryManager;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object clearOldestOverLimit(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1 r0 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1 r0 = new com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimit$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 1
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0038
            r6 = 2
            if (r2 == r6) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            int r6 = r0.I$0
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager r2 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0053 }
            goto L_0x0067
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r7)
            r0.L$0 = r5     // Catch:{ all -> 0x0052 }
            r0.I$0 = r6     // Catch:{ all -> 0x0052 }
            r0.label = r4     // Catch:{ all -> 0x0052 }
            java.lang.Object r6 = r5.clearOldestOverLimitStandard(r6, r0)     // Catch:{ all -> 0x0052 }
            if (r6 != r1) goto L_0x0067
            return r1
        L_0x0052:
            r2 = r5
        L_0x0053:
            com.onesignal.notifications.internal.data.INotificationRepository r7 = r2._dataController
            com.onesignal.notifications.internal.limiting.INotificationLimitManager$Constants r2 = com.onesignal.notifications.internal.limiting.INotificationLimitManager.Constants.INSTANCE
            int r2 = r2.getMaxNumberOfNotifications()
            r4 = 0
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r7.clearOldestOverLimitFallback(r6, r2, r0)
            if (r6 != r1) goto L_0x0067
            return r1
        L_0x0067:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimit(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010f, code lost:
        if (r4 > 0) goto L_0x00b2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object clearOldestOverLimitStandard(int r17, kotlin.coroutines.Continuation<? super kotlin.Unit> r18) throws java.lang.Throwable {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            boolean r2 = r1 instanceof com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimitStandard$1
            if (r2 == 0) goto L_0x0018
            r2 = r1
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimitStandard$1 r2 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimitStandard$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0018
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            goto L_0x001d
        L_0x0018:
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimitStandard$1 r2 = new com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager$clearOldestOverLimitStandard$1
            r2.<init>(r0, r1)
        L_0x001d:
            java.lang.Object r1 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            java.lang.String r5 = "value"
            r6 = 2
            r7 = 1
            if (r4 == 0) goto L_0x0059
            if (r4 == r7) goto L_0x0046
            if (r4 != r6) goto L_0x003e
            int r4 = r2.I$0
            java.lang.Object r8 = r2.L$1
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r2.L$0
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager r9 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager) r9
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x0108
        L_0x003e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0046:
            int r4 = r2.I$0
            java.lang.Object r8 = r2.L$2
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.Object r9 = r2.L$1
            java.util.Iterator r9 = (java.util.Iterator) r9
            java.lang.Object r10 = r2.L$0
            com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager r10 = (com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager) r10
            kotlin.ResultKt.throwOnFailure(r1)
            goto L_0x00e3
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r1)
            com.onesignal.notifications.internal.common.NotificationHelper r1 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.core.internal.application.IApplicationService r4 = r0._applicationService
            android.content.Context r4 = r4.getAppContext()
            android.service.notification.StatusBarNotification[] r1 = r1.getActiveNotifications(r4)
            int r4 = r1.length
            com.onesignal.notifications.internal.limiting.INotificationLimitManager$Constants r8 = com.onesignal.notifications.internal.limiting.INotificationLimitManager.Constants.INSTANCE
            int r8 = r8.getMaxNumberOfNotifications()
            int r4 = r4 - r8
            int r4 = r4 + r17
            if (r4 >= r7) goto L_0x0077
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        L_0x0077:
            java.util.TreeMap r8 = new java.util.TreeMap
            r8.<init>()
            java.util.SortedMap r8 = (java.util.SortedMap) r8
            int r9 = r1.length
            r10 = 0
        L_0x0080:
            if (r10 >= r9) goto L_0x00a7
            r11 = r1[r10]
            com.onesignal.notifications.internal.common.NotificationHelper r12 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            boolean r12 = r12.isGroupSummary(r11)
            if (r12 != 0) goto L_0x00a4
            r12 = r8
            java.util.Map r12 = (java.util.Map) r12
            android.app.Notification r13 = r11.getNotification()
            long r13 = r13.when
            java.lang.Long r13 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r13)
            int r11 = r11.getId()
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            r12.put(r13, r11)
        L_0x00a4:
            int r10 = r10 + 1
            goto L_0x0080
        L_0x00a7:
            java.util.Map r8 = (java.util.Map) r8
            java.util.Set r1 = r8.entrySet()
            java.util.Iterator r1 = r1.iterator()
            r8 = r0
        L_0x00b2:
            boolean r9 = r1.hasNext()
            if (r9 == 0) goto L_0x0111
            java.lang.Object r9 = r1.next()
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9
            java.lang.Object r9 = r9.getValue()
            java.lang.Integer r9 = (java.lang.Integer) r9
            com.onesignal.notifications.internal.data.INotificationRepository r10 = r8._dataController
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            int r11 = r9.intValue()
            r2.L$0 = r8
            r2.L$1 = r1
            r2.L$2 = r9
            r2.I$0 = r4
            r2.label = r7
            java.lang.Object r10 = r10.markAsDismissed(r11, r2)
            if (r10 != r3) goto L_0x00de
            return r3
        L_0x00de:
            r15 = r9
            r9 = r1
            r1 = r10
            r10 = r8
            r8 = r15
        L_0x00e3:
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 == 0) goto L_0x010b
            com.onesignal.notifications.internal.summary.INotificationSummaryManager r1 = r10._notificationSummaryManager
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r5)
            int r8 = r8.intValue()
            r2.L$0 = r10
            r2.L$1 = r9
            r11 = 0
            r2.L$2 = r11
            r2.I$0 = r4
            r2.label = r6
            java.lang.Object r1 = r1.updatePossibleDependentSummaryOnDismiss(r8, r2)
            if (r1 != r3) goto L_0x0106
            return r3
        L_0x0106:
            r8 = r9
            r9 = r10
        L_0x0108:
            r1 = r8
            r8 = r9
            goto L_0x010d
        L_0x010b:
            r1 = r9
            r8 = r10
        L_0x010d:
            int r4 = r4 + -1
            if (r4 > 0) goto L_0x00b2
        L_0x0111:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.limiting.impl.NotificationLimitManager.clearOldestOverLimitStandard(int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
