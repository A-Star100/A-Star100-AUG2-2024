package org.apache.commons.pool2.impl;

public class GenericKeyedObjectPoolConfig extends BaseObjectPoolConfig {
    public static final int DEFAULT_MAX_IDLE_PER_KEY = 8;
    public static final int DEFAULT_MAX_TOTAL = -1;
    public static final int DEFAULT_MAX_TOTAL_PER_KEY = 8;
    public static final int DEFAULT_MIN_IDLE_PER_KEY = 0;
    private int maxIdlePerKey = 8;
    private int maxTotal = -1;
    private int maxTotalPerKey = 8;
    private int minIdlePerKey = 0;

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public void setMaxTotal(int maxTotal2) {
        this.maxTotal = maxTotal2;
    }

    public int getMaxTotalPerKey() {
        return this.maxTotalPerKey;
    }

    public void setMaxTotalPerKey(int maxTotalPerKey2) {
        this.maxTotalPerKey = maxTotalPerKey2;
    }

    public int getMinIdlePerKey() {
        return this.minIdlePerKey;
    }

    public void setMinIdlePerKey(int minIdlePerKey2) {
        this.minIdlePerKey = minIdlePerKey2;
    }

    public int getMaxIdlePerKey() {
        return this.maxIdlePerKey;
    }

    public void setMaxIdlePerKey(int maxIdlePerKey2) {
        this.maxIdlePerKey = maxIdlePerKey2;
    }

    public GenericKeyedObjectPoolConfig clone() {
        try {
            return (GenericKeyedObjectPoolConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
