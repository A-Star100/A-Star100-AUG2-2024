package expo.modules.sensors.modules;

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
import expo.modules.sensors.SensorProxy;
import expo.modules.sensors.SensorProxyKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0004\n\u0002\u0010\u000b¨\u0006\u000e"}, d2 = {"Lexpo/modules/sensors/modules/PedometerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "sensorProxy", "Lexpo/modules/sensors/SensorProxy;", "getSensorProxy", "()Lexpo/modules/sensors/SensorProxy;", "sensorProxy$delegate", "Lkotlin/Lazy;", "stepsAtTheBeginning", "", "Ljava/lang/Integer;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PedometerModule.kt */
public final class PedometerModule extends Module {
    private final Lazy sensorProxy$delegate = LazyKt.lazy(new PedometerModule$sensorProxy$2(this));
    /* access modifiers changed from: private */
    public Integer stepsAtTheBeginning;

    /* access modifiers changed from: private */
    public final SensorProxy getSensorProxy() {
        return (SensorProxy) this.sensorProxy$delegate.getValue();
    }

    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExponentPedometer");
            SensorProxyKt.UseSensorProxy(moduleDefinitionBuilder, this, 19, "Exponent.pedometerUpdate", new PedometerModule$definition$1$1(this), new PedometerModule$definition$1$2(this));
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new PedometerModule$definition$lambda$3$$inlined$AsyncFunction$1(this));
            } else {
                Class<Promise> cls = Promise.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, PedometerModule$definition$lambda$3$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3 = new PedometerModule$definition$lambda$3$$inlined$AsyncFunction$3(this);
                Class<Unit> cls2 = Unit.class;
                if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("getPermissionsAsync", anyTypeArr, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("getPermissionsAsync", anyTypeArr, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent2;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("getPermissionsAsync", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Promise.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new PedometerModule$definition$lambda$3$$inlined$AsyncFunction$4(this));
            } else {
                Class<Promise> cls3 = Promise.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Promise.class), false, PedometerModule$definition$lambda$3$$inlined$AsyncFunction$5.INSTANCE))};
                Function1 pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6 = new PedometerModule$definition$lambda$3$$inlined$AsyncFunction$6(this);
                Class<Unit> cls4 = Unit.class;
                if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("requestPermissionsAsync", anyTypeArr2, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$6);
                }
                asyncFunction2 = asyncFunctionComponent;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("requestPermissionsAsync", asyncFunction2);
            ObjectDefinitionBuilder objectDefinitionBuilder3 = moduleDefinitionBuilder;
            Class<Integer> cls5 = Integer.class;
            Class<Integer> cls6 = Integer.class;
            AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, PedometerModule$definition$lambda$3$$inlined$AsyncFunction$7.INSTANCE)), new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, PedometerModule$definition$lambda$3$$inlined$AsyncFunction$8.INSTANCE))};
            Function1 pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9 = new PedometerModule$definition$lambda$3$$inlined$AsyncFunction$9();
            Class<Unit> cls7 = Unit.class;
            if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
                asyncFunction3 = new IntAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
                asyncFunction3 = new BoolAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
                asyncFunction3 = new DoubleAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
                asyncFunction3 = new FloatAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9);
            } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
                asyncFunction3 = new StringAsyncFunctionComponent("getStepCountAsync", anyTypeArr3, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9);
            } else {
                asyncFunction3 = new AsyncFunctionComponent("getStepCountAsync", anyTypeArr3, pedometerModule$definition$lambda$3$$inlined$AsyncFunction$9);
            }
            objectDefinitionBuilder3.getAsyncFunctions().put("getStepCountAsync", asyncFunction3);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
