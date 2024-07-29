package kotlin.reflect.jvm.internal.impl.types.extensions;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributeTranslator;

/* compiled from: TypeAttributeTranslators.kt */
public final class TypeAttributeTranslators {
    private final List<TypeAttributeTranslator> translators;

    public final List<TypeAttributeTranslator> getTranslators() {
        return this.translators;
    }

    public TypeAttributeTranslators(List<? extends TypeAttributeTranslator> list) {
        Intrinsics.checkNotNullParameter(list, "translators");
        this.translators = list;
    }
}
