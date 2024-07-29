package com.onesignal.notifications.internal.registration.impl;

import com.google.android.gms.iid.InstanceID;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.debug.internal.logging.Logging;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0005\b \u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001#B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ#\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0019\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017J\u0012\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0011\u0010 \u001a\u00020\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010!J\u0019\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0002\u0004\n\u0002\b\u0019¨\u0006$"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle;", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "Lcom/onesignal/notifications/internal/registration/impl/IPushRegistratorCallback;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_upgradePrompt", "Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "(Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;)V", "providerName", "", "getProviderName", "()Ljava/lang/String;", "attemptRegistration", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator$RegisterResult;", "senderId", "currentRetry", "", "(Ljava/lang/String;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fireCallback", "", "id", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "internalRegisterForPush", "isValidProjectNumber", "", "pushStatusFromThrowable", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "throwable", "", "registerForPush", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerInBackground", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushRegistratorAbstractGoogle.kt */
public abstract class PushRegistratorAbstractGoogle implements IPushRegistrator, IPushRegistratorCallback {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int REGISTRATION_RETRY_BACKOFF_MS = 10000;
    private static final int REGISTRATION_RETRY_COUNT = 5;
    private ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;
    private final GooglePlayServicesUpgradePrompt _upgradePrompt;

    public Object fireCallback(String str, Continuation<? super Unit> continuation) {
        return fireCallback$suspendImpl(this, str, continuation);
    }

    public abstract String getProviderName();

    public abstract Object getToken(String str, Continuation<? super String> continuation) throws ExecutionException, InterruptedException, IOException;

    public Object registerForPush(Continuation<? super IPushRegistrator.RegisterResult> continuation) {
        return registerForPush$suspendImpl(this, continuation);
    }

    public PushRegistratorAbstractGoogle(IDeviceService iDeviceService, ConfigModelStore configModelStore, GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt) {
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(googlePlayServicesUpgradePrompt, "_upgradePrompt");
        this._deviceService = iDeviceService;
        this._configModelStore = configModelStore;
        this._upgradePrompt = googlePlayServicesUpgradePrompt;
    }

