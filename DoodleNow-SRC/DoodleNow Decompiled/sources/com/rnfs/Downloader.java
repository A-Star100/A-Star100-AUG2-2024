package com.rnfs;

import android.os.AsyncTask;
import android.os.Build;
import com.rnfs.DownloadParams;
import java.net.HttpURLConnection;
import java.util.concurrent.atomic.AtomicBoolean;

public class Downloader extends AsyncTask<DownloadParams, long[], DownloadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public DownloadParams mParam;
    DownloadResult res;

    /* access modifiers changed from: protected */
    public void onPostExecute(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public DownloadResult doInBackground(DownloadParams... downloadParamsArr) {
        this.mParam = downloadParamsArr[0];
        this.res = new DownloadResult();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Downloader downloader = Downloader.this;
                    downloader.download(downloader.mParam, Downloader.this.res);
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                } catch (Exception e) {
                    Downloader.this.res.exception = e;
                    Downloader.this.mParam.onTaskCompleted.onTaskCompleted(Downloader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r5 == 308) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0226  */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x022b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void download(com.rnfs.DownloadParams r31, com.rnfs.DownloadResult r32) throws java.lang.Exception {
        /*
            r30 = this;
            r1 = r30
            r0 = r31
            r2 = r32
            r3 = 0
            java.net.URL r4 = r0.src     // Catch:{ all -> 0x021c }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x021c }
            java.net.HttpURLConnection r4 = (java.net.HttpURLConnection) r4     // Catch:{ all -> 0x021c }
            com.facebook.react.bridge.ReadableMap r5 = r0.headers     // Catch:{ all -> 0x0218 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r5 = r5.keySetIterator()     // Catch:{ all -> 0x0218 }
        L_0x0015:
            boolean r6 = r5.hasNextKey()     // Catch:{ all -> 0x0218 }
            if (r6 == 0) goto L_0x0029
            java.lang.String r6 = r5.nextKey()     // Catch:{ all -> 0x0218 }
            com.facebook.react.bridge.ReadableMap r7 = r0.headers     // Catch:{ all -> 0x0218 }
            java.lang.String r7 = r7.getString(r6)     // Catch:{ all -> 0x0218 }
            r4.setRequestProperty(r6, r7)     // Catch:{ all -> 0x0218 }
            goto L_0x0015
        L_0x0029:
            int r5 = r0.connectionTimeout     // Catch:{ all -> 0x0218 }
            r4.setConnectTimeout(r5)     // Catch:{ all -> 0x0218 }
            int r5 = r0.readTimeout     // Catch:{ all -> 0x0218 }
            r4.setReadTimeout(r5)     // Catch:{ all -> 0x0218 }
            r4.connect()     // Catch:{ all -> 0x0218 }
            int r5 = r4.getResponseCode()     // Catch:{ all -> 0x0218 }
            long r6 = r1.getContentLength(r4)     // Catch:{ all -> 0x0218 }
            r8 = 200(0xc8, float:2.8E-43)
            if (r5 == r8) goto L_0x0081
            r9 = 301(0x12d, float:4.22E-43)
            if (r5 == r9) goto L_0x0052
            r9 = 302(0x12e, float:4.23E-43)
            if (r5 == r9) goto L_0x0052
            r9 = 307(0x133, float:4.3E-43)
            if (r5 == r9) goto L_0x0052
            r9 = 308(0x134, float:4.32E-43)
            if (r5 != r9) goto L_0x0081
        L_0x0052:
            java.lang.String r5 = "Location"
            java.lang.String r5 = r4.getHeaderField(r5)     // Catch:{ all -> 0x0218 }
            r4.disconnect()     // Catch:{ all -> 0x0218 }
            java.net.URL r6 = new java.net.URL     // Catch:{ all -> 0x0218 }
            r6.<init>(r5)     // Catch:{ all -> 0x0218 }
            java.net.URLConnection r5 = r6.openConnection()     // Catch:{ all -> 0x0218 }
            java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ all -> 0x0218 }
            r4 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r4)     // Catch:{ all -> 0x007c }
            r5.connect()     // Catch:{ all -> 0x007c }
            int r4 = r5.getResponseCode()     // Catch:{ all -> 0x007c }
            long r6 = r1.getContentLength(r5)     // Catch:{ all -> 0x007c }
            r28 = r5
            r5 = r4
            r4 = r28
            goto L_0x0081
        L_0x007c:
            r0 = move-exception
            r6 = r3
            r12 = r5
            goto L_0x021f
        L_0x0081:
            if (r5 < r8) goto L_0x01fd
            r8 = 300(0x12c, float:4.2E-43)
            if (r5 >= r8) goto L_0x01fd
            java.util.Map r8 = r4.getHeaderFields()     // Catch:{ all -> 0x01f9 }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x01f9 }
            r9.<init>()     // Catch:{ all -> 0x01f9 }
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x01f9 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x01f9 }
        L_0x0098:
            boolean r10 = r8.hasNext()     // Catch:{ all -> 0x01f9 }
            r11 = 0
            if (r10 == 0) goto L_0x00bf
            java.lang.Object r10 = r8.next()     // Catch:{ all -> 0x0218 }
            java.util.Map$Entry r10 = (java.util.Map.Entry) r10     // Catch:{ all -> 0x0218 }
            java.lang.Object r12 = r10.getKey()     // Catch:{ all -> 0x0218 }
            java.lang.String r12 = (java.lang.String) r12     // Catch:{ all -> 0x0218 }
            java.lang.Object r10 = r10.getValue()     // Catch:{ all -> 0x0218 }
            java.util.List r10 = (java.util.List) r10     // Catch:{ all -> 0x0218 }
            java.lang.Object r10 = r10.get(r11)     // Catch:{ all -> 0x0218 }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0218 }
            if (r12 == 0) goto L_0x0098
            if (r10 == 0) goto L_0x0098
            r9.put(r12, r10)     // Catch:{ all -> 0x0218 }
            goto L_0x0098
        L_0x00bf:
            com.rnfs.DownloadParams r8 = r1.mParam     // Catch:{ all -> 0x01f9 }
            com.rnfs.DownloadParams$OnDownloadBegin r8 = r8.onDownloadBegin     // Catch:{ all -> 0x01f9 }
            if (r8 == 0) goto L_0x00cc
            com.rnfs.DownloadParams r8 = r1.mParam     // Catch:{ all -> 0x0218 }
            com.rnfs.DownloadParams$OnDownloadBegin r8 = r8.onDownloadBegin     // Catch:{ all -> 0x0218 }
            r8.onDownloadBegin(r5, r6, r9)     // Catch:{ all -> 0x0218 }
        L_0x00cc:
            java.io.BufferedInputStream r8 = new java.io.BufferedInputStream     // Catch:{ all -> 0x01f9 }
            java.io.InputStream r9 = r4.getInputStream()     // Catch:{ all -> 0x01f9 }
            r10 = 8192(0x2000, float:1.14794E-41)
            r8.<init>(r9, r10)     // Catch:{ all -> 0x01f9 }
            java.io.FileOutputStream r9 = new java.io.FileOutputStream     // Catch:{ all -> 0x01f5 }
            java.io.File r12 = r0.dest     // Catch:{ all -> 0x01f5 }
            r9.<init>(r12)     // Catch:{ all -> 0x01f5 }
            byte[] r3 = new byte[r10]     // Catch:{ all -> 0x01f0 }
            com.rnfs.DownloadParams r10 = r1.mParam     // Catch:{ all -> 0x01f0 }
            com.rnfs.DownloadParams$OnDownloadProgress r10 = r10.onDownloadProgress     // Catch:{ all -> 0x01f0 }
            if (r10 == 0) goto L_0x00e8
            r10 = 1
            goto L_0x00e9
        L_0x00e8:
            r10 = r11
        L_0x00e9:
            r15 = 0
            r13 = r15
            r19 = 0
        L_0x00ee:
            int r11 = r8.read(r3)     // Catch:{ all -> 0x01f0 }
            r12 = -1
            if (r11 == r12) goto L_0x01e1
            java.util.concurrent.atomic.AtomicBoolean r12 = r1.mAbort     // Catch:{ all -> 0x01f0 }
            boolean r12 = r12.get()     // Catch:{ all -> 0x01f0 }
            if (r12 != 0) goto L_0x01d7
            r12 = r4
            r21 = r5
            long r4 = (long) r11
            long r13 = r13 + r4
            if (r10 == 0) goto L_0x01b8
            int r4 = r0.progressInterval     // Catch:{ all -> 0x01b6 }
            if (r4 <= 0) goto L_0x0133
            long r22 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x01b6 }
            long r24 = r22 - r15
            int r4 = r0.progressInterval     // Catch:{ all -> 0x01b6 }
            r26 = r6
            long r5 = (long) r4     // Catch:{ all -> 0x01b6 }
            int r4 = (r24 > r5 ? 1 : (r24 == r5 ? 0 : -1))
            if (r4 <= 0) goto L_0x0129
            r4 = 1
            long[][] r5 = new long[r4][]     // Catch:{ all -> 0x01b6 }
            r6 = 2
            long[] r6 = new long[r6]     // Catch:{ all -> 0x01b6 }
            r7 = 0
            r6[r7] = r26     // Catch:{ all -> 0x01b6 }
            r6[r4] = r13     // Catch:{ all -> 0x01b6 }
            r5[r7] = r6     // Catch:{ all -> 0x01b6 }
            r1.publishProgress(r5)     // Catch:{ all -> 0x01b6 }
            r15 = r22
        L_0x0129:
            r2 = r3
            r6 = r8
            r7 = r26
            r0 = 1
            r3 = 0
            r17 = 0
            goto L_0x01c5
        L_0x0133:
            r26 = r6
            float r4 = r0.progressDivider     // Catch:{ all -> 0x01b6 }
            r5 = 0
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0156
            r4 = 1
            long[][] r5 = new long[r4][]     // Catch:{ all -> 0x01b6 }
            r6 = 2
            long[] r6 = new long[r6]     // Catch:{ all -> 0x01b6 }
            r7 = 0
            r6[r7] = r26     // Catch:{ all -> 0x01b6 }
            r6[r4] = r13     // Catch:{ all -> 0x01b6 }
            r5[r7] = r6     // Catch:{ all -> 0x01b6 }
            r1.publishProgress(r5)     // Catch:{ all -> 0x01b6 }
            r23 = r3
            r6 = r8
            r7 = r26
            r0 = 1
            r17 = 0
            goto L_0x01c2
        L_0x0156:
            double r4 = (double) r13
            r22 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r4 * r22
            r23 = r3
            r6 = r8
            r7 = r26
            double r2 = (double) r7
            double r4 = r4 / r2
            long r2 = java.lang.Math.round(r4)     // Catch:{ all -> 0x01ee }
            double r2 = (double) r2     // Catch:{ all -> 0x01ee }
            float r4 = r0.progressDivider     // Catch:{ all -> 0x01ee }
            double r4 = (double) r4     // Catch:{ all -> 0x01ee }
            double r4 = r2 % r4
            r17 = 0
            int r4 = (r4 > r17 ? 1 : (r4 == r17 ? 0 : -1))
            if (r4 != 0) goto L_0x01b4
            int r4 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r4 != 0) goto L_0x017a
            int r4 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r4 != 0) goto L_0x01b4
        L_0x017a:
            java.lang.String r4 = "Downloader"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ee }
            r5.<init>()     // Catch:{ all -> 0x01ee }
            java.lang.String r0 = "EMIT: "
            r5.append(r0)     // Catch:{ all -> 0x01ee }
            java.lang.String r0 = java.lang.String.valueOf(r2)     // Catch:{ all -> 0x01ee }
            r5.append(r0)     // Catch:{ all -> 0x01ee }
            java.lang.String r0 = ", TOTAL:"
            r5.append(r0)     // Catch:{ all -> 0x01ee }
            java.lang.String r0 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x01ee }
            r5.append(r0)     // Catch:{ all -> 0x01ee }
            java.lang.String r0 = r5.toString()     // Catch:{ all -> 0x01ee }
            android.util.Log.d(r4, r0)     // Catch:{ all -> 0x01ee }
            r0 = 1
            long[][] r4 = new long[r0][]     // Catch:{ all -> 0x01ee }
            r5 = 2
            long[] r5 = new long[r5]     // Catch:{ all -> 0x01ee }
            r19 = 0
            r5[r19] = r7     // Catch:{ all -> 0x01ee }
            r5[r0] = r13     // Catch:{ all -> 0x01ee }
            r4[r19] = r5     // Catch:{ all -> 0x01ee }
            r1.publishProgress(r4)     // Catch:{ all -> 0x01ee }
            r19 = r2
            goto L_0x01c2
        L_0x01b4:
            r0 = 1
            goto L_0x01c2
        L_0x01b6:
            r0 = move-exception
            goto L_0x01f2
        L_0x01b8:
            r23 = r3
            r0 = 1
            r17 = 0
            r28 = r6
            r6 = r8
            r7 = r28
        L_0x01c2:
            r2 = r23
            r3 = 0
        L_0x01c5:
            r9.write(r2, r3, r11)     // Catch:{ all -> 0x01ee }
            r0 = r31
            r3 = r2
            r4 = r12
            r5 = r21
            r2 = r32
            r28 = r7
            r8 = r6
            r6 = r28
            goto L_0x00ee
        L_0x01d7:
            r12 = r4
            r6 = r8
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ all -> 0x01ee }
            java.lang.String r2 = "Download has been aborted"
            r0.<init>(r2)     // Catch:{ all -> 0x01ee }
            throw r0     // Catch:{ all -> 0x01ee }
        L_0x01e1:
            r12 = r4
            r21 = r5
            r6 = r8
            r9.flush()     // Catch:{ all -> 0x01ee }
            r0 = r32
            r0.bytesWritten = r13     // Catch:{ all -> 0x01ee }
            r3 = r9
            goto L_0x0202
        L_0x01ee:
            r0 = move-exception
            goto L_0x01f3
        L_0x01f0:
            r0 = move-exception
            r12 = r4
        L_0x01f2:
            r6 = r8
        L_0x01f3:
            r3 = r9
            goto L_0x021f
        L_0x01f5:
            r0 = move-exception
            r12 = r4
            r6 = r8
            goto L_0x021f
        L_0x01f9:
            r0 = move-exception
            r12 = r4
            r6 = r3
            goto L_0x021f
        L_0x01fd:
            r0 = r2
            r12 = r4
            r21 = r5
            r6 = r3
        L_0x0202:
            r4 = r21
            r0.statusCode = r4     // Catch:{ all -> 0x0216 }
            if (r3 == 0) goto L_0x020b
            r3.close()
        L_0x020b:
            if (r6 == 0) goto L_0x0210
            r6.close()
        L_0x0210:
            if (r12 == 0) goto L_0x0215
            r12.disconnect()
        L_0x0215:
            return
        L_0x0216:
            r0 = move-exception
            goto L_0x021f
        L_0x0218:
            r0 = move-exception
            r6 = r3
            r12 = r4
            goto L_0x021f
        L_0x021c:
            r0 = move-exception
            r6 = r3
            r12 = r6
        L_0x021f:
            if (r3 == 0) goto L_0x0224
            r3.close()
        L_0x0224:
            if (r6 == 0) goto L_0x0229
            r6.close()
        L_0x0229:
            if (r12 == 0) goto L_0x022e
            r12.disconnect()
        L_0x022e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Downloader.download(com.rnfs.DownloadParams, com.rnfs.DownloadResult):void");
    }

    private long getContentLength(HttpURLConnection httpURLConnection) {
        if (Build.VERSION.SDK_INT >= 24) {
            return httpURLConnection.getContentLengthLong();
        }
        return (long) httpURLConnection.getContentLength();
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.mAbort.set(true);
    }

    /* access modifiers changed from: protected */
    public void onProgressUpdate(long[]... jArr) {
        super.onProgressUpdate(jArr);
        if (this.mParam.onDownloadProgress != null) {
            DownloadParams.OnDownloadProgress onDownloadProgress = this.mParam.onDownloadProgress;
            long[] jArr2 = jArr[0];
            onDownloadProgress.onDownloadProgress(jArr2[0], jArr2[1]);
        }
    }
}
