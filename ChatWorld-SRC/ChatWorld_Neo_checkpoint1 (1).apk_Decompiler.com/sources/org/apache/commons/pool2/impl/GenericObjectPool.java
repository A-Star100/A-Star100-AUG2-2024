package org.apache.commons.pool2.impl;

import androidx.appcompat.widget.ActivityChooserView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.commons.pool2.ObjectPool;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.PooledObjectFactory;
import org.apache.commons.pool2.PooledObjectState;
import org.apache.commons.pool2.UsageTracking;
import org.apache.commons.pool2.impl.BaseGenericObjectPool;

public class GenericObjectPool<T> extends BaseGenericObjectPool<T> implements ObjectPool<T>, GenericObjectPoolMXBean, UsageTracking<T> {
    private static final String ONAME_BASE = "org.apache.commons.pool2:type=GenericObjectPool,name=";
    private volatile AbandonedConfig abandonedConfig;
    private final Map<BaseGenericObjectPool.IdentityWrapper<T>, PooledObject<T>> allObjects;
    private final AtomicLong createCount;
    private final PooledObjectFactory<T> factory;
    private volatile String factoryType;
    private final LinkedBlockingDeque<PooledObject<T>> idleObjects;
    private volatile int maxIdle;
    private volatile int minIdle;

    public GenericObjectPool(PooledObjectFactory<T> factory2) {
        this(factory2, new GenericObjectPoolConfig());
    }

    public GenericObjectPool(PooledObjectFactory<T> factory2, GenericObjectPoolConfig config) {
        super(config, ONAME_BASE, config.getJmxNamePrefix());
        this.factoryType = null;
        this.maxIdle = 8;
        this.minIdle = 0;
        this.allObjects = new ConcurrentHashMap();
        this.createCount = new AtomicLong(0);
        this.abandonedConfig = null;
        if (factory2 != null) {
            this.factory = factory2;
            this.idleObjects = new LinkedBlockingDeque<>(config.getFairness());
            setConfig(config);
            startEvictor(getTimeBetweenEvictionRunsMillis());
            return;
        }
        jmxUnregister();
        throw new IllegalArgumentException("factory may not be null");
    }

    public GenericObjectPool(PooledObjectFactory<T> factory2, GenericObjectPoolConfig config, AbandonedConfig abandonedConfig2) {
        this(factory2, config);
        setAbandonedConfig(abandonedConfig2);
    }

    public int getMaxIdle() {
        return this.maxIdle;
    }

    public void setMaxIdle(int maxIdle2) {
        this.maxIdle = maxIdle2;
    }

    public void setMinIdle(int minIdle2) {
        this.minIdle = minIdle2;
    }

    public int getMinIdle() {
        int maxIdleSave = getMaxIdle();
        if (this.minIdle > maxIdleSave) {
            return maxIdleSave;
        }
        return this.minIdle;
    }

    public boolean isAbandonedConfig() {
        return this.abandonedConfig != null;
    }

    public boolean getLogAbandoned() {
        AbandonedConfig ac = this.abandonedConfig;
        return ac != null && ac.getLogAbandoned();
    }

    public boolean getRemoveAbandonedOnBorrow() {
        AbandonedConfig ac = this.abandonedConfig;
        return ac != null && ac.getRemoveAbandonedOnBorrow();
    }

    public boolean getRemoveAbandonedOnMaintenance() {
        AbandonedConfig ac = this.abandonedConfig;
        return ac != null && ac.getRemoveAbandonedOnMaintenance();
    }

