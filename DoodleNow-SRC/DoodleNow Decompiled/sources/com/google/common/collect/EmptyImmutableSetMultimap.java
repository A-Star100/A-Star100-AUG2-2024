package com.google.common.collect;

import java.util.Comparator;

@ElementTypesAreNonnullByDefault
class EmptyImmutableSetMultimap extends ImmutableSetMultimap<Object, Object> {
    static final EmptyImmutableSetMultimap INSTANCE = new EmptyImmutableSetMultimap();
    private static final long serialVersionUID = 0;

    private Object readResolve() {
        return INSTANCE;
    }

    private EmptyImmutableSetMultimap() {
        super(ImmutableMap.of(), 0, (Comparator) null);
    }
}
