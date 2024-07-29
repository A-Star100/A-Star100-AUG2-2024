package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.maps.model.LatLng;
import java.util.ArrayList;

public class MapGradientPolylineManager extends ViewGroupManager<MapGradientPolyline> {
    private final DisplayMetrics metrics;

    public String getName() {
        return "AIRMapGradientPolyline";
    }

    public MapGradientPolylineManager(ReactApplicationContext reactApplicationContext) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.metrics = displayMetrics;
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
    }

    public MapGradientPolyline createViewInstance(ThemedReactContext themedReactContext) {
        return new MapGradientPolyline(themedReactContext);
    }

    @ReactProp(name = "coordinates")
    public void setCoordinates(MapGradientPolyline mapGradientPolyline, ReadableArray readableArray) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < readableArray.size(); i++) {
            ReadableMap map = readableArray.getMap(i);
            arrayList.add(new LatLng(map.getDouble("latitude"), map.getDouble("longitude")));
        }
        mapGradientPolyline.setCoordinates(arrayList);
    }

    @ReactProp(customType = "ColorArray", name = "strokeColors")
    public void setStrokeColors(MapGradientPolyline mapGradientPolyline, ReadableArray readableArray) {
        if (readableArray == null) {
            mapGradientPolyline.setStrokeColors(new int[]{0, 0});
        } else if (readableArray.size() == 0) {
            mapGradientPolyline.setStrokeColors(new int[]{0, 0});
        } else if (readableArray.size() == 1) {
            mapGradientPolyline.setStrokeColors(new int[]{readableArray.getInt(0), readableArray.getInt(0)});
        } else {
            int[] iArr = new int[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                iArr[i] = readableArray.getInt(i);
            }
            mapGradientPolyline.setStrokeColors(iArr);
        }
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapGradientPolyline mapGradientPolyline, float f) {
        mapGradientPolyline.setZIndex(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "strokeWidth")
    public void setStrokeWidth(MapGradientPolyline mapGradientPolyline, float f) {
        mapGradientPolyline.setWidth(this.metrics.density * f);
    }
}
