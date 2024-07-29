package com.onesignal.common;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\u0002\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/onesignal/common/OneSignalWrapper;", "", "()V", "sdkType", "", "getSdkType$annotations", "getSdkType", "()Ljava/lang/String;", "setSdkType", "(Ljava/lang/String;)V", "sdkVersion", "getSdkVersion$annotations", "getSdkVersion", "setSdkVersion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OneSignalWrapper.kt */
public final class OneSignalWrapper {
    public static final OneSignalWrapper INSTANCE = new OneSignalWrapper();
    private static String sdkType;
    private static String sdkVersion;

    public static final String getSdkType() {
        return sdkType;
    }

    @JvmStatic
    public static /* synthetic */ void getSdkType$annotations() {
    }

    public static final String getSdkVersion() {
        return sdkVersion;
    }

    @JvmStatic
    public static /* synthetic */ void getSdkVersion$annotations() {
    }

    public static final void setSdkType(String str) {
        sdkType = str;
    }

    public static final void setSdkVersion(String str) {
        sdkVersion = str;
    }

    private OneSignalWrapper() {
    }
}
