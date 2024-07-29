package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.runtime.cxxreactpackage.CxxReactPackage;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005¢\u0006\u0002\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0014¨\u0006\u000e"}, d2 = {"Lcom/facebook/react/defaults/DefaultTurboModuleManagerDelegate;", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate;", "context", "Lcom/facebook/react/bridge/ReactApplicationContext;", "packages", "", "Lcom/facebook/react/ReactPackage;", "cxxReactPackages", "Lcom/facebook/react/runtime/cxxreactpackage/CxxReactPackage;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/util/List;Ljava/util/List;)V", "initHybrid", "Lcom/facebook/jni/HybridData;", "Builder", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DefaultTurboModuleManagerDelegate.kt */
public final class DefaultTurboModuleManagerDelegate extends ReactPackageTurboModuleManagerDelegate {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    public /* synthetic */ DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List list, List list2, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactApplicationContext, list, list2);
    }

    @JvmStatic
    public static final native HybridData initHybrid(List<? extends CxxReactPackage> list);

    private DefaultTurboModuleManagerDelegate(ReactApplicationContext reactApplicationContext, List<? extends ReactPackage> list, List<? extends CxxReactPackage> list2) {
        super(reactApplicationContext, list, Companion.initHybrid(list2));
    }

    /* access modifiers changed from: protected */
    public HybridData initHybrid() {
        throw new UnsupportedOperationException("DefaultTurboModuleManagerDelegate.initHybrid() must never be called!");
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rJ)\u0010\u000b\u001a\u00020\u00002!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0014R/\u0010\u0003\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/react/defaults/DefaultTurboModuleManagerDelegate$Builder;", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "()V", "cxxReactPackageProviders", "", "Lkotlin/Function1;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "Lkotlin/ParameterName;", "name", "context", "Lcom/facebook/react/runtime/cxxreactpackage/CxxReactPackage;", "addCxxReactPackage", "provider", "Lkotlin/Function0;", "build", "Lcom/facebook/react/defaults/DefaultTurboModuleManagerDelegate;", "packages", "", "Lcom/facebook/react/ReactPackage;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DefaultTurboModuleManagerDelegate.kt */
    public static final class Builder extends ReactPackageTurboModuleManagerDelegate.Builder {
        private List<Function1<ReactApplicationContext, CxxReactPackage>> cxxReactPackageProviders = new ArrayList();

        public final Builder addCxxReactPackage(Function0<? extends CxxReactPackage> function0) {
            Intrinsics.checkNotNullParameter(function0, "provider");
            this.cxxReactPackageProviders.add(new DefaultTurboModuleManagerDelegate$Builder$addCxxReactPackage$1(function0));
            return this;
        }

        public final Builder addCxxReactPackage(Function1<? super ReactApplicationContext, ? extends CxxReactPackage> function1) {
            Intrinsics.checkNotNullParameter(function1, "provider");
            this.cxxReactPackageProviders.add(function1);
            return this;
        }

        /* access modifiers changed from: protected */
        public DefaultTurboModuleManagerDelegate build(ReactApplicationContext reactApplicationContext, List<? extends ReactPackage> list) {
            Intrinsics.checkNotNullParameter(reactApplicationContext, "context");
            Intrinsics.checkNotNullParameter(list, "packages");
            List arrayList = new ArrayList();
            for (Function1<ReactApplicationContext, CxxReactPackage> invoke : this.cxxReactPackageProviders) {
                arrayList.add(invoke.invoke(reactApplicationContext));
            }
            return new DefaultTurboModuleManagerDelegate(reactApplicationContext, list, arrayList, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H ¨\u0006\b"}, d2 = {"Lcom/facebook/react/defaults/DefaultTurboModuleManagerDelegate$Companion;", "", "()V", "initHybrid", "Lcom/facebook/jni/HybridData;", "cxxReactPackages", "", "Lcom/facebook/react/runtime/cxxreactpackage/CxxReactPackage;", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DefaultTurboModuleManagerDelegate.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final HybridData initHybrid(List<? extends CxxReactPackage> list) {
            return DefaultTurboModuleManagerDelegate.initHybrid(list);
        }

        private Companion() {
        }
    }

    static {
        DefaultSoLoader.Companion.maybeLoadSoLibrary();
    }
}
