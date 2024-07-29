package expo.modules.kotlin.jni;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.sharedobjects.SharedRef;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0017\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\bJ\b\u0010\t\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0006H\u0004J\u0013\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000eH\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fH\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0010H\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0011H\u0002J\u0011\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0012H\u0002J\u0019\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\t\u0010\u0015\u001a\u00020\u0006H J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0016H J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0017H J\u0015\u0010\u0015\u001a\u00020\u00062\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u0018H J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000eH J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fH J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0010H J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0011H J\u0011\u0010\u0015\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0012H J\u0019\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u0012H R\u0010\u0010\u0002\u001a\u00020\u00038\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lexpo/modules/kotlin/jni/JavaCallback;", "Lexpo/modules/kotlin/jni/Destructible;", "mHybridData", "Lcom/facebook/jni/HybridData;", "(Lcom/facebook/jni/HybridData;)V", "checkIfValid", "", "body", "Lkotlin/Function0;", "deallocate", "finalize", "invoke", "result", "", "", "", "", "", "", "code", "errorMessage", "invokeNative", "Lcom/facebook/react/bridge/WritableNativeArray;", "Lcom/facebook/react/bridge/WritableNativeMap;", "Lexpo/modules/kotlin/sharedobjects/SharedRef;", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: JavaCallback.kt */
public final class JavaCallback implements Destructible {
    private final HybridData mHybridData;

    private final native void invokeNative();

    private final native void invokeNative(double d);

    private final native void invokeNative(float f);

    private final native void invokeNative(int i);

    private final native void invokeNative(WritableNativeArray writableNativeArray);

    private final native void invokeNative(WritableNativeMap writableNativeMap);

    private final native void invokeNative(SharedRef<?> sharedRef);

    private final native void invokeNative(String str);

    private final native void invokeNative(String str, String str2);

    private final native void invokeNative(boolean z);

    public JavaCallback(HybridData hybridData) {
        Intrinsics.checkNotNullParameter(hybridData, "mHybridData");
        this.mHybridData = hybridData;
    }

    public final void invoke(Object obj) {
        if (obj == null) {
            try {
                invokeNative();
            } catch (Throwable th) {
                if (!this.mHybridData.isValid()) {
                    CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                    return;
                }
                throw th;
            }
        } else if (obj instanceof Integer) {
            invokeNative(((Number) obj).intValue());
        } else if (obj instanceof Boolean) {
            invokeNative(((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            invokeNative(((Number) obj).doubleValue());
        } else if (obj instanceof Float) {
            invokeNative(((Number) obj).floatValue());
        } else if (obj instanceof String) {
            invokeNative((String) obj);
        } else if (obj instanceof WritableNativeArray) {
            invokeNative((WritableNativeArray) obj);
        } else if (obj instanceof WritableNativeMap) {
            invokeNative((WritableNativeMap) obj);
        } else if (obj instanceof SharedRef) {
            invokeNative((SharedRef<?>) (SharedRef) obj);
        } else {
            Class<?> cls = obj.getClass();
            throw new UnexpectedException("Unknown type: " + cls);
        }
    }

    public final void invoke(int i) {
        try {
            invokeNative(i);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(boolean z) {
        try {
            invokeNative(z);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(double d) {
        try {
            invokeNative(d);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(float f) {
        try {
            invokeNative(f);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(String str) {
        Intrinsics.checkNotNullParameter(str, "result");
        try {
            invokeNative(str);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    public final void invoke(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "code");
        Intrinsics.checkNotNullParameter(str2, "errorMessage");
        try {
            invokeNative(str, str2);
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    private final void checkIfValid(Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            if (!this.mHybridData.isValid()) {
                CoreLoggerKt.getLogger().error("Invalidated JavaCallback was invoked", th);
                return;
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        deallocate();
    }

    public void deallocate() {
        this.mHybridData.resetNative();
    }
}
