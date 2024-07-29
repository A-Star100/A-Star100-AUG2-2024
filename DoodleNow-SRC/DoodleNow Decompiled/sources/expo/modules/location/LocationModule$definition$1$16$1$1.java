package expo.modules.location;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/location/LocationModule$definition$1$16$1$1", "Lexpo/modules/location/LocationActivityResultListener;", "onResult", "", "resultCode", "", "expo-location_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LocationModule.kt */
public final class LocationModule$definition$1$16$1$1 implements LocationActivityResultListener {
    final /* synthetic */ Continuation<String> $continuation;

    LocationModule$definition$1$16$1$1(Continuation<? super String> continuation) {
        this.$continuation = continuation;
    }

    public void onResult(int i) {
        if (i == -1) {
            Continuation<String> continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1230constructorimpl((Object) null));
            return;
        }
        Continuation<String> continuation2 = this.$continuation;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m1230constructorimpl(ResultKt.createFailure(new LocationSettingsUnsatisfiedException())));
    }
}
