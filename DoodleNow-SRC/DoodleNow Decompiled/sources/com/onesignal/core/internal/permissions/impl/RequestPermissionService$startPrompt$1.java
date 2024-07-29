package com.onesignal.core.internal.permissions.impl;

import android.app.Activity;
import android.content.Intent;
import com.onesignal.core.R;
import com.onesignal.core.activities.PermissionsActivity;
import com.onesignal.core.internal.application.IActivityLifecycleHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0007"}, d2 = {"com/onesignal/core/internal/permissions/impl/RequestPermissionService$startPrompt$1", "Lcom/onesignal/core/internal/application/IActivityLifecycleHandler;", "onActivityAvailable", "", "activity", "Landroid/app/Activity;", "onActivityStopped", "com.onesignal.core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RequestPermissionService.kt */
public final class RequestPermissionService$startPrompt$1 implements IActivityLifecycleHandler {
    final /* synthetic */ String $androidPermissionString;
    final /* synthetic */ Class<?> $callbackClass;
    final /* synthetic */ String $permissionRequestType;
    final /* synthetic */ RequestPermissionService this$0;

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    RequestPermissionService$startPrompt$1(RequestPermissionService requestPermissionService, String str, String str2, Class<?> cls) {
        this.this$0 = requestPermissionService;
        this.$permissionRequestType = str;
        this.$androidPermissionString = str2;
        this.$callbackClass = cls;
    }

    public void onActivityAvailable(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual((Object) activity.getClass(), (Object) PermissionsActivity.class)) {
            this.this$0._application.removeActivityLifecycleHandler(this);
            return;
        }
        Intent intent = new Intent(activity, PermissionsActivity.class);
        intent.setFlags(131072);
        intent.putExtra(PermissionsActivity.INTENT_EXTRA_PERMISSION_TYPE, this.$permissionRequestType).putExtra(PermissionsActivity.INTENT_EXTRA_ANDROID_PERMISSION_STRING, this.$androidPermissionString).putExtra(PermissionsActivity.INTENT_EXTRA_CALLBACK_CLASS, this.$callbackClass.getName());
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.onesignal_fade_in, R.anim.onesignal_fade_out);
    }
}
