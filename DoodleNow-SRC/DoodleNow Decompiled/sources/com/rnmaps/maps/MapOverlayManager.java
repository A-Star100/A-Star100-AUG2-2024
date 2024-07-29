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

public class MapOverlayManager extends ViewGroupManager<MapOverlay> {
    public String getName() {
        return "AIRMapOverlay";
    }

    public MapOverlayManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    public MapOverlay createViewInstance(ThemedReactContext themedReactContext) {
        return new MapOverlay(themedReactContext);
    }

    @ReactProp(name = "bounds")
    public void setBounds(MapOverlay mapOverlay, ReadableArray readableArray) {
        mapOverlay.setBounds(readableArray);
    }

    @ReactProp(name = "bearing")
    public void setBearing(MapOverlay mapOverlay, float f) {
        mapOverlay.setBearing(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "zIndex")
    public void setZIndex(MapOverlay mapOverlay, float f) {
        mapOverlay.setZIndex(f);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapOverlay mapOverlay, float f) {
        mapOverlay.setTransparency(1.0f - f);
    }

    @ReactProp(name = "image")
    public void setImage(MapOverlay mapOverlay, String str) {
        mapOverlay.setImage(str);
    }

    @ReactProp(defaultBoolean = false, name = "tappable")
    public void setTappable(MapOverlay mapOverlay, boolean z) {
        mapOverlay.setTappable(z);
    }

    public Map getExportedCustomDirectEventTypeConstants() {
        return MapBuilder.of("onPress", MapBuilder.of("registrationName", "onPress"));
    }
}
