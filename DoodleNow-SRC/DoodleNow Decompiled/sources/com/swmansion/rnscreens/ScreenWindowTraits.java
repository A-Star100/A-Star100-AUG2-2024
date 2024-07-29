package com.swmansion.rnscreens;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UiThreadUtil;
import com.swmansion.rnscreens.Screen;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\n\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u000eJ\r\u0010\u000f\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0010J\u0018\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0004H\u0002J)\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b J\u001f\u0010!\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b\"J\u001f\u0010#\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b$J\u001f\u0010%\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b&J\u001f\u0010'\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b(J\u001f\u0010)\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0000¢\u0006\u0002\b*J)\u0010+\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b,J)\u0010-\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b.J)\u0010/\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0000¢\u0006\u0002\b0R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0004\n\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/swmansion/rnscreens/ScreenWindowTraits;", "", "()V", "defaultStatusBarColor", "", "Ljava/lang/Integer;", "didSetNavigationBarAppearance", "", "didSetOrientation", "didSetStatusBarAppearance", "applyDidSetNavigationBarAppearance", "", "applyDidSetNavigationBarAppearance$react_native_screens_release", "applyDidSetOrientation", "applyDidSetOrientation$react_native_screens_release", "applyDidSetStatusBarAppearance", "applyDidSetStatusBarAppearance$react_native_screens_release", "checkTraitForScreen", "screen", "Lcom/swmansion/rnscreens/Screen;", "trait", "Lcom/swmansion/rnscreens/Screen$WindowTraits;", "childScreenWithTraitSet", "findParentWithTraitSet", "findScreenForTrait", "isColorLight", "color", "setColor", "activity", "Landroid/app/Activity;", "context", "Lcom/facebook/react/bridge/ReactContext;", "setColor$react_native_screens_release", "setHidden", "setHidden$react_native_screens_release", "setNavigationBarColor", "setNavigationBarColor$react_native_screens_release", "setNavigationBarHidden", "setNavigationBarHidden$react_native_screens_release", "setNavigationBarTranslucent", "setNavigationBarTranslucent$react_native_screens_release", "setOrientation", "setOrientation$react_native_screens_release", "setStyle", "setStyle$react_native_screens_release", "setTranslucent", "setTranslucent$react_native_screens_release", "trySetWindowTraits", "trySetWindowTraits$react_native_screens_release", "react-native-screens_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ScreenWindowTraits.kt */
public final class ScreenWindowTraits {
    public static final ScreenWindowTraits INSTANCE = new ScreenWindowTraits();
    private static Integer defaultStatusBarColor;
    private static boolean didSetNavigationBarAppearance;
    private static boolean didSetOrientation;
    private static boolean didSetStatusBarAppearance;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ScreenWindowTraits.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.swmansion.rnscreens.Screen$WindowTraits[] r0 = com.swmansion.rnscreens.Screen.WindowTraits.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.ORIENTATION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.COLOR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.STYLE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.TRANSLUCENT     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.ANIMATED     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.NAVIGATION_BAR_COLOR     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.NAVIGATION_BAR_TRANSLUCENT     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.NAVIGATION_BAR_HIDDEN     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.WhenMappings.<clinit>():void");
        }
    }

    public final void applyDidSetNavigationBarAppearance$react_native_screens_release() {
        didSetNavigationBarAppearance = true;
    }

    public final void applyDidSetOrientation$react_native_screens_release() {
        didSetOrientation = true;
    }

    public final void applyDidSetStatusBarAppearance$react_native_screens_release() {
        didSetStatusBarAppearance = true;
    }

    private ScreenWindowTraits() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r2 = r2.getScreenOrientation();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setOrientation$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.ORIENTATION
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001b
            java.lang.Integer r2 = r2.getScreenOrientation()
            if (r2 == 0) goto L_0x001b
            int r2 = r2.intValue()
            goto L_0x001c
        L_0x001b:
            r2 = -1
        L_0x001c:
            r3.setRequestedOrientation(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setOrientation$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0034, code lost:
        r3 = r3.isStatusBarAnimated();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setColor$react_native_screens_release(com.swmansion.rnscreens.Screen r3, android.app.Activity r4, com.facebook.react.bridge.ReactContext r5) {
        /*
            r2 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 == 0) goto L_0x004e
            if (r5 != 0) goto L_0x000a
            goto L_0x004e
        L_0x000a:
            java.lang.Integer r0 = defaultStatusBarColor
            if (r0 != 0) goto L_0x001c
            android.view.Window r0 = r4.getWindow()
            int r0 = r0.getStatusBarColor()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            defaultStatusBarColor = r0
        L_0x001c:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.COLOR
            com.swmansion.rnscreens.Screen r0 = r2.findScreenForTrait(r3, r0)
            com.swmansion.rnscreens.Screen$WindowTraits r1 = com.swmansion.rnscreens.Screen.WindowTraits.ANIMATED
            com.swmansion.rnscreens.Screen r3 = r2.findScreenForTrait(r3, r1)
            if (r0 == 0) goto L_0x0030
            java.lang.Integer r0 = r0.getStatusBarColor()
            if (r0 != 0) goto L_0x0032
        L_0x0030:
            java.lang.Integer r0 = defaultStatusBarColor
        L_0x0032:
            if (r3 == 0) goto L_0x003f
            java.lang.Boolean r3 = r3.isStatusBarAnimated()
            if (r3 == 0) goto L_0x003f
            boolean r3 = r3.booleanValue()
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            com.facebook.react.bridge.JSExceptionHandler r5 = r5.getExceptionHandler()
            com.swmansion.rnscreens.ScreenWindowTraits$setColor$1 r1 = new com.swmansion.rnscreens.ScreenWindowTraits$setColor$1
            r1.<init>(r4, r0, r3, r5)
            java.lang.Runnable r1 = (java.lang.Runnable) r1
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r1)
        L_0x004e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setColor$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity, com.facebook.react.bridge.ReactContext):void");
    }

    public final void setStyle$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        String str;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null && reactContext != null) {
            Screen findScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.STYLE);
            if (findScreenForTrait == null || (str = findScreenForTrait.getStatusBarStyle()) == null) {
                str = "light";
            }
            UiThreadUtil.runOnUiThread(new ScreenWindowTraits$$ExternalSyntheticLambda2(activity, str));
        }
    }

    /* access modifiers changed from: private */
    public static final void setStyle$lambda$0(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(str, "$style");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        new WindowInsetsControllerCompat(activity.getWindow(), decorView).setAppearanceLightStatusBars(Intrinsics.areEqual((Object) str, (Object) "dark"));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r2 = r2.isStatusBarTranslucent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setTranslucent$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3, com.facebook.react.bridge.ReactContext r4) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 == 0) goto L_0x002c
            if (r4 != 0) goto L_0x000a
            goto L_0x002c
        L_0x000a:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.TRANSLUCENT
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001d
            java.lang.Boolean r2 = r2.isStatusBarTranslucent()
            if (r2 == 0) goto L_0x001d
            boolean r2 = r2.booleanValue()
            goto L_0x001e
        L_0x001d:
            r2 = 0
        L_0x001e:
            com.facebook.react.bridge.JSExceptionHandler r4 = r4.getExceptionHandler()
            com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1 r0 = new com.swmansion.rnscreens.ScreenWindowTraits$setTranslucent$1
            r0.<init>(r3, r2, r4)
            java.lang.Runnable r0 = (java.lang.Runnable) r0
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setTranslucent$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity, com.facebook.react.bridge.ReactContext):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r3 = r3.isStatusBarHidden();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setHidden$react_native_screens_release(com.swmansion.rnscreens.Screen r3, android.app.Activity r4) {
        /*
            r2 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            if (r4 != 0) goto L_0x0008
            return
        L_0x0008:
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.HIDDEN
            com.swmansion.rnscreens.Screen r3 = r2.findScreenForTrait(r3, r0)
            if (r3 == 0) goto L_0x001b
            java.lang.Boolean r3 = r3.isStatusBarHidden()
            if (r3 == 0) goto L_0x001b
            boolean r3 = r3.booleanValue()
            goto L_0x001c
        L_0x001b:
            r3 = 0
        L_0x001c:
            android.view.Window r4 = r4.getWindow()
            androidx.core.view.WindowInsetsControllerCompat r0 = new androidx.core.view.WindowInsetsControllerCompat
            android.view.View r1 = r4.getDecorView()
            r0.<init>(r4, r1)
            com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda0 r4 = new com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda0
            r4.<init>(r3, r0)
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setHidden$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity):void");
    }

    /* access modifiers changed from: private */
    public static final void setHidden$lambda$1(boolean z, WindowInsetsControllerCompat windowInsetsControllerCompat) {
        Intrinsics.checkNotNullParameter(windowInsetsControllerCompat, "$controller");
        if (z) {
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.statusBars());
        } else {
            windowInsetsControllerCompat.show(WindowInsetsCompat.Type.statusBars());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r2 = r2.getNavigationBarColor();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setNavigationBarColor$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            android.view.Window r3 = r3.getWindow()
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.NAVIGATION_BAR_COLOR
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001f
            java.lang.Integer r2 = r2.getNavigationBarColor()
            if (r2 == 0) goto L_0x001f
            int r2 = r2.intValue()
            goto L_0x0023
        L_0x001f:
            int r2 = r3.getNavigationBarColor()
        L_0x0023:
            com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda1 r0 = new com.swmansion.rnscreens.ScreenWindowTraits$$ExternalSyntheticLambda1
            r0.<init>(r3, r2)
            com.facebook.react.bridge.UiThreadUtil.runOnUiThread(r0)
            r3.setNavigationBarColor(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setNavigationBarColor$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity):void");
    }

    /* access modifiers changed from: private */
    public static final void setNavigationBarColor$lambda$2(Window window, int i) {
        new WindowInsetsControllerCompat(window, window.getDecorView()).setAppearanceLightNavigationBars(INSTANCE.isColorLight(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0014, code lost:
        r2 = r2.isNavigationBarTranslucent();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setNavigationBarTranslucent$react_native_screens_release(com.swmansion.rnscreens.Screen r2, android.app.Activity r3) {
        /*
            r1 = this;
            java.lang.String r0 = "screen"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            android.view.Window r3 = r3.getWindow()
            com.swmansion.rnscreens.Screen$WindowTraits r0 = com.swmansion.rnscreens.Screen.WindowTraits.NAVIGATION_BAR_TRANSLUCENT
            com.swmansion.rnscreens.Screen r2 = r1.findScreenForTrait(r2, r0)
            if (r2 == 0) goto L_0x001f
            java.lang.Boolean r2 = r2.isNavigationBarTranslucent()
            if (r2 == 0) goto L_0x001f
            boolean r2 = r2.booleanValue()
            goto L_0x0020
        L_0x001f:
            r2 = 0
        L_0x0020:
            r2 = r2 ^ 1
            androidx.core.view.WindowCompat.setDecorFitsSystemWindows(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.swmansion.rnscreens.ScreenWindowTraits.setNavigationBarTranslucent$react_native_screens_release(com.swmansion.rnscreens.Screen, android.app.Activity):void");
    }

    public final void setNavigationBarHidden$react_native_screens_release(Screen screen, Activity activity) {
        Boolean isNavigationBarHidden;
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (activity != null) {
            Window window = activity.getWindow();
            Screen findScreenForTrait = findScreenForTrait(screen, Screen.WindowTraits.NAVIGATION_BAR_HIDDEN);
            if (findScreenForTrait == null || (isNavigationBarHidden = findScreenForTrait.isNavigationBarHidden()) == null || !isNavigationBarHidden.booleanValue()) {
                new WindowInsetsControllerCompat(window, window.getDecorView()).show(WindowInsetsCompat.Type.navigationBars());
                return;
            }
            WindowInsetsControllerCompat windowInsetsControllerCompat = new WindowInsetsControllerCompat(window, window.getDecorView());
            windowInsetsControllerCompat.hide(WindowInsetsCompat.Type.navigationBars());
            windowInsetsControllerCompat.setSystemBarsBehavior(2);
        }
    }

    public final void trySetWindowTraits$react_native_screens_release(Screen screen, Activity activity, ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(screen, "screen");
        if (didSetOrientation) {
            setOrientation$react_native_screens_release(screen, activity);
        }
        if (didSetStatusBarAppearance) {
            setColor$react_native_screens_release(screen, activity, reactContext);
            setStyle$react_native_screens_release(screen, activity, reactContext);
            setTranslucent$react_native_screens_release(screen, activity, reactContext);
            setHidden$react_native_screens_release(screen, activity);
        }
        if (didSetNavigationBarAppearance) {
            setNavigationBarColor$react_native_screens_release(screen, activity);
            setNavigationBarTranslucent$react_native_screens_release(screen, activity);
            setNavigationBarHidden$react_native_screens_release(screen, activity);
        }
    }

    private final Screen findScreenForTrait(Screen screen, Screen.WindowTraits windowTraits) {
        Screen childScreenWithTraitSet = childScreenWithTraitSet(screen, windowTraits);
        if (childScreenWithTraitSet != null) {
            return childScreenWithTraitSet;
        }
        return checkTraitForScreen(screen, windowTraits) ? screen : findParentWithTraitSet(screen, windowTraits);
    }

    private final Screen findParentWithTraitSet(Screen screen, Screen.WindowTraits windowTraits) {
        for (ViewParent container = screen.getContainer(); container != null; container = container.getParent()) {
            if (container instanceof Screen) {
                Screen screen2 = (Screen) container;
                if (checkTraitForScreen(screen2, windowTraits)) {
                    return screen2;
                }
            }
        }
        return null;
    }

    private final Screen childScreenWithTraitSet(Screen screen, Screen.WindowTraits windowTraits) {
        ScreenFragmentWrapper fragmentWrapper;
        if (screen == null || (fragmentWrapper = screen.getFragmentWrapper()) == null) {
            return null;
        }
        for (ScreenContainer topScreen : fragmentWrapper.getChildScreenContainers()) {
            Screen topScreen2 = topScreen.getTopScreen();
            ScreenWindowTraits screenWindowTraits = INSTANCE;
            Screen childScreenWithTraitSet = screenWindowTraits.childScreenWithTraitSet(topScreen2, windowTraits);
            if (childScreenWithTraitSet != null) {
                return childScreenWithTraitSet;
            }
            if (topScreen2 != null && screenWindowTraits.checkTraitForScreen(topScreen2, windowTraits)) {
                return topScreen2;
            }
        }
        return null;
    }

    private final boolean checkTraitForScreen(Screen screen, Screen.WindowTraits windowTraits) {
        switch (WhenMappings.$EnumSwitchMapping$0[windowTraits.ordinal()]) {
            case 1:
                if (screen.getScreenOrientation() != null) {
                    return true;
                }
                break;
            case 2:
                if (screen.getStatusBarColor() != null) {
                    return true;
                }
                break;
            case 3:
                if (screen.getStatusBarStyle() != null) {
                    return true;
                }
                break;
            case 4:
                if (screen.isStatusBarTranslucent() != null) {
                    return true;
                }
                break;
            case 5:
                if (screen.isStatusBarHidden() != null) {
                    return true;
                }
                break;
            case 6:
                if (screen.isStatusBarAnimated() != null) {
                    return true;
                }
                break;
            case 7:
                if (screen.getNavigationBarColor() != null) {
                    return true;
                }
                break;
            case 8:
                if (screen.isNavigationBarTranslucent() != null) {
                    return true;
                }
                break;
            case 9:
                if (screen.isNavigationBarHidden() != null) {
                    return true;
                }
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return false;
    }

    private final boolean isColorLight(int i) {
        return ((double) 1) - ((((((double) Color.red(i)) * 0.299d) + (((double) Color.green(i)) * 0.587d)) + (((double) Color.blue(i)) * 0.114d)) / ((double) 255)) < 0.5d;
    }
}
