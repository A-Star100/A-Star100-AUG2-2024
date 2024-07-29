package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapModule$$ExternalSyntheticLambda3 implements Function {
    public final /* synthetic */ Promise f$0;

    public /* synthetic */ MapModule$$ExternalSyntheticLambda3(Promise promise) {
        this.f$0 = promise;
    }

    public final Object apply(Object obj) {
        return MapModule.lambda$getCamera$1(this.f$0, (MapView) obj);
    }
}
