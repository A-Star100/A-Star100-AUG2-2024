package com.facebook.common.time;

import android.os.SystemClock;

public class RealtimeSinceBootClock implements MonotonicClock {
    private static final RealtimeSinceBootClock INSTANCE = new RealtimeSinceBootClock();

    public static RealtimeSinceBootClock get() {
        return INSTANCE;
    }

    private RealtimeSinceBootClock() {
    }

    public long now() {
        return SystemClock.elapsedRealtime();
    }
}
