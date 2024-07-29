package expo.modules.location;

import com.google.android.gms.location.CurrentLocationRequest;
import com.google.android.gms.location.FusedLocationProviderClient;
import expo.modules.kotlin.Promise;
import expo.modules.location.LocationHelpers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/location/LocationModule$getCurrentPositionAsync$1", "Lexpo/modules/location/LocationActivityResultListener;", "onResult", "", "resultCode", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
public final class LocationModule$getCurrentPositionAsync$1 implements LocationActivityResultListener {
    final /* synthetic */ CurrentLocationRequest $currentLocationRequest;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ LocationModule this$0;

    LocationModule$getCurrentPositionAsync$1(LocationModule locationModule, CurrentLocationRequest currentLocationRequest, Promise promise) {
        this.this$0 = locationModule;
        this.$currentLocationRequest = currentLocationRequest;
        this.$promise = promise;
    }

    public void onResult(int i) {
        if (i == -1) {
            LocationHelpers.Companion companion = LocationHelpers.Companion;
            FusedLocationProviderClient access$getMLocationProvider$p = this.this$0.mLocationProvider;
            if (access$getMLocationProvider$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLocationProvider");
                access$getMLocationProvider$p = null;
            }
            companion.requestSingleLocation(access$getMLocationProvider$p, this.$currentLocationRequest, this.$promise);
            return;
        }
        this.$promise.reject(new LocationSettingsUnsatisfiedException());
    }
}
