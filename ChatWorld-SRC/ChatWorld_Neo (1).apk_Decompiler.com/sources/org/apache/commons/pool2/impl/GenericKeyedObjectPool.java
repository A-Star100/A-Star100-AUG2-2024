package org.apache.commons.pool2.impl;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.commons.pool2.KeyedObjectPool;
import org.apache.commons.pool2.KeyedPooledObjectFactory;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.impl.BaseGenericObjectPool;

public class GenericKeyedObjectPool<K, T> extends BaseGenericObjectPool<T> implements KeyedObjectPool<K, T>, GenericKeyedObjectPoolMXBean<K> {
    private static final String ONAME_BASE = "org.apache.commons.pool2:type=GenericKeyedObjectPool,name=";
    private K evictionKey;
    private Iterator<K> evictionKeyIterator;
    private final KeyedPooledObjectFactory<K, T> factory;
    private final boolean fairness;
    private final ReadWriteLock keyLock;
    private volatile int maxIdlePerKey;
    private volatile int maxTotalPerKey;
    private volatile int minIdlePerKey;
    private final AtomicInteger numTotal;
    private final List<K> poolKeyList;
    private final Map<K, GenericKeyedObjectPool<K, T>.ObjectDeque<T>> poolMap;

    public GenericKeyedObjectPool(KeyedPooledObjectFactory<K, T> factory2) {
        this(factory2, new GenericKeyedObjectPoolConfig());
    }

    public GenericKeyedObjectPool(KeyedPooledObjectFactory<K, T> factory2, GenericKeyedObjectPoolConfig config) {
        super(config, ONAME_BASE, config.getJmxNamePrefix());
        this.maxIdlePerKey = 8;
        this.minIdlePerKey = 0;
        this.maxTotalPerKey = 8;
        this.poolMap = new ConcurrentHashMap();
        this.poolKeyList = new ArrayList();
        this.keyLock = new ReentrantReadWriteLock(true);
        this.numTotal = new AtomicInteger(0);
        this.evictionKeyIterator = null;
        this.evictionKey = null;
        if (factory2 != null) {
            this.factory = factory2;
            this.fairness = config.getFairness();
            setConfig(config);
            startEvictor(getTimeBetweenEvictionRunsMillis());
            return;
        }
        jmxUnregister();
        throw new IllegalArgumentException("factory may not be null");
    }

    public int getMaxTotalPerKey() {
        return this.maxTotalPerKey;
    }

    public void setMaxTotalPerKey(int maxTotalPerKey2) {
        this.maxTotalPerKey = maxTotalPerKey2;
    }

    public int getMaxIdlePerKey() {
        return this.maxIdlePerKey;
    }

    public void setMaxIdlePerKey(int maxIdlePerKey2) {
        this.maxIdlePerKey = maxIdlePerKey2;
    }

    public void setMinIdlePerKey(int minIdlePerKey2) {
        this.minIdlePerKey = minIdlePerKey2;
    }

    public int getMinIdlePerKey() {
        int maxIdlePerKeySave = getMaxIdlePerKey();
        if (this.minIdlePerKey > maxIdlePerKeySave) {
            return maxIdlePerKeySave;
        }
        return this.minIdlePerKey;
    }

    public void setConfig(GenericKeyedObjectPoolConfig conf) {
        setLifo(conf.getLifo());
        setMaxIdlePerKey(conf.getMaxIdlePerKey());
        setMaxTotalPerKey(conf.getMaxTotalPerKey());
        setMaxTotal(conf.getMaxTotal());
        setMinIdlePerKey(conf.getMinIdlePerKey());
        setMaxWaitMillis(conf.getMaxWaitMillis());
        setBlockWhenExhausted(conf.getBlockWhenExhausted());
        setTestOnCreate(conf.getTestOnCreate());
        setTestOnBorrow(conf.getTestOnBorrow());
        setTestOnReturn(conf.getTestOnReturn());
        setTestWhileIdle(conf.getTestWhileIdle());
        setNumTestsPerEvictionRun(conf.getNumTestsPerEvictionRun());
        setMinEvictableIdleTimeMillis(conf.getMinEvictableIdleTimeMillis());
        setSoftMinEvictableIdleTimeMillis(conf.getSoftMinEvictableIdleTimeMillis());
        setTimeBetweenEvictionRunsMillis(conf.getTimeBetweenEvictionRunsMillis());
        setEvictionPolicyClassName(conf.getEvictionPolicyClassName());
    }

