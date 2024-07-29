package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.exception.JavaScriptEvaluateException;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObject;
import expo.modules.kotlin.sharedobjects.SharedObjectId;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\f\u001a\u00020\rH J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\t\u0010\u0013\u001a\u00020\u000fH J\u0011\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H J\b\u0010\u0018\u001a\u00020\u000fH\u0004J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001c\u001a\u00020\u0017H\u0007J\u0013\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00170\u001eH\u0007¢\u0006\u0002\u0010\u001fJ\u0016\u0010 \u001a\u0004\u0018\u00010\r2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"H\u0007J\t\u0010#\u001a\u00020\rH J\u0010\u0010$\u001a\u00020%2\u0006\u0010\u001c\u001a\u00020\u0017H\u0007J\t\u0010&\u001a\u00020\u000bH J&\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.J!\u0010'\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H J&\u0010/\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u000201J!\u0010/\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u00100\u001a\u000201H J\u000e\u00102\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u0005J\u0016\u00102\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010+\u001a\u00020,J\u0011\u00102\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,H J\u001c\u00103\u001a\u00020\u000f2\n\u0010!\u001a\u0006\u0012\u0002\b\u00030\"2\u0006\u00104\u001a\u00020\rH\u0007J\u0018\u00105\u001a\u00020\u000f2\u0006\u0010!\u001a\u0002062\u0006\u00104\u001a\u00020\rH\u0007J\u0019\u00107\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u00104\u001a\u00020\rH R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u00020\u000b8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lexpo/modules/kotlin/jni/JSIContext;", "Lexpo/modules/kotlin/jni/Destructible;", "()V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "getAppContextHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setAppContextHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "createObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "deallocate", "", "deleteSharedObject", "id", "", "drainJSEventLoop", "evaluateScript", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "script", "", "finalize", "getCoreModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getJavaScriptModuleObject", "name", "getJavaScriptModulesName", "", "()[Ljava/lang/String;", "getJavascriptClass", "native", "Ljava/lang/Class;", "global", "hasModule", "", "initHybrid", "installJSI", "appContext", "jsRuntimePointer", "", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "jsInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "installJSIForBridgeless", "runtimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "installJSIForTests", "registerClass", "js", "registerSharedObject", "", "setNativeStateForSharedObject", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: JSIContext.kt */
public final class JSIContext implements Destructible {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public WeakReference<AppContext> appContextHolder;
    private final HybridData mHybridData = initHybrid();

    private final native HybridData initHybrid();

    private final native void installJSI(long j, JNIDeallocator jNIDeallocator, CallInvokerHolderImpl callInvokerHolderImpl);

    private final native void installJSIForBridgeless(long j, JNIDeallocator jNIDeallocator, RuntimeExecutor runtimeExecutor);

    private final native void installJSIForTests(JNIDeallocator jNIDeallocator);

    public final native JavaScriptObject createObject();

    public final native void drainJSEventLoop();

    public final native JavaScriptValue evaluateScript(String str) throws JavaScriptEvaluateException;

    public final native JavaScriptObject global();

    public final void setAppContextHolder$expo_modules_core_release(WeakReference<AppContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.appContextHolder = weakReference;
    }

    public final native void setNativeStateForSharedObject(int i, JavaScriptObject javaScriptObject);

    public final WeakReference<AppContext> getAppContextHolder$expo_modules_core_release() {
        WeakReference<AppContext> weakReference = this.appContextHolder;
        if (weakReference != null) {
            return weakReference;
        }
        Intrinsics.throwUninitializedPropertyAccessException("appContextHolder");
        return null;
    }

    public final void installJSI(AppContext appContext, long j, JNIDeallocator jNIDeallocator, CallInvokerHolderImpl callInvokerHolderImpl) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jNIDeallocator, "jniDeallocator");
        Intrinsics.checkNotNullParameter(callInvokerHolderImpl, "jsInvokerHolder");
        setAppContextHolder$expo_modules_core_release(UtilsKt.weak(appContext));
        installJSI(j, jNIDeallocator, callInvokerHolderImpl);
    }

    public final void installJSIForBridgeless(AppContext appContext, long j, JNIDeallocator jNIDeallocator, RuntimeExecutor runtimeExecutor) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jNIDeallocator, "jniDeallocator");
        Intrinsics.checkNotNullParameter(runtimeExecutor, "runtimeExecutor");
        setAppContextHolder$expo_modules_core_release(UtilsKt.weak(appContext));
        installJSIForBridgeless(j, jNIDeallocator, runtimeExecutor);
    }

    public final void installJSIForTests(AppContext appContext, JNIDeallocator jNIDeallocator) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(jNIDeallocator, "jniDeallocator");
        setAppContextHolder$expo_modules_core_release(UtilsKt.weak(appContext));
        installJSIForTests(jNIDeallocator);
    }

    public final void installJSIForTests(AppContext appContext) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        setAppContextHolder$expo_modules_core_release(UtilsKt.weak(appContext));
        installJSIForTests(appContext.getJniDeallocator());
    }

    public final JavaScriptModuleObject getJavaScriptModuleObject(String str) {
        ModuleRegistry registry;
        ModuleHolder<?> moduleHolder;
        Intrinsics.checkNotNullParameter(str, "name");
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext == null || (registry = appContext.getRegistry()) == null || (moduleHolder = registry.getModuleHolder(str)) == null) {
            return null;
        }
        return moduleHolder.getJsObject();
    }

    public final boolean hasModule(String str) {
        ModuleRegistry registry;
        Intrinsics.checkNotNullParameter(str, "name");
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext == null || (registry = appContext.getRegistry()) == null) {
            return false;
        }
        return registry.hasModule(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = (java.lang.String[]) (r0 = (r0 = (r0 = r0.getRegistry()).getRegistry()).keySet()).toArray(new java.lang.String[0]);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String[] getJavaScriptModulesName() {
        /*
            r3 = this;
            java.lang.ref.WeakReference r0 = r3.getAppContextHolder$expo_modules_core_release()
            java.lang.Object r0 = r0.get()
            expo.modules.kotlin.AppContext r0 = (expo.modules.kotlin.AppContext) r0
            r1 = 0
            if (r0 == 0) goto L_0x002b
            expo.modules.kotlin.ModuleRegistry r0 = r0.getRegistry()
            if (r0 == 0) goto L_0x002b
            java.util.Map r0 = r0.getRegistry()
            if (r0 == 0) goto L_0x002b
            java.util.Set r0 = r0.keySet()
            if (r0 == 0) goto L_0x002b
            java.util.Collection r0 = (java.util.Collection) r0
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.Object[] r0 = r0.toArray(r2)
            java.lang.String[] r0 = (java.lang.String[]) r0
            if (r0 != 0) goto L_0x002d
        L_0x002b:
            java.lang.String[] r0 = new java.lang.String[r1]
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.jni.JSIContext.getJavaScriptModulesName():java.lang.String[]");
    }

    public final void registerSharedObject(Object obj, JavaScriptObject javaScriptObject) {
        SharedObjectRegistry sharedObjectRegistry$expo_modules_core_release;
        Intrinsics.checkNotNullParameter(obj, "native");
        Intrinsics.checkNotNullParameter(javaScriptObject, "js");
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext != null && (sharedObjectRegistry$expo_modules_core_release = appContext.getSharedObjectRegistry$expo_modules_core_release()) != null) {
            SharedObjectId.m1187boximpl(sharedObjectRegistry$expo_modules_core_release.m1197add5WKnsLU$expo_modules_core_release((SharedObject) obj, javaScriptObject));
        }
    }

    public final void deleteSharedObject(int i) {
        SharedObjectRegistry sharedObjectRegistry$expo_modules_core_release;
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext != null && (sharedObjectRegistry$expo_modules_core_release = appContext.getSharedObjectRegistry$expo_modules_core_release()) != null) {
            sharedObjectRegistry$expo_modules_core_release.m1198deletekyJHjyY$expo_modules_core_release(SharedObjectId.m1188constructorimpl(i));
        }
    }

    public final void registerClass(Class<?> cls, JavaScriptObject javaScriptObject) {
        ClassRegistry classRegistry$expo_modules_core_release;
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(javaScriptObject, "js");
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext != null && (classRegistry$expo_modules_core_release = appContext.getClassRegistry$expo_modules_core_release()) != null) {
            classRegistry$expo_modules_core_release.add$expo_modules_core_release(cls, javaScriptObject);
        }
    }

    public final JavaScriptObject getJavascriptClass(Class<?> cls) {
        ClassRegistry classRegistry$expo_modules_core_release;
        Intrinsics.checkNotNullParameter(cls, "native");
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext == null || (classRegistry$expo_modules_core_release = appContext.getClassRegistry$expo_modules_core_release()) == null) {
            return null;
        }
        return classRegistry$expo_modules_core_release.toJavaScriptObject$expo_modules_core_release(cls);
    }

    public final JavaScriptModuleObject getCoreModuleObject() {
        ModuleHolder<CoreModule> coreModule$expo_modules_core_release;
        AppContext appContext = (AppContext) getAppContextHolder$expo_modules_core_release().get();
        if (appContext == null || (coreModule$expo_modules_core_release = appContext.getCoreModule$expo_modules_core_release()) == null) {
            return null;
        }
        return coreModule$expo_modules_core_release.getJsObject();
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        deallocate();
    }

    public void deallocate() {
        this.mHybridData.resetNative();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/kotlin/jni/JSIContext$Companion;", "", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: JSIContext.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
