package com.rnmaps.maps;

import android.content.Context;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.TileProvider;

public class MapLocalTile extends MapFeature {
    private String pathTemplate;
    private TileOverlay tileOverlay;
    private TileOverlayOptions tileOverlayOptions;
    private AIRMapLocalTileProvider tileProvider;
    private float tileSize;
    private boolean useAssets;
    private float zIndex;

    public Object getFeature() {
        return this.tileOverlay;
    }

    public void setUseAssets(boolean z) {
        this.useAssets = z;
    }

    class AIRMapLocalTileProvider implements TileProvider {
        private static final int BUFFER_SIZE = 16384;
        private String pathTemplate;
        private int tileSize;
        private final boolean useAssets;

        public void setPathTemplate(String str) {
            this.pathTemplate = str;
        }

        public void setTileSize(int i) {
            this.tileSize = i;
        }

        public AIRMapLocalTileProvider(int i, String str, boolean z) {
            this.tileSize = i;
            this.pathTemplate = str;
            this.useAssets = z;
        }

        public Tile getTile(int i, int i2, int i3) {
            byte[] readTileImage = readTileImage(i, i2, i3);
            if (readTileImage == null) {
                return TileProvider.NO_TILE;
            }
            int i4 = this.tileSize;
            return new Tile(i4, i4, readTileImage);
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(8:10|11|(2:12|(1:14)(1:57))|15|(2:17|18)|19|20|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x003f */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x006b A[SYNTHETIC, Splitter:B:38:0x006b] */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x0070 A[SYNTHETIC, Splitter:B:42:0x0070] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0079 A[SYNTHETIC, Splitter:B:49:0x0079] */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x007e A[SYNTHETIC, Splitter:B:53:0x007e] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private byte[] readTileImage(int r7, int r8, int r9) {
            /*
                r6 = this;
                java.lang.String r7 = r6.getTileFilename(r7, r8, r9)
                r8 = 0
                boolean r9 = r6.useAssets     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                if (r9 == 0) goto L_0x0018
                com.rnmaps.maps.MapLocalTile r9 = com.rnmaps.maps.MapLocalTile.this     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                android.content.Context r9 = r9.getContext()     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                android.content.res.AssetManager r9 = r9.getAssets()     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                java.io.InputStream r7 = r9.open(r7)     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                goto L_0x001e
            L_0x0018:
                java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                r9.<init>(r7)     // Catch:{ IOException -> 0x0063, OutOfMemoryError -> 0x0061, all -> 0x005e }
                r7 = r9
            L_0x001e:
                java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0058, OutOfMemoryError -> 0x0056, all -> 0x0050 }
                r9.<init>()     // Catch:{ IOException -> 0x0058, OutOfMemoryError -> 0x0056, all -> 0x0050 }
                r0 = 16384(0x4000, float:2.2959E-41)
                byte[] r1 = new byte[r0]     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0043 }
            L_0x0027:
                r2 = 0
                int r3 = r7.read(r1, r2, r0)     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0043 }
                r4 = -1
                if (r3 == r4) goto L_0x0033
                r9.write(r1, r2, r3)     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0043 }
                goto L_0x0027
            L_0x0033:
                r9.flush()     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0043 }
                byte[] r8 = r9.toByteArray()     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0043 }
                if (r7 == 0) goto L_0x003f
                r7.close()     // Catch:{ Exception -> 0x003f }
            L_0x003f:
                r9.close()     // Catch:{ Exception -> 0x0042 }
            L_0x0042:
                return r8
            L_0x0043:
                r8 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
                goto L_0x0077
            L_0x0048:
                r0 = move-exception
                goto L_0x004b
            L_0x004a:
                r0 = move-exception
            L_0x004b:
                r5 = r9
                r9 = r7
                r7 = r0
                r0 = r5
                goto L_0x0066
            L_0x0050:
                r9 = move-exception
                r5 = r8
                r8 = r7
                r7 = r9
                r9 = r5
                goto L_0x0077
            L_0x0056:
                r9 = move-exception
                goto L_0x0059
            L_0x0058:
                r9 = move-exception
            L_0x0059:
                r0 = r8
                r5 = r9
                r9 = r7
                r7 = r5
                goto L_0x0066
            L_0x005e:
                r7 = move-exception
                r9 = r8
                goto L_0x0077
            L_0x0061:
                r7 = move-exception
                goto L_0x0064
            L_0x0063:
                r7 = move-exception
            L_0x0064:
                r9 = r8
                r0 = r9
            L_0x0066:
                r7.printStackTrace()     // Catch:{ all -> 0x0074 }
                if (r9 == 0) goto L_0x006e
                r9.close()     // Catch:{ Exception -> 0x006e }
            L_0x006e:
                if (r0 == 0) goto L_0x0073
                r0.close()     // Catch:{ Exception -> 0x0073 }
            L_0x0073:
                return r8
            L_0x0074:
                r7 = move-exception
                r8 = r9
                r9 = r0
            L_0x0077:
                if (r8 == 0) goto L_0x007c
                r8.close()     // Catch:{ Exception -> 0x007c }
            L_0x007c:
                if (r9 == 0) goto L_0x0081
                r9.close()     // Catch:{ Exception -> 0x0081 }
            L_0x0081:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapLocalTile.AIRMapLocalTileProvider.readTileImage(int, int, int):byte[]");
        }

        private String getTileFilename(int i, int i2, int i3) {
            return this.pathTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
        }
    }

    public MapLocalTile(Context context) {
        super(context);
    }

    public void setPathTemplate(String str) {
        this.pathTemplate = str;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.tileProvider;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.setPathTemplate(str);
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

    public void setTileSize(float f) {
        this.tileSize = f;
        AIRMapLocalTileProvider aIRMapLocalTileProvider = this.tileProvider;
        if (aIRMapLocalTileProvider != null) {
            aIRMapLocalTileProvider.setTileSize((int) f);
        }
    }

    public TileOverlayOptions getTileOverlayOptions() {
        if (this.tileOverlayOptions == null) {
            this.tileOverlayOptions = createTileOverlayOptions();
        }
        return this.tileOverlayOptions;
    }

    private TileOverlayOptions createTileOverlayOptions() {
        TileOverlayOptions tileOverlayOptions2 = new TileOverlayOptions();
        tileOverlayOptions2.zIndex(this.zIndex);
        AIRMapLocalTileProvider aIRMapLocalTileProvider = new AIRMapLocalTileProvider((int) this.tileSize, this.pathTemplate, this.useAssets);
        this.tileProvider = aIRMapLocalTileProvider;
        tileOverlayOptions2.tileProvider(aIRMapLocalTileProvider);
        return tileOverlayOptions2;
    }

    public void addToMap(Object obj) {
        this.tileOverlay = ((GoogleMap) obj).addTileOverlay(getTileOverlayOptions());
    }

    public void removeFromMap(Object obj) {
        this.tileOverlay.remove();
    }
}
