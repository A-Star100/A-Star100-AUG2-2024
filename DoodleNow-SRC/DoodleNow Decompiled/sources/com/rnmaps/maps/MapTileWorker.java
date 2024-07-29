package com.rnmaps.maps;

import android.content.Context;
import android.util.Log;
import androidx.work.ListenableWorker;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import com.google.android.gms.common.internal.ImagesContract;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class MapTileWorker extends Worker {
    private static final int BUFFER_SIZE = 16384;

    public MapTileWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public ListenableWorker.Result doWork() {
        String string = getInputData().getString("filename");
        try {
            int i = getInputData().getInt("maxAge", 0);
            if (i >= 0) {
                if ((System.currentTimeMillis() - new File(string).lastModified()) / 1000 < ((long) i)) {
                    return ListenableWorker.Result.failure();
                }
            }
            try {
                byte[] fetchTile = fetchTile(new URL(getInputData().getString(ImagesContract.URL)));
                if (fetchTile == null) {
                    return ListenableWorker.Result.retry();
                }
                if (!writeTileImage(fetchTile, string)) {
                    return ListenableWorker.Result.failure();
                }
                Log.d("urlTile", "Worker fetched " + string);
                return ListenableWorker.Result.success();
            } catch (MalformedURLException e) {
                throw new AssertionError(e);
            }
        } catch (Error unused) {
            return ListenableWorker.Result.failure();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(11:3|4|5|6|7|(2:8|(1:10)(1:49))|11|(2:13|14)|15|16|17) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0026 */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0047 A[SYNTHETIC, Splitter:B:31:0x0047] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x004c A[SYNTHETIC, Splitter:B:35:0x004c] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0053 A[SYNTHETIC, Splitter:B:41:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0058 A[SYNTHETIC, Splitter:B:45:0x0058] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] fetchTile(java.net.URL r9) {
        /*
            r8 = this;
            r0 = 0
            java.io.InputStream r9 = r9.openStream()     // Catch:{ IOException -> 0x003f, OutOfMemoryError -> 0x003d, all -> 0x0038 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0035, OutOfMemoryError -> 0x0033, all -> 0x002e }
            r1.<init>()     // Catch:{ IOException -> 0x0035, OutOfMemoryError -> 0x0033, all -> 0x002e }
            r2 = 16384(0x4000, float:2.2959E-41)
            byte[] r3 = new byte[r2]     // Catch:{ IOException -> 0x002c, OutOfMemoryError -> 0x002a }
        L_0x000e:
            r4 = 0
            int r5 = r9.read(r3, r4, r2)     // Catch:{ IOException -> 0x002c, OutOfMemoryError -> 0x002a }
            r6 = -1
            if (r5 == r6) goto L_0x001a
            r1.write(r3, r4, r5)     // Catch:{ IOException -> 0x002c, OutOfMemoryError -> 0x002a }
            goto L_0x000e
        L_0x001a:
            r1.flush()     // Catch:{ IOException -> 0x002c, OutOfMemoryError -> 0x002a }
            byte[] r0 = r1.toByteArray()     // Catch:{ IOException -> 0x002c, OutOfMemoryError -> 0x002a }
            if (r9 == 0) goto L_0x0026
            r9.close()     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            r1.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            return r0
        L_0x002a:
            r2 = move-exception
            goto L_0x0042
        L_0x002c:
            r2 = move-exception
            goto L_0x0042
        L_0x002e:
            r1 = move-exception
            r7 = r1
            r1 = r0
            r0 = r7
            goto L_0x0051
        L_0x0033:
            r2 = move-exception
            goto L_0x0036
        L_0x0035:
            r2 = move-exception
        L_0x0036:
            r1 = r0
            goto L_0x0042
        L_0x0038:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
            goto L_0x0051
        L_0x003d:
            r2 = move-exception
            goto L_0x0040
        L_0x003f:
            r2 = move-exception
        L_0x0040:
            r9 = r0
            r1 = r9
        L_0x0042:
            r2.printStackTrace()     // Catch:{ all -> 0x0050 }
            if (r9 == 0) goto L_0x004a
            r9.close()     // Catch:{ Exception -> 0x004a }
        L_0x004a:
            if (r1 == 0) goto L_0x004f
            r1.close()     // Catch:{ Exception -> 0x004f }
        L_0x004f:
            return r0
        L_0x0050:
            r0 = move-exception
        L_0x0051:
            if (r9 == 0) goto L_0x0056
            r9.close()     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileWorker.fetchTile(java.net.URL):byte[]");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0030 A[SYNTHETIC, Splitter:B:20:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0036 A[SYNTHETIC, Splitter:B:25:0x0036] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean writeTileImage(byte[] r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            java.io.File r2 = new java.io.File     // Catch:{ IOException -> 0x002a, OutOfMemoryError -> 0x0028 }
            r2.<init>(r5)     // Catch:{ IOException -> 0x002a, OutOfMemoryError -> 0x0028 }
            java.io.File r5 = r2.getParentFile()     // Catch:{ IOException -> 0x002a, OutOfMemoryError -> 0x0028 }
            r5.mkdirs()     // Catch:{ IOException -> 0x002a, OutOfMemoryError -> 0x0028 }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x002a, OutOfMemoryError -> 0x0028 }
            r5.<init>(r2)     // Catch:{ IOException -> 0x002a, OutOfMemoryError -> 0x0028 }
            r5.write(r4)     // Catch:{ IOException -> 0x0023, OutOfMemoryError -> 0x0021, all -> 0x001e }
            r5.close()     // Catch:{ Exception -> 0x001c }
        L_0x001c:
            r4 = 1
            return r4
        L_0x001e:
            r4 = move-exception
            r1 = r5
            goto L_0x0034
        L_0x0021:
            r4 = move-exception
            goto L_0x0024
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            r1 = r5
            goto L_0x002b
        L_0x0026:
            r4 = move-exception
            goto L_0x0034
        L_0x0028:
            r4 = move-exception
            goto L_0x002b
        L_0x002a:
            r4 = move-exception
        L_0x002b:
            r4.printStackTrace()     // Catch:{ all -> 0x0026 }
            if (r1 == 0) goto L_0x0033
            r1.close()     // Catch:{ Exception -> 0x0033 }
        L_0x0033:
            return r0
        L_0x0034:
            if (r1 == 0) goto L_0x0039
            r1.close()     // Catch:{ Exception -> 0x0039 }
        L_0x0039:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnmaps.maps.MapTileWorker.writeTileImage(byte[], java.lang.String):boolean");
    }
}
