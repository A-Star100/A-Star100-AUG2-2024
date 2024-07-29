package com.onesignal.core.internal.permissions.impl;

import android.app.Activity;
import com.onesignal.core.internal.application.IApplicationService;
import com.onesignal.core.internal.permissions.IRequestPermissionService;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\bJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\tH\u0016J0\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\f2\b\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\b2\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007j\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t`\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0014\u001a\u00020\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000e\"\u0004\b\u0016\u0010\u0010¨\u0006\""}, d2 = {"Lcom/onesignal/core/internal/permissions/impl/RequestPermissionService;", "Landroid/app/Activity;", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService;", "_application", "Lcom/onesignal/core/internal/application/IApplicationService;", "(Lcom/onesignal/core/internal/application/IApplicationService;)V", "callbackMap", "Ljava/util/HashMap;", "", "Lcom/onesignal/core/internal/permissions/IRequestPermissionService$PermissionCallback;", "Lkotlin/collections/HashMap;", "fallbackToSettings", "", "getFallbackToSettings", "()Z", "setFallbackToSettings", "(Z)V", "shouldShowRequestPermissionRationaleBeforeRequest", "getShouldShowRequestPermissionRationaleBeforeRequest", "setShouldShowRequestPermissionRationaleBeforeRequest", "waiting", "getWaiting", "setWaiting", "getCallback", "permissionType", "registerAsCallback", "", "callback", "startPrompt", "fallbackCondition", "permissionRequestType", "androidPermissionString", "callbackClass", "Ljava/lang/Class;", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RequestPermissionService.kt */
public final class RequestPermissionService extends Activity implements IRequestPermissionService {
    /* access modifiers changed from: private */
    public final IApplicationService _application;
    private final HashMap<String, IRequestPermissionService.PermissionCallback> callbackMap = new HashMap<>();
    private boolean fallbackToSettings;
    private boolean shouldShowRequestPermissionRationaleBeforeRequest;
    private boolean waiting;

    public final boolean getFallbackToSettings() {
        return this.fallbackToSettings;
    }

    public final boolean getShouldShowRequestPermissionRationaleBeforeRequest() {
        return this.shouldShowRequestPermissionRationaleBeforeRequest;
    }

    public final boolean getWaiting() {
        return this.waiting;
    }

    public final void setFallbackToSettings(boolean z) {
        this.fallbackToSettings = z;
    }

    public final void setShouldShowRequestPermissionRationaleBeforeRequest(boolean z) {
        this.shouldShowRequestPermissionRationaleBeforeRequest = z;
    }

    public final void setWaiting(boolean z) {
        this.waiting = z;
    }

    public RequestPermissionService(IApplicationService iApplicationService) {
        Intrinsics.checkNotNullParameter(iApplicationService, "_application");
        this._application = iApplicationService;
    }

    public void registerAsCallback(String str, IRequestPermissionService.PermissionCallback permissionCallback) {
        Intrinsics.checkNotNullParameter(str, "permissionType");
        Intrinsics.checkNotNullParameter(permissionCallback, "callback");
        this.callbackMap.put(str, permissionCallback);
    }

    public final IRequestPermissionService.PermissionCallback getCallback(String str) {
        Intrinsics.checkNotNullParameter(str, "permissionType");
        return this.callbackMap.get(str);
    }

    public void startPrompt(boolean z, String str, String str2, Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "callbackClass");
        if (!this.waiting) {
            this.fallbackToSettings = z;
            this._application.addActivityLifecycleHandler(new RequestPermissionService$startPrompt$1(this, str, str2, cls));
        }
    }
}
