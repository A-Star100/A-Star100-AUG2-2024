package expo.modules.location;

import android.location.Location;
import com.google.android.gms.tasks.OnCanceledListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "onCanceled"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
final class LocationModule$getLastKnownLocation$2$2 implements OnCanceledListener {
    final /* synthetic */ Continuation<Location> $continuation;

    LocationModule$getLastKnownLocation$2$2(Continuation<? super Location> continuation) {
        this.$continuation = continuation;
    }

    public final void onCanceled() {
        Continuation<Location> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1230constructorimpl((Object) null));
    }
}
