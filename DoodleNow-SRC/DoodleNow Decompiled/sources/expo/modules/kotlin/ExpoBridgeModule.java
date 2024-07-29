package expo.modules.kotlin;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import expo.modules.adapters.react.NativeModulesProxy;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0007J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0002R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/ExpoBridgeModule;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "nativeModulesProxy", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/adapters/react/NativeModulesProxy;", "(Lcom/facebook/react/bridge/ReactApplicationContext;Ljava/lang/ref/WeakReference;)V", "getName", "", "installModules", "", "tryWaitSync", "", "waitMs", "", "retries", "", "predicate", "Lkotlin/Function0;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ExpoBridgeModule.kt */
public final class ExpoBridgeModule extends ReactContextBaseJavaModule {
    private final WeakReference<NativeModulesProxy> nativeModulesProxy;

    public String getName() {
        return "ExpoModulesCore";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoBridgeModule(ReactApplicationContext reactApplicationContext, WeakReference<NativeModulesProxy> weakReference) {
        super(reactApplicationContext);
        Intrinsics.checkNotNullParameter(reactApplicationContext, "reactContext");
        Intrinsics.checkNotNullParameter(weakReference, "nativeModulesProxy");
        this.nativeModulesProxy = weakReference;
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public final boolean installModules() {
        tryWaitSync(100, 10, new ExpoBridgeModule$installModules$1(this));
        NativeModulesProxy nativeModulesProxy2 = (NativeModulesProxy) this.nativeModulesProxy.get();
        KotlinInteropModuleRegistry kotlinInteropModuleRegistry = nativeModulesProxy2 != null ? nativeModulesProxy2.getKotlinInteropModuleRegistry() : null;
        if (kotlinInteropModuleRegistry != null) {
            kotlinInteropModuleRegistry.installJSIInterop();
            return true;
        }
        throw new IllegalStateException("Couldn't find KotlinInteropModuleRegistry");
    }

    private final void tryWaitSync(long j, int i, Function0<Boolean> function0) {
        for (int i2 = 0; i2 < i && !function0.invoke().booleanValue(); i2++) {
            Thread.sleep(j);
        }
    }
}
