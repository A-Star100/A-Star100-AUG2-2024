package com.google.common.collect;

@ElementTypesAreNonnullByDefault
public enum BoundType {
    OPEN(false),
    CLOSED(true);
    
    final boolean inclusive;

    static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }

    private BoundType(boolean z) {
        this.inclusive = z;
    }
}
