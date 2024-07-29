package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.ButtCap;
import com.google.android.gms.maps.model.Cap;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.gms.maps.model.SquareCap;
import java.util.Map;

public class MapPolylineManager extends ViewGroupManager<MapPolyline> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapPolyline";
    }

    public MapPolylineManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    public MapPolyline createViewInstance(ThemedReactContext themedReactContext) {
        return new MapPolyline(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinate(MapPolyline mapPolyline, ReadableArray readableArray) {
        mapPolyline.setCoordinates(readableArray);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapPolyline mapPolyline, float f) {
        mapPolyline.setWidth(this.metrics.density * f);
    }

    @ReactProp(customType = "Color", defaultInt = -65536, name = "strokeColor")
    public void setStrokeColor(MapPolyline mapPolyline, int i) {
        mapPolyline.setColor(i);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setTappable(z);
    }

    @ReactProp(defaultBoolean = false, name = "geodesic")
    public void setGeodesic(MapPolyline mapPolyline, boolean z) {
        mapPolyline.setGeodesic(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapPolyline mapPolyline, float f) {
        mapPolyline.setZIndex(f);
    }

    @ReactProp(name = "lineCap")
    public void setlineCap(MapPolyline mapPolyline, String str) {
        Cap cap;
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -894674659:
                if (str.equals("square")) {
                    c = 0;
                    break;
                }
                break;
            case 3035667:
                if (str.equals("butt")) {
                    c = 1;
                    break;
                }
                break;
            case 108704142:
                if (str.equals("round")) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                cap = new SquareCap();
                break;
            case 1:
                cap = new ButtCap();
                break;
            case 2:
                cap = new RoundCap();
                break;
            default:
                cap = new RoundCap();
                break;
        }
        mapPolyline.setLineCap(cap);
    }

    @ReactProp(name = "lineDashPattern")
    public void setLineDashPattern(MapPolyline mapPolyline, ReadableArray readableArray) {
        mapPolyline.setLineDashPattern(readableArray);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
