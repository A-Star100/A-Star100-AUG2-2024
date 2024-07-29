package com.ReactNativeBlobUtil;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.ReactNativeBlobUtil.Utils.FileDescription;
import com.facebook.react.bridge.ReactApplicationContext;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.IOUtils;

public class ReactNativeBlobUtilMediaCollection {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public enum MediaType {
        Audio,
        Image,
        Video,
        Download
    }

    private static Uri getMediaUri(MediaType mediaType) {
        if (mediaType == MediaType.Audio) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Audio.Media.getContentUri("external_primary");
            }
            return MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == MediaType.Video) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Video.Media.getContentUri("external_primary");
            }
            return MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType == MediaType.Image) {
            if (Build.VERSION.SDK_INT >= 29) {
                return MediaStore.Images.Media.getContentUri("external_primary");
            }
            return MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if (mediaType != MediaType.Download || Build.VERSION.SDK_INT < 29) {
            return null;
        } else {
            return MediaStore.Downloads.getContentUri("external_primary");
        }
    }

    private static String getRelativePath(MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        if (Build.VERSION.SDK_INT >= 29) {
            if (mediaType == MediaType.Audio) {
                return Environment.DIRECTORY_MUSIC;
            }
            if (mediaType == MediaType.Video) {
                return Environment.DIRECTORY_MOVIES;
            }
            if (mediaType == MediaType.Image) {
                return Environment.DIRECTORY_PICTURES;
            }
            if (mediaType == MediaType.Download) {
                return Environment.DIRECTORY_DOWNLOADS;
            }
            return Environment.DIRECTORY_DOWNLOADS;
        } else if (mediaType == MediaType.Audio) {
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMusicDir").toString();
        } else {
            if (mediaType == MediaType.Video) {
                return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyMovieDir").toString();
            }
            if (mediaType == MediaType.Image) {
                return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyPictureDir").toString();
            }
            if (mediaType == MediaType.Download) {
                return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
            }
            return ReactNativeBlobUtilFS.getLegacySystemfolders(reactApplicationContext).get("LegacyDownloadDir").toString();
        }
    }

    public static Uri createNewMediaFile(FileDescription fileDescription, MediaType mediaType, ReactApplicationContext reactApplicationContext) {
        ContentResolver contentResolver = ReactNativeBlobUtilImpl.RCTContext.getApplicationContext().getContentResolver();
        ContentValues contentValues = new ContentValues();
        String relativePath = getRelativePath(mediaType, reactApplicationContext);
        String str = fileDescription.mimeType;
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("date_added", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("date_modified", Long.valueOf(System.currentTimeMillis() / 1000));
            contentValues.put("mime_type", str);
            contentValues.put("_display_name", fileDescription.name);
            contentValues.put("relative_path", relativePath + IOUtils.DIR_SEPARATOR_UNIX + fileDescription.partentFolder);
            try {
                return contentResolver.insert(getMediaUri(mediaType), contentValues);
            } catch (Exception unused) {
                return null;
            }
        } else {
            File file = new File(relativePath + fileDescription.getFullPath());
            if (file.exists()) {
                return Uri.fromFile(file);
            }
            File parentFile = file.getParentFile();
            if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
                return null;
            }
            try {
                file.createNewFile();
                return Uri.fromFile(file);
            } catch (IOException unused2) {
                return null;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:47:0x00c9 A[SYNTHETIC, Splitter:B:47:0x00c9] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d1 A[Catch:{ IOException -> 0x00d5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean writeToMediaFile(android.net.Uri r8, java.lang.String r9, boolean r10, com.facebook.react.bridge.Promise r11, com.facebook.react.bridge.ReactApplicationContext r12) {
        /*
            java.lang.String r0 = "Failed to get output stream."
            java.lang.String r1 = "No such file ('"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 29
            r4 = 0
            if (r2 < r3) goto L_0x00dd
            android.content.Context r12 = r12.getApplicationContext()     // Catch:{ IOException -> 0x00d5 }
            android.content.ContentResolver r2 = r12.getContentResolver()     // Catch:{ IOException -> 0x00d5 }
            r3 = 0
            android.content.ContentResolver r12 = r12.getContentResolver()     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r5 = "w"
            android.os.ParcelFileDescriptor r12 = r12.openFileDescriptor(r8, r5)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r9 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r9)     // Catch:{ Exception -> 0x00b0 }
            java.io.File r5 = new java.io.File     // Catch:{ Exception -> 0x00b0 }
            r5.<init>(r9)     // Catch:{ Exception -> 0x00b0 }
            boolean r6 = r5.exists()     // Catch:{ Exception -> 0x00b0 }
            if (r6 != 0) goto L_0x0045
            java.lang.String r8 = "ENOENT"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b0 }
            r10.<init>(r1)     // Catch:{ Exception -> 0x00b0 }
            r10.append(r9)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r9 = "')"
            r10.append(r9)     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r9 = r10.toString()     // Catch:{ Exception -> 0x00b0 }
            r11.reject((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x00b0 }
            return r4
        L_0x0045:
            java.io.FileInputStream r9 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b0 }
            r9.<init>(r5)     // Catch:{ Exception -> 0x00b0 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ Exception -> 0x00b0 }
            java.io.FileDescriptor r6 = r12.getFileDescriptor()     // Catch:{ Exception -> 0x00b0 }
            r1.<init>(r6)     // Catch:{ Exception -> 0x00b0 }
            if (r10 == 0) goto L_0x0075
            long r5 = r5.length()     // Catch:{ Exception -> 0x00b0 }
            int r10 = (int) r5     // Catch:{ Exception -> 0x00b0 }
            byte[] r10 = new byte[r10]     // Catch:{ Exception -> 0x00b0 }
            r9.read(r10)     // Catch:{ Exception -> 0x00b0 }
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ Exception -> 0x00b0 }
            if (r5 == 0) goto L_0x006d
            com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer$FileTransformer r5 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFileTransformer.sharedFileTransformer     // Catch:{ Exception -> 0x00b0 }
            byte[] r10 = r5.onWriteFile(r10)     // Catch:{ Exception -> 0x00b0 }
            r1.write(r10)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0083
        L_0x006d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ Exception -> 0x00b0 }
            java.lang.String r9 = "Write to media file with transform was specified but the shared file transformer is not set"
            r8.<init>(r9)     // Catch:{ Exception -> 0x00b0 }
            throw r8     // Catch:{ Exception -> 0x00b0 }
        L_0x0075:
            r10 = 10240(0x2800, float:1.4349E-41)
            byte[] r10 = new byte[r10]     // Catch:{ Exception -> 0x00b0 }
        L_0x0079:
            int r5 = r9.read(r10)     // Catch:{ Exception -> 0x00b0 }
            if (r5 <= 0) goto L_0x0083
            r1.write(r10, r4, r5)     // Catch:{ Exception -> 0x00b0 }
            goto L_0x0079
        L_0x0083:
            r9.close()     // Catch:{ Exception -> 0x00b0 }
            r1.close()     // Catch:{ Exception -> 0x00b0 }
            r12.close()     // Catch:{ Exception -> 0x00b0 }
            java.io.OutputStream r8 = r2.openOutputStream(r8)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            if (r8 != 0) goto L_0x00a9
            java.io.IOException r9 = new java.io.IOException     // Catch:{ IOException -> 0x00a4, all -> 0x00a0 }
            r9.<init>(r0)     // Catch:{ IOException -> 0x00a4, all -> 0x00a0 }
            r11.reject((java.lang.Throwable) r9)     // Catch:{ IOException -> 0x00a4, all -> 0x00a0 }
            if (r8 == 0) goto L_0x009f
            r8.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x009f:
            return r4
        L_0x00a0:
            r9 = move-exception
            r3 = r8
            r8 = r9
            goto L_0x00cf
        L_0x00a4:
            r9 = move-exception
            r7 = r9
            r9 = r8
            r8 = r7
            goto L_0x00c1
        L_0x00a9:
            if (r8 == 0) goto L_0x00ae
            r8.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00ae:
            r8 = 1
            return r8
        L_0x00b0:
            r8 = move-exception
            r8.printStackTrace()     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            java.io.IOException r8 = new java.io.IOException     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r8.<init>(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            r11.reject((java.lang.Throwable) r8)     // Catch:{ IOException -> 0x00bf, all -> 0x00bd }
            return r4
        L_0x00bd:
            r8 = move-exception
            goto L_0x00cf
        L_0x00bf:
            r8 = move-exception
            r9 = r3
        L_0x00c1:
            r2.delete(r3, r3, r3)     // Catch:{ all -> 0x00cd }
            r11.reject((java.lang.Throwable) r8)     // Catch:{ all -> 0x00cd }
            if (r9 == 0) goto L_0x00cc
            r9.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00cc:
            return r4
        L_0x00cd:
            r8 = move-exception
            r3 = r9
        L_0x00cf:
            if (r3 == 0) goto L_0x00d4
            r3.close()     // Catch:{ IOException -> 0x00d5 }
        L_0x00d4:
            throw r8     // Catch:{ IOException -> 0x00d5 }
        L_0x00d5:
            java.lang.String r8 = "ReactNativeBlobUtil.createMediaFile"
            java.lang.String r9 = "Cannot write to file, file might not exist"
            r11.reject((java.lang.String) r8, (java.lang.String) r9)
            return r4
        L_0x00dd:
            java.lang.String r8 = r8.toString()
            java.lang.String r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilUtils.normalizePath(r8)
            java.lang.String r10 = "uri"
            boolean r8 = com.ReactNativeBlobUtil.ReactNativeBlobUtilFS.writeFile((java.lang.String) r8, (java.lang.String) r10, (java.lang.String) r9, (boolean) r4)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.writeToMediaFile(android.net.Uri, java.lang.String, boolean, com.facebook.react.bridge.Promise, com.facebook.react.bridge.ReactApplicationContext):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:52:0x00c3 A[SYNTHETIC, Splitter:B:52:0x00c3] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00cd A[SYNTHETIC, Splitter:B:57:0x00cd] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00d9 A[SYNTHETIC, Splitter:B:63:0x00d9] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00e3 A[SYNTHETIC, Splitter:B:68:0x00e3] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void copyToInternal(android.net.Uri r6, java.lang.String r7, com.facebook.react.bridge.Promise r8) {
        /*
            java.lang.String r0 = "ReactNativeBlobUtil.copyToInternal: Cannot create parent folders<'"
            java.lang.String r1 = "ReactNativeBlobUtil.copyToInternal: Destination file at '"
            com.facebook.react.bridge.ReactApplicationContext r2 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r2 = r2.getApplicationContext()
            android.content.ContentResolver r2 = r2.getContentResolver()
            java.io.File r3 = new java.io.File
            r3.<init>(r7)
            boolean r4 = r3.exists()
            if (r4 != 0) goto L_0x006c
            java.io.File r4 = r3.getParentFile()     // Catch:{ IOException -> 0x0056 }
            if (r4 == 0) goto L_0x003b
            boolean r5 = r4.exists()     // Catch:{ IOException -> 0x0056 }
            if (r5 != 0) goto L_0x003b
            boolean r4 = r4.mkdirs()     // Catch:{ IOException -> 0x0056 }
            if (r4 != 0) goto L_0x003b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0056 }
            r1.<init>(r0)     // Catch:{ IOException -> 0x0056 }
            r1.append(r7)     // Catch:{ IOException -> 0x0056 }
            java.lang.String r0 = r1.toString()     // Catch:{ IOException -> 0x0056 }
            r8.reject((java.lang.String) r0)     // Catch:{ IOException -> 0x0056 }
            return
        L_0x003b:
            boolean r0 = r3.createNewFile()     // Catch:{ IOException -> 0x0056 }
            if (r0 != 0) goto L_0x006c
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0056 }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0056 }
            r0.append(r7)     // Catch:{ IOException -> 0x0056 }
            java.lang.String r1 = "' already exists"
            r0.append(r1)     // Catch:{ IOException -> 0x0056 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0056 }
            r8.reject((java.lang.String) r0)     // Catch:{ IOException -> 0x0056 }
            return
        L_0x0056:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = "ReactNativeBlobUtil.copyToInternal: Could not create file: "
            r1.<init>(r3)
            java.lang.String r0 = r0.getLocalizedMessage()
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r8.reject((java.lang.String) r0)
        L_0x006c:
            r0 = 0
            java.io.InputStream r6 = r2.openInputStream(r6)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x00a0, all -> 0x009c }
            r1.<init>(r7)     // Catch:{ IOException -> 0x00a0, all -> 0x009c }
            r7 = 10240(0x2800, float:1.4349E-41)
            byte[] r7 = new byte[r7]     // Catch:{ IOException -> 0x009a, all -> 0x0098 }
        L_0x007a:
            int r0 = r6.read(r7)     // Catch:{ IOException -> 0x009a, all -> 0x0098 }
            if (r0 <= 0) goto L_0x0085
            r2 = 0
            r1.write(r7, r2, r0)     // Catch:{ IOException -> 0x009a, all -> 0x0098 }
            goto L_0x007a
        L_0x0085:
            if (r6 == 0) goto L_0x008f
            r6.close()     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008f:
            r1.close()     // Catch:{ IOException -> 0x0093 }
            goto L_0x00d0
        L_0x0093:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x00d0
        L_0x0098:
            r7 = move-exception
            goto L_0x009e
        L_0x009a:
            r7 = move-exception
            goto L_0x00a2
        L_0x009c:
            r7 = move-exception
            r1 = r0
        L_0x009e:
            r0 = r6
            goto L_0x00d7
        L_0x00a0:
            r7 = move-exception
            r1 = r0
        L_0x00a2:
            r0 = r6
            goto L_0x00a9
        L_0x00a4:
            r7 = move-exception
            r1 = r0
            goto L_0x00d7
        L_0x00a7:
            r7 = move-exception
            r1 = r0
        L_0x00a9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d6 }
            r6.<init>()     // Catch:{ all -> 0x00d6 }
            java.lang.String r2 = "ReactNativeBlobUtil.copyToInternal:  Could not write data: "
            r6.append(r2)     // Catch:{ all -> 0x00d6 }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x00d6 }
            r6.append(r7)     // Catch:{ all -> 0x00d6 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x00d6 }
            r8.reject((java.lang.String) r6)     // Catch:{ all -> 0x00d6 }
            if (r0 == 0) goto L_0x00cb
            r0.close()     // Catch:{ IOException -> 0x00c7 }
            goto L_0x00cb
        L_0x00c7:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00cb:
            if (r1 == 0) goto L_0x00d0
            r1.close()     // Catch:{ IOException -> 0x0093 }
        L_0x00d0:
            java.lang.String r6 = ""
            r8.resolve(r6)
            return
        L_0x00d6:
            r7 = move-exception
        L_0x00d7:
            if (r0 == 0) goto L_0x00e1
            r0.close()     // Catch:{ IOException -> 0x00dd }
            goto L_0x00e1
        L_0x00dd:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00e1:
            if (r1 == 0) goto L_0x00eb
            r1.close()     // Catch:{ IOException -> 0x00e7 }
            goto L_0x00eb
        L_0x00e7:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00eb:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.copyToInternal(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0065 A[Catch:{ IOException -> 0x008b }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082 A[Catch:{ IOException -> 0x008b }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void getBlob(android.net.Uri r5, java.lang.String r6, com.facebook.react.bridge.Promise r7) {
        /*
            java.lang.String r0 = "Read only "
            com.facebook.react.bridge.ReactApplicationContext r1 = com.ReactNativeBlobUtil.ReactNativeBlobUtilImpl.RCTContext
            android.content.Context r1 = r1.getApplicationContext()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.io.InputStream r5 = r1.openInputStream(r5)     // Catch:{ IOException -> 0x008b }
            int r1 = r5.available()     // Catch:{ IOException -> 0x008b }
            byte[] r2 = new byte[r1]     // Catch:{ IOException -> 0x008b }
            int r3 = r5.read(r2)     // Catch:{ IOException -> 0x008b }
            r5.close()     // Catch:{ IOException -> 0x008b }
            if (r3 >= r1) goto L_0x0039
            java.lang.String r5 = "EUNSPECIFIED"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x008b }
            r6.<init>(r0)     // Catch:{ IOException -> 0x008b }
            r6.append(r3)     // Catch:{ IOException -> 0x008b }
            java.lang.String r0 = " bytes of "
            r6.append(r0)     // Catch:{ IOException -> 0x008b }
            r6.append(r1)     // Catch:{ IOException -> 0x008b }
            java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x008b }
            r7.reject((java.lang.String) r5, (java.lang.String) r6)     // Catch:{ IOException -> 0x008b }
            return
        L_0x0039:
            java.lang.String r5 = r6.toLowerCase()     // Catch:{ IOException -> 0x008b }
            int r6 = r5.hashCode()     // Catch:{ IOException -> 0x008b }
            r0 = -1396204209(0xffffffffacc79d4f, float:-5.673385E-12)
            r3 = 0
            r4 = 1
            if (r6 == r0) goto L_0x0058
            r0 = 93106001(0x58caf51, float:1.3229938E-35)
            if (r6 == r0) goto L_0x004e
            goto L_0x0062
        L_0x004e:
            java.lang.String r6 = "ascii"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException -> 0x008b }
            if (r5 == 0) goto L_0x0062
            r5 = r4
            goto L_0x0063
        L_0x0058:
            java.lang.String r6 = "base64"
            boolean r5 = r5.equals(r6)     // Catch:{ IOException -> 0x008b }
            if (r5 == 0) goto L_0x0062
            r5 = r3
            goto L_0x0063
        L_0x0062:
            r5 = -1
        L_0x0063:
            if (r5 == 0) goto L_0x0082
            if (r5 == r4) goto L_0x0070
            java.lang.String r5 = new java.lang.String     // Catch:{ IOException -> 0x008b }
            r5.<init>(r2)     // Catch:{ IOException -> 0x008b }
            r7.resolve(r5)     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x0070:
            com.facebook.react.bridge.WritableArray r5 = com.facebook.react.bridge.Arguments.createArray()     // Catch:{ IOException -> 0x008b }
        L_0x0074:
            if (r3 >= r1) goto L_0x007e
            byte r6 = r2[r3]     // Catch:{ IOException -> 0x008b }
            r5.pushInt(r6)     // Catch:{ IOException -> 0x008b }
            int r3 = r3 + 1
            goto L_0x0074
        L_0x007e:
            r7.resolve(r5)     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x0082:
            r5 = 2
            java.lang.String r5 = android.util.Base64.encodeToString(r2, r5)     // Catch:{ IOException -> 0x008b }
            r7.resolve(r5)     // Catch:{ IOException -> 0x008b }
            goto L_0x008f
        L_0x008b:
            r5 = move-exception
            r5.printStackTrace()
        L_0x008f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ReactNativeBlobUtil.ReactNativeBlobUtilMediaCollection.getBlob(android.net.Uri, java.lang.String, com.facebook.react.bridge.Promise):void");
    }
}
