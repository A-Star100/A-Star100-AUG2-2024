package org.apache.commons.pool2;

import java.io.PrintWriter;
import java.util.Deque;

public interface PooledObject<T> extends Comparable<PooledObject<T>> {
    boolean allocate();

    int compareTo(PooledObject<T> pooledObject);

    boolean deallocate();

    boolean endEvictionTest(Deque<PooledObject<T>> deque);

    boolean equals(Object obj);

    long getActiveTimeMillis();

    long getCreateTime();

    long getIdleTimeMillis();

    long getLastBorrowTime();

    long getLastReturnTime();

    long getLastUsedTime();

    T getObject();

    PooledObjectState getState();

    int hashCode();

    void invalidate();

    void markAbandoned();

    void markReturning();

    void printStackTrace(PrintWriter printWriter);

    void setLogAbandoned(boolean z);

    boolean startEvictionTest();

    String toString();

    void use();
}
