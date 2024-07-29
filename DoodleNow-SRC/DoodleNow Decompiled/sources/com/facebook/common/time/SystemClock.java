package com.facebook.common.time;

public class SystemClock implements Clock {
    private static final SystemClock INSTANCE = new SystemClock();

    public static SystemClock get() {
        return INSTANCE;
    }

    private SystemClock() {
    }

    public long now() {
        return System.currentTimeMillis();
    }
}
