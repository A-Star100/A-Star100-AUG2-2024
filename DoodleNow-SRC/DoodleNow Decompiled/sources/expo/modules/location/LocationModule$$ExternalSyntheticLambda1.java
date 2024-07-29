package expo.modules.location;

import android.app.Activity;
import com.google.android.gms.tasks.OnFailureListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationModule$$ExternalSyntheticLambda1 implements OnFailureListener {
    public final /* synthetic */ LocationModule f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ LocationModule$$ExternalSyntheticLambda1(LocationModule locationModule, Activity activity) {
        this.f$0 = locationModule;
        this.f$1 = activity;
    }

    public final void onFailure(Exception exc) {
        LocationModule.resolveUserSettingsForRequest$lambda$32(this.f$0, this.f$1, exc);
    }
}
