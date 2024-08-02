package org.apache.commons.pool2;

public abstract class BaseKeyedPooledObjectFactory<K, V> implements KeyedPooledObjectFactory<K, V> {
    public abstract V create(K k) throws Exception;

    public abstract PooledObject<V> wrap(V v);

    public PooledObject<V> makeObject(K key) throws Exception {
        return wrap(create(key));
    }

    public void destroyObject(K k, PooledObject<V> pooledObject) throws Exception {
    }

    public boolean validateObject(K k, PooledObject<V> pooledObject) {
        return true;
    }

    public void activateObject(K k, PooledObject<V> pooledObject) throws Exception {
    }

    public void passivateObject(K k, PooledObject<V> pooledObject) throws Exception {
    }
}
