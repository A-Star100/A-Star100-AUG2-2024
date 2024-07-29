package com.facebook.react.defaults;

import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.uimanager.ViewManagerResolver;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u001f\n\u0002\u0010\u001e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J`\u0010\u0002\u001aR\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u0004\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0018\u0001 \u0005*#\u0012\u0002\b\u0003\u0012\u0016\b\u0001\u0012\u0012\u0012\u0002\b\u0003 \u0005*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0018\u00010\u0003¨\u0006\u00010\u0003¨\u0006\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a&\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\b0\b \u0005*\u0012\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\b0\b\u0018\u00010\u000b0\nH\u0016¨\u0006\f"}, d2 = {"com/facebook/react/defaults/DefaultReactNativeHost$getUIManagerProvider$1$viewManagerRegistry$1", "Lcom/facebook/react/uimanager/ViewManagerResolver;", "getViewManager", "Lcom/facebook/react/uimanager/ViewManager;", "Landroid/view/View;", "kotlin.jvm.PlatformType", "Lcom/facebook/react/uimanager/ReactShadowNode;", "viewManagerName", "", "getViewManagerNames", "", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DefaultReactNativeHost.kt */
public final class DefaultReactNativeHost$getUIManagerProvider$1$viewManagerRegistry$1 implements ViewManagerResolver {
    final /* synthetic */ DefaultReactNativeHost this$0;

    DefaultReactNativeHost$getUIManagerProvider$1$viewManagerRegistry$1(DefaultReactNativeHost defaultReactNativeHost) {
        this.this$0 = defaultReactNativeHost;
    }

    public ViewManager getViewManager(String str) {
        Intrinsics.checkNotNullParameter(str, "viewManagerName");
        return this.this$0.getReactInstanceManager().createViewManager(str);
    }

    public Collection<String> getViewManagerNames() {
        return this.this$0.getReactInstanceManager().getViewManagerNames();
    }
}