    public KeyedPooledObjectFactory<K, T> getFactory() {
        return this.factory;
    }

    public T borrowObject(K key) throws Exception {
        return borrowObject(key, getMaxWaitMillis());
    }

    public T borrowObject(K key, long borrowMaxWaitMillis) throws Exception {
        assertOpen();
        PooledObject<T> p = null;
        boolean blockWhenExhausted = getBlockWhenExhausted();
        long waitTime = System.currentTimeMillis();
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = register(key);
        while (p == null) {
            boolean create = false;
            if (blockWhenExhausted) {
                try {
                    p = objectDeque.getIdleObjects().pollFirst();
                    if (p == null && (p = create(key)) != null) {
                        create = true;
                    }
                    if (p == null) {
                        if (borrowMaxWaitMillis < 0) {
                            p = objectDeque.getIdleObjects().takeFirst();
                        } else {
                            p = objectDeque.getIdleObjects().pollFirst(borrowMaxWaitMillis, TimeUnit.MILLISECONDS);
                        }
                    }
                    if (p == null) {
                        throw new NoSuchElementException("Timeout waiting for idle object");
                    } else if (!p.allocate()) {
                        p = null;
                    }
                } catch (Exception e) {
                    try {
                        destroy(key, p, true);
                    } catch (Exception e2) {
                    }
                    p = null;
                    if (create) {
                        NoSuchElementException nsee = new NoSuchElementException("Unable to activate object");
                        nsee.initCause(e);
                        throw nsee;
                    }
                } catch (Throwable th) {
                    deregister(key);
                    throw th;
                }
            } else {
                PooledObject<T> p2 = objectDeque.getIdleObjects().pollFirst();
                if (p2 == null && (p2 = create(key)) != null) {
                    create = true;
                }
                if (p == null) {
                    throw new NoSuchElementException("Pool exhausted");
                } else if (!p.allocate()) {
                    p = null;
                }
            }
            if (p != null) {
                this.factory.activateObject(key, p);
                if (p == null) {
                    continue;
                } else if (getTestOnBorrow() || (create && getTestOnCreate())) {
                    boolean validate = false;
                    Throwable validationThrowable = null;
                    try {
                        validate = this.factory.validateObject(key, p);
                    } catch (Throwable t) {
                        PoolUtils.checkRethrow(t);
                        validationThrowable = t;
                    }
                    if (!validate) {
                        try {
                            destroy(key, p, true);
                            this.destroyedByBorrowValidationCount.incrementAndGet();
                        } catch (Exception e3) {
                        }
                        p = null;
                        if (create) {
                            NoSuchElementException nsee2 = new NoSuchElementException("Unable to validate object");
                            nsee2.initCause(validationThrowable);
                            throw nsee2;
                        }
                    }
                }
            }
        }
        deregister(key);
        updateStatsBorrow(p, System.currentTimeMillis() - waitTime);
        return p.getObject();
    }

