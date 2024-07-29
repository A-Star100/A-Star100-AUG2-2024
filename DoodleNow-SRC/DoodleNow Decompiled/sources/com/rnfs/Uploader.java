package com.rnfs;

import android.os.AsyncTask;
import android.webkit.MimeTypeMap;
import expo.modules.imagepicker.MediaTypes;
import java.util.concurrent.atomic.AtomicBoolean;

public class Uploader extends AsyncTask<UploadParams, int[], UploadResult> {
    private AtomicBoolean mAbort = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public UploadParams mParams;
    /* access modifiers changed from: private */
    public UploadResult res;

    /* access modifiers changed from: protected */
    public UploadResult doInBackground(UploadParams... uploadParamsArr) {
        this.mParams = uploadParamsArr[0];
        this.res = new UploadResult();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Uploader uploader = Uploader.this;
                    uploader.upload(uploader.mParams, Uploader.this.res);
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                } catch (Exception e) {
                    Uploader.this.res.exception = e;
                    Uploader.this.mParams.onUploadComplete.onUploadComplete(Uploader.this.res);
                }
            }
        }).start();
        return this.res;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:38|39) */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        r22 = r12.getString(r3);
        r26 = r12.getString(r2);
        r9 = r1.getMimeType(r12.getString(r7));
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x00fe */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0345  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x034f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void upload(com.rnfs.UploadParams r37, com.rnfs.UploadResult r38) throws java.lang.Exception {
        /*
            r36 = this;
            r1 = r36
            r0 = r37
            java.lang.String r2 = "filename"
            java.lang.String r3 = "name"
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r5 = r0.files     // Catch:{ all -> 0x0339 }
            java.lang.Object[] r5 = r5.toArray()     // Catch:{ all -> 0x0339 }
            boolean r6 = r0.binaryStreamOnly     // Catch:{ all -> 0x0339 }
            java.net.URL r7 = r0.src     // Catch:{ all -> 0x0339 }
            java.net.URLConnection r7 = r7.openConnection()     // Catch:{ all -> 0x0339 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ all -> 0x0339 }
            r8 = 1
            r7.setDoOutput(r8)     // Catch:{ all -> 0x0334 }
            com.facebook.react.bridge.ReadableMap r9 = r0.headers     // Catch:{ all -> 0x0334 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r9 = r9.keySetIterator()     // Catch:{ all -> 0x0334 }
            java.lang.String r10 = r0.method     // Catch:{ all -> 0x0334 }
            r7.setRequestMethod(r10)     // Catch:{ all -> 0x0334 }
            if (r6 != 0) goto L_0x0030
            java.lang.String r10 = "Content-Type"
            java.lang.String r11 = "multipart/form-data;boundary=*****"
            r7.setRequestProperty(r10, r11)     // Catch:{ all -> 0x0334 }
        L_0x0030:
            boolean r10 = r9.hasNextKey()     // Catch:{ all -> 0x0334 }
            if (r10 == 0) goto L_0x0044
            java.lang.String r10 = r9.nextKey()     // Catch:{ all -> 0x0334 }
            com.facebook.react.bridge.ReadableMap r11 = r0.headers     // Catch:{ all -> 0x0334 }
            java.lang.String r11 = r11.getString(r10)     // Catch:{ all -> 0x0334 }
            r7.setRequestProperty(r10, r11)     // Catch:{ all -> 0x0334 }
            goto L_0x0030
        L_0x0044:
            com.facebook.react.bridge.ReadableMap r9 = r0.fields     // Catch:{ all -> 0x0334 }
            com.facebook.react.bridge.ReadableMapKeySetIterator r9 = r9.keySetIterator()     // Catch:{ all -> 0x0334 }
            java.lang.String r10 = ""
            r11 = r10
        L_0x004d:
            boolean r12 = r9.hasNextKey()     // Catch:{ all -> 0x0334 }
            java.lang.String r13 = "\""
            java.lang.String r14 = "Content-Disposition: form-data; name=\""
            java.lang.String r15 = "\r\n"
            java.lang.String r4 = "--"
            java.lang.String r8 = "*****"
            if (r12 == 0) goto L_0x00a0
            java.lang.String r12 = r9.nextKey()     // Catch:{ all -> 0x009b }
            r17 = r9
            com.facebook.react.bridge.ReadableMap r9 = r0.fields     // Catch:{ all -> 0x009b }
            java.lang.String r9 = r9.getString(r12)     // Catch:{ all -> 0x009b }
            r18 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0330 }
            r7.<init>()     // Catch:{ all -> 0x0330 }
            r7.append(r11)     // Catch:{ all -> 0x0330 }
            r7.append(r4)     // Catch:{ all -> 0x0330 }
            r7.append(r8)     // Catch:{ all -> 0x0330 }
            r7.append(r15)     // Catch:{ all -> 0x0330 }
            r7.append(r14)     // Catch:{ all -> 0x0330 }
            r7.append(r12)     // Catch:{ all -> 0x0330 }
            r7.append(r13)     // Catch:{ all -> 0x0330 }
            r7.append(r15)     // Catch:{ all -> 0x0330 }
            r7.append(r15)     // Catch:{ all -> 0x0330 }
            r7.append(r9)     // Catch:{ all -> 0x0330 }
            r7.append(r15)     // Catch:{ all -> 0x0330 }
            java.lang.String r11 = r7.toString()     // Catch:{ all -> 0x0330 }
            r9 = r17
            r7 = r18
            r8 = 1
            goto L_0x004d
        L_0x009b:
            r0 = move-exception
            r18 = r7
            goto L_0x0331
        L_0x00a0:
            r18 = r7
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0330 }
            r7.<init>()     // Catch:{ all -> 0x0330 }
            r7.append(r10)     // Catch:{ all -> 0x0330 }
            r7.append(r11)     // Catch:{ all -> 0x0330 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0330 }
            int r9 = r5.length     // Catch:{ all -> 0x0330 }
            java.lang.String[] r9 = new java.lang.String[r9]     // Catch:{ all -> 0x0330 }
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r12 = r0.files     // Catch:{ all -> 0x0330 }
            java.util.Iterator r12 = r12.iterator()     // Catch:{ all -> 0x0330 }
            r17 = r7
            r19 = 0
            r21 = r11
            r7 = r17
            r0 = 0
            r17 = r10
            r10 = r19
        L_0x00c7:
            boolean r22 = r12.hasNext()     // Catch:{ all -> 0x0330 }
            r23 = r7
            java.lang.String r7 = "filepath"
            r24 = r9
            java.lang.String r9 = "\r\n--*****--\r\n"
            if (r22 == 0) goto L_0x01bd
            java.lang.Object r22 = r12.next()     // Catch:{ all -> 0x01b3 }
            r25 = r12
            r12 = r22
            com.facebook.react.bridge.ReadableMap r12 = (com.facebook.react.bridge.ReadableMap) r12     // Catch:{ all -> 0x01b3 }
            java.lang.String r22 = r12.getString(r3)     // Catch:{ NoSuchKeyException -> 0x00fc }
            java.lang.String r26 = r12.getString(r2)     // Catch:{ NoSuchKeyException -> 0x00fc }
            r27 = r9
            java.lang.String r9 = "filetype"
            java.lang.String r9 = r12.getString(r9)     // Catch:{ NoSuchKeyException -> 0x00fe }
        L_0x00ef:
            r34 = r22
            r22 = r2
            r2 = r34
            r35 = r26
            r26 = r3
            r3 = r35
            goto L_0x010f
        L_0x00fc:
            r27 = r9
        L_0x00fe:
            java.lang.String r22 = r12.getString(r3)     // Catch:{ all -> 0x01b3 }
            java.lang.String r26 = r12.getString(r2)     // Catch:{ all -> 0x01b3 }
            java.lang.String r9 = r12.getString(r7)     // Catch:{ all -> 0x01b3 }
            java.lang.String r9 = r1.getMimeType(r9)     // Catch:{ all -> 0x01b3 }
            goto L_0x00ef
        L_0x010f:
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x01b3 }
            java.lang.String r7 = r12.getString(r7)     // Catch:{ all -> 0x01b3 }
            r1.<init>(r7)     // Catch:{ all -> 0x01b3 }
            r12 = r0
            long r0 = r1.length()     // Catch:{ all -> 0x01b3 }
            long r10 = r10 + r0
            if (r6 != 0) goto L_0x01a0
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r7.<init>()     // Catch:{ all -> 0x01b3 }
            r7.append(r4)     // Catch:{ all -> 0x01b3 }
            r7.append(r8)     // Catch:{ all -> 0x01b3 }
            r7.append(r15)     // Catch:{ all -> 0x01b3 }
            r7.append(r14)     // Catch:{ all -> 0x01b3 }
            r7.append(r2)     // Catch:{ all -> 0x01b3 }
            java.lang.String r2 = "\"; filename=\""
            r7.append(r2)     // Catch:{ all -> 0x01b3 }
            r7.append(r3)     // Catch:{ all -> 0x01b3 }
            r7.append(r13)     // Catch:{ all -> 0x01b3 }
            r7.append(r15)     // Catch:{ all -> 0x01b3 }
            java.lang.String r2 = "Content-Type: "
            r7.append(r2)     // Catch:{ all -> 0x01b3 }
            r7.append(r9)     // Catch:{ all -> 0x01b3 }
            r7.append(r15)     // Catch:{ all -> 0x01b3 }
            java.lang.String r2 = r7.toString()     // Catch:{ all -> 0x01b3 }
            int r3 = r5.length     // Catch:{ all -> 0x01b3 }
            r7 = 1
            int r3 = r3 - r7
            if (r3 != r12) goto L_0x015e
            int r3 = r27.length()     // Catch:{ all -> 0x01b3 }
            r9 = r8
            long r7 = (long) r3     // Catch:{ all -> 0x01b3 }
            long r10 = r10 + r7
            goto L_0x015f
        L_0x015e:
            r9 = r8
        L_0x015f:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r3.<init>()     // Catch:{ all -> 0x01b3 }
            java.lang.String r7 = "Content-length: "
            r3.append(r7)     // Catch:{ all -> 0x01b3 }
            r3.append(r0)     // Catch:{ all -> 0x01b3 }
            r3.append(r15)     // Catch:{ all -> 0x01b3 }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r1.<init>()     // Catch:{ all -> 0x01b3 }
            r1.append(r2)     // Catch:{ all -> 0x01b3 }
            r1.append(r0)     // Catch:{ all -> 0x01b3 }
            r1.append(r15)     // Catch:{ all -> 0x01b3 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01b3 }
            r24[r12] = r1     // Catch:{ all -> 0x01b3 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b3 }
            r1.<init>()     // Catch:{ all -> 0x01b3 }
            r3 = r23
            r1.append(r3)     // Catch:{ all -> 0x01b3 }
            r1.append(r2)     // Catch:{ all -> 0x01b3 }
            r1.append(r0)     // Catch:{ all -> 0x01b3 }
            r1.append(r15)     // Catch:{ all -> 0x01b3 }
            java.lang.String r0 = r1.toString()     // Catch:{ all -> 0x01b3 }
            r7 = r0
            goto L_0x01a4
        L_0x01a0:
            r9 = r8
            r3 = r23
            r7 = r3
        L_0x01a4:
            int r0 = r12 + 1
            r1 = r36
            r8 = r9
            r2 = r22
            r9 = r24
            r12 = r25
            r3 = r26
            goto L_0x00c7
        L_0x01b3:
            r0 = move-exception
            r2 = 0
            r3 = 0
            r5 = 0
            r1 = r36
            r4 = r18
            goto L_0x033e
        L_0x01bd:
            r27 = r9
            r3 = r23
            com.rnfs.UploadParams r0 = r1.mParams     // Catch:{ all -> 0x0330 }
            com.rnfs.UploadParams$onUploadBegin r0 = r0.onUploadBegin     // Catch:{ all -> 0x0330 }
            if (r0 == 0) goto L_0x01ce
            com.rnfs.UploadParams r0 = r1.mParams     // Catch:{ all -> 0x0330 }
            com.rnfs.UploadParams$onUploadBegin r0 = r0.onUploadBegin     // Catch:{ all -> 0x0330 }
            r0.onUploadBegin()     // Catch:{ all -> 0x0330 }
        L_0x01ce:
            if (r6 != 0) goto L_0x01f7
            int r0 = r3.length()     // Catch:{ all -> 0x0330 }
            int r2 = r5.length     // Catch:{ all -> 0x0330 }
            int r2 = r2 * 2
            int r0 = r0 + r2
            long r2 = (long) r0     // Catch:{ all -> 0x0330 }
            long r2 = r2 + r10
            java.lang.String r0 = "Content-length"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0330 }
            r4.<init>()     // Catch:{ all -> 0x0330 }
            r5 = r17
            r4.append(r5)     // Catch:{ all -> 0x0330 }
            int r2 = (int) r2     // Catch:{ all -> 0x0330 }
            r4.append(r2)     // Catch:{ all -> 0x0330 }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x0330 }
            r4 = r18
            r4.setRequestProperty(r0, r3)     // Catch:{ all -> 0x032e }
            r4.setFixedLengthStreamingMode(r2)     // Catch:{ all -> 0x032e }
            goto L_0x01f9
        L_0x01f7:
            r4 = r18
        L_0x01f9:
            r4.connect()     // Catch:{ all -> 0x032e }
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ all -> 0x032e }
            java.io.OutputStream r0 = r4.getOutputStream()     // Catch:{ all -> 0x032e }
            r2.<init>(r0)     // Catch:{ all -> 0x032e }
            java.nio.channels.WritableByteChannel r0 = java.nio.channels.Channels.newChannel(r2)     // Catch:{ all -> 0x032c }
            if (r6 != 0) goto L_0x0210
            r3 = r21
            r2.writeBytes(r3)     // Catch:{ all -> 0x032c }
        L_0x0210:
            r3 = r37
            java.util.ArrayList<com.facebook.react.bridge.ReadableMap> r3 = r3.files     // Catch:{ all -> 0x032c }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x032c }
            r5 = 0
            r8 = 0
        L_0x021a:
            boolean r9 = r3.hasNext()     // Catch:{ all -> 0x032c }
            if (r9 == 0) goto L_0x029e
            java.lang.Object r9 = r3.next()     // Catch:{ all -> 0x032c }
            com.facebook.react.bridge.ReadableMap r9 = (com.facebook.react.bridge.ReadableMap) r9     // Catch:{ all -> 0x032c }
            if (r6 != 0) goto L_0x022d
            r12 = r24[r5]     // Catch:{ all -> 0x032c }
            r2.writeBytes(r12)     // Catch:{ all -> 0x032c }
        L_0x022d:
            java.io.File r12 = new java.io.File     // Catch:{ all -> 0x032c }
            java.lang.String r9 = r9.getString(r7)     // Catch:{ all -> 0x032c }
            r12.<init>(r9)     // Catch:{ all -> 0x032c }
            long r13 = r12.length()     // Catch:{ all -> 0x032c }
            float r9 = (float) r13     // Catch:{ all -> 0x032c }
            r16 = 1120403456(0x42c80000, float:100.0)
            float r9 = r9 / r16
            r16 = r7
            r37 = r8
            double r7 = (double) r9     // Catch:{ all -> 0x032c }
            double r7 = java.lang.Math.ceil(r7)     // Catch:{ all -> 0x032c }
            long r7 = (long) r7     // Catch:{ all -> 0x032c }
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ all -> 0x032c }
            r9.<init>(r12)     // Catch:{ all -> 0x032c }
            java.nio.channels.FileChannel r12 = r9.getChannel()     // Catch:{ all -> 0x032c }
            r17 = r3
            r21 = r19
            r3 = r37
        L_0x0258:
            int r18 = (r21 > r13 ? 1 : (r21 == r13 ? 0 : -1))
            if (r18 >= 0) goto L_0x0289
            r28 = r12
            r29 = r21
            r31 = r7
            r33 = r0
            long r25 = r28.transferTo(r29, r31, r33)     // Catch:{ all -> 0x032c }
            long r21 = r21 + r25
            r18 = r0
            com.rnfs.UploadParams r0 = r1.mParams     // Catch:{ all -> 0x032c }
            com.rnfs.UploadParams$onUploadProgress r0 = r0.onUploadProgress     // Catch:{ all -> 0x032c }
            if (r0 == 0) goto L_0x0282
            r28 = r7
            long r7 = (long) r3     // Catch:{ all -> 0x032c }
            long r7 = r7 + r25
            int r0 = (int) r7     // Catch:{ all -> 0x032c }
            com.rnfs.UploadParams r3 = r1.mParams     // Catch:{ all -> 0x032c }
            com.rnfs.UploadParams$onUploadProgress r3 = r3.onUploadProgress     // Catch:{ all -> 0x032c }
            int r7 = (int) r10     // Catch:{ all -> 0x032c }
            r3.onUploadProgress(r7, r0)     // Catch:{ all -> 0x032c }
            r3 = r0
            goto L_0x0284
        L_0x0282:
            r28 = r7
        L_0x0284:
            r0 = r18
            r7 = r28
            goto L_0x0258
        L_0x0289:
            r18 = r0
            if (r6 != 0) goto L_0x0290
            r2.writeBytes(r15)     // Catch:{ all -> 0x032c }
        L_0x0290:
            int r5 = r5 + 1
            r9.close()     // Catch:{ all -> 0x032c }
            r8 = r3
            r7 = r16
            r3 = r17
            r0 = r18
            goto L_0x021a
        L_0x029e:
            if (r6 != 0) goto L_0x02a5
            r0 = r27
            r2.writeBytes(r0)     // Catch:{ all -> 0x032c }
        L_0x02a5:
            r2.flush()     // Catch:{ all -> 0x032c }
            r2.close()     // Catch:{ all -> 0x032c }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ all -> 0x032c }
            java.io.InputStream r0 = r4.getInputStream()     // Catch:{ all -> 0x032c }
            r3.<init>(r0)     // Catch:{ all -> 0x032c }
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch:{ all -> 0x032a }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ all -> 0x032a }
            r0.<init>(r3)     // Catch:{ all -> 0x032a }
            r5.<init>(r0)     // Catch:{ all -> 0x032a }
            com.facebook.react.bridge.WritableMap r0 = com.facebook.react.bridge.Arguments.createMap()     // Catch:{ all -> 0x0328 }
            java.util.Map r6 = r4.getHeaderFields()     // Catch:{ all -> 0x0328 }
            java.util.Set r6 = r6.entrySet()     // Catch:{ all -> 0x0328 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0328 }
        L_0x02ce:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0328 }
            if (r7 == 0) goto L_0x02f1
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0328 }
            java.util.Map$Entry r7 = (java.util.Map.Entry) r7     // Catch:{ all -> 0x0328 }
            java.lang.Object r8 = r7.getKey()     // Catch:{ all -> 0x0328 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0328 }
            java.lang.Object r7 = r7.getValue()     // Catch:{ all -> 0x0328 }
            java.util.List r7 = (java.util.List) r7     // Catch:{ all -> 0x0328 }
            r9 = 0
            java.lang.Object r7 = r7.get(r9)     // Catch:{ all -> 0x0328 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ all -> 0x0328 }
            r0.putString(r8, r7)     // Catch:{ all -> 0x0328 }
            goto L_0x02ce
        L_0x02f1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0328 }
            r6.<init>()     // Catch:{ all -> 0x0328 }
        L_0x02f6:
            java.lang.String r7 = r5.readLine()     // Catch:{ all -> 0x0328 }
            if (r7 == 0) goto L_0x0305
            r6.append(r7)     // Catch:{ all -> 0x0328 }
            java.lang.String r7 = "\n"
            r6.append(r7)     // Catch:{ all -> 0x0328 }
            goto L_0x02f6
        L_0x0305:
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0328 }
            int r7 = r4.getResponseCode()     // Catch:{ all -> 0x0328 }
            com.rnfs.UploadResult r8 = r1.res     // Catch:{ all -> 0x0328 }
            r8.headers = r0     // Catch:{ all -> 0x0328 }
            com.rnfs.UploadResult r0 = r1.res     // Catch:{ all -> 0x0328 }
            r0.body = r6     // Catch:{ all -> 0x0328 }
            com.rnfs.UploadResult r0 = r1.res     // Catch:{ all -> 0x0328 }
            r0.statusCode = r7     // Catch:{ all -> 0x0328 }
            if (r4 == 0) goto L_0x031e
            r4.disconnect()
        L_0x031e:
            r2.close()
            r3.close()
            r5.close()
            return
        L_0x0328:
            r0 = move-exception
            goto L_0x033e
        L_0x032a:
            r0 = move-exception
            goto L_0x033d
        L_0x032c:
            r0 = move-exception
            goto L_0x0337
        L_0x032e:
            r0 = move-exception
            goto L_0x0336
        L_0x0330:
            r0 = move-exception
        L_0x0331:
            r4 = r18
            goto L_0x0336
        L_0x0334:
            r0 = move-exception
            r4 = r7
        L_0x0336:
            r2 = 0
        L_0x0337:
            r3 = 0
            goto L_0x033d
        L_0x0339:
            r0 = move-exception
            r2 = 0
            r3 = 0
            r4 = 0
        L_0x033d:
            r5 = 0
        L_0x033e:
            if (r4 == 0) goto L_0x0343
            r4.disconnect()
        L_0x0343:
            if (r2 == 0) goto L_0x0348
            r2.close()
        L_0x0348:
            if (r3 == 0) goto L_0x034d
            r3.close()
        L_0x034d:
            if (r5 == 0) goto L_0x0352
            r5.close()
        L_0x0352:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rnfs.Uploader.upload(com.rnfs.UploadParams, com.rnfs.UploadResult):void");
    }

    /* access modifiers changed from: protected */
    public String getMimeType(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        String mimeTypeFromExtension = fileExtensionFromUrl != null ? MimeTypeMap.getSingleton().getMimeTypeFromExtension(fileExtensionFromUrl.toLowerCase()) : null;
        return mimeTypeFromExtension == null ? MediaTypes.AllMimeType : mimeTypeFromExtension;
    }

    /* access modifiers changed from: protected */
    public void stop() {
        this.mAbort.set(true);
    }
}
