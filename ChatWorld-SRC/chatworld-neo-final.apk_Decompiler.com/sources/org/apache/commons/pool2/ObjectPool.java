package org.apache.commons.pool2;

import java.util.NoSuchElementException;

public interface ObjectPool<T> {
    void addObject() throws Exception, IllegalStateException, UnsupportedOperationException;

    T borrowObject() throws Exception, NoSuchElementException, IllegalStateException;

    void clear() throws Exception, UnsupportedOperationException;

    void close();

    int getNumActive();

    int getNumIdle();

    void invalidateObject(T t) throws Exception;

    void returnObject(T t) throws Exception;
}
