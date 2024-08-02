package org.apache.commons.pool2.impl;

public abstract class BaseObjectPoolConfig implements Cloneable {
    public static final boolean DEFAULT_BLOCK_WHEN_EXHAUSTED = true;
    public static final String DEFAULT_EVICTION_POLICY_CLASS_NAME = "org.apache.commons.pool2.impl.DefaultEvictionPolicy";
    public static final boolean DEFAULT_FAIRNESS = false;
    public static final boolean DEFAULT_JMX_ENABLE = true;
    public static final String DEFAULT_JMX_NAME_BASE = null;
    public static final String DEFAULT_JMX_NAME_PREFIX = "pool";
    public static final boolean DEFAULT_LIFO = true;
    public static final long DEFAULT_MAX_WAIT_MILLIS = -1;
    public static final long DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS = 1800000;
    public static final int DEFAULT_NUM_TESTS_PER_EVICTION_RUN = 3;
    public static final long DEFAULT_SOFT_MIN_EVICTABLE_IDLE_TIME_MILLIS = -1;
    public static final boolean DEFAULT_TEST_ON_BORROW = false;
    public static final boolean DEFAULT_TEST_ON_CREATE = false;
    public static final boolean DEFAULT_TEST_ON_RETURN = false;
    public static final boolean DEFAULT_TEST_WHILE_IDLE = false;
    public static final long DEFAULT_TIME_BETWEEN_EVICTION_RUNS_MILLIS = -1;
    private boolean blockWhenExhausted = true;
    private String evictionPolicyClassName = DEFAULT_EVICTION_POLICY_CLASS_NAME;
    private boolean fairness = false;
    private boolean jmxEnabled = true;
    private String jmxNameBase = DEFAULT_JMX_NAME_BASE;
    private String jmxNamePrefix = DEFAULT_JMX_NAME_PREFIX;
    private boolean lifo = true;
    private long maxWaitMillis = -1;
    private long minEvictableIdleTimeMillis = DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
    private int numTestsPerEvictionRun = 3;
    private long softMinEvictableIdleTimeMillis = DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
    private boolean testOnBorrow = false;
    private boolean testOnCreate = false;
    private boolean testOnReturn = false;
    private boolean testWhileIdle = false;
    private long timeBetweenEvictionRunsMillis = -1;

    public boolean getLifo() {
        return this.lifo;
    }

    public boolean getFairness() {
        return this.fairness;
    }

    public void setLifo(boolean lifo2) {
        this.lifo = lifo2;
    }

    public void setFairness(boolean fairness2) {
        this.fairness = fairness2;
    }

    public long getMaxWaitMillis() {
        return this.maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis2) {
        this.maxWaitMillis = maxWaitMillis2;
    }

    public long getMinEvictableIdleTimeMillis() {
        return this.minEvictableIdleTimeMillis;
    }

    public void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis2) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis2;
    }

    public long getSoftMinEvictableIdleTimeMillis() {
        return this.softMinEvictableIdleTimeMillis;
    }

    public void setSoftMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis2) {
        this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis2;
    }

    public int getNumTestsPerEvictionRun() {
        return this.numTestsPerEvictionRun;
    }

    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun2) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun2;
    }

    public boolean getTestOnCreate() {
        return this.testOnCreate;
    }

    public void setTestOnCreate(boolean testOnCreate2) {
        this.testOnCreate = testOnCreate2;
    }

    public boolean getTestOnBorrow() {
        return this.testOnBorrow;
    }

    public void setTestOnBorrow(boolean testOnBorrow2) {
        this.testOnBorrow = testOnBorrow2;
    }

    public boolean getTestOnReturn() {
        return this.testOnReturn;
    }

    public void setTestOnReturn(boolean testOnReturn2) {
        this.testOnReturn = testOnReturn2;
    }

    public boolean getTestWhileIdle() {
        return this.testWhileIdle;
    }

    public void setTestWhileIdle(boolean testWhileIdle2) {
        this.testWhileIdle = testWhileIdle2;
    }

    public long getTimeBetweenEvictionRunsMillis() {
        return this.timeBetweenEvictionRunsMillis;
    }

    public void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis2) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis2;
    }

    public String getEvictionPolicyClassName() {
        return this.evictionPolicyClassName;
    }

    public void setEvictionPolicyClassName(String evictionPolicyClassName2) {
        this.evictionPolicyClassName = evictionPolicyClassName2;
    }

    public boolean getBlockWhenExhausted() {
        return this.blockWhenExhausted;
    }

    public void setBlockWhenExhausted(boolean blockWhenExhausted2) {
        this.blockWhenExhausted = blockWhenExhausted2;
    }

    public boolean getJmxEnabled() {
        return this.jmxEnabled;
    }

    public void setJmxEnabled(boolean jmxEnabled2) {
        this.jmxEnabled = jmxEnabled2;
    }

    public String getJmxNameBase() {
        return this.jmxNameBase;
    }

    public void setJmxNameBase(String jmxNameBase2) {
        this.jmxNameBase = jmxNameBase2;
    }

    public String getJmxNamePrefix() {
        return this.jmxNamePrefix;
    }

    public void setJmxNamePrefix(String jmxNamePrefix2) {
        this.jmxNamePrefix = jmxNamePrefix2;
    }
}
