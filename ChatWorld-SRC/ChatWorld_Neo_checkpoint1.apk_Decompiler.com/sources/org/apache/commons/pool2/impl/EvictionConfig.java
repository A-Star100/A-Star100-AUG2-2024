package org.apache.commons.pool2.impl;

public class EvictionConfig {
    private final long idleEvictTime;
    private final long idleSoftEvictTime;
    private final int minIdle;

    public EvictionConfig(long poolIdleEvictTime, long poolIdleSoftEvictTime, int minIdle2) {
        if (poolIdleEvictTime > 0) {
            this.idleEvictTime = poolIdleEvictTime;
        } else {
            this.idleEvictTime = Long.MAX_VALUE;
        }
        if (poolIdleSoftEvictTime > 0) {
            this.idleSoftEvictTime = poolIdleSoftEvictTime;
        } else {
            this.idleSoftEvictTime = Long.MAX_VALUE;
        }
        this.minIdle = minIdle2;
    }

    public long getIdleEvictTime() {
        return this.idleEvictTime;
    }

    public long getIdleSoftEvictTime() {
        return this.idleSoftEvictTime;
    }

    public int getMinIdle() {
        return this.minIdle;
    }
}