    public void returnObject(K key, T obj) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(key);
        PooledObject<T> p = objectDeque.getAllObjects().get(new BaseGenericObjectPool.IdentityWrapper(obj));
        if (p != null) {
            synchronized (p) {
                if (p.getState() == PooledObjectState.ALLOCATED) {
                    p.markReturning();
                } else {
                    throw new IllegalStateException("Object has already been returned to this pool or is invalid");
                }
            }
            long activeTime = p.getActiveTimeMillis();
            if (!getTestOnReturn() || this.factory.validateObject(key, p)) {
                try {
                    this.factory.passivateObject(key, p);
                    if (p.deallocate()) {
                        int maxIdle = getMaxIdlePerKey();
                        LinkedBlockingDeque<PooledObject<T>> idleObjects = objectDeque.getIdleObjects();
                        if (isClosed() || (maxIdle > -1 && maxIdle <= idleObjects.size())) {
                            try {
                                destroy(key, p, true);
                            } catch (Exception e) {
                                swallowException(e);
                            }
                        } else {
                            if (getLifo()) {
                                idleObjects.addFirst(p);
                            } else {
                                idleObjects.addLast(p);
                            }
                            if (isClosed()) {
                                clear(key);
                            }
                        }
                        if (hasBorrowWaiters()) {
                            reuseCapacity();
                        }
                        updateStatsReturn(activeTime);
                        return;
                    }
                    throw new IllegalStateException("Object has already been returned to this pool");
                } catch (Exception e1) {
                    swallowException(e1);
                    try {
                        destroy(key, p, true);
                    } catch (Exception e2) {
                        swallowException(e2);
                    }
                    if (objectDeque.idleObjects.hasTakeWaiters()) {
                        try {
                            addObject(key);
                        } catch (Exception e3) {
                            swallowException(e3);
                        }
                    }
                    updateStatsReturn(activeTime);
                }
            } else {
                try {
                    destroy(key, p, true);
                } catch (Exception e4) {
                    swallowException(e4);
                }
                if (objectDeque.idleObjects.hasTakeWaiters()) {
                    try {
                        addObject(key);
                    } catch (Exception e5) {
                        swallowException(e5);
                    }
                }
                updateStatsReturn(activeTime);
            }
        } else {
            throw new IllegalStateException("Returned object not currently part of this pool");
        }
    }

    public void invalidateObject(K key, T obj) throws Exception {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(key);
        PooledObject<T> p = objectDeque.getAllObjects().get(new BaseGenericObjectPool.IdentityWrapper(obj));
        if (p != null) {
            synchronized (p) {
                if (p.getState() != PooledObjectState.INVALID) {
                    destroy(key, p, true);
                }
            }
            if (objectDeque.idleObjects.hasTakeWaiters()) {
                addObject(key);
                return;
            }
            return;
        }
        throw new IllegalStateException("Object not currently part of this pool");
    }

    public void clear() {
        for (K clear : this.poolMap.keySet()) {
            clear(clear);
        }
    }

    public void clear(K key) {
        try {
            LinkedBlockingDeque<PooledObject<T>> idleObjects = register(key).getIdleObjects();
            for (PooledObject<T> p = idleObjects.poll(); p != null; p = idleObjects.poll()) {
                destroy(key, p, true);
            }
            deregister(key);
        } catch (Exception e) {
            swallowException(e);
        } catch (Throwable th) {
            deregister(key);
            throw th;
        }
    }

    public int getNumActive() {
        return this.numTotal.get() - getNumIdle();
    }

    public int getNumIdle() {
        int result = 0;
        for (GenericKeyedObjectPool<K, T>.ObjectDeque<T> idleObjects : this.poolMap.values()) {
            result += idleObjects.getIdleObjects().size();
        }
        return result;
    }

    public int getNumActive(K key) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(key);
        if (objectDeque != null) {
            return objectDeque.getAllObjects().size() - objectDeque.getIdleObjects().size();
        }
        return 0;
    }

    public int getNumIdle(K key) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(key);
        if (objectDeque != null) {
            return objectDeque.getIdleObjects().size();
        }
        return 0;
    }

    public void close() {
        if (!isClosed()) {
            synchronized (this.closeLock) {
                if (!isClosed()) {
                    startEvictor(-1);
                    this.closed = true;
                    clear();
                    jmxUnregister();
                    for (GenericKeyedObjectPool<K, T>.ObjectDeque<T> idleObjects : this.poolMap.values()) {
                        idleObjects.getIdleObjects().interuptTakeWaiters();
                    }
                    clear();
                }
            }
        }
    }

    public void clearOldest() {
        Map<PooledObject<T>, K> map = new TreeMap<>();
        for (K k : this.poolMap.keySet()) {
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> queue = this.poolMap.get(k);
            if (queue != null) {
                Iterator<PooledObject<T>> it = queue.getIdleObjects().iterator();
                while (it.hasNext()) {
                    map.put(it.next(), k);
                }
            }
        }
        double size = (double) map.size();
        Double.isNaN(size);
        int itemsToRemove = ((int) (size * 0.15d)) + 1;
        Iterator<Map.Entry<PooledObject<T>, K>> iter = map.entrySet().iterator();
        while (iter.hasNext() && itemsToRemove > 0) {
            Map.Entry<PooledObject<T>, K> entry = iter.next();
            boolean destroyed = true;
            try {
                destroyed = destroy(entry.getValue(), entry.getKey(), false);
            } catch (Exception e) {
                swallowException(e);
            }
            if (destroyed) {
                itemsToRemove--;
            }
        }
    }

    private void reuseCapacity() {
        int maxTotalPerKeySave = getMaxTotalPerKey();
        int maxQueueLength = 0;
        LinkedBlockingDeque<PooledObject<T>> mostLoaded = null;
        K loadedKey = null;
        for (K k : this.poolMap.keySet()) {
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> deque = this.poolMap.get(k);
            if (deque != null) {
                LinkedBlockingDeque<PooledObject<T>> pool = deque.getIdleObjects();
                int queueLength = pool.getTakeQueueLength();
                if (getNumActive(k) < maxTotalPerKeySave && queueLength > maxQueueLength) {
                    maxQueueLength = queueLength;
                    mostLoaded = pool;
                    loadedKey = k;
                }
            }
        }
        if (mostLoaded != null) {
            register(loadedKey);
            try {
                PooledObject<T> p = create(loadedKey);
                if (p != null) {
                    addIdleObject(loadedKey, p);
                }
            } catch (Exception e) {
                swallowException(e);
            } catch (Throwable th) {
                deregister(loadedKey);
                throw th;
            }
            deregister(loadedKey);
        }
    }

    private boolean hasBorrowWaiters() {
        for (K k : this.poolMap.keySet()) {
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> deque = this.poolMap.get(k);
            if (deque != null && deque.getIdleObjects().hasTakeWaiters()) {
                return true;
            }
        }
        return false;
    }

    public void evict() throws Exception {
        boolean evict;
        assertOpen();
        if (getNumIdle() != 0) {
            EvictionPolicy<T> evictionPolicy = getEvictionPolicy();
            synchronized (this.evictionLock) {
                EvictionConfig evictionConfig = new EvictionConfig(getMinEvictableIdleTimeMillis(), getSoftMinEvictableIdleTimeMillis(), getMinIdlePerKey());
                boolean testWhileIdle = getTestWhileIdle();
                int i = 0;
                int m = getNumTests();
                while (i < m) {
                    if (this.evictionIterator == null || !this.evictionIterator.hasNext()) {
                        Iterator<K> it = this.evictionKeyIterator;
                        if (it == null || !it.hasNext()) {
                            List<K> keyCopy = new ArrayList<>();
                            Lock readLock = this.keyLock.readLock();
                            readLock.lock();
                            try {
                                keyCopy.addAll(this.poolKeyList);
                                readLock.unlock();
                                this.evictionKeyIterator = keyCopy.iterator();
                            } catch (Throwable t) {
                                PoolUtils.checkRethrow(t);
                                swallowException(new Exception(t));
                                evict = false;
                            }
                        }
                        while (true) {
                            if (!this.evictionKeyIterator.hasNext()) {
                                break;
                            }
                            K next = this.evictionKeyIterator.next();
                            this.evictionKey = next;
                            GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(next);
                            if (objectDeque != null) {
                                this.evictionIterator = new BaseGenericObjectPool.EvictionIterator(objectDeque.getIdleObjects());
                                if (this.evictionIterator.hasNext()) {
                                    break;
                                }
                                this.evictionIterator = null;
                            }
                        }
                    }
                    if (this.evictionIterator != null) {
                        try {
                            PooledObject next2 = this.evictionIterator.next();
                            Deque<PooledObject<T>> idleObjects = this.evictionIterator.getIdleObjects();
                            if (!next2.startEvictionTest()) {
                                i--;
                            } else {
                                evict = evictionPolicy.evict(evictionConfig, next2, this.poolMap.get(this.evictionKey).getIdleObjects().size());
                                if (evict) {
                                    destroy(this.evictionKey, next2, true);
                                    this.destroyedByEvictorCount.incrementAndGet();
                                } else {
                                    if (testWhileIdle) {
                                        boolean active = false;
                                        try {
                                            this.factory.activateObject(this.evictionKey, next2);
                                            active = true;
                                        } catch (Exception e) {
                                            destroy(this.evictionKey, next2, true);
                                            this.destroyedByEvictorCount.incrementAndGet();
                                        }
                                        if (active) {
                                            if (!this.factory.validateObject(this.evictionKey, next2)) {
                                                destroy(this.evictionKey, next2, true);
                                                this.destroyedByEvictorCount.incrementAndGet();
                                            } else {
                                                try {
                                                    this.factory.passivateObject(this.evictionKey, next2);
                                                } catch (Exception e2) {
                                                    destroy(this.evictionKey, next2, true);
                                                    this.destroyedByEvictorCount.incrementAndGet();
                                                }
                                            }
                                        }
                                    }
                                    next2.endEvictionTest(idleObjects);
                                }
                            }
                        } catch (NoSuchElementException e3) {
                            i--;
                            this.evictionIterator = null;
                        }
                        i++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    private PooledObject<T> create(K key) throws Exception {
        int maxTotalPerKeySave = getMaxTotalPerKey();
        int maxTotal = getMaxTotal();
        boolean loop = true;
        while (loop) {
            int newNumTotal = this.numTotal.incrementAndGet();
            if (maxTotal <= -1 || newNumTotal <= maxTotal) {
                loop = false;
            } else {
                this.numTotal.decrementAndGet();
                if (getNumIdle() == 0) {
                    return null;
                }
                clearOldest();
            }
        }
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(key);
        long newCreateCount = (long) objectDeque.getCreateCount().incrementAndGet();
        if ((maxTotalPerKeySave <= -1 || newCreateCount <= ((long) maxTotalPerKeySave)) && newCreateCount <= 2147483647L) {
            try {
                PooledObject<T> p = this.factory.makeObject(key);
                this.createdCount.incrementAndGet();
                objectDeque.getAllObjects().put(new BaseGenericObjectPool.IdentityWrapper(p.getObject()), p);
                return p;
            } catch (Exception e) {
                this.numTotal.decrementAndGet();
                objectDeque.getCreateCount().decrementAndGet();
                throw e;
            }
        } else {
            this.numTotal.decrementAndGet();
            objectDeque.getCreateCount().decrementAndGet();
            return null;
        }
    }

    private boolean destroy(K key, PooledObject<T> toDestroy, boolean always) throws Exception {
        boolean z;
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = register(key);
        try {
            if (objectDeque.getIdleObjects().remove(toDestroy) || always) {
                objectDeque.getAllObjects().remove(new BaseGenericObjectPool.IdentityWrapper(toDestroy.getObject()));
                toDestroy.invalidate();
                this.factory.destroyObject(key, toDestroy);
                objectDeque.getCreateCount().decrementAndGet();
                this.destroyedCount.incrementAndGet();
                this.numTotal.decrementAndGet();
                z = true;
            } else {
                z = false;
            }
            deregister(key);
            return z;
        } catch (Throwable th) {
            deregister(key);
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    private GenericKeyedObjectPool<K, T>.ObjectDeque<T> register(K k) {
        Lock lock = this.keyLock.readLock();
        try {
            lock.lock();
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
            if (objectDeque == null) {
                lock.unlock();
                lock = this.keyLock.writeLock();
                lock.lock();
                objectDeque = this.poolMap.get(k);
                if (objectDeque == null) {
                    objectDeque = new ObjectDeque<>(this.fairness);
                    objectDeque.getNumInterested().incrementAndGet();
                    this.poolMap.put(k, objectDeque);
                    this.poolKeyList.add(k);
                } else {
                    objectDeque.getNumInterested().incrementAndGet();
                }
            } else {
                objectDeque.getNumInterested().incrementAndGet();
            }
            lock.unlock();
            return objectDeque;
        } catch (Throwable th) {
            lock.unlock();
            throw th;
        }
    }

    private void deregister(K k) {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(k);
        if (objectDeque.getNumInterested().decrementAndGet() == 0 && objectDeque.getCreateCount().get() == 0) {
            Lock writeLock = this.keyLock.writeLock();
            writeLock.lock();
            try {
                if (objectDeque.getCreateCount().get() == 0 && objectDeque.getNumInterested().get() == 0) {
                    this.poolMap.remove(k);
                    this.poolKeyList.remove(k);
                }
            } finally {
                writeLock.unlock();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureMinIdle() throws Exception {
        if (getMinIdlePerKey() >= 1) {
            for (K k : this.poolMap.keySet()) {
                ensureMinIdle(k);
            }
        }
    }

    private void ensureMinIdle(K key) throws Exception {
        GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque = this.poolMap.get(key);
        int deficit = calculateDeficit(objectDeque);
        for (int i = 0; i < deficit && calculateDeficit(objectDeque) > 0; i++) {
            addObject(key);
        }
    }

    public void addObject(K key) throws Exception {
        assertOpen();
        register(key);
        try {
            addIdleObject(key, create(key));
        } finally {
            deregister(key);
        }
    }

    private void addIdleObject(K key, PooledObject<T> p) throws Exception {
        if (p != null) {
            this.factory.passivateObject(key, p);
            LinkedBlockingDeque<PooledObject<T>> idleObjects = this.poolMap.get(key).getIdleObjects();
            if (getLifo()) {
                idleObjects.addFirst(p);
            } else {
                idleObjects.addLast(p);
            }
        }
    }

    public void preparePool(K key) throws Exception {
        if (getMinIdlePerKey() >= 1) {
            ensureMinIdle(key);
        }
    }

    private int getNumTests() {
        int totalIdle = getNumIdle();
        int numTests = getNumTestsPerEvictionRun();
        if (numTests >= 0) {
            return Math.min(numTests, totalIdle);
        }
        double d = (double) totalIdle;
        double abs = Math.abs((double) numTests);
        Double.isNaN(d);
        return (int) Math.ceil(d / abs);
    }

    private int calculateDeficit(GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDeque) {
        if (objectDeque == null) {
            return getMinIdlePerKey();
        }
        int maxTotal = getMaxTotal();
        int maxTotalPerKeySave = getMaxTotalPerKey();
        int objectDefecit = getMinIdlePerKey() - objectDeque.getIdleObjects().size();
        if (maxTotalPerKeySave > 0) {
            objectDefecit = Math.min(objectDefecit, Math.max(0, maxTotalPerKeySave - objectDeque.getIdleObjects().size()));
        }
        if (maxTotal > 0) {
            return Math.min(objectDefecit, Math.max(0, (maxTotal - getNumActive()) - getNumIdle()));
        }
        return objectDefecit;
    }

    public Map<String, Integer> getNumActivePerKey() {
        HashMap<String, Integer> result = new HashMap<>();
        for (Map.Entry<K, GenericKeyedObjectPool<K, T>.ObjectDeque<T>> entry : this.poolMap.entrySet()) {
            if (entry != null) {
                K key = entry.getKey();
                GenericKeyedObjectPool<K, T>.ObjectDeque<T> objectDequeue = entry.getValue();
                if (!(key == null || objectDequeue == null)) {
                    result.put(key.toString(), Integer.valueOf(objectDequeue.getAllObjects().size() - objectDequeue.getIdleObjects().size()));
                }
            }
        }
        return result;
    }

    public int getNumWaiters() {
        int result = 0;
        if (getBlockWhenExhausted()) {
            for (GenericKeyedObjectPool<K, T>.ObjectDeque<T> idleObjects : this.poolMap.values()) {
                result += idleObjects.getIdleObjects().getTakeQueueLength();
            }
        }
        return result;
    }

    public Map<String, Integer> getNumWaitersByKey() {
        Map<String, Integer> result = new HashMap<>();
        for (K key : this.poolMap.keySet()) {
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> queue = this.poolMap.get(key);
            if (queue != null) {
                if (getBlockWhenExhausted()) {
                    result.put(key.toString(), Integer.valueOf(queue.getIdleObjects().getTakeQueueLength()));
                } else {
                    result.put(key.toString(), 0);
                }
            }
        }
        return result;
    }

    public Map<String, List<DefaultPooledObjectInfo>> listAllObjects() {
        Map<String, List<DefaultPooledObjectInfo>> result = new HashMap<>();
        for (K key : this.poolMap.keySet()) {
            GenericKeyedObjectPool<K, T>.ObjectDeque<T> queue = this.poolMap.get(key);
            if (queue != null) {
                List<DefaultPooledObjectInfo> list = new ArrayList<>();
                result.put(key.toString(), list);
                for (PooledObject<T> p : queue.getAllObjects().values()) {
                    list.add(new DefaultPooledObjectInfo(p));
                }
            }
        }
        return result;
    }

    private class ObjectDeque<S> {
        private final Map<BaseGenericObjectPool.IdentityWrapper<S>, PooledObject<S>> allObjects = new ConcurrentHashMap();
        private final AtomicInteger createCount = new AtomicInteger(0);
        /* access modifiers changed from: private */
        public final LinkedBlockingDeque<PooledObject<S>> idleObjects;
        private final AtomicLong numInterested = new AtomicLong(0);

        public ObjectDeque(boolean fairness) {
            this.idleObjects = new LinkedBlockingDeque<>(fairness);
        }

        public LinkedBlockingDeque<PooledObject<S>> getIdleObjects() {
            return this.idleObjects;
        }

        public AtomicInteger getCreateCount() {
            return this.createCount;
        }

        public AtomicLong getNumInterested() {
            return this.numInterested;
        }

        public Map<BaseGenericObjectPool.IdentityWrapper<S>, PooledObject<S>> getAllObjects() {
            return this.allObjects;
        }
    }
}
