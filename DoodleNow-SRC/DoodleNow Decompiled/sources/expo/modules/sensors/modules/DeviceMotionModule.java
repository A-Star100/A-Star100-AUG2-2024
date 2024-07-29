package expo.modules.sensors.modules;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.view.Choreographer;
import android.view.Display;
import android.view.WindowManager;
import androidx.tracing.Trace;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.react.uimanager.ViewProps;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import expo.modules.interfaces.sensors.services.AccelerometerServiceInterface;
import expo.modules.interfaces.sensors.services.GravitySensorServiceInterface;
import expo.modules.interfaces.sensors.services.GyroscopeServiceInterface;
import expo.modules.interfaces.sensors.services.LinearAccelerationSensorServiceInterface;
import expo.modules.interfaces.sensors.services.RotationVectorSensorServiceInterface;
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
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.sensors.ServiceNotFoundException;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002:\u0002-.B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0016\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u001fH\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020&2\u0006\u0010,\u001a\u00020\u0005H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nR\u00020\u0000X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule;", "Lexpo/modules/kotlin/modules/Module;", "Landroid/hardware/SensorEventListener2;", "()V", "accelerationEvent", "Landroid/hardware/SensorEvent;", "accelerationIncludingGravityEvent", "currentFrameCallback", "Lexpo/modules/sensors/modules/DeviceMotionModule$ScheduleDispatchFrameCallback;", "dispatchEventRunnable", "Lexpo/modules/sensors/modules/DeviceMotionModule$DispatchEventRunnable;", "gravityEvent", "lastUpdate", "", "rotationEvent", "rotationMatrix", "", "rotationRateEvent", "rotationResult", "serviceSubscriptions", "", "Lexpo/modules/interfaces/sensors/SensorServiceSubscriptionInterface;", "uiManager", "Lexpo/modules/core/interfaces/services/UIManager;", "updateInterval", "", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "eventsToMap", "Landroid/os/Bundle;", "getOrientation", "", "getSensorKernelServices", "", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "appContext", "Lexpo/modules/kotlin/AppContext;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onFlushCompleted", "onSensorChanged", "sensorEvent", "DispatchEventRunnable", "ScheduleDispatchFrameCallback", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceMotionModule.kt */
public final class DeviceMotionModule extends Module implements SensorEventListener2 {
    private SensorEvent accelerationEvent;
    private SensorEvent accelerationIncludingGravityEvent;
    /* access modifiers changed from: private */
    public final ScheduleDispatchFrameCallback currentFrameCallback = new ScheduleDispatchFrameCallback();
    /* access modifiers changed from: private */
    public final DispatchEventRunnable dispatchEventRunnable = new DispatchEventRunnable(this, new WeakReference(this));
    private SensorEvent gravityEvent;
    /* access modifiers changed from: private */
    public long lastUpdate;
    private SensorEvent rotationEvent;
    private final float[] rotationMatrix = new float[9];
    private SensorEvent rotationRateEvent;
    private final float[] rotationResult = new float[3];
    /* access modifiers changed from: private */
    public List<SensorServiceSubscriptionInterface> serviceSubscriptions;
    /* access modifiers changed from: private */
    public UIManager uiManager;
    /* access modifiers changed from: private */
    public float updateInterval = 0.016666668f;

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
    }

    public void onFlushCompleted(Sensor sensor) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
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
            moduleDefinitionBuilder.Name("ExponentDeviceMotion");
            moduleDefinitionBuilder.Events("deviceMotionDidUpdate");
            moduleDefinitionBuilder.Constants((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("Gravity", Float.valueOf(9.80665f))});
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new DeviceMotionModule$definition$lambda$6$$inlined$OnCreate$1(this)));
            ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) Float.class, (Object) Promise.class)) {
                asyncFunction = new AsyncFunctionWithPromiseComponent("setUpdateInterval", new AnyType[0], new DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$1(this));
            } else {
                Class<Float> cls = Float.class;
                AnyType[] anyTypeArr = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Float.class), false, DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$2.INSTANCE))};
                Function1 deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3 = new DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3(this);
                Class<Unit> cls2 = Unit.class;
                if (Intrinsics.areEqual((Object) cls2, (Object) Integer.TYPE)) {
                    asyncFunctionComponent2 = new IntAsyncFunctionComponent("setUpdateInterval", anyTypeArr, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent2 = new BoolAsyncFunctionComponent("setUpdateInterval", anyTypeArr, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Double.TYPE)) {
                    asyncFunctionComponent2 = new DoubleAsyncFunctionComponent("setUpdateInterval", anyTypeArr, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) Float.TYPE)) {
                    asyncFunctionComponent2 = new FloatAsyncFunctionComponent("setUpdateInterval", anyTypeArr, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else if (Intrinsics.areEqual((Object) cls2, (Object) String.class)) {
                    asyncFunctionComponent2 = new StringAsyncFunctionComponent("setUpdateInterval", anyTypeArr, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3);
                } else {
                    asyncFunctionComponent2 = new AsyncFunctionComponent("setUpdateInterval", anyTypeArr, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$3);
                }
                asyncFunction = asyncFunctionComponent2;
            }
            objectDefinitionBuilder.getAsyncFunctions().put("setUpdateInterval", asyncFunction);
            ObjectDefinitionBuilder objectDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual((Object) String.class, (Object) Promise.class)) {
                asyncFunction2 = new AsyncFunctionWithPromiseComponent("startObserving", new AnyType[0], new DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$1(this));
            } else {
                Class<String> cls3 = String.class;
                AnyType[] anyTypeArr2 = {new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$2.INSTANCE))};
                Function1 deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3 = new DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3(this);
                Class<Unit> cls4 = Unit.class;
                if (Intrinsics.areEqual((Object) cls4, (Object) Integer.TYPE)) {
                    asyncFunctionComponent = new IntAsyncFunctionComponent("startObserving", anyTypeArr2, deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Boolean.TYPE)) {
                    asyncFunctionComponent = new BoolAsyncFunctionComponent("startObserving", anyTypeArr2, deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Double.TYPE)) {
                    asyncFunctionComponent = new DoubleAsyncFunctionComponent("startObserving", anyTypeArr2, deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) Float.TYPE)) {
                    asyncFunctionComponent = new FloatAsyncFunctionComponent("startObserving", anyTypeArr2, deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3);
                } else if (Intrinsics.areEqual((Object) cls4, (Object) String.class)) {
                    asyncFunctionComponent = new StringAsyncFunctionComponent("startObserving", anyTypeArr2, deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3);
                } else {
                    asyncFunctionComponent = new AsyncFunctionComponent("startObserving", anyTypeArr2, deviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3);
                }
                asyncFunction2 = asyncFunctionComponent;
            }
            objectDefinitionBuilder2.getAsyncFunctions().put("startObserving", asyncFunction2);
            Class<String> cls5 = String.class;
            AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("stopObserving", new AnyType[]{new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunctionWithPromise$1.INSTANCE))}, new DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunctionWithPromise$2(this));
            moduleDefinitionBuilder.getAsyncFunctions().put("stopObserving", asyncFunctionWithPromiseComponent);
            AsyncFunction asyncFunction4 = asyncFunctionWithPromiseComponent;
            ObjectDefinitionBuilder objectDefinitionBuilder3 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1 deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4 = new DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4(this);
            Class<Boolean> cls6 = Boolean.class;
            if (Intrinsics.areEqual((Object) cls6, (Object) Integer.TYPE)) {
                asyncFunction3 = new IntAsyncFunctionComponent("isAvailableAsync", anyTypeArr3, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Boolean.TYPE)) {
                asyncFunction3 = new BoolAsyncFunctionComponent("isAvailableAsync", anyTypeArr3, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Double.TYPE)) {
                asyncFunction3 = new DoubleAsyncFunctionComponent("isAvailableAsync", anyTypeArr3, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) Float.TYPE)) {
                asyncFunction3 = new FloatAsyncFunctionComponent("isAvailableAsync", anyTypeArr3, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else if (Intrinsics.areEqual((Object) cls6, (Object) String.class)) {
                asyncFunction3 = new StringAsyncFunctionComponent("isAvailableAsync", anyTypeArr3, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4);
            } else {
                asyncFunction3 = new AsyncFunctionComponent("isAvailableAsync", anyTypeArr3, deviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4);
            }
            objectDefinitionBuilder3.getAsyncFunctions().put("isAvailableAsync", asyncFunction3);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        int type = sensorEvent.sensor.getType();
        if (type == 1) {
            this.accelerationIncludingGravityEvent = sensorEvent;
        } else if (type != 4) {
            switch (type) {
                case 9:
                    this.gravityEvent = sensorEvent;
                    break;
                case 10:
                    this.accelerationEvent = sensorEvent;
                    break;
                case 11:
                    this.rotationEvent = sensorEvent;
                    break;
            }
        } else {
            this.rotationRateEvent = sensorEvent;
        }
        this.currentFrameCallback.maybePostFromNonUI();
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0007J\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\u0007H\u0002J\u0006\u0010\r\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$ScheduleDispatchFrameCallback;", "Landroid/view/Choreographer$FrameCallback;", "(Lexpo/modules/sensors/modules/DeviceMotionModule;)V", "mIsPosted", "", "mShouldStop", "doFrame", "", "frameTimeNanos", "", "maybePost", "maybePostFromNonUI", "post", "stop", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceMotionModule.kt */
    private final class ScheduleDispatchFrameCallback implements Choreographer.FrameCallback {
        private volatile boolean mIsPosted;
        private boolean mShouldStop;

        public final void stop() {
            this.mShouldStop = true;
        }

        public ScheduleDispatchFrameCallback() {
        }

        public void doFrame(long j) {
            if (this.mShouldStop) {
                this.mIsPosted = false;
            } else {
                post();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (((float) (currentTimeMillis - DeviceMotionModule.this.lastUpdate)) > DeviceMotionModule.this.updateInterval) {
                UIManager access$getUiManager$p = DeviceMotionModule.this.uiManager;
                if (access$getUiManager$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                    access$getUiManager$p = null;
                }
                access$getUiManager$p.runOnClientCodeQueueThread(DeviceMotionModule.this.dispatchEventRunnable);
                DeviceMotionModule.this.lastUpdate = currentTimeMillis;
            }
        }

        public final void maybePost() {
            if (!this.mIsPosted) {
                this.mIsPosted = true;
                post();
            }
        }

        private final void post() {
            Choreographer.getInstance().postFrameCallback(DeviceMotionModule.this.currentFrameCallback);
        }

        /* access modifiers changed from: private */
        public static final void maybePostFromNonUI$lambda$0(ScheduleDispatchFrameCallback scheduleDispatchFrameCallback) {
            Intrinsics.checkNotNullParameter(scheduleDispatchFrameCallback, "this$0");
            scheduleDispatchFrameCallback.maybePost();
        }

        public final void maybePostFromNonUI() {
            if (!this.mIsPosted) {
                UIManager access$getUiManager$p = DeviceMotionModule.this.uiManager;
                if (access$getUiManager$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("uiManager");
                    access$getUiManager$p = null;
                }
                access$getUiManager$p.runOnUiQueueThread(new DeviceMotionModule$ScheduleDispatchFrameCallback$$ExternalSyntheticLambda0(this));
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lexpo/modules/sensors/modules/DeviceMotionModule$DispatchEventRunnable;", "Ljava/lang/Runnable;", "weakReference", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/sensors/modules/DeviceMotionModule;", "(Lexpo/modules/sensors/modules/DeviceMotionModule;Ljava/lang/ref/WeakReference;)V", "run", "", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DeviceMotionModule.kt */
    private final class DispatchEventRunnable implements Runnable {
        final /* synthetic */ DeviceMotionModule this$0;
        private final WeakReference<DeviceMotionModule> weakReference;

        public DispatchEventRunnable(DeviceMotionModule deviceMotionModule, WeakReference<DeviceMotionModule> weakReference2) {
            Intrinsics.checkNotNullParameter(weakReference2, "weakReference");
            this.this$0 = deviceMotionModule;
            this.weakReference = weakReference2;
        }

        public void run() {
            DeviceMotionModule deviceMotionModule = (DeviceMotionModule) this.weakReference.get();
            if (deviceMotionModule != null) {
                deviceMotionModule.sendEvent("deviceMotionDidUpdate", this.this$0.eventsToMap());
            }
        }
    }

    /* access modifiers changed from: private */
    public final Bundle eventsToMap() {
        Bundle bundle = new Bundle();
        if (this.accelerationEvent != null) {
            Bundle bundle2 = new Bundle();
            SensorEvent sensorEvent = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent);
            bundle2.putDouble("x", (double) sensorEvent.values[0]);
            SensorEvent sensorEvent2 = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent2);
            bundle2.putDouble("y", (double) sensorEvent2.values[1]);
            SensorEvent sensorEvent3 = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent3);
            bundle2.putDouble("z", (double) sensorEvent3.values[2]);
            SensorEvent sensorEvent4 = this.accelerationEvent;
            Intrinsics.checkNotNull(sensorEvent4);
            bundle2.putDouble("timestamp", ((double) sensorEvent4.timestamp) / 1.0E9d);
            Unit unit = Unit.INSTANCE;
            bundle.putBundle("acceleration", bundle2);
        }
        if (!(this.accelerationIncludingGravityEvent == null || this.gravityEvent == null)) {
            Bundle bundle3 = new Bundle();
            SensorEvent sensorEvent5 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent5);
            float f = sensorEvent5.values[0];
            float f2 = (float) 2;
            SensorEvent sensorEvent6 = this.gravityEvent;
            Intrinsics.checkNotNull(sensorEvent6);
            bundle3.putDouble("x", (double) (f - (sensorEvent6.values[0] * f2)));
            SensorEvent sensorEvent7 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent7);
            float f3 = sensorEvent7.values[1];
            SensorEvent sensorEvent8 = this.gravityEvent;
            Intrinsics.checkNotNull(sensorEvent8);
            bundle3.putDouble("y", (double) (f3 - (sensorEvent8.values[1] * f2)));
            SensorEvent sensorEvent9 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent9);
            float f4 = sensorEvent9.values[2];
            SensorEvent sensorEvent10 = this.gravityEvent;
            Intrinsics.checkNotNull(sensorEvent10);
            bundle3.putDouble("z", (double) (f4 - (f2 * sensorEvent10.values[2])));
            SensorEvent sensorEvent11 = this.accelerationIncludingGravityEvent;
            Intrinsics.checkNotNull(sensorEvent11);
            bundle3.putDouble("timestamp", ((double) sensorEvent11.timestamp) / 1.0E9d);
            Unit unit2 = Unit.INSTANCE;
            bundle.putBundle("accelerationIncludingGravity", bundle3);
        }
        if (this.rotationRateEvent != null) {
            Bundle bundle4 = new Bundle();
            SensorEvent sensorEvent12 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent12);
            bundle4.putDouble("alpha", Math.toDegrees((double) sensorEvent12.values[0]));
            SensorEvent sensorEvent13 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent13);
            bundle4.putDouble("beta", Math.toDegrees((double) sensorEvent13.values[1]));
            SensorEvent sensorEvent14 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent14);
            bundle4.putDouble("gamma", Math.toDegrees((double) sensorEvent14.values[2]));
            SensorEvent sensorEvent15 = this.rotationRateEvent;
            Intrinsics.checkNotNull(sensorEvent15);
            bundle4.putDouble("timestamp", ((double) sensorEvent15.timestamp) / 1.0E9d);
            Unit unit3 = Unit.INSTANCE;
            bundle.putBundle("rotationRate", bundle4);
        }
        SensorEvent sensorEvent16 = this.rotationEvent;
        if (sensorEvent16 != null) {
            float[] fArr = this.rotationMatrix;
            Intrinsics.checkNotNull(sensorEvent16);
            SensorManager.getRotationMatrixFromVector(fArr, sensorEvent16.values);
            SensorManager.getOrientation(this.rotationMatrix, this.rotationResult);
            Bundle bundle5 = new Bundle();
            bundle5.putDouble("alpha", (double) (-this.rotationResult[0]));
            bundle5.putDouble("beta", (double) (-this.rotationResult[1]));
            bundle5.putDouble("gamma", (double) this.rotationResult[2]);
            SensorEvent sensorEvent17 = this.rotationEvent;
            Intrinsics.checkNotNull(sensorEvent17);
            bundle5.putDouble("timestamp", ((double) sensorEvent17.timestamp) / 1.0E9d);
            Unit unit4 = Unit.INSTANCE;
            bundle.putBundle(ViewProps.ROTATION, bundle5);
        }
        bundle.putDouble("interval", (double) this.updateInterval);
        bundle.putInt("orientation", getOrientation());
        return bundle;
    }

    private final int getOrientation() {
        Display defaultDisplay;
        Activity currentActivity;
        Display m;
        Context reactContext = getAppContext().getReactContext();
        Integer num = null;
        Object systemService = reactContext != null ? reactContext.getSystemService("window") : null;
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (Build.VERSION.SDK_INT >= 30) {
            ActivityProvider activityProvider = getAppContext().getActivityProvider();
            if (!(activityProvider == null || (currentActivity = activityProvider.getCurrentActivity()) == null || (m = currentActivity.getDisplay()) == null)) {
                num = Integer.valueOf(m.getRotation());
            }
        } else if (!(windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null)) {
            num = Integer.valueOf(defaultDisplay.getRotation());
        }
        if (num == null) {
            return 0;
        }
        int intValue = num.intValue();
        if (intValue == 1) {
            return 90;
        }
        if (intValue != 2) {
            return intValue != 3 ? 0 : -90;
        }
        return RotationOptions.ROTATE_180;
    }

    /* access modifiers changed from: private */
    public final List<SensorServiceInterface> getSensorKernelServices(AppContext appContext) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        SensorServiceInterface[] sensorServiceInterfaceArr = new SensorServiceInterface[5];
        if (appContext != null) {
            Object obj5 = null;
            try {
                obj = appContext.getLegacyModuleRegistry().getModule(GyroscopeServiceInterface.class);
            } catch (Exception unused) {
                obj = null;
            }
            SensorServiceInterface sensorServiceInterface = (SensorServiceInterface) obj;
            if (sensorServiceInterface != null) {
                sensorServiceInterfaceArr[0] = sensorServiceInterface;
                if (appContext != null) {
                    try {
                        obj2 = appContext.getLegacyModuleRegistry().getModule(LinearAccelerationSensorServiceInterface.class);
                    } catch (Exception unused2) {
                        obj2 = null;
                    }
                    SensorServiceInterface sensorServiceInterface2 = (SensorServiceInterface) obj2;
                    if (sensorServiceInterface2 != null) {
                        sensorServiceInterfaceArr[1] = sensorServiceInterface2;
                        if (appContext != null) {
                            try {
                                obj3 = appContext.getLegacyModuleRegistry().getModule(AccelerometerServiceInterface.class);
                            } catch (Exception unused3) {
                                obj3 = null;
                            }
                            SensorServiceInterface sensorServiceInterface3 = (SensorServiceInterface) obj3;
                            if (sensorServiceInterface3 != null) {
                                sensorServiceInterfaceArr[2] = sensorServiceInterface3;
                                if (appContext != null) {
                                    try {
                                        obj4 = appContext.getLegacyModuleRegistry().getModule(RotationVectorSensorServiceInterface.class);
                                    } catch (Exception unused4) {
                                        obj4 = null;
                                    }
                                    SensorServiceInterface sensorServiceInterface4 = (SensorServiceInterface) obj4;
                                    if (sensorServiceInterface4 != null) {
                                        sensorServiceInterfaceArr[3] = sensorServiceInterface4;
                                        if (appContext != null) {
                                            try {
                                                obj5 = appContext.getLegacyModuleRegistry().getModule(GravitySensorServiceInterface.class);
                                            } catch (Exception unused5) {
                                            }
                                            SensorServiceInterface sensorServiceInterface5 = (SensorServiceInterface) obj5;
                                            if (sensorServiceInterface5 != null) {
                                                sensorServiceInterfaceArr[4] = sensorServiceInterface5;
                                                return CollectionsKt.arrayListOf(sensorServiceInterfaceArr);
                                            }
                                        }
                                        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(GravitySensorServiceInterface.class));
                                    }
                                }
                                throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(RotationVectorSensorServiceInterface.class));
                            }
                        }
                        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(AccelerometerServiceInterface.class));
                    }
                }
                throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(LinearAccelerationSensorServiceInterface.class));
            }
        }
        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(GyroscopeServiceInterface.class));
    }
}
