package expo.modules.adapters.react.apploader;

import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import expo.modules.apploader.HeadlessAppLoader;
import expo.modules.core.interfaces.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/adapters/react/apploader/RNHeadlessAppLoader$loadApp$1", "Lcom/facebook/react/ReactInstanceEventListener;", "onReactContextInitialized", "", "context", "Lcom/facebook/react/bridge/ReactContext;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: RNHeadlessAppLoader.kt */
public final class RNHeadlessAppLoader$loadApp$1 implements ReactInstanceEventListener {
    final /* synthetic */ Consumer<Boolean> $callback;
    final /* synthetic */ HeadlessAppLoader.Params $params;

    RNHeadlessAppLoader$loadApp$1(HeadlessAppLoader.Params params, Consumer<Boolean> consumer) {
        this.$params = params;
        this.$callback = consumer;
    }

    public void onReactContextInitialized(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "context");
        HeadlessAppLoaderNotifier.INSTANCE.notifyAppLoaded(this.$params.getAppScopeKey());
        Consumer<Boolean> consumer = this.$callback;
        if (consumer != null) {
            consumer.apply(true);
        }
    }
}
