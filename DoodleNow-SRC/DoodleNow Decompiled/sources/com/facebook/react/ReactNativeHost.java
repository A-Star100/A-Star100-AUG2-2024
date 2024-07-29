package com.facebook.react;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.interfaces.DevLoadingViewManager;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.internal.ChoreographerProvider;
import java.util.List;

public abstract class ReactNativeHost {
    private final Application mApplication;
    private ReactInstanceManager mReactInstanceManager;

    static /* synthetic */ UIManager lambda$getUIManagerProvider$0(ReactApplicationContext reactApplicationContext) {
        return null;
    }

    /* access modifiers changed from: protected */
    public final Application getApplication() {
        return this.mApplication;
    }

    /* access modifiers changed from: protected */
    public String getBundleAssetName() {
        return "index.android.bundle";
    }

    /* access modifiers changed from: protected */
    public ChoreographerProvider getChoreographerProvider() {
        return null;
    }

    /* access modifiers changed from: protected */
    public DevLoadingViewManager getDevLoadingViewManager() {
        return null;
    }

    /* access modifiers changed from: protected */
    public DevSupportManagerFactory getDevSupportManagerFactory() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getJSBundleFile() {
        return null;
    }

    /* access modifiers changed from: protected */
    public JSEngineResolutionAlgorithm getJSEngineResolutionAlgorithm() {
        return null;
    }

    /* access modifiers changed from: protected */
    public String getJSMainModuleName() {
        return "index.android";
    }

    /* access modifiers changed from: protected */
    public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        return null;
    }

    public boolean getLazyViewManagersEnabled() {
        return false;
    }

    /* access modifiers changed from: protected */
    public abstract List<ReactPackage> getPackages();

    /* access modifiers changed from: protected */
    public ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        return null;
    }

    /* access modifiers changed from: protected */
    public RedBoxHandler getRedBoxHandler() {
        return null;
    }

    public boolean getShouldRequireActivity() {
        return true;
    }

    public abstract boolean getUseDeveloperSupport();

    public boolean hasInstance() {
        return this.mReactInstanceManager != null;
    }

    protected ReactNativeHost(Application application) {
        this.mApplication = application;
    }

    public ReactInstanceManager getReactInstanceManager() {
        if (this.mReactInstanceManager == null) {
            ReactMarker.logMarker(ReactMarkerConstants.INIT_REACT_RUNTIME_START);
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
            this.mReactInstanceManager = createReactInstanceManager();
            ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
        }
        return this.mReactInstanceManager;
    }

    public void clear() {
        ReactInstanceManager reactInstanceManager = this.mReactInstanceManager;
        if (reactInstanceManager != null) {
            reactInstanceManager.destroy();
            this.mReactInstanceManager = null;
        }
    }

    /* access modifiers changed from: protected */
    public ReactInstanceManager createReactInstanceManager() {
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
        ReactInstanceManagerBuilder choreographerProvider = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setDevSupportManagerFactory(getDevSupportManagerFactory()).setDevLoadingViewManager(getDevLoadingViewManager()).setRequireActivity(getShouldRequireActivity()).setSurfaceDelegateFactory(getSurfaceDelegateFactory()).setLazyViewManagersEnabled(getLazyViewManagersEnabled()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setUIManagerProvider(getUIManagerProvider()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE).setReactPackageTurboModuleManagerDelegateBuilder(getReactPackageTurboModuleManagerDelegateBuilder()).setJSEngineResolutionAlgorithm(getJSEngineResolutionAlgorithm()).setChoreographerProvider(getChoreographerProvider());
        for (ReactPackage addPackage : getPackages()) {
            choreographerProvider.addPackage(addPackage);
        }
        String jSBundleFile = getJSBundleFile();
        if (jSBundleFile != null) {
            choreographerProvider.setJSBundleFile(jSBundleFile);
        } else {
            choreographerProvider.setBundleAssetName((String) Assertions.assertNotNull(getBundleAssetName()));
        }
        ReactInstanceManager build = choreographerProvider.build();
        ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
        return build;
    }

    /* access modifiers changed from: protected */
    public UIManagerProvider getUIManagerProvider() {
        return new ReactNativeHost$$ExternalSyntheticLambda0();
    }

    public SurfaceDelegateFactory getSurfaceDelegateFactory() {
        return new SurfaceDelegateFactory() {
            public SurfaceDelegate createSurfaceDelegate(String str) {
                return null;
            }
        };
    }
}
