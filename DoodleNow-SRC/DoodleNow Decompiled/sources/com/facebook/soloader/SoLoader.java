package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.soloader.SysUtil;
import com.facebook.soloader.nativeloader.NativeLoader;
import com.facebook.soloader.nativeloader.SystemDelegate;
import com.revenuecat.purchases.common.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.annotation.Nullable;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

public class SoLoader {
    static final boolean DEBUG = false;
    private static final String[] DEFAULT_DENY_LIST = {System.mapLibraryName("breakpad")};
    public static final int SOLOADER_ALLOW_ASYNC_INIT = 2;
    public static final int SOLOADER_DISABLE_BACKUP_SOSOURCE = 8;
    public static final int SOLOADER_DISABLE_FS_SYNC_JOB = 256;
    public static final int SOLOADER_DONT_TREAT_AS_SYSTEMAPP = 32;
    public static final int SOLOADER_ENABLE_DIRECT_SOSOURCE = 64;
    public static final int SOLOADER_ENABLE_EXOPACKAGE = 1;
    public static final int SOLOADER_EXPLICITLY_ENABLE_BACKUP_SOSOURCE = 128;
    public static final int SOLOADER_LOOK_IN_ZIP = 4;
    public static final int SOLOADER_SKIP_MERGED_JNI_ONLOAD = 16;
    private static final String SO_STORE_NAME_MAIN = "lib-main";
    private static final String SO_STORE_NAME_SPLIT = "lib-";
    static final boolean SYSTRACE_LIBRARY_LOADING = true;
    static final String TAG = "SoLoader";
    public static String VERSION = "0.10.5";
    private static boolean isEnabled = true;
    private static int sAppType = 0;
    @Nullable
    private static ApplicationSoSource sApplicationSoSource;
    @Nullable
    private static UnpackingSoSource[] sBackupSoSources;
    private static int sFlags;
    private static final Set<String> sLoadedAndMergedLibraries = Collections.newSetFromMap(new ConcurrentHashMap());
    /* access modifiers changed from: private */
    public static final HashSet<String> sLoadedLibraries = new HashSet<>();
    /* access modifiers changed from: private */
    public static final Map<String, Object> sLoadingLibraries = new HashMap();
    @Nullable
    static SoFileLoader sSoFileLoader;
    /* access modifiers changed from: private */
    @Nullable
    public static volatile SoSource[] sSoSources = null;
    /* access modifiers changed from: private */
    public static final ReentrantReadWriteLock sSoSourcesLock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public static final AtomicInteger sSoSourcesVersion = new AtomicInteger(0);
    @Nullable
    private static SystemLoadLibraryWrapper sSystemLoadLibraryWrapper = null;

    interface AppType {
        public static final int SYSTEM_APP = 2;
        public static final int THIRD_PARTY_APP = 1;
        public static final int UNSET = 0;
        public static final int UPDATED_SYSTEM_APP = 3;
    }

    public static void setSystemLoadLibraryWrapper(SystemLoadLibraryWrapper systemLoadLibraryWrapper) {
        sSystemLoadLibraryWrapper = systemLoadLibraryWrapper;
    }

    public static void init(Context context, int i) throws IOException {
        init(context, i, (SoFileLoader) null, DEFAULT_DENY_LIST);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader) throws IOException {
        init(context, i, soFileLoader, DEFAULT_DENY_LIST);
    }

