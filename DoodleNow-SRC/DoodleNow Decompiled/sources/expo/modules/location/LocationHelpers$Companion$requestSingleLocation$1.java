package expo.modules.location;

import android.location.Location;
import expo.modules.kotlin.Promise;
import expo.modules.location.records.LocationResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "location", "Landroid/location/Location;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationHelpers.kt */
final class LocationHelpers$Companion$requestSingleLocation$1 extends Lambda implements Function1<Location, Unit> {
    final /* synthetic */ Promise $promise;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationHelpers$Companion$requestSingleLocation$1(Promise promise) {
        super(1);
        this.$promise = promise;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Location) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Location location) {
        if (location == null) {
            this.$promise.reject(new CurrentLocationIsUnavailableException());
        } else {
            this.$promise.resolve((Object) new LocationResponse(location));
        }
    }
}
