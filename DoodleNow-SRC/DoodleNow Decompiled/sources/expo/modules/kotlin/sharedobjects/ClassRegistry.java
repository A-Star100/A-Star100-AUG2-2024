package expo.modules.kotlin.sharedobjects;

import expo.modules.kotlin.jni.JavaScriptObject;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000fJ\u0014\u0010\u0010\u001a\u00020\f2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0002J\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0000¢\u0006\u0002\b\u0012R*\u0010\u0003\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "", "()V", "pairs", "", "Ljava/lang/Class;", "Lexpo/modules/kotlin/jni/JavaScriptObject;", "getPairs$expo_modules_core_release", "()Ljava/util/Map;", "setPairs$expo_modules_core_release", "(Ljava/util/Map;)V", "add", "", "native", "js", "add$expo_modules_core_release", "delete", "toJavaScriptObject", "toJavaScriptObject$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ClassRegistry.kt */
public final class ClassRegistry {
    private Map<Class<?>, JavaScriptObject> pairs = new LinkedHashMap();

    public final Map<Class<?>, JavaScriptObject> getPairs$expo_modules_core_release() {
        return this.pairs;
    }

    public final void setPairs$expo_modules_core_release(Map<Class<?>, JavaScriptObject> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pairs = map;
    }

    public final void add$expo_modules_core_release(Class<?> cls, JavaScriptObject javaScriptObject) {
        Intrinsics.checkNotNullParameter(cls, "native");
        Intrinsics.checkNotNullParameter(javaScriptObject, "js");
        javaScriptObject.defineDeallocator$expo_modules_core_release(new ClassRegistry$add$1(this, cls));
        this.pairs.put(cls, javaScriptObject);
    }

    /* access modifiers changed from: private */
    public final void delete(Class<?> cls) {
        this.pairs.remove(cls);
    }

    public final JavaScriptObject toJavaScriptObject$expo_modules_core_release(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "native");
        return this.pairs.get(cls);
    }
}
