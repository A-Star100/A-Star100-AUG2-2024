package expo.modules;

import android.content.Context;
import com.facebook.react.JSEngineResolutionAlgorithm;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import com.facebook.react.defaults.DefaultComponentsRegistry;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSCInstance;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostDelegate;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.hermes.HermesInstance;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lexpo/modules/ExpoReactHostFactory;", "", "()V", "reactHost", "Lcom/facebook/react/ReactHost;", "createFromReactNativeHost", "context", "Landroid/content/Context;", "reactNativeHost", "Lcom/facebook/react/ReactNativeHost;", "ExpoReactHostDelegate", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExpoReactHostFactory.kt */
public final class ExpoReactHostFactory {
    public static final ExpoReactHostFactory INSTANCE = new ExpoReactHostFactory();
    private static ReactHost reactHost;

    /* access modifiers changed from: private */
    public static final void createFromReactNativeHost$lambda$1(ReadableMapBuffer readableMapBuffer) {
    }

    private ExpoReactHostFactory() {
    }

    @UnstableReactNativeAPI
    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B;\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\b\u0010$\u001a\u00020\nH\u0016J\u0014\u0010%\u001a\u00020&2\n\u0010'\u001a\u00060(j\u0002`)H\u0016R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u000f8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8VX\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lexpo/modules/ExpoReactHostFactory$ExpoReactHostDelegate;", "Lcom/facebook/react/runtime/ReactHostDelegate;", "weakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "reactNativeHostWrapper", "Lexpo/modules/ReactNativeHostWrapper;", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "reactNativeConfig", "Lcom/facebook/react/fabric/ReactNativeConfig;", "turboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "(Ljava/lang/ref/WeakReference;Lexpo/modules/ReactNativeHostWrapper;Lcom/facebook/react/runtime/BindingsInstaller;Lcom/facebook/react/fabric/ReactNativeConfig;Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;)V", "_jsBundleLoader", "Lcom/facebook/react/bridge/JSBundleLoader;", "getBindingsInstaller", "()Lcom/facebook/react/runtime/BindingsInstaller;", "jsBundleLoader", "getJsBundleLoader", "()Lcom/facebook/react/bridge/JSBundleLoader;", "jsMainModulePath", "", "getJsMainModulePath", "()Ljava/lang/String;", "jsRuntimeFactory", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "getJsRuntimeFactory", "()Lcom/facebook/react/runtime/JSRuntimeFactory;", "reactPackages", "", "Lcom/facebook/react/ReactPackage;", "getReactPackages", "()Ljava/util/List;", "getTurboModuleManagerDelegateBuilder", "()Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "getReactNativeConfig", "handleInstanceException", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ExpoReactHostFactory.kt */
    private static final class ExpoReactHostDelegate implements ReactHostDelegate {
        private JSBundleLoader _jsBundleLoader;
        private final BindingsInstaller bindingsInstaller;
        private final ReactNativeConfig reactNativeConfig;
        private final ReactNativeHostWrapper reactNativeHostWrapper;
        private final ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder;
        private final WeakReference<Context> weakContext;

        public BindingsInstaller getBindingsInstaller() {
            return this.bindingsInstaller;
        }

        public ReactNativeConfig getReactNativeConfig() {
            return this.reactNativeConfig;
        }

        public ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder() {
            return this.turboModuleManagerDelegateBuilder;
        }

