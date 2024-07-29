package expo.modules.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import androidx.core.app.NotificationCompat;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B>\u0012\u0010\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005\u0012%\u0010\u0006\u001a!\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u001b\u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0012\u0010 \u001a\u00020\f2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010!\u001a\u00020\fJ\u0006\u0010\"\u001a\u00020\fJ\u0006\u0010#\u001a\u00020\fJ\u0010\u0010$\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\bH\u0016J\u000e\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\u001fJ\u0006\u0010'\u001a\u00020\fJ\u0006\u0010(\u001a\u00020\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R0\u0010\u0006\u001a!\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148BX\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0002\u001a\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lexpo/modules/sensors/SensorProxy;", "Landroid/hardware/SensorEventListener2;", "sensorServiceFactory", "Lkotlin/Function0;", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "Lexpo/modules/sensors/SensorServiceFactory;", "onNewEvent", "Lkotlin/Function1;", "Landroid/hardware/SensorEvent;", "Lkotlin/ParameterName;", "name", "event", "", "Lexpo/modules/sensors/OnNewEvent;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "mIsObserving", "", "getOnNewEvent", "()Lkotlin/jvm/functions/Function1;", "sensorKernelServiceSubscription", "Lexpo/modules/interfaces/sensors/SensorServiceSubscriptionInterface;", "getSensorKernelServiceSubscription", "()Lexpo/modules/interfaces/sensors/SensorServiceSubscriptionInterface;", "sensorKernelServiceSubscription$delegate", "Lkotlin/Lazy;", "getSensorServiceFactory", "()Lkotlin/jvm/functions/Function0;", "onAccuracyChanged", "sensor", "Landroid/hardware/Sensor;", "accuracy", "", "onFlushCompleted", "onHostDestroy", "onHostPause", "onHostResume", "onSensorChanged", "setUpdateInterval", "updateInterval", "startObserving", "stopObserving", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorProxy.kt */
public final class SensorProxy implements SensorEventListener2 {
    private boolean mIsObserving;
    private final Function1<SensorEvent, Unit> onNewEvent;
    private final Lazy sensorKernelServiceSubscription$delegate = LazyKt.lazy(new SensorProxy$sensorKernelServiceSubscription$2(this));
    private final Function0<SensorServiceInterface> sensorServiceFactory;

    public final Function1<SensorEvent, Unit> getOnNewEvent() {
        return this.onNewEvent;
    }

    public final Function0<SensorServiceInterface> getSensorServiceFactory() {
        return this.sensorServiceFactory;
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
    }

    public void onFlushCompleted(Sensor sensor) {
    }

    public SensorProxy(Function0<? extends SensorServiceInterface> function0, Function1<? super SensorEvent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function0, "sensorServiceFactory");
        Intrinsics.checkNotNullParameter(function1, "onNewEvent");
        this.sensorServiceFactory = function0;
        this.onNewEvent = function1;
    }

    private final SensorServiceSubscriptionInterface getSensorKernelServiceSubscription() {
        Object value = this.sensorKernelServiceSubscription$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SensorServiceSubscriptionInterface) value;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, NotificationCompat.CATEGORY_EVENT);
        this.onNewEvent.invoke(sensorEvent);
    }

    public final void setUpdateInterval(int i) {
        getSensorKernelServiceSubscription().setUpdateInterval((long) i);
    }

    public final void startObserving() {
        this.mIsObserving = true;
        getSensorKernelServiceSubscription().start();
    }

    public final void stopObserving() {
        if (this.mIsObserving) {
            this.mIsObserving = false;
            getSensorKernelServiceSubscription().stop();
        }
    }

    public final void onHostResume() {
        if (this.mIsObserving) {
            getSensorKernelServiceSubscription().start();
        }
    }

    public final void onHostPause() {
        if (this.mIsObserving) {
            getSensorKernelServiceSubscription().stop();
        }
    }

    public final void onHostDestroy() {
        getSensorKernelServiceSubscription().release();
    }
}
