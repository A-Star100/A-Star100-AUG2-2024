package expo.modules.sensors;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "expo/modules/kotlin/modules/ModuleDefinitionBuilder$OnDestroy$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class SensorProxyKt$UseSensorProxy$$inlined$OnDestroy$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0 $sensorProxyGetter$inlined;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SensorProxyKt$UseSensorProxy$$inlined$OnDestroy$1(Function0 function0) {
        super(0);
        this.$sensorProxyGetter$inlined = function0;
    }

    public final void invoke() {
        ((SensorProxy) this.$sensorProxyGetter$inlined.invoke()).onHostDestroy();
    }
}
