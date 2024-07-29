package com.onesignal.location.internal.permissions;

import android.app.Activity;
import com.onesignal.core.internal.permissions.AlertDialogPrepromptForAndroidSettings;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016¨\u0006\u0005"}, d2 = {"com/onesignal/location/internal/permissions/LocationPermissionController$showFallbackAlertDialog$1", "Lcom/onesignal/core/internal/permissions/AlertDialogPrepromptForAndroidSettings$Callback;", "onAccept", "", "onDecline", "com.onesignal.location"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LocationPermissionController.kt */
public final class LocationPermissionController$showFallbackAlertDialog$1 implements AlertDialogPrepromptForAndroidSettings.Callback {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ LocationPermissionController this$0;

    LocationPermissionController$showFallbackAlertDialog$1(LocationPermissionController locationPermissionController, Activity activity) {
        this.this$0 = locationPermissionController;
        this.$activity = activity;
    }

    public void onAccept() {
        this.this$0._applicationService.addApplicationLifecycleHandler(new LocationPermissionController$showFallbackAlertDialog$1$onAccept$1(this.this$0));
        NavigateToAndroidSettingsForLocation.INSTANCE.show(this.$activity);
    }

    public void onDecline() {
        this.this$0.waiter.wake(false);
        this.this$0.events.fire(LocationPermissionController$showFallbackAlertDialog$1$onDecline$1.INSTANCE);
    }
}
