package com.onesignal.notifications.internal.registration.impl;

import com.onesignal.common.threading.WaiterWithValue;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u00020\u00012\u00020\u0002:\u0001\u0016B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\nH@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u0011\u0010\u0014\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorHMS;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/application/IApplicationService;)V", "waiter", "Lcom/onesignal/common/threading/WaiterWithValue;", "", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getHMSTokenTask", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerForPush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushRegistratorHMS.kt */
public final class PushRegistratorHMS implements IPushRegistrator, IPushRegistratorCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HMS_CLIENT_APP_ID = "client/app_id";
    private final IApplicationService _applicationService;
    private final IDeviceService _deviceService;
    /* access modifiers changed from: private */
    public WaiterWithValue<String> waiter;

    public PushRegistratorHMS(IDeviceService iDeviceService, IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        this._deviceService = iDeviceService;
        this._applicationService = iApplicationService;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorHMS$Companion;", "", "()V", "HMS_CLIENT_APP_ID", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PushRegistratorHMS.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object registerForPush(kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$registerForPush$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r4) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ ApiException -> 0x002b }
            goto L_0x004a
        L_0x002b:
            r6 = move-exception
            goto L_0x004d
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r3
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r6 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r6
            com.onesignal.core.internal.application.IApplicationService r6 = r5._applicationService     // Catch:{ ApiException -> 0x002b }
            android.content.Context r6 = r6.getAppContext()     // Catch:{ ApiException -> 0x002b }
            r0.label = r4     // Catch:{ ApiException -> 0x002b }
            java.lang.Object r6 = r5.getHMSTokenTask(r6, r0)     // Catch:{ ApiException -> 0x002b }
            if (r6 != r1) goto L_0x004a
            return r1
        L_0x004a:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r6 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r6     // Catch:{ ApiException -> 0x002b }
            goto L_0x0069
        L_0x004d:
            java.lang.String r0 = "HMS ApiException getting Huawei push token!"
            r1 = r6
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            com.onesignal.debug.internal.logging.Logging.error(r0, r1)
            int r6 = r6.getStatusCode()
            r0 = 907135000(0x3611c818, float:2.1723154E-6)
            if (r6 != r0) goto L_0x0061
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_ARGUMENTS_INVALID
            goto L_0x0063
        L_0x0061:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_API_EXCEPTION_OTHER
        L_0x0063:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r0 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r0.<init>(r3, r6)
            r6 = r0
        L_0x0069:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.registerForPush(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e4, code lost:
        return r12;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.Object getHMSTokenTask(android.content.Context r11, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r12) throws com.huawei.hms.common.ApiException {
        /*
            r10 = this;
            java.lang.String r0 = "Device registered for HMS, push token = "
            java.lang.String r1 = "HMS registered with ID:"
            monitor-enter(r10)
            boolean r2 = r12 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$1     // Catch:{ all -> 0x00e5 }
            if (r2 == 0) goto L_0x0019
            r2 = r12
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$1 r2 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$1) r2     // Catch:{ all -> 0x00e5 }
            int r3 = r2.label     // Catch:{ all -> 0x00e5 }
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x0019
            int r12 = r2.label     // Catch:{ all -> 0x00e5 }
            int r12 = r12 - r4
            r2.label = r12     // Catch:{ all -> 0x00e5 }
            goto L_0x001e
        L_0x0019:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$1 r2 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$1     // Catch:{ all -> 0x00e5 }
            r2.<init>(r10, r12)     // Catch:{ all -> 0x00e5 }
        L_0x001e:
            java.lang.Object r12 = r2.result     // Catch:{ all -> 0x00e5 }
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()     // Catch:{ all -> 0x00e5 }
            int r4 = r2.label     // Catch:{ all -> 0x00e5 }
            r5 = 1
            r6 = 2
            r7 = 0
            if (r4 == 0) goto L_0x003e
            if (r4 != r5) goto L_0x0036
            java.lang.Object r11 = r2.L$0     // Catch:{ all -> 0x00e5 }
            kotlin.jvm.internal.Ref$ObjectRef r11 = (kotlin.jvm.internal.Ref.ObjectRef) r11     // Catch:{ all -> 0x00e5 }
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00e5 }
            goto L_0x00b4
        L_0x0036:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00e5 }
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)     // Catch:{ all -> 0x00e5 }
            throw r11     // Catch:{ all -> 0x00e5 }
        L_0x003e:
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ all -> 0x00e5 }
            com.onesignal.core.internal.device.IDeviceService r12 = r10._deviceService     // Catch:{ all -> 0x00e5 }
            boolean r12 = r12.getHasAllHMSLibrariesForPushKit()     // Catch:{ all -> 0x00e5 }
            if (r12 != 0) goto L_0x0052
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r11 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch:{ all -> 0x00e5 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r12 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.MISSING_HMS_PUSHKIT_LIBRARY     // Catch:{ all -> 0x00e5 }
            r11.<init>(r7, r12)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r10)
            return r11
        L_0x0052:
            com.onesignal.common.threading.WaiterWithValue r12 = new com.onesignal.common.threading.WaiterWithValue     // Catch:{ all -> 0x00e5 }
            r12.<init>()     // Catch:{ all -> 0x00e5 }
            r10.waiter = r12     // Catch:{ all -> 0x00e5 }
            com.huawei.agconnect.config.AGConnectServicesConfig r12 = com.huawei.agconnect.config.AGConnectServicesConfig.fromContext(r11)     // Catch:{ all -> 0x00e5 }
            java.lang.String r4 = "client/app_id"
            java.lang.String r12 = r12.getString(r4)     // Catch:{ all -> 0x00e5 }
            com.huawei.hms.aaid.HmsInstanceId r11 = com.huawei.hms.aaid.HmsInstanceId.getInstance(r11)     // Catch:{ all -> 0x00e5 }
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ all -> 0x00e5 }
            r4.<init>()     // Catch:{ all -> 0x00e5 }
            java.lang.String r8 = "HCM"
            java.lang.String r11 = r11.getToken(r12, r8)     // Catch:{ all -> 0x00e5 }
            r4.element = r11     // Catch:{ all -> 0x00e5 }
            T r11 = r4.element     // Catch:{ all -> 0x00e5 }
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11     // Catch:{ all -> 0x00e5 }
            boolean r11 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00e5 }
            if (r11 != 0) goto L_0x009e
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r11.<init>(r0)     // Catch:{ all -> 0x00e5 }
            T r12 = r4.element     // Catch:{ all -> 0x00e5 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x00e5 }
            r11.append(r12)     // Catch:{ all -> 0x00e5 }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00e5 }
            com.onesignal.debug.internal.logging.Logging.info$default(r11, r7, r6, r7)     // Catch:{ all -> 0x00e5 }
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r11 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch:{ all -> 0x00e5 }
            T r12 = r4.element     // Catch:{ all -> 0x00e5 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x00e5 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED     // Catch:{ all -> 0x00e5 }
            r11.<init>(r12, r0)     // Catch:{ all -> 0x00e5 }
            monitor-exit(r10)
            return r11
        L_0x009e:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$2 r11 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS$getHMSTokenTask$2     // Catch:{ all -> 0x00e5 }
            r11.<init>(r4, r10, r7)     // Catch:{ all -> 0x00e5 }
            kotlin.jvm.functions.Function2 r11 = (kotlin.jvm.functions.Function2) r11     // Catch:{ all -> 0x00e5 }
            r2.L$0 = r4     // Catch:{ all -> 0x00e5 }
            r2.label = r5     // Catch:{ all -> 0x00e5 }
            r8 = 30000(0x7530, double:1.4822E-319)
            java.lang.Object r11 = kotlinx.coroutines.TimeoutKt.withTimeout(r8, r11, r2)     // Catch:{ all -> 0x00e5 }
            if (r11 != r3) goto L_0x00b3
            monitor-exit(r10)
            return r3
        L_0x00b3:
            r11 = r4
        L_0x00b4:
            T r12 = r11.element     // Catch:{ all -> 0x00e5 }
            if (r12 == 0) goto L_0x00d7
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e5 }
            r12.<init>(r1)     // Catch:{ all -> 0x00e5 }
            T r0 = r11.element     // Catch:{ all -> 0x00e5 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x00e5 }
            r12.append(r0)     // Catch:{ all -> 0x00e5 }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00e5 }
            com.onesignal.debug.internal.logging.Logging.error$default(r12, r7, r6, r7)     // Catch:{ all -> 0x00e5 }
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r12 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch:{ all -> 0x00e5 }
            T r11 = r11.element     // Catch:{ all -> 0x00e5 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x00e5 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED     // Catch:{ all -> 0x00e5 }
            r12.<init>(r11, r0)     // Catch:{ all -> 0x00e5 }
            goto L_0x00e3
        L_0x00d7:
            java.lang.String r11 = "HmsMessageServiceOneSignal.onNewToken timed out."
            com.onesignal.debug.internal.logging.Logging.error$default(r11, r7, r6, r7)     // Catch:{ all -> 0x00e5 }
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r12 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch:{ all -> 0x00e5 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r11 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.HMS_TOKEN_TIMEOUT     // Catch:{ all -> 0x00e5 }
            r12.<init>(r7, r11)     // Catch:{ all -> 0x00e5 }
        L_0x00e3:
            monitor-exit(r10)
            return r12
        L_0x00e5:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorHMS.getHMSTokenTask(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object fireCallback(String str, Continuation<? super Unit> continuation) {
        WaiterWithValue<String> waiterWithValue = this.waiter;
        if (waiterWithValue != null) {
            waiterWithValue.wake(str);
        }
        return Unit.INSTANCE;
    }
}
