package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MapWMSTileManager extends ViewGroupManager<MapWMSTile> {
    public String getName() {
        return "AIRMapWMSTile";
    }

    public MapWMSTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    public MapWMSTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapWMSTile(themedReactContext);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(MapWMSTile mapWMSTile, String str) {
        mapWMSTile.setUrlTemplate(str);
    }

    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setZIndex(f);
    }

    @ReactProp(defaultFloat = 0.0f, name = "minimumZ")
    public void setMinimumZ(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setMinimumZ(f);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumZ")
    public void setMaximumZ(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setMaximumZ(f);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumNativeZ")
    public void setMaximumNativeZ(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setMaximumNativeZ(f);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setTileSize(f);
    }

    @ReactProp(name = "tileCachePath")
    public void setTileCachePath(MapWMSTile mapWMSTile, String str) {
        mapWMSTile.setTileCachePath(str);
    }

    @ReactProp(defaultFloat = 0.0f, name = "tileCacheMaxAge")
    public void setTileCacheMaxAge(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setTileCacheMaxAge(f);
    }

    @ReactProp(defaultBoolean = false, name = "offlineMode")
    public void setOfflineMode(MapWMSTile mapWMSTile, boolean z) {
        mapWMSTile.setOfflineMode(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapWMSTile mapWMSTile, float f) {
        mapWMSTile.setOpacity(f);
    }
}
