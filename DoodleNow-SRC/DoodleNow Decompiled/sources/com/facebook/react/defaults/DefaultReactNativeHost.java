package com.facebook.react.defaults;

import android.app.Application;
import android.content.Context;
import com.facebook.react.JSEngineResolutionAlgorithm;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UIManagerProvider;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.fabric.FabricUIManagerProviderImpl;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.uimanager.ViewManagerRegistry;
import com.facebook.react.uimanager.ViewManagerResolver;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\n\u0010\f\u001a\u0004\u0018\u00010\rH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00068TX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/facebook/react/defaults/DefaultReactNativeHost;", "Lcom/facebook/react/ReactNativeHost;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "isHermesEnabled", "", "()Ljava/lang/Boolean;", "isNewArchEnabled", "()Z", "getJSEngineResolutionAlgorithm", "Lcom/facebook/react/JSEngineResolutionAlgorithm;", "getReactPackageTurboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "getUIManagerProvider", "Lcom/facebook/react/bridge/UIManagerProvider;", "toReactHost", "Lcom/facebook/react/ReactHost;", "context", "Landroid/content/Context;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DefaultReactNativeHost.kt */
public abstract class DefaultReactNativeHost extends ReactNativeHost {
    /* access modifiers changed from: protected */
    public Boolean isHermesEnabled() {
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean isNewArchEnabled() {
        return false;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    protected DefaultReactNativeHost(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
    }

    /* access modifiers changed from: protected */
    public ReactPackageTurboModuleManagerDelegate.Builder getReactPackageTurboModuleManagerDelegateBuilder() {
        if (isNewArchEnabled()) {
            return new DefaultTurboModuleManagerDelegate.Builder();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public UIManagerProvider getUIManagerProvider() {
        if (isNewArchEnabled()) {
            return new DefaultReactNativeHost$$ExternalSyntheticLambda0(this);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final UIManager getUIManagerProvider$lambda$0(DefaultReactNativeHost defaultReactNativeHost, ReactApplicationContext reactApplicationContext) {
        ViewManagerRegistry viewManagerRegistry;
        Intrinsics.checkNotNullParameter(defaultReactNativeHost, "this$0");
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactApplicationContext");
        ComponentFactory componentFactory = new ComponentFactory();
        DefaultComponentsRegistry.Companion.register(componentFactory);
        if (defaultReactNativeHost.getLazyViewManagersEnabled()) {
            viewManagerRegistry = new ViewManagerRegistry((ViewManagerResolver) new DefaultReactNativeHost$getUIManagerProvider$1$viewManagerRegistry$1(defaultReactNativeHost));
        } else {
            viewManagerRegistry = new ViewManagerRegistry(defaultReactNativeHost.getReactInstanceManager().getOrCreateViewManagers(reactApplicationContext));
        }
        return new FabricUIManagerProviderImpl(componentFactory, ReactNativeConfig.DEFAULT_CONFIG, viewManagerRegistry).createUIManager(reactApplicationContext);
    }

    /* access modifiers changed from: protected */
    public JSEngineResolutionAlgorithm getJSEngineResolutionAlgorithm() {
        Boolean isHermesEnabled = isHermesEnabled();
        if (Intrinsics.areEqual((Object) isHermesEnabled, (Object) true)) {
            return JSEngineResolutionAlgorithm.HERMES;
        }
        if (Intrinsics.areEqual((Object) isHermesEnabled, (Object) false)) {
            return JSEngineResolutionAlgorithm.JSC;
        }
        if (isHermesEnabled == null) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final ReactHost toReactHost(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        List<ReactPackage> packages = getPackages();
        Intrinsics.checkNotNullExpressionValue(packages, "getPackages(...)");
        String jSMainModuleName = getJSMainModuleName();
        Intrinsics.checkNotNullExpressionValue(jSMainModuleName, "getJSMainModuleName(...)");
        String bundleAssetName = getBundleAssetName();
        if (bundleAssetName == null) {
            bundleAssetName = "index";
        }
        Boolean isHermesEnabled = isHermesEnabled();
        return DefaultReactHost.getDefaultReactHost(context, packages, jSMainModuleName, bundleAssetName, isHermesEnabled != null ? isHermesEnabled.booleanValue() : true);
    }
}
