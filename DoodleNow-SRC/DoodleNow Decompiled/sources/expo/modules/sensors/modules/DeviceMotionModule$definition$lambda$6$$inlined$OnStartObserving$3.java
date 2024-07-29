package expo.modules.sensors.modules;

import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001\"\u0006\b\u0001\u0010\u0002\u0018\u00012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"<anonymous>", "R", "P0", "<name for destructuring parameter 0>", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$6", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3 extends Lambda implements Function1<Object[], Unit> {
    final /* synthetic */ DeviceMotionModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$3(DeviceMotionModule deviceMotionModule) {
        super(1);
        this.this$0 = deviceMotionModule;
    }

    public final Unit invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<name for destructuring parameter 0>");
        String str = objArr[0];
        List<SensorServiceSubscriptionInterface> list = null;
        if (this.this$0.serviceSubscriptions == null) {
            this.this$0.serviceSubscriptions = new ArrayList();
            DeviceMotionModule deviceMotionModule = this.this$0;
            for (SensorServiceInterface createSubscriptionForListener : deviceMotionModule.getSensorKernelServices(deviceMotionModule.getAppContext())) {
                SensorServiceSubscriptionInterface createSubscriptionForListener2 = createSubscriptionForListener.createSubscriptionForListener(this.this$0);
                createSubscriptionForListener2.setUpdateInterval(0);
                List access$getServiceSubscriptions$p = this.this$0.serviceSubscriptions;
                if (access$getServiceSubscriptions$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("serviceSubscriptions");
                    access$getServiceSubscriptions$p = null;
                }
                Intrinsics.checkNotNull(createSubscriptionForListener2);
                access$getServiceSubscriptions$p.add(createSubscriptionForListener2);
            }
        }
        List access$getServiceSubscriptions$p2 = this.this$0.serviceSubscriptions;
        if (access$getServiceSubscriptions$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("serviceSubscriptions");
        } else {
            list = access$getServiceSubscriptions$p2;
        }
        for (SensorServiceSubscriptionInterface start : list) {
            start.start();
        }
        return Unit.INSTANCE;
    }
}
