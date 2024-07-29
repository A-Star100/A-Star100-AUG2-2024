package expo.modules.sensors.services;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener2;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u000e\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nJ\u000e\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\nJ\b\u0010\u001e\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lexpo/modules/sensors/services/SubscribableSensorService;", "Lexpo/modules/sensors/services/BaseSensorService;", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "reactContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mListenersCount", "", "mSensorEventListenerLastUpdateMap", "", "Lexpo/modules/sensors/services/SensorServiceSubscription;", "", "createSubscriptionForListener", "Lexpo/modules/interfaces/sensors/SensorServiceSubscriptionInterface;", "listener", "Landroid/hardware/SensorEventListener2;", "onAccuracyChanged", "", "sensor", "Landroid/hardware/Sensor;", "accuracy", "onExperienceBackgrounded", "onExperienceForegrounded", "onFlushCompleted", "onSensorChanged", "sensorEvent", "Landroid/hardware/SensorEvent;", "onSubscriptionEnabledChanged", "sensorServiceSubscription", "removeSubscription", "updateObserving", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SubscribableSensorService.kt */
public abstract class SubscribableSensorService extends BaseSensorService implements SensorServiceInterface {
    private int mListenersCount;
    private final Map<SensorServiceSubscription, Long> mSensorEventListenerLastUpdateMap = new WeakHashMap();

    public SubscribableSensorService(Context context) {
        super(context);
    }

    public void onExperienceForegrounded() {
        updateObserving();
    }

    public void onExperienceBackgrounded() {
        updateObserving();
    }

    public SensorServiceSubscriptionInterface createSubscriptionForListener(SensorEventListener2 sensorEventListener2) {
        Intrinsics.checkNotNullParameter(sensorEventListener2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        SensorServiceSubscription sensorServiceSubscription = new SensorServiceSubscription(this, sensorEventListener2);
        this.mSensorEventListenerLastUpdateMap.put(sensorServiceSubscription, 0L);
        return sensorServiceSubscription;
    }

    public final void onSubscriptionEnabledChanged(SensorServiceSubscription sensorServiceSubscription) {
        Intrinsics.checkNotNullParameter(sensorServiceSubscription, "sensorServiceSubscription");
        if (sensorServiceSubscription.isEnabled()) {
            this.mListenersCount++;
        } else {
            this.mListenersCount--;
        }
        updateObserving();
    }

    public final void removeSubscription(SensorServiceSubscription sensorServiceSubscription) {
        Intrinsics.checkNotNullParameter(sensorServiceSubscription, "sensorServiceSubscription");
        this.mSensorEventListenerLastUpdateMap.remove(sensorServiceSubscription);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        if (sensorEvent.sensor.getType() == getSensorType()) {
            long currentTimeMillis = System.currentTimeMillis();
            for (SensorServiceSubscription next : this.mSensorEventListenerLastUpdateMap.keySet()) {
                if (next.isEnabled()) {
                    Long l = this.mSensorEventListenerLastUpdateMap.get(next);
                    if (currentTimeMillis - (l != null ? l.longValue() : 0) > next.getUpdateInterval().longValue()) {
                        next.getSensorEventListener().onSensorChanged(sensorEvent);
                        this.mSensorEventListenerLastUpdateMap.put(next, Long.valueOf(currentTimeMillis));
                    }
                }
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
        if (sensor.getType() == getSensorType()) {
            for (SensorServiceSubscription next : this.mSensorEventListenerLastUpdateMap.keySet()) {
                if (next.isEnabled()) {
                    next.getSensorEventListener().onAccuracyChanged(sensor, i);
                }
            }
        }
    }

    public void onFlushCompleted(Sensor sensor) {
        Intrinsics.checkNotNullParameter(sensor, "sensor");
        if (sensor.getType() == getSensorType()) {
            for (SensorServiceSubscription next : this.mSensorEventListenerLastUpdateMap.keySet()) {
                if (next.isEnabled()) {
                    next.getSensorEventListener().onFlushCompleted(sensor);
                }
            }
        }
    }

    private final void updateObserving() {
        if (this.mListenersCount <= 0 || !getExperienceIsForegrounded()) {
            super.stopObserving();
        } else {
            super.startObserving();
        }
    }
}
