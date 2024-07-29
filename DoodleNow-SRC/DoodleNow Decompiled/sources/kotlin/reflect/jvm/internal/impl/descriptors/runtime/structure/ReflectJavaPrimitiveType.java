package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaAnnotation;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: ReflectJavaPrimitiveType.kt */
public final class ReflectJavaPrimitiveType extends ReflectJavaType implements JavaPrimitiveType {
    private final Collection<JavaAnnotation> annotations = CollectionsKt.emptyList();
    private final boolean isDeprecatedInJavaDoc;
    private final Class<?> reflectType;

    public Collection<JavaAnnotation> getAnnotations() {
        return this.annotations;
    }

    /* access modifiers changed from: protected */
    public Class<?> getReflectType() {
        return this.reflectType;
    }

    public boolean isDeprecatedInJavaDoc() {
        return this.isDeprecatedInJavaDoc;
    }

    public ReflectJavaPrimitiveType(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "reflectType");
        this.reflectType = cls;
    }

    public PrimitiveType getType() {
        if (Intrinsics.areEqual((Object) getReflectType(), (Object) Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(getReflectType().getName()).getPrimitiveType();
    }
}
