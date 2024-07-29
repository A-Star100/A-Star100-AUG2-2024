package expo.modules;

import android.app.Application;
import androidx.collection.ArrayMap;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.google.android.exoplayer2.util.MimeTypes;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\u0012\u001a\u00020\u0013H\u0014J\n\u0010\u0014\u001a\u0004\u0018\u00010\nH\u0016J\n\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0014J\u000e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0013H\u0002J\u001d\u0010!\u001a\u0002H\"\"\u0004\b\u0000\u0010\"2\u0006\u0010#\u001a\u00020\nH\u0000¢\u0006\u0004\b$\u0010%R\u0014\u0010\u0004\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006&"}, d2 = {"Lexpo/modules/ReactNativeHostWrapperBase;", "Lcom/facebook/react/ReactNativeHost;", "application", "Landroid/app/Application;", "host", "(Landroid/app/Application;Lcom/facebook/react/ReactNativeHost;)V", "getHost", "()Lcom/facebook/react/ReactNativeHost;", "methodMap", "Landroidx/collection/ArrayMap;", "", "Ljava/lang/reflect/Method;", "reactNativeHostHandlers", "", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "kotlin.jvm.PlatformType", "getReactNativeHostHandlers$expo_release", "()Ljava/util/List;", "createReactInstanceManager", "Lcom/facebook/react/ReactInstanceManager;", "getBundleAssetName", "getJSBundleFile", "getJSMainModuleName", "getJavaScriptExecutorFactory", "Lcom/facebook/react/bridge/JavaScriptExecutorFactory;", "getPackages", "", "Lcom/facebook/react/ReactPackage;", "getUseDeveloperSupport", "", "injectHostReactInstanceManager", "", "reactInstanceManager", "invokeDelegateMethod", "T", "name", "invokeDelegateMethod$expo_release", "(Ljava/lang/String;)Ljava/lang/Object;", "expo_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ReactNativeHostWrapperBase.kt */
public class ReactNativeHostWrapperBase extends ReactNativeHost {
    private final ReactNativeHost host;
    private final ArrayMap<String, Method> methodMap;
    private final List<ReactNativeHostHandler> reactNativeHostHandlers;

    /* access modifiers changed from: protected */
    public final ReactNativeHost getHost() {
        return this.host;
    }

    public final List<ReactNativeHostHandler> getReactNativeHostHandlers$expo_release() {
        return this.reactNativeHostHandlers;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReactNativeHostWrapperBase(Application application, ReactNativeHost reactNativeHost) {
        super(application);
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        Intrinsics.checkNotNullParameter(reactNativeHost, "host");
        this.host = reactNativeHost;
        Collection arrayList = new ArrayList();
        for (Package createReactNativeHostHandlers : ExpoModulesPackage.Companion.getPackageList()) {
            List<? extends ReactNativeHostHandler> createReactNativeHostHandlers2 = createReactNativeHostHandlers.createReactNativeHostHandlers(application);
            Intrinsics.checkNotNullExpressionValue(createReactNativeHostHandlers2, "createReactNativeHostHandlers(...)");
            CollectionsKt.addAll(arrayList, createReactNativeHostHandlers2);
        }
        this.reactNativeHostHandlers = (List) arrayList;
        this.methodMap = new ArrayMap<>();
    }

    /* access modifiers changed from: protected */
    public ReactInstanceManager createReactInstanceManager() {
        boolean useDeveloperSupport = getUseDeveloperSupport();
        for (ReactNativeHostHandler onWillCreateReactInstance : this.reactNativeHostHandlers) {
            onWillCreateReactInstance.onWillCreateReactInstance(useDeveloperSupport);
        }
        ReactInstanceManager createReactInstanceManager = super.createReactInstanceManager();
        for (ReactNativeHostHandler onDidCreateDevSupportManager : this.reactNativeHostHandlers) {
            onDidCreateDevSupportManager.onDidCreateDevSupportManager(createReactInstanceManager.getDevSupportManager());
        }
        createReactInstanceManager.addReactInstanceEventListener(new ReactNativeHostWrapperBase$createReactInstanceManager$3(this, useDeveloperSupport));
        Intrinsics.checkNotNull(createReactInstanceManager);
        injectHostReactInstanceManager(createReactInstanceManager);
        return createReactInstanceManager;
    }

    /* access modifiers changed from: protected */
    public JavaScriptExecutorFactory getJavaScriptExecutorFactory() {
        JavaScriptExecutorFactory javaScriptExecutorFactory = (JavaScriptExecutorFactory) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), ReactNativeHostWrapperBase$getJavaScriptExecutorFactory$1.INSTANCE));
        return javaScriptExecutorFactory == null ? (JavaScriptExecutorFactory) invokeDelegateMethod$expo_release("getJavaScriptExecutorFactory") : javaScriptExecutorFactory;
    }

    public String getJSMainModuleName() {
        return (String) invokeDelegateMethod$expo_release("getJSMainModuleName");
    }

    public String getJSBundleFile() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapperBase$getJSBundleFile$1(this)));
        return str == null ? (String) invokeDelegateMethod$expo_release("getJSBundleFile") : str;
    }

    public String getBundleAssetName() {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), new ReactNativeHostWrapperBase$getBundleAssetName$1(this)));
        return str == null ? (String) invokeDelegateMethod$expo_release("getBundleAssetName") : str;
    }

    public boolean getUseDeveloperSupport() {
        Boolean bool = (Boolean) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.reactNativeHostHandlers), ReactNativeHostWrapperBase$getUseDeveloperSupport$1.INSTANCE));
        if (bool == null) {
            return this.host.getUseDeveloperSupport();
        }
        return bool.booleanValue();
    }

    public List<ReactPackage> getPackages() {
        return (List) invokeDelegateMethod$expo_release("getPackages");
    }

    public final <T> T invokeDelegateMethod$expo_release(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        Method method = this.methodMap.get(str);
        if (method == null) {
            method = ReactNativeHost.class.getDeclaredMethod(str, new Class[0]);
            method.setAccessible(true);
            this.methodMap.put(str, method);
        }
        Intrinsics.checkNotNull(method);
        return method.invoke(this.host, new Object[0]);
    }

    private final void injectHostReactInstanceManager(ReactInstanceManager reactInstanceManager) {
        Field declaredField = ReactNativeHost.class.getDeclaredField("mReactInstanceManager");
        declaredField.setAccessible(true);
        declaredField.set(this.host, reactInstanceManager);
    }
}
