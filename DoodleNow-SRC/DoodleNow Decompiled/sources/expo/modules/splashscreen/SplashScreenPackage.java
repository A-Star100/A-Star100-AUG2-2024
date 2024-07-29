package expo.modules.splashscreen;

import android.content.Context;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactActivityHandler;
import expo.modules.core.interfaces.ReactActivityLifecycleListener;
import expo.modules.core.interfaces.SingletonModule;
import expo.modules.splashscreen.singletons.SplashScreen;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\r"}, d2 = {"Lexpo/modules/splashscreen/SplashScreenPackage;", "Lexpo/modules/core/interfaces/Package;", "()V", "createReactActivityHandlers", "", "Lexpo/modules/core/interfaces/ReactActivityHandler;", "activityContext", "Landroid/content/Context;", "createReactActivityLifecycleListeners", "Lexpo/modules/core/interfaces/ReactActivityLifecycleListener;", "createSingletonModules", "Lexpo/modules/core/interfaces/SingletonModule;", "context", "expo-splash-screen_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SplashScreenPackage.kt */
public final class SplashScreenPackage implements Package {
    public /* synthetic */ List createApplicationLifecycleListeners(Context context) {
        return Package.CC.$default$createApplicationLifecycleListeners(this, context);
    }

    public /* synthetic */ List createInternalModules(Context context) {
        return Package.CC.$default$createInternalModules(this, context);
    }

    public /* synthetic */ List createReactNativeHostHandlers(Context context) {
        return Package.CC.$default$createReactNativeHostHandlers(this, context);
    }

    public List<SingletonModule> createSingletonModules(Context context) {
        return CollectionsKt.listOf(SplashScreen.INSTANCE);
    }

    public List<ReactActivityLifecycleListener> createReactActivityLifecycleListeners(Context context) {
        Intrinsics.checkNotNullParameter(context, "activityContext");
        return CollectionsKt.listOf(new SplashScreenReactActivityLifecycleListener());
    }

    public List<ReactActivityHandler> createReactActivityHandlers(Context context) {
        return CollectionsKt.listOf(new SplashScreenReactActivityHandler());
    }
}
