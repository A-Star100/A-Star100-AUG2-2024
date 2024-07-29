package expo.modules.location;

import android.location.Location;
import com.google.android.gms.tasks.OnFailureListener;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/lang/Exception;", "onFailure"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
final class LocationModule$getLastKnownLocation$2$3 implements OnFailureListener {
    final /* synthetic */ Continuation<Location> $continuation;

    LocationModule$getLastKnownLocation$2$3(Continuation<? super Location> continuation) {
        this.$continuation = continuation;
    }

    public final void onFailure(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "it");
        Continuation<Location> continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1230constructorimpl((Object) null));
    }
}
