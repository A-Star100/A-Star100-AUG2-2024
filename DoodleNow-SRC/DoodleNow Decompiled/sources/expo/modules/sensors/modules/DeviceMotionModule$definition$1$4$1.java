package expo.modules.sensors.modules;

import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import expo.modules.kotlin.Promise;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: DeviceMotionModule.kt */
final class DeviceMotionModule$definition$1$4$1 implements Runnable {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ DeviceMotionModule this$0;

    DeviceMotionModule$definition$1$4$1(DeviceMotionModule deviceMotionModule, Promise promise) {
        this.this$0 = deviceMotionModule;
        this.$promise = promise;
    }

    public final void run() {
        List<SensorServiceSubscriptionInterface> access$getServiceSubscriptions$p = this.this$0.serviceSubscriptions;
        if (access$getServiceSubscriptions$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceSubscriptions");
            access$getServiceSubscriptions$p = null;
        }
        for (SensorServiceSubscriptionInterface stop : access$getServiceSubscriptions$p) {
            stop.stop();
        }
        this.this$0.currentFrameCallback.stop();
        this.$promise.resolve((Object) null);
    }
}
