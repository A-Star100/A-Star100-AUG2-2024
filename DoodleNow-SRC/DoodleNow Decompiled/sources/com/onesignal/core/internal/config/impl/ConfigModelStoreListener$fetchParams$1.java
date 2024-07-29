package com.onesignal.core.internal.config.impl;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0006\n\u0002\u0010\u0002\n\u0000\u0010\u0001\u001a\u00020\u0000H@"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.onesignal.core.internal.config.impl.ConfigModelStoreListener$fetchParams$1", f = "ConfigModelStoreListener.kt", i = {0, 0, 1, 1}, l = {70, 120}, m = "invokeSuspend", n = {"androidParamsRetries", "success", "androidParamsRetries", "success"}, s = {"I$0", "I$1", "I$0", "I$1"})
/* compiled from: ConfigModelStoreListener.kt */
final class ConfigModelStoreListener$fetchParams$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    int I$0;
    int I$1;
    int label;
    final /* synthetic */ ConfigModelStoreListener this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ConfigModelStoreListener$fetchParams$1(String str, ConfigModelStoreListener configModelStoreListener, Continuation<? super ConfigModelStoreListener$fetchParams$1> continuation) {
        super(1, continuation);
        this.$appId = str;
        this.this$0 = configModelStoreListener;
    }

    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new ConfigModelStoreListener$fetchParams$1(this.$appId, this.this$0, continuation);
    }

    public final Object invoke(Continuation<? super Unit> continuation) {
        return ((ConfigModelStoreListener$fetchParams$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f A[Catch:{ BackendException -> 0x021e }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0081 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00e3 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00f0 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00fd A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x010a A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0117 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0124 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0131 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x013e A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x014b A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0158 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0169 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x017c A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0193 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01aa A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01c1 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01d8 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01ed A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0202 A[Catch:{ BackendException -> 0x021c }] */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x022b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0233  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x026b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r11.label
            r2 = 2
            r3 = 0
            r4 = 0
            r5 = 1
            if (r1 == 0) goto L_0x0035
            if (r1 == r5) goto L_0x0024
            if (r1 != r2) goto L_0x001c
            int r1 = r11.I$1
            int r4 = r11.I$0
            kotlin.ResultKt.throwOnFailure(r12)
            r6 = r4
            r4 = r1
            r1 = r11
            goto L_0x0266
        L_0x001c:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L_0x0024:
            int r1 = r11.I$1
            int r4 = r11.I$0
            kotlin.ResultKt.throwOnFailure(r12)     // Catch:{ BackendException -> 0x002f }
            r6 = r4
            r4 = r1
            r1 = r11
            goto L_0x0086
        L_0x002f:
            r12 = move-exception
            r6 = r4
            r4 = r1
            r1 = r11
            goto L_0x0223
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r12)
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r1 = "ConfigModelListener: fetching parameters for appId: "
            r12.<init>(r1)
            java.lang.String r1 = r11.$appId
            r12.append(r1)
            java.lang.String r12 = r12.toString()
            com.onesignal.debug.internal.logging.Logging.debug$default(r12, r3, r2, r3)
            r1 = r11
            r12 = r4
        L_0x004d:
            com.onesignal.core.internal.config.impl.ConfigModelStoreListener r6 = r1.this$0     // Catch:{ BackendException -> 0x021e }
            com.onesignal.core.internal.backend.IParamsBackendService r6 = r6._paramsBackendService     // Catch:{ BackendException -> 0x021e }
            java.lang.String r7 = r1.$appId     // Catch:{ BackendException -> 0x021e }
            com.onesignal.core.internal.config.impl.ConfigModelStoreListener r8 = r1.this$0     // Catch:{ BackendException -> 0x021e }
            com.onesignal.user.internal.subscriptions.ISubscriptionManager r8 = r8._subscriptionManager     // Catch:{ BackendException -> 0x021e }
            com.onesignal.user.internal.subscriptions.SubscriptionList r8 = r8.getSubscriptions()     // Catch:{ BackendException -> 0x021e }
            com.onesignal.user.subscriptions.IPushSubscription r8 = r8.getPush()     // Catch:{ BackendException -> 0x021e }
            java.lang.String r8 = r8.getId()     // Catch:{ BackendException -> 0x021e }
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8     // Catch:{ BackendException -> 0x021e }
            int r9 = r8.length()     // Catch:{ BackendException -> 0x021e }
            if (r9 != 0) goto L_0x0070
            r8 = r3
        L_0x0070:
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ BackendException -> 0x021e }
            r9 = r1
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ BackendException -> 0x021e }
            r1.I$0 = r4     // Catch:{ BackendException -> 0x021e }
            r1.I$1 = r12     // Catch:{ BackendException -> 0x021e }
            r1.label = r5     // Catch:{ BackendException -> 0x021e }
            java.lang.Object r6 = r6.fetchParams(r7, r8, r9)     // Catch:{ BackendException -> 0x021e }
            if (r6 != r0) goto L_0x0082
            return r0
        L_0x0082:
            r10 = r4
            r4 = r12
            r12 = r6
            r6 = r10
        L_0x0086:
            com.onesignal.core.internal.backend.ParamsObject r12 = (com.onesignal.core.internal.backend.ParamsObject) r12     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.ConfigModel r7 = new com.onesignal.core.internal.config.ConfigModel     // Catch:{ BackendException -> 0x021c }
            r7.<init>()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.impl.ConfigModelStoreListener r8 = r1.this$0     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.ConfigModelStore r8 = r8._configModelStore     // Catch:{ BackendException -> 0x021c }
            com.onesignal.common.modeling.Model r8 = r8.getModel()     // Catch:{ BackendException -> 0x021c }
            r7.initializeFromModel(r3, r8)     // Catch:{ BackendException -> 0x021c }
            r7.setInitializedWithRemote(r5)     // Catch:{ BackendException -> 0x021c }
            java.lang.String r8 = r1.$appId     // Catch:{ BackendException -> 0x021c }
            r7.setAppId(r8)     // Catch:{ BackendException -> 0x021c }
            org.json.JSONArray r8 = r12.getNotificationChannels()     // Catch:{ BackendException -> 0x021c }
            r7.setNotificationChannels(r8)     // Catch:{ BackendException -> 0x021c }
            java.lang.String r8 = r12.getGoogleProjectNumber()     // Catch:{ BackendException -> 0x021c }
            r7.setGoogleProjectNumber(r8)     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.FCMConfigModel r8 = r7.getFcmParams()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.backend.FCMParamsObject r9 = r12.getFcmParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.String r9 = r9.getProjectId()     // Catch:{ BackendException -> 0x021c }
            r8.setProjectId(r9)     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.FCMConfigModel r8 = r7.getFcmParams()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.backend.FCMParamsObject r9 = r12.getFcmParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.String r9 = r9.getAppId()     // Catch:{ BackendException -> 0x021c }
            r8.setAppId(r9)     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.FCMConfigModel r8 = r7.getFcmParams()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.backend.FCMParamsObject r9 = r12.getFcmParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.String r9 = r9.getApiKey()     // Catch:{ BackendException -> 0x021c }
            r8.setApiKey(r9)     // Catch:{ BackendException -> 0x021c }
            java.lang.Boolean r8 = r12.getEnterprise()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x00ea
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setEnterprise(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x00ea:
            java.lang.Boolean r8 = r12.getUseIdentityVerification()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x00f7
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setUseIdentityVerification(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x00f7:
            java.lang.Boolean r8 = r12.getFirebaseAnalytics()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0104
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setFirebaseAnalytics(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0104:
            java.lang.Boolean r8 = r12.getRestoreTTLFilter()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0111
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setRestoreTTLFilter(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0111:
            java.lang.Boolean r8 = r12.getClearGroupOnSummaryClick()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x011e
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setClearGroupOnSummaryClick(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x011e:
            java.lang.Boolean r8 = r12.getReceiveReceiptEnabled()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x012b
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setReceiveReceiptEnabled(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x012b:
            java.lang.Boolean r8 = r12.getDisableGMSMissingPrompt()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0138
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setDisableGMSMissingPrompt(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0138:
            java.lang.Boolean r8 = r12.getUnsubscribeWhenNotificationsDisabled()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0145
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setUnsubscribeWhenNotificationsDisabled(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0145:
            java.lang.Boolean r8 = r12.getLocationShared()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0152
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            r7.setLocationShared(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0152:
            java.lang.Boolean r8 = r12.getRequiresUserPrivacyConsent()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0163
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)     // Catch:{ BackendException -> 0x021c }
            r7.setConsentRequired(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0163:
            java.lang.Long r8 = r12.getOpRepoExecutionInterval()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0172
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ BackendException -> 0x021c }
            long r8 = r8.longValue()     // Catch:{ BackendException -> 0x021c }
            r7.setOpRepoExecutionInterval(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0172:
            com.onesignal.core.internal.backend.InfluenceParamsObject r8 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Integer r8 = r8.getNotificationLimit()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x0189
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ BackendException -> 0x021c }
            int r8 = r8.intValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r9 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r9.setNotificationLimit(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x0189:
            com.onesignal.core.internal.backend.InfluenceParamsObject r8 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Integer r8 = r8.getIndirectNotificationAttributionWindow()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x01a0
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ BackendException -> 0x021c }
            int r8 = r8.intValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r9 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r9.setIndirectNotificationAttributionWindow(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x01a0:
            com.onesignal.core.internal.backend.InfluenceParamsObject r8 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Integer r8 = r8.getIamLimit()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x01b7
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ BackendException -> 0x021c }
            int r8 = r8.intValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r9 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r9.setIamLimit(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x01b7:
            com.onesignal.core.internal.backend.InfluenceParamsObject r8 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Integer r8 = r8.getIndirectIAMAttributionWindow()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x01ce
            java.lang.Number r8 = (java.lang.Number) r8     // Catch:{ BackendException -> 0x021c }
            int r8 = r8.intValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r9 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r9.setIndirectIAMAttributionWindow(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x01ce:
            com.onesignal.core.internal.backend.InfluenceParamsObject r8 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Boolean r8 = r8.isDirectEnabled()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x01e3
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r9 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r9.setDirectEnabled(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x01e3:
            com.onesignal.core.internal.backend.InfluenceParamsObject r8 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Boolean r8 = r8.isIndirectEnabled()     // Catch:{ BackendException -> 0x021c }
            if (r8 == 0) goto L_0x01f8
            boolean r8 = r8.booleanValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r9 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r9.setIndirectEnabled(r8)     // Catch:{ BackendException -> 0x021c }
        L_0x01f8:
            com.onesignal.core.internal.backend.InfluenceParamsObject r12 = r12.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            java.lang.Boolean r12 = r12.isUnattributedEnabled()     // Catch:{ BackendException -> 0x021c }
            if (r12 == 0) goto L_0x020d
            boolean r12 = r12.booleanValue()     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.InfluenceConfigModel r8 = r7.getInfluenceParams()     // Catch:{ BackendException -> 0x021c }
            r8.setUnattributedEnabled(r12)     // Catch:{ BackendException -> 0x021c }
        L_0x020d:
            com.onesignal.core.internal.config.impl.ConfigModelStoreListener r12 = r1.this$0     // Catch:{ BackendException -> 0x021c }
            com.onesignal.core.internal.config.ConfigModelStore r12 = r12._configModelStore     // Catch:{ BackendException -> 0x021c }
            com.onesignal.common.modeling.Model r7 = (com.onesignal.common.modeling.Model) r7     // Catch:{ BackendException -> 0x021c }
            java.lang.String r8 = "HYDRATE"
            r12.replace(r7, r8)     // Catch:{ BackendException -> 0x021c }
            r12 = r5
            goto L_0x0268
        L_0x021c:
            r12 = move-exception
            goto L_0x0223
        L_0x021e:
            r6 = move-exception
            r10 = r4
            r4 = r12
            r12 = r6
            r6 = r10
        L_0x0223:
            int r12 = r12.getStatusCode()
            r7 = 403(0x193, float:5.65E-43)
            if (r12 != r7) goto L_0x0233
            java.lang.String r12 = "403 error getting OneSignal params, omitting further retries!"
            com.onesignal.debug.internal.logging.Logging.fatal$default(r12, r3, r2, r3)
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        L_0x0233:
            int r12 = r6 * 10000
            int r12 = r12 + 30000
            r7 = 90000(0x15f90, float:1.26117E-40)
            if (r12 <= r7) goto L_0x023d
            r12 = r7
        L_0x023d:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            java.lang.String r8 = "Failed to get Android parameters, trying again in "
            r7.<init>(r8)
            int r8 = r12 / 1000
            r7.append(r8)
            java.lang.String r8 = " seconds."
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.onesignal.debug.internal.logging.Logging.info$default(r7, r3, r2, r3)
            long r7 = (long) r12
            r12 = r1
            kotlin.coroutines.Continuation r12 = (kotlin.coroutines.Continuation) r12
            r1.I$0 = r6
            r1.I$1 = r4
            r1.label = r2
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.delay(r7, r12)
            if (r12 != r0) goto L_0x0266
            return r0
        L_0x0266:
            int r6 = r6 + r5
            r12 = r4
        L_0x0268:
            r4 = r6
            if (r12 == 0) goto L_0x004d
            kotlin.Unit r12 = kotlin.Unit.INSTANCE
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.config.impl.ConfigModelStoreListener$fetchParams$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
