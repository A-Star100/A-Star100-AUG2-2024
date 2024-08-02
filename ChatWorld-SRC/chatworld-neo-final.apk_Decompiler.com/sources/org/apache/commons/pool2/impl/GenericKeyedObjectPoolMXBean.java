package org.apache.commons.pool2.impl;

import java.util.List;
import java.util.Map;

public interface GenericKeyedObjectPoolMXBean<K> {
    boolean getBlockWhenExhausted();

    long getBorrowedCount();

    long getCreatedCount();

    String getCreationStackTrace();

    long getDestroyedByBorrowValidationCount();

    long getDestroyedByEvictorCount();

    long getDestroyedCount();

    boolean getFairness();

    boolean getLifo();

    long getMaxBorrowWaitTimeMillis();

    int getMaxIdlePerKey();

    int getMaxTotal();

    int getMaxTotalPerKey();

    long getMaxWaitMillis();

    long getMeanActiveTimeMillis();

    long getMeanBorrowWaitTimeMillis();

    long getMeanIdleTimeMillis();

    long getMinEvictableIdleTimeMillis();

    int getMinIdlePerKey();

    int getNumActive();

    Map<String, Integer> getNumActivePerKey();

    int getNumIdle();

    int getNumTestsPerEvictionRun();

    int getNumWaiters();

    Map<String, Integer> getNumWaitersByKey();

    long getReturnedCount();

    boolean getTestOnBorrow();

    boolean getTestOnCreate();

    boolean getTestOnReturn();

    boolean getTestWhileIdle();

    long getTimeBetweenEvictionRunsMillis();

    boolean isClosed();

    Map<String, List<DefaultPooledObjectInfo>> listAllObjects();
}
