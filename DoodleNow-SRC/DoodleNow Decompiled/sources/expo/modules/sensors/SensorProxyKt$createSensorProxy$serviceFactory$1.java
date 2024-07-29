package expo.modules.sensors;

import expo.modules.core.ModuleRegistry;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.modules.Module;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "T", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "invoke", "()Lexpo/modules/interfaces/sensors/SensorServiceInterface;"}, k = 3, mv = {1, 9, 0}, xi = 176)
/* compiled from: SensorProxy.kt */
public final class SensorProxyKt$createSensorProxy$serviceFactory$1 extends Lambda implements Function0<T> {
    final /* synthetic */ WeakReference<Module> $weakModule;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SensorProxyKt$createSensorProxy$serviceFactory$1(WeakReference<Module> weakReference) {
        super(0);
        this.$weakModule = weakReference;
    }

    public final T invoke() {
        Module module = (Module) this.$weakModule.get();
        T t = null;
        AppContext appContext = module != null ? module.getAppContext() : null;
        if (appContext != null) {
            try {
                ModuleRegistry legacyModuleRegistry = appContext.getLegacyModuleRegistry();
                Intrinsics.reifiedOperationMarker(4, "T");
                Class cls = Object.class;
                Class cls2 = cls;
                t = legacyModuleRegistry.getModule(cls);
            } catch (Exception unused) {
            }
            T t2 = (SensorServiceInterface) t;
            if (t2 != null) {
                SensorServiceInterface sensorServiceInterface = (SensorServiceInterface) t2;
                return t2;
            }
        }
        Intrinsics.reifiedOperationMarker(4, "T");
        throw new ServiceNotFoundException(Reflection.getOrCreateKotlinClass(SensorServiceInterface.class));
    }
}
