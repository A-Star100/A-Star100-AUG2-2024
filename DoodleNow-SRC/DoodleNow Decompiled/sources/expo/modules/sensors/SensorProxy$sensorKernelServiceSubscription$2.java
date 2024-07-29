package expo.modules.sensors;

import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lexpo/modules/interfaces/sensors/SensorServiceSubscriptionInterface;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorProxy.kt */
final class SensorProxy$sensorKernelServiceSubscription$2 extends Lambda implements Function0<SensorServiceSubscriptionInterface> {
    final /* synthetic */ SensorProxy this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SensorProxy$sensorKernelServiceSubscription$2(SensorProxy sensorProxy) {
        super(0);
        this.this$0 = sensorProxy;
    }

    public final SensorServiceSubscriptionInterface invoke() {
        return this.this$0.getSensorServiceFactory().invoke().createSubscriptionForListener(this.this$0);
    }
}
