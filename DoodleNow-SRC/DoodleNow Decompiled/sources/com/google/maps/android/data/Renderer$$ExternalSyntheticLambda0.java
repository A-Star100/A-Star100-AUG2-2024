package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Polygon;
import com.google.maps.android.data.Layer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Renderer$$ExternalSyntheticLambda0 implements GoogleMap.OnPolygonClickListener {
    public final /* synthetic */ Renderer f$0;
    public final /* synthetic */ Layer.OnFeatureClickListener f$1;

    public /* synthetic */ Renderer$$ExternalSyntheticLambda0(Renderer renderer, Layer.OnFeatureClickListener onFeatureClickListener) {
        this.f$0 = renderer;
        this.f$1 = onFeatureClickListener;
    }

    public final void onPolygonClick(Polygon polygon) {
        this.f$0.m989lambda$setOnFeatureClickListener$0$comgooglemapsandroiddataRenderer(this.f$1, polygon);
    }
}
