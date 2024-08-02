package org.apache.commons.pool2.impl;

import org.apache.commons.pool2.PooledObject;

public interface EvictionPolicy<T> {
    boolean evict(EvictionConfig evictionConfig, PooledObject<T> pooledObject, int i);
}
