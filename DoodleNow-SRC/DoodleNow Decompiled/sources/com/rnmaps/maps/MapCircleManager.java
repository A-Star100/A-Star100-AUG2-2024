package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;

public class MapCircleManager extends ViewGroupManager<MapCircle> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapCircle";
    }

    public MapCircleManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    public MapCircle createViewInstance(ThemedReactContext themedReactContext) {
        return new MapCircle(themedReactContext);
    }

    @ReactProp(name = "center")
    public void setCenter(MapCircle mapCircle, ReadableMap readableMap) {
        mapCircle.setCenter(new LatLng(readableMap.getDouble("latitude"), readableMap.getDouble("longitude")));
    }

    @ReactProp(defaultDouble = 0.0d, name = "radius")
    public void setRadius(MapCircle mapCircle, double d) {
        mapCircle.setRadius(d);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapCircle mapCircle, float f) {
        mapCircle.setStrokeWidth(this.metrics.density * f);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "fillColor")
    public void setFillColor(MapCircle mapCircle, int i) {
        mapCircle.setFillColor(i);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(MapCircle mapCircle, int i) {
        mapCircle.setStrokeColor(i);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapCircle mapCircle, float f) {
        mapCircle.setZIndex(f);
    }
}
