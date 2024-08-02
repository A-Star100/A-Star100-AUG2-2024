package org.apache.commons.pool2;

public interface PooledObjectFactory<T> {
    void activateObject(PooledObject<T> pooledObject) throws Exception;

    void destroyObject(PooledObject<T> pooledObject) throws Exception;

    PooledObject<T> makeObject() throws Exception;

    void passivateObject(PooledObject<T> pooledObject) throws Exception;

    boolean validateObject(PooledObject<T> pooledObject);
}
