package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MapUrlTileManager extends ViewGroupManager<MapUrlTile> {
    public String getName() {
        return "AIRMapUrlTile";
    }

    public MapUrlTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    public MapUrlTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapUrlTile(themedReactContext);
    }

    @ReactProp(name = "urlTemplate")
    public void setUrlTemplate(MapUrlTile mapUrlTile, String str) {
        mapUrlTile.setUrlTemplate(str);
    }

    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setZIndex(f);
    }

    @ReactProp(defaultFloat = 0.0f, name = "minimumZ")
    public void setMinimumZ(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setMinimumZ(f);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumZ")
    public void setMaximumZ(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setMaximumZ(f);
    }

    @ReactProp(defaultFloat = 100.0f, name = "maximumNativeZ")
    public void setMaximumNativeZ(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setMaximumNativeZ(f);
    }

    @ReactProp(defaultBoolean = false, name = "flipY")
    public void setFlipY(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setFlipY(z);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setTileSize(f);
    }

    @ReactProp(defaultBoolean = false, name = "doubleTileSize")
    public void setDoubleTileSize(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setDoubleTileSize(z);
    }

    @ReactProp(name = "tileCachePath")
    public void setTileCachePath(MapUrlTile mapUrlTile, String str) {
        mapUrlTile.setTileCachePath(str);
    }

    @ReactProp(defaultFloat = 0.0f, name = "tileCacheMaxAge")
    public void setTileCacheMaxAge(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setTileCacheMaxAge(f);
    }

    @ReactProp(defaultBoolean = false, name = "offlineMode")
    public void setOfflineMode(MapUrlTile mapUrlTile, boolean z) {
        mapUrlTile.setOfflineMode(z);
    }

    @ReactProp(defaultFloat = 1.0f, name = "opacity")
    public void setOpacity(MapUrlTile mapUrlTile, float f) {
        mapUrlTile.setOpacity(f);
    }
}
