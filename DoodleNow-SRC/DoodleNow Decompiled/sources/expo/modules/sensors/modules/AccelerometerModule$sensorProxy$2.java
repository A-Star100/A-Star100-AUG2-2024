package expo.modules.sensors.modules;

import expo.modules.sensors.SensorProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/sensors/SensorProxy;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AccelerometerModule.kt */
final class AccelerometerModule$sensorProxy$2 extends Lambda implements Function0<SensorProxy> {
    final /* synthetic */ AccelerometerModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AccelerometerModule$sensorProxy$2(AccelerometerModule accelerometerModule) {
        super(0);
        this.this$0 = accelerometerModule;
    }

    public final SensorProxy invoke() {
        WeakReference weakReference = new WeakReference(this.this$0);
        return new SensorProxy(new AccelerometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$1(weakReference), new AccelerometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$2(weakReference, "accelerometerDidUpdate"));
    }
}
