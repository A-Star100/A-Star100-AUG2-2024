package com.onesignal.user.internal.backend;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0015\u0010\u000f\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001f\u0010\u001dR\u0015\u0010\u000e\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b \u0010\u0019R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0014R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Lcom/onesignal/user/internal/backend/SubscriptionObject;", "", "id", "", "type", "Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "token", "enabled", "", "notificationTypes", "", "sdk", "deviceModel", "deviceOS", "rooted", "netType", "carrier", "appVersion", "(Ljava/lang/String;Lcom/onesignal/user/internal/backend/SubscriptionObjectType;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getAppVersion", "()Ljava/lang/String;", "getCarrier", "getDeviceModel", "getDeviceOS", "getEnabled", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "getNetType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNotificationTypes", "getRooted", "getSdk", "getToken", "getType", "()Lcom/onesignal/user/internal/backend/SubscriptionObjectType;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SubscriptionObject.kt */
public final class SubscriptionObject {
    private final String appVersion;
    private final String carrier;
    private final String deviceModel;
    private final String deviceOS;
    private final Boolean enabled;
    private final String id;
    private final Integer netType;
    private final Integer notificationTypes;
    private final Boolean rooted;
    private final String sdk;
    private final String token;
    private final SubscriptionObjectType type;

    public SubscriptionObject() {
        this((String) null, (SubscriptionObjectType) null, (String) null, (Boolean) null, (Integer) null, (String) null, (String) null, (String) null, (Boolean) null, (Integer) null, (String) null, (String) null, 4095, (DefaultConstructorMarker) null);
    }

    public final String getAppVersion() {
        return this.appVersion;
    }

    public final String getCarrier() {
        return this.carrier;
    }

    public final String getDeviceModel() {
        return this.deviceModel;
    }

    public final String getDeviceOS() {
        return this.deviceOS;
    }

    public final Boolean getEnabled() {
        return this.enabled;
    }

    public final String getId() {
        return this.id;
    }

    public final Integer getNetType() {
        return this.netType;
    }

    public final Integer getNotificationTypes() {
        return this.notificationTypes;
    }

    public final Boolean getRooted() {
        return this.rooted;
    }

    public final String getSdk() {
        return this.sdk;
    }

    public final String getToken() {
        return this.token;
    }

    public final SubscriptionObjectType getType() {
        return this.type;
    }

    public SubscriptionObject(String str, SubscriptionObjectType subscriptionObjectType, String str2, Boolean bool, Integer num, String str3, String str4, String str5, Boolean bool2, Integer num2, String str6, String str7) {
        this.id = str;
        this.type = subscriptionObjectType;
        this.token = str2;
        this.enabled = bool;
        this.notificationTypes = num;
        this.sdk = str3;
        this.deviceModel = str4;
        this.deviceOS = str5;
        this.rooted = bool2;
        this.netType = num2;
        this.carrier = str6;
        this.appVersion = str7;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SubscriptionObject(java.lang.String r14, com.onesignal.user.internal.backend.SubscriptionObjectType r15, java.lang.String r16, java.lang.Boolean r17, java.lang.Integer r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.Boolean r22, java.lang.Integer r23, java.lang.String r24, java.lang.String r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r13 = this;
            r0 = r26
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r14
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r15
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0019
        L_0x0017:
            r4 = r16
        L_0x0019:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001f
            r5 = r2
            goto L_0x0021
        L_0x001f:
            r5 = r17
        L_0x0021:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0027
            r6 = r2
            goto L_0x0029
        L_0x0027:
            r6 = r18
        L_0x0029:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002f
            r7 = r2
            goto L_0x0031
        L_0x002f:
            r7 = r19
        L_0x0031:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0037
            r8 = r2
            goto L_0x0039
        L_0x0037:
            r8 = r20
        L_0x0039:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003f
            r9 = r2
            goto L_0x0041
        L_0x003f:
            r9 = r21
        L_0x0041:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0047
            r10 = r2
            goto L_0x0049
        L_0x0047:
            r10 = r22
        L_0x0049:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x004f
            r11 = r2
            goto L_0x0051
        L_0x004f:
            r11 = r23
        L_0x0051:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0057
            r12 = r2
            goto L_0x0059
        L_0x0057:
            r12 = r24
        L_0x0059:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r2 = r25
        L_0x0060:
            r14 = r13
            r15 = r1
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r22 = r9
            r23 = r10
            r24 = r11
            r25 = r12
            r26 = r2
            r14.<init>(r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.onesignal.user.internal.backend.SubscriptionObject.<init>(java.lang.String, com.onesignal.user.internal.backend.SubscriptionObjectType, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.Boolean, java.lang.Integer, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
