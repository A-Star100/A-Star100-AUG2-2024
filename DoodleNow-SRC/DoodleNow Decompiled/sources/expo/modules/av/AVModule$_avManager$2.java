package expo.modules.av;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lexpo/modules/av/AVManagerInterface;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AVModule.kt */
final class AVModule$_avManager$2 extends Lambda implements Function0<AVManagerInterface> {
    final /* synthetic */ AVModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AVModule$_avManager$2(AVModule aVModule) {
        super(0);
        this.this$0 = aVModule;
    }

    public final AVManagerInterface invoke() {
        Object obj;
        try {
            obj = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(AVManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (AVManagerInterface) obj;
    }
}
