package com.rnmaps.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.Log;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingWorkPolicy;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.TileProvider;
import com.google.android.gms.maps.model.UrlTileProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.IOUtils;

public class MapTileProvider implements TileProvider {
    protected static final int BUFFER_SIZE = 16384;
    protected static final int TARGET_TILE_SIZE = 512;
    protected Context context;
    protected boolean customMode;
    protected boolean doubleTileSize;
    protected boolean flipY;
    protected int maximumNativeZ;
    protected int maximumZ;
    protected int minimumZ;
    protected boolean offlineMode;
    protected int tileCacheMaxAge;
    protected String tileCachePath;
    protected UrlTileProvider tileProvider;
    protected int tileSize;
    protected String urlTemplate;

    public void setCustomMode() {
    }

    public void setDoubleTileSize(boolean z) {
        this.doubleTileSize = z;
    }

    public void setFlipY(boolean z) {
        this.flipY = z;
    }

    public void setMaximumNativeZ(int i) {
        this.maximumNativeZ = i;
    }

    public void setMaximumZ(int i) {
        this.maximumZ = i;
    }

    public void setMinimumZ(int i) {
        this.minimumZ = i;
    }

    public void setOfflineMode(boolean z) {
        this.offlineMode = z;
    }

    public void setTileCacheMaxAge(int i) {
        this.tileCacheMaxAge = i;
    }

    public void setTileCachePath(String str) {
        this.tileCachePath = str;
    }

    class AIRMapUrlTileProvider extends UrlTileProvider {
        private String urlTemplate;

        public void setUrlTemplate(String str) {
            this.urlTemplate = str;
        }

        public AIRMapUrlTileProvider(int i, int i2, String str) {
            super(i, i2);
            this.urlTemplate = str;
        }

        public URL getTileUrl(int i, int i2, int i3) {
            if (MapTileProvider.this.flipY) {
                i2 = ((1 << i3) - i2) - 1;
            }
            String replace = this.urlTemplate.replace("{x}", Integer.toString(i)).replace("{y}", Integer.toString(i2)).replace("{z}", Integer.toString(i3));
            if (MapTileProvider.this.maximumZ > 0 && i3 > MapTileProvider.this.maximumZ) {
                return null;
            }
            if (MapTileProvider.this.minimumZ > 0 && i3 < MapTileProvider.this.minimumZ) {
                return null;
            }
            try {
                return new URL(replace);
            } catch (MalformedURLException e) {
                throw new AssertionError(e);
            }
        }
    }

    public MapTileProvider(int i, boolean z, String str, int i2, int i3, int i4, boolean z2, String str2, int i5, boolean z3, Context context2, boolean z4) {
        this.tileProvider = new AIRMapUrlTileProvider(i, i, str);
        this.tileSize = i;
        this.doubleTileSize = z;
        this.urlTemplate = str;
        this.maximumZ = i2;
        this.maximumNativeZ = i3;
        this.minimumZ = i4;
        this.flipY = z2;
        this.tileCachePath = str2;
        this.tileCacheMaxAge = i5;
        this.offlineMode = z3;
        this.context = context2;
        this.customMode = z4;
    }

    public Tile getTile(int i, int i2, int i3) {
        byte[] bArr;
        int i4;
        if (!this.customMode) {
            return this.tileProvider.getTile(i, i2, i3);
        }
        int i5 = this.maximumZ;
        if (i5 <= 0) {
            i5 = Integer.MAX_VALUE;
        }
        if (this.tileSize != 256 || !this.doubleTileSize || (i4 = i3 + 1) > this.maximumNativeZ || i4 > i5) {
            bArr = null;
        } else {
            Log.d("urlTile", "pullTilesFromHigherZoom");
            bArr = pullTilesFromHigherZoom(i, i2, i3);
        }
        if (i3 > this.maximumNativeZ) {
            Log.d("urlTile", "scaleLowerZoomTile");
            bArr = scaleLowerZoomTile(i, i2, i3, this.maximumNativeZ);
        }
        if (bArr == null && i3 <= i5) {
            Log.d("urlTile", "getTileImage");
            bArr = getTileImage(i, i2, i3);
        }
        if (bArr == null && this.tileCachePath != null && this.offlineMode) {
            Log.d("urlTile", "findLowerZoomTileForScaling");
            int i6 = this.maximumNativeZ;
            int max = Math.max(this.minimumZ, i3 - 3);
            for (int i7 = i3 > i6 ? i6 - 1 : i3 - 1; i7 >= max; i7--) {
                bArr = scaleLowerZoomTile(i, i2, i3, i7);
                if (bArr != null) {
                    break;
                }
            }
        }
        if (bArr == null) {
            return null;
        }
        int i8 = this.tileSize;
        return new Tile(i8, i8, bArr);
    }

