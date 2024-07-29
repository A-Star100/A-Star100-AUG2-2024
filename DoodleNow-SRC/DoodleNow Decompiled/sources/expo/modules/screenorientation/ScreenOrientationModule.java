package expo.modules.screenorientation;

import android.app.Activity;
import android.graphics.Insets;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.tracing.Trace;
import com.rnfs.Downloader$$ExternalSyntheticApiModelOutline0;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.screenorientation.enums.Orientation;
import expo.modules.screenorientation.enums.OrientationAttr;
import expo.modules.screenorientation.enums.OrientationLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\tH\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8BX\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u001f"}, d2 = {"Lexpo/modules/screenorientation/ScreenOrientationModule;", "Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "()V", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "initialOrientation", "", "Ljava/lang/Integer;", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "getUiManager", "()Lexpo/modules/core/interfaces/services/UIManager;", "weakCurrentActivity", "getWeakCurrentActivity", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getScreenOrientation", "Lexpo/modules/screenorientation/enums/Orientation;", "activity", "isPortraitNaturalOrientation", "", "rotation", "width", "height", "onHostDestroy", "", "onHostPause", "onHostResume", "expo-screen-orientation_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ScreenOrientationModule.kt */
public final class ScreenOrientationModule extends Module implements LifecycleEventListener {
    /* access modifiers changed from: private */
    public Integer initialOrientation;

