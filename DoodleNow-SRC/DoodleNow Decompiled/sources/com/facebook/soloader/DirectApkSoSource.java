package com.facebook.soloader;

import android.content.Context;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.SysUtil;
import com.revenuecat.purchases.common.Constants;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javax.annotation.Nullable;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class DirectApkSoSource extends SoSource {
    private final File mApkFile;
    private final Set<String> mDirectApkLdPaths;
    private final Map<String, Set<String>> mLibsInApkMap = new HashMap();

    public DirectApkSoSource(Context context) {
        String str = context.getApplicationInfo().sourceDir;
        this.mDirectApkLdPaths = getDirectApkLdPaths("", str);
        this.mApkFile = new File(str);
    }

    public DirectApkSoSource(File file) {
        this.mDirectApkLdPaths = getDirectApkLdPaths(SysUtil.getBaseName(file.getName()), file.getAbsolutePath());
        this.mApkFile = file;
    }

    public DirectApkSoSource(File file, Set<String> set) {
        this.mDirectApkLdPaths = set;
        this.mApkFile = file;
    }

    public int loadLibrary(String str, int i, StrictMode.ThreadPolicy threadPolicy) throws IOException {
        if (SoLoader.sSoFileLoader != null) {
            for (String next : this.mDirectApkLdPaths) {
                Set set = this.mLibsInApkMap.get(next);
                if (TextUtils.isEmpty(next) || set == null || !set.contains(str)) {
                    Log.v("SoLoader", str + " not found on " + next);
                } else {
                    loadDependencies(str, i, threadPolicy);
                    try {
                        i |= 4;
                        SoLoader.sSoFileLoader.load(next + File.separator + str, i);
                        Log.d("SoLoader", str + " found on " + next);
                        return 1;
                    } catch (UnsatisfiedLinkError e) {
                        Log.w("SoLoader", str + " not found on " + next + " flag: " + i, e);
                    }
                }
            }
            return 0;
        }
        throw new IllegalStateException("SoLoader.init() not yet called");
    }

    public File unpackLibrary(String str) throws IOException {
        throw new UnsupportedOperationException("DirectAPKSoSource doesn't support unpackLibrary");
    }

    public boolean isValid() {
        return !this.mDirectApkLdPaths.isEmpty();
    }

    static Set<String> getDirectApkLdPaths(String str, String str2) {
        String fallbackApkLdPath;
        HashSet hashSet = new HashSet();
        String classLoaderLdLoadLibrary = SysUtil.Api14Utils.getClassLoaderLdLoadLibrary();
        if (classLoaderLdLoadLibrary != null) {
            for (String str3 : classLoaderLdLoadLibrary.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)) {
                if (str3.contains(str + ".apk!/")) {
                    hashSet.add(str3);
                }
            }
        }
        if (hashSet.isEmpty() && (fallbackApkLdPath = getFallbackApkLdPath(str2)) != null) {
            hashSet.add(fallbackApkLdPath);
        }
        return hashSet;
    }

    private static String[] getDependencies(String str, ElfByteChannel elfByteChannel) throws IOException {
        if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
            Api18TraceUtils.beginTraceSection("SoLoader.getElfDependencies[", str, "]");
        }
        try {
            return NativeDeps.getDependencies(str, elfByteChannel);
        } finally {
            if (SoLoader.SYSTRACE_LIBRARY_LOADING) {
                Api18TraceUtils.endSection();
            }
        }
    }

    @Nullable
    private static String getFallbackApkLdPath(String str) {
        String[] supportedAbis = SysUtil.getSupportedAbis();
        if (TextUtils.isEmpty(str) || supportedAbis.length <= 0) {
            return null;
        }
        return str + "!/lib/" + supportedAbis[0];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r8 = getDependencies(r8, r2);
        r3 = r8.length;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        if (r4 >= r3) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        r5 = r8[r4];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0047, code lost:
        if (r5.startsWith("/") == false) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r9 | 1, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004f, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        r2 = new com.facebook.soloader.ElfZipFileChannel(r1, r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadDependencies(java.lang.String r8, int r9, android.os.StrictMode.ThreadPolicy r10) throws java.io.IOException {
        /*
            r7 = this;
            java.lang.String r0 = "/"
            java.util.zip.ZipFile r1 = new java.util.zip.ZipFile
            java.io.File r2 = r7.mApkFile
            r1.<init>(r2)
            java.util.Enumeration r2 = r1.entries()     // Catch:{ all -> 0x0064 }
        L_0x000d:
            boolean r3 = r2.hasMoreElements()     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x0060
            java.lang.Object r3 = r2.nextElement()     // Catch:{ all -> 0x0064 }
            java.util.zip.ZipEntry r3 = (java.util.zip.ZipEntry) r3     // Catch:{ all -> 0x0064 }
            if (r3 == 0) goto L_0x000d
            java.lang.String r4 = r3.getName()     // Catch:{ all -> 0x0064 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0064 }
            r5.<init>()     // Catch:{ all -> 0x0064 }
            r5.append(r0)     // Catch:{ all -> 0x0064 }
            r5.append(r8)     // Catch:{ all -> 0x0064 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0064 }
            boolean r4 = r4.endsWith(r5)     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x000d
            com.facebook.soloader.ElfZipFileChannel r2 = new com.facebook.soloader.ElfZipFileChannel     // Catch:{ all -> 0x0064 }
            r2.<init>(r1, r3)     // Catch:{ all -> 0x0064 }
            java.lang.String[] r8 = getDependencies(r8, r2)     // Catch:{ all -> 0x0056 }
            int r3 = r8.length     // Catch:{ all -> 0x0056 }
            r4 = 0
        L_0x003f:
            if (r4 >= r3) goto L_0x0052
            r5 = r8[r4]     // Catch:{ all -> 0x0056 }
            boolean r6 = r5.startsWith(r0)     // Catch:{ all -> 0x0056 }
            if (r6 == 0) goto L_0x004a
            goto L_0x004f
        L_0x004a:
            r6 = r9 | 1
            com.facebook.soloader.SoLoader.loadLibraryBySoName(r5, r6, r10)     // Catch:{ all -> 0x0056 }
        L_0x004f:
            int r4 = r4 + 1
            goto L_0x003f
        L_0x0052:
            r2.close()     // Catch:{ all -> 0x0064 }
            goto L_0x0060
        L_0x0056:
            r8 = move-exception
            r2.close()     // Catch:{ all -> 0x005b }
            goto L_0x005f
        L_0x005b:
            r9 = move-exception
            r8.addSuppressed(r9)     // Catch:{ all -> 0x0064 }
        L_0x005f:
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x0060:
            r1.close()
            return
        L_0x0064:
            r8 = move-exception
            r1.close()     // Catch:{ all -> 0x0069 }
            goto L_0x006d
        L_0x0069:
            r9 = move-exception
            r8.addSuppressed(r9)
        L_0x006d:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.DirectApkSoSource.loadDependencies(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    /* access modifiers changed from: protected */
    public void prepare(int i) throws IOException {
        int indexOf;
        int i2;
        String str = null;
        for (String next : this.mDirectApkLdPaths) {
            if (!TextUtils.isEmpty(next) && (indexOf = next.indexOf(33)) >= 0 && (i2 = indexOf + 2) < next.length()) {
                str = next.substring(i2);
            }
            if (!TextUtils.isEmpty(str)) {
                ZipFile zipFile = new ZipFile(this.mApkFile);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile.entries();
                    while (entries.hasMoreElements()) {
                        ZipEntry zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry != null && zipEntry.getName().startsWith(str) && zipEntry.getName().endsWith(".so") && zipEntry.getMethod() == 0) {
                            append(next, zipEntry.getName().substring(str.length() + 1));
                        }
                    }
                    zipFile.close();
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            }
        }
        return;
        throw th;
    }

    public String toString() {
        return getClass().getName() + "[root = " + this.mDirectApkLdPaths.toString() + AbstractJsonLexerKt.END_LIST;
    }

    private synchronized void append(String str, String str2) {
        if (!this.mLibsInApkMap.containsKey(str)) {
            this.mLibsInApkMap.put(str, new HashSet());
        }
        this.mLibsInApkMap.get(str).add(str2);
    }
}
