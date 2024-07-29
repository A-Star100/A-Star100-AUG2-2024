package com.onesignal.notifications.internal.pushtoken;

import com.onesignal.core.internal.device.IDeviceService;
import com.onesignal.notifications.internal.registration.IPushRegistrator;
import com.onesignal.user.internal.subscriptions.SubscriptionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0002J\u0011\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lcom/onesignal/notifications/internal/pushtoken/PushTokenManager;", "Lcom/onesignal/notifications/internal/pushtoken/IPushTokenManager;", "_pushRegistrator", "Lcom/onesignal/notifications/internal/registration/IPushRegistrator;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "(Lcom/onesignal/notifications/internal/registration/IPushRegistrator;Lcom/onesignal/core/internal/device/IDeviceService;)V", "pushToken", "", "getPushToken", "()Ljava/lang/String;", "setPushToken", "(Ljava/lang/String;)V", "pushTokenStatus", "Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "getPushTokenStatus", "()Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;", "setPushTokenStatus", "(Lcom/onesignal/user/internal/subscriptions/SubscriptionStatus;)V", "pushStatusRuntimeError", "", "status", "retrievePushToken", "Lcom/onesignal/notifications/internal/pushtoken/PushTokenResponse;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PushTokenManager.kt */
public final class PushTokenManager implements IPushTokenManager {
    private final IDeviceService _deviceService;
    private final IPushRegistrator _pushRegistrator;
    private String pushToken;
    private SubscriptionStatus pushTokenStatus = SubscriptionStatus.NO_PERMISSION;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PushTokenManager.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IDeviceService.AndroidSupportLibraryStatus.values().length];
            iArr[IDeviceService.AndroidSupportLibraryStatus.MISSING.ordinal()] = 1;
            iArr[IDeviceService.AndroidSupportLibraryStatus.OUTDATED.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final String getPushToken() {
        return this.pushToken;
    }

    public final SubscriptionStatus getPushTokenStatus() {
        return this.pushTokenStatus;
    }

    public final void setPushToken(String str) {
        this.pushToken = str;
    }

    public final void setPushTokenStatus(SubscriptionStatus subscriptionStatus) {
        Intrinsics.checkNotNullParameter(subscriptionStatus, "<set-?>");
        this.pushTokenStatus = subscriptionStatus;
    }

    public PushTokenManager(IPushRegistrator iPushRegistrator, IDeviceService iDeviceService) {
        Intrinsics.checkNotNullParameter(iPushRegistrator, "_pushRegistrator");
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        this._pushRegistrator = iPushRegistrator;
        this._deviceService = iDeviceService;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object retrievePushToken(kotlin.coroutines.Continuation<? super com.onesignal.notifications.internal.pushtoken.PushTokenResponse> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1 r0 = (com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1 r0 = new com.onesignal.notifications.internal.pushtoken.PushTokenManager$retrievePushToken$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.onesignal.notifications.internal.pushtoken.PushTokenManager r0 = (com.onesignal.notifications.internal.pushtoken.PushTokenManager) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x005b
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.onesignal.core.internal.device.IDeviceService r6 = r5._deviceService
            com.onesignal.core.internal.device.IDeviceService$AndroidSupportLibraryStatus r6 = r6.getAndroidSupportLibraryStatus()
            int[] r2 = com.onesignal.notifications.internal.pushtoken.PushTokenManager.WhenMappings.$EnumSwitchMapping$0
            int r6 = r6.ordinal()
            r6 = r2[r6]
            r2 = 2
            r4 = 0
            if (r6 == r3) goto L_0x00bc
            if (r6 == r2) goto L_0x00b2
            com.onesignal.notifications.internal.registration.IPushRegistrator r6 = r5._pushRegistrator
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.registerForPush(r0)
            if (r6 != r1) goto L_0x005a
            return r1
        L_0x005a:
            r0 = r5
        L_0x005b:
            com.onesignal.notifications.internal.registration.IPushRegistrator$RegisterResult r6 = (com.onesignal.notifications.internal.registration.IPushRegistrator.RegisterResult) r6
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            int r1 = r1.getValue()
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            int r2 = r2.getValue()
            if (r1 != r2) goto L_0x0074
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            r0.pushTokenStatus = r1
            goto L_0x00ab
        L_0x0074:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            int r1 = r1.getValue()
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.SUBSCRIBED
            int r2 = r2.getValue()
            if (r1 >= r2) goto L_0x009d
            java.lang.String r1 = r0.pushToken
            if (r1 != 0) goto L_0x00ab
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r0.pushTokenStatus
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r2 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.NO_PERMISSION
            if (r1 == r2) goto L_0x0096
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r0.pushTokenStatus
            boolean r1 = r0.pushStatusRuntimeError(r1)
            if (r1 == 0) goto L_0x00ab
        L_0x0096:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            r0.pushTokenStatus = r1
            goto L_0x00ab
        L_0x009d:
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r0.pushTokenStatus
            boolean r1 = r0.pushStatusRuntimeError(r1)
            if (r1 == 0) goto L_0x00ab
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r1 = r6.getStatus()
            r0.pushTokenStatus = r1
        L_0x00ab:
            java.lang.String r6 = r6.getId()
            r0.pushToken = r6
            goto L_0x00c6
        L_0x00b2:
            java.lang.String r6 = "The included Android Support Library is too old or incomplete. Please update to the 26.0.0 revision or newer."
            com.onesignal.debug.internal.logging.Logging.fatal$default(r6, r4, r2, r4)
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.OUTDATED_ANDROID_SUPPORT_LIBRARY
            r5.pushTokenStatus = r6
            goto L_0x00c5
        L_0x00bc:
            java.lang.String r6 = "Could not find the Android Support Library. Please make sure it has been correctly added to your project."
            com.onesignal.debug.internal.logging.Logging.fatal$default(r6, r4, r2, r4)
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r6 = com.onesignal.user.internal.subscriptions.SubscriptionStatus.MISSING_ANDROID_SUPPORT_LIBRARY
            r5.pushTokenStatus = r6
        L_0x00c5:
            r0 = r5
        L_0x00c6:
            com.onesignal.notifications.internal.pushtoken.PushTokenResponse r6 = new com.onesignal.notifications.internal.pushtoken.PushTokenResponse
            java.lang.String r1 = r0.pushToken
            com.onesignal.user.internal.subscriptions.SubscriptionStatus r0 = r0.pushTokenStatus
            r6.<init>(r1, r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.notifications.internal.pushtoken.PushTokenManager.retrievePushToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final boolean pushStatusRuntimeError(SubscriptionStatus subscriptionStatus) {
        return subscriptionStatus.getValue() < -6;
    }
}