    private final boolean isPortraitNaturalOrientation(int i, int i2, int i3) {
        if ((i == 0 || i == 2) && i3 > i2) {
            return true;
        }
        return (i == 1 || i == 3) && i2 > i3;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    /* access modifiers changed from: private */
    public final Activity getWeakCurrentActivity() {
        ActivityProvider activityProvider = getAppContext().getActivityProvider();
        if (activityProvider != null) {
            return activityProvider.getCurrentActivity();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public final Activity getCurrentActivity() {
        Activity weakCurrentActivity = getWeakCurrentActivity();
        if (weakCurrentActivity != null) {
            return weakCurrentActivity;
        }
        throw new Exceptions.MissingActivity();
    }

    /* access modifiers changed from: private */
    public final UIManager getUiManager() {
        UIManager uIManager = (UIManager) getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
        if (uIManager != null) {
            return uIManager;
        }
        throw new IllegalStateException("Could not find implementation for UIManager.");
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunction4;
        AsyncFunction asyncFunction5;
        AsyncFunction asyncFunction6;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        AsyncFunction asyncFunctionComponent3;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoScreenOrientation");
            moduleDefinitionBuilder.Events("expoDidUpdateDimensions");
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) OrientationLock.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("lockAsync", new AnyType[0], new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$1(this));
            } else {
                Class<OrientationLock> cls = OrientationLock.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OrientationLock.class), false, ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3 = new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3(this);
                Class<Unit> cls2 = Unit.class;
                if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                    asyncFunctionComponent3 = new IntAsyncFunctionComponent("lockAsync", anyTypeArr, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent3 = new BoolAsyncFunctionComponent("lockAsync", anyTypeArr, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                    asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("lockAsync", anyTypeArr, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                    asyncFunctionComponent3 = new FloatAsyncFunctionComponent("lockAsync", anyTypeArr, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                    asyncFunctionComponent3 = new StringAsyncFunctionComponent("lockAsync", anyTypeArr, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent3 = new AsyncFunctionComponent("lockAsync", anyTypeArr, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent3;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("lockAsync", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) OrientationAttr.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("lockPlatformAsync", new AnyType[0], new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$4(this));
            } else {
                Class<OrientationAttr> cls3 = OrientationAttr.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(OrientationAttr.class), false, ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$5.INSTANCE))};
                Function1 screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6 = new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6(this);
                Class<Unit> cls4 = Unit.class;
                if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("lockPlatformAsync", anyTypeArr2, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$6);
                }
                asyncFunction2 = asyncFunctionComponent2;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("lockPlatformAsync", asyncFunction2);
            ObjectDefinitionBuilder objectDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1 screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7 = new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7(this);
            Class<Integer> cls5 = Integer.class;
            if (Intrinsics.areEqual((Object) cls5, (Object) Integer.TYPE)) {
                asyncFunction3 = new IntAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls5, (Object) Boolean.TYPE)) {
                asyncFunction3 = new BoolAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls5, (Object) Double.TYPE)) {
                asyncFunction3 = new DoubleAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls5, (Object) Float.TYPE)) {
                asyncFunction3 = new FloatAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7);
            } else if (Intrinsics.areEqual((Object) cls5, (Object) String.class)) {
                asyncFunction3 = new StringAsyncFunctionComponent("getOrientationAsync", anyTypeArr3, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7);
            } else {
                asyncFunction3 = new AsyncFunctionComponent("getOrientationAsync", anyTypeArr3, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$7);
            }
            objectDefinitionBuilder3.getAsyncFunctions().put("getOrientationAsync", asyncFunction3);
            ObjectDefinitionBuilder objectDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr4 = new AnyType[0];
            Function1 screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8 = new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8(this);
            Class<OrientationLock> cls6 = OrientationLock.class;
            if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
                asyncFunction4 = new IntAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
                asyncFunction4 = new BoolAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
                asyncFunction4 = new DoubleAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
                asyncFunction4 = new FloatAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
                asyncFunction4 = new StringAsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8);
            } else {
                asyncFunction4 = new AsyncFunctionComponent("getOrientationLockAsync", anyTypeArr4, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$8);
            }
            objectDefinitionBuilder4.getAsyncFunctions().put("getOrientationLockAsync", asyncFunction4);
            ObjectDefinitionBuilder objectDefinitionBuilder5 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr5 = new AnyType[0];
            Function1 screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9 = new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9(this);
            Class<Integer> cls7 = Integer.class;
            if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
                asyncFunction5 = new IntAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
                asyncFunction5 = new BoolAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
                asyncFunction5 = new DoubleAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
                asyncFunction5 = new FloatAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
                asyncFunction5 = new StringAsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9);
            } else {
                asyncFunction5 = new AsyncFunctionComponent("getPlatformOrientationLockAsync", anyTypeArr5, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$9);
            }
            objectDefinitionBuilder5.getAsyncFunctions().put("getPlatformOrientationLockAsync", asyncFunction5);
            ObjectDefinitionBuilder objectDefinitionBuilder6 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Integer.class, (Object) Promise.class)) {
                asyncFunction6 = new AsyncFunctionWithPromiseComponent("supportsOrientationLockAsync", new AnyType[0], new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$10());
            } else {
                Class<Integer> cls8 = Integer.class;
                AnyType[] anyTypeArr6 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$11.INSTANCE))};
                Function1 screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12 = new ScreenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12();
                Class<Boolean> cls9 = Boolean.class;
                if (Intrinsics.areEqual((Object) cls9, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12);
                } else if (Intrinsics.areEqual((Object) cls9, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("supportsOrientationLockAsync", anyTypeArr6, screenOrientationModule$definition$lambda$9$$inlined$AsyncFunction$12);
                }
                asyncFunction6 = asyncFunctionComponent;
            }
            objectDefinitionBuilder6.getAsyncFunctions().put("supportsOrientationLockAsync", asyncFunction6);
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new ScreenOrientationModule$definition$lambda$9$$inlined$OnCreate$1(this)));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new ScreenOrientationModule$definition$lambda$9$$inlined$OnDestroy$1(this)));
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public void onHostResume() {
        Integer num = this.initialOrientation;
        if (num == null) {
            Activity weakCurrentActivity = getWeakCurrentActivity();
            num = weakCurrentActivity != null ? Integer.valueOf(weakCurrentActivity.getRequestedOrientation()) : null;
        }
        this.initialOrientation = num;
    }

    /* access modifiers changed from: private */
    public final Orientation getScreenOrientation(Activity activity) {
        int i;
        DisplayMetrics displayMetrics;
        WindowManager windowManager = activity.getWindowManager();
        if (windowManager == null) {
            return Orientation.UNKNOWN;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Display m = getCurrentActivity().getWindow().getContext().getDisplay();
            if (m == null) {
                return Orientation.UNKNOWN;
            }
            i = m.getRotation();
        } else {
            i = windowManager.getDefaultDisplay().getRotation();
        }
        if (Build.VERSION.SDK_INT >= 30) {
            WindowMetrics m2 = windowManager.getCurrentWindowMetrics();
            Intrinsics.checkNotNullExpressionValue(m2, "getCurrentWindowMetrics(...)");
            Insets m$1 = Downloader$$ExternalSyntheticApiModelOutline0.m(m2).getInsetsIgnoringVisibility(Downloader$$ExternalSyntheticApiModelOutline0.m());
            Intrinsics.checkNotNullExpressionValue(m$1, "getInsetsIgnoringVisibility(...)");
            displayMetrics = new DisplayMetrics();
            displayMetrics.widthPixels = (Downloader$$ExternalSyntheticApiModelOutline0.m(m2).width() - m$1.left) - m$1.right;
            displayMetrics.heightPixels = (Downloader$$ExternalSyntheticApiModelOutline0.m(m2).height() - m$1.top) - m$1.bottom;
        } else {
            displayMetrics = new DisplayMetrics();
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Intrinsics.checkNotNullExpressionValue(defaultDisplay, "getDefaultDisplay(...)");
            defaultDisplay.getMetrics(displayMetrics);
        }
        if (isPortraitNaturalOrientation(i, displayMetrics.widthPixels, displayMetrics.heightPixels)) {
            if (i == 0) {
                return Orientation.PORTRAIT_UP;
            }
            if (i == 1) {
                return Orientation.LANDSCAPE_RIGHT;
            }
            if (i == 2) {
                return Orientation.PORTRAIT_DOWN;
            }
            if (i != 3) {
                return Orientation.UNKNOWN;
            }
            return Orientation.LANDSCAPE_LEFT;
        } else if (i == 0) {
            return Orientation.LANDSCAPE_RIGHT;
        } else {
            if (i == 1) {
                return Orientation.PORTRAIT_DOWN;
            }
            if (i == 2) {
                return Orientation.LANDSCAPE_LEFT;
            }
            if (i != 3) {
                return Orientation.UNKNOWN;
            }
            return Orientation.PORTRAIT_UP;
        }
    }
}
