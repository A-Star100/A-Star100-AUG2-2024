package expo.modules.location;

import android.location.Location;
import io.nlopez.smartlocation.OnLocationUpdatedListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationModule$$ExternalSyntheticLambda2 implements OnLocationUpdatedListener {
    public final /* synthetic */ LocationModule f$0;

    public /* synthetic */ LocationModule$$ExternalSyntheticLambda2(LocationModule locationModule) {
        this.f$0 = locationModule;
    }

    public final void onLocationUpdated(Location location) {
        LocationModule.startHeadingUpdate$lambda$33(this.f$0, location);
    }
}
