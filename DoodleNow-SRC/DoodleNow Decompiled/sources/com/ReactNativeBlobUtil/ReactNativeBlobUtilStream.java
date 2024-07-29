package com.ReactNativeBlobUtil;

import android.net.Uri;
import androidx.core.app.NotificationCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.UUID;

public class ReactNativeBlobUtilStream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, ReactNativeBlobUtilStream> fileStreams = new HashMap<>();
    private final DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private String encoding = ReactNativeBlobUtilConst.RNFB_RESPONSE_BASE64;
    private OutputStream writeStreamInstance = null;

    ReactNativeBlobUtilStream(ReactApplicationContext reactApplicationContext) {
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0118, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0119, code lost:
        emitStreamEvent(r3, "error", "EUNSPECIFIED", "Failed to convert data to " + r2 + " encoded string. This might be because this encoding cannot be used for this data.");
        r0.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0135, code lost:
        r12 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x006a A[SYNTHETIC, Splitter:B:23:0x006a] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x009a A[Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }] */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0118 A[ExcHandler: Exception (r0v3 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:4:0x001a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void readStream(java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21, com.facebook.react.bridge.ReactApplicationContext r22) {
        /*
            r16 = this;
            r1 = r16
            r2 = r18
            r0 = r20
            r3 = r21
            java.lang.String r4 = "bundle-assets://"
            java.lang.String r5 = "base64"
            java.lang.String r6 = "error"
            java.lang.String r7 = "Unrecognized encoding `"
            java.lang.String r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r17)
            if (r8 == 0) goto L_0x0018
            r9 = r8
            goto L_0x001a
        L_0x0018:
            r9 = r17
        L_0x001a:
            boolean r10 = r2.equalsIgnoreCase(r5)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r10 == 0) goto L_0x0023
            r10 = 4095(0xfff, float:5.738E-42)
            goto L_0x0025
        L_0x0023:
            r10 = 4096(0x1000, float:5.74E-42)
        L_0x0025:
            if (r19 <= 0) goto L_0x0029
            r10 = r19
        L_0x0029:
            java.lang.String r11 = ""
            if (r8 == 0) goto L_0x0042
            boolean r12 = r9.startsWith(r4)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r12 == 0) goto L_0x0042
            com.facebook.react.bridge.ReactApplicationContext r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            android.content.res.AssetManager r8 = r8.getAssets()     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.lang.String r4 = r9.replace(r4, r11)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.io.InputStream r4 = r8.open(r4)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            goto L_0x005d
        L_0x0042:
            if (r8 != 0) goto L_0x0053
            com.facebook.react.bridge.ReactApplicationContext r4 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            android.content.ContentResolver r4 = r4.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            android.net.Uri r8 = android.net.Uri.parse(r9)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.io.InputStream r4 = r4.openInputStream(r8)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            goto L_0x005d
        L_0x0053:
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.io.File r8 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r8.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r4.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
        L_0x005d:
            java.lang.String r8 = "utf8"
            boolean r8 = r2.equalsIgnoreCase(r8)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r12 = -1
            java.lang.String r13 = "data"
            r14 = 0
            if (r8 == 0) goto L_0x009a
            java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.lang.String r7 = "UTF-8"
            java.nio.charset.Charset r7 = java.nio.charset.Charset.forName(r7)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r5.<init>(r4, r7)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.io.BufferedReader r7 = new java.io.BufferedReader     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r7.<init>(r5, r10)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            char[] r8 = new char[r10]     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
        L_0x007c:
            int r15 = r7.read(r8, r14, r10)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r15 == r12) goto L_0x0093
            java.lang.String r12 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r12.<init>(r8, r14, r15)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r13, (java.lang.String) r12)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r0 <= 0) goto L_0x0090
            long r14 = (long) r0     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            android.os.SystemClock.sleep(r14)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
        L_0x0090:
            r12 = -1
            r14 = 0
            goto L_0x007c
        L_0x0093:
            r7.close()     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            goto L_0x00c4
        L_0x009a:
            java.lang.String r8 = "ascii"
            boolean r8 = r2.equalsIgnoreCase(r8)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r8 == 0) goto L_0x00c6
            byte[] r5 = new byte[r10]     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
        L_0x00a4:
            int r7 = r4.read(r5)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r8 = -1
            if (r7 == r8) goto L_0x00c4
            com.facebook.react.bridge.WritableArray r8 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r10 = 0
        L_0x00b0:
            if (r10 >= r7) goto L_0x00ba
            byte r12 = r5[r10]     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r8.pushInt(r12)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            int r10 = r10 + 1
            goto L_0x00b0
        L_0x00ba:
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r13, (com.facebook.react.bridge.WritableArray) r8)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r0 <= 0) goto L_0x00a4
            long r7 = (long) r0     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            android.os.SystemClock.sleep(r7)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            goto L_0x00a4
        L_0x00c4:
            r12 = r9
            goto L_0x00f7
        L_0x00c6:
            boolean r5 = r2.equalsIgnoreCase(r5)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            if (r5 == 0) goto L_0x00fd
            byte[] r5 = new byte[r10]     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
        L_0x00ce:
            int r7 = r4.read(r5)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r8 = -1
            if (r7 == r8) goto L_0x00c4
            r12 = 2
            if (r7 >= r10) goto L_0x00e6
            byte[] r14 = new byte[r7]     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r15 = 0
            java.lang.System.arraycopy(r5, r15, r14, r15, r7)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            java.lang.String r7 = android.util.Base64.encodeToString(r14, r12)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r13, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            goto L_0x00ee
        L_0x00e6:
            r15 = 0
            java.lang.String r7 = android.util.Base64.encodeToString(r5, r12)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r13, (java.lang.String) r7)     // Catch:{ FileNotFoundException -> 0x0135, Exception -> 0x0118 }
        L_0x00ee:
            if (r0 <= 0) goto L_0x00ce
            r12 = r9
            long r8 = (long) r0
            android.os.SystemClock.sleep(r8)     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            r9 = r12
            goto L_0x00ce
        L_0x00f7:
            java.lang.String r0 = "end"
            r1.emitStreamEvent((java.lang.String) r3, (java.lang.String) r0, (java.lang.String) r11)     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            goto L_0x0114
        L_0x00fd:
            r12 = r9
            java.lang.String r0 = "EINVAL"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            r5.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            r5.append(r2)     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            java.lang.String r7 = "`, should be one of `base64`, `utf8`, `ascii`"
            r5.append(r7)     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            java.lang.String r5 = r5.toString()     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            r1.emitStreamEvent(r3, r6, r0, r5)     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
        L_0x0114:
            r4.close()     // Catch:{ FileNotFoundException -> 0x0136, Exception -> 0x0118 }
            goto L_0x014f
        L_0x0118:
            r0 = move-exception
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Failed to convert data to "
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r2 = " encoded string. This might be because this encoding cannot be used for this data."
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r4 = "EUNSPECIFIED"
            r1.emitStreamEvent(r3, r6, r4, r2)
            r0.printStackTrace()
            goto L_0x014f
        L_0x0135:
            r12 = r9
        L_0x0136:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "No such file '"
            r0.<init>(r2)
            r8 = r12
            r0.append(r8)
            java.lang.String r2 = "'"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "ENOENT"
            r1.emitStreamEvent(r3, r6, r2, r0)
        L_0x014f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilStream.readStream(java.lang.String, java.lang.String, int, int, java.lang.String, com.facebook.react.bridge.ReactApplicationContext):void");
    }

    /* access modifiers changed from: package-private */
    public void writeStream(String str, String str2, boolean z, Callback callback) {
        OutputStream outputStream;
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        if (normalizePath != null) {
            str = normalizePath;
        }
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (normalizePath == null || file.exists()) {
                if (file.isDirectory()) {
                    callback.invoke("EISDIR", "Expecting a file but '" + str + "' is a directory");
                    return;
                }
            } else if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                callback.invoke("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                return;
            } else if (!file.createNewFile()) {
                callback.invoke("ENOENT", "File '" + str + "' does not exist and could not be created");
                return;
            }
            if (normalizePath != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
                outputStream = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "")).createOutputStream();
            } else if (normalizePath == null) {
                outputStream = ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openOutputStream(Uri.parse(str));
            } else {
                outputStream = new FileOutputStream(str, z);
            }
            this.encoding = str2;
            String uuid = UUID.randomUUID().toString();
            fileStreams.put(uuid, this);
            this.writeStreamInstance = outputStream;
            callback.invoke(null, null, uuid);
        } catch (Exception e) {
            callback.invoke("EUNSPECIFIED", "Failed to create write stream at path `" + str + "`; " + e.getLocalizedMessage());
        }
    }

    static void writeChunk(String str, String str2, Callback callback) {
        ReactNativeBlobUtilStream reactNativeBlobUtilStream = fileStreams.get(str);
        try {
            reactNativeBlobUtilStream.writeStreamInstance.write(ReactNativeBlobUtilUtils.stringToBytes(str2, reactNativeBlobUtilStream.encoding));
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void writeArrayChunk(String str, ReadableArray readableArray, Callback callback) {
        try {
            OutputStream outputStream = fileStreams.get(str).writeStreamInstance;
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            outputStream.write(bArr);
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static void closeStream(String str, Callback callback) {
        try {
            HashMap<String, ReactNativeBlobUtilStream> hashMap = fileStreams;
            OutputStream outputStream = hashMap.get(str).writeStreamInstance;
            hashMap.remove(str);
            outputStream.close();
            callback.invoke(new Object[0]);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    private void emitStreamEvent(String str, String str2, String str3) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("detail", str3);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    private void emitStreamEvent(String str, String str2, WritableArray writableArray) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putArray("detail", writableArray);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }

    private void emitStreamEvent(String str, String str2, String str3, String str4) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(NotificationCompat.CATEGORY_EVENT, str2);
        createMap.putString("code", str3);
        createMap.putString("detail", str4);
        createMap.putString("streamId", str);
        this.emitter.emit(ReactNativeBlobUtilConst.EVENT_FILESYSTEM, createMap);
    }
}
