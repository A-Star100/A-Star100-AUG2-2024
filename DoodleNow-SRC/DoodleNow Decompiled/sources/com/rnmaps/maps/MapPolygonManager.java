package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import java.util.Map;

public class MapPolygonManager extends ViewGroupManager<MapPolygon> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapPolygon";
    }

    public MapPolygonManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    public MapPolygon createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolygon(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setCoordinates(readableArray);
    }

    @ReactProp(name = "holes")
    public void setHoles(MapPolygon mapPolygon, ReadableArray readableArray) {
        mapPolygon.setHoles(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapPolygon mapPolygon, float f) {
        mapPolygon.setStrokeWidth(this.metrics.density * f);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "fillColor")
    public void setFillColor(MapPolygon mapPolygon, int i) {
        mapPolygon.setFillColor(i);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(MapPolygon mapPolygon, int i) {
        mapPolygon.setStrokeColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setTappable(z);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(MapPolygon mapPolygon, boolean z) {
        mapPolygon.setGeodesic(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapPolygon mapPolygon, float f) {
        mapPolygon.setZIndex(f);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
