package expo.modules.sensors.modules;

import androidx.tracing.Trace;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.sensors.SensorProxy;
import expo.modules.sensors.SensorProxyKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lexpo/modules/sensors/modules/MagnetometerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "sensorProxy", "Lexpo/modules/sensors/SensorProxy;", "getSensorProxy", "()Lexpo/modules/sensors/SensorProxy;", "sensorProxy$delegate", "Lkotlin/Lazy;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-sensors_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MagnetometerModule.kt */
public final class MagnetometerModule extends Module {
    private final Lazy sensorProxy$delegate = LazyKt.lazy(new MagnetometerModule$sensorProxy$2(this));

    /* access modifiers changed from: private */
    public final SensorProxy getSensorProxy() {
        return (SensorProxy) this.sensorProxy$delegate.getValue();
    }

    public ModuleDefinitionData definition() {
        Module module = this;
        Trace.beginSection("[ExpoModulesCore] " + (module.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(module);
            moduleDefinitionBuilder.Name("ExponentMagnetometer");
            SensorProxyKt.UseSensorProxy$default(moduleDefinitionBuilder, this, 2, "magnetometerDidUpdate", (Function0) null, new MagnetometerModule$definition$1$1(this), 8, (Object) null);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}
