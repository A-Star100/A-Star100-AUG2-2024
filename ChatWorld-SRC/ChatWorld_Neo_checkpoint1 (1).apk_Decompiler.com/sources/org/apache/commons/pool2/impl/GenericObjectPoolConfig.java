package org.apache.commons.pool2.impl;

public class GenericObjectPoolConfig extends BaseObjectPoolConfig {
    public static final int DEFAULT_MAX_IDLE = 8;
    public static final int DEFAULT_MAX_TOTAL = 8;
    public static final int DEFAULT_MIN_IDLE = 0;
    private int maxIdle = 8;
    private int maxTotal = 8;
    private int minIdle = 0;

    public int getMaxTotal() {
        return this.maxTotal;
    }

    public void setMaxTotal(int maxTotal2) {
        this.maxTotal = maxTotal2;
    }

    public int getMaxIdle() {
        return this.maxIdle;
    }

    public void setMaxIdle(int maxIdle2) {
        this.maxIdle = maxIdle2;
    }

    public int getMinIdle() {
        return this.minIdle;
    }

    public void setMinIdle(int minIdle2) {
        this.minIdle = minIdle2;
    }

    public GenericObjectPoolConfig clone() {
        try {
            return (GenericObjectPoolConfig) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
