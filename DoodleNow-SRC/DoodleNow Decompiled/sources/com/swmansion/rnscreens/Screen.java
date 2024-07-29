package com.swmansion.rnscreens;

import android.content.Context;
import android.graphics.Paint;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebView;
import androidx.camera.video.AudioStats;
import androidx.core.view.ViewGroupKt;
import androidx.fragment.app.Fragment;
import com.amplitude.api.DeviceInfo;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.swmansion.rnscreens.events.HeaderHeightChangeEvent;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u00002\u00020\u0001:\u0006|}~\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020^\u0012\u0004\u0012\u00020^0]H\u0002J\u000e\u0010_\u001a\u00020`2\u0006\u0010a\u001a\u000209J\u0016\u0010b\u001a\u00020`2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020d0cH\u0014J\u0016\u0010e\u001a\u00020`2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020d0cH\u0014J\u0010\u0010f\u001a\u00020\u001f2\u0006\u0010g\u001a\u00020hH\u0002J\u0010\u0010i\u001a\u00020`2\u0006\u0010j\u001a\u00020^H\u0002J0\u0010k\u001a\u00020`2\u0006\u0010l\u001a\u00020\u001f2\u0006\u0010m\u001a\u0002092\u0006\u0010n\u001a\u0002092\u0006\u0010o\u001a\u0002092\u0006\u0010p\u001a\u000209H\u0014J\u000e\u0010q\u001a\u00020`2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u0010r\u001a\u00020`2\u0006\u0010s\u001a\u0002092\b\u0010t\u001a\u0004\u0018\u00010uH\u0016J\u0010\u0010v\u001a\u00020`2\b\u0010E\u001a\u0004\u0018\u00010WJ\u000e\u0010w\u001a\u00020`2\u0006\u0010x\u001a\u00020\u001fJ\u0018\u0010y\u001a\u00020`2\u0006\u0010z\u001a\u0002092\u0006\u0010{\u001a\u000209H\u0002R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u00118F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"R*\u0010$\u001a\u0004\u0018\u00010\u001f2\b\u0010#\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R*\u0010*\u001a\u0004\u0018\u00010\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\u001e\u0010,\u001a\u0004\u0018\u00010\u001fX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R*\u0010/\u001a\u0004\u0018\u00010\u001f2\b\u0010.\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b/\u0010%\"\u0004\b0\u0010'R*\u00102\u001a\u0004\u0018\u00010\u001f2\b\u00101\u001a\u0004\u0018\u00010\u001f@FX\u000e¢\u0006\u0010\n\u0002\u0010(\u001a\u0004\b2\u0010%\"\u0004\b3\u0010'R\u000e\u00104\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u001a\u00105\u001a\u00020\u001fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010 \"\u0004\b7\u0010\"R*\u00108\u001a\u0004\u0018\u0001092\b\u00108\u001a\u0004\u0018\u000109@FX\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010?\u001a\u00020@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR$\u0010E\u001a\u0004\u0018\u0001092\b\u0010\u0005\u001a\u0004\u0018\u000109@BX\u000e¢\u0006\n\n\u0002\u0010>\u001a\u0004\bF\u0010;R\u001a\u0010G\u001a\u00020HX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u001a\u0010M\u001a\u00020NX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR*\u0010S\u001a\u0004\u0018\u0001092\b\u0010S\u001a\u0004\u0018\u000109@FX\u000e¢\u0006\u0010\n\u0002\u0010>\u001a\u0004\bT\u0010;\"\u0004\bU\u0010=R(\u0010V\u001a\u0004\u0018\u00010W2\b\u0010V\u001a\u0004\u0018\u00010W@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[¨\u0006\u0001"}, d2 = {"Lcom/swmansion/rnscreens/Screen;", "Lcom/swmansion/rnscreens/FabricEnabledViewGroup;", "context", "Lcom/facebook/react/bridge/ReactContext;", "(Lcom/facebook/react/bridge/ReactContext;)V", "<set-?>", "Lcom/swmansion/rnscreens/Screen$ActivityState;", "activityState", "getActivityState", "()Lcom/swmansion/rnscreens/Screen$ActivityState;", "container", "Lcom/swmansion/rnscreens/ScreenContainer;", "getContainer", "()Lcom/swmansion/rnscreens/ScreenContainer;", "setContainer", "(Lcom/swmansion/rnscreens/ScreenContainer;)V", "fragment", "Landroidx/fragment/app/Fragment;", "getFragment", "()Landroidx/fragment/app/Fragment;", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "getFragmentWrapper", "()Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "setFragmentWrapper", "(Lcom/swmansion/rnscreens/ScreenFragmentWrapper;)V", "headerConfig", "Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "getHeaderConfig", "()Lcom/swmansion/rnscreens/ScreenStackHeaderConfig;", "isGestureEnabled", "", "()Z", "setGestureEnabled", "(Z)V", "navigationBarHidden", "isNavigationBarHidden", "()Ljava/lang/Boolean;", "setNavigationBarHidden", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "navigationBarTranslucent", "isNavigationBarTranslucent", "setNavigationBarTranslucent", "isStatusBarAnimated", "setStatusBarAnimated", "statusBarHidden", "isStatusBarHidden", "setStatusBarHidden", "statusBarTranslucent", "isStatusBarTranslucent", "setStatusBarTranslucent", "isTransitioning", "nativeBackButtonDismissalEnabled", "getNativeBackButtonDismissalEnabled", "setNativeBackButtonDismissalEnabled", "navigationBarColor", "", "getNavigationBarColor", "()Ljava/lang/Integer;", "setNavigationBarColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "replaceAnimation", "Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "getReplaceAnimation", "()Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "setReplaceAnimation", "(Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;)V", "screenOrientation", "getScreenOrientation", "stackAnimation", "Lcom/swmansion/rnscreens/Screen$StackAnimation;", "getStackAnimation", "()Lcom/swmansion/rnscreens/Screen$StackAnimation;", "setStackAnimation", "(Lcom/swmansion/rnscreens/Screen$StackAnimation;)V", "stackPresentation", "Lcom/swmansion/rnscreens/Screen$StackPresentation;", "getStackPresentation", "()Lcom/swmansion/rnscreens/Screen$StackPresentation;", "setStackPresentation", "(Lcom/swmansion/rnscreens/Screen$StackPresentation;)V", "statusBarColor", "getStatusBarColor", "setStatusBarColor", "statusBarStyle", "", "getStatusBarStyle", "()Ljava/lang/String;", "setStatusBarStyle", "(Ljava/lang/String;)V", "calculateHeaderHeight", "Lkotlin/Pair;", "", "changeAccessibilityMode", "", "mode", "dispatchRestoreInstanceState", "Landroid/util/SparseArray;", "Landroid/os/Parcelable;", "dispatchSaveInstanceState", "hasWebView", "viewGroup", "Landroid/view/ViewGroup;", "notifyHeaderHeightChange", "headerHeight", "onLayout", "changed", "l", "t", "r", "b", "setActivityState", "setLayerType", "layerType", "paint", "Landroid/graphics/Paint;", "setScreenOrientation", "setTransitioning", "transitioning", "updateScreenSizePaper", "width", "height", "ActivityState", "ReplaceAnimation", "StackAnimation", "StackPresentation", "WindowTraits", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Screen.kt */
public final class Screen extends FabricEnabledViewGroup {
    private ActivityState activityState;
    private ScreenContainer container;
    private ScreenFragmentWrapper fragmentWrapper;
    private boolean isGestureEnabled = true;
    private Boolean isNavigationBarHidden;
    private Boolean isNavigationBarTranslucent;
    private Boolean isStatusBarAnimated;
    private Boolean isStatusBarHidden;
    private Boolean isStatusBarTranslucent;
    private boolean isTransitioning;
    private boolean nativeBackButtonDismissalEnabled;
    private Integer navigationBarColor;
    private ReplaceAnimation replaceAnimation = ReplaceAnimation.POP;
    private Integer screenOrientation;
    private StackAnimation stackAnimation = StackAnimation.DEFAULT;
    private StackPresentation stackPresentation = StackPresentation.PUSH;
    private Integer statusBarColor;
    private String statusBarStyle;

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, TtmlNode.RUBY_CONTAINER);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, TtmlNode.RUBY_CONTAINER);
    }

    public final ActivityState getActivityState() {
        return this.activityState;
    }

    public final ScreenContainer getContainer() {
        return this.container;
    }

    public final ScreenFragmentWrapper getFragmentWrapper() {
        return this.fragmentWrapper;
    }

    public final boolean getNativeBackButtonDismissalEnabled() {
        return this.nativeBackButtonDismissalEnabled;
    }

    public final Integer getNavigationBarColor() {
        return this.navigationBarColor;
    }

    public final ReplaceAnimation getReplaceAnimation() {
        return this.replaceAnimation;
    }

    public final Integer getScreenOrientation() {
        return this.screenOrientation;
    }

    public final StackAnimation getStackAnimation() {
        return this.stackAnimation;
    }

    public final StackPresentation getStackPresentation() {
        return this.stackPresentation;
    }

    public final Integer getStatusBarColor() {
        return this.statusBarColor;
    }

    public final String getStatusBarStyle() {
        return this.statusBarStyle;
    }

    public final boolean isGestureEnabled() {
        return this.isGestureEnabled;
    }

    public final Boolean isNavigationBarHidden() {
        return this.isNavigationBarHidden;
    }

    public final Boolean isNavigationBarTranslucent() {
        return this.isNavigationBarTranslucent;
    }

    public final Boolean isStatusBarAnimated() {
        return this.isStatusBarAnimated;
    }

    public final Boolean isStatusBarHidden() {
        return this.isStatusBarHidden;
    }

    public final Boolean isStatusBarTranslucent() {
        return this.isStatusBarTranslucent;
    }

    public final void setContainer(ScreenContainer screenContainer) {
        this.container = screenContainer;
    }

    public final void setFragmentWrapper(ScreenFragmentWrapper screenFragmentWrapper) {
        this.fragmentWrapper = screenFragmentWrapper;
    }

    public final void setGestureEnabled(boolean z) {
        this.isGestureEnabled = z;
    }

    public void setLayerType(int i, Paint paint) {
    }

    public final void setNativeBackButtonDismissalEnabled(boolean z) {
        this.nativeBackButtonDismissalEnabled = z;
    }

    public final void setReplaceAnimation(ReplaceAnimation replaceAnimation2) {
        Intrinsics.checkNotNullParameter(replaceAnimation2, "<set-?>");
        this.replaceAnimation = replaceAnimation2;
    }

    public final void setStackAnimation(StackAnimation stackAnimation2) {
        Intrinsics.checkNotNullParameter(stackAnimation2, "<set-?>");
        this.stackAnimation = stackAnimation2;
    }

    public final void setStackPresentation(StackPresentation stackPresentation2) {
        Intrinsics.checkNotNullParameter(stackPresentation2, "<set-?>");
        this.stackPresentation = stackPresentation2;
    }

    public final void setStatusBarAnimated(Boolean bool) {
        this.isStatusBarAnimated = bool;
    }

    public Screen(ReactContext reactContext) {
        super(reactContext);
        setLayoutParams(new WindowManager.LayoutParams(2));
        this.nativeBackButtonDismissalEnabled = true;
    }

    public final Fragment getFragment() {
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            return screenFragmentWrapper.getFragment();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if ((this.container instanceof ScreenStack) && z) {
            Pair<Double, Double> calculateHeaderHeight = calculateHeaderHeight();
            updateScreenSizePaper(i3 - i, i4 - i2);
            notifyHeaderHeightChange(calculateHeaderHeight.getFirst().doubleValue() + calculateHeaderHeight.getSecond().doubleValue());
        }
    }

    private final void updateScreenSizePaper(int i, int i2) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        reactContext.runOnNativeModulesQueueThread(new Screen$updateScreenSizePaper$1(reactContext, this, i, i2, reactContext.getExceptionHandler()));
    }

    public final ScreenStackHeaderConfig getHeaderConfig() {
        View view;
        Iterator<View> it = ViewGroupKt.getChildren(this).iterator();
        while (true) {
            if (!it.hasNext()) {
                view = null;
                break;
            }
            view = it.next();
            if (view instanceof ScreenStackHeaderConfig) {
                break;
            }
        }
        if (view instanceof ScreenStackHeaderConfig) {
            return (ScreenStackHeaderConfig) view;
        }
        return null;
    }

    public final void setTransitioning(boolean z) {
        if (this.isTransitioning != z) {
            this.isTransitioning = z;
            boolean hasWebView = hasWebView(this);
            int i = 2;
            if (!hasWebView || getLayerType() == 2) {
                if (!z || hasWebView) {
                    i = 0;
                }
                super.setLayerType(i, (Paint) null);
            }
        }
    }

    private final boolean hasWebView(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof WebView) {
                return true;
            }
            if ((childAt instanceof ViewGroup) && hasWebView((ViewGroup) childAt)) {
                return true;
            }
        }
        return false;
    }

    public final void setActivityState(ActivityState activityState2) {
        Intrinsics.checkNotNullParameter(activityState2, "activityState");
        if (activityState2 != this.activityState) {
            this.activityState = activityState2;
            ScreenContainer screenContainer = this.container;
            if (screenContainer != null) {
                screenContainer.notifyChildUpdate();
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setScreenOrientation(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 != 0) goto L_0x0006
            r2 = 0
            r1.screenOrientation = r2
            return
        L_0x0006:
            com.swmansion.rnscreens.ScreenWindowTraits r0 = com.swmansion.rnscreens.ScreenWindowTraits.INSTANCE
            r0.applyDidSetOrientation$react_native_screens_release()
            int r0 = r2.hashCode()
            switch(r0) {
                case -1894896954: goto L_0x0072;
                case 96673: goto L_0x0062;
                case 729267099: goto L_0x0053;
                case 1430647483: goto L_0x0044;
                case 1651658175: goto L_0x0035;
                case 1730732811: goto L_0x0025;
                case 2118770584: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0082
        L_0x0014:
            java.lang.String r0 = "landscape_right"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x001e
            goto L_0x0082
        L_0x001e:
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0025:
            java.lang.String r0 = "landscape_left"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x002e
            goto L_0x0082
        L_0x002e:
            r2 = 8
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0035:
            java.lang.String r0 = "portrait_up"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x003e
            goto L_0x0082
        L_0x003e:
            r2 = 1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0044:
            java.lang.String r0 = "landscape"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004d
            goto L_0x0082
        L_0x004d:
            r2 = 6
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0053:
            java.lang.String r0 = "portrait"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x005c
            goto L_0x0082
        L_0x005c:
            r2 = 7
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0062:
            java.lang.String r0 = "all"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x006b
            goto L_0x0082
        L_0x006b:
            r2 = 10
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0072:
            java.lang.String r0 = "portrait_down"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x007b
            goto L_0x0082
        L_0x007b:
            r2 = 9
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            goto L_0x0087
        L_0x0082:
            r2 = -1
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x0087:
            r1.screenOrientation = r2
            com.swmansion.rnscreens.ScreenFragmentWrapper r2 = r1.fragmentWrapper
            if (r2 == 0) goto L_0x0096
            com.swmansion.rnscreens.ScreenWindowTraits r0 = com.swmansion.rnscreens.ScreenWindowTraits.INSTANCE
            android.app.Activity r2 = r2.tryGetActivity()
            r0.setOrientation$react_native_screens_release(r1, r2)
        L_0x0096:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.Screen.setScreenOrientation(java.lang.String):void");
    }

    public final void changeAccessibilityMode(int i) {
        setImportantForAccessibility(i);
        ScreenStackHeaderConfig headerConfig = getHeaderConfig();
        CustomToolbar toolbar = headerConfig != null ? headerConfig.getToolbar() : null;
        if (toolbar != null) {
            toolbar.setImportantForAccessibility(i);
        }
    }

    public final void setStatusBarStyle(String str) {
        if (str != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarStyle = str;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setStyle$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final void setStatusBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final void setStatusBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.isStatusBarTranslucent = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setTranslucent$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final void setStatusBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetStatusBarAppearance$react_native_screens_release();
        }
        this.statusBarColor = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setColor$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity(), screenFragmentWrapper.tryGetContext());
        }
    }

    public final void setNavigationBarColor(Integer num) {
        if (num != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.navigationBarColor = num;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarColor$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final void setNavigationBarTranslucent(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.isNavigationBarTranslucent = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarTranslucent$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    public final void setNavigationBarHidden(Boolean bool) {
        if (bool != null) {
            ScreenWindowTraits.INSTANCE.applyDidSetNavigationBarAppearance$react_native_screens_release();
        }
        this.isNavigationBarHidden = bool;
        ScreenFragmentWrapper screenFragmentWrapper = this.fragmentWrapper;
        if (screenFragmentWrapper != null) {
            ScreenWindowTraits.INSTANCE.setNavigationBarHidden$react_native_screens_release(this, screenFragmentWrapper.tryGetActivity());
        }
    }

    private final Pair<Double, Double> calculateHeaderHeight() {
        ScreenStackHeaderConfig headerConfig;
        ScreenStackHeaderConfig headerConfig2;
        TypedValue typedValue = new TypedValue();
        boolean resolveAttribute = getContext().getTheme().resolveAttribute(16843499, typedValue, true);
        Integer valueOf = Integer.valueOf(TypedValue.complexToDimensionPixelSize(typedValue.data, getResources().getDisplayMetrics()));
        valueOf.intValue();
        Integer num = null;
        if (!resolveAttribute || (((headerConfig = getHeaderConfig()) != null && headerConfig.isHeaderHidden()) || ((headerConfig2 = getHeaderConfig()) != null && headerConfig2.isHeaderTranslucent()))) {
            valueOf = null;
        }
        double d = AudioStats.AUDIO_AMPLITUDE_NONE;
        double dIPFromPixel = valueOf != null ? (double) PixelUtil.toDIPFromPixel((float) valueOf.intValue()) : 0.0d;
        Integer valueOf2 = Integer.valueOf(getContext().getResources().getIdentifier("status_bar_height", "dimen", DeviceInfo.OS_NAME));
        if (valueOf2.intValue() > 0 && !Intrinsics.areEqual((Object) this.isStatusBarHidden, (Object) true) && dIPFromPixel > AudioStats.AUDIO_AMPLITUDE_NONE) {
            num = valueOf2;
        }
        if (num != null) {
            d = (double) PixelUtil.toDIPFromPixel((float) getContext().getResources().getDimensionPixelSize(num.intValue()));
        }
        return TuplesKt.to(Double.valueOf(dIPFromPixel), Double.valueOf(d));
    }

    private final void notifyHeaderHeightChange(double d) {
        Context context = getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type com.facebook.react.bridge.ReactContext");
        ReactContext reactContext = (ReactContext) context;
        int surfaceId = UIManagerHelper.getSurfaceId((Context) reactContext);
        EventDispatcher eventDispatcherForReactTag = UIManagerHelper.getEventDispatcherForReactTag(reactContext, getId());
        if (eventDispatcherForReactTag != null) {
            eventDispatcherForReactTag.dispatchEvent(new HeaderHeightChangeEvent(surfaceId, getId(), d));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackPresentation;", "", "(Ljava/lang/String;I)V", "PUSH", "MODAL", "TRANSPARENT_MODAL", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum StackPresentation {
        PUSH,
        MODAL,
        TRANSPARENT_MODAL;

        public static EnumEntries<StackPresentation> getEntries() {
            return $ENTRIES;
        }

        static {
            StackPresentation[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/swmansion/rnscreens/Screen$StackAnimation;", "", "(Ljava/lang/String;I)V", "DEFAULT", "NONE", "FADE", "SLIDE_FROM_BOTTOM", "SLIDE_FROM_RIGHT", "SLIDE_FROM_LEFT", "FADE_FROM_BOTTOM", "IOS", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum StackAnimation {
        DEFAULT,
        NONE,
        FADE,
        SLIDE_FROM_BOTTOM,
        SLIDE_FROM_RIGHT,
        SLIDE_FROM_LEFT,
        FADE_FROM_BOTTOM,
        IOS;

        public static EnumEntries<StackAnimation> getEntries() {
            return $ENTRIES;
        }

        static {
            StackAnimation[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ReplaceAnimation;", "", "(Ljava/lang/String;I)V", "PUSH", "POP", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum ReplaceAnimation {
        PUSH,
        POP;

        public static EnumEntries<ReplaceAnimation> getEntries() {
            return $ENTRIES;
        }

        static {
            ReplaceAnimation[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/swmansion/rnscreens/Screen$ActivityState;", "", "(Ljava/lang/String;I)V", "INACTIVE", "TRANSITIONING_OR_BELOW_TOP", "ON_TOP", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum ActivityState {
        INACTIVE,
        TRANSITIONING_OR_BELOW_TOP,
        ON_TOP;

        public static EnumEntries<ActivityState> getEntries() {
            return $ENTRIES;
        }

        static {
            ActivityState[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/swmansion/rnscreens/Screen$WindowTraits;", "", "(Ljava/lang/String;I)V", "ORIENTATION", "COLOR", "STYLE", "TRANSLUCENT", "HIDDEN", "ANIMATED", "NAVIGATION_BAR_COLOR", "NAVIGATION_BAR_TRANSLUCENT", "NAVIGATION_BAR_HIDDEN", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Screen.kt */
    public enum WindowTraits {
        ORIENTATION,
        COLOR,
        STYLE,
        TRANSLUCENT,
        HIDDEN,
        ANIMATED,
        NAVIGATION_BAR_COLOR,
        NAVIGATION_BAR_TRANSLUCENT,
        NAVIGATION_BAR_HIDDEN;

        public static EnumEntries<WindowTraits> getEntries() {
            return $ENTRIES;
        }

        static {
            WindowTraits[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
