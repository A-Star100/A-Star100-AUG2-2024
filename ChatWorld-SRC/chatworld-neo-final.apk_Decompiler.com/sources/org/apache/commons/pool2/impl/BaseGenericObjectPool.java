package org.apache.commons.pool2.impl;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.management.ManagementFactory;
import java.lang.ref.WeakReference;
import java.util.Deque;
import java.util.Iterator;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicLong;
import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.SwallowedExceptionListener;

public abstract class BaseGenericObjectPool<T> {
    public static final int MEAN_TIMING_STATS_CACHE_SIZE = 100;
    private final BaseGenericObjectPool<T>.StatsStore activeTimes = new StatsStore(100);
    private volatile boolean blockWhenExhausted = true;
    private final AtomicLong borrowedCount = new AtomicLong(0);
    final Object closeLock = new Object();
    volatile boolean closed = false;
    final AtomicLong createdCount = new AtomicLong(0);
    private final String creationStackTrace;
    final AtomicLong destroyedByBorrowValidationCount = new AtomicLong(0);
    final AtomicLong destroyedByEvictorCount = new AtomicLong(0);
    final AtomicLong destroyedCount = new AtomicLong(0);
    BaseGenericObjectPool<T>.EvictionIterator evictionIterator = null;
    final Object evictionLock = new Object();
    private volatile EvictionPolicy<T> evictionPolicy;
    private BaseGenericObjectPool<T>.Evictor evictor = null;
    /* access modifiers changed from: private */
    public final WeakReference<ClassLoader> factoryClassLoader;
    private final boolean fairness;
    private final BaseGenericObjectPool<T>.StatsStore idleTimes = new StatsStore(100);
    private volatile boolean lifo = true;
    private final AtomicLong maxBorrowWaitTimeMillis = new AtomicLong(0);
    private volatile int maxTotal = -1;
    private volatile long maxWaitMillis = -1;
    private volatile long minEvictableIdleTimeMillis = BaseObjectPoolConfig.DEFAULT_MIN_EVICTABLE_IDLE_TIME_MILLIS;
    private volatile int numTestsPerEvictionRun = 3;
    private final ObjectName oname;
    private final AtomicLong returnedCount = new AtomicLong(0);
    private volatile long softMinEvictableIdleTimeMillis = -1;
    private volatile SwallowedExceptionListener swallowedExceptionListener = null;
    private volatile boolean testOnBorrow = false;
    private volatile boolean testOnCreate = false;
    private volatile boolean testOnReturn = false;
    private volatile boolean testWhileIdle = false;
    private volatile long timeBetweenEvictionRunsMillis = -1;
    private final BaseGenericObjectPool<T>.StatsStore waitTimes = new StatsStore(100);

    public abstract void close();

    /* access modifiers changed from: package-private */
    public abstract void ensureMinIdle() throws Exception;

    public abstract void evict() throws Exception;

    public abstract int getNumIdle();

    public BaseGenericObjectPool(BaseObjectPoolConfig config, String jmxNameBase, String jmxNamePrefix) {
        if (config.getJmxEnabled()) {
            this.oname = jmxRegister(config, jmxNameBase, jmxNamePrefix);
        } else {
            this.oname = null;
        }
        this.creationStackTrace = getStackTrace(new Exception());
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        if (cl == null) {
            this.factoryClassLoader = null;
        } else {
            this.factoryClassLoader = new WeakReference<>(cl);
        }
        this.fairness = config.getFairness();
    }

    public final int getMaxTotal() {
        return this.maxTotal;
    }

    public final void setMaxTotal(int maxTotal2) {
        this.maxTotal = maxTotal2;
    }

    public final boolean getBlockWhenExhausted() {
        return this.blockWhenExhausted;
    }

    public final void setBlockWhenExhausted(boolean blockWhenExhausted2) {
        this.blockWhenExhausted = blockWhenExhausted2;
    }

    public final long getMaxWaitMillis() {
        return this.maxWaitMillis;
    }

    public final void setMaxWaitMillis(long maxWaitMillis2) {
        this.maxWaitMillis = maxWaitMillis2;
    }

    public final boolean getLifo() {
        return this.lifo;
    }

    public final boolean getFairness() {
        return this.fairness;
    }

    public final void setLifo(boolean lifo2) {
        this.lifo = lifo2;
    }

    public final boolean getTestOnCreate() {
        return this.testOnCreate;
    }

    public final void setTestOnCreate(boolean testOnCreate2) {
        this.testOnCreate = testOnCreate2;
    }

