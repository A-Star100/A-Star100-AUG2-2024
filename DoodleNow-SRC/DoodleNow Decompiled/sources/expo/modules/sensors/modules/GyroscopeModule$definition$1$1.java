package expo.modules.sensors.modules;

import expo.modules.sensors.SensorProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/sensors/SensorProxy;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: GyroscopeModule.kt */
final class GyroscopeModule$definition$1$1 extends Lambda implements Function0<SensorProxy> {
    final /* synthetic */ GyroscopeModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GyroscopeModule$definition$1$1(GyroscopeModule gyroscopeModule) {
        super(0);
        this.this$0 = gyroscopeModule;
    }

    public final SensorProxy invoke() {
        return this.this$0.getSensorProxy();
    }
}
