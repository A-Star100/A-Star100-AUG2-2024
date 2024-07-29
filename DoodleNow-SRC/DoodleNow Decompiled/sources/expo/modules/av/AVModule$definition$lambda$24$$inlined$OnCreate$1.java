package expo.modules.av;

import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "invoke", "expo/modules/kotlin/modules/ModuleDefinitionBuilder$OnCreate$1"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: ModuleDefinitionBuilder.kt */
public final class AVModule$definition$lambda$24$$inlined$OnCreate$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ AVModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AVModule$definition$lambda$24$$inlined$OnCreate$1(AVModule aVModule) {
        super(0);
        this.this$0 = aVModule;
    }

    public final void invoke() {
        Object obj;
        Function2 aVModule$definition$1$1$emitEvent$1 = new AVModule$definition$1$1$emitEvent$1(new WeakReference(this.this$0));
        try {
            obj = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(AVManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        AVManagerInterface aVManagerInterface = (AVManagerInterface) obj;
        if (aVManagerInterface != null) {
            aVManagerInterface.setEmitEventWrapper(new AVModuleKt$sam$expo_modules_av_EmitEventWrapper$0(aVModule$definition$1$1$emitEvent$1));
        }
    }
}
