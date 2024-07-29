package com.rnmaps.maps;

import android.content.Context;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.net.MalformedURLException;
import java.net.URL;

public class MapWMSTile extends MapUrlTile {
    private static final double FULL = 4.007501669578488E7d;
    /* access modifiers changed from: private */
    public static final double[] mapBound = {-2.003750834789244E7d, 2.003750834789244E7d};

    class AIRMapGSUrlTileProvider extends MapTileProvider {
        final /* synthetic */ MapWMSTile this$0;

        class AIRMapWMSTileProvider extends UrlTileProvider {
            private final int tileSize;
            private String urlTemplate;

            public void setUrlTemplate(String str) {
                this.urlTemplate = str;
            }

            public AIRMapWMSTileProvider(int i, int i2, String str) {
                super(i, i2);
                this.urlTemplate = str;
                this.tileSize = i;
            }

            public URL getTileUrl(int i, int i2, int i3) {
                if (AIRMapGSUrlTileProvider.this.this$0.maximumZ > 0.0f && i3 > AIRMapGSUrlTileProvider.this.maximumZ) {
                    return null;
                }
                if (AIRMapGSUrlTileProvider.this.this$0.minimumZ > 0.0f && i3 < AIRMapGSUrlTileProvider.this.minimumZ) {
                    return null;
                }
                double[] boundingBox = getBoundingBox(i, i2, i3);
                try {
                    return new URL(this.urlTemplate.replace("{minX}", Double.toString(boundingBox[0])).replace("{minY}", Double.toString(boundingBox[1])).replace("{maxX}", Double.toString(boundingBox[2])).replace("{maxY}", Double.toString(boundingBox[3])).replace("{width}", Integer.toString(this.tileSize)).replace("{height}", Integer.toString(this.tileSize)));
                } catch (MalformedURLException e) {
                    throw new AssertionError(e);
                }
            }

            private double[] getBoundingBox(int i, int i2, int i3) {
                double pow = MapWMSTile.FULL / Math.pow(2.0d, (double) i3);
                return new double[]{MapWMSTile.mapBound[0] + (((double) i) * pow), MapWMSTile.mapBound[1] - (((double) (i2 + 1)) * pow), MapWMSTile.mapBound[0] + (((double) (i + 1)) * pow), MapWMSTile.mapBound[1] - (((double) i2) * pow)};
            }
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public AIRMapGSUrlTileProvider(com.rnmaps.maps.MapWMSTile r15, int r16, java.lang.String r17, int r18, int r19, int r20, java.lang.String r21, int r22, boolean r23, android.content.Context r24, boolean r25) {
            /*
                r14 = this;
                r13 = r14
                r0 = r15
                r13.this$0 = r0
                r2 = 0
                r7 = 0
                r0 = r14
                r1 = r16
                r3 = r17
                r4 = r18
                r5 = r19
                r6 = r20
                r8 = r21
                r9 = r22
                r10 = r23
                r11 = r24
                r12 = r25
                r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
                com.rnmaps.maps.MapWMSTile$AIRMapGSUrlTileProvider$AIRMapWMSTileProvider r0 = new com.rnmaps.maps.MapWMSTile$AIRMapGSUrlTileProvider$AIRMapWMSTileProvider
                r2 = r17
                r0.<init>(r1, r1, r2)
                r13.tileProvider = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapWMSTile.AIRMapGSUrlTileProvider.<init>(com.rnmaps.maps.MapWMSTile, int, java.lang.String, int, int, int, java.lang.String, int, boolean, android.content.Context, boolean):void");
        }
    }

    public MapWMSTile(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public TileOverlayOptions createTileOverlayOptions() {
        TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
        tileOverlayOptions.zIndex(this.zIndex);
        tileOverlayOptions.transparency(1.0f - this.opacity);
        tileOverlayOptions.tileProvider(new AIRMapGSUrlTileProvider(this, (int) this.tileSize, this.urlTemplate, (int) this.maximumZ, (int) this.maximumNativeZ, (int) this.minimumZ, this.tileCachePath, (int) this.tileCacheMaxAge, this.offlineMode, this.context, this.customTileProviderNeeded));
        return tileOverlayOptions;
    }
}
