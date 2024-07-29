package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.data.Layer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Renderer$$ExternalSyntheticLambda2 implements GoogleMap.OnPolylineClickListener {
    public final /* synthetic */ Renderer f$0;
    public final /* synthetic */ Layer.OnFeatureClickListener f$1;

    public /* synthetic */ Renderer$$ExternalSyntheticLambda2(Renderer renderer, Layer.OnFeatureClickListener onFeatureClickListener) {
        this.f$0 = renderer;
        this.f$1 = onFeatureClickListener;
    }

    public final void onPolylineClick(Polyline polyline) {
        this.f$0.m991lambda$setOnFeatureClickListener$2$comgooglemapsandroiddataRenderer(this.f$1, polyline);
    }
}
