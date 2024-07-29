package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapModule$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ MapModule$$ExternalSyntheticLambda5(Promise promise) {
        this.f$0 = promise;
    }

    public final Object apply(Object obj) {
        return MapModule.lambda$getMapBoundaries$5(this.f$0, (MapView) obj);
    }
}