    /* access modifiers changed from: package-private */
    public byte[] getTileImage(int i, int i2, int i3) {
        byte[] bArr;
        int i4 = i;
        int i5 = i2;
        int i6 = i3;
        if (this.tileCachePath != null) {
            bArr = readTileImage(i, i2, i3);
            if (bArr != null) {
                Log.d("urlTile", "tile cache HIT for " + i6 + "/" + i4 + "/" + i5);
            } else {
                Log.d("urlTile", "tile cache MISS for " + i6 + "/" + i4 + "/" + i5);
            }
            if (bArr != null && !this.offlineMode) {
                checkForRefresh(i, i2, i3);
            }
        } else {
            bArr = null;
        }
        if (bArr == null && !this.offlineMode && this.tileCachePath != null) {
            String tileFilename = getTileFilename(i, i2, i3);
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            WorkManager instance = WorkManager.getInstance(this.context.getApplicationContext());
            try {
                instance.enqueueUniqueWork(tileFilename, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(MapTileWorker.class).setConstraints(build)).addTag(tileFilename)).setInputData(new Data.Builder().putString(ImagesContract.URL, getTileUrl(i, i2, i3).toString()).putString("filename", tileFilename).putInt("maxAge", -1).build())).build()).getResult().get(1, TimeUnit.SECONDS);
                Thread.sleep(500);
                Log.d("urlTile: ", ((WorkInfo) instance.getWorkInfosByTag(tileFilename).get(1, TimeUnit.SECONDS).get(0)).toString());
                if (this.tileCachePath != null) {
                    bArr = readTileImage(i, i2, i3);
                    if (bArr != null) {
                        Log.d("urlTile", "tile cache fetch HIT for " + i6 + "/" + i4 + "/" + i5);
                    } else {
                        Log.d("urlTile", "tile cache fetch MISS for " + i6 + "/" + i4 + "/" + i5);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (bArr == null && !this.offlineMode) {
            Log.d("urlTile", "Normal fetch");
            bArr = fetchTile(i, i2, i3);
            if (bArr == null) {
                Log.d("urlTile", "tile fetch TIMEOUT / FAIL for " + i6 + "/" + i4 + "/" + i5);
            }
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public byte[] pullTilesFromHigherZoom(int i, int i2, int i3) {
        Bitmap newBitmap = getNewBitmap();
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        int i4 = i * 2;
        int i5 = i2 * 2;
        int i6 = i3 + 1;
        byte[] tileImage = getTileImage(i4, i5, i6);
        int i7 = i5 + 1;
        byte[] tileImage2 = getTileImage(i4, i7, i6);
        int i8 = i4 + 1;
        byte[] tileImage3 = getTileImage(i8, i5, i6);
        byte[] tileImage4 = getTileImage(i8, i7, i6);
        if (tileImage == null || tileImage2 == null || tileImage3 == null || tileImage4 == null) {
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(tileImage, 0, tileImage.length);
        canvas.drawBitmap(decodeByteArray, 0.0f, 0.0f, paint);
        decodeByteArray.recycle();
        Bitmap decodeByteArray2 = BitmapFactory.decodeByteArray(tileImage2, 0, tileImage2.length);
        canvas.drawBitmap(decodeByteArray2, 0.0f, 256.0f, paint);
        decodeByteArray2.recycle();
        Bitmap decodeByteArray3 = BitmapFactory.decodeByteArray(tileImage3, 0, tileImage3.length);
        canvas.drawBitmap(decodeByteArray3, 256.0f, 0.0f, paint);
        decodeByteArray3.recycle();
        Bitmap decodeByteArray4 = BitmapFactory.decodeByteArray(tileImage4, 0, tileImage4.length);
        canvas.drawBitmap(decodeByteArray4, 256.0f, 256.0f, paint);
        decodeByteArray4.recycle();
        byte[] bitmapToByteArray = bitmapToByteArray(newBitmap);
        newBitmap.recycle();
        return bitmapToByteArray;
    }

    /* access modifiers changed from: package-private */
    public Bitmap getNewBitmap() {
        Bitmap createBitmap = Bitmap.createBitmap(512, 512, Bitmap.Config.ARGB_8888);
        createBitmap.eraseColor(0);
        return createBitmap;
    }

    /* access modifiers changed from: package-private */
    public byte[] bitmapToByteArray(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }

    /* access modifiers changed from: package-private */
    public byte[] scaleLowerZoomTile(int i, int i2, int i3, int i4) {
        int i5 = i3 - i4;
        int i6 = 1 << i5;
        int i7 = i >> i5;
        int i8 = i2 >> i5;
        int i9 = i3 - i5;
        int i10 = i % i6;
        int i11 = i2 % i6;
        Bitmap newBitmap = getNewBitmap();
        Canvas canvas = new Canvas(newBitmap);
        Paint paint = new Paint();
        byte[] tileImage = getTileImage(i7, i8, i9);
        if (tileImage == null) {
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(tileImage, 0, tileImage.length);
        int i12 = this.tileSize / i6;
        int i13 = i10 * i12;
        int i14 = i11 * i12;
        canvas.drawBitmap(decodeByteArray, new Rect(i13, i14, i13 + i12, i12 + i14), new Rect(0, 0, 512, 512), paint);
        decodeByteArray.recycle();
        byte[] bitmapToByteArray = bitmapToByteArray(newBitmap);
        newBitmap.recycle();
        return bitmapToByteArray;
    }

    /* access modifiers changed from: package-private */
    public void checkForRefresh(int i, int i2, int i3) {
        String tileFilename = getTileFilename(i, i2, i3);
        if ((System.currentTimeMillis() - new File(tileFilename).lastModified()) / 1000 > ((long) this.tileCacheMaxAge)) {
            Log.d("urlTile", "Refreshing");
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            WorkManager.getInstance(this.context.getApplicationContext()).enqueueUniqueWork(tileFilename, ExistingWorkPolicy.KEEP, (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(MapTileWorker.class).setConstraints(build)).addTag(tileFilename)).setInputData(new Data.Builder().putString(ImagesContract.URL, getTileUrl(i, i2, i3).toString()).putString("filename", tileFilename).putInt("maxAge", this.tileCacheMaxAge).build())).build());
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:6|7|(2:8|(1:10)(1:49))|11|(2:13|14)|15|16|17) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x002e */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004f A[SYNTHETIC, Splitter:B:31:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0054 A[SYNTHETIC, Splitter:B:35:0x0054] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x005b A[SYNTHETIC, Splitter:B:41:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0060 A[SYNTHETIC, Splitter:B:45:0x0060] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] fetchTile(int r7, int r8, int r9) {
        /*
            r6 = this;
            java.net.URL r7 = r6.getTileUrl(r7, r8, r9)
            r8 = 0
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x0047, OutOfMemoryError -> 0x0045, all -> 0x0040 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ IOException -> 0x0047, OutOfMemoryError -> 0x0045, all -> 0x0040 }
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x003d, OutOfMemoryError -> 0x003b, all -> 0x0036 }
            r9.<init>()     // Catch:{ IOException -> 0x003d, OutOfMemoryError -> 0x003b, all -> 0x0036 }
            r0 = 16384(0x4000, float:2.2959E-41)
            byte[] r1 = new byte[r0]     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
        L_0x0016:
            r2 = 0
            int r3 = r7.read(r1, r2, r0)     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            r4 = -1
            if (r3 == r4) goto L_0x0022
            r9.write(r1, r2, r3)     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            goto L_0x0016
        L_0x0022:
            r9.flush()     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            byte[] r8 = r9.toByteArray()     // Catch:{ IOException -> 0x0034, OutOfMemoryError -> 0x0032 }
            if (r7 == 0) goto L_0x002e
            r7.close()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            r9.close()     // Catch:{ Exception -> 0x0031 }
        L_0x0031:
            return r8
        L_0x0032:
            r0 = move-exception
            goto L_0x004a
        L_0x0034:
            r0 = move-exception
            goto L_0x004a
        L_0x0036:
            r9 = move-exception
            r5 = r9
            r9 = r8
            r8 = r5
            goto L_0x0059
        L_0x003b:
            r0 = move-exception
            goto L_0x003e
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            r9 = r8
            goto L_0x004a
        L_0x0040:
            r7 = move-exception
            r9 = r8
            r8 = r7
            r7 = r9
            goto L_0x0059
        L_0x0045:
            r0 = move-exception
            goto L_0x0048
        L_0x0047:
            r0 = move-exception
        L_0x0048:
            r7 = r8
            r9 = r7
        L_0x004a:
            r0.printStackTrace()     // Catch:{ all -> 0x0058 }
            if (r7 == 0) goto L_0x0052
            r7.close()     // Catch:{ Exception -> 0x0052 }
        L_0x0052:
            if (r9 == 0) goto L_0x0057
            r9.close()     // Catch:{ Exception -> 0x0057 }
        L_0x0057:
            return r8
        L_0x0058:
            r8 = move-exception
        L_0x0059:
            if (r7 == 0) goto L_0x005e
            r7.close()     // Catch:{ Exception -> 0x005e }
        L_0x005e:
            if (r9 == 0) goto L_0x0063
            r9.close()     // Catch:{ Exception -> 0x0063 }
        L_0x0063:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileProvider.fetchTile(int, int, int):byte[]");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(11:9|10|(2:11|(1:13)(1:54))|14|(1:16)|17|18|19|20|21|22) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003c */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005c A[SYNTHETIC, Splitter:B:36:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0061 A[SYNTHETIC, Splitter:B:40:0x0061] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0068 A[SYNTHETIC, Splitter:B:46:0x0068] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x006d A[SYNTHETIC, Splitter:B:50:0x006d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] readTileImage(int r7, int r8, int r9) {
        /*
            r6 = this;
            java.lang.String r7 = r6.getTileFilename(r7, r8, r9)
            r8 = 0
            if (r7 != 0) goto L_0x0008
            return r8
        L_0x0008:
            java.io.File r9 = new java.io.File
            r9.<init>(r7)
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0054, OutOfMemoryError -> 0x0052, all -> 0x004d }
            r7.<init>(r9)     // Catch:{ IOException -> 0x0054, OutOfMemoryError -> 0x0052, all -> 0x004d }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0044 }
            r0.<init>()     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x0048, all -> 0x0044 }
            r1 = 16384(0x4000, float:2.2959E-41)
            byte[] r2 = new byte[r1]     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
        L_0x001b:
            r3 = 0
            int r4 = r7.read(r2, r3, r1)     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
            r5 = -1
            if (r4 == r5) goto L_0x0027
            r0.write(r2, r3, r4)     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
            goto L_0x001b
        L_0x0027:
            r0.flush()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
            int r1 = r6.tileCacheMaxAge     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
            if (r1 != 0) goto L_0x0035
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
            r9.setLastModified(r1)     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
        L_0x0035:
            byte[] r8 = r0.toByteArray()     // Catch:{ IOException -> 0x0042, OutOfMemoryError -> 0x0040 }
            r7.close()     // Catch:{ Exception -> 0x003c }
        L_0x003c:
            r0.close()     // Catch:{ Exception -> 0x003f }
        L_0x003f:
            return r8
        L_0x0040:
            r9 = move-exception
            goto L_0x0057
        L_0x0042:
            r9 = move-exception
            goto L_0x0057
        L_0x0044:
            r9 = move-exception
            r0 = r8
            r8 = r9
            goto L_0x0066
        L_0x0048:
            r9 = move-exception
            goto L_0x004b
        L_0x004a:
            r9 = move-exception
        L_0x004b:
            r0 = r8
            goto L_0x0057
        L_0x004d:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r0
            goto L_0x0066
        L_0x0052:
            r9 = move-exception
            goto L_0x0055
        L_0x0054:
            r9 = move-exception
        L_0x0055:
            r7 = r8
            r0 = r7
        L_0x0057:
            r9.printStackTrace()     // Catch:{ all -> 0x0065 }
            if (r7 == 0) goto L_0x005f
            r7.close()     // Catch:{ Exception -> 0x005f }
        L_0x005f:
            if (r0 == 0) goto L_0x0064
            r0.close()     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            return r8
        L_0x0065:
            r8 = move-exception
        L_0x0066:
            if (r7 == 0) goto L_0x006b
            r7.close()     // Catch:{ Exception -> 0x006b }
        L_0x006b:
            if (r0 == 0) goto L_0x0070
            r0.close()     // Catch:{ Exception -> 0x0070 }
        L_0x0070:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileProvider.readTileImage(int, int, int):byte[]");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034 A[SYNTHETIC, Splitter:B:20:0x0034] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x003a A[SYNTHETIC, Splitter:B:25:0x003a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean writeTileImage(byte[] r2, int r3, int r4, int r5) {
        /*
            r1 = this;
            java.lang.String r3 = r1.getTileFilename(r3, r4, r5)
            r4 = 0
            if (r3 != 0) goto L_0x0008
            return r4
        L_0x0008:
            r5 = 0
            java.io.File r0 = new java.io.File     // Catch:{ IOException -> 0x002e, OutOfMemoryError -> 0x002c }
            r0.<init>(r3)     // Catch:{ IOException -> 0x002e, OutOfMemoryError -> 0x002c }
            java.io.File r3 = r0.getParentFile()     // Catch:{ IOException -> 0x002e, OutOfMemoryError -> 0x002c }
            r3.mkdirs()     // Catch:{ IOException -> 0x002e, OutOfMemoryError -> 0x002c }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002e, OutOfMemoryError -> 0x002c }
            r3.<init>(r0)     // Catch:{ IOException -> 0x002e, OutOfMemoryError -> 0x002c }
            r3.write(r2)     // Catch:{ IOException -> 0x0027, OutOfMemoryError -> 0x0025, all -> 0x0022 }
            r3.close()     // Catch:{ Exception -> 0x0020 }
        L_0x0020:
            r2 = 1
            return r2
        L_0x0022:
            r2 = move-exception
            r5 = r3
            goto L_0x0038
        L_0x0025:
            r2 = move-exception
            goto L_0x0028
        L_0x0027:
            r2 = move-exception
        L_0x0028:
            r5 = r3
            goto L_0x002f
        L_0x002a:
            r2 = move-exception
            goto L_0x0038
        L_0x002c:
            r2 = move-exception
            goto L_0x002f
        L_0x002e:
            r2 = move-exception
        L_0x002f:
            r2.printStackTrace()     // Catch:{ all -> 0x002a }
            if (r5 == 0) goto L_0x0037
            r5.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            return r4
        L_0x0038:
            if (r5 == 0) goto L_0x003d
            r5.close()     // Catch:{ Exception -> 0x003d }
        L_0x003d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileProvider.writeTileImage(byte[], int, int, int):boolean");
    }

    /* access modifiers changed from: package-private */
    public String getTileFilename(int i, int i2, int i3) {
        if (this.tileCachePath == null) {
            return null;
        }
        return this.tileCachePath + IOUtils.DIR_SEPARATOR_UNIX + i3 + "/" + i + "/" + i2;
    }

    /* access modifiers changed from: protected */
    public URL getTileUrl(int i, int i2, int i3) {
        return this.tileProvider.getTileUrl(i, i2, i3);
    }

    public void setUrlTemplate(String str) {
        if (this.urlTemplate != str) {
            int i = this.tileSize;
            this.tileProvider = new AIRMapUrlTileProvider(i, i, str);
        }
        this.urlTemplate = str;
    }

    public void setTileSize(int i) {
        if (this.tileSize != i) {
            this.tileProvider = new AIRMapUrlTileProvider(i, i, this.urlTemplate);
        }
        this.tileSize = i;
    }
}