    public static void init(Context context, int i, @Nullable SoFileLoader soFileLoader, String[] strArr) throws IOException {
        if (!isInitialized()) {
            StrictMode.ThreadPolicy allowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
            try {
                boolean initEnableConfig = initEnableConfig(context);
                isEnabled = initEnableConfig;
                if (initEnableConfig) {
                    int appType = getAppType(context, i);
                    sAppType = appType;
                    if ((i & 128) == 0 && SysUtil.isSupportedDirectLoad(context, appType)) {
                        i |= 72;
                    }
                    initSoLoader(soFileLoader);
                    initSoSources(context, i, strArr);
                    Log.v(TAG, "Init SoLoader delegate");
                    NativeLoader.initIfUninitialized(new NativeLoaderToSoLoaderDelegate());
                } else {
                    initDummySoSource();
                    Log.v(TAG, "Init System Loader delegate");
                    NativeLoader.initIfUninitialized(new SystemDelegate());
                }
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskWrites);
            }
        }
    }

    public static void init(Context context, boolean z) {
        try {
            init(context, z ? 1 : 0, (SoFileLoader) null, DEFAULT_DENY_LIST);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x003a A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean initEnableConfig(android.content.Context r4) {
        /*
            r0 = 0
            java.lang.String r1 = r4.getPackageName()     // Catch:{ Exception -> 0x0014 }
            android.content.pm.PackageManager r4 = r4.getPackageManager()     // Catch:{ Exception -> 0x0012 }
            r2 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r4 = r4.getApplicationInfo(r1, r2)     // Catch:{ Exception -> 0x0012 }
            android.os.Bundle r0 = r4.metaData     // Catch:{ Exception -> 0x0012 }
            goto L_0x002e
        L_0x0012:
            r4 = move-exception
            goto L_0x0016
        L_0x0014:
            r4 = move-exception
            r1 = r0
        L_0x0016:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Unexpected issue with package manager ("
            r2.<init>(r3)
            r2.append(r1)
            java.lang.String r1 = ")"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "SoLoader"
            android.util.Log.w(r2, r1, r4)
        L_0x002e:
            r4 = 1
            if (r0 == 0) goto L_0x003b
            java.lang.String r1 = "com.facebook.soloader.enabled"
            boolean r0 = r0.getBoolean(r1, r4)
            if (r0 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r4 = 0
        L_0x003b:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.initEnableConfig(android.content.Context):boolean");
    }

    private static void initSoSources(Context context, int i, String[] strArr) throws IOException {
        if (sSoSources == null) {
            ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (sSoSources != null) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                sFlags = i;
                ArrayList arrayList = new ArrayList();
                AddSystemLibSoSource(arrayList, strArr);
                if (context != null) {
                    if ((i & 1) != 0) {
                        addApplicationSoSource(context, arrayList, getApplicationSoSourceFlags());
                        sBackupSoSources = null;
                        if (Log.isLoggable(TAG, 3)) {
                            Log.d(TAG, "adding exo package source: lib-main");
                        }
                        arrayList.add(0, new ExoSoSource(context, SO_STORE_NAME_MAIN));
                    } else {
                        if ((i & 64) != 0) {
                            addDirectApkSoSource(context, arrayList);
                        }
                        addApplicationSoSource(context, arrayList, getApplicationSoSourceFlags());
                        AddBackupSoSource(context, arrayList, 1);
                    }
                }
                SoSource[] soSourceArr = (SoSource[]) arrayList.toArray(new SoSource[arrayList.size()]);
                int makePrepareFlags = makePrepareFlags();
                int length = soSourceArr.length;
                while (true) {
                    int i2 = length - 1;
                    if (length <= 0) {
                        break;
                    }
                    if (Log.isLoggable(TAG, 3)) {
                        Log.d(TAG, "Preparing SO source: " + soSourceArr[i2]);
                    }
                    boolean z = SYSTRACE_LIBRARY_LOADING;
                    if (z) {
                        Api18TraceUtils.beginTraceSection(TAG, "_", soSourceArr[i2].getClass().getSimpleName());
                    }
                    soSourceArr[i2].prepare(makePrepareFlags);
                    if (z) {
                        Api18TraceUtils.endSection();
                    }
                    length = i2;
                }
                sSoSources = soSourceArr;
                sSoSourcesVersion.getAndIncrement();
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "init finish: " + sSoSources.length + " SO sources prepared");
                }
            } finally {
                sSoSourcesLock.writeLock().unlock();
            }
        }
    }

    private static void initDummySoSource() {
        if (sSoSources == null) {
            ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (sSoSources != null) {
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                sSoSources = new SoSource[0];
                reentrantReadWriteLock.writeLock().unlock();
            } catch (Throwable th) {
                sSoSourcesLock.writeLock().unlock();
                throw th;
            }
        }
    }

    private static int getApplicationSoSourceFlags() {
        int i = sAppType;
        if (i == 1) {
            return 0;
        }
        if (i == 2 || i == 3) {
            return 1;
        }
        throw new RuntimeException("Unsupported app type, we should not reach here");
    }

    private static void addDirectApkSoSource(Context context, ArrayList<SoSource> arrayList) {
        if (context.getApplicationInfo().splitSourceDirs != null) {
            for (String file : context.getApplicationInfo().splitSourceDirs) {
                DirectApkSoSource directApkSoSource = new DirectApkSoSource(new File(file));
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "validating/adding directApk source from splitApk: " + directApkSoSource.toString());
                }
                if (directApkSoSource.isValid()) {
                    arrayList.add(0, directApkSoSource);
                }
            }
        }
        DirectApkSoSource directApkSoSource2 = new DirectApkSoSource(context);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "validating/adding directApk source: " + directApkSoSource2.toString());
        }
        if (directApkSoSource2.isValid()) {
            arrayList.add(0, directApkSoSource2);
        }
    }

    private static void addApplicationSoSource(Context context, ArrayList<SoSource> arrayList, int i) {
        sApplicationSoSource = new ApplicationSoSource(context, i);
        if (Log.isLoggable(TAG, 3)) {
            Log.d(TAG, "adding application source: " + sApplicationSoSource.toString());
        }
        arrayList.add(0, sApplicationSoSource);
    }

    private static void AddBackupSoSource(Context context, ArrayList<SoSource> arrayList, int i) throws IOException {
        if ((sFlags & 8) != 0) {
            sBackupSoSources = null;
            File soStorePath = UnpackingSoSource.getSoStorePath(context, SO_STORE_NAME_MAIN);
            try {
                SysUtil.dumbDeleteRecursive(soStorePath);
            } catch (IOException e) {
                Log.w(TAG, "Failed to delete " + soStorePath.getCanonicalPath(), e);
            }
        } else {
            File file = new File(context.getApplicationInfo().sourceDir);
            ArrayList arrayList2 = new ArrayList();
            ApkSoSource apkSoSource = new ApkSoSource(context, file, SO_STORE_NAME_MAIN, i);
            arrayList2.add(apkSoSource);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding backup source from : " + apkSoSource.toString());
            }
            addBackupSoSourceFromSplitApk(context, i, arrayList2);
            sBackupSoSources = (UnpackingSoSource[]) arrayList2.toArray(new UnpackingSoSource[arrayList2.size()]);
            arrayList.addAll(0, arrayList2);
        }
    }

    private static void addBackupSoSourceFromSplitApk(Context context, int i, ArrayList<UnpackingSoSource> arrayList) {
        if (context.getApplicationInfo().splitSourceDirs != null) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding backup sources from split apks");
            }
            String[] strArr = context.getApplicationInfo().splitSourceDirs;
            int length = strArr.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                File file = new File(strArr[i2]);
                StringBuilder sb = new StringBuilder(SO_STORE_NAME_SPLIT);
                int i4 = i3 + 1;
                sb.append(i3);
                ApkSoSource apkSoSource = new ApkSoSource(context, file, sb.toString(), i);
                if (Log.isLoggable(TAG, 3)) {
                    Log.d(TAG, "adding backup source: " + apkSoSource.toString());
                }
                arrayList.add(apkSoSource);
                i2++;
                i3 = i4;
            }
        }
    }

    private static void AddSystemLibSoSource(ArrayList<SoSource> arrayList, String[] strArr) {
        String str = SysUtil.is64Bit() ? "/system/lib64:/vendor/lib64" : "/system/lib:/vendor/lib";
        String str2 = System.getenv("LD_LIBRARY_PATH");
        if (str2 != null && !str2.equals("")) {
            str = str + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + str2;
        }
        for (String str3 : new HashSet(Arrays.asList(str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR)))) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "adding system library source: " + str3);
            }
            arrayList.add(new DirectorySoSource(new File(str3), 2, strArr));
        }
    }

    private static int makePrepareFlags() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            int i = sFlags;
            int i2 = (i & 2) != 0 ? 1 : 0;
            if ((i & 256) != 0) {
                i2 |= 4;
            }
            reentrantReadWriteLock.writeLock().unlock();
            return i2;
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    private static synchronized void initSoLoader(@Nullable SoFileLoader soFileLoader) {
        synchronized (SoLoader.class) {
            if (soFileLoader == null) {
                if (sSoFileLoader != null) {
                    return;
                }
            }
            if (soFileLoader != null) {
                sSoFileLoader = soFileLoader;
                return;
            }
            final Runtime runtime = Runtime.getRuntime();
            final Method nativeLoadRuntimeMethod = getNativeLoadRuntimeMethod();
            final boolean z = nativeLoadRuntimeMethod != null;
            final String classLoaderLdLoadLibrary = z ? SysUtil.Api14Utils.getClassLoaderLdLoadLibrary() : null;
            final String makeNonZipPath = makeNonZipPath(classLoaderLdLoadLibrary);
            sSoFileLoader = new SoFileLoader() {
                public void loadBytes(String str, ElfByteChannel elfByteChannel, int i) {
                    throw new UnsupportedOperationException();
                }

                /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
                    if (r2 == null) goto L_?;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:16:0x0032, code lost:
                    android.util.Log.e(com.facebook.soloader.SoLoader.TAG, "Error when loading lib: " + r2 + " lib hash: " + getLibHash(r9) + " search path is " + r10);
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
                    return;
                 */
                /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
                    return;
                 */
                /* JADX WARNING: Removed duplicated region for block: B:40:0x0097  */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void load(java.lang.String r9, int r10) {
                    /*
                        r8 = this;
                        boolean r0 = r2
                        if (r0 == 0) goto L_0x00bf
                        r0 = 4
                        r10 = r10 & r0
                        if (r10 != r0) goto L_0x000b
                        java.lang.String r10 = r3
                        goto L_0x000d
                    L_0x000b:
                        java.lang.String r10 = r4
                    L_0x000d:
                        r0 = 0
                        java.lang.Runtime r1 = r5     // Catch:{ IllegalAccessException -> 0x0077, IllegalArgumentException -> 0x0075, InvocationTargetException -> 0x0073, all -> 0x006f }
                        monitor-enter(r1)     // Catch:{ IllegalAccessException -> 0x0077, IllegalArgumentException -> 0x0075, InvocationTargetException -> 0x0073, all -> 0x006f }
                        java.lang.reflect.Method r2 = r6     // Catch:{ all -> 0x0061 }
                        java.lang.Runtime r3 = r5     // Catch:{ all -> 0x0061 }
                        r4 = 3
                        java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0061 }
                        r5 = 0
                        r4[r5] = r9     // Catch:{ all -> 0x0061 }
                        java.lang.Class<com.facebook.soloader.SoLoader> r5 = com.facebook.soloader.SoLoader.class
                        java.lang.ClassLoader r5 = r5.getClassLoader()     // Catch:{ all -> 0x0061 }
                        r6 = 1
                        r4[r6] = r5     // Catch:{ all -> 0x0061 }
                        r5 = 2
                        r4[r5] = r10     // Catch:{ all -> 0x0061 }
                        java.lang.Object r2 = r2.invoke(r3, r4)     // Catch:{ all -> 0x0061 }
                        java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x0061 }
                        if (r2 != 0) goto L_0x005b
                        monitor-exit(r1)     // Catch:{ all -> 0x006d }
                        if (r2 == 0) goto L_0x00c2
                        java.lang.String r0 = "SoLoader"
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder
                        java.lang.String r3 = "Error when loading lib: "
                        r1.<init>(r3)
                        r1.append(r2)
                        java.lang.String r2 = " lib hash: "
                        r1.append(r2)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r1.append(r9)
                        java.lang.String r9 = " search path is "
                        r1.append(r9)
                        r1.append(r10)
                        java.lang.String r9 = r1.toString()
                        android.util.Log.e(r0, r9)
                        goto L_0x00c2
                    L_0x005b:
                        java.lang.UnsatisfiedLinkError r0 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x006d }
                        r0.<init>(r2)     // Catch:{ all -> 0x006d }
                        throw r0     // Catch:{ all -> 0x006d }
                    L_0x0061:
                        r2 = move-exception
                        r7 = r2
                        r2 = r0
                        r0 = r7
                    L_0x0065:
                        monitor-exit(r1)     // Catch:{ all -> 0x006d }
                        throw r0     // Catch:{ IllegalAccessException -> 0x006b, IllegalArgumentException -> 0x0069, InvocationTargetException -> 0x0067 }
                    L_0x0067:
                        r0 = move-exception
                        goto L_0x007a
                    L_0x0069:
                        r0 = move-exception
                        goto L_0x007a
                    L_0x006b:
                        r0 = move-exception
                        goto L_0x007a
                    L_0x006d:
                        r0 = move-exception
                        goto L_0x0065
                    L_0x006f:
                        r1 = move-exception
                        r2 = r0
                        r0 = r1
                        goto L_0x0095
                    L_0x0073:
                        r1 = move-exception
                        goto L_0x0078
                    L_0x0075:
                        r1 = move-exception
                        goto L_0x0078
                    L_0x0077:
                        r1 = move-exception
                    L_0x0078:
                        r2 = r0
                        r0 = r1
                    L_0x007a:
                        java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0094 }
                        r1.<init>()     // Catch:{ all -> 0x0094 }
                        java.lang.String r3 = "Error: Cannot load "
                        r1.append(r3)     // Catch:{ all -> 0x0094 }
                        r1.append(r9)     // Catch:{ all -> 0x0094 }
                        java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0094 }
                        java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0091 }
                        r2.<init>(r1, r0)     // Catch:{ all -> 0x0091 }
                        throw r2     // Catch:{ all -> 0x0091 }
                    L_0x0091:
                        r0 = move-exception
                        r2 = r1
                        goto L_0x0095
                    L_0x0094:
                        r0 = move-exception
                    L_0x0095:
                        if (r2 == 0) goto L_0x00be
                        java.lang.String r1 = "SoLoader"
                        java.lang.StringBuilder r3 = new java.lang.StringBuilder
                        java.lang.String r4 = "Error when loading lib: "
                        r3.<init>(r4)
                        r3.append(r2)
                        java.lang.String r2 = " lib hash: "
                        r3.append(r2)
                        java.lang.String r9 = r8.getLibHash(r9)
                        r3.append(r9)
                        java.lang.String r9 = " search path is "
                        r3.append(r9)
                        r3.append(r10)
                        java.lang.String r9 = r3.toString()
                        android.util.Log.e(r1, r9)
                    L_0x00be:
                        throw r0
                    L_0x00bf:
                        java.lang.System.load(r9)
                    L_0x00c2:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.AnonymousClass1.load(java.lang.String, int):void");
                }

                private String getLibHash(String str) {
                    FileInputStream fileInputStream;
                    try {
                        File file = new File(str);
                        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                        fileInputStream = new FileInputStream(file);
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                instance.update(bArr, 0, read);
                            } else {
                                String format = String.format("%32x", new Object[]{new BigInteger(1, instance.digest())});
                                fileInputStream.close();
                                return format;
                            }
                        }
                    } catch (IOException | SecurityException | NoSuchAlgorithmException e) {
                        return e.toString();
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                    throw th;
                }
            };
        }
    }

    @Nullable
    private static Method getNativeLoadRuntimeMethod() {
        if (Build.VERSION.SDK_INT > 27) {
            return null;
        }
        try {
            Method declaredMethod = Runtime.class.getDeclaredMethod("nativeLoad", new Class[]{String.class, ClassLoader.class, String.class});
            declaredMethod.setAccessible(true);
            return declaredMethod;
        } catch (NoSuchMethodException | SecurityException e) {
            Log.w(TAG, "Cannot get nativeLoad method", e);
            return null;
        }
    }

    private static int getAppType(Context context, int i) {
        int i2 = sAppType;
        if (i2 != 0) {
            return i2;
        }
        int i3 = 1;
        if ((i & 32) == 0 && context != null) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((applicationInfo.flags & 1) != 0) {
                i3 = (applicationInfo.flags & 128) != 0 ? 3 : 2;
            }
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "ApplicationInfo.flags is: " + applicationInfo.flags + " appType is: " + i3);
            }
        }
        return i3;
    }

    public static void setInTestMode() {
        TestOnlyUtils.setSoSources(new SoSource[]{new NoopSoSource()});
    }

    public static void deinitForTest() {
        TestOnlyUtils.setSoSources((SoSource[]) null);
    }

    static class TestOnlyUtils {
        TestOnlyUtils() {
        }

        static void setSoSources(SoSource[] soSourceArr) {
            SoLoader.sSoSourcesLock.writeLock().lock();
            try {
                SoSource[] unused = SoLoader.sSoSources = soSourceArr;
                SoLoader.sSoSourcesVersion.getAndIncrement();
            } finally {
                SoLoader.sSoSourcesLock.writeLock().unlock();
            }
        }

        static void setSoFileLoader(SoFileLoader soFileLoader) {
            SoLoader.sSoFileLoader = soFileLoader;
        }

        static void resetStatus() {
            synchronized (SoLoader.class) {
                SoLoader.sLoadedLibraries.clear();
                SoLoader.sLoadingLibraries.clear();
                SoLoader.sSoFileLoader = null;
            }
            setSoSources((SoSource[]) null);
        }
    }

    public static final class WrongAbiError extends UnsatisfiedLinkError {
        WrongAbiError(Throwable th, String str) {
            super("APK was built for a different platform. Supported ABIs: " + Arrays.toString(SysUtil.getSupportedAbis()) + " error: " + str);
            initCause(th);
        }
    }

    @Nullable
    public static String getLibraryPath(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String str2 = null;
            if (sSoSources != null) {
                int i = 0;
                while (str2 == null && i < sSoSources.length) {
                    str2 = sSoSources[i].getLibraryPath(str);
                    i++;
                }
            }
            return str2;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static String[] getLibraryDependencies(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            String[] strArr = null;
            if (sSoSources != null) {
                int i = 0;
                while (strArr == null && i < sSoSources.length) {
                    strArr = sSoSources[i].getLibraryDependencies(str);
                    i++;
                }
            }
            return strArr;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    @Nullable
    public static File getSoFile(String str) {
        String mapLibName = MergedSoMapping.mapLibName(str);
        if (mapLibName != null) {
            str = mapLibName;
        }
        String mapLibraryName = System.mapLibraryName(str);
        sSoSourcesLock.readLock().lock();
        try {
            if (sSoSources != null) {
                int i = 0;
                while (i < sSoSources.length) {
                    try {
                        File soFileByName = sSoSources[i].getSoFileByName(mapLibraryName);
                        if (soFileByName != null) {
                            return soFileByName;
                        }
                        i++;
                    } catch (IOException unused) {
                    }
                }
            }
            sSoSourcesLock.readLock().unlock();
            return null;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    public static boolean loadLibrary(String str) {
        return isEnabled ? loadLibrary(str, 0) : NativeLoader.loadLibrary(str);
    }

    public static boolean loadLibrary(String str, int i) throws UnsatisfiedLinkError {
        SystemLoadLibraryWrapper systemLoadLibraryWrapper;
        Boolean loadLibraryOnNonAndroid = loadLibraryOnNonAndroid(str);
        if (loadLibraryOnNonAndroid != null) {
            return loadLibraryOnNonAndroid.booleanValue();
        }
        if (!isEnabled) {
            return NativeLoader.loadLibrary(str);
        }
        int i2 = sAppType;
        if ((i2 == 2 || i2 == 3) && (systemLoadLibraryWrapper = sSystemLoadLibraryWrapper) != null) {
            systemLoadLibraryWrapper.loadLibrary(str);
            return true;
        }
        String mapLibName = MergedSoMapping.mapLibName(str);
        return loadLibraryBySoName(System.mapLibraryName(mapLibName != null ? mapLibName : str), str, mapLibName, i, (StrictMode.ThreadPolicy) null);
    }

    @Nullable
    private static Boolean loadLibraryOnNonAndroid(String str) {
        Boolean valueOf;
        if (sSoSources != null) {
            return null;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                if ("http://www.android.com/".equals(System.getProperty("java.vendor.url"))) {
                    assertInitialized();
                } else {
                    synchronized (SoLoader.class) {
                        boolean z = !sLoadedLibraries.contains(str);
                        if (z) {
                            SystemLoadLibraryWrapper systemLoadLibraryWrapper = sSystemLoadLibraryWrapper;
                            if (systemLoadLibraryWrapper != null) {
                                systemLoadLibraryWrapper.loadLibrary(str);
                            } else {
                                System.loadLibrary(str);
                            }
                        }
                        valueOf = Boolean.valueOf(z);
                    }
                    reentrantReadWriteLock.readLock().unlock();
                    return valueOf;
                }
            }
            reentrantReadWriteLock.readLock().unlock();
            return null;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    static void loadLibraryBySoName(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        loadLibraryBySoNameImpl(str, (String) null, (String) null, i, threadPolicy);
    }

    private static boolean loadLibraryBySoName(String str, @Nullable String str2, @Nullable String str3, int i, @Nullable StrictMode.ThreadPolicy threadPolicy) {
        boolean z;
        boolean z2 = false;
        do {
            try {
                z2 = loadLibraryBySoNameImpl(str, str2, str3, i, threadPolicy);
                z = false;
                continue;
            } catch (UnsatisfiedLinkError e) {
                int i2 = sSoSourcesVersion.get();
                sSoSourcesLock.writeLock().lock();
                try {
                    if (sApplicationSoSource == null || !sApplicationSoSource.checkAndMaybeUpdate()) {
                        z = false;
                    } else {
                        Log.w(TAG, "sApplicationSoSource updated during load: " + str + ", attempting load again.");
                        sSoSourcesVersion.getAndIncrement();
                        z = true;
                    }
                    sSoSourcesLock.writeLock().unlock();
                    if (sSoSourcesVersion.get() == i2) {
                        throw e;
                    }
                } catch (IOException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    sSoSourcesLock.writeLock().unlock();
                    throw th;
                }
            }
        } while (z);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:102:0x0148, code lost:
        throw new java.lang.RuntimeException("Failed to call JNI_OnLoad from '" + r2 + "', which has been merged into '" + r1 + "'.  See comment for details.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x014b, code lost:
        if (SYSTRACE_LIBRARY_LOADING != false) goto L_0x014d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x014d, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0150, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x0151, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0152, code lost:
        r7.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x015b, code lost:
        return !r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x015e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x015f, code lost:
        sSoSourcesLock.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0168, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        r7 = sSoSourcesLock;
        r7.readLock().lock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0053, code lost:
        if (r10 != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0055, code lost:
        r14 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        monitor-enter(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005c, code lost:
        if (r9.contains(r1) == false) goto L_0x006b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005e, code lost:
        if (r18 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0060, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0062, code lost:
        r7.readLock().unlock();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0069, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x006a, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        monitor-exit(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006c, code lost:
        if (r10 != false) goto L_0x00d6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0074, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0076, code lost:
        android.util.Log.d(TAG, "About to load: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0087, code lost:
        doLoadLibraryBySoName(r1, r0, r20);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0092, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0094, code lost:
        android.util.Log.d(TAG, "Loaded: " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00a5, code lost:
        r3 = com.facebook.soloader.SoLoader.class;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00a7, code lost:
        monitor-enter(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:?, code lost:
        r9.add(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00ab, code lost:
        monitor-exit(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00b0, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b1, code lost:
        r1 = r0.getMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00b5, code lost:
        if (r1 == null) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x00ce, code lost:
        throw new com.facebook.soloader.SoLoader.WrongAbiError(r0, r1.substring(r1.lastIndexOf("unexpected e_machine:")));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x00cf, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x00d3, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x00d8, code lost:
        if ((r0 & 16) != 0) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x00de, code lost:
        if (android.text.TextUtils.isEmpty(r17) != false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x00e6, code lost:
        if (sLoadedAndMergedLibraries.contains(r2) == false) goto L_0x00e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x00e8, code lost:
        r8 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x00e9, code lost:
        if (r18 == null) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x00eb, code lost:
        if (r8 != false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x00ed, code lost:
        r0 = SYSTRACE_LIBRARY_LOADING;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x00ef, code lost:
        if (r0 == false) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x00f1, code lost:
        com.facebook.soloader.Api18TraceUtils.beginTraceSection("MergedSoMapping.invokeJniOnload[", r2, "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x00fe, code lost:
        if (android.util.Log.isLoggable(TAG, 3) == false) goto L_0x0119;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0100, code lost:
        android.util.Log.d(TAG, "About to merge: " + r2 + " / " + r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0119, code lost:
        com.facebook.soloader.MergedSoMapping.invokeJniOnload(r17);
        sLoadedAndMergedLibraries.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0121, code lost:
        if (r0 == false) goto L_0x0151;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:?, code lost:
        com.facebook.soloader.Api18TraceUtils.endSection();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0127, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0129, code lost:
        r0 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean loadLibraryBySoNameImpl(java.lang.String r16, @javax.annotation.Nullable java.lang.String r17, @javax.annotation.Nullable java.lang.String r18, int r19, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r20) {
        /*
            r1 = r16
            r2 = r17
            r0 = r19
            java.lang.String r3 = "Loaded: "
            java.lang.String r4 = "About to load: "
            java.lang.String r5 = "About to merge: "
            java.lang.String r6 = "Failed to call JNI_OnLoad from '"
            boolean r7 = android.text.TextUtils.isEmpty(r17)
            r8 = 0
            if (r7 != 0) goto L_0x001e
            java.util.Set<java.lang.String> r7 = sLoadedAndMergedLibraries
            boolean r7 = r7.contains(r2)
            if (r7 == 0) goto L_0x001e
            return r8
        L_0x001e:
            java.lang.Class<com.facebook.soloader.SoLoader> r7 = com.facebook.soloader.SoLoader.class
            monitor-enter(r7)
            java.util.HashSet<java.lang.String> r9 = sLoadedLibraries     // Catch:{ all -> 0x0169 }
            boolean r10 = r9.contains(r1)     // Catch:{ all -> 0x0169 }
            r11 = 1
            if (r10 == 0) goto L_0x0030
            if (r18 != 0) goto L_0x002e
            monitor-exit(r7)     // Catch:{ all -> 0x0169 }
            return r8
        L_0x002e:
            r10 = r11
            goto L_0x0031
        L_0x0030:
            r10 = r8
        L_0x0031:
            java.util.Map<java.lang.String, java.lang.Object> r12 = sLoadingLibraries     // Catch:{ all -> 0x0169 }
            boolean r13 = r12.containsKey(r1)     // Catch:{ all -> 0x0169 }
            if (r13 == 0) goto L_0x003e
            java.lang.Object r12 = r12.get(r1)     // Catch:{ all -> 0x0169 }
            goto L_0x0047
        L_0x003e:
            java.lang.Object r13 = new java.lang.Object     // Catch:{ all -> 0x0169 }
            r13.<init>()     // Catch:{ all -> 0x0169 }
            r12.put(r1, r13)     // Catch:{ all -> 0x0169 }
            r12 = r13
        L_0x0047:
            monitor-exit(r7)     // Catch:{ all -> 0x0169 }
            java.util.concurrent.locks.ReentrantReadWriteLock r7 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r7.readLock()
            r13.lock()
            monitor-enter(r12)     // Catch:{ all -> 0x015e }
            r13 = 3
            if (r10 != 0) goto L_0x00d6
            java.lang.Class<com.facebook.soloader.SoLoader> r14 = com.facebook.soloader.SoLoader.class
            monitor-enter(r14)     // Catch:{ all -> 0x00d3 }
            boolean r15 = r9.contains(r1)     // Catch:{ all -> 0x00d0 }
            if (r15 == 0) goto L_0x006b
            if (r18 != 0) goto L_0x006a
            monitor-exit(r14)     // Catch:{ all -> 0x00d0 }
            monitor-exit(r12)     // Catch:{ all -> 0x00d3 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r7.readLock()
            r0.unlock()
            return r8
        L_0x006a:
            r10 = r11
        L_0x006b:
            monitor-exit(r14)     // Catch:{ all -> 0x00d0 }
            if (r10 != 0) goto L_0x00d6
            java.lang.String r14 = "SoLoader"
            boolean r14 = android.util.Log.isLoggable(r14, r13)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            if (r14 == 0) goto L_0x0087
            java.lang.String r14 = "SoLoader"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            r15.<init>(r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            r15.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            java.lang.String r4 = r15.toString()     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            android.util.Log.d(r14, r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
        L_0x0087:
            r4 = r20
            doLoadLibraryBySoName(r1, r0, r4)     // Catch:{ UnsatisfiedLinkError -> 0x00b0 }
            java.lang.String r4 = "SoLoader"
            boolean r4 = android.util.Log.isLoggable(r4, r13)     // Catch:{ all -> 0x00d3 }
            if (r4 == 0) goto L_0x00a5
            java.lang.String r4 = "SoLoader"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d3 }
            r14.<init>(r3)     // Catch:{ all -> 0x00d3 }
            r14.append(r1)     // Catch:{ all -> 0x00d3 }
            java.lang.String r3 = r14.toString()     // Catch:{ all -> 0x00d3 }
            android.util.Log.d(r4, r3)     // Catch:{ all -> 0x00d3 }
        L_0x00a5:
            java.lang.Class<com.facebook.soloader.SoLoader> r3 = com.facebook.soloader.SoLoader.class
            monitor-enter(r3)     // Catch:{ all -> 0x00d3 }
            r9.add(r1)     // Catch:{ all -> 0x00ad }
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            goto L_0x00d6
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x00b0:
            r0 = move-exception
            java.lang.String r1 = r0.getMessage()     // Catch:{ all -> 0x00d3 }
            if (r1 == 0) goto L_0x00cf
            java.lang.String r2 = "unexpected e_machine:"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x00d3 }
            if (r2 == 0) goto L_0x00cf
            java.lang.String r2 = "unexpected e_machine:"
            int r2 = r1.lastIndexOf(r2)     // Catch:{ all -> 0x00d3 }
            java.lang.String r1 = r1.substring(r2)     // Catch:{ all -> 0x00d3 }
            com.facebook.soloader.SoLoader$WrongAbiError r2 = new com.facebook.soloader.SoLoader$WrongAbiError     // Catch:{ all -> 0x00d3 }
            r2.<init>(r0, r1)     // Catch:{ all -> 0x00d3 }
            throw r2     // Catch:{ all -> 0x00d3 }
        L_0x00cf:
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x00d0:
            r0 = move-exception
            monitor-exit(r14)     // Catch:{ all -> 0x00d0 }
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x00d3:
            r0 = move-exception
            goto L_0x015c
        L_0x00d6:
            r0 = r0 & 16
            if (r0 != 0) goto L_0x0151
            boolean r0 = android.text.TextUtils.isEmpty(r17)     // Catch:{ all -> 0x00d3 }
            if (r0 != 0) goto L_0x00e9
            java.util.Set<java.lang.String> r0 = sLoadedAndMergedLibraries     // Catch:{ all -> 0x00d3 }
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x00d3 }
            if (r0 == 0) goto L_0x00e9
            r8 = r11
        L_0x00e9:
            if (r18 == 0) goto L_0x0151
            if (r8 != 0) goto L_0x0151
            boolean r0 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00d3 }
            if (r0 == 0) goto L_0x00f8
            java.lang.String r3 = "MergedSoMapping.invokeJniOnload["
            java.lang.String r4 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r3, r2, r4)     // Catch:{ all -> 0x00d3 }
        L_0x00f8:
            java.lang.String r3 = "SoLoader"
            boolean r3 = android.util.Log.isLoggable(r3, r13)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            if (r3 == 0) goto L_0x0119
            java.lang.String r3 = "SoLoader"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            r4.<init>(r5)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            r4.append(r2)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            java.lang.String r5 = " / "
            r4.append(r5)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            r4.append(r1)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            java.lang.String r4 = r4.toString()     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            android.util.Log.d(r3, r4)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
        L_0x0119:
            com.facebook.soloader.MergedSoMapping.invokeJniOnload(r17)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            java.util.Set<java.lang.String> r3 = sLoadedAndMergedLibraries     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            r3.add(r2)     // Catch:{ UnsatisfiedLinkError -> 0x0129 }
            if (r0 == 0) goto L_0x0151
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x00d3 }
            goto L_0x0151
        L_0x0127:
            r0 = move-exception
            goto L_0x0149
        L_0x0129:
            r0 = move-exception
            java.lang.RuntimeException r3 = new java.lang.RuntimeException     // Catch:{ all -> 0x0127 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0127 }
            r4.<init>(r6)     // Catch:{ all -> 0x0127 }
            r4.append(r2)     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = "', which has been merged into '"
            r4.append(r2)     // Catch:{ all -> 0x0127 }
            r4.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = "'.  See comment for details."
            r4.append(r1)     // Catch:{ all -> 0x0127 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0127 }
            r3.<init>(r1, r0)     // Catch:{ all -> 0x0127 }
            throw r3     // Catch:{ all -> 0x0127 }
        L_0x0149:
            boolean r1 = SYSTRACE_LIBRARY_LOADING     // Catch:{ all -> 0x00d3 }
            if (r1 == 0) goto L_0x0150
            com.facebook.soloader.Api18TraceUtils.endSection()     // Catch:{ all -> 0x00d3 }
        L_0x0150:
            throw r0     // Catch:{ all -> 0x00d3 }
        L_0x0151:
            monitor-exit(r12)     // Catch:{ all -> 0x00d3 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r0 = r7.readLock()
            r0.unlock()
            r0 = r10 ^ 1
            return r0
        L_0x015c:
            monitor-exit(r12)     // Catch:{ all -> 0x00d3 }
            throw r0     // Catch:{ all -> 0x015e }
        L_0x015e:
            r0 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()
            r1.unlock()
            throw r0
        L_0x0169:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0169 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.loadLibraryBySoNameImpl(java.lang.String, java.lang.String, java.lang.String, int, android.os.StrictMode$ThreadPolicy):boolean");
    }

    public static File unpackLibraryAndDependencies(String str) throws UnsatisfiedLinkError {
        assertInitialized();
        try {
            return unpackLibraryBySoName(System.mapLibraryName(str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x011e  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void doLoadLibraryBySoName(java.lang.String r12, int r13, @javax.annotation.Nullable android.os.StrictMode.ThreadPolicy r14) throws java.lang.UnsatisfiedLinkError {
        /*
            java.lang.String r0 = " result: "
            java.lang.String r1 = "Could not load: "
            java.util.concurrent.locks.ReentrantReadWriteLock r2 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r3 = r2.readLock()
            r3.lock()
            com.facebook.soloader.SoSource[] r3 = sSoSources     // Catch:{ all -> 0x0180 }
            java.lang.String r4 = "SoLoader"
            java.lang.String r5 = "couldn't find DSO to load: "
            if (r3 == 0) goto L_0x015a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r2.readLock()
            r1.unlock()
            r1 = 1
            r3 = 0
            if (r14 != 0) goto L_0x0026
            android.os.StrictMode$ThreadPolicy r14 = android.os.StrictMode.allowThreadDiskReads()
            r6 = r1
            goto L_0x0027
        L_0x0026:
            r6 = r3
        L_0x0027:
            boolean r7 = SYSTRACE_LIBRARY_LOADING
            if (r7 == 0) goto L_0x0032
            java.lang.String r7 = "SoLoader.loadLibrary["
            java.lang.String r8 = "]"
            com.facebook.soloader.Api18TraceUtils.beginTraceSection(r7, r12, r8)
        L_0x0032:
            r7 = 3
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r2 = r2.readLock()     // Catch:{ all -> 0x0114 }
            r2.lock()     // Catch:{ all -> 0x0114 }
            r2 = r3
            r8 = r2
        L_0x003c:
            if (r2 != 0) goto L_0x0090
            com.facebook.soloader.SoSource[] r9 = sSoSources     // Catch:{ all -> 0x0084 }
            int r9 = r9.length     // Catch:{ all -> 0x0084 }
            if (r8 >= r9) goto L_0x0090
            com.facebook.soloader.SoSource[] r9 = sSoSources     // Catch:{ all -> 0x0084 }
            r9 = r9[r8]     // Catch:{ all -> 0x0084 }
            int r2 = r9.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x0084 }
            if (r2 != r7) goto L_0x0081
            com.facebook.soloader.UnpackingSoSource[] r9 = sBackupSoSources     // Catch:{ all -> 0x0084 }
            if (r9 == 0) goto L_0x0081
            boolean r8 = android.util.Log.isLoggable(r4, r7)     // Catch:{ all -> 0x0084 }
            if (r8 == 0) goto L_0x006b
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0084 }
            r8.<init>()     // Catch:{ all -> 0x0084 }
            java.lang.String r9 = "Trying backup SoSource for "
            r8.append(r9)     // Catch:{ all -> 0x0084 }
            r8.append(r12)     // Catch:{ all -> 0x0084 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0084 }
            android.util.Log.d(r4, r8)     // Catch:{ all -> 0x0084 }
        L_0x006b:
            com.facebook.soloader.UnpackingSoSource[] r8 = sBackupSoSources     // Catch:{ all -> 0x0084 }
            int r9 = r8.length     // Catch:{ all -> 0x0084 }
            r10 = r3
        L_0x006f:
            if (r10 >= r9) goto L_0x0090
            r11 = r8[r10]     // Catch:{ all -> 0x0084 }
            r11.prepare((java.lang.String) r12)     // Catch:{ all -> 0x0084 }
            int r11 = r11.loadLibrary(r12, r13, r14)     // Catch:{ all -> 0x0084 }
            if (r11 != r1) goto L_0x007e
            r2 = r11
            goto L_0x0090
        L_0x007e:
            int r10 = r10 + 1
            goto L_0x006f
        L_0x0081:
            int r8 = r8 + 1
            goto L_0x003c
        L_0x0084:
            r13 = move-exception
            r3 = r2
            java.util.concurrent.locks.ReentrantReadWriteLock r1 = sSoSourcesLock     // Catch:{ all -> 0x0114 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r1.readLock()     // Catch:{ all -> 0x0114 }
            r1.unlock()     // Catch:{ all -> 0x0114 }
            throw r13     // Catch:{ all -> 0x0114 }
        L_0x0090:
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock     // Catch:{ all -> 0x0111 }
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r13.readLock()     // Catch:{ all -> 0x0111 }
            r1.unlock()     // Catch:{ all -> 0x0111 }
            boolean r1 = SYSTRACE_LIBRARY_LOADING
            if (r1 == 0) goto L_0x00a0
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x00a0:
            if (r6 == 0) goto L_0x00a5
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x00a5:
            if (r2 == 0) goto L_0x00a9
            if (r2 != r7) goto L_0x0126
        L_0x00a9:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r5)
            r14.append(r12)
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r13.readLock()
            r12.lock()
        L_0x00b8:
            com.facebook.soloader.SoSource[] r12 = sSoSources
            int r12 = r12.length
            if (r3 >= r12) goto L_0x00d8
            java.lang.String r12 = "\n\tSoSource "
            r14.append(r12)
            r14.append(r3)
            java.lang.String r12 = ": "
            r14.append(r12)
            com.facebook.soloader.SoSource[] r12 = sSoSources
            r12 = r12[r3]
            java.lang.String r12 = r12.toString()
            r14.append(r12)
            int r3 = r3 + 1
            goto L_0x00b8
        L_0x00d8:
            com.facebook.soloader.ApplicationSoSource r12 = sApplicationSoSource
            if (r12 == 0) goto L_0x00f5
            android.content.Context r12 = r12.getUpdatedContext()
            java.io.File r12 = com.facebook.soloader.ApplicationSoSource.getNativeLibDirFromContext(r12)
            java.lang.String r13 = "\n\tNative lib dir: "
            r14.append(r13)
            java.lang.String r12 = r12.getAbsolutePath()
            r14.append(r12)
            java.lang.String r12 = "\n"
            r14.append(r12)
        L_0x00f5:
            java.util.concurrent.locks.ReentrantReadWriteLock r12 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r12 = r12.readLock()
            r12.unlock()
            r14.append(r0)
            r14.append(r2)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r4, r12)
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError
            r13.<init>(r12)
            throw r13
        L_0x0111:
            r13 = move-exception
            r3 = r2
            goto L_0x0115
        L_0x0114:
            r13 = move-exception
        L_0x0115:
            boolean r1 = SYSTRACE_LIBRARY_LOADING
            if (r1 == 0) goto L_0x011c
            com.facebook.soloader.Api18TraceUtils.endSection()
        L_0x011c:
            if (r6 == 0) goto L_0x0121
            android.os.StrictMode.setThreadPolicy(r14)
        L_0x0121:
            if (r3 == 0) goto L_0x0127
            if (r3 != r7) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            return
        L_0x0127:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r5)
            r14.append(r12)
            java.lang.String r12 = r13.getMessage()
            if (r12 != 0) goto L_0x0139
            java.lang.String r12 = r13.toString()
        L_0x0139:
            java.lang.String r1 = " caused by: "
            r14.append(r1)
            r14.append(r12)
            r13.printStackTrace()
            r14.append(r0)
            r14.append(r3)
            java.lang.String r12 = r14.toString()
            android.util.Log.e(r4, r12)
            java.lang.UnsatisfiedLinkError r14 = new java.lang.UnsatisfiedLinkError
            r14.<init>(r12)
            r14.initCause(r13)
            throw r14
        L_0x015a:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
            r13.<init>(r1)     // Catch:{ all -> 0x0180 }
            r13.append(r12)     // Catch:{ all -> 0x0180 }
            java.lang.String r14 = " because no SO source exists"
            r13.append(r14)     // Catch:{ all -> 0x0180 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0180 }
            android.util.Log.e(r4, r13)     // Catch:{ all -> 0x0180 }
            java.lang.UnsatisfiedLinkError r13 = new java.lang.UnsatisfiedLinkError     // Catch:{ all -> 0x0180 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0180 }
            r14.<init>(r5)     // Catch:{ all -> 0x0180 }
            r14.append(r12)     // Catch:{ all -> 0x0180 }
            java.lang.String r12 = r14.toString()     // Catch:{ all -> 0x0180 }
            r13.<init>(r12)     // Catch:{ all -> 0x0180 }
            throw r13     // Catch:{ all -> 0x0180 }
        L_0x0180:
            r12 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock r13 = sSoSourcesLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r13 = r13.readLock()
            r13.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.soloader.SoLoader.doLoadLibraryBySoName(java.lang.String, int, android.os.StrictMode$ThreadPolicy):void");
    }

    @Nullable
    public static String makeNonZipPath(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        ArrayList arrayList = new ArrayList(split.length);
        for (String str2 : split) {
            if (!str2.contains("!")) {
                arrayList.add(str2);
            }
        }
        return TextUtils.join(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, arrayList);
    }

    static File unpackLibraryBySoName(String str) throws IOException {
        sSoSourcesLock.readLock().lock();
        try {
            for (SoSource unpackLibrary : sSoSources) {
                File unpackLibrary2 = unpackLibrary.unpackLibrary(str);
                if (unpackLibrary2 != null) {
                    return unpackLibrary2;
                }
            }
            sSoSourcesLock.readLock().unlock();
            throw new FileNotFoundException(str);
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    private static void assertInitialized() {
        if (!isInitialized()) {
            throw new IllegalStateException("SoLoader.init() not yet called");
        }
    }

    public static boolean isInitialized() {
        boolean z = true;
        if (sSoSources != null) {
            return true;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources == null) {
                z = false;
            }
            reentrantReadWriteLock.readLock().unlock();
            return z;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static int getSoSourcesVersion() {
        return sSoSourcesVersion.get();
    }

    public static void prependSoSource(SoSource soSource) throws IOException {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            assertInitialized();
            soSource.prepare(makePrepareFlags());
            SoSource[] soSourceArr = new SoSource[(sSoSources.length + 1)];
            soSourceArr[0] = soSource;
            System.arraycopy(sSoSources, 0, soSourceArr, 1, sSoSources.length);
            sSoSources = soSourceArr;
            sSoSourcesVersion.getAndIncrement();
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Prepended to SO sources: " + soSource);
            }
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            sSoSourcesLock.writeLock().unlock();
            throw th;
        }
    }

    public static String makeLdLibraryPath() {
        sSoSourcesLock.readLock().lock();
        try {
            assertInitialized();
            ArrayList arrayList = new ArrayList();
            SoSource[] soSourceArr = sSoSources;
            if (soSourceArr != null) {
                for (SoSource addToLdLibraryPath : soSourceArr) {
                    addToLdLibraryPath.addToLdLibraryPath(arrayList);
                }
            }
            String join = TextUtils.join(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR, arrayList);
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "makeLdLibraryPath final path: " + join);
            }
            return join;
        } finally {
            sSoSourcesLock.readLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public static boolean areSoSourcesAbisSupported() {
        ReentrantReadWriteLock reentrantReadWriteLock = sSoSourcesLock;
        reentrantReadWriteLock.readLock().lock();
        try {
            if (sSoSources != null) {
                String[] supportedAbis = SysUtil.getSupportedAbis();
                for (SoSource soSourceAbis : sSoSources) {
                    String[] soSourceAbis2 = soSourceAbis.getSoSourceAbis();
                    int length = soSourceAbis2.length;
                    int i = 0;
                    while (i < length) {
                        String str = soSourceAbis2[i];
                        boolean z = false;
                        for (int i2 = 0; i2 < supportedAbis.length && !z; i2++) {
                            z = str.equals(supportedAbis[i2]);
                        }
                        if (!z) {
                            Log.e(TAG, "abi not supported: " + str);
                            reentrantReadWriteLock = sSoSourcesLock;
                        } else {
                            i++;
                        }
                    }
                }
                sSoSourcesLock.readLock().unlock();
                return true;
            }
            reentrantReadWriteLock.readLock().unlock();
            return false;
        } catch (Throwable th) {
            sSoSourcesLock.readLock().unlock();
            throw th;
        }
    }

    public static boolean useDepsFile(Context context, boolean z, boolean z2) {
        return NativeDeps.useDepsFile(context, z, z2);
    }

    public static int getLoadedLibrariesCount() {
        return sLoadedLibraries.size();
    }
}
