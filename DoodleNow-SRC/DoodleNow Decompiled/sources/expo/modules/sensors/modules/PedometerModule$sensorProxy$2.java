package expo.modules.sensors.modules;

import expo.modules.sensors.SensorProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/sensors/SensorProxy;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: PedometerModule.kt */
final class PedometerModule$sensorProxy$2 extends Lambda implements Function0<SensorProxy> {
    final /* synthetic */ PedometerModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PedometerModule$sensorProxy$2(PedometerModule pedometerModule) {
        super(0);
        this.this$0 = pedometerModule;
    }

    public final SensorProxy invoke() {
        PedometerModule pedometerModule = this.this$0;
        WeakReference weakReference = new WeakReference(pedometerModule);
        return new SensorProxy(new PedometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$1(weakReference), new PedometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$2(weakReference, "Exponent.pedometerUpdate", pedometerModule));
    }
}
