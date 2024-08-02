package org.apache.commons.pool2;

public abstract class BasePooledObjectFactory<T> implements PooledObjectFactory<T> {
    public abstract T create() throws Exception;

    public abstract PooledObject<T> wrap(T t);

    public PooledObject<T> makeObject() throws Exception {
        return wrap(create());
    }

    public void destroyObject(PooledObject<T> pooledObject) throws Exception {
    }

    public boolean validateObject(PooledObject<T> pooledObject) {
        return true;
    }

    public void activateObject(PooledObject<T> pooledObject) throws Exception {
    }

    public void passivateObject(PooledObject<T> pooledObject) throws Exception {
    }
}
