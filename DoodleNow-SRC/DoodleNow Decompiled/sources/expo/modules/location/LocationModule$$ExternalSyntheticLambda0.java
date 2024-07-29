package expo.modules.location;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class LocationModule$$ExternalSyntheticLambda0 implements OnSuccessListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ LocationModule$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    public final void onSuccess(Object obj) {
        LocationModule.resolveUserSettingsForRequest$lambda$31(this.f$0, obj);
    }
}
