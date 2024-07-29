package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.google.android.gms.maps.model.LatLng;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapModule$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ LatLng f$0;
    public final /* synthetic */ double f$1;
    public final /* synthetic */ Promise f$2;

    public /* synthetic */ MapModule$$ExternalSyntheticLambda2(LatLng latLng, double d, Promise promise) {
        this.f$0 = latLng;
        this.f$1 = d;
        this.f$2 = promise;
    }

    public final Object apply(Object obj) {
        return MapModule.lambda$pointForCoordinate$3(this.f$0, this.f$1, this.f$2, (MapView) obj);
    }
}
