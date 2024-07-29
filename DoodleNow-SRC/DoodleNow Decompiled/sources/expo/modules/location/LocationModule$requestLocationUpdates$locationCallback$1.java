package expo.modules.location;

import android.location.Location;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"expo/modules/location/LocationModule$requestLocationUpdates$locationCallback$1", "Lcom/google/android/gms/location/LocationCallback;", "isLocationAvailable", "", "()Z", "setLocationAvailable", "(Z)V", "onLocationAvailability", "", "locationAvailability", "Lcom/google/android/gms/location/LocationAvailability;", "onLocationResult", "locationResult", "Lcom/google/android/gms/location/LocationResult;", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
public final class LocationModule$requestLocationUpdates$locationCallback$1 extends LocationCallback {
    final /* synthetic */ LocationRequestCallbacks $callbacks;
    private boolean isLocationAvailable;

    public final boolean isLocationAvailable() {
        return this.isLocationAvailable;
    }

    public final void setLocationAvailable(boolean z) {
        this.isLocationAvailable = z;
    }

    LocationModule$requestLocationUpdates$locationCallback$1(LocationRequestCallbacks locationRequestCallbacks) {
        this.$callbacks = locationRequestCallbacks;
    }

    public void onLocationResult(LocationResult locationResult) {
        Intrinsics.checkNotNullParameter(locationResult, "locationResult");
        Location lastLocation = locationResult.getLastLocation();
        if (lastLocation != null) {
            this.$callbacks.onLocationChanged(lastLocation);
        } else if (!this.isLocationAvailable) {
            this.$callbacks.onLocationError(new LocationUnavailableException());
        } else {
            this.$callbacks.onRequestFailed(new LocationUnknownException());
        }
    }

    public void onLocationAvailability(LocationAvailability locationAvailability) {
        Intrinsics.checkNotNullParameter(locationAvailability, "locationAvailability");
        this.isLocationAvailable = locationAvailability.isLocationAvailable();
    }
}
