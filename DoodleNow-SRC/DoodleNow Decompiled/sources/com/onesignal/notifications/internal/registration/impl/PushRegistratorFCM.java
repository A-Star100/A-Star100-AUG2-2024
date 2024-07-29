package com.onesignal.notifications.internal.registration.impl;

import android.util.Base64;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.messaging.FirebaseMessaging;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.config.FCMConfigModel;
import com.onesignal.core.internal.device.IDeviceService;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineScopeKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001b\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u0011\u0010\u001e\u001a\u00020\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u00020!2\u0006\u0010\u001b\u001a\u00020\u0012H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\u00020\u00128VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorFCM;", "Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorAbstractGoogle;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "upgradePrompt", "Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "(Lcom/onesignal/core/internal/config/ConfigModelStore;Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;Lcom/onesignal/core/internal/device/IDeviceService;)V", "get_applicationService", "()Lcom/onesignal/core/internal/application/IApplicationService;", "get_configModelStore", "()Lcom/onesignal/core/internal/config/ConfigModelStore;", "set_configModelStore", "(Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "apiKey", "", "appId", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "projectId", "providerName", "getProviderName", "()Ljava/lang/String;", "getToken", "senderId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTokenWithClassFirebaseInstanceId", "getTokenWithClassFirebaseMessaging", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initFirebaseApp", "", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushRegistratorFCM.kt */
public final class PushRegistratorFCM extends PushRegistratorAbstractGoogle {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FCM_APP_NAME = "ONESIGNAL_SDK_FCM_APP_NAME";
    private static final String FCM_DEFAULT_API_KEY_BASE64 = "QUl6YVN5QW5UTG41LV80TWMyYTJQLWRLVWVFLWFCdGd5Q3JqbFlV";
    private static final String FCM_DEFAULT_APP_ID = "1:754795614042:android:c682b8144a8dd52bc1ad63";
    private static final String FCM_DEFAULT_PROJECT_ID = "onesignal-shared-public";
    private final IApplicationService _applicationService;
    private ConfigModelStore _configModelStore;
    private final String apiKey;
    private final String appId;
    /* access modifiers changed from: private */
    public FirebaseApp firebaseApp;
    private final String projectId;

    public String getProviderName() {
        return FirebaseMessaging.INSTANCE_ID_SCOPE;
    }

    public final IApplicationService get_applicationService() {
        return this._applicationService;
    }

    public final ConfigModelStore get_configModelStore() {
        return this._configModelStore;
    }

    public final void set_configModelStore(ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(configModelStore, "<set-?>");
        this._configModelStore = configModelStore;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/PushRegistratorFCM$Companion;", "", "()V", "FCM_APP_NAME", "", "FCM_DEFAULT_API_KEY_BASE64", "FCM_DEFAULT_APP_ID", "FCM_DEFAULT_PROJECT_ID", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PushRegistratorFCM.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PushRegistratorFCM(ConfigModelStore configModelStore, IApplicationService iApplicationService, GooglePlayServicesUpgradePrompt googlePlayServicesUpgradePrompt, IDeviceService iDeviceService) {
        super(iDeviceService, configModelStore, googlePlayServicesUpgradePrompt);
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(googlePlayServicesUpgradePrompt, "upgradePrompt");
        Intrinsics.checkNotNullParameter(iDeviceService, "deviceService");
        this._configModelStore = configModelStore;
        this._applicationService = iApplicationService;
        FCMConfigModel fcmParams = ((ConfigModel) configModelStore.getModel()).getFcmParams();
        String projectId2 = fcmParams.getProjectId();
        this.projectId = projectId2 == null ? FCM_DEFAULT_PROJECT_ID : projectId2;
        String appId2 = fcmParams.getAppId();
        this.appId = appId2 == null ? FCM_DEFAULT_APP_ID : appId2;
        byte[] decode = Base64.decode(FCM_DEFAULT_API_KEY_BASE64, 0);
        Intrinsics.checkNotNullExpressionValue(decode, "decode(FCM_DEFAULT_API_KEY_BASE64, Base64.DEFAULT)");
        String str = new String(decode, Charsets.UTF_8);
        String apiKey2 = fcmParams.getApiKey();
        this.apiKey = apiKey2 != null ? apiKey2 : str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006d A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006e A[PHI: r9 
      PHI: (r9v2 java.lang.Object) = (r9v3 java.lang.Object), (r9v1 java.lang.Object) binds: [B:31:0x006b, B:10:0x002c] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object getToken(java.lang.String r8, kotlin.coroutines.Continuation<? super java.lang.String> r9) throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getToken$1 r0 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getToken$1 r0 = new com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM$getToken$1
            r0.<init>(r7, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            java.lang.String r3 = "FirebaseMessaging.getToken not found, attempting to use FirebaseInstanceId.getToken"
            r4 = 1
            r5 = 2
            r6 = 0
            if (r2 == 0) goto L_0x0044
            if (r2 == r4) goto L_0x0038
            if (r2 != r5) goto L_0x0030
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006e
        L_0x0030:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0038:
            java.lang.Object r8 = r0.L$1
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r2 = r0.L$0
            com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM r2 = (com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM) r2
            kotlin.ResultKt.throwOnFailure(r9)     // Catch:{ NoClassDefFoundError -> 0x005e, NoSuchMethodError -> 0x0059 }
            goto L_0x0057
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r9)
            r7.initFirebaseApp(r8)
            r0.L$0 = r7     // Catch:{ NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x0058 }
            r0.L$1 = r8     // Catch:{ NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x0058 }
            r0.label = r4     // Catch:{ NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x0058 }
            java.lang.Object r9 = r7.getTokenWithClassFirebaseMessaging(r0)     // Catch:{ NoClassDefFoundError -> 0x005d, NoSuchMethodError -> 0x0058 }
            if (r9 != r1) goto L_0x0057
            return r1
        L_0x0057:
            return r9
        L_0x0058:
            r2 = r7
        L_0x0059:
            com.onesignal.debug.internal.logging.Logging.info$default(r3, r6, r5, r6)
            goto L_0x0061
        L_0x005d:
            r2 = r7
        L_0x005e:
            com.onesignal.debug.internal.logging.Logging.info$default(r3, r6, r5, r6)
        L_0x0061:
            r0.L$0 = r6
            r0.L$1 = r6
            r0.label = r5
            java.lang.Object r9 = r2.getTokenWithClassFirebaseInstanceId(r8, r0)
            if (r9 != r1) goto L_0x006e
            return r1
        L_0x006e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.registration.impl.PushRegistratorFCM.getToken(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    @Deprecated(message = "")
    public final Object getTokenWithClassFirebaseInstanceId(String str, Continuation<? super String> continuation) throws IOException {
        return CoroutineScopeKt.coroutineScope(new PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2(this, str, (Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseInstanceId$2>) null), continuation);
    }

    /* access modifiers changed from: private */
    public final Object getTokenWithClassFirebaseMessaging(Continuation<? super String> continuation) throws ExecutionException, InterruptedException {
        return CoroutineScopeKt.coroutineScope(new PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2(this, (Continuation<? super PushRegistratorFCM$getTokenWithClassFirebaseMessaging$2>) null), continuation);
    }

    private final void initFirebaseApp(String str) {
        if (this.firebaseApp == null) {
            FirebaseOptions build = new FirebaseOptions.Builder().setGcmSenderId(str).setApplicationId(this.appId).setApiKey(this.apiKey).setProjectId(this.projectId).build();
            Intrinsics.checkNotNullExpressionValue(build, "Builder()\n              …\n                .build()");
            this.firebaseApp = FirebaseApp.initializeApp(this._applicationService.getAppContext(), build, FCM_APP_NAME);
        }
    }
}
