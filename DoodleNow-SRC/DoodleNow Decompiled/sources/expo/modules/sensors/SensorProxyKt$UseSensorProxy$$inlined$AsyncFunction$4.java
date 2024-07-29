package expo.modules.sensors;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import expo.modules.kotlin.modules.Module;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "it", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4 extends Lambda implements Function1<Object[], Boolean> {
    final /* synthetic */ Module $module$inlined;
    final /* synthetic */ int $sensorType$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SensorProxyKt$UseSensorProxy$$inlined$AsyncFunction$4(Module module, int i) {
        super(1);
        this.$module$inlined = module;
        this.$sensorType$inlined = i;
    }

    public final Boolean invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Context reactContext = this.$module$inlined.getAppContext().getReactContext();
        Sensor sensor = null;
        Object systemService = reactContext != null ? reactContext.getSystemService("sensor") : null;
        SensorManager sensorManager = systemService instanceof SensorManager ? (SensorManager) systemService : null;
        if (sensorManager != null) {
            sensor = sensorManager.getDefaultSensor(this.$sensorType$inlined);
        }
        return Boolean.valueOf(sensor != null);
    }
}
