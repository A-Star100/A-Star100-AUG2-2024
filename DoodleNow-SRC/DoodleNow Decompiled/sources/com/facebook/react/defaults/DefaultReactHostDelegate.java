package com.facebook.react.defaults;

import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0018\b\u0002\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\u0014\u0010$\u001a\u00020\u00132\n\u0010%\u001a\u00060\u0011j\u0002`\u0012H\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u000f\u001a\u0012\u0012\b\u0012\u00060\u0011j\u0002`\u0012\u0012\u0004\u0012\u00020\u00130\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/facebook/react/defaults/DefaultReactHostDelegate;", "Lcom/facebook/react/runtime/ReactHostDelegate;", "jsMainModulePath", "", "jsBundleLoader", "Lcom/facebook/react/bridge/JSBundleLoader;", "reactPackages", "", "Lcom/facebook/react/ReactPackage;", "jsRuntimeFactory", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "reactNativeConfig", "Lcom/facebook/react/fabric/ReactNativeConfig;", "exceptionHandler", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "turboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "(Ljava/lang/String;Lcom/facebook/react/bridge/JSBundleLoader;Ljava/util/List;Lcom/facebook/react/runtime/JSRuntimeFactory;Lcom/facebook/react/runtime/BindingsInstaller;Lcom/facebook/react/fabric/ReactNativeConfig;Lkotlin/jvm/functions/Function1;Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;)V", "getBindingsInstaller", "()Lcom/facebook/react/runtime/BindingsInstaller;", "getJsBundleLoader", "()Lcom/facebook/react/bridge/JSBundleLoader;", "getJsMainModulePath", "()Ljava/lang/String;", "getJsRuntimeFactory", "()Lcom/facebook/react/runtime/JSRuntimeFactory;", "getReactPackages", "()Ljava/util/List;", "getTurboModuleManagerDelegateBuilder", "()Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "getReactNativeConfig", "handleInstanceException", "error", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@UnstableReactNativeAPI
/* compiled from: DefaultReactHostDelegate.kt */
public final class DefaultReactHostDelegate implements ReactHostDelegate {
    private final BindingsInstaller bindingsInstaller;
    private final Function1<Exception, Unit> exceptionHandler;
    private final JSBundleLoader jsBundleLoader;
    private final String jsMainModulePath;
    private final JSRuntimeFactory jsRuntimeFactory;
    private final ReactNativeConfig reactNativeConfig;
    private final List<ReactPackage> reactPackages;
    private final ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder;

    public BindingsInstaller getBindingsInstaller() {
        return this.bindingsInstaller;
    }

    public JSBundleLoader getJsBundleLoader() {
        return this.jsBundleLoader;
    }

    public String getJsMainModulePath() {
        return this.jsMainModulePath;
    }

    public JSRuntimeFactory getJsRuntimeFactory() {
        return this.jsRuntimeFactory;
    }

    public ReactNativeConfig getReactNativeConfig() {
        return this.reactNativeConfig;
    }

    public List<ReactPackage> getReactPackages() {
        return this.reactPackages;
    }

    public ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder() {
        return this.turboModuleManagerDelegateBuilder;
    }

    public DefaultReactHostDelegate(String str, JSBundleLoader jSBundleLoader, List<? extends ReactPackage> list, JSRuntimeFactory jSRuntimeFactory, BindingsInstaller bindingsInstaller2, ReactNativeConfig reactNativeConfig2, Function1<? super Exception, Unit> function1, ReactPackageTurboModuleManagerDelegate.Builder builder) {
        Intrinsics.checkNotNullParameter(str, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jSBundleLoader, "jsBundleLoader");
        Intrinsics.checkNotNullParameter(list, "reactPackages");
        Intrinsics.checkNotNullParameter(jSRuntimeFactory, "jsRuntimeFactory");
        Intrinsics.checkNotNullParameter(reactNativeConfig2, "reactNativeConfig");
        Intrinsics.checkNotNullParameter(function1, "exceptionHandler");
        Intrinsics.checkNotNullParameter(builder, "turboModuleManagerDelegateBuilder");
        this.jsMainModulePath = str;
        this.jsBundleLoader = jSBundleLoader;
        this.reactPackages = list;
        this.jsRuntimeFactory = jSRuntimeFactory;
        this.bindingsInstaller = bindingsInstaller2;
        this.reactNativeConfig = reactNativeConfig2;
        this.exceptionHandler = function1;
        this.turboModuleManagerDelegateBuilder = builder;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ DefaultReactHostDelegate(java.lang.String r11, com.facebook.react.bridge.JSBundleLoader r12, java.util.List r13, com.facebook.react.runtime.JSRuntimeFactory r14, com.facebook.react.runtime.BindingsInstaller r15, com.facebook.react.fabric.ReactNativeConfig r16, kotlin.jvm.functions.Function1 r17, com.facebook.react.ReactPackageTurboModuleManagerDelegate.Builder r18, int r19, kotlin.jvm.internal.DefaultConstructorMarker r20) {
        /*
            r10 = this;
            r0 = r19 & 4
            if (r0 == 0) goto L_0x000a
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            r4 = r0
            goto L_0x000b
        L_0x000a:
            r4 = r13
        L_0x000b:
            r0 = r19 & 8
            if (r0 == 0) goto L_0x0018
            com.facebook.react.runtime.hermes.HermesInstance r0 = new com.facebook.react.runtime.hermes.HermesInstance
            r0.<init>()
            com.facebook.react.runtime.JSRuntimeFactory r0 = (com.facebook.react.runtime.JSRuntimeFactory) r0
            r5 = r0
            goto L_0x0019
        L_0x0018:
            r5 = r14
        L_0x0019:
            r0 = r19 & 16
            if (r0 == 0) goto L_0x0020
            r0 = 0
            r6 = r0
            goto L_0x0021
        L_0x0020:
            r6 = r15
        L_0x0021:
            r0 = r19 & 32
            if (r0 == 0) goto L_0x0029
            com.facebook.react.fabric.ReactNativeConfig r0 = com.facebook.react.fabric.ReactNativeConfig.DEFAULT_CONFIG
            r7 = r0
            goto L_0x002b
        L_0x0029:
            r7 = r16
        L_0x002b:
            r0 = r19 & 64
            if (r0 == 0) goto L_0x0035
            com.facebook.react.defaults.DefaultReactHostDelegate$1 r0 = com.facebook.react.defaults.DefaultReactHostDelegate.AnonymousClass1.INSTANCE
            kotlin.jvm.functions.Function1 r0 = (kotlin.jvm.functions.Function1) r0
            r8 = r0
            goto L_0x0037
        L_0x0035:
            r8 = r17
        L_0x0037:
            r1 = r10
            r2 = r11
            r3 = r12
            r9 = r18
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.defaults.DefaultReactHostDelegate.<init>(java.lang.String, com.facebook.react.bridge.JSBundleLoader, java.util.List, com.facebook.react.runtime.JSRuntimeFactory, com.facebook.react.runtime.BindingsInstaller, com.facebook.react.fabric.ReactNativeConfig, kotlin.jvm.functions.Function1, com.facebook.react.ReactPackageTurboModuleManagerDelegate$Builder, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public void handleInstanceException(Exception exc) {
        Intrinsics.checkNotNullParameter(exc, "error");
        this.exceptionHandler.invoke(exc);
    }
}
