package expo.modules.kotlin.sharedobjects;

import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.jni.JavaScriptFunction;
import expo.modules.kotlin.jni.JavaScriptObject;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J+\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u001a2\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001c\"\u0004\u0018\u00010\u0001¢\u0006\u0002\u0010\u001dR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u00020\u000eX\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001e"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/SharedObject;", "", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Lexpo/modules/kotlin/AppContext;)V", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "appContextHolder", "Ljava/lang/ref/WeakReference;", "getAppContextHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setAppContextHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "sharedObjectId", "Lexpo/modules/kotlin/sharedobjects/SharedObjectId;", "getSharedObjectId-HSeVr_g$expo_modules_core_release", "()I", "setSharedObjectId-kyJHjyY$expo_modules_core_release", "(I)V", "I", "deallocate", "", "getJavaScriptObject", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "sendEvent", "eventName", "", "args", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: SharedObject.kt */
public class SharedObject {
    private WeakReference<AppContext> appContextHolder;
    private int sharedObjectId;

    public SharedObject() {
        this((AppContext) null, 1, (DefaultConstructorMarker) null);
    }

    public void deallocate() {
    }

    public final WeakReference<AppContext> getAppContextHolder$expo_modules_core_release() {
        return this.appContextHolder;
    }

    /* renamed from: getSharedObjectId-HSeVr_g$expo_modules_core_release  reason: not valid java name */
    public final int m1185getSharedObjectIdHSeVr_g$expo_modules_core_release() {
        return this.sharedObjectId;
    }

    public final void setAppContextHolder$expo_modules_core_release(WeakReference<AppContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this.appContextHolder = weakReference;
    }

    /* renamed from: setSharedObjectId-kyJHjyY$expo_modules_core_release  reason: not valid java name */
    public final void m1186setSharedObjectIdkyJHjyY$expo_modules_core_release(int i) {
        this.sharedObjectId = i;
    }

    public SharedObject(AppContext appContext) {
        this.sharedObjectId = SharedObjectId.m1188constructorimpl(0);
        this.appContextHolder = new WeakReference<>(appContext);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SharedObject(AppContext appContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : appContext);
    }

    public final AppContext getAppContext() {
        return (AppContext) this.appContextHolder.get();
    }

    private final JavaScriptObject getJavaScriptObject() {
        int r0 = SharedObjectId.m1188constructorimpl(this.sharedObjectId);
        AppContext appContext = getAppContext();
        if (appContext == null) {
            return null;
        }
        return SharedObjectId.m1192toJavaScriptObjectimpl(r0, appContext);
    }

    public final void sendEvent(String str, Object... objArr) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        Intrinsics.checkNotNullParameter(objArr, "args");
        JavaScriptObject javaScriptObject = getJavaScriptObject();
        if (javaScriptObject != null) {
            try {
                JavaScriptFunction internalJniGetFunction = javaScriptObject.getProperty("emit").internalJniGetFunction();
                internalJniGetFunction.setReturnType(Reflection.nullableTypeOf(Unit.class));
                SpreadBuilder spreadBuilder = new SpreadBuilder(2);
                spreadBuilder.add(str);
                spreadBuilder.addSpread(objArr);
                internalJniGetFunction.invoke(spreadBuilder.toArray(new Object[spreadBuilder.size()]), javaScriptObject, getAppContext());
            } catch (Throwable th) {
                Logger logger = CoreLoggerKt.getLogger();
                String simpleName = getClass().getSimpleName();
                logger.error("Unable to send event '" + str + "' by shared object of type " + simpleName, th);
            }
        }
    }
}
