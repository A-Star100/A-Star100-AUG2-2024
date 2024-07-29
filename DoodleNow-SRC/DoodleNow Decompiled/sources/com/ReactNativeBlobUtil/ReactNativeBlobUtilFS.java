package com.ReactNativeBlobUtil;

import android.content.res.AssetFileDescriptor;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.StatFs;
import androidx.work.Data;
import com.facebook.common.util.UriUtil;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.revenuecat.purchases.common.verification.SigningManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class ReactNativeBlobUtilFS {
    private DeviceEventManagerModule.RCTDeviceEventEmitter emitter;
    private ReactApplicationContext mCtx;

    ReactNativeBlobUtilFS(ReactApplicationContext reactApplicationContext) {
        this.mCtx = reactApplicationContext;
        this.emitter = (DeviceEventManagerModule.RCTDeviceEventEmitter) reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0073 A[Catch:{ all -> 0x008e, FileNotFoundException | Exception -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0078 A[Catch:{ all -> 0x008e, FileNotFoundException | Exception -> 0x0093 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean writeFile(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            java.lang.String r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            java.io.File r1 = new java.io.File     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            r1.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            java.io.File r3 = r1.getParentFile()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            boolean r2 = r1.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r2 != 0) goto L_0x0030
            if (r3 == 0) goto L_0x0029
            boolean r2 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r2 != 0) goto L_0x0029
            boolean r2 = r3.mkdirs()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r2 != 0) goto L_0x0029
            boolean r3 = r3.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r3 != 0) goto L_0x0029
            return r0
        L_0x0029:
            boolean r3 = r1.createNewFile()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r3 != 0) goto L_0x0030
            return r0
        L_0x0030:
            java.lang.String r3 = "uri"
            boolean r3 = r4.equalsIgnoreCase(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r3 == 0) goto L_0x007c
            java.lang.String r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r5)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            r4.<init>(r3)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            boolean r3 = r4.exists()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            if (r3 != 0) goto L_0x0049
            return r0
        L_0x0049:
            r3 = 10240(0x2800, float:1.4349E-41)
            byte[] r3 = new byte[r3]     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            r5 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x006f }
            r2.<init>(r4)     // Catch:{ all -> 0x006f }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ all -> 0x006b }
            r4.<init>(r1, r6)     // Catch:{ all -> 0x006b }
        L_0x0058:
            int r5 = r2.read(r3)     // Catch:{ all -> 0x0069 }
            if (r5 <= 0) goto L_0x0062
            r4.write(r3, r0, r5)     // Catch:{ all -> 0x0069 }
            goto L_0x0058
        L_0x0062:
            r2.close()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            goto L_0x008c
        L_0x0069:
            r3 = move-exception
            goto L_0x006d
        L_0x006b:
            r3 = move-exception
            r4 = r5
        L_0x006d:
            r5 = r2
            goto L_0x0071
        L_0x006f:
            r3 = move-exception
            r4 = r5
        L_0x0071:
            if (r5 == 0) goto L_0x0076
            r5.close()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
        L_0x0076:
            if (r4 == 0) goto L_0x007b
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
        L_0x007b:
            throw r3     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
        L_0x007c:
            byte[] r3 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.stringToBytes(r5, r4)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            r4.<init>(r1, r6)     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            r4.write(r3)     // Catch:{ all -> 0x008e }
            int r3 = r3.length     // Catch:{ all -> 0x008e }
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
        L_0x008c:
            r3 = 1
            return r3
        L_0x008e:
            r3 = move-exception
            r4.close()     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
            throw r3     // Catch:{ FileNotFoundException | Exception -> 0x0093 }
        L_0x0093:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x00bf A[Catch:{ all -> 0x00f5, FileNotFoundException -> 0x0103, Exception -> 0x00fa }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c4 A[Catch:{ all -> 0x00f5, FileNotFoundException -> 0x0103, Exception -> 0x00fa }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void writeFile(java.lang.String r8, java.lang.String r9, java.lang.String r10, boolean r11, boolean r12, com.facebook.react.bridge.Promise r13) {
        /*
            java.lang.String r0 = "EUNSPECIFIED"
            java.lang.String r1 = "ENOENT"
            java.lang.String r2 = "No such file '"
            java.lang.String r3 = "Failed to create parent directory of '"
            java.lang.String r4 = "File '"
            java.io.File r5 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r5.<init>(r8)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.io.File r6 = r5.getParentFile()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            boolean r7 = r5.exists()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r7 != 0) goto L_0x005d
            if (r6 == 0) goto L_0x0042
            boolean r7 = r6.exists()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r7 != 0) goto L_0x0042
            boolean r7 = r6.mkdirs()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r7 != 0) goto L_0x0042
            boolean r6 = r6.exists()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r6 != 0) goto L_0x0042
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r9.<init>(r3)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r9.append(r8)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r10 = "'"
            r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r13.reject((java.lang.String) r0, (java.lang.String) r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            return
        L_0x0042:
            boolean r3 = r5.createNewFile()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r3 != 0) goto L_0x005d
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r9.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r9.append(r8)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r10 = "' does not exist and could not be created"
            r9.append(r10)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r9 = r9.toString()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r13.reject((java.lang.String) r1, (java.lang.String) r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            return
        L_0x005d:
            java.lang.String r3 = "uri"
            boolean r3 = r9.equalsIgnoreCase(r3)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r3 == 0) goto L_0x00c8
            java.lang.String r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r10)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.io.File r10 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            boolean r11 = r10.exists()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r11 != 0) goto L_0x0092
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.append(r8)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r11 = "' ('"
            r10.append(r11)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.append(r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r9 = "')"
            r10.append(r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r9 = r10.toString()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r13.reject((java.lang.String) r1, (java.lang.String) r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            return
        L_0x0092:
            r9 = 10240(0x2800, float:1.4349E-41)
            byte[] r9 = new byte[r9]     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r11 = 0
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ all -> 0x00bb }
            r2.<init>(r10)     // Catch:{ all -> 0x00bb }
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ all -> 0x00b7 }
            r10.<init>(r5, r12)     // Catch:{ all -> 0x00b7 }
            r11 = 0
            r12 = r11
        L_0x00a3:
            int r3 = r2.read(r9)     // Catch:{ all -> 0x00b5 }
            if (r3 <= 0) goto L_0x00ae
            r10.write(r9, r11, r3)     // Catch:{ all -> 0x00b5 }
            int r12 = r12 + r3
            goto L_0x00a3
        L_0x00ae:
            r2.close()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.close()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            goto L_0x00ed
        L_0x00b5:
            r9 = move-exception
            goto L_0x00b9
        L_0x00b7:
            r9 = move-exception
            r10 = r11
        L_0x00b9:
            r11 = r2
            goto L_0x00bd
        L_0x00bb:
            r9 = move-exception
            r10 = r11
        L_0x00bd:
            if (r11 == 0) goto L_0x00c2
            r11.close()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
        L_0x00c2:
            if (r10 == 0) goto L_0x00c7
            r10.close()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
        L_0x00c7:
            throw r9     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
        L_0x00c8:
            byte[] r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.stringToBytes(r10, r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r11 == 0) goto L_0x00e1
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            if (r10 == 0) goto L_0x00d9
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r10 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            byte[] r9 = r10.onWriteFile(r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            goto L_0x00e1
        L_0x00d9:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            java.lang.String r10 = "Write file with transform was specified but the shared file transformer is not set"
            r9.<init>(r10)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            throw r9     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
        L_0x00e1:
            java.io.FileOutputStream r10 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.<init>(r5, r12)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r10.write(r9)     // Catch:{ all -> 0x00f5 }
            int r12 = r9.length     // Catch:{ all -> 0x00f5 }
            r10.close()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
        L_0x00ed:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r12)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            r13.resolve(r9)     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            goto L_0x0117
        L_0x00f5:
            r9 = move-exception
            r10.close()     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
            throw r9     // Catch:{ FileNotFoundException -> 0x0103, Exception -> 0x00fa }
        L_0x00fa:
            r8 = move-exception
            java.lang.String r8 = r8.getLocalizedMessage()
            r13.reject((java.lang.String) r0, (java.lang.String) r8)
            goto L_0x0117
        L_0x0103:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r4)
            r9.append(r8)
            java.lang.String r8 = "' does not exist and could not be created, or it is a directory"
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            r13.reject((java.lang.String) r1, (java.lang.String) r8)
        L_0x0117:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, com.facebook.react.bridge.Promise):void");
    }

    static void writeFile(String str, ReadableArray readableArray, boolean z, Promise promise) {
        FileOutputStream fileOutputStream;
        try {
            File file = new File(str);
            File parentFile = file.getParentFile();
            if (!file.exists()) {
                if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
                    promise.reject("ENOTDIR", "Failed to create parent directory of '" + str + "'");
                    return;
                } else if (!file.createNewFile()) {
                    promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
                    return;
                }
            }
            fileOutputStream = new FileOutputStream(file, z);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            promise.resolve(Integer.valueOf(readableArray.size()));
        } catch (FileNotFoundException unused) {
            promise.reject("ENOENT", "File '" + str + "' does not exist and could not be created");
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x006d A[Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0085 A[Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d8 A[Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0102 A[Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void readFile(java.lang.String r7, java.lang.String r8, boolean r9, com.facebook.react.bridge.Promise r10) {
        /*
            java.lang.String r0 = "bundle-assets://"
            java.lang.String r1 = "Read only "
            java.lang.String r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r7)
            if (r2 == 0) goto L_0x000b
            r7 = r2
        L_0x000b:
            java.lang.String r3 = "EUNSPECIFIED"
            r4 = 0
            if (r2 == 0) goto L_0x0034
            boolean r5 = r2.startsWith(r0)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            if (r5 == 0) goto L_0x0034
            java.lang.String r2 = ""
            java.lang.String r0 = r7.replace(r0, r2)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            com.facebook.react.bridge.ReactApplicationContext r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            android.content.res.AssetManager r2 = r2.getAssets()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.io.InputStream r0 = r2.open(r0)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r2 = r0.available()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            byte[] r5 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r6 = r0.read(r5, r4, r2)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x006b
        L_0x0034:
            if (r2 != 0) goto L_0x0052
            com.facebook.react.bridge.ReactApplicationContext r0 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            android.net.Uri r2 = android.net.Uri.parse(r7)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.io.InputStream r0 = r0.openInputStream(r2)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r2 = r0.available()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            byte[] r5 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r6 = r0.read(r5)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r0.close()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x006b
        L_0x0052:
            java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r0.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            long r5 = r0.length()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r2 = (int) r5     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            byte[] r5 = new byte[r2]     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r6.<init>(r0)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r0 = r6.read(r5)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r6.close()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r6 = r0
        L_0x006b:
            if (r6 >= r2) goto L_0x0085
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r8.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r8.append(r6)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.lang.String r9 = " bytes of "
            r8.append(r9)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r8.append(r2)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.lang.String r8 = r8.toString()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r10.reject((java.lang.String) r3, (java.lang.String) r8)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            return
        L_0x0085:
            if (r9 == 0) goto L_0x009a
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            if (r9 == 0) goto L_0x0092
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            byte[] r5 = r9.onReadFile(r5)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x009a
        L_0x0092:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.lang.String r9 = "Read file with transform was specified but the shared file transformer is not set"
            r8.<init>(r9)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            throw r8     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
        L_0x009a:
            java.util.Locale r9 = java.util.Locale.ROOT     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            java.lang.String r8 = r8.toLowerCase(r9)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r9 = r8.hashCode()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r0 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r1 = 2
            r2 = 1
            if (r9 == r0) goto L_0x00cb
            r0 = 3600241(0x36ef71, float:5.045012E-39)
            if (r9 == r0) goto L_0x00c0
            r0 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r9 == r0) goto L_0x00b6
            goto L_0x00d5
        L_0x00b6:
            java.lang.String r9 = "ascii"
            boolean r8 = r8.equals(r9)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            if (r8 == 0) goto L_0x00d5
            r8 = r2
            goto L_0x00d6
        L_0x00c0:
            java.lang.String r9 = "utf8"
            boolean r8 = r8.equals(r9)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            if (r8 == 0) goto L_0x00d5
            r8 = r1
            goto L_0x00d6
        L_0x00cb:
            java.lang.String r9 = "base64"
            boolean r8 = r8.equals(r9)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            if (r8 == 0) goto L_0x00d5
            r8 = r4
            goto L_0x00d6
        L_0x00d5:
            r8 = -1
        L_0x00d6:
            if (r8 == 0) goto L_0x0102
            if (r8 == r2) goto L_0x00ef
            if (r8 == r1) goto L_0x00e6
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r8.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x0155
        L_0x00e6:
            java.lang.String r8 = new java.lang.String     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r8.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x0155
        L_0x00ef:
            com.facebook.react.bridge.WritableArray r8 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r9 = r5.length     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
        L_0x00f4:
            if (r4 >= r9) goto L_0x00fe
            byte r0 = r5[r4]     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r8.pushInt(r0)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            int r4 = r4 + 1
            goto L_0x00f4
        L_0x00fe:
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x0155
        L_0x0102:
            java.lang.String r8 = android.util.Base64.encodeToString(r5, r1)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            r10.resolve(r8)     // Catch:{ FileNotFoundException -> 0x0113, Exception -> 0x010a }
            goto L_0x0155
        L_0x010a:
            r7 = move-exception
            java.lang.String r7 = r7.getLocalizedMessage()
            r10.reject((java.lang.String) r3, (java.lang.String) r7)
            goto L_0x0155
        L_0x0113:
            r8 = move-exception
            java.lang.String r8 = r8.getLocalizedMessage()
            java.lang.String r9 = "EISDIR"
            boolean r0 = r8.contains(r9)
            if (r0 == 0) goto L_0x013a
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Expecting a file but '"
            r0.<init>(r1)
            r0.append(r7)
            java.lang.String r7 = "' is a directory; "
            r0.append(r7)
            r0.append(r8)
            java.lang.String r7 = r0.toString()
            r10.reject((java.lang.String) r9, (java.lang.String) r7)
            goto L_0x0155
        L_0x013a:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            java.lang.String r0 = "No such file '"
            r9.<init>(r0)
            r9.append(r7)
            java.lang.String r7 = "'; "
            r9.append(r7)
            r9.append(r8)
            java.lang.String r7 = r9.toString()
            java.lang.String r8 = "ENOENT"
            r10.reject((java.lang.String) r8, (java.lang.String) r7)
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.readFile(java.lang.String, java.lang.String, boolean, com.facebook.react.bridge.Promise):void");
    }

    static Map<String, Object> getSystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("DocumentDir", getFilesDirPath(reactApplicationContext));
        hashMap.put("CacheDir", getCacheDirPath(reactApplicationContext));
        hashMap.put("DCIMDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DCIM));
        hashMap.put("PictureDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_PICTURES));
        hashMap.put("MusicDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MUSIC));
        hashMap.put("DownloadDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_DOWNLOADS));
        hashMap.put("MovieDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_MOVIES));
        hashMap.put("RingtoneDir", getExternalFilesDirPath(reactApplicationContext, Environment.DIRECTORY_RINGTONES));
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("SDCardDir", getExternalFilesDirPath(reactApplicationContext, (String) null));
            File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
            if (externalFilesDir == null || externalFilesDir.getParentFile() == null) {
                hashMap.put("SDCardApplicationDir", "");
            } else {
                hashMap.put("SDCardApplicationDir", externalFilesDir.getParentFile().getAbsolutePath());
            }
        } else {
            hashMap.put("SDCardDir", "");
            hashMap.put("SDCardApplicationDir", "");
        }
        hashMap.put("MainBundleDir", reactApplicationContext.getApplicationInfo().dataDir);
        hashMap.put("LibraryDir", "");
        hashMap.put("ApplicationSupportDir", "");
        return hashMap;
    }

    static Map<String, Object> getLegacySystemfolders(ReactApplicationContext reactApplicationContext) {
        HashMap hashMap = new HashMap();
        hashMap.put("LegacyDCIMDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath());
        hashMap.put("LegacyPictureDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath());
        hashMap.put("LegacyMusicDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC).getAbsolutePath());
        hashMap.put("LegacyDownloadDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath());
        hashMap.put("LegacyMovieDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MOVIES).getAbsolutePath());
        hashMap.put("LegacyRingtoneDir", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_RINGTONES).getAbsolutePath());
        if (Environment.getExternalStorageState().equals("mounted")) {
            hashMap.put("LegacySDCardDir", Environment.getExternalStorageDirectory().getAbsolutePath());
        } else {
            hashMap.put("LegacySDCardDir", "");
        }
        return hashMap;
    }

    static String getExternalFilesDirPath(ReactApplicationContext reactApplicationContext, String str) {
        File externalFilesDir = reactApplicationContext.getExternalFilesDir(str);
        return externalFilesDir != null ? externalFilesDir.getAbsolutePath() : "";
    }

    static String getFilesDirPath(ReactApplicationContext reactApplicationContext) {
        File filesDir = reactApplicationContext.getFilesDir();
        return filesDir != null ? filesDir.getAbsolutePath() : "";
    }

    static String getCacheDirPath(ReactApplicationContext reactApplicationContext) {
        File cacheDir = reactApplicationContext.getCacheDir();
        return cacheDir != null ? cacheDir.getAbsolutePath() : "";
    }

    public static void getSDCardDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getAbsolutePath());
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("ReactNativeBlobUtil.getSDCardDir", "External storage not mounted");
        }
    }

    public static void getSDCardApplicationDir(ReactApplicationContext reactApplicationContext, Promise promise) {
        if (Environment.getExternalStorageState().equals("mounted")) {
            try {
                promise.resolve(reactApplicationContext.getExternalFilesDir((String) null).getParentFile().getAbsolutePath());
            } catch (Exception e) {
                promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", e.getLocalizedMessage());
            }
        } else {
            promise.reject("ReactNativeBlobUtil.getSDCardApplicationDir", "External storage not mounted");
        }
    }

    static String getTmpPath(String str) {
        return ReactNativeBlobUtilImpl.RCTContext.getFilesDir() + "/ReactNativeBlobUtilTmp_" + str;
    }

    static void unlink(String str, Callback callback) {
        try {
            deleteRecursive(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
            callback.invoke(null, true);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), false);
        }
    }

    private static void deleteRecursive(File file) throws IOException {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File deleteRecursive : listFiles) {
                    deleteRecursive(deleteRecursive);
                }
            } else {
                throw new NullPointerException("Received null trying to list files of directory '" + file + "'");
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete '" + file + "'");
        }
    }

    static void mkdir(String str, Promise promise) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        File file = new File(normalizePath);
        if (file.exists()) {
            StringBuilder sb = new StringBuilder();
            sb.append(file.isDirectory() ? "Folder" : "File");
            sb.append(" '");
            sb.append(normalizePath);
            sb.append("' already exists");
            promise.reject("EEXIST", sb.toString());
            return;
        }
        try {
            if (!file.mkdirs()) {
                promise.reject("EUNSPECIFIED", "mkdir failed to create some or all directories in '" + normalizePath + "'");
                return;
            }
            promise.resolve(true);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d0 A[SYNTHETIC, Splitter:B:53:0x00d0] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00d8 A[Catch:{ Exception -> 0x00d4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f1  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x0102 A[SYNTHETIC, Splitter:B:65:0x0102] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x010a A[Catch:{ Exception -> 0x0106 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static void cp(java.lang.String r8, java.lang.String r9, com.facebook.react.bridge.Callback r10) {
        /*
            java.lang.String r0 = "Destination file at '"
            java.lang.String r1 = "Source file at path`"
            java.lang.String r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r9)
            java.lang.String r2 = ""
            r3 = 1
            r4 = 0
            r5 = 0
            java.io.InputStream r6 = inputStreamFromPath(r8)     // Catch:{ Exception -> 0x00b9, all -> 0x00b6 }
            if (r6 != 0) goto L_0x0036
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r0.<init>(r1)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r0.append(r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.String r8 = "` does not exist or can not be opened"
            r0.append(r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.String r8 = r0.toString()     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r9[r4] = r8     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r10.invoke(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            if (r6 == 0) goto L_0x0035
            r6.close()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0035
        L_0x0031:
            r8 = move-exception
            r8.getLocalizedMessage()
        L_0x0035:
            return
        L_0x0036:
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            boolean r8 = r8.exists()     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            if (r8 != 0) goto L_0x006f
            java.io.File r8 = new java.io.File     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            boolean r8 = r8.createNewFile()     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            if (r8 != 0) goto L_0x006f
            java.lang.Object[] r8 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r1.append(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.String r9 = "' already exists"
            r1.append(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            java.lang.String r9 = r1.toString()     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r8[r4] = r9     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r10.invoke(r8)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            if (r6 == 0) goto L_0x006e
            r6.close()     // Catch:{ Exception -> 0x006a }
            goto L_0x006e
        L_0x006a:
            r8 = move-exception
            r8.getLocalizedMessage()
        L_0x006e:
            return
        L_0x006f:
            java.io.FileOutputStream r8 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b2, all -> 0x00ae }
            r9 = 10240(0x2800, float:1.4349E-41)
            byte[] r9 = new byte[r9]     // Catch:{ Exception -> 0x00a8, all -> 0x00a1 }
        L_0x0078:
            int r0 = r6.read(r9)     // Catch:{ Exception -> 0x00a8, all -> 0x00a1 }
            if (r0 <= 0) goto L_0x0082
            r8.write(r9, r4, r0)     // Catch:{ Exception -> 0x00a8, all -> 0x00a1 }
            goto L_0x0078
        L_0x0082:
            if (r6 == 0) goto L_0x008a
            r6.close()     // Catch:{ Exception -> 0x0088 }
            goto L_0x008a
        L_0x0088:
            r8 = move-exception
            goto L_0x0090
        L_0x008a:
            r8.close()     // Catch:{ Exception -> 0x0088 }
            r8 = r2
            goto L_0x00ef
        L_0x0090:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>(r2)
            java.lang.String r8 = r8.getLocalizedMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            goto L_0x00ef
        L_0x00a1:
            r9 = move-exception
            r5 = r6
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x0100
        L_0x00a8:
            r9 = move-exception
            r5 = r6
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00bb
        L_0x00ae:
            r8 = move-exception
            r9 = r5
            r5 = r6
            goto L_0x0100
        L_0x00b2:
            r8 = move-exception
            r9 = r5
            r5 = r6
            goto L_0x00bb
        L_0x00b6:
            r8 = move-exception
            r9 = r5
            goto L_0x0100
        L_0x00b9:
            r8 = move-exception
            r9 = r5
        L_0x00bb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ff }
            r0.<init>()     // Catch:{ all -> 0x00ff }
            r0.append(r2)     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = r8.getLocalizedMessage()     // Catch:{ all -> 0x00ff }
            r0.append(r8)     // Catch:{ all -> 0x00ff }
            java.lang.String r8 = r0.toString()     // Catch:{ all -> 0x00ff }
            if (r5 == 0) goto L_0x00d6
            r5.close()     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00d6
        L_0x00d4:
            r9 = move-exception
            goto L_0x00dc
        L_0x00d6:
            if (r9 == 0) goto L_0x00ef
            r9.close()     // Catch:{ Exception -> 0x00d4 }
            goto L_0x00ef
        L_0x00dc:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = r9.getLocalizedMessage()
            r0.append(r8)
            java.lang.String r8 = r0.toString()
        L_0x00ef:
            if (r8 == r2) goto L_0x00f9
            java.lang.Object[] r9 = new java.lang.Object[r3]
            r9[r4] = r8
            r10.invoke(r9)
            goto L_0x00fe
        L_0x00f9:
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r10.invoke(r8)
        L_0x00fe:
            return
        L_0x00ff:
            r8 = move-exception
        L_0x0100:
            if (r5 == 0) goto L_0x0108
            r5.close()     // Catch:{ Exception -> 0x0106 }
            goto L_0x0108
        L_0x0106:
            r9 = move-exception
            goto L_0x010e
        L_0x0108:
            if (r9 == 0) goto L_0x0111
            r9.close()     // Catch:{ Exception -> 0x0106 }
            goto L_0x0111
        L_0x010e:
            r9.getLocalizedMessage()
        L_0x0111:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.cp(java.lang.String, java.lang.String, com.facebook.react.bridge.Callback):void");
    }

    static void mv(String str, String str2, Callback callback) {
        String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
        String normalizePath2 = ReactNativeBlobUtilUtils.normalizePath(str2);
        File file = new File(normalizePath);
        if (!file.exists()) {
            callback.invoke("Source file at path `" + normalizePath + "` does not exist");
            return;
        }
        try {
            File file2 = new File(normalizePath2);
            File parentFile = file2.getParentFile();
            if (parentFile == null || parentFile.exists()) {
                if (file2.exists()) {
                    file2.delete();
                }
                if (!file.renameTo(file2)) {
                    callback.invoke("mv failed for unknown reasons");
                    return;
                }
                callback.invoke(new Object[0]);
                return;
            }
            callback.invoke("mv failed because the destination directory doesn't exist");
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }

    static void exists(String str, Callback callback) {
        if (isAsset(str)) {
            try {
                ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
                callback.invoke(true, false);
            } catch (IOException unused) {
                callback.invoke(false, false);
            }
        } else {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            if (normalizePath != null) {
                callback.invoke(Boolean.valueOf(new File(normalizePath).exists()), Boolean.valueOf(new File(normalizePath).isDirectory()));
                return;
            }
            callback.invoke(false, false);
        }
    }

    static void ls(String str, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.exists()) {
                promise.reject("ENOENT", "No such file '" + normalizePath + "'");
            } else if (!file.isDirectory()) {
                promise.reject("ENOTDIR", "Not a directory '" + normalizePath + "'");
            } else {
                String[] list = new File(normalizePath).list();
                WritableArray createArray = Arguments.createArray();
                for (String pushString : list) {
                    createArray.pushString(pushString);
                }
                promise.resolve(createArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void slice(String str, String str2, int i, int i2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str2);
            if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) || !new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                InputStream inputStreamFromPath = inputStreamFromPath(str);
                if (inputStreamFromPath == null) {
                    promise.reject("ENOENT", "No such file '" + str + "'");
                    return;
                }
                FileOutputStream fileOutputStream = new FileOutputStream(new File(normalizePath));
                int skip = (int) inputStreamFromPath.skip((long) i);
                if (skip != i) {
                    promise.reject("EUNSPECIFIED", "Skipped " + skip + " instead of the specified " + i + " bytes");
                    return;
                }
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                int i3 = i2 - i;
                while (true) {
                    if (i3 <= 0) {
                        break;
                    }
                    int read = inputStreamFromPath.read(bArr, 0, Data.MAX_DATA_BYTES);
                    if (read <= 0) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, Math.min(i3, read));
                    i3 -= read;
                }
                inputStreamFromPath.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                promise.resolve(normalizePath);
                return;
            }
            promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void lstat(String str, final Callback callback) {
        new AsyncTask<String, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(String... strArr) {
                WritableArray createArray = Arguments.createArray();
                if (strArr[0] == null) {
                    Callback.this.invoke("the path specified for lstat is either `null` or `undefined`.");
                    return 0;
                }
                File file = new File(strArr[0]);
                if (!file.exists()) {
                    Callback.this.invoke("failed to lstat path `" + strArr[0] + "` because it does not exist or it is not a folder");
                    return 0;
                }
                if (file.isDirectory()) {
                    for (String str : file.list()) {
                        createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getPath() + "/" + str));
                    }
                } else {
                    createArray.pushMap(ReactNativeBlobUtilFS.statFile(file.getAbsolutePath()));
                }
                Callback.this.invoke(null, createArray);
                return 0;
            }
        }.execute(new String[]{ReactNativeBlobUtilUtils.normalizePath(str)});
    }

    static void stat(String str, Callback callback) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap statFile = statFile(normalizePath);
            if (statFile == null) {
                callback.invoke("failed to stat path `" + normalizePath + "` because it does not exist or it is not a folder", null);
                return;
            }
            callback.invoke(null, statFile);
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage());
        }
    }

    static WritableMap statFile(String str) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            WritableMap createMap = Arguments.createMap();
            if (isAsset(normalizePath)) {
                String replace = normalizePath.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, "");
                AssetFileDescriptor openFd = ReactNativeBlobUtilImpl.RCTContext.getAssets().openFd(replace);
                createMap.putString("filename", replace);
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, normalizePath);
                createMap.putString("type", UriUtil.LOCAL_ASSET_SCHEME);
                createMap.putString("size", String.valueOf(openFd.getLength()));
                createMap.putInt("lastModified", 0);
            } else {
                File file = new File(normalizePath);
                if (!file.exists()) {
                    return null;
                }
                createMap.putString("filename", file.getName());
                createMap.putString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH, file.getPath());
                createMap.putString("type", file.isDirectory() ? "directory" : "file");
                createMap.putString("size", String.valueOf(file.length()));
                createMap.putString("lastModified", String.valueOf(file.lastModified()));
            }
            return createMap;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void scanFile(String[] strArr, String[] strArr2, final Callback callback) {
        try {
            MediaScannerConnection.scanFile(this.mCtx, strArr, strArr2, new MediaScannerConnection.OnScanCompletedListener() {
                public void onScanCompleted(String str, Uri uri) {
                    callback.invoke(null, true);
                }
            });
        } catch (Exception e) {
            callback.invoke(e.getLocalizedMessage(), null);
        }
    }

    static void hash(String str, String str2, Promise promise) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("md5", MessageDigestAlgorithms.MD5);
            hashMap.put("sha1", MessageDigestAlgorithms.SHA_1);
            hashMap.put("sha224", "SHA-224");
            hashMap.put(SigningManager.POST_PARAMS_ALGORITHM, MessageDigestAlgorithms.SHA_256);
            hashMap.put("sha384", MessageDigestAlgorithms.SHA_384);
            hashMap.put("sha512", MessageDigestAlgorithms.SHA_512);
            if (!hashMap.containsKey(str2)) {
                promise.reject("EINVAL", "Invalid algorithm '" + str2 + "', must be one of md5, sha1, sha224, sha256, sha384, sha512");
            } else if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT) || !new File(ReactNativeBlobUtilUtils.normalizePath(str)).isDirectory()) {
                MessageDigest instance = MessageDigest.getInstance((String) hashMap.get(str2));
                InputStream inputStreamFromPath = inputStreamFromPath(str);
                if (inputStreamFromPath == null) {
                    promise.reject("ENOENT", "No such file '" + str + "'");
                    return;
                }
                byte[] bArr = new byte[1048576];
                while (true) {
                    int read = inputStreamFromPath.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                StringBuilder sb = new StringBuilder();
                byte[] digest = instance.digest();
                int length = digest.length;
                for (int i = 0; i < length; i++) {
                    sb.append(String.format("%02x", new Object[]{Byte.valueOf(digest[i])}));
                }
                promise.resolve(sb.toString());
            } else {
                promise.reject("EISDIR", "Expecting a file but '" + str + "' is a directory");
            }
        } catch (Exception e) {
            e.printStackTrace();
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFile(String str, String str2, String str3, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            boolean createNewFile = file.createNewFile();
            if (str3.equals("uri")) {
                File file2 = new File(str2.replace(ReactNativeBlobUtilConst.FILE_PREFIX, ""));
                if (!file2.exists()) {
                    promise.reject("ENOENT", "Source file : " + str2 + " does not exist");
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(file2);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                byte[] bArr = new byte[Data.MAX_DATA_BYTES];
                for (int read = fileInputStream.read(bArr); read > 0; read = fileInputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, read);
                }
                fileInputStream.close();
                fileOutputStream.close();
            } else if (!createNewFile) {
                promise.reject("EEXIST", "File `" + normalizePath + "` already exists");
                return;
            } else {
                new FileOutputStream(file).write(ReactNativeBlobUtilUtils.stringToBytes(str2, str3));
            }
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void createFileASCII(String str, ReadableArray readableArray, Promise promise) {
        try {
            String normalizePath = ReactNativeBlobUtilUtils.normalizePath(str);
            File file = new File(normalizePath);
            if (!file.createNewFile()) {
                promise.reject("EEXIST", "File at path `" + normalizePath + "` already exists");
                return;
            }
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[readableArray.size()];
            for (int i = 0; i < readableArray.size(); i++) {
                bArr[i] = (byte) readableArray.getInt(i);
            }
            fileOutputStream.write(bArr);
            promise.resolve(normalizePath);
        } catch (Exception e) {
            promise.reject("EUNSPECIFIED", e.getLocalizedMessage());
        }
    }

    static void df(Callback callback, ReactApplicationContext reactApplicationContext) {
        StatFs statFs = new StatFs(reactApplicationContext.getFilesDir().getPath());
        WritableMap createMap = Arguments.createMap();
        createMap.putString("internal_free", String.valueOf(statFs.getFreeBytes()));
        createMap.putString("internal_total", String.valueOf(statFs.getTotalBytes()));
        File externalFilesDir = reactApplicationContext.getExternalFilesDir((String) null);
        if (externalFilesDir != null) {
            StatFs statFs2 = new StatFs(externalFilesDir.getPath());
            createMap.putString("external_free", String.valueOf(statFs2.getFreeBytes()));
            createMap.putString("external_total", String.valueOf(statFs2.getTotalBytes()));
        } else {
            createMap.putString("external_free", "-1");
            createMap.putString("external_total", "-1");
        }
        callback.invoke(null, createMap);
    }

    static void removeSession(ReadableArray readableArray, final Callback callback) {
        new AsyncTask<ReadableArray, Integer, Integer>() {
            /* access modifiers changed from: protected */
            public Integer doInBackground(ReadableArray... readableArrayArr) {
                try {
                    ArrayList arrayList = new ArrayList();
                    for (int i = 0; i < readableArrayArr[0].size(); i++) {
                        String string = readableArrayArr[0].getString(i);
                        File file = new File(string);
                        if (file.exists() && !file.delete()) {
                            arrayList.add(string);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Callback.this.invoke(null, true);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Failed to delete: ");
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            sb.append((String) it.next());
                            sb.append(", ");
                        }
                        Callback.this.invoke(sb.toString());
                    }
                } catch (Exception e) {
                    Callback.this.invoke(e.getLocalizedMessage());
                }
                return Integer.valueOf(readableArrayArr[0].size());
            }
        }.execute(new ReadableArray[]{readableArray});
    }

    private static InputStream inputStreamFromPath(String str) throws IOException {
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
        }
        if (str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_CONTENT)) {
            return ReactNativeBlobUtilImpl.RCTContext.getContentResolver().openInputStream(Uri.parse(str));
        }
        return new FileInputStream(new File(ReactNativeBlobUtilUtils.normalizePath(str)));
    }

    private static boolean isPathExists(String str) {
        if (!str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET)) {
            return new File(str).exists();
        }
        try {
            ReactNativeBlobUtilImpl.RCTContext.getAssets().open(str.replace(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET, ""));
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    static boolean isAsset(String str) {
        return str != null && str.startsWith(ReactNativeBlobUtilConst.FILE_PREFIX_BUNDLE_ASSET);
    }
}
