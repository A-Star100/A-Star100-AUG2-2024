package com.facebook.yoga;

import com.polidea.rxandroidble2.exceptions.BleScanException;

public enum YogaErrata {
    NONE(0),
    STRETCH_FLEX_BASIS(1),
    ABSOLUTE_POSITIONING_INCORRECT(2),
    ABSOLUTE_PERCENT_AGAINST_INNER_SIZE(4),
    ALL(Integer.MAX_VALUE),
    CLASSIC(BleScanException.UNDOCUMENTED_SCAN_THROTTLE);
    
    private final int mIntValue;

    public int intValue() {
        return this.mIntValue;
    }

    private YogaErrata(int i) {
        this.mIntValue = i;
    }

    public static YogaErrata fromInt(int i) {
        if (i == 0) {
            return NONE;
        }
        if (i == 1) {
            return STRETCH_FLEX_BASIS;
        }
        if (i == 2) {
            return ABSOLUTE_POSITIONING_INCORRECT;
        }
        if (i == 4) {
            return ABSOLUTE_PERCENT_AGAINST_INNER_SIZE;
        }
        switch (i) {
            case BleScanException.UNDOCUMENTED_SCAN_THROTTLE /*2147483646*/:
                return CLASSIC;
            case Integer.MAX_VALUE:
                return ALL;
            default:
                throw new IllegalArgumentException("Unknown enum value: " + i);
        }
    }
}