    public final boolean getTestOnBorrow() {
        return this.testOnBorrow;
    }

    public final void setTestOnBorrow(boolean testOnBorrow2) {
        this.testOnBorrow = testOnBorrow2;
    }

    public final boolean getTestOnReturn() {
        return this.testOnReturn;
    }

    public final void setTestOnReturn(boolean testOnReturn2) {
        this.testOnReturn = testOnReturn2;
    }

    public final boolean getTestWhileIdle() {
        return this.testWhileIdle;
    }

    public final void setTestWhileIdle(boolean testWhileIdle2) {
        this.testWhileIdle = testWhileIdle2;
    }

    public final long getTimeBetweenEvictionRunsMillis() {
        return this.timeBetweenEvictionRunsMillis;
    }

    public final void setTimeBetweenEvictionRunsMillis(long timeBetweenEvictionRunsMillis2) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis2;
        startEvictor(timeBetweenEvictionRunsMillis2);
    }

    public final int getNumTestsPerEvictionRun() {
        return this.numTestsPerEvictionRun;
    }

    public final void setNumTestsPerEvictionRun(int numTestsPerEvictionRun2) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun2;
    }

    public final long getMinEvictableIdleTimeMillis() {
        return this.minEvictableIdleTimeMillis;
    }

    public final void setMinEvictableIdleTimeMillis(long minEvictableIdleTimeMillis2) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis2;
    }

    public final long getSoftMinEvictableIdleTimeMillis() {
        return this.softMinEvictableIdleTimeMillis;
    }

    public final void setSoftMinEvictableIdleTimeMillis(long softMinEvictableIdleTimeMillis2) {
        this.softMinEvictableIdleTimeMillis = softMinEvictableIdleTimeMillis2;
    }

    public final String getEvictionPolicyClassName() {
        return this.evictionPolicy.getClass().getName();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003f, code lost:
        throw new java.lang.IllegalArgumentException("Unable to create EvictionPolicy instance of type " + r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0056, code lost:
        throw new java.lang.IllegalArgumentException("Unable to create EvictionPolicy instance of type " + r5, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0010, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0012, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r1 = java.lang.Class.forName(r5);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010 A[ExcHandler: IllegalAccessException (r1v6 'e' java.lang.IllegalAccessException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* JADX WARNING: Removed duplicated region for block: B:4:0x0012 A[ExcHandler: InstantiationException (r1v5 'e' java.lang.InstantiationException A[CUSTOM_DECLARE]), Splitter:B:1:0x0003] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setEvictionPolicyClassName(java.lang.String r5) {
        /*
            r4 = this;
            java.lang.String r0 = "Unable to create EvictionPolicy instance of type "
            r1 = 1
            java.lang.Thread r2 = java.lang.Thread.currentThread()     // Catch:{ ClassNotFoundException -> 0x0014, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            java.lang.ClassLoader r2 = r2.getContextClassLoader()     // Catch:{ ClassNotFoundException -> 0x0014, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            java.lang.Class r1 = java.lang.Class.forName(r5, r1, r2)     // Catch:{ ClassNotFoundException -> 0x0014, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            goto L_0x001a
        L_0x0010:
            r1 = move-exception
            goto L_0x0029
        L_0x0012:
            r1 = move-exception
            goto L_0x0040
        L_0x0014:
            r1 = move-exception
            java.lang.Class r2 = java.lang.Class.forName(r5)     // Catch:{ ClassNotFoundException -> 0x0057, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            r1 = r2
        L_0x001a:
            java.lang.Object r2 = r1.newInstance()     // Catch:{ ClassNotFoundException -> 0x0057, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            boolean r3 = r2 instanceof org.apache.commons.pool2.impl.EvictionPolicy     // Catch:{ ClassNotFoundException -> 0x0057, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            if (r3 == 0) goto L_0x0027
            r3 = r2
            org.apache.commons.pool2.impl.EvictionPolicy r3 = (org.apache.commons.pool2.impl.EvictionPolicy) r3     // Catch:{ ClassNotFoundException -> 0x0057, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
            r4.evictionPolicy = r3     // Catch:{ ClassNotFoundException -> 0x0057, InstantiationException -> 0x0012, IllegalAccessException -> 0x0010 }
        L_0x0027:
            return
        L_0x0029:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r1)
            throw r2
        L_0x0040:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r1)
            throw r2
        L_0x0057:
            r1 = move-exception
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.StringBuilder r0 = r3.append(r0)
            java.lang.StringBuilder r0 = r0.append(r5)
            java.lang.String r0 = r0.toString()
            r2.<init>(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.pool2.impl.BaseGenericObjectPool.setEvictionPolicyClassName(java.lang.String):void");
    }

    public final boolean isClosed() {
        return this.closed;
    }

    /* access modifiers changed from: protected */
    public EvictionPolicy<T> getEvictionPolicy() {
        return this.evictionPolicy;
    }

    /* access modifiers changed from: package-private */
    public final void assertOpen() throws IllegalStateException {
        if (isClosed()) {
            throw new IllegalStateException("Pool not open");
        }
    }

    /* access modifiers changed from: package-private */
    public final void startEvictor(long delay) {
        synchronized (this.evictionLock) {
            BaseGenericObjectPool<T>.Evictor evictor2 = this.evictor;
            if (evictor2 != null) {
                EvictionTimer.cancel(evictor2);
                this.evictor = null;
                this.evictionIterator = null;
            }
            if (delay > 0) {
                BaseGenericObjectPool<T>.Evictor evictor3 = new Evictor();
                this.evictor = evictor3;
                EvictionTimer.schedule(evictor3, delay, delay);
            }
        }
    }

    public final ObjectName getJmxName() {
        return this.oname;
    }

    public final String getCreationStackTrace() {
        return this.creationStackTrace;
    }

    public final long getBorrowedCount() {
        return this.borrowedCount.get();
    }

    public final long getReturnedCount() {
        return this.returnedCount.get();
    }

    public final long getCreatedCount() {
        return this.createdCount.get();
    }

    public final long getDestroyedCount() {
        return this.destroyedCount.get();
    }

    public final long getDestroyedByEvictorCount() {
        return this.destroyedByEvictorCount.get();
    }

    public final long getDestroyedByBorrowValidationCount() {
        return this.destroyedByBorrowValidationCount.get();
    }

    public final long getMeanActiveTimeMillis() {
        return this.activeTimes.getMean();
    }

    public final long getMeanIdleTimeMillis() {
        return this.idleTimes.getMean();
    }

    public final long getMeanBorrowWaitTimeMillis() {
        return this.waitTimes.getMean();
    }

    public final long getMaxBorrowWaitTimeMillis() {
        return this.maxBorrowWaitTimeMillis.get();
    }

    public final SwallowedExceptionListener getSwallowedExceptionListener() {
        return this.swallowedExceptionListener;
    }

    public final void setSwallowedExceptionListener(SwallowedExceptionListener swallowedExceptionListener2) {
        this.swallowedExceptionListener = swallowedExceptionListener2;
    }

    /* access modifiers changed from: package-private */
    public final void swallowException(Exception e) {
        SwallowedExceptionListener listener = getSwallowedExceptionListener();
        if (listener != null) {
            try {
                listener.onSwallowException(e);
            } catch (OutOfMemoryError oome) {
                throw oome;
            } catch (VirtualMachineError vme) {
                throw vme;
            } catch (Throwable th) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void updateStatsBorrow(PooledObject<T> p, long waitTime) {
        long currentMax;
        this.borrowedCount.incrementAndGet();
        this.idleTimes.add(p.getIdleTimeMillis());
        this.waitTimes.add(waitTime);
        do {
            currentMax = this.maxBorrowWaitTimeMillis.get();
            if (currentMax >= waitTime || this.maxBorrowWaitTimeMillis.compareAndSet(currentMax, waitTime)) {
            }
            currentMax = this.maxBorrowWaitTimeMillis.get();
            return;
        } while (this.maxBorrowWaitTimeMillis.compareAndSet(currentMax, waitTime));
    }

    /* access modifiers changed from: package-private */
    public final void updateStatsReturn(long activeTime) {
        this.returnedCount.incrementAndGet();
        this.activeTimes.add(activeTime);
    }

    /* access modifiers changed from: package-private */
    public final void jmxUnregister() {
        if (this.oname != null) {
            try {
                ManagementFactory.getPlatformMBeanServer().unregisterMBean(this.oname);
            } catch (MBeanRegistrationException e) {
                swallowException(e);
            } catch (InstanceNotFoundException e2) {
                swallowException(e2);
            }
        }
    }

    private ObjectName jmxRegister(BaseObjectPoolConfig config, String jmxNameBase, String jmxNamePrefix) {
        ObjectName objName;
        ObjectName objectName = null;
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        int i = 1;
        boolean registered = false;
        String base = config.getJmxNameBase();
        if (base == null) {
            base = jmxNameBase;
        }
        while (!registered) {
            if (i == 1) {
                try {
                    objName = new ObjectName(base + jmxNamePrefix);
                } catch (MalformedObjectNameException e) {
                    if (!BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX.equals(jmxNamePrefix) || !jmxNameBase.equals(base)) {
                        jmxNamePrefix = BaseObjectPoolConfig.DEFAULT_JMX_NAME_PREFIX;
                        base = jmxNameBase;
                    } else {
                        registered = true;
                    }
                } catch (InstanceAlreadyExistsException e2) {
                    i++;
                } catch (MBeanRegistrationException e3) {
                    registered = true;
                } catch (NotCompliantMBeanException e4) {
                    registered = true;
                }
            } else {
                objName = new ObjectName(base + jmxNamePrefix + i);
            }
            mbs.registerMBean(this, objName);
            objectName = objName;
            registered = true;
        }
        return objectName;
    }

    private String getStackTrace(Exception e) {
        Writer w = new StringWriter();
        e.printStackTrace(new PrintWriter(w));
        return w.toString();
    }

    class Evictor extends TimerTask {
        Evictor() {
        }

        public void run() {
            ClassLoader savedClassLoader = Thread.currentThread().getContextClassLoader();
            try {
                if (BaseGenericObjectPool.this.factoryClassLoader != null) {
                    ClassLoader cl = (ClassLoader) BaseGenericObjectPool.this.factoryClassLoader.get();
                    if (cl == null) {
                        cancel();
                        Thread.currentThread().setContextClassLoader(savedClassLoader);
                        return;
                    }
                    Thread.currentThread().setContextClassLoader(cl);
                }
                BaseGenericObjectPool.this.evict();
            } catch (Exception e) {
                BaseGenericObjectPool.this.swallowException(e);
            } catch (OutOfMemoryError oome) {
                oome.printStackTrace(System.err);
            } catch (Throwable th) {
                Thread.currentThread().setContextClassLoader(savedClassLoader);
                throw th;
            }
            try {
                BaseGenericObjectPool.this.ensureMinIdle();
            } catch (Exception e2) {
                BaseGenericObjectPool.this.swallowException(e2);
            }
            Thread.currentThread().setContextClassLoader(savedClassLoader);
        }
    }

    private class StatsStore {
        private int index;
        private final int size;
        private final AtomicLong[] values;

        public StatsStore(int size2) {
            this.size = size2;
            this.values = new AtomicLong[size2];
            for (int i = 0; i < size2; i++) {
                this.values[i] = new AtomicLong(-1);
            }
        }

        public synchronized void add(long value) {
            this.values[this.index].set(value);
            int i = this.index + 1;
            this.index = i;
            if (i == this.size) {
                this.index = 0;
            }
        }

        public long getMean() {
            double result = 0.0d;
            int counter = 0;
            for (int i = 0; i < this.size; i++) {
                long value = this.values[i].get();
                if (value != -1) {
                    counter++;
                    double d = (double) (counter - 1);
                    double d2 = (double) counter;
                    Double.isNaN(d);
                    Double.isNaN(d2);
                    double d3 = (double) value;
                    double d4 = (double) counter;
                    Double.isNaN(d3);
                    Double.isNaN(d4);
                    result = ((d / d2) * result) + (d3 / d4);
                }
            }
            return (long) result;
        }
    }

    class EvictionIterator implements Iterator<PooledObject<T>> {
        private final Iterator<PooledObject<T>> idleObjectIterator;
        private final Deque<PooledObject<T>> idleObjects;

        EvictionIterator(Deque<PooledObject<T>> idleObjects2) {
            this.idleObjects = idleObjects2;
            if (BaseGenericObjectPool.this.getLifo()) {
                this.idleObjectIterator = idleObjects2.descendingIterator();
            } else {
                this.idleObjectIterator = idleObjects2.iterator();
            }
        }

        public Deque<PooledObject<T>> getIdleObjects() {
            return this.idleObjects;
        }

        public boolean hasNext() {
            return this.idleObjectIterator.hasNext();
        }

        public PooledObject<T> next() {
            return this.idleObjectIterator.next();
        }

        public void remove() {
            this.idleObjectIterator.remove();
        }
    }

    static class IdentityWrapper<T> {
        private final T instance;

        public IdentityWrapper(T instance2) {
            this.instance = instance2;
        }

        public int hashCode() {
            return System.identityHashCode(this.instance);
        }

        public boolean equals(Object other) {
            return ((IdentityWrapper) other).instance == this.instance;
        }

        public T getObject() {
            return this.instance;
        }
    }
}
