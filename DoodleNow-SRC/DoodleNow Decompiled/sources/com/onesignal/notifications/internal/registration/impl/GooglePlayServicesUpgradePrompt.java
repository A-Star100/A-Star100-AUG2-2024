package com.onesignal.notifications.internal.registration.impl;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.pm.PackageManager;
import com.google.android.gms.common.GoogleApiAvailability;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.config.ConfigModel;
import com.onesignal.core.internal.config.ConfigModelStore;
import com.onesignal.core.internal.device.IDeviceService;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0011\u0010\u0010\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u00020\n8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt;", "", "_applicationService", "Lcom/onesignal/core/internal/application/IApplicationService;", "_deviceService", "Lcom/onesignal/core/internal/device/IDeviceService;", "_configModelStore", "Lcom/onesignal/core/internal/config/ConfigModelStore;", "(Lcom/onesignal/core/internal/application/IApplicationService;Lcom/onesignal/core/internal/device/IDeviceService;Lcom/onesignal/core/internal/config/ConfigModelStore;)V", "isGooglePlayStoreInstalled", "", "()Z", "openPlayStoreToApp", "", "activity", "Landroid/app/Activity;", "showUpdateGPSDialog", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GooglePlayServicesUpgradePrompt.kt */
public final class GooglePlayServicesUpgradePrompt {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    /* access modifiers changed from: private */
    public final IApplicationService _applicationService;
    /* access modifiers changed from: private */
    public final ConfigModelStore _configModelStore;
    private final IDeviceService _deviceService;

    public GooglePlayServicesUpgradePrompt(IApplicationService iApplicationService, IDeviceService iDeviceService, ConfigModelStore configModelStore) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_applicationService");
        Intrinsics.checkNotNullParameter(iDeviceService, "_deviceService");
        Intrinsics.checkNotNullParameter(configModelStore, "_configModelStore");
        this._applicationService = iApplicationService;
        this._deviceService = iDeviceService;
        this._configModelStore = configModelStore;
    }

    private final boolean isGooglePlayStoreInstalled() {
        try {
            PackageManager packageManager = this._applicationService.getAppContext().getPackageManager();
            CharSequence loadLabel = packageManager.getPackageInfo("com.google.android.gms", 128).applicationInfo.loadLabel(packageManager);
            Intrinsics.checkNotNull(loadLabel, "null cannot be cast to non-null type kotlin.String");
            return !Intrinsics.areEqual((Object) (String) loadLabel, (Object) "Market");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final Object showUpdateGPSDialog(Continuation<? super Unit> continuation) {
        if (!this._deviceService.isAndroidDeviceType()) {
            return Unit.INSTANCE;
        }
        if (!isGooglePlayStoreInstalled() || ((ConfigModel) this._configModelStore.getModel()).getDisableGMSMissingPrompt() || ((ConfigModel) this._configModelStore.getModel()).getUserRejectedGMSUpdate()) {
            return Unit.INSTANCE;
        }
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2(this, (Continuation<? super GooglePlayServicesUpgradePrompt$showUpdateGPSDialog$2>) null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void openPlayStoreToApp(Activity activity) {
        try {
            GoogleApiAvailability instance = GoogleApiAvailability.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance()");
            PendingIntent errorResolutionPendingIntent = instance.getErrorResolutionPendingIntent(activity, instance.isGooglePlayServicesAvailable(this._applicationService.getAppContext()), PLAY_SERVICES_RESOLUTION_REQUEST);
            if (errorResolutionPendingIntent != null) {
                errorResolutionPendingIntent.send();
            }
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/onesignal/notifications/internal/registration/impl/GooglePlayServicesUpgradePrompt$Companion;", "", "()V", "PLAY_SERVICES_RESOLUTION_REQUEST", "", "com.onesignal.notifications"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GooglePlayServicesUpgradePrompt.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
