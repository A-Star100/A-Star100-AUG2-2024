package com.facebook.react.defaults;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.runtime.cxxreactpackage.CxxReactPackage;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/facebook/react/runtime/cxxreactpackage/CxxReactPackage;", "<anonymous parameter 0>", "Lcom/facebook/react/bridge/ReactApplicationContext;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DefaultTurboModuleManagerDelegate.kt */
final class DefaultTurboModuleManagerDelegate$Builder$addCxxReactPackage$1 extends Lambda implements Function1<ReactApplicationContext, CxxReactPackage> {
    final /* synthetic */ Function0<CxxReactPackage> $provider;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DefaultTurboModuleManagerDelegate$Builder$addCxxReactPackage$1(Function0<? extends CxxReactPackage> function0) {
        super(1);
        this.$provider = function0;
    }

    public final CxxReactPackage invoke(ReactApplicationContext reactApplicationContext) {
        Intrinsics.checkNotNullParameter(reactApplicationContext, "<anonymous parameter 0>");
        return this.$provider.invoke();
    }
}
