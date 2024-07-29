package com.onesignal.notifications.internal.receivereceipt.impl;

import android.content.Context;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkerParameters;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.common.OSWorkManagerHelper;
import com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptWorkManager;
import com.onesignal.user.internal.subscriptions.ISubscriptionManager;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0002\u0012\u0013B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nXD¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager;", "Lcom/onesignal/notifications/internal/receivereceipt/IReceiveReceiptWorkManager;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_subscriptionManager", "Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/user/internal/subscriptions/ISubscriptionManager;)V", "maxDelay", "", "minDelay", "buildConstraints", "Landroidx/work/Constraints;", "enqueueReceiveReceipt", "", "notificationId", "", "Companion", "ReceiveReceiptWorker", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReceiveReceiptWorkManager.kt */
public final class ReceiveReceiptWorkManager implements IReceiveReceiptWorkManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String OS_APP_ID = "os_app_id";
    private static final String OS_NOTIFICATION_ID = "os_notification_id";
    private static final String OS_SUBSCRIPTION_ID = "os_subscription_id";
    private final IApplicationService _applicationService;
    private final ConfigModelStore _configModelStore;
    private final ISubscriptionManager _subscriptionManager;
    private final int maxDelay = 25;
    private final int minDelay;

    public ReceiveReceiptWorkManager(IApplicationService iApplicationService, ConfigModelStore configModelStore, ISubscriptionManager iSubscriptionManager) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iSubscriptionManager, "_subscriptionManager");
        this._applicationService = iApplicationService;
        this._configModelStore = configModelStore;
        this._subscriptionManager = iSubscriptionManager;
    }

    public void enqueueReceiveReceipt(String str) {
        Intrinsics.checkNotNullParameter(str, "notificationId");
        if (!((ConfigModel) this._configModelStore.getModel()).getReceiveReceiptEnabled()) {
            Logging.debug$default("sendReceiveReceipt disabled", (Throwable) null, 2, (Object) null);
            return;
        }
        String appId = ((ConfigModel) this._configModelStore.getModel()).getAppId();
        String id = this._subscriptionManager.getSubscriptions().getPush().getId();
        if (id.length() == 0 || appId.length() == 0) {
            Logging.debug$default("ReceiveReceiptWorkManager: No push subscription or appId!", (Throwable) null, 2, (Object) null);
        }
        int randomDelay = AndroidUtils.INSTANCE.getRandomDelay(this.minDelay, this.maxDelay);
        Data build = new Data.Builder().putString(OS_NOTIFICATION_ID, str).putString(OS_APP_ID, appId).putString(OS_SUBSCRIPTION_ID, id).build();
        Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
        Constraints buildConstraints = buildConstraints();
        Logging.debug$default("OSReceiveReceiptController enqueueing send receive receipt work with notificationId: " + str + " and delay: " + randomDelay + " seconds", (Throwable) null, 2, (Object) null);
        WorkManager instance = OSWorkManagerHelper.INSTANCE.getInstance(this._applicationService.getAppContext());
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("_receive_receipt");
        instance.enqueueUniqueWork(sb.toString(), ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(ReceiveReceiptWorker.class).setConstraints(buildConstraints)).setInitialDelay((long) randomDelay, TimeUnit.SECONDS)).setInputData(build)).build());
    }

    private final Constraints buildConstraints() {
        return new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager$ReceiveReceiptWorker;", "Landroidx/work/CoroutineWorker;", "context", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ReceiveReceiptWorkManager.kt */
    public static final class ReceiveReceiptWorker extends CoroutineWorker {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ReceiveReceiptWorker(Context context, WorkerParameters workerParameters) {
            super(context, workerParameters);
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r9) {
            /*
                r8 = this;
                boolean r0 = r9 instanceof com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1
                if (r0 == 0) goto L_0x0014
                r0 = r9
                com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 r0 = (com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L_0x0014
                int r9 = r0.label
                int r9 = r9 - r2
                r0.label = r9
                goto L_0x0019
            L_0x0014:
                com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1 r0 = new com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager$ReceiveReceiptWorker$doWork$1
                r0.<init>(r8, r9)
            L_0x0019:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                java.lang.String r3 = "success()"
                r4 = 1
                if (r2 == 0) goto L_0x0034
                if (r2 != r4) goto L_0x002c
                kotlin.ResultKt.throwOnFailure(r9)
                goto L_0x008c
            L_0x002c:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L_0x0034:
                kotlin.ResultKt.throwOnFailure(r9)
                android.content.Context r9 = r8.getApplicationContext()
                java.lang.String r2 = "applicationContext"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r2)
                boolean r9 = com.onesignal.OneSignal.initWithContext(r9)
                if (r9 != 0) goto L_0x004e
                androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
                return r9
            L_0x004e:
                androidx.work.Data r9 = r8.getInputData()
                java.lang.String r2 = "os_notification_id"
                java.lang.String r9 = r9.getString(r2)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                androidx.work.Data r2 = r8.getInputData()
                java.lang.String r5 = "os_app_id"
                java.lang.String r2 = r2.getString(r5)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
                androidx.work.Data r5 = r8.getInputData()
                java.lang.String r6 = "os_subscription_id"
                java.lang.String r5 = r5.getString(r6)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                com.onesignal.OneSignal r6 = com.onesignal.OneSignal.INSTANCE
                com.onesignal.common.services.IServiceProvider r6 = r6.getServices()
                java.lang.Class<com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor> r7 = com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor.class
                java.lang.Object r6 = r6.getService(r7)
                com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor r6 = (com.onesignal.notifications.internal.receivereceipt.IReceiveReceiptProcessor) r6
                r0.label = r4
                java.lang.Object r9 = r6.sendReceiveReceipt(r2, r5, r9, r0)
                if (r9 != r1) goto L_0x008c
                return r1
            L_0x008c:
                androidx.work.ListenableWorker$Result r9 = androidx.work.ListenableWorker.Result.success()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r3)
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.receivereceipt.impl.ReceiveReceiptWorkManager.ReceiveReceiptWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/onesignal/notifications/internal/receivereceipt/impl/ReceiveReceiptWorkManager$Companion;", "", "()V", "OS_APP_ID", "", "OS_NOTIFICATION_ID", "OS_SUBSCRIPTION_ID", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ReceiveReceiptWorkManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
