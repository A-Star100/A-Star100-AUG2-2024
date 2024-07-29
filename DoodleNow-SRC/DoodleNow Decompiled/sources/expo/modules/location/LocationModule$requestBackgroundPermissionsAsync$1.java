package expo.modules.location;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "expo.modules.location.LocationModule", f = "LocationModule.kt", i = {}, l = {355, 358}, m = "requestBackgroundPermissionsAsync", n = {}, s = {})
/* compiled from: LocationModule.kt */
final class LocationModule$requestBackgroundPermissionsAsync$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LocationModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LocationModule$requestBackgroundPermissionsAsync$1(LocationModule locationModule, Continuation<? super LocationModule$requestBackgroundPermissionsAsync$1> continuation) {
        super(continuation);
        this.this$0 = locationModule;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.requestBackgroundPermissionsAsync(this);
    }
}
