package com.facebook.react.runtime;

import android.content.Context;
import android.util.Log;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.JavaScriptModuleRegistry;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.common.annotations.FrameworkAPI;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherProvider;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

class BridgelessReactContext extends ReactApplicationContext implements EventDispatcherProvider {
    private final String TAG = getClass().getSimpleName();
    private final ReactHostImpl mReactHost;
    private final AtomicReference<String> mSourceURL = new AtomicReference<>();

    public boolean isBridgeless() {
        return true;
    }

    BridgelessReactContext(Context context, ReactHostImpl reactHostImpl) {
        super(context);
        this.mReactHost = reactHostImpl;
        if (ReactFeatureFlags.unstable_useFabricInterop) {
            initializeInteropModules();
        }
    }

    public EventDispatcher getEventDispatcher() {
        return this.mReactHost.getEventDispatcher();
    }

    public void setSourceURL(String str) {
        this.mSourceURL.set(str);
    }

    @Nullable
    public String getSourceURL() {
        return this.mSourceURL.get();
    }

    @Nullable
    public UIManager getFabricUIManager() {
        return this.mReactHost.getUIManager();
    }

    public CatalystInstance getCatalystInstance() {
        Log.w(this.TAG, "[WARNING] Bridgeless doesn't support CatalystInstance. Accessing an API that's not part of the new architecture is not encouraged usage.");
        return new BridgelessCatalystInstance(this.mReactHost);
    }

    public boolean hasActiveReactInstance() {
        return this.mReactHost.isInstanceInitialized();
    }

    /* access modifiers changed from: package-private */
    public DevSupportManager getDevSupportManager() {
        return this.mReactHost.getDevSupportManager();
    }

    public void registerSegment(int i, String str, Callback callback) {
        this.mReactHost.registerSegment(i, str, callback);
    }

    private static class BridgelessJSModuleInvocationHandler implements InvocationHandler {
        private final Class<? extends JavaScriptModule> mJSModuleInterface;
        private final ReactHostImpl mReactHost;

        public BridgelessJSModuleInvocationHandler(ReactHostImpl reactHostImpl, Class<? extends JavaScriptModule> cls) {
            this.mReactHost = reactHostImpl;
            this.mJSModuleInterface = cls;
        }

        @Nullable
        public Object invoke(Object obj, Method method, @Nullable Object[] objArr) {
            this.mReactHost.callFunctionOnModule(JavaScriptModuleRegistry.getJSModuleName(this.mJSModuleInterface), method.getName(), objArr != null ? Arguments.fromJavaArgs(objArr) : new WritableNativeArray());
            return null;
        }
    }

    public <T extends JavaScriptModule> T getJSModule(Class<T> cls) {
        if (this.mInteropModuleRegistry != null && this.mInteropModuleRegistry.shouldReturnInteropModule(cls)) {
            return this.mInteropModuleRegistry.getInteropModule(cls);
        }
        return (JavaScriptModule) Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new BridgelessJSModuleInvocationHandler(this.mReactHost, cls));
    }

    public <T extends NativeModule> boolean hasNativeModule(Class<T> cls) {
        return this.mReactHost.hasNativeModule(cls);
    }

    public Collection<NativeModule> getNativeModules() {
        return this.mReactHost.getNativeModules();
    }

    @Nullable
    public <T extends NativeModule> T getNativeModule(Class<T> cls) {
        return this.mReactHost.getNativeModule(cls);
    }

    @UnstableReactNativeAPI
    @Nullable
    @FrameworkAPI
    public RuntimeExecutor getRuntimeExecutor() {
        return this.mReactHost.getRuntimeExecutor();
    }

    @UnstableReactNativeAPI
    @Nullable
    @FrameworkAPI
    public JavaScriptContextHolder getJavaScriptContextHolder() {
        return this.mReactHost.getJavaScriptContextHolder();
    }

    public void handleException(Exception exc) {
        this.mReactHost.handleHostException(exc);
    }

    /* access modifiers changed from: package-private */
    public DefaultHardwareBackBtnHandler getDefaultHardwareBackBtnHandler() {
        return this.mReactHost.getDefaultBackButtonHandler();
    }
}
