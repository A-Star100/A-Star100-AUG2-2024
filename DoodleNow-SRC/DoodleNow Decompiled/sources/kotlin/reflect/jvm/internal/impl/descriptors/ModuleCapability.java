package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModuleCapability.kt */
public final class ModuleCapability<T> {
    private final String name;

    public String toString() {
        return this.name;
    }

    public ModuleCapability(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }
}
