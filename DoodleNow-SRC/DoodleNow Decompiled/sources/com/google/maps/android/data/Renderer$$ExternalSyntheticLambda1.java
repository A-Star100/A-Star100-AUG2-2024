package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.data.Layer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Renderer$$ExternalSyntheticLambda1 implements GoogleMap.OnMarkerClickListener {
    public final /* synthetic */ Renderer f$0;
    public final /* synthetic */ Layer.OnFeatureClickListener f$1;

    public /* synthetic */ Renderer$$ExternalSyntheticLambda1(Renderer renderer, Layer.OnFeatureClickListener onFeatureClickListener) {
        this.f$0 = renderer;
        this.f$1 = onFeatureClickListener;
    }

    public final boolean onMarkerClick(Marker marker) {
        return this.f$0.m990lambda$setOnFeatureClickListener$1$comgooglemapsandroiddataRenderer(this.f$1, marker);
    }
}
