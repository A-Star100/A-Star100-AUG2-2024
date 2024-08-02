package org.apache.commons.pool2;

public interface KeyedPooledObjectFactory<K, V> {
    void activateObject(K k, PooledObject<V> pooledObject) throws Exception;

    void destroyObject(K k, PooledObject<V> pooledObject) throws Exception;

    PooledObject<V> makeObject(K k) throws Exception;

    void passivateObject(K k, PooledObject<V> pooledObject) throws Exception;

    boolean validateObject(K k, PooledObject<V> pooledObject);
}
