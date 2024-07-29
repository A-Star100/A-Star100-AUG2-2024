package com.facebook.react.defaults;

import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.config.ReactFeatureFlags;
import com.facebook.react.internal.featureflags.ReactNativeFeatureFlags;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J&\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u0012\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0007R\u001a\u0010\u0003\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u0007R\u000e\u0010\u000e\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u00048FX\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/facebook/react/defaults/DefaultNewArchitectureEntryPoint;", "", "()V", "bridgelessEnabled", "", "getBridgelessEnabled$annotations", "getBridgelessEnabled", "()Z", "concurrentReactEnabled", "getConcurrentReactEnabled$annotations", "getConcurrentReactEnabled", "fabricEnabled", "getFabricEnabled$annotations", "getFabricEnabled", "privateBridgelessEnabled", "privateConcurrentReactEnabled", "privateFabricEnabled", "privateTurboModulesEnabled", "turboModulesEnabled", "getTurboModulesEnabled$annotations", "getTurboModulesEnabled", "isConfigurationValid", "Lkotlin/Pair;", "", "load", "", "ReactAndroid_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DefaultNewArchitectureEntryPoint.kt */
public final class DefaultNewArchitectureEntryPoint {
    public static final DefaultNewArchitectureEntryPoint INSTANCE = new DefaultNewArchitectureEntryPoint();
    private static boolean privateBridgelessEnabled;
    private static boolean privateConcurrentReactEnabled;
    private static boolean privateFabricEnabled;
    private static boolean privateTurboModulesEnabled;

    public static final boolean getBridgelessEnabled() {
        return privateBridgelessEnabled;
    }

    @JvmStatic
    public static /* synthetic */ void getBridgelessEnabled$annotations() {
    }

    public static final boolean getConcurrentReactEnabled() {
        return privateConcurrentReactEnabled;
    }

    @JvmStatic
    public static /* synthetic */ void getConcurrentReactEnabled$annotations() {
    }

    public static final boolean getFabricEnabled() {
        return privateFabricEnabled;
    }

    @JvmStatic
    public static /* synthetic */ void getFabricEnabled$annotations() {
    }

    public static final boolean getTurboModulesEnabled() {
        return privateTurboModulesEnabled;
    }

    @JvmStatic
    public static /* synthetic */ void getTurboModulesEnabled$annotations() {
    }

    @JvmStatic
    public static final void load() {
        load$default(false, false, false, 7, (Object) null);
    }

    @JvmStatic
    public static final void load(boolean z) {
        load$default(z, false, false, 6, (Object) null);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2) {
        load$default(z, z2, false, 4, (Object) null);
    }

    private DefaultNewArchitectureEntryPoint() {
    }

    public static /* synthetic */ void load$default(boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            z2 = true;
        }
        if ((i & 4) != 0) {
            z3 = true;
        }
        load(z, z2, z3);
    }

    @JvmStatic
    public static final void load(boolean z, boolean z2, boolean z3) {
        Pair<Boolean, String> isConfigurationValid = INSTANCE.isConfigurationValid(z, z2, z3);
        boolean booleanValue = isConfigurationValid.component1().booleanValue();
        String component2 = isConfigurationValid.component2();
        if (booleanValue) {
            ReactFeatureFlags.useTurboModules = z;
            ReactFeatureFlags.enableFabricRenderer = z2;
            ReactFeatureFlags.unstable_useFabricInterop = z2;
            ReactFeatureFlags.enableBridgelessArchitecture = z3;
            ReactFeatureFlags.useNativeViewConfigsInBridgelessMode = z2 && z3;
            ReactFeatureFlags.unstable_useTurboModuleInterop = z3;
            ReactFeatureFlags.enableFabricPendingEventQueue = z2;
            if (z3) {
                ReactNativeFeatureFlags.override(new DefaultNewArchitectureEntryPoint$load$1());
            }
            privateFabricEnabled = z2;
            privateTurboModulesEnabled = z;
            privateConcurrentReactEnabled = z2;
            privateBridgelessEnabled = z3;
            DefaultSoLoader.Companion.maybeLoadSoLibrary();
            return;
        }
        throw new IllegalStateException(component2.toString());
    }

    @VisibleForTesting
    public final Pair<Boolean, String> isConfigurationValid(boolean z, boolean z2, boolean z3) {
        if (z2 && !z) {
            return TuplesKt.to(false, "fabricEnabled=true requires turboModulesEnabled=true (is now false) - Please update your DefaultNewArchitectureEntryPoint.load() parameters.");
        }
        if (!z3 || (z && z2)) {
            return TuplesKt.to(true, "");
        }
        return TuplesKt.to(false, "bridgelessEnabled=true requires (turboModulesEnabled=true AND fabricEnabled=true) - Please update your DefaultNewArchitectureEntryPoint.load() parameters.");
    }
}
