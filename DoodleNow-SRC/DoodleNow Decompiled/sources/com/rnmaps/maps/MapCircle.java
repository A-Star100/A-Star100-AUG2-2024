package com.rnmaps.maps;

import android.content.Context;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.collections.CircleManager;

public class MapCircle extends MapFeature {
    private LatLng center;
    private Circle circle;
    private CircleOptions circleOptions;
    private int fillColor;
    private double radius;
    private int strokeColor;
    private float strokeWidth;
    private float zIndex;

    public Object getFeature() {
        return this.circle;
    }

    public MapCircle(Context context) {
        super(context);
    }

    public void setCenter(LatLng latLng) {
        this.center = latLng;
        Circle circle2 = this.circle;
        if (circle2 != null) {
            circle2.setCenter(latLng);
        }
    }

    public void setRadius(double d) {
        this.radius = d;
        Circle circle2 = this.circle;
        if (circle2 != null) {
            circle2.setRadius(d);
        }
    }

    public void setFillColor(int i) {
        this.fillColor = i;
        Circle circle2 = this.circle;
        if (circle2 != null) {
            circle2.setFillColor(i);
        }
    }

    public void setStrokeColor(int i) {
        this.strokeColor = i;
        Circle circle2 = this.circle;
        if (circle2 != null) {
            circle2.setStrokeColor(i);
        }
    }

    public void setStrokeWidth(float f) {
        this.strokeWidth = f;
        Circle circle2 = this.circle;
        if (circle2 != null) {
            circle2.setStrokeWidth(f);
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        Circle circle2 = this.circle;
        if (circle2 != null) {
            circle2.setZIndex(f);
        }
    }

    public CircleOptions getCircleOptions() {
        if (this.circleOptions == null) {
            this.circleOptions = createCircleOptions();
        }
        return this.circleOptions;
    }

    private CircleOptions createCircleOptions() {
        CircleOptions circleOptions2 = new CircleOptions();
        circleOptions2.center(this.center);
        circleOptions2.radius(this.radius);
        circleOptions2.fillColor(this.fillColor);
        circleOptions2.strokeColor(this.strokeColor);
        circleOptions2.strokeWidth(this.strokeWidth);
        circleOptions2.zIndex(this.zIndex);
        return circleOptions2;
    }

    public void addToMap(Object obj) {
        this.circle = ((CircleManager.Collection) obj).addCircle(getCircleOptions());
    }

    public void removeFromMap(Object obj) {
        ((CircleManager.Collection) obj).remove(this.circle);
    }
}
