package com.onesignal.core.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.onesignal.OneSignal;
import com.onesignal.common.AndroidSupportV4Compat;
import com.onesignal.core.R;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import com.onesignal.core.internal.permissions.impl.RequestPermissionService;
import com.onesignal.core.internal.preferences.IPreferencesService;
import com.onesignal.core.internal.preferences.PreferenceOneSignalKeys;
import com.onesignal.core.internal.preferences.PreferenceStores;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\rH\u0014J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0014J+\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016¢\u0006\u0002\u0010\u001aJ\u0012\u0010\u001b\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/onesignal/core/activities/PermissionsActivity;", "Landroid/app/Activity;", "()V", "androidPermissionString", "", "permissionRequestType", "preferenceService", "Lcom/onesignal/core/internal/preferences/IPreferencesService;", "requestPermissionService", "Lcom/onesignal/core/internal/permissions/impl/RequestPermissionService;", "handleBundleParams", "", "extras", "Landroid/os/Bundle;", "onCreate", "savedInstanceState", "onNewIntent", "intent", "Landroid/content/Intent;", "onRequestPermissionsResult", "requestCode", "", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "requestPermission", "reregisterCallbackHandlers", "shouldShowSettings", "", "Companion", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PermissionsActivity.kt */
public final class PermissionsActivity extends Activity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int DELAY_TIME_CALLBACK_CALL = 500;
    public static final String INTENT_EXTRA_ANDROID_PERMISSION_STRING = "INTENT_EXTRA_ANDROID_PERMISSION_STRING";
    public static final String INTENT_EXTRA_CALLBACK_CLASS = "INTENT_EXTRA_CALLBACK_CLASS";
    public static final String INTENT_EXTRA_PERMISSION_TYPE = "INTENT_EXTRA_PERMISSION_TYPE";
    public static final int ONESIGNAL_PERMISSION_REQUEST_CODE = 2;
    private String androidPermissionString;
    private String permissionRequestType;
    private IPreferencesService preferenceService;
    private RequestPermissionService requestPermissionService;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (OneSignal.initWithContext(this)) {
            this.requestPermissionService = (RequestPermissionService) OneSignal.INSTANCE.getServices().getService(RequestPermissionService.class);
            this.preferenceService = (IPreferencesService) OneSignal.INSTANCE.getServices().getService(IPreferencesService.class);
            handleBundleParams(getIntent().getExtras());
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        handleBundleParams(intent.getExtras());
    }

    private final void handleBundleParams(Bundle bundle) {
        reregisterCallbackHandlers(bundle);
        Intrinsics.checkNotNull(bundle);
        this.permissionRequestType = bundle.getString(INTENT_EXTRA_PERMISSION_TYPE);
        String string = bundle.getString(INTENT_EXTRA_ANDROID_PERMISSION_STRING);
        this.androidPermissionString = string;
        requestPermission(string);
    }

    private final void reregisterCallbackHandlers(Bundle bundle) {
        Intrinsics.checkNotNull(bundle);
        String string = bundle.getString(INTENT_EXTRA_CALLBACK_CLASS);
        try {
            Class.forName(string);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Could not find callback class for PermissionActivity: " + string);
        }
    }

    private final void requestPermission(String str) {
        RequestPermissionService requestPermissionService2 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService2);
        if (!requestPermissionService2.getWaiting()) {
            RequestPermissionService requestPermissionService3 = this.requestPermissionService;
            Intrinsics.checkNotNull(requestPermissionService3);
            requestPermissionService3.setWaiting(true);
            RequestPermissionService requestPermissionService4 = this.requestPermissionService;
            Intrinsics.checkNotNull(requestPermissionService4);
            Activity activity = this;
            requestPermissionService4.setShouldShowRequestPermissionRationaleBeforeRequest(AndroidSupportV4Compat.ActivityCompat.INSTANCE.shouldShowRequestPermissionRationale(activity, str));
            AndroidSupportV4Compat.ActivityCompat.INSTANCE.requestPermissions(activity, new String[]{str}, 2);
        }
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        RequestPermissionService requestPermissionService2 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService2);
        requestPermissionService2.setWaiting(false);
        if (i == 2) {
            new Handler().postDelayed(new PermissionsActivity$$ExternalSyntheticLambda0(iArr, this), 500);
        }
        finish();
        overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
    }

    /* access modifiers changed from: private */
    /* renamed from: onRequestPermissionsResult$lambda-0  reason: not valid java name */
    public static final void m1025onRequestPermissionsResult$lambda0(int[] iArr, PermissionsActivity permissionsActivity) {
        Intrinsics.checkNotNullParameter(iArr, "$grantResults");
        Intrinsics.checkNotNullParameter(permissionsActivity, "this$0");
        boolean z = false;
        if (iArr.length > 0 && iArr[0] == 0) {
            z = true;
        }
        RequestPermissionService requestPermissionService2 = permissionsActivity.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService2);
        String str = permissionsActivity.permissionRequestType;
        Intrinsics.checkNotNull(str);
        IRequestPermissionService.PermissionCallback callback = requestPermissionService2.getCallback(str);
        if (callback == null) {
            throw new RuntimeException("Missing handler for permissionRequestType: " + permissionsActivity.permissionRequestType);
        } else if (z) {
            callback.onAccept();
            IPreferencesService iPreferencesService = permissionsActivity.preferenceService;
            Intrinsics.checkNotNull(iPreferencesService);
            iPreferencesService.saveBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_USER_RESOLVED_PERMISSION_PREFIX + permissionsActivity.androidPermissionString, true);
        } else {
            callback.onReject(permissionsActivity.shouldShowSettings());
        }
    }

    private final boolean shouldShowSettings() {
        RequestPermissionService requestPermissionService2 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService2);
        if (!requestPermissionService2.getFallbackToSettings()) {
            return false;
        }
        RequestPermissionService requestPermissionService3 = this.requestPermissionService;
        Intrinsics.checkNotNull(requestPermissionService3);
        if (!requestPermissionService3.getShouldShowRequestPermissionRationaleBeforeRequest() || AndroidSupportV4Compat.ActivityCompat.INSTANCE.shouldShowRequestPermissionRationale(this, this.androidPermissionString)) {
            IPreferencesService iPreferencesService = this.preferenceService;
            Intrinsics.checkNotNull(iPreferencesService);
            Boolean bool = iPreferencesService.getBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_USER_RESOLVED_PERMISSION_PREFIX + this.androidPermissionString, false);
            Intrinsics.checkNotNull(bool);
            return bool.booleanValue();
        }
        IPreferencesService iPreferencesService2 = this.preferenceService;
        Intrinsics.checkNotNull(iPreferencesService2);
        iPreferencesService2.saveBool(PreferenceStores.ONESIGNAL, PreferenceOneSignalKeys.PREFS_OS_USER_RESOLVED_PERMISSION_PREFIX + this.androidPermissionString, true);
        return false;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/onesignal/core/activities/PermissionsActivity$Companion;", "", "()V", "DELAY_TIME_CALLBACK_CALL", "", "INTENT_EXTRA_ANDROID_PERMISSION_STRING", "", "INTENT_EXTRA_CALLBACK_CLASS", "INTENT_EXTRA_PERMISSION_TYPE", "ONESIGNAL_PERMISSION_REQUEST_CODE", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PermissionsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
