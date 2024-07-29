package expo.modules.av;

import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "name", "", "body", "Landroid/os/Bundle;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AVModule.kt */
final class AVModule$definition$1$1$emitEvent$1 extends Lambda implements Function2<String, Bundle, Unit> {
    final /* synthetic */ WeakReference<AVModule> $weakModule;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AVModule$definition$1$1$emitEvent$1(WeakReference<AVModule> weakReference) {
        super(2);
        this.$weakModule = weakReference;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((String) obj, (Bundle) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(bundle, TtmlNode.TAG_BODY);
        try {
            AVModule aVModule = (AVModule) this.$weakModule.get();
            if (aVModule != null) {
                aVModule.sendEvent(str, bundle);
            }
        } catch (Throwable unused) {
        }
    }
}
