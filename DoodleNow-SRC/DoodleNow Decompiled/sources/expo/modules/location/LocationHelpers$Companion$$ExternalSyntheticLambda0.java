package expo.modules.location;

import com.google.android.gms.tasks.OnSuccessListener;
import expo.modules.location.LocationHelpers;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationHelpers$Companion$$ExternalSyntheticLambda0 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ LocationHelpers$Companion$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        LocationHelpers.Companion.requestSingleLocation$lambda$1(this.f$0, obj);
    }
}
