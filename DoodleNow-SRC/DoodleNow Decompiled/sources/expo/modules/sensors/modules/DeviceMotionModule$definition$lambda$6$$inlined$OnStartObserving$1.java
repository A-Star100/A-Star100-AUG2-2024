package expo.modules.sensors.modules;

import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.SensorServiceSubscriptionInterface;
import expo.modules.kotlin.Promise;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"<anonymous>", "", "R", "P0", "<anonymous parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$5", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$OnStartObserving$$inlined$AsyncFunction$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$1 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ DeviceMotionModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMotionModule$definition$lambda$6$$inlined$OnStartObserving$1(DeviceMotionModule deviceMotionModule) {
        super(2);
        this.this$0 = deviceMotionModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String str = (String) promise;
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
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
