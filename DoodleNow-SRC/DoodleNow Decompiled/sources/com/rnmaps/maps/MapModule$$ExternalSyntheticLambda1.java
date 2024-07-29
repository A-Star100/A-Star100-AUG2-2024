package com.rnmaps.maps;

import android.graphics.Bitmap;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class MapModule$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ MapModule f$0;
    public final /* synthetic */ Promise f$1;
    public final /* synthetic */ Integer f$2;
    public final /* synthetic */ Integer f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ String f$5;
    public final /* synthetic */ ReactApplicationContext f$6;
    public final /* synthetic */ Bitmap.CompressFormat f$7;
    public final /* synthetic */ double f$8;

    public /* synthetic */ MapModule$$ExternalSyntheticLambda1(MapModule mapModule, Promise promise, Integer num, Integer num2, String str, String str2, ReactApplicationContext reactApplicationContext, Bitmap.CompressFormat compressFormat, double d) {
        this.f$0 = mapModule;
        this.f$1 = promise;
        this.f$2 = num;
        this.f$3 = num2;
        this.f$4 = str;
        this.f$5 = str2;
        this.f$6 = reactApplicationContext;
        this.f$7 = compressFormat;
        this.f$8 = d;
    }

    public final Object apply(Object obj) {
        return this.f$0.lambda$takeSnapshot$0(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, (MapView) obj);
    }
}
