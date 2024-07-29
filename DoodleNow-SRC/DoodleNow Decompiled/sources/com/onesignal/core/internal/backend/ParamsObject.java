package com.onesignal.core.internal.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b.\u0018\u00002\u00020\u0001B±\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\r\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001f\u0010\u0019\"\u0004\b \u0010\u001bR\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b%\u0010\u0019\"\u0004\b&\u0010\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010\f\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b:\u0010\u0019\"\u0004\b;\u0010\u001bR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b<\u0010\u0019\"\u0004\b=\u0010\u001bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b>\u0010\u0019\"\u0004\b?\u0010\u001bR\u001e\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b@\u0010\u0019\"\u0004\bA\u0010\u001bR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\bB\u0010\u0019\"\u0004\bC\u0010\u001b¨\u0006D"}, d2 = {"Lcom/onesignal/core/internal/backend/ParamsObject;", "", "googleProjectNumber", "", "enterprise", "", "useIdentityVerification", "notificationChannels", "Lorg/json/JSONArray;", "firebaseAnalytics", "restoreTTLFilter", "clearGroupOnSummaryClick", "receiveReceiptEnabled", "disableGMSMissingPrompt", "unsubscribeWhenNotificationsDisabled", "locationShared", "requiresUserPrivacyConsent", "opRepoExecutionInterval", "", "influenceParams", "Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "fcmParams", "Lcom/onesignal/core/internal/backend/FCMParamsObject;", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Lorg/json/JSONArray;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Long;Lcom/onesignal/core/internal/backend/InfluenceParamsObject;Lcom/onesignal/core/internal/backend/FCMParamsObject;)V", "getClearGroupOnSummaryClick", "()Ljava/lang/Boolean;", "setClearGroupOnSummaryClick", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getDisableGMSMissingPrompt", "setDisableGMSMissingPrompt", "getEnterprise", "setEnterprise", "getFcmParams", "()Lcom/onesignal/core/internal/backend/FCMParamsObject;", "setFcmParams", "(Lcom/onesignal/core/internal/backend/FCMParamsObject;)V", "getFirebaseAnalytics", "setFirebaseAnalytics", "getGoogleProjectNumber", "()Ljava/lang/String;", "setGoogleProjectNumber", "(Ljava/lang/String;)V", "getInfluenceParams", "()Lcom/onesignal/core/internal/backend/InfluenceParamsObject;", "setInfluenceParams", "(Lcom/onesignal/core/internal/backend/InfluenceParamsObject;)V", "getLocationShared", "setLocationShared", "getNotificationChannels", "()Lorg/json/JSONArray;", "setNotificationChannels", "(Lorg/json/JSONArray;)V", "getOpRepoExecutionInterval", "()Ljava/lang/Long;", "setOpRepoExecutionInterval", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getReceiveReceiptEnabled", "setReceiveReceiptEnabled", "getRequiresUserPrivacyConsent", "setRequiresUserPrivacyConsent", "getRestoreTTLFilter", "setRestoreTTLFilter", "getUnsubscribeWhenNotificationsDisabled", "setUnsubscribeWhenNotificationsDisabled", "getUseIdentityVerification", "setUseIdentityVerification", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: IParamsBackendService.kt */
public final class ParamsObject {
    private Boolean clearGroupOnSummaryClick;
    private Boolean disableGMSMissingPrompt;
    private Boolean enterprise;
    private FCMParamsObject fcmParams;
    private Boolean firebaseAnalytics;
    private String googleProjectNumber;
    private InfluenceParamsObject influenceParams;
    private Boolean locationShared;
    private JSONArray notificationChannels;
    private Long opRepoExecutionInterval;
    private Boolean receiveReceiptEnabled;
    private Boolean requiresUserPrivacyConsent;
    private Boolean restoreTTLFilter;
    private Boolean unsubscribeWhenNotificationsDisabled;
    private Boolean useIdentityVerification;

    public final Boolean getClearGroupOnSummaryClick() {
        return this.clearGroupOnSummaryClick;
    }

    public final Boolean getDisableGMSMissingPrompt() {
        return this.disableGMSMissingPrompt;
    }

    public final Boolean getEnterprise() {
        return this.enterprise;
    }

    public final FCMParamsObject getFcmParams() {
        return this.fcmParams;
    }

    public final Boolean getFirebaseAnalytics() {
        return this.firebaseAnalytics;
    }

    public final String getGoogleProjectNumber() {
        return this.googleProjectNumber;
    }

    public final InfluenceParamsObject getInfluenceParams() {
        return this.influenceParams;
    }

    public final Boolean getLocationShared() {
        return this.locationShared;
    }

    public final JSONArray getNotificationChannels() {
        return this.notificationChannels;
    }

    public final Long getOpRepoExecutionInterval() {
        return this.opRepoExecutionInterval;
    }

    public final Boolean getReceiveReceiptEnabled() {
        return this.receiveReceiptEnabled;
    }

    public final Boolean getRequiresUserPrivacyConsent() {
        return this.requiresUserPrivacyConsent;
    }

    public final Boolean getRestoreTTLFilter() {
        return this.restoreTTLFilter;
    }

    public final Boolean getUnsubscribeWhenNotificationsDisabled() {
        return this.unsubscribeWhenNotificationsDisabled;
    }

    public final Boolean getUseIdentityVerification() {
        return this.useIdentityVerification;
    }

    public final void setClearGroupOnSummaryClick(Boolean bool) {
        this.clearGroupOnSummaryClick = bool;
    }

    public final void setDisableGMSMissingPrompt(Boolean bool) {
        this.disableGMSMissingPrompt = bool;
    }

    public final void setEnterprise(Boolean bool) {
        this.enterprise = bool;
    }

    public final void setFcmParams(FCMParamsObject fCMParamsObject) {
        Intrinsics.checkNotNullParameter(fCMParamsObject, "<set-?>");
        this.fcmParams = fCMParamsObject;
    }

    public final void setFirebaseAnalytics(Boolean bool) {
        this.firebaseAnalytics = bool;
    }

    public final void setGoogleProjectNumber(String str) {
        this.googleProjectNumber = str;
    }

    public final void setInfluenceParams(InfluenceParamsObject influenceParamsObject) {
        Intrinsics.checkNotNullParameter(influenceParamsObject, "<set-?>");
        this.influenceParams = influenceParamsObject;
    }

    public final void setLocationShared(Boolean bool) {
        this.locationShared = bool;
    }

    public final void setNotificationChannels(JSONArray jSONArray) {
        this.notificationChannels = jSONArray;
    }

    public final void setOpRepoExecutionInterval(Long l) {
        this.opRepoExecutionInterval = l;
    }

    public final void setReceiveReceiptEnabled(Boolean bool) {
        this.receiveReceiptEnabled = bool;
    }

    public final void setRequiresUserPrivacyConsent(Boolean bool) {
        this.requiresUserPrivacyConsent = bool;
    }

    public final void setRestoreTTLFilter(Boolean bool) {
        this.restoreTTLFilter = bool;
    }

    public final void setUnsubscribeWhenNotificationsDisabled(Boolean bool) {
        this.unsubscribeWhenNotificationsDisabled = bool;
    }

    public final void setUseIdentityVerification(Boolean bool) {
        this.useIdentityVerification = bool;
    }

    public ParamsObject(String str, Boolean bool, Boolean bool2, JSONArray jSONArray, Boolean bool3, Boolean bool4, Boolean bool5, Boolean bool6, Boolean bool7, Boolean bool8, Boolean bool9, Boolean bool10, Long l, InfluenceParamsObject influenceParamsObject, FCMParamsObject fCMParamsObject) {
        InfluenceParamsObject influenceParamsObject2 = influenceParamsObject;
        FCMParamsObject fCMParamsObject2 = fCMParamsObject;
        Intrinsics.checkNotNullParameter(influenceParamsObject2, "influenceParams");
        Intrinsics.checkNotNullParameter(fCMParamsObject2, "fcmParams");
        this.googleProjectNumber = str;
        this.enterprise = bool;
        this.useIdentityVerification = bool2;
        this.notificationChannels = jSONArray;
        this.firebaseAnalytics = bool3;
        this.restoreTTLFilter = bool4;
        this.clearGroupOnSummaryClick = bool5;
        this.receiveReceiptEnabled = bool6;
        this.disableGMSMissingPrompt = bool7;
        this.unsubscribeWhenNotificationsDisabled = bool8;
        this.locationShared = bool9;
        this.requiresUserPrivacyConsent = bool10;
        this.opRepoExecutionInterval = l;
        this.influenceParams = influenceParamsObject2;
        this.fcmParams = fCMParamsObject2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ParamsObject(java.lang.String r20, java.lang.Boolean r21, java.lang.Boolean r22, org.json.JSONArray r23, java.lang.Boolean r24, java.lang.Boolean r25, java.lang.Boolean r26, java.lang.Boolean r27, java.lang.Boolean r28, java.lang.Boolean r29, java.lang.Boolean r30, java.lang.Boolean r31, java.lang.Long r32, com.onesignal.core.internal.backend.InfluenceParamsObject r33, com.onesignal.core.internal.backend.FCMParamsObject r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r19 = this;
            r0 = r35
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r20
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r21
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r22
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r23
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r24
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r25
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r26
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r27
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0049
            r12 = r2
            goto L_0x004b
        L_0x0049:
            r12 = r28
        L_0x004b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0051
            r13 = r2
            goto L_0x0053
        L_0x0051:
            r13 = r29
        L_0x0053:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x0059
            r14 = r2
            goto L_0x005b
        L_0x0059:
            r14 = r30
        L_0x005b:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0061
            r15 = r2
            goto L_0x0063
        L_0x0061:
            r15 = r31
        L_0x0063:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x006a
            r16 = r2
            goto L_0x006c
        L_0x006a:
            r16 = r32
        L_0x006c:
            r3 = r19
            r17 = r33
            r18 = r34
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.core.internal.backend.ParamsObject.<init>(java.lang.String, java.lang.Boolean, java.lang.Boolean, org.json.JSONArray, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Boolean, java.lang.Long, com.onesignal.core.internal.backend.InfluenceParamsObject, com.onesignal.core.internal.backend.FCMParamsObject, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
