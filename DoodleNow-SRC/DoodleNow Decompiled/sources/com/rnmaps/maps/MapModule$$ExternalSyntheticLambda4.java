package com.rnmaps.maps;

import android.graphics.Point;
import com.facebook.react.bridge.Promise;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapModule$$ExternalSyntheticLambda4 implements Function {
    public final /* synthetic */ Point f$0;
    public final /* synthetic */ Promise f$1;

    public /* synthetic */ MapModule$$ExternalSyntheticLambda4(Point point, Promise promise) {
        this.f$0 = point;
        this.f$1 = promise;
    }

    public final Object apply(Object obj) {
        return MapModule.lambda$coordinateForPoint$4(this.f$0, this.f$1, (MapView) obj);
    }
}
