package expo.modules.location;

import android.location.Location;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.location.LocationRequestCallbacks;
import expo.modules.location.records.LocationResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016¨\u0006\n"}, d2 = {"expo/modules/location/LocationHelpers$Companion$requestContinuousUpdates$1", "Lexpo/modules/location/LocationRequestCallbacks;", "onLocationChanged", "", "location", "Landroid/location/Location;", "onRequestFailed", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "onRequestSuccess", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationHelpers.kt */
public final class LocationHelpers$Companion$requestContinuousUpdates$1 implements LocationRequestCallbacks {
    final /* synthetic */ LocationModule $locationModule;
    final /* synthetic */ Promise $promise;
    final /* synthetic */ int $watchId;

    LocationHelpers$Companion$requestContinuousUpdates$1(LocationModule locationModule, int i, Promise promise) {
        this.$locationModule = locationModule;
        this.$watchId = i;
        this.$promise = promise;
    }

    public void onLocationError(CodedException codedException) {
        LocationRequestCallbacks.DefaultImpls.onLocationError(this, codedException);
    }

    public void onLocationChanged(Location location) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.$locationModule.sendLocationResponse$expo_location_release(this.$watchId, new LocationResponse(location));
    }

    public void onRequestSuccess() {
        this.$promise.resolve((Object) null);
    }

    public void onRequestFailed(CodedException codedException) {
        Intrinsics.checkNotNullParameter(codedException, "cause");
        this.$promise.reject(codedException);
    }
}
