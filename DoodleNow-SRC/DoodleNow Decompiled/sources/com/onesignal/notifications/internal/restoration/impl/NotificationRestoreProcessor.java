package com.onesignal.notifications.internal.restoration.impl;

import android.service.notification.StatusBarNotification;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.notifications.internal.badges.IBadgeCountUpdater;
import com.onesignal.notifications.internal.common.NotificationHelper;
import com.onesignal.notifications.internal.data.INotificationRepository;
import com.onesignal.notifications.internal.generation.INotificationGenerationWorkManager;
import com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0002J\u0011\u0010\u000e\u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreProcessor;", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreProcessor;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_workManager", "Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;", "_dataController", "Lcom/onesignal/notifications/internal/data/INotificationRepository;", "_badgeCountUpdater", "Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/generation/INotificationGenerationWorkManager;Lcom/onesignal/notifications/internal/data/INotificationRepository;Lcom/onesignal/notifications/internal/badges/IBadgeCountUpdater;)V", "getVisibleNotifications", "", "", "process", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "processNotification", "notification", "Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;", "delay", "(Lcom/onesignal/notifications/internal/data/INotificationRepository$NotificationData;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationRestoreProcessor.kt */
public final class NotificationRestoreProcessor implements INotificationRestoreProcessor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DEFAULT_TTL_IF_NOT_IN_PAYLOAD = 259200;
    private static final int DELAY_BETWEEN_NOTIFICATION_RESTORES_MS = 200;
    private final IApplicationService _applicationService;
    private final IBadgeCountUpdater _badgeCountUpdater;
    private final INotificationRepository _dataController;
    private final INotificationGenerationWorkManager _workManager;

    public NotificationRestoreProcessor(IApplicationService iApplicationService, INotificationGenerationWorkManager iNotificationGenerationWorkManager, INotificationRepository iNotificationRepository, IBadgeCountUpdater iBadgeCountUpdater) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iNotificationGenerationWorkManager, "_workManager");
        Intrinsics.checkNotNullParameter(iNotificationRepository, "_dataController");
        Intrinsics.checkNotNullParameter(iBadgeCountUpdater, "_badgeCountUpdater");
        this._applicationService = iApplicationService;
        this._workManager = iNotificationGenerationWorkManager;
        this._dataController = iNotificationRepository;
        this._badgeCountUpdater = iBadgeCountUpdater;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006e A[Catch:{ all -> 0x0089 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object process(kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1
            if (r0 == 0) goto L_0x0014
            r0 = r7
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1 r0 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r7 = r0.label
            int r7 = r7 - r2
            r0.label = r7
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1 r0 = new com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor$process$1
            r0.<init>(r6, r7)
        L_0x0019:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            if (r2 == 0) goto L_0x0045
            if (r2 == r3) goto L_0x003d
            if (r2 != r4) goto L_0x0035
            java.lang.Object r2 = r0.L$1
            java.util.Iterator r2 = (java.util.Iterator) r2
            java.lang.Object r3 = r0.L$0
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor r3 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor) r3
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0089 }
            goto L_0x0068
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x003d:
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor r2 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor) r2
            kotlin.ResultKt.throwOnFailure(r7)     // Catch:{ all -> 0x0089 }
            goto L_0x0060
        L_0x0045:
            kotlin.ResultKt.throwOnFailure(r7)
            java.lang.String r7 = "Restoring notifications"
            r2 = 0
            com.onesignal.debug.internal.logging.Logging.info$default(r7, r2, r4, r2)
            java.util.List r7 = r6.getVisibleNotifications()     // Catch:{ all -> 0x0089 }
            com.onesignal.notifications.internal.data.INotificationRepository r2 = r6._dataController     // Catch:{ all -> 0x0089 }
            r0.L$0 = r6     // Catch:{ all -> 0x0089 }
            r0.label = r3     // Catch:{ all -> 0x0089 }
            java.lang.Object r7 = r2.listNotificationsForOutstanding(r7, r0)     // Catch:{ all -> 0x0089 }
            if (r7 != r1) goto L_0x005f
            return r1
        L_0x005f:
            r2 = r6
        L_0x0060:
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x0089 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x0089 }
            r3 = r2
            r2 = r7
        L_0x0068:
            boolean r7 = r2.hasNext()     // Catch:{ all -> 0x0089 }
            if (r7 == 0) goto L_0x0083
            java.lang.Object r7 = r2.next()     // Catch:{ all -> 0x0089 }
            com.onesignal.notifications.internal.data.INotificationRepository$NotificationData r7 = (com.onesignal.notifications.internal.data.INotificationRepository.NotificationData) r7     // Catch:{ all -> 0x0089 }
            r0.L$0 = r3     // Catch:{ all -> 0x0089 }
            r0.L$1 = r2     // Catch:{ all -> 0x0089 }
            r0.label = r4     // Catch:{ all -> 0x0089 }
            r5 = 200(0xc8, float:2.8E-43)
            java.lang.Object r7 = r3.processNotification(r7, r5, r0)     // Catch:{ all -> 0x0089 }
            if (r7 != r1) goto L_0x0068
            return r1
        L_0x0083:
            com.onesignal.notifications.internal.badges.IBadgeCountUpdater r7 = r3._badgeCountUpdater     // Catch:{ all -> 0x0089 }
            r7.update()     // Catch:{ all -> 0x0089 }
            goto L_0x008f
        L_0x0089:
            r7 = move-exception
            java.lang.String r0 = "Error restoring notification records! "
            com.onesignal.debug.internal.logging.Logging.error(r0, r7)
        L_0x008f:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreProcessor.process(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object processNotification(INotificationRepository.NotificationData notificationData, int i, Continuation<? super Unit> continuation) {
        this._workManager.beginEnqueueingWork(this._applicationService.getAppContext(), notificationData.getId(), notificationData.getAndroidId(), new JSONObject(notificationData.getFullData()), notificationData.getCreatedAt(), true, false);
        if (i <= 0) {
            return Unit.INSTANCE;
        }
        Object delay = DelayKt.delay((long) i, continuation);
        return delay == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? delay : Unit.INSTANCE;
    }

    private final List<Integer> getVisibleNotifications() {
        StatusBarNotification[] activeNotifications = NotificationHelper.INSTANCE.getActiveNotifications(this._applicationService.getAppContext());
        if (activeNotifications.length == 0) {
            return null;
        }
        List<Integer> arrayList = new ArrayList<>();
        for (StatusBarNotification id : activeNotifications) {
            arrayList.add(Integer.valueOf(id.getId()));
        }
        return arrayList;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreProcessor$Companion;", "", "()V", "DEFAULT_TTL_IF_NOT_IN_PAYLOAD", "", "DELAY_BETWEEN_NOTIFICATION_RESTORES_MS", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationRestoreProcessor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
