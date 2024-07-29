package expo.modules.sensors.modules;

import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.sensors.services.GyroscopeServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.modules.Module;
import expo.modules.sensors.ServiceNotFoundException;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"<anonymous>", "T", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "invoke", "()Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "expo/modules/sensors/SensorProxyKt$createSensorProxy$serviceFactory$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SensorProxy.kt */
public final class GyroscopeModule$sensorProxy$2$invoke$$inlined$createSensorProxy$1 extends Lambda implements Function0<GyroscopeServiceInterface> {
    final /* synthetic */ WeakReference $weakModule;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GyroscopeModule$sensorProxy$2$invoke$$inlined$createSensorProxy$1(WeakReference weakReference) {
        super(0);
        this.$weakModule = weakReference;
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [expo.modules.interfaces.sensors.SensorServiceInterface, expo.modules.interfaces.sensors.services.GyroscopeServiceInterface] */
    public final GyroscopeServiceInterface invoke() {
        Module module = (Module) this.$weakModule.get();
        Object obj = null;
        AppContext appContext = module != null ? module.getAppContext() : null;
        if (appContext != null) {
            try {
                obj = appContext.getLegacyModuleRegistry().getModule(GyroscopeServiceInterface.class);
            } catch (Exception unused) {
            }
            ? r1 = (SensorServiceInterface) obj;
            if (r1 != 0) {
                return r1;
            }
        }
        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(GyroscopeServiceInterface.class));
    }
}
