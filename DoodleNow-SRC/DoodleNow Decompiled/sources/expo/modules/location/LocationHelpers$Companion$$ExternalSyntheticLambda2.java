package expo.modules.location;

import com.google.android.gms.tasks.OnCanceledListener;
import expo.modules.kotlin.Promise;
import expo.modules.location.LocationHelpers;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationHelpers$Companion$$ExternalSyntheticLambda2 implements OnCanceledListener {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ LocationHelpers$Companion$$ExternalSyntheticLambda2(Promise promise) {
        this.f$0 = promise;
    }

    public final void onCanceled() {
        LocationHelpers.Companion.requestSingleLocation$lambda$3(this.f$0);
    }
}
