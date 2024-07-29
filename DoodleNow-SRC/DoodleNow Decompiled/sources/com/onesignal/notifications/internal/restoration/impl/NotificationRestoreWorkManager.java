package com.onesignal.notifications.internal.restoration.impl;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.WorkerParameters;
import com.onesignal.notifications.internal.restoration.INotificationRestoreWorkManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager;", "Lcom/onesignal/notifications/internal/restoration/INotificationRestoreWorkManager;", "()V", "restored", "", "beginEnqueueingWork", "", "context", "Landroid/content/Context;", "shouldDelay", "Companion", "NotificationRestoreWorker", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: NotificationRestoreWorkManager.kt */
public final class NotificationRestoreWorkManager implements INotificationRestoreWorkManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String NOTIFICATION_RESTORE_WORKER_IDENTIFIER = NotificationRestoreWorker.class.getCanonicalName();
    private boolean restored;

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        if (r5 == false) goto L_0x001d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        r5 = 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001d, code lost:
        r5 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        com.onesignal.notifications.internal.common.OSWorkManagerHelper.INSTANCE.getInstance(r4).enqueueUniqueWork(NOTIFICATION_RESTORE_WORKER_IDENTIFIER, androidx.work.ExistingWorkPolicy.KEEP, (androidx.work.OneTimeWorkRequest) ((androidx.work.OneTimeWorkRequest.Builder) new androidx.work.OneTimeWorkRequest.Builder(com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.class).setInitialDelay((long) r5, java.util.concurrent.TimeUnit.SECONDS)).build());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0041, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void beginEnqueueingWork(android.content.Context r4, boolean r5) {
        /*
            r3 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r3.restored
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            monitor-enter(r0)
            boolean r1 = r3.restored     // Catch:{ all -> 0x0042 }
            if (r1 == 0) goto L_0x0012
            monitor-exit(r0)
            return
        L_0x0012:
            r1 = 1
            r3.restored = r1     // Catch:{ all -> 0x0042 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0042 }
            monitor-exit(r0)
            if (r5 == 0) goto L_0x001d
            r5 = 15
            goto L_0x001e
        L_0x001d:
            r5 = 0
        L_0x001e:
            androidx.work.OneTimeWorkRequest$Builder r0 = new androidx.work.OneTimeWorkRequest$Builder
            java.lang.Class<com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker> r1 = com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.class
            r0.<init>(r1)
            long r1 = (long) r5
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            androidx.work.WorkRequest$Builder r5 = r0.setInitialDelay(r1, r5)
            androidx.work.OneTimeWorkRequest$Builder r5 = (androidx.work.OneTimeWorkRequest.Builder) r5
            androidx.work.WorkRequest r5 = r5.build()
            androidx.work.OneTimeWorkRequest r5 = (androidx.work.OneTimeWorkRequest) r5
            com.onesignal.notifications.internal.common.OSWorkManagerHelper r0 = com.onesignal.notifications.internal.common.OSWorkManagerHelper.INSTANCE
            androidx.work.WorkManager r4 = r0.getInstance(r4)
            java.lang.String r0 = NOTIFICATION_RESTORE_WORKER_IDENTIFIER
            androidx.work.ExistingWorkPolicy r1 = androidx.work.ExistingWorkPolicy.KEEP
            r4.enqueueUniqueWork((java.lang.String) r0, (androidx.work.ExistingWorkPolicy) r1, (androidx.work.OneTimeWorkRequest) r5)
            return
        L_0x0042:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.beginEnqueueingWork(android.content.Context, boolean):void");
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager$NotificationRestoreWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationRestoreWorkManager.kt */
    public static final class NotificationRestoreWorker extends CoroutineWorker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NotificationRestoreWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r8) {
            /*
                r7 = this;
                boolean r0 = r8 instanceof com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1
                if (r0 == 0) goto L_0x0014
                r0 = r8
                com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 r0 = (com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L_0x0019
            L_0x0014:
                com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1 r0 = new com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager$NotificationRestoreWorker$doWork$1
                r0.<init>(r7, r8)
            L_0x0019:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                java.lang.String r3 = "success()"
                r4 = 1
                if (r2 == 0) goto L_0x0034
                if (r2 != r4) goto L_0x002c
                kotlin.ResultKt.throwOnFailure(r8)
                goto L_0x0079
            L_0x002c:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r8)
                android.content.Context r8 = r7.getApplicationContext()
                java.lang.String r2 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r2)
                boolean r2 = com.onesignal.OneSignal.initWithContext(r8)
                if (r2 != 0) goto L_0x004e
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
                return r8
            L_0x004e:
                com.onesignal.notifications.internal.common.NotificationHelper r2 = com.onesignal.notifications.internal.common.NotificationHelper.INSTANCE
                r5 = 2
                r6 = 0
                boolean r8 = com.onesignal.notifications.internal.common.NotificationHelper.areNotificationsEnabled$default(r2, r8, r6, r5, r6)
                if (r8 != 0) goto L_0x0062
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.failure()
                java.lang.String r0 = "failure()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r0)
                return r8
            L_0x0062:
                com.onesignal.OneSignal r8 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r8 = r8.getServices()
                java.lang.Class<com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor> r2 = com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor.class
                java.lang.Object r8 = r8.getService(r2)
                com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor r8 = (com.onesignal.notifications.internal.restoration.INotificationRestoreProcessor) r8
                r0.label = r4
                java.lang.Object r8 = r8.process(r0)
                if (r8 != r1) goto L_0x0079
                return r1
            L_0x0079:
                androidx.work.ListenableWorker$Result r8 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r3)
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.restoration.impl.NotificationRestoreWorkManager.NotificationRestoreWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/restoration/impl/NotificationRestoreWorkManager$Companion;", "", "()V", "NOTIFICATION_RESTORE_WORKER_IDENTIFIER", "", "kotlin.jvm.PlatformType", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: NotificationRestoreWorkManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
