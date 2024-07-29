package com.facebook.react.runtime;

import android.content.res.AssetManager;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.logging.FLog;
import com.facebook.jni.HybridData;
import com.facebook.react.DebugCorePackage;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.ViewManagerOnDemandReactPackage;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSBundleLoaderDelegate;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.NativeArray;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactNoCrashSoftException;
import com.facebook.react.bridge.ReactSoftExceptionLogger;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.RuntimeScheduler;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.MessageQueueThreadSpec;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.fabric.BindingImpl;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.fabric.events.EventBeatManager;
import com.facebook.react.interfaces.exceptionmanager.ReactJsExceptionHandler;
import com.facebook.react.internal.AndroidChoreographerProvider;
import com.facebook.react.internal.turbomodule.core.TurboModuleManager;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.JavaTimerManager;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.NativeMethodCallInvokerHolderImpl;
import com.facebook.react.uimanager.ComponentNameResolverManager;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.UIConstantsProviderManager;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.ViewManagerResolver;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

final class ReactInstance {
    private static final String TAG = "ReactInstance";
    private static volatile boolean sIsLibraryLoaded;
    /* access modifiers changed from: private */
    public final BridgelessReactContext mBridgelessReactContext;
    @Nullable
    private ComponentNameResolverManager mComponentNameResolverManager;
    private final ReactHostDelegate mDelegate;
    private final FabricUIManager mFabricUIManager;
    private final HybridData mHybridData;
    private JavaScriptContextHolder mJavaScriptContextHolder;
    /* access modifiers changed from: private */
    public final JavaTimerManager mJavaTimerManager;
    private final ReactQueueConfiguration mQueueConfiguration;
    private final List<ReactPackage> mReactPackages;
    private final TurboModuleManager mTurboModuleManager;
    @Nullable
    private UIConstantsProviderManager mUIConstantsProviderManager;
    private final BridgelessViewManagerResolver mViewManagerResolver;

    private static native JSTimerExecutor createJSTimerExecutor();

    private native long getJavaScriptContext();

    private native NativeMethodCallInvokerHolderImpl getNativeMethodCallInvokerHolder();

    private native RuntimeScheduler getRuntimeScheduler();

    private native RuntimeExecutor getUnbufferedRuntimeExecutor();

    private native void handleMemoryPressureJs(int i);

    private native HybridData initHybrid(JSRuntimeFactory jSRuntimeFactory, MessageQueueThread messageQueueThread, MessageQueueThread messageQueueThread2, JavaTimerManager javaTimerManager, JSTimerExecutor jSTimerExecutor, ReactJsExceptionHandler reactJsExceptionHandler, @Nullable BindingsInstaller bindingsInstaller, boolean z);

    private native void installGlobals(boolean z);

    /* access modifiers changed from: private */
    public native void loadJSBundleFromAssets(AssetManager assetManager, String str);

    /* access modifiers changed from: private */
    public native void loadJSBundleFromFile(String str, String str2);

    private native void registerSegmentNative(int i, String str);

    /* access modifiers changed from: package-private */
    public native void callFunctionOnModule(String str, String str2, NativeArray nativeArray);

    /* access modifiers changed from: package-private */
    public native RuntimeExecutor getBufferedRuntimeExecutor();

    /* access modifiers changed from: package-private */
    public native CallInvokerHolderImpl getJSCallInvokerHolder();

