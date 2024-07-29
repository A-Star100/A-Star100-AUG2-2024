package com.facebook.react.internal.turbomodule.core;

import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.CxxModuleWrapper;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.internal.turbomodule.core.TurboModuleInteropUtils;
import com.facebook.react.internal.turbomodule.core.interfaces.TurboModuleRegistry;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.NativeMethodCallInvokerHolder;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TurboModuleManager implements TurboModuleRegistry {
    private final TurboModuleManagerDelegate mDelegate;
    private final List<String> mEagerInitModuleNames;
    private final HybridData mHybridData;
    private final ModuleProvider mLegacyModuleProvider;
    private final Object mModuleCleanupLock = new Object();
    private boolean mModuleCleanupStarted = false;
    private final Map<String, ModuleHolder> mModuleHolders = new HashMap();
    private final ModuleProvider mTurboModuleProvider;

    private interface ModuleProvider {
        NativeModule getModule(String str);
    }

    private native HybridData initHybrid(RuntimeExecutor runtimeExecutor, CallInvokerHolderImpl callInvokerHolderImpl, NativeMethodCallInvokerHolderImpl nativeMethodCallInvokerHolderImpl, TurboModuleManagerDelegate turboModuleManagerDelegate);

    private native void installJSIBindings(boolean z, boolean z2);

    static /* synthetic */ NativeModule lambda$new$0(String str) {
        return null;
    }

    public List<String> getEagerInitModuleNames() {
        return this.mEagerInitModuleNames;
    }

    static {
        NativeModuleSoLoader.maybeLoadSoLibrary();
    }

    public TurboModuleManager(RuntimeExecutor runtimeExecutor, TurboModuleManagerDelegate turboModuleManagerDelegate, CallInvokerHolder callInvokerHolder, NativeMethodCallInvokerHolder nativeMethodCallInvokerHolder) {
        ModuleProvider moduleProvider;
        this.mDelegate = turboModuleManagerDelegate;
        this.mHybridData = initHybrid(runtimeExecutor, (CallInvokerHolderImpl) callInvokerHolder, (NativeMethodCallInvokerHolderImpl) nativeMethodCallInvokerHolder, turboModuleManagerDelegate);
        installJSIBindings(shouldEnableLegacyModuleInterop(), enableSyncVoidMethods());
        this.mEagerInitModuleNames = turboModuleManagerDelegate == null ? new ArrayList<>() : turboModuleManagerDelegate.getEagerInitModuleNames();
        ModuleProvider turboModuleManager$$ExternalSyntheticLambda0 = new TurboModuleManager$$ExternalSyntheticLambda0();
        if (turboModuleManagerDelegate == null) {
            moduleProvider = turboModuleManager$$ExternalSyntheticLambda0;
        } else {
            moduleProvider = new TurboModuleManager$$ExternalSyntheticLambda1(turboModuleManagerDelegate);
        }
        this.mTurboModuleProvider = moduleProvider;
        if (turboModuleManagerDelegate != null && shouldEnableLegacyModuleInterop()) {
            turboModuleManager$$ExternalSyntheticLambda0 = new TurboModuleManager$$ExternalSyntheticLambda2(turboModuleManagerDelegate);
        }
        this.mLegacyModuleProvider = turboModuleManager$$ExternalSyntheticLambda0;
    }

    static /* synthetic */ NativeModule lambda$new$1(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        return (NativeModule) turboModuleManagerDelegate.getModule(str);
    }

    static /* synthetic */ NativeModule lambda$new$2(TurboModuleManagerDelegate turboModuleManagerDelegate, String str) {
        NativeModule legacyModule = turboModuleManagerDelegate.getLegacyModule(str);
        if (legacyModule == null) {
            return null;
        }
        Assertions.assertCondition(!(legacyModule instanceof TurboModule), "NativeModule \"" + str + "\" is a TurboModule");
        return legacyModule;
    }

    private boolean isTurboModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_isModuleRegistered(str);
    }

    private boolean isLegacyModule(String str) {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_isLegacyModuleRegistered(str);
    }

    private boolean shouldEnableLegacyModuleInterop() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_shouldEnableLegacyModuleInterop();
    }

    private boolean shouldRouteTurboModulesThroughLegacyModuleInterop() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_shouldRouteTurboModulesThroughLegacyModuleInterop();
    }

    private boolean enableSyncVoidMethods() {
        TurboModuleManagerDelegate turboModuleManagerDelegate = this.mDelegate;
        return turboModuleManagerDelegate != null && turboModuleManagerDelegate.unstable_enableSyncVoidMethods();
    }

    private static List<TurboModuleInteropUtils.MethodDescriptor> getMethodDescriptorsFromModule(NativeModule nativeModule) {
        return TurboModuleInteropUtils.getMethodDescriptorsFromModule(nativeModule);
    }

    private NativeModule getLegacyJavaModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            NativeModule module = getModule(str);
            if (!(module instanceof CxxModuleWrapper)) {
                return module;
            }
            return null;
        } else if (!isLegacyModule(str)) {
            return null;
        } else {
            NativeModule module2 = getModule(str);
            if ((module2 instanceof CxxModuleWrapper) || (module2 instanceof TurboModule)) {
                return null;
            }
            return module2;
        }
    }

    private CxxModuleWrapper getLegacyCxxModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            NativeModule module = getModule(str);
            if (module instanceof CxxModuleWrapper) {
                return (CxxModuleWrapper) module;
            }
            return null;
        } else if (!isLegacyModule(str)) {
            return null;
        } else {
            NativeModule module2 = getModule(str);
            if (!(module2 instanceof CxxModuleWrapper) || (module2 instanceof TurboModule)) {
                return null;
            }
            return (CxxModuleWrapper) module2;
        }
    }

    private CxxModuleWrapper getTurboLegacyCxxModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop() || !isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if (!(module instanceof CxxModuleWrapper) || !(module instanceof TurboModule)) {
            return null;
        }
        return (CxxModuleWrapper) module;
    }

    private TurboModule getTurboJavaModule(String str) {
        if (shouldRouteTurboModulesThroughLegacyModuleInterop() || !isTurboModule(str)) {
            return null;
        }
        NativeModule module = getModule(str);
        if ((module instanceof CxxModuleWrapper) || !(module instanceof TurboModule)) {
            return null;
        }
        return (TurboModule) module;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateStart(r4, r0.getModuleId());
        r1 = getOrCreateModule(r4, r0, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005f, code lost:
        if (r1 == null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0061, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateEnd(r4, r0.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateFail(r4, r0.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.react.bridge.NativeModule getModule(java.lang.String r4) {
        /*
            r3 = this;
            java.lang.String r0 = "getModule(): Tried to get module \""
            java.lang.Object r1 = r3.mModuleCleanupLock
            monitor-enter(r1)
            boolean r2 = r3.mModuleCleanupStarted     // Catch:{ all -> 0x0071 }
            if (r2 == 0) goto L_0x0038
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0071 }
            r2.<init>(r0)     // Catch:{ all -> 0x0071 }
            r2.append(r4)     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = "\", but TurboModuleManager was tearing down. Returning null. Was legacy: "
            r2.append(r0)     // Catch:{ all -> 0x0071 }
            boolean r0 = r3.isLegacyModule(r4)     // Catch:{ all -> 0x0071 }
            r2.append(r0)     // Catch:{ all -> 0x0071 }
            java.lang.String r0 = ". Was turbo: "
            r2.append(r0)     // Catch:{ all -> 0x0071 }
            boolean r4 = r3.isTurboModule(r4)     // Catch:{ all -> 0x0071 }
            r2.append(r4)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = "."
            r2.append(r4)     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = r2.toString()     // Catch:{ all -> 0x0071 }
            r3.logError(r4)     // Catch:{ all -> 0x0071 }
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            r4 = 0
            return r4
        L_0x0038:
            java.util.Map<java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder> r0 = r3.mModuleHolders     // Catch:{ all -> 0x0071 }
            boolean r0 = r0.containsKey(r4)     // Catch:{ all -> 0x0071 }
            if (r0 != 0) goto L_0x004a
            java.util.Map<java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder> r0 = r3.mModuleHolders     // Catch:{ all -> 0x0071 }
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder r2 = new com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder     // Catch:{ all -> 0x0071 }
            r2.<init>()     // Catch:{ all -> 0x0071 }
            r0.put(r4, r2)     // Catch:{ all -> 0x0071 }
        L_0x004a:
            java.util.Map<java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder> r0 = r3.mModuleHolders     // Catch:{ all -> 0x0071 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0071 }
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder r0 = (com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleHolder) r0     // Catch:{ all -> 0x0071 }
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            int r1 = r0.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateStart(r4, r1)
            r1 = 1
            com.facebook.react.bridge.NativeModule r1 = r3.getOrCreateModule(r4, r0, r1)
            if (r1 == 0) goto L_0x0069
            int r0 = r0.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateEnd(r4, r0)
            goto L_0x0070
        L_0x0069:
            int r0 = r0.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateFail(r4, r0)
        L_0x0070:
            return r1
        L_0x0071:
            r4 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0071 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.internal.turbomodule.core.TurboModuleManager.getModule(java.lang.String):com.facebook.react.bridge.NativeModule");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (r5 == false) goto L_0x0099;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0027, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructStart(r3, r4.getModuleId());
        r5 = r2.mTurboModuleProvider.getModule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r5 != null) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r5 = r2.mLegacyModuleProvider.getModule(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructEnd(r3, r4.getModuleId());
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpStart(r3, r4.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004a, code lost:
        if (r5 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004c, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r4.setModule(r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0050, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r5.initialize();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0058, code lost:
        logError("getOrCreateModule(): Unable to create module \"" + r3 + "\". Was legacy: " + isLegacyModule(r3) + ". Was turbo: " + isTurboModule(r3) + ".");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0086, code lost:
        com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpEnd(r3, r4.getModuleId());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x008d, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
        r4.endCreatingModule();
        r4.notifyAll();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0095, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x009e, code lost:
        if (r4.isCreatingModule() == false) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        r4.wait();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00a4, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00a6, code lost:
        if (r1 == false) goto L_0x00af;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        java.lang.Thread.currentThread().interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00af, code lost:
        r3 = r4.getModule();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00b3, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b4, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.facebook.react.bridge.NativeModule getOrCreateModule(java.lang.String r3, com.facebook.react.internal.turbomodule.core.TurboModuleManager.ModuleHolder r4, boolean r5) {
        /*
            r2 = this;
            monitor-enter(r4)
            boolean r0 = r4.isDoneCreatingModule()     // Catch:{ all -> 0x00b8 }
            if (r0 == 0) goto L_0x0016
            if (r5 == 0) goto L_0x0010
            int r5 = r4.getModuleId()     // Catch:{ all -> 0x00b8 }
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateCacheHit(r3, r5)     // Catch:{ all -> 0x00b8 }
        L_0x0010:
            com.facebook.react.bridge.NativeModule r3 = r4.getModule()     // Catch:{ all -> 0x00b8 }
            monitor-exit(r4)     // Catch:{ all -> 0x00b8 }
            return r3
        L_0x0016:
            boolean r5 = r4.isCreatingModule()     // Catch:{ all -> 0x00b8 }
            r0 = 1
            r1 = 0
            if (r5 != 0) goto L_0x0023
            r4.startCreatingModule()     // Catch:{ all -> 0x00b8 }
            r5 = r0
            goto L_0x0024
        L_0x0023:
            r5 = r1
        L_0x0024:
            monitor-exit(r4)     // Catch:{ all -> 0x00b8 }
            if (r5 == 0) goto L_0x0099
            int r5 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructStart(r3, r5)
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleProvider r5 = r2.mTurboModuleProvider
            com.facebook.react.bridge.NativeModule r5 = r5.getModule(r3)
            if (r5 != 0) goto L_0x003c
            com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleProvider r5 = r2.mLegacyModuleProvider
            com.facebook.react.bridge.NativeModule r5 = r5.getModule(r3)
        L_0x003c:
            int r0 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateConstructEnd(r3, r0)
            int r0 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpStart(r3, r0)
            if (r5 == 0) goto L_0x0058
            monitor-enter(r4)
            r4.setModule(r5)     // Catch:{ all -> 0x0055 }
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            r5.initialize()
            goto L_0x0086
        L_0x0055:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0055 }
            throw r3
        L_0x0058:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "getOrCreateModule(): Unable to create module \""
            r0.<init>(r1)
            r0.append(r3)
            java.lang.String r1 = "\". Was legacy: "
            r0.append(r1)
            boolean r1 = r2.isLegacyModule(r3)
            r0.append(r1)
            java.lang.String r1 = ". Was turbo: "
            r0.append(r1)
            boolean r1 = r2.isTurboModule(r3)
            r0.append(r1)
            java.lang.String r1 = "."
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r2.logError(r0)
        L_0x0086:
            int r0 = r4.getModuleId()
            com.facebook.react.internal.turbomodule.core.TurboModulePerfLogger.moduleCreateSetUpEnd(r3, r0)
            monitor-enter(r4)
            r4.endCreatingModule()     // Catch:{ all -> 0x0096 }
            r4.notifyAll()     // Catch:{ all -> 0x0096 }
            monitor-exit(r4)     // Catch:{ all -> 0x0096 }
            return r5
        L_0x0096:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0096 }
            throw r3
        L_0x0099:
            monitor-enter(r4)
        L_0x009a:
            boolean r3 = r4.isCreatingModule()     // Catch:{ all -> 0x00b5 }
            if (r3 == 0) goto L_0x00a6
            r4.wait()     // Catch:{ InterruptedException -> 0x00a4 }
            goto L_0x009a
        L_0x00a4:
            r1 = r0
            goto L_0x009a
        L_0x00a6:
            if (r1 == 0) goto L_0x00af
            java.lang.Thread r3 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x00b5 }
            r3.interrupt()     // Catch:{ all -> 0x00b5 }
        L_0x00af:
            com.facebook.react.bridge.NativeModule r3 = r4.getModule()     // Catch:{ all -> 0x00b5 }
            monitor-exit(r4)     // Catch:{ all -> 0x00b5 }
            return r3
        L_0x00b5:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b5 }
            throw r3
        L_0x00b8:
            r3 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b8 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.internal.turbomodule.core.TurboModuleManager.getOrCreateModule(java.lang.String, com.facebook.react.internal.turbomodule.core.TurboModuleManager$ModuleHolder, boolean):com.facebook.react.bridge.NativeModule");
    }

    public Collection<NativeModule> getModules() {
        ArrayList<ModuleHolder> arrayList = new ArrayList<>();
        synchronized (this.mModuleCleanupLock) {
            arrayList.addAll(this.mModuleHolders.values());
        }
        ArrayList arrayList2 = new ArrayList();
        for (ModuleHolder moduleHolder : arrayList) {
            synchronized (moduleHolder) {
                if (moduleHolder.getModule() != null) {
                    arrayList2.add(moduleHolder.getModule());
                }
            }
        }
        return arrayList2;
    }

    public boolean hasModule(String str) {
        ModuleHolder moduleHolder;
        synchronized (this.mModuleCleanupLock) {
            moduleHolder = this.mModuleHolders.get(str);
        }
        if (moduleHolder == null) {
            return false;
        }
        synchronized (moduleHolder) {
            if (moduleHolder.getModule() != null) {
                return true;
            }
            return false;
        }
    }

    private void logError(String str) {
        FLog.e("TurboModuleManager", str);
        if (shouldRouteTurboModulesThroughLegacyModuleInterop()) {
            ReactSoftExceptionLogger.logSoftException("TurboModuleManager", new ReactNoCrashSoftException(str));
        }
    }

    public void invalidate() {
        synchronized (this.mModuleCleanupLock) {
            this.mModuleCleanupStarted = true;
        }
        for (Map.Entry next : this.mModuleHolders.entrySet()) {
            NativeModule orCreateModule = getOrCreateModule((String) next.getKey(), (ModuleHolder) next.getValue(), false);
            if (orCreateModule != null) {
                orCreateModule.invalidate();
            }
        }
        this.mModuleHolders.clear();
        this.mHybridData.resetNative();
    }

    private static class ModuleHolder {
        private static volatile int sHolderCount;
        private volatile boolean mIsDoneCreatingModule = false;
        private volatile boolean mIsTryingToCreate = false;
        private volatile NativeModule mModule = null;
        private volatile int mModuleId = sHolderCount;

        /* access modifiers changed from: package-private */
        public void endCreatingModule() {
            this.mIsTryingToCreate = false;
            this.mIsDoneCreatingModule = true;
        }

        /* access modifiers changed from: package-private */
        public NativeModule getModule() {
            return this.mModule;
        }

        /* access modifiers changed from: package-private */
        public int getModuleId() {
            return this.mModuleId;
        }

        /* access modifiers changed from: package-private */
        public boolean isCreatingModule() {
            return this.mIsTryingToCreate;
        }

        /* access modifiers changed from: package-private */
        public boolean isDoneCreatingModule() {
            return this.mIsDoneCreatingModule;
        }

        /* access modifiers changed from: package-private */
        public void setModule(NativeModule nativeModule) {
            this.mModule = nativeModule;
        }

        /* access modifiers changed from: package-private */
        public void startCreatingModule() {
            this.mIsTryingToCreate = true;
        }

        public ModuleHolder() {
            sHolderCount++;
        }
    }
}
