package com.rnmaps.maps;

import android.content.Context;
import android.util.Log;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import java.net.MalformedURLException;
import java.net.URL;

public class MapUrlTile extends MapFeature {
    protected Context context;
    protected boolean customTileProviderNeeded = false;
    protected boolean doubleTileSize = false;
    protected boolean flipY = false;
    protected float maximumNativeZ = 100.0f;
    protected float maximumZ;
    protected float minimumZ;
    protected boolean offlineMode = false;
    protected float opacity = 1.0f;
    protected float tileCacheMaxAge;
    protected String tileCachePath;
    protected TileOverlay tileOverlay;
    protected TileOverlayOptions tileOverlayOptions;
    protected MapTileProvider tileProvider;
    protected float tileSize = 256.0f;
    protected String urlTemplate;
    protected float zIndex;

    public Object getFeature() {
        return this.tileOverlay;
    }

    public MapUrlTile(Context context2) {
        super(context2);
        this.context = context2;
    }

    public void setUrlTemplate(String str) {
        this.urlTemplate = str;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setUrlTemplate(str);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setZIndex(float f) {
        this.zIndex = f;
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.setZIndex(f);
        }
    }

    public void setMaximumZ(float f) {
        this.maximumZ = f;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setMaximumZ((int) f);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setMaximumNativeZ(float f) {
        this.maximumNativeZ = f;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setMaximumNativeZ((int) f);
        }
        setCustomTileProviderMode();
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setMinimumZ(float f) {
        this.minimumZ = f;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setMinimumZ((int) f);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setFlipY(boolean z) {
        this.flipY = z;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setFlipY(z);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setDoubleTileSize(boolean z) {
        this.doubleTileSize = z;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setDoubleTileSize(z);
        }
        setCustomTileProviderMode();
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setTileSize(float f) {
        this.tileSize = f;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setTileSize((int) f);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setTileCachePath(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                this.tileCachePath = new URL(str).getPath();
            } catch (MalformedURLException unused) {
                this.tileCachePath = str;
            } catch (Exception unused2) {
                return;
            }
            MapTileProvider mapTileProvider = this.tileProvider;
            if (mapTileProvider != null) {
                mapTileProvider.setTileCachePath(str);
            }
            setCustomTileProviderMode();
            TileOverlay tileOverlay2 = this.tileOverlay;
            if (tileOverlay2 != null) {
                tileOverlay2.clearTileCache();
            }
        }
    }

    public void setTileCacheMaxAge(float f) {
        this.tileCacheMaxAge = f;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setTileCacheMaxAge((int) f);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setOfflineMode(boolean z) {
        this.offlineMode = z;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setOfflineMode(z);
        }
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.clearTileCache();
        }
    }

    public void setOpacity(float f) {
        this.opacity = f;
        TileOverlay tileOverlay2 = this.tileOverlay;
        if (tileOverlay2 != null) {
            tileOverlay2.setTransparency(1.0f - f);
        }
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    /* access modifiers changed from: protected */
    public void setCustomTileProviderMode() {
        Log.d("urlTile ", "creating new mode TileProvider");
        this.customTileProviderNeeded = true;
        MapTileProvider mapTileProvider = this.tileProvider;
        if (mapTileProvider != null) {
            mapTileProvider.setCustomMode();
        }
    }

    /* access modifiers changed from: protected */
    public TileOverlayOptions createTileOverlayOptions() {
        Log.d("urlTile ", "creating TileProvider");
        TileOverlayOptions tileOverlayOptions2 = new TileOverlayOptions();
        tileOverlayOptions2.zIndex(this.zIndex);
        tileOverlayOptions2.transparency(1.0f - this.opacity);
        MapTileProvider mapTileProvider = new MapTileProvider((int) this.tileSize, this.doubleTileSize, this.urlTemplate, (int) this.maximumZ, (int) this.maximumNativeZ, (int) this.minimumZ, this.flipY, this.tileCachePath, (int) this.tileCacheMaxAge, this.offlineMode, this.context, this.customTileProviderNeeded);
        this.tileProvider = mapTileProvider;
        tileOverlayOptions2.tileProvider(mapTileProvider);
        return tileOverlayOptions2;
    }

    public void addToMap(Object obj) {
        this.tileOverlay = ((GoogleMap) obj).addTileOverlay(getTileOverlayOptions());
    }

    public void removeFromMap(Object obj) {
        this.tileOverlay.remove();
    }
}
