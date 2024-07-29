package expo.modules;

import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.bridge.ReactContext;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/ReactNativeHostWrapperBase$createReactInstanceManager$3", "Lcom/facebook/react/ReactInstanceEventListener;", "onReactContextInitialized", "", "context", "Lcom/facebook/react/bridge/ReactContext;", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeHostWrapperBase.kt */
public final class ReactNativeHostWrapperBase$createReactInstanceManager$3 implements ReactInstanceEventListener {
    final /* synthetic */ boolean $developerSupport;
    final /* synthetic */ ReactNativeHostWrapperBase this$0;

    ReactNativeHostWrapperBase$createReactInstanceManager$3(ReactNativeHostWrapperBase reactNativeHostWrapperBase, boolean z) {
        this.this$0 = reactNativeHostWrapperBase;
        this.$developerSupport = z;
    }

    public void onReactContextInitialized(ReactContext reactContext) {
        Intrinsics.checkNotNullParameter(reactContext, "context");
        boolean z = this.$developerSupport;
        for (ReactNativeHostHandler onDidCreateReactInstance : this.this$0.getReactNativeHostHandlers$expo_release()) {
            onDidCreateReactInstance.onDidCreateReactInstance(z, reactContext);
        }
    }
}
