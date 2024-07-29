package expo.modules.sensors;

import android.hardware.SensorEvent;
import android.os.Bundle;
import expo.modules.kotlin.modules.Module;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "T", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "sensorEvent", "Landroid/hardware/SensorEvent;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: SensorProxy.kt */
public final class SensorProxyKt$createSensorProxy$onNewEvent$1 extends Lambda implements Function1<SensorEvent, Unit> {
    final /* synthetic */ Function1<SensorEvent, Bundle> $eventMapper;
    final /* synthetic */ String $eventName;
    final /* synthetic */ WeakReference<Module> $weakModule;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SensorProxyKt$createSensorProxy$onNewEvent$1(WeakReference<Module> weakReference, String str, Function1<? super SensorEvent, Bundle> function1) {
        super(1);
        this.$weakModule = weakReference;
        this.$eventName = str;
        this.$eventMapper = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((SensorEvent) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(SensorEvent sensorEvent) {
        Intrinsics.checkNotNullParameter(sensorEvent, "sensorEvent");
        Module module = (Module) this.$weakModule.get();
        if (module != null) {
            module.sendEvent(this.$eventName, this.$eventMapper.invoke(sensorEvent));
        }
    }
}
