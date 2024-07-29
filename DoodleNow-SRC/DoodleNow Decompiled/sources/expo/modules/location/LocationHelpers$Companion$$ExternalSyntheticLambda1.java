package expo.modules.location;

import com.google.android.gms.tasks.OnFailureListener;
import expo.modules.kotlin.Promise;
import expo.modules.location.LocationHelpers;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationHelpers$Companion$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ LocationHelpers$Companion$$ExternalSyntheticLambda1(Promise promise) {
        this.f$0 = promise;
    }

    public final void onFailure(Exception exc) {
        LocationHelpers.Companion.requestSingleLocation$lambda$2(this.f$0, exc);
    }
}
