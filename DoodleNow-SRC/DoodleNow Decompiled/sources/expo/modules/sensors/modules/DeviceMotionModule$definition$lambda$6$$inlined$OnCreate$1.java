package expo.modules.sensors.modules;

import expo.modules.core.interfaces.services.UIManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "expo/modules/kotlin/modules/ModuleDefinitionBuilder$OnCreate$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class DeviceMotionModule$definition$lambda$6$$inlined$OnCreate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ DeviceMotionModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceMotionModule$definition$lambda$6$$inlined$OnCreate$1(DeviceMotionModule deviceMotionModule) {
        super(0);
        this.this$0 = deviceMotionModule;
    }

    public final void invoke() {
        Object obj;
        DeviceMotionModule deviceMotionModule = this.this$0;
        try {
            obj = deviceMotionModule.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
        } catch (Exception unused) {
            obj = null;
        }
        Intrinsics.checkNotNull(obj);
        deviceMotionModule.uiManager = (UIManager) obj;
    }
}
