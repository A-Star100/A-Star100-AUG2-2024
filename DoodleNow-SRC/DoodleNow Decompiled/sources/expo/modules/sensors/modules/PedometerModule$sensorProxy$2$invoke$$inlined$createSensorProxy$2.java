package expo.modules.sensors.modules;

import android.hardware.SensorEvent;
import android.os.Bundle;
import expo.modules.kotlin.modules.Module;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "sensorEvent", "Landroid/hardware/SensorEvent;", "invoke", "expo/modules/sensors/SensorProxyKt$createSensorProxy$onNewEvent$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorProxy.kt */
public final class PedometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$2 extends Lambda implements Function1<SensorEvent, Unit> {
    final /* synthetic */ String $eventName;
    final /* synthetic */ WeakReference $weakModule;
    final /* synthetic */ PedometerModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PedometerModule$sensorProxy$2$invoke$$inlined$createSensorProxy$2(WeakReference weakReference, String str, PedometerModule pedometerModule) {
        super(1);
        this.$weakModule = weakReference;
        this.$eventName = str;
        this.this$0 = pedometerModule;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SensorEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        Module module = (Module) this.$weakModule.get();
        if (module != null) {
            String str = this.$eventName;
            if (this.this$0.stepsAtTheBeginning == null) {
                this.this$0.stepsAtTheBeginning = Integer.valueOf(((int) sensorEvent.values[0]) - 1);
            }
            Bundle bundle = new Bundle();
            float f = sensorEvent.values[0];
            Integer access$getStepsAtTheBeginning$p = this.this$0.stepsAtTheBeginning;
            bundle.putDouble("steps", (double) (f - ((float) (access$getStepsAtTheBeginning$p != null ? access$getStepsAtTheBeginning$p.intValue() : ((int) sensorEvent.values[0]) - 1))));
            module.sendEvent(str, bundle);
        }
    }
}
