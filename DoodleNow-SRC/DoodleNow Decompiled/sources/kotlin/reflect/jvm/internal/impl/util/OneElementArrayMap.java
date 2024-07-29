package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ArrayMap.kt */
public final class OneElementArrayMap<T> extends ArrayMap<T> {
    private final int index;
    private final T value;

    public T get(int i) {
        if (i == this.index) {
            return this.value;
        }
        return null;
    }

    public final int getIndex() {
        return this.index;
    }

    public int getSize() {
        return 1;
    }

    public final T getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OneElementArrayMap(T t, int i) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(t, "value");
        this.value = t;
        this.index = i;
    }

    public void set(int i, T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        throw new IllegalStateException();
    }

    public Iterator<T> iterator() {
        return new OneElementArrayMap$iterator$1(this);
    }
}
