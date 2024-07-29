package expo.modules.kotlin.jni;

import androidx.core.os.EnvironmentCompat;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.PromiseAlreadySettledException;
import expo.modules.kotlin.types.JSTypeConverter;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0011\u001a\u00020\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H\bJ$\u0010\u0015\u001a\u00020\u00122\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0017\u001a\u00020\u000bJ$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010\u001d\u001a\u00020\u00122\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\rH\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\"H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020#H\u0016J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u000bH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006$"}, d2 = {"Lexpo/modules/kotlin/jni/PromiseImpl;", "Lexpo/modules/kotlin/Promise;", "callback", "Lexpo/modules/kotlin/jni/JavaCallback;", "(Lexpo/modules/kotlin/jni/JavaCallback;)V", "appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "getCallback$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JavaCallback;", "fullFunctionName", "", "<set-?>", "", "wasSettled", "getWasSettled$expo_modules_core_release", "()Z", "checkIfWasSettled", "", "body", "Lkotlin/Function0;", "decorateWithDebugInformation", "moduleName", "functionName", "reject", "code", "message", "cause", "", "resolve", "value", "", "result", "", "", "", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PromiseImpl.kt */
public final class PromiseImpl implements Promise {
    private WeakReference<AppContext> appContextHolder;
    private final JavaCallback callback;
    private String fullFunctionName;
    private boolean wasSettled;

    public final JavaCallback getCallback$expo_modules_core_release() {
        return this.callback;
    }

    public final boolean getWasSettled$expo_modules_core_release() {
        return this.wasSettled;
    }

    public PromiseImpl(JavaCallback javaCallback) {
        Intrinsics.checkNotNullParameter(javaCallback, "callback");
        this.callback = javaCallback;
    }

    public void reject(CodedException codedException) {
        Promise.DefaultImpls.reject(this, codedException);
    }

    public void resolve() {
        Promise.DefaultImpls.resolve(this);
    }

    private final void checkIfWasSettled(Function0<Unit> function0) {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        function0.invoke();
        this.wasSettled = true;
    }

    public final void decorateWithDebugInformation(WeakReference<AppContext> weakReference, String str, String str2) {
        Intrinsics.checkNotNullParameter(weakReference, "appContextHolder");
        Intrinsics.checkNotNullParameter(str, "moduleName");
        Intrinsics.checkNotNullParameter(str2, "functionName");
        this.appContextHolder = weakReference;
        this.fullFunctionName = str + "." + str2;
    }

    public void resolve(Object obj) {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        this.callback.invoke(JSTypeConverter.convertToJSValue$default(JSTypeConverter.INSTANCE, obj, (JSTypeConverter.ContainerProvider) null, 2, (Object) null));
        this.wasSettled = true;
    }

    public void resolve(int i) {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        this.callback.invoke(i);
        this.wasSettled = true;
    }

    public void resolve(boolean z) {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        this.callback.invoke(z);
        this.wasSettled = true;
    }

    public void resolve(double d) {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        this.callback.invoke(d);
        this.wasSettled = true;
    }

    public void resolve(float f) {
        AppContext appContext;
        if (this.wasSettled) {
            String str = this.fullFunctionName;
            if (str == null) {
                str = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        this.callback.invoke(f);
        this.wasSettled = true;
    }

    public void resolve(String str) {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(str, "result");
        if (this.wasSettled) {
            String str2 = this.fullFunctionName;
            if (str2 == null) {
                str2 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str2);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        this.callback.invoke(str);
        this.wasSettled = true;
    }

    public void reject(String str, String str2, Throwable th) {
        AppContext appContext;
        Intrinsics.checkNotNullParameter(str, "code");
        boolean z = this.wasSettled;
        String str3 = EnvironmentCompat.MEDIA_UNKNOWN;
        if (z) {
            String str4 = this.fullFunctionName;
            if (str4 != null) {
                str3 = str4;
            }
            PromiseAlreadySettledException promiseAlreadySettledException = new PromiseAlreadySettledException(str3);
            WeakReference<AppContext> weakReference = this.appContextHolder;
            if (!(weakReference == null || (appContext = (AppContext) weakReference.get()) == null)) {
                appContext.getErrorManager();
            }
            throw promiseAlreadySettledException;
        }
        JavaCallback javaCallback = this.callback;
        if (str2 == null) {
            str2 = th != null ? th.getMessage() : null;
            if (str2 == null) {
                str2 = str3;
            }
        }
        javaCallback.invoke(str, str2);
        this.wasSettled = true;
    }
}
