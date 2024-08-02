package org.apache.commons.pool2;

import java.util.NoSuchElementException;

public interface KeyedObjectPool<K, V> {
    void addObject(K k) throws Exception, IllegalStateException, UnsupportedOperationException;

    V borrowObject(K k) throws Exception, NoSuchElementException, IllegalStateException;

    void clear() throws Exception, UnsupportedOperationException;

    void clear(K k) throws Exception, UnsupportedOperationException;

    void close();

    int getNumActive();

    int getNumActive(K k);

    int getNumIdle();

    int getNumIdle(K k);

    void invalidateObject(K k, V v) throws Exception;

    void returnObject(K k, V v) throws Exception;
}
