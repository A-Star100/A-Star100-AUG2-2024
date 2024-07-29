package expo.modules.location;

import expo.modules.location.records.LocationLastKnownOptions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {0}, l = {383}, m = "getLastKnownPositionAsync", n = {"options"}, s = {"L$0"})
/* compiled from: LocationModule.kt */
final class LocationModule$getLastKnownPositionAsync$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationModule$getLastKnownPositionAsync$1(LocationModule locationModule, Continuation<? super LocationModule$getLastKnownPositionAsync$1> continuation) {
        super(continuation);
        this.this$0 = locationModule;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.getLastKnownPositionAsync((LocationLastKnownOptions) null, this);
    }
}
