package com.rnmaps.maps;

import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;

public class MapLocalTileManager extends ViewGroupManager<MapLocalTile> {
    public String getName() {
        return "AIRMapLocalTile";
    }

    public MapLocalTileManager(ReactApplicationContext reactApplicationContext) {
        ((WindowManager) reactApplicationContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(new DisplayMetrics());
    }

    public MapLocalTile createViewInstance(ThemedReactContext themedReactContext) {
        return new MapLocalTile(themedReactContext);
    }

    @ReactProp(name = "pathTemplate")
    public void setPathTemplate(MapLocalTile mapLocalTile, String str) {
        mapLocalTile.setPathTemplate(str);
    }

    @ReactProp(defaultFloat = 256.0f, name = "tileSize")
    public void setTileSize(MapLocalTile mapLocalTile, float f) {
        mapLocalTile.setTileSize(f);
    }

    @ReactProp(defaultFloat = -1.0f, name = "zIndex")
    public void setZIndex(MapLocalTile mapLocalTile, float f) {
        mapLocalTile.setZIndex(f);
    }

    @ReactProp(defaultBoolean = false, name = "useAssets")
    public void setUseAssets(MapLocalTile mapLocalTile, boolean z) {
        mapLocalTile.setUseAssets(z);
    }
}