    public int getRemoveAbandonedTimeout() {
        AbandonedConfig ac = this.abandonedConfig;
        return ac != null ? ac.getRemoveAbandonedTimeout() : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public void setConfig(GenericObjectPoolConfig conf) {
        setLifo(conf.getLifo());
        setMaxIdle(conf.getMaxIdle());
        setMinIdle(conf.getMinIdle());
        setMaxTotal(conf.getMaxTotal());
        setMaxWaitMillis(conf.getMaxWaitMillis());
        setBlockWhenExhausted(conf.getBlockWhenExhausted());
        setTestOnCreate(conf.getTestOnCreate());
        setTestOnBorrow(conf.getTestOnBorrow());
        setTestOnReturn(conf.getTestOnReturn());
        setTestWhileIdle(conf.getTestWhileIdle());
        setNumTestsPerEvictionRun(conf.getNumTestsPerEvictionRun());
        setMinEvictableIdleTimeMillis(conf.getMinEvictableIdleTimeMillis());
        setTimeBetweenEvictionRunsMillis(conf.getTimeBetweenEvictionRunsMillis());
        setSoftMinEvictableIdleTimeMillis(conf.getSoftMinEvictableIdleTimeMillis());
        setEvictionPolicyClassName(conf.getEvictionPolicyClassName());
    }

    public void setAbandonedConfig(AbandonedConfig abandonedConfig2) throws IllegalArgumentException {
        if (abandonedConfig2 == null) {
            this.abandonedConfig = null;
            return;
        }
        this.abandonedConfig = new AbandonedConfig();
        this.abandonedConfig.setLogAbandoned(abandonedConfig2.getLogAbandoned());
        this.abandonedConfig.setLogWriter(abandonedConfig2.getLogWriter());
        this.abandonedConfig.setRemoveAbandonedOnBorrow(abandonedConfig2.getRemoveAbandonedOnBorrow());
        this.abandonedConfig.setRemoveAbandonedOnMaintenance(abandonedConfig2.getRemoveAbandonedOnMaintenance());
        this.abandonedConfig.setRemoveAbandonedTimeout(abandonedConfig2.getRemoveAbandonedTimeout());
        this.abandonedConfig.setUseUsageTracking(abandonedConfig2.getUseUsageTracking());
    }

    public PooledObjectFactory<T> getFactory() {
        return this.factory;
    }

    public T borrowObject() throws Exception {
        return borrowObject(getMaxWaitMillis());
    }

    public T borrowObject(long borrowMaxWaitMillis) throws Exception {
        assertOpen();
        AbandonedConfig ac = this.abandonedConfig;
        if (ac != null && ac.getRemoveAbandonedOnBorrow() && getNumIdle() < 2 && getNumActive() > getMaxTotal() - 3) {
            removeAbandoned(ac);
        }
        PooledObject<T> p = null;
        boolean blockWhenExhausted = getBlockWhenExhausted();
        long waitTime = System.currentTimeMillis();
        while (p == null) {
            boolean create = false;
            if (blockWhenExhausted) {
                p = this.idleObjects.pollFirst();
                if (p == null && (p = create()) != null) {
                    create = true;
                }
                if (p == null) {
                    if (borrowMaxWaitMillis < 0) {
                        p = this.idleObjects.takeFirst();
                    } else {
                        p = this.idleObjects.pollFirst(borrowMaxWaitMillis, TimeUnit.MILLISECONDS);
                    }
                }
                if (p == null) {
                    throw new NoSuchElementException("Timeout waiting for idle object");
                } else if (!p.allocate()) {
                    p = null;
                }
            } else {
                PooledObject<T> p2 = this.idleObjects.pollFirst();
                if (p2 == null && (p2 = create()) != null) {
                    create = true;
                }
                if (p == null) {
                    throw new NoSuchElementException("Pool exhausted");
                } else if (!p.allocate()) {
                    p = null;
                }
            }
            if (p != null) {
                try {
                    this.factory.activateObject(p);
                } catch (Exception e) {
                    try {
                        destroy(p);
                    } catch (Exception e2) {
                    }
                    p = null;
                    if (create) {
                        NoSuchElementException nsee = new NoSuchElementException("Unable to activate object");
                        nsee.initCause(e);
                        throw nsee;
                    }
                }
                if (p != null && (getTestOnBorrow() || (create && getTestOnCreate()))) {
                    boolean validate = false;
                    Throwable validationThrowable = null;
                    try {
                        validate = this.factory.validateObject(p);
                    } catch (Throwable t) {
                        PoolUtils.checkRethrow(t);
                        validationThrowable = t;
                    }
                    if (!validate) {
                        try {
                            destroy(p);
                            this.destroyedByBorrowValidationCount.incrementAndGet();
                        } catch (Exception e3) {
                        }
                        p = null;
                        if (create) {
                            NoSuchElementException nsee2 = new NoSuchElementException("Unable to validate object");
                            nsee2.initCause(validationThrowable);
                            throw nsee2;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        updateStatsBorrow(p, System.currentTimeMillis() - waitTime);
        return p.getObject();
    }

    public void returnObject(T obj) {
        PooledObject<T> p = this.allObjects.get(new BaseGenericObjectPool.IdentityWrapper(obj));
        if (p != null) {
            synchronized (p) {
                if (p.getState() == PooledObjectState.ALLOCATED) {
                    p.markReturning();
                } else {
                    throw new IllegalStateException("Object has already been returned to this pool or is invalid");
                }
            }
            long activeTime = p.getActiveTimeMillis();
            if (!getTestOnReturn() || this.factory.validateObject(p)) {
                try {
                    this.factory.passivateObject(p);
                    if (p.deallocate()) {
                        int maxIdleSave = getMaxIdle();
                        if (isClosed() || (maxIdleSave > -1 && maxIdleSave <= this.idleObjects.size())) {
                            try {
                                destroy(p);
                            } catch (Exception e) {
                                swallowException(e);
                            }
                        } else {
                            if (getLifo()) {
                                this.idleObjects.addFirst(p);
                            } else {
                                this.idleObjects.addLast(p);
                            }
                            if (isClosed()) {
                                clear();
                            }
                        }
                        updateStatsReturn(activeTime);
                        return;
                    }
                    throw new IllegalStateException("Object has already been returned to this pool or is invalid");
                } catch (Exception e1) {
                    swallowException(e1);
                    try {
                        destroy(p);
                    } catch (Exception e2) {
                        swallowException(e2);
                    }
                    try {
                        ensureIdle(1, false);
                    } catch (Exception e3) {
                        swallowException(e3);
                    }
                    updateStatsReturn(activeTime);
                }
            } else {
                try {
                    destroy(p);
                } catch (Exception e4) {
                    swallowException(e4);
                }
                try {
                    ensureIdle(1, false);
                } catch (Exception e5) {
                    swallowException(e5);
                }
                updateStatsReturn(activeTime);
            }
        } else if (!isAbandonedConfig()) {
            throw new IllegalStateException("Returned object not currently part of this pool");
        }
    }

    public void invalidateObject(T obj) throws Exception {
        PooledObject<T> p = this.allObjects.get(new BaseGenericObjectPool.IdentityWrapper(obj));
        if (p != null) {
            synchronized (p) {
                if (p.getState() != PooledObjectState.INVALID) {
                    destroy(p);
                }
            }
            ensureIdle(1, false);
        } else if (!isAbandonedConfig()) {
            throw new IllegalStateException("Invalidated object not currently part of this pool");
        }
    }

    public void clear() {
        PooledObject<T> p = this.idleObjects.poll();
        while (p != null) {
            try {
                destroy(p);
            } catch (Exception e) {
                swallowException(e);
            }
            p = this.idleObjects.poll();
        }
    }

    public int getNumActive() {
        return this.allObjects.size() - this.idleObjects.size();
    }

    public int getNumIdle() {
        return this.idleObjects.size();
    }

    public void close() {
        if (!isClosed()) {
            synchronized (this.closeLock) {
                if (!isClosed()) {
                    startEvictor(-1);
                    this.closed = true;
                    clear();
                    jmxUnregister();
                    this.idleObjects.interuptTakeWaiters();
                }
            }
        }
    }

    public void evict() throws Exception {
        boolean evict;
        assertOpen();
        if (this.idleObjects.size() > 0) {
            EvictionPolicy<T> evictionPolicy = getEvictionPolicy();
            synchronized (this.evictionLock) {
                EvictionConfig evictionConfig = new EvictionConfig(getMinEvictableIdleTimeMillis(), getSoftMinEvictableIdleTimeMillis(), getMinIdle());
                boolean testWhileIdle = getTestWhileIdle();
                int i = 0;
                int m = getNumTests();
                while (i < m) {
                    if (this.evictionIterator == null || !this.evictionIterator.hasNext()) {
                        this.evictionIterator = new BaseGenericObjectPool.EvictionIterator(this.idleObjects);
                    }
                    if (this.evictionIterator.hasNext()) {
                        try {
                            PooledObject next = this.evictionIterator.next();
                            if (!next.startEvictionTest()) {
                                i--;
                            } else {
                                try {
                                    evict = evictionPolicy.evict(evictionConfig, next, this.idleObjects.size());
                                } catch (Throwable t) {
                                    PoolUtils.checkRethrow(t);
                                    swallowException(new Exception(t));
                                    evict = false;
                                }
                                if (evict) {
                                    destroy(next);
                                    this.destroyedByEvictorCount.incrementAndGet();
                                } else {
                                    if (testWhileIdle) {
                                        boolean active = false;
                                        try {
                                            this.factory.activateObject(next);
                                            active = true;
                                        } catch (Exception e) {
                                            destroy(next);
                                            this.destroyedByEvictorCount.incrementAndGet();
                                        }
                                        if (active) {
                                            if (!this.factory.validateObject(next)) {
                                                destroy(next);
                                                this.destroyedByEvictorCount.incrementAndGet();
                                            } else {
                                                try {
                                                    this.factory.passivateObject(next);
                                                } catch (Exception e2) {
                                                    destroy(next);
                                                    this.destroyedByEvictorCount.incrementAndGet();
                                                }
                                            }
                                        }
                                    }
                                    next.endEvictionTest(this.idleObjects);
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
        AbandonedConfig ac = this.abandonedConfig;
        if (ac != null && ac.getRemoveAbandonedOnMaintenance()) {
            removeAbandoned(ac);
        }
    }

    public void preparePool() throws Exception {
        if (getMinIdle() >= 1) {
            ensureMinIdle();
        }
    }

    private PooledObject<T> create() throws Exception {
        int localMaxTotal = getMaxTotal();
        long newCreateCount = this.createCount.incrementAndGet();
        if ((localMaxTotal <= -1 || newCreateCount <= ((long) localMaxTotal)) && newCreateCount <= 2147483647L) {
            try {
                PooledObject<T> p = this.factory.makeObject();
                AbandonedConfig ac = this.abandonedConfig;
                if (ac != null && ac.getLogAbandoned()) {
                    p.setLogAbandoned(true);
                }
                this.createdCount.incrementAndGet();
                this.allObjects.put(new BaseGenericObjectPool.IdentityWrapper(p.getObject()), p);
                return p;
            } catch (Exception e) {
                this.createCount.decrementAndGet();
                throw e;
            }
        } else {
            this.createCount.decrementAndGet();
            return null;
        }
    }

    private void destroy(PooledObject<T> toDestory) throws Exception {
        toDestory.invalidate();
        this.idleObjects.remove(toDestory);
        this.allObjects.remove(new BaseGenericObjectPool.IdentityWrapper(toDestory.getObject()));
        try {
            this.factory.destroyObject(toDestory);
        } finally {
            this.destroyedCount.incrementAndGet();
            this.createCount.decrementAndGet();
        }
    }

    /* access modifiers changed from: package-private */
    public void ensureMinIdle() throws Exception {
        ensureIdle(getMinIdle(), true);
    }

    private void ensureIdle(int idleCount, boolean always) throws Exception {
        PooledObject<T> p;
        if (idleCount >= 1 && !isClosed()) {
            if (always || this.idleObjects.hasTakeWaiters()) {
                while (this.idleObjects.size() < idleCount && (p = create()) != null) {
                    if (getLifo()) {
                        this.idleObjects.addFirst(p);
                    } else {
                        this.idleObjects.addLast(p);
                    }
                }
                if (isClosed()) {
                    clear();
                }
            }
        }
    }

    public void addObject() throws Exception {
        assertOpen();
        if (this.factory != null) {
            addIdleObject(create());
            return;
        }
        throw new IllegalStateException("Cannot add objects without a factory.");
    }

    private void addIdleObject(PooledObject<T> p) throws Exception {
        if (p != null) {
            this.factory.passivateObject(p);
            if (getLifo()) {
                this.idleObjects.addFirst(p);
            } else {
                this.idleObjects.addLast(p);
            }
        }
    }

    private int getNumTests() {
        int numTestsPerEvictionRun = getNumTestsPerEvictionRun();
        if (numTestsPerEvictionRun >= 0) {
            return Math.min(numTestsPerEvictionRun, this.idleObjects.size());
        }
        return (int) Math.ceil(((double) this.idleObjects.size()) / Math.abs((double) numTestsPerEvictionRun));
    }

    private void removeAbandoned(AbandonedConfig ac) {
        long timeout = System.currentTimeMillis() - (((long) ac.getRemoveAbandonedTimeout()) * 1000);
        ArrayList<PooledObject<T>> remove = new ArrayList<>();
        for (PooledObject<T> pooledObject : this.allObjects.values()) {
            synchronized (pooledObject) {
                if (pooledObject.getState() == PooledObjectState.ALLOCATED && pooledObject.getLastUsedTime() <= timeout) {
                    pooledObject.markAbandoned();
                    remove.add(pooledObject);
                }
            }
        }
        Iterator<PooledObject<T>> itr = remove.iterator();
        while (itr.hasNext()) {
            PooledObject<T> pooledObject2 = itr.next();
            if (ac.getLogAbandoned()) {
                pooledObject2.printStackTrace(ac.getLogWriter());
            }
            try {
                invalidateObject(pooledObject2.getObject());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void use(T pooledObject) {
        AbandonedConfig ac = this.abandonedConfig;
        if (ac != null && ac.getUseUsageTracking()) {
            this.allObjects.get(new BaseGenericObjectPool.IdentityWrapper(pooledObject)).use();
        }
    }

    public int getNumWaiters() {
        if (getBlockWhenExhausted()) {
            return this.idleObjects.getTakeQueueLength();
        }
        return 0;
    }

    public String getFactoryType() {
        if (this.factoryType == null) {
            this.factoryType = this.factory.getClass().getName() + '<' + PoolImplUtils.getFactoryType(this.factory.getClass()).getName() + '>';
        }
        return this.factoryType;
    }

    public Set<DefaultPooledObjectInfo> listAllObjects() {
        Set<DefaultPooledObjectInfo> result = new HashSet<>(this.allObjects.size());
        for (PooledObject<T> p : this.allObjects.values()) {
            result.add(new DefaultPooledObjectInfo(p));
        }
        return result;
    }
}
