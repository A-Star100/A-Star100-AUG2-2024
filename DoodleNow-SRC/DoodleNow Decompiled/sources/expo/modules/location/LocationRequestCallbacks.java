package expo.modules.location;

import android.location.Location;
import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\u0003H\u0016¨\u0006\u000b"}, d2 = {"Lexpo/modules/location/LocationRequestCallbacks;", "", "onLocationChanged", "", "location", "Landroid/location/Location;", "onLocationError", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "onRequestFailed", "onRequestSuccess", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationRequestCallbacks.kt */
public interface LocationRequestCallbacks {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LocationRequestCallbacks.kt */
    public static final class DefaultImpls {
        public static void onLocationChanged(LocationRequestCallbacks locationRequestCallbacks, Location location) {
            Intrinsics.checkNotNullParameter(location, "location");
        }

        public static void onLocationError(LocationRequestCallbacks locationRequestCallbacks, CodedException codedException) {
            Intrinsics.checkNotNullParameter(codedException, "cause");
        }

        public static void onRequestFailed(LocationRequestCallbacks locationRequestCallbacks, CodedException codedException) {
            Intrinsics.checkNotNullParameter(codedException, "cause");
        }

        public static void onRequestSuccess(LocationRequestCallbacks locationRequestCallbacks) {
        }
    }

    void onLocationChanged(Location location);

    void onLocationError(CodedException codedException);

    void onRequestFailed(CodedException codedException);

    void onRequestSuccess();
}
