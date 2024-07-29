package com.onesignal.notifications.internal.summary.impl;

import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.time.ITime;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import com.onesignal.notifications.internal.summary.INotificationSummaryManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0019\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ!\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0016H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/onesignal/notifications/internal/summary/impl/NotificationSummaryManager;", "Lcom/onesignal/notifications/internal/summary/INotificationSummaryManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_summaryNotificationDisplayer", "Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_notificationRestoreProcessor", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;", "_time", "Lcom/onesignal/core/internal/time/ITime;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/display/ISummaryNotificationDisplayer;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;Lcom/onesignal/core/internal/time/ITime;)V", "clearNotificationOnSummaryClick", "", "group", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "internalUpdateSummaryNotificationAfterChildRemoved", "dismissed", "", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "restoreSummary", "updatePossibleDependentSummaryOnDismiss", "androidNotificationId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSummaryNotificationAfterChildRemoved", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationSummaryManager.kt */
public final class NotificationSummaryManager implements INotificationSummaryManager {
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final INotificationRepository _dataController;
    private final INotificationRestoreProcessor _notificationRestoreProcessor;
    private final ISummaryNotificationDisplayer _summaryNotificationDisplayer;
    private final ITime _time;

    public NotificationSummaryManager(IApplicationService iApplicationService, INotificationRepository iNotificationRepository, ISummaryNotificationDisplayer iSummaryNotificationDisplayer, ConfigModelStore configModelStore, INotificationRestoreProcessor iNotificationRestoreProcessor, ITime iTime) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_dataController");
        Intrinsics.checkNotNullParameter(iSummaryNotificationDisplayer, "_summaryNotificationDisplayer");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iNotificationRestoreProcessor, "_notificationRestoreProcessor");
        Intrinsics.checkNotNullParameter(iTime, "_time");
        this._applicationService = iApplicationService;
        this._dataController = iNotificationRepository;
        this._summaryNotificationDisplayer = iSummaryNotificationDisplayer;
        this._configModelStore = configModelStore;
        this._notificationRestoreProcessor = iNotificationRestoreProcessor;
        this._time = iTime;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object updatePossibleDependentSummaryOnDismiss(int r6, kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1 r0 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1 r0 = new com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$updatePossibleDependentSummaryOnDismiss$1
            r0.<init>(r5, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            java.lang.Object r6 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r6 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x004e
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r7)
            com.onesignal.notifications.internal.data.INotificationRepository r7 = r5._dataController
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r7 = r7.getGroupId(r6, r0)
            if (r7 != r1) goto L_0x004d
            return r1
        L_0x004d:
            r6 = r5
        L_0x004e:
            java.lang.String r7 = (java.lang.String) r7
            if (r7 == 0) goto L_0x0061
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.internalUpdateSummaryNotificationAfterChildRemoved(r7, r4, r0)
            if (r6 != r1) goto L_0x005e
            return r1
        L_0x005e:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0061:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.updatePossibleDependentSummaryOnDismiss(int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object updateSummaryNotificationAfterChildRemoved(String str, boolean z, Continuation<? super Unit> continuation) {
        Object internalUpdateSummaryNotificationAfterChildRemoved = internalUpdateSummaryNotificationAfterChildRemoved(str, z, continuation);
        return internalUpdateSummaryNotificationAfterChildRemoved == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? internalUpdateSummaryNotificationAfterChildRemoved : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00a3 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x012d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object internalUpdateSummaryNotificationAfterChildRemoved(java.lang.String r12, boolean r13, kotlin.coroutines.Continuation<? super kotlin.Unit> r14) {
        /*
            r11 = this;
            boolean r0 = r14 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$1
            if (r0 == 0) goto L_0x0014
            r0 = r14
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$1 r0 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r14 = r0.label
            int r14 = r14 - r2
            r0.label = r14
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$1 r0 = new com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$internalUpdateSummaryNotificationAfterChildRemoved$1
            r0.<init>(r11, r14)
        L_0x0019:
            r6 = r0
            java.lang.Object r14 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 5
            r3 = 4
            r4 = 3
            r5 = 2
            r7 = 1
            if (r1 == 0) goto L_0x0070
            if (r1 == r7) goto L_0x0061
            if (r1 == r5) goto L_0x004d
            if (r1 == r4) goto L_0x0048
            if (r1 == r3) goto L_0x0043
            if (r1 != r2) goto L_0x003b
            kotlin.ResultKt.throwOnFailure(r14)     // Catch:{ JSONException -> 0x0038 }
            goto L_0x012a
        L_0x0038:
            r12 = move-exception
            goto L_0x0127
        L_0x003b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00ef
        L_0x0048:
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00db
        L_0x004d:
            int r12 = r6.I$0
            boolean r13 = r6.Z$0
            java.lang.Object r1 = r6.L$2
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r5 = r6.L$1
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r8 = r6.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r8 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r8
            kotlin.ResultKt.throwOnFailure(r14)
            goto L_0x00a8
        L_0x0061:
            boolean r13 = r6.Z$0
            java.lang.Object r12 = r6.L$1
            java.lang.String r12 = (java.lang.String) r12
            java.lang.Object r1 = r6.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r1 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r1
            kotlin.ResultKt.throwOnFailure(r14)
            r8 = r1
            goto L_0x0085
        L_0x0070:
            kotlin.ResultKt.throwOnFailure(r14)
            com.onesignal.notifications.internal.data.INotificationRepository r14 = r11._dataController
            r6.L$0 = r11
            r6.L$1 = r12
            r6.Z$0 = r13
            r6.label = r7
            java.lang.Object r14 = r14.listNotificationsForGroup(r12, r6)
            if (r14 != r0) goto L_0x0084
            return r0
        L_0x0084:
            r8 = r11
        L_0x0085:
            r1 = r14
            java.util.List r1 = (java.util.List) r1
            r14 = r1
            java.util.Collection r14 = (java.util.Collection) r14
            int r14 = r14.size()
            com.onesignal.notifications.internal.data.INotificationRepository r9 = r8._dataController
            r6.L$0 = r8
            r6.L$1 = r12
            r6.L$2 = r1
            r6.Z$0 = r13
            r6.I$0 = r14
            r6.label = r5
            java.lang.Object r5 = r9.getAndroidIdForGroup(r12, r7, r6)
            if (r5 != r0) goto L_0x00a4
            return r0
        L_0x00a4:
            r10 = r5
            r5 = r12
            r12 = r14
            r14 = r10
        L_0x00a8:
            java.lang.Integer r14 = (java.lang.Integer) r14
            if (r14 == 0) goto L_0x012d
            int r14 = r14.intValue()
            r9 = 0
            if (r12 != 0) goto L_0x00de
            com.onesignal.notifications.internal.common.NotificationHelper r12 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.core.internal.application.IApplicationService r1 = r8._applicationService
            android.content.Context r1 = r1.getAppContext()
            android.app.NotificationManager r12 = r12.getNotificationManager(r1)
            r12.cancel(r14)
            com.onesignal.notifications.internal.data.INotificationRepository r1 = r8._dataController
            r12 = 0
            r5 = 0
            r7 = 12
            r8 = 0
            r6.L$0 = r9
            r6.L$1 = r9
            r6.L$2 = r9
            r6.label = r4
            r2 = r14
            r3 = r13
            r4 = r12
            java.lang.Object r12 = com.onesignal.notifications.internal.data.INotificationRepository.DefaultImpls.markAsConsumed$default(r1, r2, r3, r4, r5, r6, r7, r8)
            if (r12 != r0) goto L_0x00db
            return r0
        L_0x00db:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00de:
            if (r12 != r7) goto L_0x00f2
            r6.L$0 = r9
            r6.L$1 = r9
            r6.L$2 = r9
            r6.label = r3
            java.lang.Object r12 = r8.restoreSummary(r5, r6)
            if (r12 != r0) goto L_0x00ef
            return r0
        L_0x00ef:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x00f2:
            java.lang.Object r12 = kotlin.collections.CollectionsKt.first(r1)     // Catch:{ JSONException -> 0x0038 }
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r12 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r12     // Catch:{ JSONException -> 0x0038 }
            org.json.JSONObject r13 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0038 }
            java.lang.String r14 = r12.getFullData()     // Catch:{ JSONException -> 0x0038 }
            r13.<init>(r14)     // Catch:{ JSONException -> 0x0038 }
            com.onesignal.notifications.internal.common.NotificationGenerationJob r14 = new com.onesignal.notifications.internal.common.NotificationGenerationJob     // Catch:{ JSONException -> 0x0038 }
            com.onesignal.core.internal.time.ITime r1 = r8._time     // Catch:{ JSONException -> 0x0038 }
            r14.<init>((org.json.JSONObject) r13, (com.onesignal.core.internal.time.ITime) r1)     // Catch:{ JSONException -> 0x0038 }
            r14.setRestoring(r7)     // Catch:{ JSONException -> 0x0038 }
            long r12 = r12.getCreatedAt()     // Catch:{ JSONException -> 0x0038 }
            java.lang.Long r12 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r12)     // Catch:{ JSONException -> 0x0038 }
            r14.setShownTimeStamp(r12)     // Catch:{ JSONException -> 0x0038 }
            com.onesignal.notifications.internal.display.ISummaryNotificationDisplayer r12 = r8._summaryNotificationDisplayer     // Catch:{ JSONException -> 0x0038 }
            r6.L$0 = r9     // Catch:{ JSONException -> 0x0038 }
            r6.L$1 = r9     // Catch:{ JSONException -> 0x0038 }
            r6.L$2 = r9     // Catch:{ JSONException -> 0x0038 }
            r6.label = r2     // Catch:{ JSONException -> 0x0038 }
            java.lang.Object r12 = r12.updateSummaryNotification(r14, r6)     // Catch:{ JSONException -> 0x0038 }
            if (r12 != r0) goto L_0x012a
            return r0
        L_0x0127:
            r12.printStackTrace()
        L_0x012a:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x012d:
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.internalUpdateSummaryNotificationAfterChildRemoved(java.lang.String, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object restoreSummary(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1 r0 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1 r0 = new com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$restoreSummary$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0045
            if (r2 == r4) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            java.lang.Object r11 = r0.L$1
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r2 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r2
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x005e
        L_0x0035:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x003d:
            java.lang.Object r11 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r11 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x0056
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r12)
            com.onesignal.notifications.internal.data.INotificationRepository r12 = r10._dataController
            r0.L$0 = r10
            r0.label = r4
            java.lang.Object r12 = r12.listNotificationsForGroup(r11, r0)
            if (r12 != r1) goto L_0x0055
            return r1
        L_0x0055:
            r11 = r10
        L_0x0056:
            java.util.List r12 = (java.util.List) r12
            java.util.Iterator r12 = r12.iterator()
            r2 = r11
            r11 = r12
        L_0x005e:
            boolean r12 = r11.hasNext()
            if (r12 == 0) goto L_0x007e
            java.lang.Object r12 = r11.next()
            r5 = r12
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r5 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r5
            com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor r4 = r2._notificationRestoreProcessor
            r6 = 0
            r8 = 2
            r9 = 0
            r0.L$0 = r2
            r0.L$1 = r11
            r0.label = r3
            r7 = r0
            java.lang.Object r12 = com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor.DefaultImpls.processNotification$default(r4, r5, r6, r7, r8, r9)
            if (r12 != r1) goto L_0x005e
            return r1
        L_0x007e:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.restoreSummary(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object clearNotificationOnSummaryClick(java.lang.String r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
        /*
            r10 = this;
            boolean r0 = r12 instanceof com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$clearNotificationOnSummaryClick$1
            if (r0 == 0) goto L_0x0014
            r0 = r12
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$clearNotificationOnSummaryClick$1 r0 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$clearNotificationOnSummaryClick$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r12 = r0.label
            int r12 = r12 - r2
            r0.label = r12
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$clearNotificationOnSummaryClick$1 r0 = new com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager$clearNotificationOnSummaryClick$1
            r0.<init>(r10, r12)
        L_0x0019:
            java.lang.Object r12 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0056
            if (r2 == r5) goto L_0x0042
            if (r2 == r4) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00d3
        L_0x0031:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0039:
            java.lang.Object r11 = r0.L$0
            android.app.NotificationManager r11 = (android.app.NotificationManager) r11
            kotlin.ResultKt.throwOnFailure(r12)
            goto L_0x00af
        L_0x0042:
            java.lang.Object r11 = r0.L$2
            android.app.NotificationManager r11 = (android.app.NotificationManager) r11
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r6 = r0.L$0
            com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager r6 = (com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager) r6
            kotlin.ResultKt.throwOnFailure(r12)
            r9 = r12
            r12 = r11
            r11 = r2
            r2 = r9
            goto L_0x0078
        L_0x0056:
            kotlin.ResultKt.throwOnFailure(r12)
            com.onesignal.notifications.internal.common.NotificationHelper r12 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
            com.onesignal.core.internal.application.IApplicationService r2 = r10._applicationService
            android.content.Context r2 = r2.getAppContext()
            android.app.NotificationManager r12 = r12.getNotificationManager(r2)
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r10._dataController
            r0.L$0 = r10
            r0.L$1 = r11
            r0.L$2 = r12
            r0.label = r5
            r6 = 0
            java.lang.Object r2 = r2.getAndroidIdForGroup(r11, r6, r0)
            if (r2 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r6 = r10
        L_0x0078:
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x00d6
            com.onesignal.core.internal.config.ConfigModelStore r7 = r6._configModelStore
            com.onesignal.common.modeling.Model r7 = r7.getModel()
            com.onesignal.core.internal.config.ConfigModel r7 = (com.onesignal.core.internal.config.ConfigModel) r7
            boolean r7 = r7.getClearGroupOnSummaryClick()
            r8 = 0
            if (r7 == 0) goto L_0x00be
            java.lang.String r2 = "os_group_undefined"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x009b
            r11 = -718463522(0xffffffffd52d1dde, float:-1.18964869E13)
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r11)
            goto L_0x00b4
        L_0x009b:
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r6._dataController
            r0.L$0 = r12
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r4
            java.lang.Object r11 = r2.getAndroidIdForGroup(r11, r5, r0)
            if (r11 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x00af:
            java.lang.Integer r12 = (java.lang.Integer) r12
            r9 = r12
            r12 = r11
            r11 = r9
        L_0x00b4:
            if (r11 == 0) goto L_0x00d6
            int r11 = r11.intValue()
            r12.cancel(r11)
            goto L_0x00d6
        L_0x00be:
            com.onesignal.notifications.internal.data.INotificationRepository r11 = r6._dataController
            int r12 = r2.intValue()
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r8
            r0.label = r3
            java.lang.Object r11 = r11.markAsDismissed(r12, r0)
            if (r11 != r1) goto L_0x00d3
            return r1
        L_0x00d3:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00d6:
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.summary.impl.NotificationSummaryManager.clearNotificationOnSummaryClick(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