    static /* synthetic */ Object registerForPush$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, Continuation continuation) {
        if (!((ConfigModel) pushRegistratorAbstractGoogle._configModelStore.getModel()).isInitializedWithRemote()) {
            return new IPushRegistrator.RegisterResult((String) null, SubscriptionStatus.FIREBASE_FCM_INIT_ERROR);
        }
        if (!pushRegistratorAbstractGoogle._deviceService.getHasFCMLibrary()) {
            Logging.fatal$default("The Firebase FCM library is missing! Please make sure to include it in your project.", (Throwable) null, 2, (Object) null);
            return new IPushRegistrator.RegisterResult((String) null, SubscriptionStatus.MISSING_FIREBASE_FCM_LIBRARY);
        } else if (!pushRegistratorAbstractGoogle.isValidProjectNumber(((ConfigModel) pushRegistratorAbstractGoogle._configModelStore.getModel()).getGoogleProjectNumber())) {
            Logging.error$default("Missing Google Project number!\nPlease enter a Google Project number / Sender ID on under App Settings > Android > Configuration on the OneSignal dashboard.", (Throwable) null, 2, (Object) null);
            return new IPushRegistrator.RegisterResult((String) null, SubscriptionStatus.INVALID_FCM_SENDER_ID);
        } else {
            String googleProjectNumber = ((ConfigModel) pushRegistratorAbstractGoogle._configModelStore.getModel()).getGoogleProjectNumber();
            Intrinsics.checkNotNull(googleProjectNumber);
            return pushRegistratorAbstractGoogle.internalRegisterForPush(googleProjectNumber, continuation);
        }
    }

    static /* synthetic */ Object fireCallback$suspendImpl(PushRegistratorAbstractGoogle pushRegistratorAbstractGoogle, String str, Continuation continuation) {
        throw new Exception("Google has no callback mechanism for push registration!");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object internalRegisterForPush(java.lang.String r7, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$internalRegisterForPush$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 2
            r5 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r3) goto L_0x003a
            if (r2 != r4) goto L_0x0032
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r7 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0042 }
            goto L_0x006c
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            java.lang.Object r7 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r7 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0042 }
            goto L_0x005b
        L_0x0042:
            r8 = move-exception
            goto L_0x007b
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r8)
            com.onesignal.core.internal.device.IDeviceService r8 = r6._deviceService     // Catch:{ all -> 0x0079 }
            boolean r8 = r8.isGMSInstalledAndEnabled()     // Catch:{ all -> 0x0079 }
            if (r8 == 0) goto L_0x005e
            r0.L$0 = r6     // Catch:{ all -> 0x0079 }
            r0.label = r3     // Catch:{ all -> 0x0079 }
            java.lang.Object r8 = r6.registerInBackground(r7, r0)     // Catch:{ all -> 0x0079 }
            if (r8 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r7 = r6
        L_0x005b:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r8 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r8     // Catch:{ all -> 0x0042 }
            goto L_0x0078
        L_0x005e:
            com.onesignal.notifications.internal.registration.impl.GooglePlayServicesUpgradePrompt r7 = r6._upgradePrompt     // Catch:{ all -> 0x0079 }
            r0.L$0 = r6     // Catch:{ all -> 0x0079 }
            r0.label = r4     // Catch:{ all -> 0x0079 }
            java.lang.Object r7 = r7.showUpdateGPSDialog(r0)     // Catch:{ all -> 0x0079 }
            if (r7 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r7 = r6
        L_0x006c:
            java.lang.String r8 = "'Google Play services' app not installed or disabled on the device."
            com.onesignal.debug.internal.logging.Logging.error$default(r8, r5, r4, r5)     // Catch:{ all -> 0x0042 }
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r8 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch:{ all -> 0x0042 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.OUTDATED_GOOGLE_PLAY_SERVICES_APP     // Catch:{ all -> 0x0042 }
            r8.<init>(r5, r0)     // Catch:{ all -> 0x0042 }
        L_0x0078:
            return r8
        L_0x0079:
            r8 = move-exception
            r7 = r6
        L_0x007b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Could not register with "
            r0.<init>(r1)
            java.lang.String r7 = r7.getProviderName()
            r0.append(r7)
            java.lang.String r7 = " due to an issue with your AndroidManifest.xml or with 'Google Play services'."
            r0.append(r7)
            java.lang.String r7 = r0.toString()
            com.onesignal.debug.internal.logging.Logging.error(r7, r8)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r7 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r8 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_INIT_ERROR
            r7.<init>(r5, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.internalRegisterForPush(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object registerInBackground(java.lang.String r10, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$registerInBackground$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004d
            if (r2 == r4) goto L_0x003f
            if (r2 != r3) goto L_0x0037
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r5 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0082
        L_0x0037:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003f:
            int r10 = r0.I$0
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r5 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r5 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r5
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0069
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r11)
            r11 = 0
            r2 = r9
        L_0x0052:
            r5 = 5
            if (r11 >= r5) goto L_0x0087
            r0.L$0 = r2
            r0.L$1 = r10
            r0.I$0 = r11
            r0.label = r4
            java.lang.Object r5 = r2.attemptRegistration(r10, r11, r0)
            if (r5 != r1) goto L_0x0064
            return r1
        L_0x0064:
            r8 = r2
            r2 = r10
            r10 = r11
            r11 = r5
            r5 = r8
        L_0x0069:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r11 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r11
            if (r11 == 0) goto L_0x006e
            return r11
        L_0x006e:
            int r11 = r10 + 1
            int r11 = r11 * 10000
            long r6 = (long) r11
            r0.L$0 = r5
            r0.L$1 = r2
            r0.I$0 = r10
            r0.label = r3
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r6, r0)
            if (r11 != r1) goto L_0x0082
            return r1
        L_0x0082:
            int r11 = r10 + 1
            r10 = r2
            r2 = r5
            goto L_0x0052
        L_0x0087:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r10 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r11 = 0
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_INIT_ERROR
            r10.<init>(r11, r0)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.registerInBackground(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object attemptRegistration(java.lang.String r9, int r10, kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult> r11) {
        /*
            r8 = this;
            java.lang.String r0 = "Device registered, push token = "
            boolean r1 = r11 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$attemptRegistration$1
            if (r1 == 0) goto L_0x0016
            r1 = r11
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$attemptRegistration$1 r1 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$attemptRegistration$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = r2 & r3
            if (r2 == 0) goto L_0x0016
            int r11 = r1.label
            int r11 = r11 - r3
            r1.label = r11
            goto L_0x001b
        L_0x0016:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$attemptRegistration$1 r1 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle$attemptRegistration$1
            r1.<init>(r8, r11)
        L_0x001b:
            java.lang.Object r11 = r1.result
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r1.label
            r4 = 2
            java.lang.String r5 = " Token"
            r6 = 1
            r7 = 0
            if (r3 == 0) goto L_0x0042
            if (r3 != r6) goto L_0x003a
            int r10 = r1.I$0
            java.lang.Object r9 = r1.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle r9 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle) r9
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            goto L_0x0053
        L_0x0036:
            r10 = move-exception
            goto L_0x006e
        L_0x0038:
            r11 = move-exception
            goto L_0x0090
        L_0x003a:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x0042:
            kotlin.ResultKt.throwOnFailure(r11)
            r1.L$0 = r8     // Catch:{ IOException -> 0x008e, all -> 0x006c }
            r1.I$0 = r10     // Catch:{ IOException -> 0x008e, all -> 0x006c }
            r1.label = r6     // Catch:{ IOException -> 0x008e, all -> 0x006c }
            java.lang.Object r11 = r8.getToken(r9, r1)     // Catch:{ IOException -> 0x008e, all -> 0x006c }
            if (r11 != r2) goto L_0x0052
            return r2
        L_0x0052:
            r9 = r8
        L_0x0053:
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            r1.append(r11)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            com.onesignal.debug.internal.logging.Logging.info$default(r0, r7, r4, r7)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r0 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            r0.<init>(r11, r1)     // Catch:{ IOException -> 0x0038, all -> 0x0036 }
            return r0
        L_0x006c:
            r10 = move-exception
            r9 = r8
        L_0x006e:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r0 = "Unknown error getting "
            r11.<init>(r0)
            java.lang.String r9 = r9.getProviderName()
            r11.append(r9)
            r11.append(r5)
            java.lang.String r9 = r11.toString()
            com.onesignal.debug.internal.logging.Logging.error(r9, r10)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r10 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION
            r9.<init>(r7, r10)
            return r9
        L_0x008e:
            r11 = move-exception
            r9 = r8
        L_0x0090:
            java.lang.Throwable r11 = (java.lang.Throwable) r11
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = r9.pushStatusFromThrowable(r11)
            com.onesignal.common.AndroidUtils r1 = com.onesignal.common.AndroidUtils.INSTANCE
            java.lang.String r1 = r1.getRootCauseMessage(r11)
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 != 0) goto L_0x00d2
            java.lang.String r2 = "AUTHENTICATION_FAILED"
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r1)
            if (r2 == 0) goto L_0x00ad
            goto L_0x00d2
        L_0x00ad:
            java.lang.Exception r10 = new java.lang.Exception
            r10.<init>(r11)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r1 = "Error Getting "
            r11.<init>(r1)
            java.lang.String r9 = r9.getProviderName()
            r11.append(r9)
            r11.append(r5)
            java.lang.String r9 = r11.toString()
            java.lang.Throwable r10 = (java.lang.Throwable) r10
            com.onesignal.debug.internal.logging.Logging.error(r9, r10)
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r9.<init>(r7, r0)
            return r9
        L_0x00d2:
            java.lang.Exception r2 = new java.lang.Exception
            r2.<init>(r11)
            r11 = 4
            if (r10 < r11) goto L_0x00f7
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Retry count of 5 exceed! Could not get a "
            r10.<init>(r11)
            java.lang.String r9 = r9.getProviderName()
            r10.append(r9)
            java.lang.String r9 = " Token."
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            com.onesignal.debug.internal.logging.Logging.error(r9, r2)
            goto L_0x011a
        L_0x00f7:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r11 = "'Google Play services' returned "
            r9.<init>(r11)
            r9.append(r1)
            java.lang.String r11 = " error. Current retry count: "
            r9.append(r11)
            r9.append(r10)
            java.lang.String r9 = r9.toString()
            java.lang.Throwable r2 = (java.lang.Throwable) r2
            com.onesignal.debug.internal.logging.Logging.info(r9, r2)
            if (r10 != r4) goto L_0x011a
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r9 = new com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult
            r9.<init>(r7, r0)
            return r9
        L_0x011a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorAbstractGoogle.attemptRegistration(java.lang.String, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final SubscriptionStatus pushStatusFromThrowable(Throwable th) {
        String rootCauseMessage = AndroidUtils.INSTANCE.getRootCauseMessage(th);
        if (!(th instanceof IOException)) {
            return SubscriptionStatus.FIREBASE_FCM_ERROR_MISC_EXCEPTION;
        }
        if (Intrinsics.areEqual((Object) rootCauseMessage, (Object) InstanceID.ERROR_SERVICE_NOT_AVAILABLE)) {
            return SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_SERVICE_NOT_AVAILABLE;
        }
        if (Intrinsics.areEqual((Object) rootCauseMessage, (Object) "AUTHENTICATION_FAILED")) {
            return SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_AUTHENTICATION_FAILED;
        }
        return SubscriptionStatus.FIREBASE_FCM_ERROR_IOEXCEPTION_OTHER;
    }

    private final boolean isValidProjectNumber(String str) {
        try {
            Intrinsics.checkNotNull(str);
            Float.parseFloat(str);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle$Companion;", "", "()V", "REGISTRATION_RETRY_BACKOFF_MS", "", "REGISTRATION_RETRY_COUNT", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PushRegistratorAbstractGoogle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
