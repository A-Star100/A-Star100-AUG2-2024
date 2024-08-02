package org.apache.commons.pool2;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class PoolUtils {

    static class TimerHolder {
        static final Timer MIN_IDLE_TIMER = new Timer(true);

        TimerHolder() {
        }
    }

    public static void checkRethrow(Throwable t) {
        if (t instanceof ThreadDeath) {
            throw ((ThreadDeath) t);
        } else if (t instanceof VirtualMachineError) {
            throw ((VirtualMachineError) t);
        }
    }

    public static <T> TimerTask checkMinIdle(ObjectPool<T> pool, int minIdle, long period) throws IllegalArgumentException {
        if (pool == null) {
            throw new IllegalArgumentException("keyedPool must not be null.");
        } else if (minIdle >= 0) {
            ObjectPoolMinIdleTimerTask objectPoolMinIdleTimerTask = new ObjectPoolMinIdleTimerTask(pool, minIdle);
            getMinIdleTimer().schedule(objectPoolMinIdleTimerTask, 0, period);
            return objectPoolMinIdleTimerTask;
        } else {
            throw new IllegalArgumentException("minIdle must be non-negative.");
        }
    }

    public static <K, V> TimerTask checkMinIdle(KeyedObjectPool<K, V> keyedPool, K key, int minIdle, long period) throws IllegalArgumentException {
        if (keyedPool == null) {
            throw new IllegalArgumentException("keyedPool must not be null.");
        } else if (key == null) {
            throw new IllegalArgumentException("key must not be null.");
        } else if (minIdle >= 0) {
            KeyedObjectPoolMinIdleTimerTask keyedObjectPoolMinIdleTimerTask = new KeyedObjectPoolMinIdleTimerTask(keyedPool, key, minIdle);
            getMinIdleTimer().schedule(keyedObjectPoolMinIdleTimerTask, 0, period);
            return keyedObjectPoolMinIdleTimerTask;
        } else {
            throw new IllegalArgumentException("minIdle must be non-negative.");
        }
    }

    public static <K, V> Map<K, TimerTask> checkMinIdle(KeyedObjectPool<K, V> keyedPool, Collection<K> keys, int minIdle, long period) throws IllegalArgumentException {
        if (keys != null) {
            Map<K, TimerTask> tasks = new HashMap<>(keys.size());
            for (K key : keys) {
                tasks.put(key, checkMinIdle(keyedPool, key, minIdle, period));
            }
            return tasks;
        }
        throw new IllegalArgumentException("keys must not be null.");
    }

    public static <T> void prefill(ObjectPool<T> pool, int count) throws Exception, IllegalArgumentException {
        if (pool != null) {
            for (int i = 0; i < count; i++) {
                pool.addObject();
            }
            return;
        }
        throw new IllegalArgumentException("pool must not be null.");
    }

    public static <K, V> void prefill(KeyedObjectPool<K, V> keyedPool, K key, int count) throws Exception, IllegalArgumentException {
        if (keyedPool == null) {
            throw new IllegalArgumentException("keyedPool must not be null.");
        } else if (key != null) {
            for (int i = 0; i < count; i++) {
                keyedPool.addObject(key);
            }
        } else {
            throw new IllegalArgumentException("key must not be null.");
        }
    }

    public static <K, V> void prefill(KeyedObjectPool<K, V> keyedPool, Collection<K> keys, int count) throws Exception, IllegalArgumentException {
        if (keys != null) {
            for (K prefill : keys) {
                prefill(keyedPool, prefill, count);
            }
            return;
        }
        throw new IllegalArgumentException("keys must not be null.");
    }

    public static <T> ObjectPool<T> synchronizedPool(ObjectPool<T> pool) {
        if (pool != null) {
            return new SynchronizedObjectPool(pool);
        }
        throw new IllegalArgumentException("pool must not be null.");
    }

    public static <K, V> KeyedObjectPool<K, V> synchronizedPool(KeyedObjectPool<K, V> keyedPool) {
        return new SynchronizedKeyedObjectPool(keyedPool);
    }

    public static <T> PooledObjectFactory<T> synchronizedPooledFactory(PooledObjectFactory<T> factory) {
        return new SynchronizedPooledObjectFactory(factory);
    }

    public static <K, V> KeyedPooledObjectFactory<K, V> synchronizedKeyedPooledFactory(KeyedPooledObjectFactory<K, V> keyedFactory) {
        return new SynchronizedKeyedPooledObjectFactory(keyedFactory);
    }

    public static <T> ObjectPool<T> erodingPool(ObjectPool<T> pool) {
        return erodingPool(pool, 1.0f);
    }

    public static <T> ObjectPool<T> erodingPool(ObjectPool<T> pool, float factor) {
        if (pool == null) {
            throw new IllegalArgumentException("pool must not be null.");
        } else if (factor > 0.0f) {
            return new ErodingObjectPool(pool, factor);
        } else {
            throw new IllegalArgumentException("factor must be positive.");
        }
    }

    public static <K, V> KeyedObjectPool<K, V> erodingPool(KeyedObjectPool<K, V> keyedPool) {
        return erodingPool(keyedPool, 1.0f);
    }

    public static <K, V> KeyedObjectPool<K, V> erodingPool(KeyedObjectPool<K, V> keyedPool, float factor) {
        return erodingPool(keyedPool, factor, false);
    }

    public static <K, V> KeyedObjectPool<K, V> erodingPool(KeyedObjectPool<K, V> keyedPool, float factor, boolean perKey) {
        if (keyedPool == null) {
            throw new IllegalArgumentException("keyedPool must not be null.");
        } else if (factor <= 0.0f) {
            throw new IllegalArgumentException("factor must be positive.");
        } else if (perKey) {
            return new ErodingPerKeyKeyedObjectPool(keyedPool, factor);
        } else {
            return new ErodingKeyedObjectPool(keyedPool, factor);
        }
    }

    private static Timer getMinIdleTimer() {
        return TimerHolder.MIN_IDLE_TIMER;
    }

    private static class ObjectPoolMinIdleTimerTask<T> extends TimerTask {
        private final int minIdle;
        private final ObjectPool<T> pool;

        ObjectPoolMinIdleTimerTask(ObjectPool<T> pool2, int minIdle2) throws IllegalArgumentException {
            if (pool2 != null) {
                this.pool = pool2;
                this.minIdle = minIdle2;
                return;
            }
            throw new IllegalArgumentException("pool must not be null.");
        }

        public void run() {
            try {
                if (this.pool.getNumIdle() < this.minIdle) {
                    this.pool.addObject();
                }
                if (1 != 0) {
                    return;
                }
            } catch (Exception e) {
                cancel();
                if (0 != 0) {
                    return;
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    cancel();
                }
                throw th;
            }
            cancel();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("ObjectPoolMinIdleTimerTask");
            sb.append("{minIdle=").append(this.minIdle);
            sb.append(", pool=").append(this.pool);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class KeyedObjectPoolMinIdleTimerTask<K, V> extends TimerTask {
        private final K key;
        private final KeyedObjectPool<K, V> keyedPool;
        private final int minIdle;

        KeyedObjectPoolMinIdleTimerTask(KeyedObjectPool<K, V> keyedPool2, K key2, int minIdle2) throws IllegalArgumentException {
            if (keyedPool2 != null) {
                this.keyedPool = keyedPool2;
                this.key = key2;
                this.minIdle = minIdle2;
                return;
            }
            throw new IllegalArgumentException("keyedPool must not be null.");
        }

        public void run() {
            try {
                if (this.keyedPool.getNumIdle(this.key) < this.minIdle) {
                    this.keyedPool.addObject(this.key);
                }
                if (1 != 0) {
                    return;
                }
            } catch (Exception e) {
                cancel();
                if (0 != 0) {
                    return;
                }
            } catch (Throwable th) {
                if (0 == 0) {
                    cancel();
                }
                throw th;
            }
            cancel();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("KeyedObjectPoolMinIdleTimerTask");
            sb.append("{minIdle=").append(this.minIdle);
            sb.append(", key=").append(this.key);
            sb.append(", keyedPool=").append(this.keyedPool);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class SynchronizedObjectPool<T> implements ObjectPool<T> {
        private final ObjectPool<T> pool;
        private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        SynchronizedObjectPool(ObjectPool<T> pool2) throws IllegalArgumentException {
            if (pool2 != null) {
                this.pool = pool2;
                return;
            }
            throw new IllegalArgumentException("pool must not be null.");
        }

        public T borrowObject() throws Exception, NoSuchElementException, IllegalStateException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                return this.pool.borrowObject();
            } finally {
                writeLock.unlock();
            }
        }

        public void returnObject(T obj) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.returnObject(obj);
            } catch (Exception e) {
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
            writeLock.unlock();
        }

        public void invalidateObject(T obj) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.invalidateObject(obj);
            } catch (Exception e) {
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
            writeLock.unlock();
        }

        public void addObject() throws Exception, IllegalStateException, UnsupportedOperationException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.addObject();
            } finally {
                writeLock.unlock();
            }
        }

        public int getNumIdle() {
            ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
            readLock.lock();
            try {
                return this.pool.getNumIdle();
            } finally {
                readLock.unlock();
            }
        }

        public int getNumActive() {
            ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
            readLock.lock();
            try {
                return this.pool.getNumActive();
            } finally {
                readLock.unlock();
            }
        }

        public void clear() throws Exception, UnsupportedOperationException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.clear();
            } finally {
                writeLock.unlock();
            }
        }

        public void close() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.pool.close();
            } catch (Exception e) {
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
            writeLock.unlock();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedObjectPool");
            sb.append("{pool=").append(this.pool);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class SynchronizedKeyedObjectPool<K, V> implements KeyedObjectPool<K, V> {
        private final KeyedObjectPool<K, V> keyedPool;
        private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        SynchronizedKeyedObjectPool(KeyedObjectPool<K, V> keyedPool2) throws IllegalArgumentException {
            if (keyedPool2 != null) {
                this.keyedPool = keyedPool2;
                return;
            }
            throw new IllegalArgumentException("keyedPool must not be null.");
        }

        public V borrowObject(K key) throws Exception, NoSuchElementException, IllegalStateException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                return this.keyedPool.borrowObject(key);
            } finally {
                writeLock.unlock();
            }
        }

        public void returnObject(K key, V obj) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.returnObject(key, obj);
            } catch (Exception e) {
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
            writeLock.unlock();
        }

        public void invalidateObject(K key, V obj) {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.invalidateObject(key, obj);
            } catch (Exception e) {
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
            writeLock.unlock();
        }

        public void addObject(K key) throws Exception, IllegalStateException, UnsupportedOperationException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.addObject(key);
            } finally {
                writeLock.unlock();
            }
        }

        public int getNumIdle(K key) {
            ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
            readLock.lock();
            try {
                return this.keyedPool.getNumIdle(key);
            } finally {
                readLock.unlock();
            }
        }

        public int getNumActive(K key) {
            ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
            readLock.lock();
            try {
                return this.keyedPool.getNumActive(key);
            } finally {
                readLock.unlock();
            }
        }

        public int getNumIdle() {
            ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
            readLock.lock();
            try {
                return this.keyedPool.getNumIdle();
            } finally {
                readLock.unlock();
            }
        }

        public int getNumActive() {
            ReentrantReadWriteLock.ReadLock readLock = this.readWriteLock.readLock();
            readLock.lock();
            try {
                return this.keyedPool.getNumActive();
            } finally {
                readLock.unlock();
            }
        }

        public void clear() throws Exception, UnsupportedOperationException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.clear();
            } finally {
                writeLock.unlock();
            }
        }

        public void clear(K key) throws Exception, UnsupportedOperationException {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.clear(key);
            } finally {
                writeLock.unlock();
            }
        }

        public void close() {
            ReentrantReadWriteLock.WriteLock writeLock = this.readWriteLock.writeLock();
            writeLock.lock();
            try {
                this.keyedPool.close();
            } catch (Exception e) {
            } catch (Throwable th) {
                writeLock.unlock();
                throw th;
            }
            writeLock.unlock();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedKeyedObjectPool");
            sb.append("{keyedPool=").append(this.keyedPool);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class SynchronizedPooledObjectFactory<T> implements PooledObjectFactory<T> {
        private final PooledObjectFactory<T> factory;
        private final ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();

        SynchronizedPooledObjectFactory(PooledObjectFactory<T> factory2) throws IllegalArgumentException {
            if (factory2 != null) {
                this.factory = factory2;
                return;
            }
            throw new IllegalArgumentException("factory must not be null.");
        }

        public PooledObject<T> makeObject() throws Exception {
            this.writeLock.lock();
            try {
                return this.factory.makeObject();
            } finally {
                this.writeLock.unlock();
            }
        }

        public void destroyObject(PooledObject<T> p) throws Exception {
            this.writeLock.lock();
            try {
                this.factory.destroyObject(p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public boolean validateObject(PooledObject<T> p) {
            this.writeLock.lock();
            try {
                return this.factory.validateObject(p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public void activateObject(PooledObject<T> p) throws Exception {
            this.writeLock.lock();
            try {
                this.factory.activateObject(p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public void passivateObject(PooledObject<T> p) throws Exception {
            this.writeLock.lock();
            try {
                this.factory.passivateObject(p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedPoolableObjectFactory");
            sb.append("{factory=").append(this.factory);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class SynchronizedKeyedPooledObjectFactory<K, V> implements KeyedPooledObjectFactory<K, V> {
        private final KeyedPooledObjectFactory<K, V> keyedFactory;
        private final ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();

        SynchronizedKeyedPooledObjectFactory(KeyedPooledObjectFactory<K, V> keyedFactory2) throws IllegalArgumentException {
            if (keyedFactory2 != null) {
                this.keyedFactory = keyedFactory2;
                return;
            }
            throw new IllegalArgumentException("keyedFactory must not be null.");
        }

        public PooledObject<V> makeObject(K key) throws Exception {
            this.writeLock.lock();
            try {
                return this.keyedFactory.makeObject(key);
            } finally {
                this.writeLock.unlock();
            }
        }

        public void destroyObject(K key, PooledObject<V> p) throws Exception {
            this.writeLock.lock();
            try {
                this.keyedFactory.destroyObject(key, p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public boolean validateObject(K key, PooledObject<V> p) {
            this.writeLock.lock();
            try {
                return this.keyedFactory.validateObject(key, p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public void activateObject(K key, PooledObject<V> p) throws Exception {
            this.writeLock.lock();
            try {
                this.keyedFactory.activateObject(key, p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public void passivateObject(K key, PooledObject<V> p) throws Exception {
            this.writeLock.lock();
            try {
                this.keyedFactory.passivateObject(key, p);
            } finally {
                this.writeLock.unlock();
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("SynchronizedKeyedPoolableObjectFactory");
            sb.append("{keyedFactory=").append(this.keyedFactory);
            sb.append('}');
            return sb.toString();
        }
    }

    private static class ErodingFactor {
        private final float factor;
        private volatile transient int idleHighWaterMark = 1;
        private volatile transient long nextShrink;

        public ErodingFactor(float factor2) {
            this.factor = factor2;
            this.nextShrink = System.currentTimeMillis() + ((long) (900000.0f * factor2));
        }

        public void update(long now, int numIdle) {
            int idle = Math.max(0, numIdle);
            this.idleHighWaterMark = Math.max(idle, this.idleHighWaterMark);
            this.nextShrink = ((long) (60000.0f * (((-14.0f / ((float) this.idleHighWaterMark)) * ((float) idle)) + 15.0f) * this.factor)) + now;
        }

        public long getNextShrink() {
            return this.nextShrink;
        }

        public String toString() {
            return "ErodingFactor{factor=" + this.factor + ", idleHighWaterMark=" + this.idleHighWaterMark + '}';
        }
    }

    private static class ErodingObjectPool<T> implements ObjectPool<T> {
        private final ErodingFactor factor;
        private final ObjectPool<T> pool;

        public ErodingObjectPool(ObjectPool<T> pool2, float factor2) {
            this.pool = pool2;
            this.factor = new ErodingFactor(factor2);
        }

        public T borrowObject() throws Exception, NoSuchElementException, IllegalStateException {
            return this.pool.borrowObject();
        }

        public void returnObject(T obj) {
            boolean discard = false;
            long now = System.currentTimeMillis();
            synchronized (this.pool) {
                if (this.factor.getNextShrink() < now) {
                    int numIdle = this.pool.getNumIdle();
                    if (numIdle > 0) {
                        discard = true;
                    }
                    this.factor.update(now, numIdle);
                }
            }
            if (discard) {
                try {
                    this.pool.invalidateObject(obj);
                } catch (Exception e) {
                }
            } else {
                this.pool.returnObject(obj);
            }
        }

        public void invalidateObject(T obj) {
            try {
                this.pool.invalidateObject(obj);
            } catch (Exception e) {
            }
        }

        public void addObject() throws Exception, IllegalStateException, UnsupportedOperationException {
            this.pool.addObject();
        }

        public int getNumIdle() {
            return this.pool.getNumIdle();
        }

        public int getNumActive() {
            return this.pool.getNumActive();
        }

        public void clear() throws Exception, UnsupportedOperationException {
            this.pool.clear();
        }

        public void close() {
            try {
                this.pool.close();
            } catch (Exception e) {
            }
        }

        public String toString() {
            return "ErodingObjectPool{factor=" + this.factor + ", pool=" + this.pool + '}';
        }
    }

    private static class ErodingKeyedObjectPool<K, V> implements KeyedObjectPool<K, V> {
        private final ErodingFactor erodingFactor;
        private final KeyedObjectPool<K, V> keyedPool;

        public ErodingKeyedObjectPool(KeyedObjectPool<K, V> keyedPool2, float factor) {
            this(keyedPool2, new ErodingFactor(factor));
        }

        protected ErodingKeyedObjectPool(KeyedObjectPool<K, V> keyedPool2, ErodingFactor erodingFactor2) {
            if (keyedPool2 != null) {
                this.keyedPool = keyedPool2;
                this.erodingFactor = erodingFactor2;
                return;
            }
            throw new IllegalArgumentException("keyedPool must not be null.");
        }

        public V borrowObject(K key) throws Exception, NoSuchElementException, IllegalStateException {
            return this.keyedPool.borrowObject(key);
        }

        public void returnObject(K key, V obj) throws Exception {
            boolean discard = false;
            long now = System.currentTimeMillis();
            ErodingFactor factor = getErodingFactor(key);
            synchronized (this.keyedPool) {
                if (factor.getNextShrink() < now) {
                    int numIdle = getNumIdle(key);
                    if (numIdle > 0) {
                        discard = true;
                    }
                    factor.update(now, numIdle);
                }
            }
            if (discard) {
                try {
                    this.keyedPool.invalidateObject(key, obj);
                } catch (Exception e) {
                }
            } else {
                this.keyedPool.returnObject(key, obj);
            }
        }

        /* access modifiers changed from: protected */
        public ErodingFactor getErodingFactor(K k) {
            return this.erodingFactor;
        }

        public void invalidateObject(K key, V obj) {
            try {
                this.keyedPool.invalidateObject(key, obj);
            } catch (Exception e) {
            }
        }

        public void addObject(K key) throws Exception, IllegalStateException, UnsupportedOperationException {
            this.keyedPool.addObject(key);
        }

        public int getNumIdle() {
            return this.keyedPool.getNumIdle();
        }

        public int getNumIdle(K key) {
            return this.keyedPool.getNumIdle(key);
        }

        public int getNumActive() {
            return this.keyedPool.getNumActive();
        }

        public int getNumActive(K key) {
            return this.keyedPool.getNumActive(key);
        }

        public void clear() throws Exception, UnsupportedOperationException {
            this.keyedPool.clear();
        }

        public void clear(K key) throws Exception, UnsupportedOperationException {
            this.keyedPool.clear(key);
        }

        public void close() {
            try {
                this.keyedPool.close();
            } catch (Exception e) {
            }
        }

        /* access modifiers changed from: protected */
        public KeyedObjectPool<K, V> getKeyedPool() {
            return this.keyedPool;
        }

        public String toString() {
            return "ErodingKeyedObjectPool{factor=" + this.erodingFactor + ", keyedPool=" + this.keyedPool + '}';
        }
    }

    private static class ErodingPerKeyKeyedObjectPool<K, V> extends ErodingKeyedObjectPool<K, V> {
        private final float factor;
        private final Map<K, ErodingFactor> factors = Collections.synchronizedMap(new HashMap());

        public ErodingPerKeyKeyedObjectPool(KeyedObjectPool<K, V> keyedPool, float factor2) {
            super(keyedPool, (ErodingFactor) null);
            this.factor = factor2;
        }

        /* access modifiers changed from: protected */
        public ErodingFactor getErodingFactor(K key) {
            ErodingFactor eFactor = this.factors.get(key);
            if (eFactor != null) {
                return eFactor;
            }
            ErodingFactor eFactor2 = new ErodingFactor(this.factor);
            this.factors.put(key, eFactor2);
            return eFactor2;
        }

        public String toString() {
            return "ErodingPerKeyKeyedObjectPool{factor=" + this.factor + ", keyedPool=" + getKeyedPool() + '}';
        }
    }
}
