package expo.modules.location;

import com.google.android.gms.tasks.OnSuccessListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
final class LocationModule$sam$com_google_android_gms_tasks_OnSuccessListener$0 implements OnSuccessListener {
    private final /* synthetic */ Function1 function;

    LocationModule$sam$com_google_android_gms_tasks_OnSuccessListener$0(Function1 function1) {
        Intrinsics.checkNotNullParameter(function1, "function");
        this.function = function1;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        this.function.invoke(obj);
    }
}
