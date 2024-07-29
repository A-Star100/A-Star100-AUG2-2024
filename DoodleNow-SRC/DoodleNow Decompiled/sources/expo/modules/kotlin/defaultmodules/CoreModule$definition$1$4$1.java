package expo.modules.kotlin.defaultmodules;

import com.facebook.react.ReactInstanceManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: CoreModule.kt */
final class CoreModule$definition$1$4$1 implements Runnable {
    final /* synthetic */ ReactInstanceManager $reactInstanceManager;

    CoreModule$definition$1$4$1(ReactInstanceManager reactInstanceManager) {
        this.$reactInstanceManager = reactInstanceManager;
    }

    public final void run() {
        this.$reactInstanceManager.recreateReactContextInBackground();
    }
}
