package com.revenuecat.purchases.common;

import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.Store;
import java.net.URL;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 ;2\u00020\u0001:\u0001;B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012J\u0013\u00106\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u00108\u001a\u000209H\u0016J\b\u0010:\u001a\u00020&H\u0016R\u0011\u0010\u0013\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0016\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010 R\u001c\u0010\u0010\u001a\u00020\u00058FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010 R\u001c\u0010\u0011\u001a\u00020\u00058FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010 R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010(R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b.\u0010(R\u0013\u0010/\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\b0\u0010(R\u000e\u0010\u000f\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u00104\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b5\u0010(¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig;", "", "context", "Landroid/content/Context;", "observerMode", "", "showInAppMessagesAutomatically", "platformInfo", "Lcom/revenuecat/purchases/common/PlatformInfo;", "proxyURL", "Ljava/net/URL;", "store", "Lcom/revenuecat/purchases/Store;", "dangerousSettings", "Lcom/revenuecat/purchases/DangerousSettings;", "runningTests", "forceServerErrors", "forceSigningErrors", "(Landroid/content/Context;ZZLcom/revenuecat/purchases/common/PlatformInfo;Ljava/net/URL;Lcom/revenuecat/purchases/Store;Lcom/revenuecat/purchases/DangerousSettings;ZZZ)V", "baseURL", "getBaseURL", "()Ljava/net/URL;", "customEntitlementComputation", "getCustomEntitlementComputation", "()Z", "getDangerousSettings", "()Lcom/revenuecat/purchases/DangerousSettings;", "enableOfflineEntitlements", "getEnableOfflineEntitlements", "finishTransactions", "getFinishTransactions", "setFinishTransactions", "(Z)V", "getForceServerErrors", "setForceServerErrors", "getForceSigningErrors", "setForceSigningErrors", "languageTag", "", "getLanguageTag", "()Ljava/lang/String;", "packageName", "getPackageName", "getPlatformInfo", "()Lcom/revenuecat/purchases/common/PlatformInfo;", "playServicesVersionName", "getPlayServicesVersionName", "playStoreVersionName", "getPlayStoreVersionName", "getShowInAppMessagesAutomatically", "getStore", "()Lcom/revenuecat/purchases/Store;", "versionName", "getVersionName", "equals", "other", "hashCode", "", "toString", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppConfig.kt */
public final class AppConfig {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final URL diagnosticsURL = new URL("https://api-diagnostics.revenuecat.com/");
    /* access modifiers changed from: private */
    public static final URL paywallEventsURL = new URL("https://api-paywalls.revenuecat.com/");
    private final URL baseURL;
    private final DangerousSettings dangerousSettings;
    private final boolean enableOfflineEntitlements;
    private boolean finishTransactions;
    private boolean forceServerErrors;
    private boolean forceSigningErrors;
    private final String languageTag;
    private final String packageName;
    private final PlatformInfo platformInfo;
    private final String playServicesVersionName;
    private final String playStoreVersionName;
    private final boolean runningTests;
    private final boolean showInAppMessagesAutomatically;
    private final Store store;
    private final String versionName;

    public final URL getBaseURL() {
        return this.baseURL;
    }

    public final DangerousSettings getDangerousSettings() {
        return this.dangerousSettings;
    }

    public final boolean getEnableOfflineEntitlements() {
        return this.enableOfflineEntitlements;
    }

    public final boolean getFinishTransactions() {
        return this.finishTransactions;
    }

    public final boolean getForceServerErrors() {
        return this.runningTests && this.forceServerErrors;
    }

    public final boolean getForceSigningErrors() {
        return this.runningTests && this.forceSigningErrors;
    }

    public final String getLanguageTag() {
        return this.languageTag;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final PlatformInfo getPlatformInfo() {
        return this.platformInfo;
    }

    public final String getPlayServicesVersionName() {
        return this.playServicesVersionName;
    }

    public final String getPlayStoreVersionName() {
        return this.playStoreVersionName;
    }

    public final boolean getShowInAppMessagesAutomatically() {
        return this.showInAppMessagesAutomatically;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getVersionName() {
        return this.versionName;
    }

    public final void setFinishTransactions(boolean z) {
        this.finishTransactions = z;
    }

    public final void setForceServerErrors(boolean z) {
        this.forceServerErrors = z;
    }

    public final void setForceSigningErrors(boolean z) {
        this.forceSigningErrors = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0030, code lost:
        r5 = com.revenuecat.purchases.common.UtilsKt.toBCP47(r5);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AppConfig(android.content.Context r2, boolean r3, boolean r4, com.revenuecat.purchases.common.PlatformInfo r5, java.net.URL r6, com.revenuecat.purchases.Store r7, com.revenuecat.purchases.DangerousSettings r8, boolean r9, boolean r10, boolean r11) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "platformInfo"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "store"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "dangerousSettings"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r1.<init>()
            r1.showInAppMessagesAutomatically = r4
            r1.platformInfo = r5
            r1.store = r7
            r1.dangerousSettings = r8
            r1.runningTests = r9
            r1.forceServerErrors = r10
            r1.forceSigningErrors = r11
            r4 = 1
            r1.enableOfflineEntitlements = r4
            java.util.Locale r5 = com.revenuecat.purchases.common.UtilsKt.getLocale(r2)
            java.lang.String r7 = ""
            if (r5 == 0) goto L_0x0036
            java.lang.String r5 = com.revenuecat.purchases.common.UtilsKt.toBCP47(r5)
            if (r5 != 0) goto L_0x0037
        L_0x0036:
            r5 = r7
        L_0x0037:
            r1.languageTag = r5
            java.lang.String r5 = com.revenuecat.purchases.common.UtilsKt.getVersionName(r2)
            if (r5 != 0) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r7 = r5
        L_0x0041:
            r1.versionName = r7
            java.lang.String r5 = r2.getPackageName()
            java.lang.String r7 = "context.packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r7)
            r1.packageName = r5
            r3 = r3 ^ r4
            r1.finishTransactions = r3
            if (r6 == 0) goto L_0x005b
            com.revenuecat.purchases.common.LogIntent r3 = com.revenuecat.purchases.common.LogIntent.INFO
            java.lang.String r4 = "Purchases is being configured using a proxy for RevenueCat"
            com.revenuecat.purchases.common.LogWrapperKt.log(r3, r4)
            goto L_0x0062
        L_0x005b:
            java.net.URL r6 = new java.net.URL
            java.lang.String r3 = "https://api.revenuecat.com/"
            r6.<init>(r3)
        L_0x0062:
            r1.baseURL = r6
            java.lang.String r3 = com.revenuecat.purchases.common.UtilsKt.getPlayStoreVersionName(r2)
            r1.playStoreVersionName = r3
            java.lang.String r2 = com.revenuecat.purchases.common.UtilsKt.getPlayServicesVersionName(r2)
            r1.playServicesVersionName = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.AppConfig.<init>(android.content.Context, boolean, boolean, com.revenuecat.purchases.common.PlatformInfo, java.net.URL, com.revenuecat.purchases.Store, com.revenuecat.purchases.DangerousSettings, boolean, boolean, boolean):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AppConfig(android.content.Context r15, boolean r16, boolean r17, com.revenuecat.purchases.common.PlatformInfo r18, java.net.URL r19, com.revenuecat.purchases.Store r20, com.revenuecat.purchases.DangerousSettings r21, boolean r22, boolean r23, boolean r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
        /*
            r14 = this;
            r0 = r25
            r1 = r0 & 64
            if (r1 == 0) goto L_0x000e
            com.revenuecat.purchases.DangerousSettings r1 = new com.revenuecat.purchases.DangerousSettings
            r2 = 1
            r1.<init>(r2)
            r10 = r1
            goto L_0x0010
        L_0x000e:
            r10 = r21
        L_0x0010:
            r1 = r0 & 128(0x80, float:1.794E-43)
            r2 = 0
            if (r1 == 0) goto L_0x0017
            r11 = r2
            goto L_0x0019
        L_0x0017:
            r11 = r22
        L_0x0019:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x001f
            r12 = r2
            goto L_0x0021
        L_0x001f:
            r12 = r23
        L_0x0021:
            r0 = r0 & 512(0x200, float:7.175E-43)
            if (r0 == 0) goto L_0x0027
            r13 = r2
            goto L_0x0029
        L_0x0027:
            r13 = r24
        L_0x0029:
            r3 = r14
            r4 = r15
            r5 = r16
            r6 = r17
            r7 = r18
            r8 = r19
            r9 = r20
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.AppConfig.<init>(android.content.Context, boolean, boolean, com.revenuecat.purchases.common.PlatformInfo, java.net.URL, com.revenuecat.purchases.Store, com.revenuecat.purchases.DangerousSettings, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/revenuecat/purchases/common/AppConfig$Companion;", "", "()V", "diagnosticsURL", "Ljava/net/URL;", "getDiagnosticsURL", "()Ljava/net/URL;", "paywallEventsURL", "getPaywallEventsURL", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: AppConfig.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final URL getDiagnosticsURL() {
            return AppConfig.diagnosticsURL;
        }

        public final URL getPaywallEventsURL() {
            return AppConfig.paywallEventsURL;
        }
    }

    public final boolean getCustomEntitlementComputation() {
        return this.dangerousSettings.getCustomEntitlementComputation$purchases_defaultsRelease();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.AppConfig");
        AppConfig appConfig = (AppConfig) obj;
        return Intrinsics.areEqual((Object) this.platformInfo, (Object) appConfig.platformInfo) && this.store == appConfig.store && Intrinsics.areEqual((Object) this.dangerousSettings, (Object) appConfig.dangerousSettings) && Intrinsics.areEqual((Object) this.languageTag, (Object) appConfig.languageTag) && Intrinsics.areEqual((Object) this.versionName, (Object) appConfig.versionName) && Intrinsics.areEqual((Object) this.packageName, (Object) appConfig.packageName) && this.finishTransactions == appConfig.finishTransactions && getForceServerErrors() == appConfig.getForceServerErrors() && getForceSigningErrors() == appConfig.getForceSigningErrors() && Intrinsics.areEqual((Object) this.baseURL, (Object) appConfig.baseURL) && this.showInAppMessagesAutomatically == appConfig.showInAppMessagesAutomatically;
    }

    public int hashCode() {
        return (((((((((((((((((((this.platformInfo.hashCode() * 31) + this.store.hashCode()) * 31) + this.dangerousSettings.hashCode()) * 31) + this.languageTag.hashCode()) * 31) + this.versionName.hashCode()) * 31) + this.packageName.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.finishTransactions)) * 31) + UByte$$ExternalSyntheticBackport0.m(getForceServerErrors())) * 31) + UByte$$ExternalSyntheticBackport0.m(getForceSigningErrors())) * 31) + this.baseURL.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.showInAppMessagesAutomatically);
    }

    public String toString() {
        return "AppConfig(platformInfo=" + this.platformInfo + ", store=" + this.store + ", dangerousSettings=" + this.dangerousSettings + ", languageTag='" + this.languageTag + "', versionName='" + this.versionName + "', packageName='" + this.packageName + "', finishTransactions=" + this.finishTransactions + ", showInAppMessagesAutomatically=" + this.showInAppMessagesAutomatically + ", baseURL=" + this.baseURL + ')';
    }
}
