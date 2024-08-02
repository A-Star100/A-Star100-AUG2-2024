package redis.clients.util;

import java.io.Closeable;
import java.util.NoSuchElementException;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisException;

public abstract class Pool<T> implements Closeable {
    protected GenericObjectPool<T> internalPool;

    public Pool() {
    }

    public Pool(GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
        initPool(poolConfig, factory);
    }

    public void close() {
        destroy();
    }

    public boolean isClosed() {
        return this.internalPool.isClosed();
    }

    public void initPool(GenericObjectPoolConfig poolConfig, PooledObjectFactory<T> factory) {
        if (this.internalPool != null) {
            try {
                closeInternalPool();
            } catch (Exception e) {
            }
        }
        this.internalPool = new GenericObjectPool<>(factory, poolConfig);
    }

    public T getResource() {
        try {
            return this.internalPool.borrowObject();
        } catch (NoSuchElementException nse) {
            throw new JedisException("Could not get a resource from the pool", nse);
        } catch (Exception e) {
            throw new JedisConnectionException("Could not get a resource from the pool", e);
        }
    }

    /* access modifiers changed from: protected */
    public void returnResourceObject(T resource) {
        if (resource != null) {
            try {
                this.internalPool.returnObject(resource);
            } catch (Exception e) {
                throw new JedisException("Could not return the resource to the pool", e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void returnBrokenResource(T resource) {
        if (resource != null) {
            returnBrokenResourceObject(resource);
        }
    }

    /* access modifiers changed from: protected */
    public void returnResource(T resource) {
        if (resource != null) {
            returnResourceObject(resource);
        }
    }

    public void destroy() {
        closeInternalPool();
    }

    /* access modifiers changed from: protected */
    public void returnBrokenResourceObject(T resource) {
        try {
            this.internalPool.invalidateObject(resource);
        } catch (Exception e) {
            throw new JedisException("Could not return the resource to the pool", e);
        }
    }

    /* access modifiers changed from: protected */
    public void closeInternalPool() {
        try {
            this.internalPool.close();
        } catch (Exception e) {
            throw new JedisException("Could not destroy the pool", e);
        }
    }

    public int getNumActive() {
        if (poolInactive()) {
            return -1;
        }
        return this.internalPool.getNumActive();
    }

    public int getNumIdle() {
        if (poolInactive()) {
            return -1;
        }
        return this.internalPool.getNumIdle();
    }

    public int getNumWaiters() {
        if (poolInactive()) {
            return -1;
        }
        return this.internalPool.getNumWaiters();
    }

    public long getMeanBorrowWaitTimeMillis() {
        if (poolInactive()) {
            return -1;
        }
        return this.internalPool.getMeanBorrowWaitTimeMillis();
    }

    public long getMaxBorrowWaitTimeMillis() {
        if (poolInactive()) {
            return -1;
        }
        return this.internalPool.getMaxBorrowWaitTimeMillis();
    }

    private boolean poolInactive() {
        GenericObjectPool<T> genericObjectPool = this.internalPool;
        return genericObjectPool == null || genericObjectPool.isClosed();
    }

    public void addObjects(int count) {
        int i = 0;
        while (i < count) {
            try {
                this.internalPool.addObject();
                i++;
            } catch (Exception e) {
                throw new JedisException("Error trying to add idle objects", e);
            }
        }
    }
}