    /* access modifiers changed from: package-private */
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mJavaScriptContextHolder;
    }

    public ReactQueueConfiguration getReactQueueConfiguration() {
        return this.mQueueConfiguration;
    }

    /* access modifiers changed from: package-private */
    public FabricUIManager getUIManager() {
        return this.mFabricUIManager;
    }

    static {
        loadLibraryIfNeeded();
    }

    ReactInstance(BridgelessReactContext bridgelessReactContext, ReactHostDelegate reactHostDelegate, ComponentFactory componentFactory, DevSupportManager devSupportManager, QueueThreadExceptionHandler queueThreadExceptionHandler, ReactJsExceptionHandler reactJsExceptionHandler, boolean z) {
        BridgelessReactContext bridgelessReactContext2 = bridgelessReactContext;
        this.mBridgelessReactContext = bridgelessReactContext2;
        this.mDelegate = reactHostDelegate;
        Systrace.beginSection(0, "ReactInstance.initialize");
        ReactQueueConfigurationImpl create = ReactQueueConfigurationImpl.create(ReactQueueConfigurationSpec.builder().setJSQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("v_js")).setNativeModulesQueueThreadSpec(MessageQueueThreadSpec.newBackgroundThreadSpec("v_native")).build(), queueThreadExceptionHandler);
        this.mQueueConfiguration = create;
        FLog.d(TAG, "Calling initializeMessageQueueThreads()");
        bridgelessReactContext2.initializeMessageQueueThreads(create);
        MessageQueueThread jSQueueThread = create.getJSQueueThread();
        MessageQueueThread nativeModulesQueueThread = create.getNativeModulesQueueThread();
        ReactChoreographer.initialize(AndroidChoreographerProvider.getInstance());
        if (z) {
            devSupportManager.startInspector();
        }
        JSTimerExecutor createJSTimerExecutor = createJSTimerExecutor();
        JavaTimerManager javaTimerManager = new JavaTimerManager(bridgelessReactContext2, createJSTimerExecutor, ReactChoreographer.getInstance(), devSupportManager);
        this.mJavaTimerManager = javaTimerManager;
        bridgelessReactContext2.addLifecycleEventListener(new LifecycleEventListener() {
            public void onHostResume() {
                ReactInstance.this.mJavaTimerManager.onHostResume();
            }

            public void onHostPause() {
                ReactInstance.this.mJavaTimerManager.onHostPause();
            }

            public void onHostDestroy() {
                ReactInstance.this.mJavaTimerManager.onHostDestroy();
            }
        });
        this.mHybridData = initHybrid(reactHostDelegate.getJsRuntimeFactory(), jSQueueThread, nativeModulesQueueThread, javaTimerManager, createJSTimerExecutor, reactJsExceptionHandler, reactHostDelegate.getBindingsInstaller(), Systrace.isTracing(0));
        this.mJavaScriptContextHolder = new JavaScriptContextHolder(getJavaScriptContext());
        Systrace.beginSection(0, "ReactInstance.initialize#initTurboModules");
        ArrayList arrayList = new ArrayList();
        this.mReactPackages = arrayList;
        arrayList.add(new CoreReactPackage(bridgelessReactContext.getDevSupportManager(), bridgelessReactContext.getDefaultHardwareBackBtnHandler()));
        if (z) {
            arrayList.add(new DebugCorePackage());
        }
        arrayList.addAll(reactHostDelegate.getReactPackages());
        ReactPackageTurboModuleManagerDelegate build = reactHostDelegate.getTurboModuleManagerDelegateBuilder().setPackages(arrayList).setReactApplicationContext(bridgelessReactContext2).build();
        RuntimeExecutor unbufferedRuntimeExecutor = getUnbufferedRuntimeExecutor();
        TurboModuleManager turboModuleManager = new TurboModuleManager(unbufferedRuntimeExecutor, build, getJSCallInvokerHolder(), getNativeMethodCallInvokerHolder());
        this.mTurboModuleManager = turboModuleManager;
        for (String module : turboModuleManager.getEagerInitModuleNames()) {
            this.mTurboModuleManager.getModule(module);
        }
        Systrace.endSection(0);
        Systrace.beginSection(0, "ReactInstance.initialize#initFabric");
        BridgelessViewManagerResolver bridgelessViewManagerResolver = new BridgelessViewManagerResolver(this.mReactPackages, this.mBridgelessReactContext);
        this.mViewManagerResolver = bridgelessViewManagerResolver;
        this.mComponentNameResolverManager = new ComponentNameResolverManager(unbufferedRuntimeExecutor, new ReactInstance$$ExternalSyntheticLambda0(this));
        if (ReactFeatureFlags.useNativeViewConfigsInBridgelessMode) {
            HashMap hashMap = new HashMap();
            this.mUIConstantsProviderManager = new UIConstantsProviderManager(unbufferedRuntimeExecutor, new ReactInstance$$ExternalSyntheticLambda1(), new ReactInstance$$ExternalSyntheticLambda2(this, hashMap), new ReactInstance$$ExternalSyntheticLambda3(this, hashMap));
        }
        EventBeatManager eventBeatManager = new EventBeatManager();
        FabricUIManager fabricUIManager = new FabricUIManager(this.mBridgelessReactContext, new ViewManagerRegistry((ViewManagerResolver) bridgelessViewManagerResolver), eventBeatManager);
        this.mFabricUIManager = fabricUIManager;
        ReactNativeConfig reactNativeConfig = this.mDelegate.getReactNativeConfig();
        DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(this.mBridgelessReactContext);
        new BindingImpl().register(getBufferedRuntimeExecutor(), getRuntimeScheduler(), fabricUIManager, eventBeatManager, componentFactory, reactNativeConfig);
        Systrace.endSection(0);
        fabricUIManager.initialize();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String[] lambda$new$0() {
        Collection<String> viewManagerNames = this.mViewManagerResolver.getViewManagerNames();
        if (viewManagerNames.size() >= 1) {
            return (String[]) viewManagerNames.toArray(new String[0]);
        }
        FLog.e(TAG, "No ViewManager names found");
        return new String[0];
    }

    /* access modifiers changed from: private */
    public /* synthetic */ NativeMap lambda$new$2(Map map, String str) {
        ViewManager viewManager = this.mViewManagerResolver.getViewManager(str);
        if (viewManager == null) {
            return null;
        }
        return (NativeMap) UIManagerModule.getConstantsForViewManager(viewManager, map);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ NativeMap lambda$new$3(Map map) {
        Map<String, Object> createConstants = UIManagerModule.createConstants(new ArrayList(this.mViewManagerResolver.getEagerViewManagerMap().values()), (Map<String, Object>) null, map);
        Collection<String> lazyViewManagerNames = this.mViewManagerResolver.getLazyViewManagerNames();
        if (lazyViewManagerNames.size() > 0) {
            createConstants.put("ViewManagerNames", new ArrayList(lazyViewManagerNames));
            createConstants.put("LazyViewManagersEnabled", true);
        }
        return Arguments.makeNativeMap(createConstants);
    }

    private static synchronized void loadLibraryIfNeeded() {
        synchronized (ReactInstance.class) {
            if (!sIsLibraryLoaded) {
                SoLoader.loadLibrary("rninstance");
                sIsLibraryLoaded = true;
            }
        }
    }

    public void loadJSBundle(JSBundleLoader jSBundleLoader) {
        Systrace.beginSection(0, "ReactInstance.loadJSBundle");
        jSBundleLoader.loadScript(new JSBundleLoaderDelegate() {
            public void loadScriptFromFile(String str, String str2, boolean z) {
                ReactInstance.this.mBridgelessReactContext.setSourceURL(str2);
                ReactInstance.this.loadJSBundleFromFile(str, str2);
            }

            public void loadSplitBundleFromFile(String str, String str2) {
                ReactInstance.this.loadJSBundleFromFile(str, str2);
            }

            public void loadScriptFromAssets(AssetManager assetManager, String str, boolean z) {
                ReactInstance.this.mBridgelessReactContext.setSourceURL(str);
                ReactInstance.this.loadJSBundleFromAssets(assetManager, str);
            }

            public void setSourceURLs(String str, String str2) {
                ReactInstance.this.mBridgelessReactContext.setSourceURL(str);
            }
        });
        Systrace.endSection(0);
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
        if (reactModule != null) {
            return this.mTurboModuleManager.hasModule(reactModule.name());
        }
        return false;
    }

    public Collection<NativeModule> getNativeModules() {
        return new ArrayList(this.mTurboModuleManager.getModules());
    }

    @Nullable
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        ReactModule reactModule = (ReactModule) cls.getAnnotation(ReactModule.class);
        if (reactModule != null) {
            return getNativeModule(reactModule.name());
        }
        return null;
    }

    @Nullable
    public NativeModule getNativeModule(String str) {
        NativeModule module;
        synchronized (this.mTurboModuleManager) {
            module = this.mTurboModuleManager.getModule(str);
        }
        return module;
    }

    /* access modifiers changed from: package-private */
    public void prerenderSurface(ReactSurfaceImpl reactSurfaceImpl) {
        Systrace.beginSection(0, "ReactInstance.prerenderSurface");
        String str = TAG;
        FLog.d(str, "call prerenderSurface with surface: " + reactSurfaceImpl.getModuleName());
        this.mFabricUIManager.startSurface(reactSurfaceImpl.getSurfaceHandler(), reactSurfaceImpl.getContext(), (View) null);
        Systrace.endSection(0);
    }

    /* access modifiers changed from: package-private */
    public void startSurface(ReactSurfaceImpl reactSurfaceImpl) {
        String str = TAG;
        FLog.d(str, "startSurface() is called with surface: " + reactSurfaceImpl.getSurfaceID());
        Systrace.beginSection(0, "ReactInstance.startSurface");
        ViewGroup view = reactSurfaceImpl.getView();
        if (view != null) {
            if (view.getId() != -1) {
                ReactSoftExceptionLogger.logSoftException(str, new IllegalViewOperationException("surfaceView's is NOT equal to View.NO_ID before calling startSurface."));
                view.setId(-1);
            }
            if (reactSurfaceImpl.isRunning()) {
                this.mFabricUIManager.attachRootView(reactSurfaceImpl.getSurfaceHandler(), view);
            } else {
                this.mFabricUIManager.startSurface(reactSurfaceImpl.getSurfaceHandler(), reactSurfaceImpl.getContext(), view);
            }
            Systrace.endSection(0);
            return;
        }
        throw new IllegalStateException("Starting surface without a view is not supported, use prerenderSurface instead.");
    }

    /* access modifiers changed from: package-private */
    public void stopSurface(ReactSurfaceImpl reactSurfaceImpl) {
        String str = TAG;
        FLog.d(str, "stopSurface() is called with surface: " + reactSurfaceImpl.getSurfaceID());
        this.mFabricUIManager.stopSurface(reactSurfaceImpl.getSurfaceHandler());
    }

    /* access modifiers changed from: package-private */
    public void destroy() {
        FLog.d(TAG, "ReactInstance.destroy() is called.");
        this.mQueueConfiguration.destroy();
        this.mTurboModuleManager.invalidate();
        this.mFabricUIManager.invalidate();
        this.mHybridData.resetNative();
        this.mComponentNameResolverManager = null;
        this.mUIConstantsProviderManager = null;
        this.mJavaScriptContextHolder.clear();
    }

    public void handleMemoryPressure(int i) {
        try {
            handleMemoryPressureJs(i);
        } catch (NullPointerException unused) {
            ReactSoftExceptionLogger.logSoftException(TAG, new ReactNoCrashSoftException("Native method handleMemoryPressureJs is called earlier than librninstance.so got ready."));
        }
    }

    /* access modifiers changed from: package-private */
    public EventDispatcher getEventDispatcher() {
        return this.mFabricUIManager.getEventDispatcher();
    }

    public void registerSegment(int i, String str) {
        registerSegmentNative(i, str);
    }

    private static class BridgelessViewManagerResolver implements ViewManagerResolver {
        private BridgelessReactContext mBridgelessReactContext;
        @Nullable
        private Map<String, ViewManager> mEagerViewManagerMap = null;
        private Map<String, ViewManager> mLazyViewManagerMap = new HashMap();
        private List<ReactPackage> mReactPackages;

        public BridgelessViewManagerResolver(List<ReactPackage> list, BridgelessReactContext bridgelessReactContext) {
            this.mReactPackages = list;
            this.mBridgelessReactContext = bridgelessReactContext;
        }

        @Nullable
        public synchronized ViewManager getViewManager(String str) {
            ViewManager lazyViewManager = getLazyViewManager(str);
            if (lazyViewManager != null) {
                return lazyViewManager;
            }
            return getEagerViewManagerMap().get(str);
        }

        public synchronized Collection<String> getViewManagerNames() {
            HashSet hashSet;
            hashSet = new HashSet();
            hashSet.addAll(getLazyViewManagerNames());
            hashSet.addAll(getEagerViewManagerMap().keySet());
            return hashSet;
        }

        public synchronized Map<String, ViewManager> getEagerViewManagerMap() {
            Map<String, ViewManager> map = this.mEagerViewManagerMap;
            if (map != null) {
                return map;
            }
            HashMap hashMap = new HashMap();
            for (ReactPackage next : this.mReactPackages) {
                if (!(next instanceof ViewManagerOnDemandReactPackage)) {
                    for (ViewManager next2 : next.createViewManagers(this.mBridgelessReactContext)) {
                        hashMap.put(next2.getName(), next2);
                    }
                }
            }
            this.mEagerViewManagerMap = hashMap;
            return hashMap;
        }

        @Nullable
        private ViewManager getLazyViewManager(String str) {
            ViewManager createViewManager;
            if (this.mLazyViewManagerMap.containsKey(str)) {
                return this.mLazyViewManagerMap.get(str);
            }
            for (ReactPackage next : this.mReactPackages) {
                if ((next instanceof ViewManagerOnDemandReactPackage) && (createViewManager = ((ViewManagerOnDemandReactPackage) next).createViewManager(this.mBridgelessReactContext, str)) != null) {
                    this.mLazyViewManagerMap.put(str, createViewManager);
                    return createViewManager;
                }
            }
            return null;
        }

        public synchronized Collection<String> getLazyViewManagerNames() {
            HashSet hashSet;
            Collection<String> viewManagerNames;
            hashSet = new HashSet();
            for (ReactPackage next : this.mReactPackages) {
                if ((next instanceof ViewManagerOnDemandReactPackage) && (viewManagerNames = ((ViewManagerOnDemandReactPackage) next).getViewManagerNames(this.mBridgelessReactContext)) != null) {
                    hashSet.addAll(viewManagerNames);
                }
            }
            return hashSet;
        }
    }
}
