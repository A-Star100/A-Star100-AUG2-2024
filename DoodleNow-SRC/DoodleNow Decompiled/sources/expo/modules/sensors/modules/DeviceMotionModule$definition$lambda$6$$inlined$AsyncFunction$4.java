package expo.modules.sensors.modules;

import android.content.Context;
import android.hardware.SensorManager;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u00012\u0010\u0010\u0002\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "R", "it", "", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$3"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ObjectDefinitionBuilder.kt */
public final class DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4 extends Lambda implements Function1<Object[], Boolean> {
    final /* synthetic */ DeviceMotionModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMotionModule$definition$lambda$6$$inlined$AsyncFunction$4(DeviceMotionModule deviceMotionModule) {
        super(1);
        this.this$0 = deviceMotionModule;
    }

    public final Boolean invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        Context reactContext = this.this$0.getAppContext().getReactContext();
        SensorManager sensorManager = null;
        Object systemService = reactContext != null ? reactContext.getSystemService("sensor") : null;
        if (systemService instanceof SensorManager) {
            sensorManager = (SensorManager) systemService;
        }
        boolean z = false;
        if (sensorManager != null) {
            Iterator it = CollectionsKt.arrayListOf(4, 1, 10, 11, 9).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = true;
                    break;
                }
                Integer num = (Integer) it.next();
                Intrinsics.checkNotNull(num);
                if (sensorManager.getDefaultSensor(num.intValue()) == null) {
                    break;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
