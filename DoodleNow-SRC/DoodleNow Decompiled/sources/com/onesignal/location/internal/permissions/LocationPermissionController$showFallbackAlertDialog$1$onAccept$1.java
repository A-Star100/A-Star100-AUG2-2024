package com.onesignal.location.internal.permissions;

import com.onesignal.common.AndroidUtils;
import com.onesignal.core.internal.application.ApplicationLifecycleHandlerBase;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/onesignal/location/internal/permissions/LocationPermissionController$showFallbackAlertDialog$1$onAccept$1", "Lcom/onesignal/core/internal/application/ApplicationLifecycleHandlerBase;", "onFocus", "", "firedOnSubscribe", "", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationPermissionController.kt */
public final class LocationPermissionController$showFallbackAlertDialog$1$onAccept$1 extends ApplicationLifecycleHandlerBase {
    final /* synthetic */ LocationPermissionController this$0;

    LocationPermissionController$showFallbackAlertDialog$1$onAccept$1(LocationPermissionController locationPermissionController) {
        this.this$0 = locationPermissionController;
    }

    public void onFocus(boolean z) {
        if (!z) {
            super.onFocus(false);
            this.this$0._applicationService.removeApplicationLifecycleHandler(this);
            boolean hasPermission = AndroidUtils.INSTANCE.hasPermission(this.this$0.currPermission, true, this.this$0._applicationService);
            this.this$0.waiter.wake(Boolean.valueOf(hasPermission));
            this.this$0.events.fire(new LocationPermissionController$showFallbackAlertDialog$1$onAccept$1$onFocus$1(hasPermission));
        }
    }
}
