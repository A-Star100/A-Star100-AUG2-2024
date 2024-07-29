package expo.modules.splashscreen;

import androidx.tracing.Trace;
import expo.modules.kotlin.Promise;
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
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-splash-screen_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SplashScreenModule.kt */
public final class SplashScreenModule extends Module {
    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExpoSplashScreen");
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("preventAutoHideAsync", new AnyType[0], new SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$1(this, moduleDefinitionBuilder));
            } else {
                Class<Promise> cls = Promise.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3 = new SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3(this, moduleDefinitionBuilder);
                Class<Unit> cls2 = Unit.class;
                if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("preventAutoHideAsync", anyTypeArr, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent2;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("preventAutoHideAsync", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("hideAsync", new AnyType[0], new SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$4(this, moduleDefinitionBuilder));
            } else {
                Class<Promise> cls3 = Promise.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$5.INSTANCE))};
                Function1 splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6 = new SplashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6(this, moduleDefinitionBuilder);
                Class<Unit> cls4 = Unit.class;
                if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("hideAsync", anyTypeArr2, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("hideAsync", anyTypeArr2, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("hideAsync", anyTypeArr2, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("hideAsync", anyTypeArr2, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("hideAsync", anyTypeArr2, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("hideAsync", anyTypeArr2, splashScreenModule$definition$lambda$6$$inlined$AsyncFunction$6);
                }
                asyncFunction2 = asyncFunctionComponent;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("hideAsync", asyncFunction2);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
