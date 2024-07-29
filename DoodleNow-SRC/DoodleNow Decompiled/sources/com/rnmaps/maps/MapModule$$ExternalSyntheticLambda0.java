package com.rnmaps.maps;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapModule$$ExternalSyntheticLambda0 implements Function {
    public final /* synthetic */ ReadableMap f$0;
    public final /* synthetic */ Promise f$1;
    public final /* synthetic */ ReactApplicationContext f$2;

    public /* synthetic */ MapModule$$ExternalSyntheticLambda0(ReadableMap readableMap, Promise promise, ReactApplicationContext reactApplicationContext) {
        this.f$0 = readableMap;
        this.f$1 = promise;
        this.f$2 = reactApplicationContext;
    }

    public final Object apply(Object obj) {
        return MapModule.lambda$getAddressFromCoordinates$2(this.f$0, this.f$1, this.f$2, (MapView) obj);
    }
}
