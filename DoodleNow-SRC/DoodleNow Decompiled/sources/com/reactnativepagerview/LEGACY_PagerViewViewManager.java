package com.reactnativepagerview;

import android.widget.FrameLayout;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/reactnativepagerview/LEGACY_PagerViewViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Landroid/widget/FrameLayout;", "()V", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getName", "", "react-native-pager-view_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@ReactModule(name = "LEGACY_RNCViewPager")
/* compiled from: LEGACY_PagerViewViewManager.kt */
public final class LEGACY_PagerViewViewManager extends ViewGroupManager<FrameLayout> {
    public String getName() {
        return LEGACY_PagerViewViewManagerImpl.NAME;
    }

    /* access modifiers changed from: protected */
    public FrameLayout createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        throw new Error("LEGACY_RNCViewPager is an iOS-only feature");
    }
}
