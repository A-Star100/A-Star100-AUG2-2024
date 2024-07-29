package expo.modules.sensors;

import android.hardware.SensorEvent;
import android.os.Bundle;
import expo.modules.core.ModuleRegistry;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
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
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aD\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0000\u001aI\u0010\r\u001a\u00020\f\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\u0011H\bø\u0001\u0000\u001a \u0010\u0017\u001a\u0002H\u000e\"\n\b\u0000\u0010\u000e\u0018\u0001*\u00020\u000f*\u0004\u0018\u00010\u0018H\b¢\u0006\u0002\u0010\u0019*B\b\u0000\u0010\u001a\"\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00010\u00112\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00010\u0011*\u0018\b\u0000\u0010\u001c\"\b\u0012\u0004\u0012\u00020\u000f0\n2\b\u0012\u0004\u0012\u00020\u000f0\n\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"UseSensorProxy", "", "Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "sensorType", "", "eventName", "", "listenerDecorator", "Lkotlin/Function0;", "sensorProxyGetter", "Lexpo/modules/sensors/SensorProxy;", "createSensorProxy", "T", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "eventMapper", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "Lkotlin/ParameterName;", "name", "sensorEvent", "Landroid/os/Bundle;", "getServiceInterface", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "OnNewEvent", "event", "SensorServiceFactory", "expo-sensors_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorProxy.kt */
public final class SensorProxyKt {
    public static /* synthetic */ void UseSensorProxy$default(ModuleDefinitionBuilder moduleDefinitionBuilder, Module module, int i, String str, Function0 function0, Function0 function02, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            function0 = null;
        }
        UseSensorProxy(moduleDefinitionBuilder, module, i, str, function0, function02);
    }

    public static final void UseSensorProxy(ModuleDefinitionBuilder moduleDefinitionBuilder, Module module, int i, String str, Function0<Unit> function0, Function0<SensorProxy> function02) {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunction4;
        AsyncFunction asyncFunctionComponent;
        AsyncFunction asyncFunctionComponent2;
        AsyncFunction asyncFunctionComponent3;
        Intrinsics.checkNotNullParameter(moduleDefinitionBuilder, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(function02, "sensorProxyGetter");
        moduleDefinitionBuilder.Events(str);
        ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
        if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
            asyncFunction = new AsyncFunctionWithPromiseComponent("startObserving", new AnyType[0], new SensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$1(function0, function02));
        } else {
            Class<String> cls = String.class;
            AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, SensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$2.INSTANCE))};
            Function1 sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3 = new SensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3(function0, function02);
            Class<Unit> cls2 = Unit.class;
            if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                asyncFunctionComponent3 = new IntAsyncFunctionComponent("startObserving", anyTypeArr, sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                asyncFunctionComponent3 = new BoolAsyncFunctionComponent("startObserving", anyTypeArr, sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                asyncFunctionComponent3 = new DoubleAsyncFunctionComponent("startObserving", anyTypeArr, sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                asyncFunctionComponent3 = new FloatAsyncFunctionComponent("startObserving", anyTypeArr, sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3);
            } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                asyncFunctionComponent3 = new StringAsyncFunctionComponent("startObserving", anyTypeArr, sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3);
            } else {
                asyncFunctionComponent3 = new AsyncFunctionComponent("startObserving", anyTypeArr, sensorProxyKt$UseSensorProxy$$inlined$OnStartObserving$3);
            }
            asyncFunction = asyncFunctionComponent3;
        }
        objectDefinitionBuilder.getAsyncFunctions().put("startObserving", asyncFunction);
        if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
            asyncFunction2 = new AsyncFunctionWithPromiseComponent("stopObserving", new AnyType[0], new SensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$1(function0, function02));
        } else {
            Class<String> cls3 = String.class;
            AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, SensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$2.INSTANCE))};
            Function1 sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3 = new SensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3(function0, function02);
            Class<Unit> cls4 = Unit.class;
            if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                asyncFunctionComponent2 = new IntAsyncFunctionComponent("stopObserving", anyTypeArr2, sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                asyncFunctionComponent2 = new BoolAsyncFunctionComponent("stopObserving", anyTypeArr2, sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("stopObserving", anyTypeArr2, sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                asyncFunctionComponent2 = new FloatAsyncFunctionComponent("stopObserving", anyTypeArr2, sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3);
            } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                asyncFunctionComponent2 = new StringAsyncFunctionComponent("stopObserving", anyTypeArr2, sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3);
            } else {
                asyncFunctionComponent2 = new AsyncFunctionComponent("stopObserving", anyTypeArr2, sensorProxyKt$UseSensorProxy$$inlined$OnStopObserving$3);
            }
            asyncFunction2 = asyncFunctionComponent2;
        }
        objectDefinitionBuilder.getAsyncFunctions().put("stopObserving", asyncFunction2);
        moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new SensorProxyKt$UseSensorProxy$$inlined$OnActivityEntersForeground$1(function02)));
        moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new SensorProxyKt$UseSensorProxy$$inlined$OnActivityEntersBackground$1(function02)));
        moduleDefinitionBuilder.getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new SensorProxyKt$UseSensorProxy$$inlined$OnActivityDestroys$1(function02)));
        moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new SensorProxyKt$UseSensorProxy$$inlined$OnDestroy$1(function02)));
        if (Intrinsics.areEqual((Object) Integer.class, (Object) Promise.class)) {
            asyncFunction3 = new AsyncFunctionWithPromiseComponent("setUpdateInterval", new AnyType[0], new SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$1(function02));
        } else {
            Class<Integer> cls5 = Integer.class;
            AnyType[] anyTypeArr3 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$2.INSTANCE))};
            Function1 sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3 = new SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3(function02);
            Class<Unit> cls6 = Unit.class;
            if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
                asyncFunctionComponent = new IntAsyncFunctionComponent("setUpdateInterval", anyTypeArr3, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
                asyncFunctionComponent = new BoolAsyncFunctionComponent("setUpdateInterval", anyTypeArr3, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
                asyncFunctionComponent = new DoubleAsyncFunctionComponent("setUpdateInterval", anyTypeArr3, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
                asyncFunctionComponent = new FloatAsyncFunctionComponent("setUpdateInterval", anyTypeArr3, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
                asyncFunctionComponent = new StringAsyncFunctionComponent("setUpdateInterval", anyTypeArr3, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3);
            } else {
                asyncFunctionComponent = new AsyncFunctionComponent("setUpdateInterval", anyTypeArr3, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$3);
            }
            asyncFunction3 = asyncFunctionComponent;
        }
        objectDefinitionBuilder.getAsyncFunctions().put("setUpdateInterval", asyncFunction3);
        AnyType[] anyTypeArr4 = new AnyType[0];
        Function1 sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4 = new SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4(module, i);
        Class<Boolean> cls7 = Boolean.class;
        if (Intrinsics.areEqual((Object) cls7, (Object) Integer.TYPE)) {
            asyncFunction4 = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Boolean.TYPE)) {
            asyncFunction4 = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Double.TYPE)) {
            asyncFunction4 = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) Float.TYPE)) {
            asyncFunction4 = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4);
        } else if (Intrinsics.areEqual((Object) cls7, (Object) String.class)) {
            asyncFunction4 = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr4, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4);
        } else {
            asyncFunction4 = new AsyncFunctionComponent("isAvailableAsync", anyTypeArr4, sensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4);
        }
        objectDefinitionBuilder.getAsyncFunctions().put("isAvailableAsync", asyncFunction4);
    }

    public static final /* synthetic */ <T extends SensorServiceInterface> SensorProxy createSensorProxy(Module module, String str, Function1<? super SensorEvent, Bundle> function1) {
        Intrinsics.checkNotNullParameter(module, "<this>");
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(function1, "eventMapper");
        WeakReference weakReference = new WeakReference(module);
        Intrinsics.needClassReification();
        return new SensorProxy(new SensorProxyKt$createSensorProxy$serviceFactory$1(weakReference), new SensorProxyKt$createSensorProxy$onNewEvent$1(weakReference, str, function1));
    }

    public static final /* synthetic */ <T extends SensorServiceInterface> T getServiceInterface(AppContext appContext) {
        T t;
        if (appContext != null) {
            try {
                ModuleRegistry legacyModuleRegistry = appContext.getLegacyModuleRegistry();
                Intrinsics.reifiedOperationMarker(4, "T");
                Class cls = Object.class;
                Class cls2 = cls;
                t = legacyModuleRegistry.getModule(cls);
            } catch (Exception unused) {
                t = null;
            }
            T t2 = (SensorServiceInterface) t;
            if (t2 != null) {
                SensorServiceInterface sensorServiceInterface = (SensorServiceInterface) t2;
                return t2;
            }
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(SensorServiceInterface.class));
    }
}
