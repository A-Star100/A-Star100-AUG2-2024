package com.google.common.collect;

import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    static final AllEqualOrdering INSTANCE = new AllEqualOrdering();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    public int compare(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return 0;
    }

    public <S> Ordering<S> reverse() {
        return this;
    }

    public String toString() {
        return "Ordering.allEqual()";
    }

    AllEqualOrdering() {
    }

    public <E> List<E> sortedCopy(Iterable<E> iterable) {
        return Lists.newArrayList(iterable);
    }

    public <E> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.copyOf(iterable);
    }
}
