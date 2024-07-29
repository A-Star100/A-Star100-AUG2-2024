package kotlin.reflect.jvm.internal.impl.descriptors;

/* compiled from: ClassKind.kt */
public enum ClassKind {
    CLASS("class"),
    INTERFACE("interface"),
    ENUM_CLASS("enum class"),
    ENUM_ENTRY((String) null),
    ANNOTATION_CLASS("annotation class"),
    OBJECT("object");
    
    private final String codeRepresentation;

    public final boolean isSingleton() {
        return this == OBJECT || this == ENUM_ENTRY;
    }

    private ClassKind(String str) {
        this.codeRepresentation = str;
    }
}