        public ExpoReactHostDelegate(WeakReference<Context> weakReference, ReactNativeHostWrapper reactNativeHostWrapper2, BindingsInstaller bindingsInstaller2, ReactNativeConfig reactNativeConfig2, ReactPackageTurboModuleManagerDelegate.Builder builder) {
            Intrinsics.checkNotNullParameter(weakReference, "weakContext");
            Intrinsics.checkNotNullParameter(reactNativeHostWrapper2, "reactNativeHostWrapper");
            Intrinsics.checkNotNullParameter(reactNativeConfig2, "reactNativeConfig");
            Intrinsics.checkNotNullParameter(builder, "turboModuleManagerDelegateBuilder");
            this.weakContext = weakReference;
            this.reactNativeHostWrapper = reactNativeHostWrapper2;
            this.bindingsInstaller = bindingsInstaller2;
            this.reactNativeConfig = reactNativeConfig2;
            this.turboModuleManagerDelegateBuilder = builder;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ExpoReactHostDelegate(WeakReference weakReference, ReactNativeHostWrapper reactNativeHostWrapper2, BindingsInstaller bindingsInstaller2, ReactNativeConfig reactNativeConfig2, ReactPackageTurboModuleManagerDelegate.Builder builder, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(weakReference, reactNativeHostWrapper2, (i & 4) != 0 ? null : bindingsInstaller2, (i & 8) != 0 ? ReactNativeConfig.DEFAULT_CONFIG : reactNativeConfig2, (i & 16) != 0 ? new DefaultTurboModuleManagerDelegate.Builder() : builder);
        }

        public JSBundleLoader getJsBundleLoader() {
            JSBundleLoader jSBundleLoader = this._jsBundleLoader;
            if (jSBundleLoader != null) {
                return jSBundleLoader;
            }
            Context context = (Context) this.weakContext.get();
            if (context != null) {
                String jSBundleFile = this.reactNativeHostWrapper.getJSBundleFile();
                if (jSBundleFile == null) {
                    String bundleAssetName = this.reactNativeHostWrapper.getBundleAssetName();
                    JSBundleLoader createAssetLoader = JSBundleLoader.createAssetLoader(context, "assets://" + bundleAssetName, true);
                    Intrinsics.checkNotNullExpressionValue(createAssetLoader, "createAssetLoader(...)");
                    return createAssetLoader;
                } else if (StringsKt.startsWith$default(jSBundleFile, "assets://", false, 2, (Object) null)) {
                    JSBundleLoader createAssetLoader2 = JSBundleLoader.createAssetLoader(context, jSBundleFile, true);
                    Intrinsics.checkNotNullExpressionValue(createAssetLoader2, "createAssetLoader(...)");
                    return createAssetLoader2;
                } else {
                    JSBundleLoader createFileLoader = JSBundleLoader.createFileLoader(jSBundleFile);
                    Intrinsics.checkNotNullExpressionValue(createFileLoader, "createFileLoader(...)");
                    return createFileLoader;
                }
            } else {
                throw new IllegalStateException("Unable to get concrete Context");
            }
        }

        public String getJsMainModulePath() {
            return this.reactNativeHostWrapper.getJSMainModuleName();
        }

        public JSRuntimeFactory getJsRuntimeFactory() {
            if (this.reactNativeHostWrapper.getJSEngineResolutionAlgorithm() == JSEngineResolutionAlgorithm.HERMES) {
                return new HermesInstance();
            }
            return new JSCInstance();
        }

        public List<ReactPackage> getReactPackages() {
            return this.reactNativeHostWrapper.getPackages();
        }

        public void handleInstanceException(Exception exc) {
            Intrinsics.checkNotNullParameter(exc, "error");
            boolean useDeveloperSupport = this.reactNativeHostWrapper.getUseDeveloperSupport();
            for (ReactNativeHostHandler onReactInstanceException : this.reactNativeHostWrapper.getReactNativeHostHandlers$expo_release()) {
                onReactInstanceException.onReactInstanceException(useDeveloperSupport, exc);
            }
        }
    }

    @JvmStatic
    public static final ReactHost createFromReactNativeHost(Context context, ReactNativeHost reactNativeHost) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(reactNativeHost, "reactNativeHost");
        if (reactNativeHost instanceof ReactNativeHostWrapper) {
            if (reactHost == null) {
                ReactNativeHostWrapper reactNativeHostWrapper = (ReactNativeHostWrapper) reactNativeHost;
                boolean useDeveloperSupport = reactNativeHostWrapper.getUseDeveloperSupport();
                ExpoReactHostDelegate expoReactHostDelegate = new ExpoReactHostDelegate(new WeakReference(context), reactNativeHostWrapper, (BindingsInstaller) null, (ReactNativeConfig) null, (ReactPackageTurboModuleManagerDelegate.Builder) null, 28, (DefaultConstructorMarker) null);
                ExpoReactHostFactory$$ExternalSyntheticLambda0 expoReactHostFactory$$ExternalSyntheticLambda0 = new ExpoReactHostFactory$$ExternalSyntheticLambda0();
                ComponentFactory componentFactory = new ComponentFactory();
                DefaultComponentsRegistry.Companion.register(componentFactory);
                for (ReactNativeHostHandler onWillCreateReactInstance : reactNativeHostWrapper.getReactNativeHostHandlers$expo_release()) {
                    onWillCreateReactInstance.onWillCreateReactInstance(useDeveloperSupport);
                }
                ReactHostImpl reactHostImpl = new ReactHostImpl(context, expoReactHostDelegate, componentFactory, true, expoReactHostFactory$$ExternalSyntheticLambda0, useDeveloperSupport);
                reactHostImpl.setJsEngineResolutionAlgorithm(reactNativeHostWrapper.getJSEngineResolutionAlgorithm());
                for (ReactNativeHostHandler onDidCreateDevSupportManager : reactNativeHostWrapper.getReactNativeHostHandlers$expo_release()) {
                    onDidCreateDevSupportManager.onDidCreateDevSupportManager(reactHostImpl.getDevSupportManager());
                }
                reactHostImpl.addReactInstanceEventListener(new ExpoReactHostFactory$createFromReactNativeHost$4(reactNativeHost, useDeveloperSupport));
                reactHost = reactHostImpl;
            }
            ReactHost reactHost2 = reactHost;
            Intrinsics.checkNotNull(reactHost2, "null cannot be cast to non-null type com.facebook.react.ReactHost");
            return reactHost2;
        }
        throw new IllegalArgumentException("You can call createFromReactNativeHost only with instances of ReactNativeHostWrapper".toString());
    }
}
