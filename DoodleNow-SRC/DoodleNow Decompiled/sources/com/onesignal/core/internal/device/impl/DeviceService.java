package com.onesignal.core.internal.device.impl;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.device.IDeviceService;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 #2\u00020\u0001:\u0001#B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\b\u0010\u001c\u001a\u00020\u000eH\u0002J\b\u0010\u001d\u001a\u00020\u000eH\u0002J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u000eH\u0002J\b\u0010\"\u001a\u00020\u000eH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u000e8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0010R\u0014\u0010\u0017\u001a\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0010¨\u0006$"}, d2 = {"Lcom/onesignal/core/internal/device/impl/DeviceService;", "Lcom/onesignal/core/internal/device/IDeviceService;", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "androidSupportLibraryStatus", "Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "getAndroidSupportLibraryStatus", "()Lcom/onesignal/core/internal/device/IDeviceService$AndroidSupportLibraryStatus;", "deviceType", "Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "getDeviceType", "()Lcom/onesignal/core/internal/device/IDeviceService$DeviceType;", "hasAllHMSLibrariesForPushKit", "", "getHasAllHMSLibrariesForPushKit", "()Z", "hasFCMLibrary", "getHasFCMLibrary", "isAndroidDeviceType", "isFireOSDeviceType", "isGMSInstalledAndEnabled", "isHuaweiDeviceType", "supportsHMS", "getSupportsHMS", "hasHMSAGConnectLibrary", "hasHMSAvailabilityLibrary", "hasHMSPushKitLibrary", "isHMSCoreInstalledAndEnabled", "isHMSCoreInstalledAndEnabledFallback", "packageInstalledAndEnabled", "packageName", "", "supportsADM", "supportsGooglePush", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DeviceService.kt */
public final class DeviceService implements IDeviceService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String GOOGLE_PLAY_SERVICES_PACKAGE = "com.google.android.gms";
    private static final int HMS_AVAILABLE_SUCCESSFUL = 0;
    private static final String HMS_CORE_SERVICES_PACKAGE = "com.huawei.hwid";
    private final IApplicationService _applicationService;

    public DeviceService(IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        this._applicationService = iApplicationService;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/onesignal/core/internal/device/impl/DeviceService$Companion;", "", "()V", "GOOGLE_PLAY_SERVICES_PACKAGE", "", "HMS_AVAILABLE_SUCCESSFUL", "", "HMS_CORE_SERVICES_PACKAGE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DeviceService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public boolean isAndroidDeviceType() {
        return getDeviceType() == IDeviceService.DeviceType.Android;
    }

    public boolean isFireOSDeviceType() {
        return getDeviceType() == IDeviceService.DeviceType.Fire;
    }

    public boolean isHuaweiDeviceType() {
        return getDeviceType() == IDeviceService.DeviceType.Huawei;
    }

    public IDeviceService.DeviceType getDeviceType() {
        if (supportsADM()) {
            return IDeviceService.DeviceType.Fire;
        }
        if (supportsGooglePush()) {
            return IDeviceService.DeviceType.Android;
        }
        if (getSupportsHMS()) {
            return IDeviceService.DeviceType.Huawei;
        }
        if (isGMSInstalledAndEnabled()) {
            return IDeviceService.DeviceType.Android;
        }
        return isHMSCoreInstalledAndEnabledFallback() ? IDeviceService.DeviceType.Huawei : IDeviceService.DeviceType.Android;
    }

    public IDeviceService.AndroidSupportLibraryStatus getAndroidSupportLibraryStatus() {
        boolean hasWakefulBroadcastReceiver = AndroidUtils.INSTANCE.hasWakefulBroadcastReceiver();
        boolean hasNotificationManagerCompat = AndroidUtils.INSTANCE.hasNotificationManagerCompat();
        if (!hasWakefulBroadcastReceiver && !hasNotificationManagerCompat) {
            return IDeviceService.AndroidSupportLibraryStatus.MISSING;
        }
        if (!hasWakefulBroadcastReceiver || !hasNotificationManagerCompat) {
            return IDeviceService.AndroidSupportLibraryStatus.OUTDATED;
        }
        if (Build.VERSION.SDK_INT < 26 || AndroidUtils.INSTANCE.getTargetSdkVersion(this._applicationService.getAppContext()) < 26 || AndroidUtils.INSTANCE.hasJobIntentService()) {
            return IDeviceService.AndroidSupportLibraryStatus.OK;
        }
        return IDeviceService.AndroidSupportLibraryStatus.OUTDATED;
    }

    private final boolean supportsGooglePush() {
        if (!getHasFCMLibrary()) {
            return false;
        }
        return isGMSInstalledAndEnabled();
    }

    private final boolean isHMSCoreInstalledAndEnabledFallback() {
        return packageInstalledAndEnabled(HMS_CORE_SERVICES_PACKAGE);
    }

    public boolean isGMSInstalledAndEnabled() {
        return packageInstalledAndEnabled("com.google.android.gms");
    }

    private final boolean packageInstalledAndEnabled(String str) {
        try {
            return this._applicationService.getAppContext().getPackageManager().getPackageInfo(str, 128).applicationInfo.enabled;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public boolean getHasFCMLibrary() {
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessaging");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private final boolean getSupportsHMS() {
        if (!hasHMSAvailabilityLibrary() || !getHasAllHMSLibrariesForPushKit()) {
            return false;
        }
        return isHMSCoreInstalledAndEnabled();
    }

    private final boolean isHMSCoreInstalledAndEnabled() {
        try {
            Class<?> cls = Class.forName("com.huawei.hms.api.HuaweiApiAvailability");
            Method method = cls.getMethod("getInstance", new Class[0]);
            Object invoke = cls.getMethod("isHuaweiMobileServicesAvailable", new Class[]{Context.class}).invoke(method.invoke((Object) null, new Object[0]), new Object[]{this._applicationService.getAppContext()});
            Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type kotlin.Int");
            if (((Integer) invoke).intValue() == 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public boolean getHasAllHMSLibrariesForPushKit() {
        return hasHMSAGConnectLibrary() && hasHMSPushKitLibrary();
    }

    private final boolean hasHMSAGConnectLibrary() {
        try {
            Class.forName("com.huawei.agconnect.config.AGConnectServicesConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private final boolean hasHMSPushKitLibrary() {
        try {
            Class.forName("com.huawei.hms.aaid.HmsInstanceId");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private final boolean hasHMSAvailabilityLibrary() {
        try {
            Class.forName("com.huawei.hms.api.HuaweiApiAvailability");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private final boolean supportsADM() {
        try {
            Class.forName("com.amazon.device.messaging.ADM");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }
}
