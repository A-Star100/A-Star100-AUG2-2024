package org.apache.commons.pool2.impl;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.pool2.BaseObjectPool;
import org.apache.commons.pool2.PoolUtils;
import org.apache.commons.pool2.PooledObjectFactory;

public class SoftReferenceObjectPool<T> extends BaseObjectPool<T> {
    private final ArrayList<PooledSoftReference<T>> allReferences = new ArrayList<>();
    private long createCount = 0;
    private long destroyCount = 0;
    private final PooledObjectFactory<T> factory;
    private final LinkedBlockingDeque<PooledSoftReference<T>> idleReferences = new LinkedBlockingDeque<>();
    private int numActive = 0;
    private final ReferenceQueue<T> refQueue = new ReferenceQueue<>();

    public SoftReferenceObjectPool(PooledObjectFactory<T> factory2) {
        this.factory = factory2;
    }

    public synchronized T borrowObject() throws Exception {
        T obj;
        boolean newlyCreated;
        assertOpen();
        obj = null;
        newlyCreated = false;
        PooledSoftReference<T> ref = null;
        while (obj == null) {
            if (this.idleReferences.isEmpty()) {
                PooledObjectFactory<T> pooledObjectFactory = this.factory;
                if (pooledObjectFactory != null) {
                    newlyCreated = true;
                    obj = pooledObjectFactory.makeObject().getObject();
                    this.createCount++;
                    ref = new PooledSoftReference<>(new SoftReference(obj));
                    this.allReferences.add(ref);
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                ref = this.idleReferences.pollFirst();
                obj = ref.getObject();
                ref.getReference().clear();
                ref.setReference(new SoftReference(obj));
            }
            PooledObjectFactory<T> pooledObjectFactory2 = this.factory;
            if (!(pooledObjectFactory2 == null || obj == null)) {
                try {
                    pooledObjectFactory2.activateObject(ref);
                    if (!this.factory.validateObject(ref)) {
                        throw new Exception("ValidateObject failed");
                    }
                } catch (Throwable t2) {
                    try {
                        PoolUtils.checkRethrow(t2);
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }
        this.numActive++;
        ref.allocate();
        return obj;
        obj = null;
        if (newlyCreated) {
            throw new NoSuchElementException("Could not create a validated object, cause: " + t.getMessage());
        }
    }

    public synchronized void returnObject(T obj) throws Exception {
        boolean shouldDestroy = false;
        boolean success = !isClosed();
        PooledSoftReference<T> ref = findReference(obj);
        if (ref != null) {
            PooledObjectFactory<T> pooledObjectFactory = this.factory;
            if (pooledObjectFactory != null) {
                if (!pooledObjectFactory.validateObject(ref)) {
                    success = false;
                } else {
                    try {
                        this.factory.passivateObject(ref);
                    } catch (Exception e) {
                        success = false;
                    }
                }
            }
            if (!success) {
                shouldDestroy = true;
            }
            this.numActive--;
            if (success) {
                ref.deallocate();
                this.idleReferences.add(ref);
            }
            notifyAll();
            if (shouldDestroy && this.factory != null) {
                try {
                    destroy(ref);
                } catch (Exception e2) {
                }
            }
        } else {
            throw new IllegalStateException("Returned object not currently part of this pool");
        }
    }

    public synchronized void invalidateObject(T obj) throws Exception {
        PooledSoftReference<T> ref = findReference(obj);
        if (ref != null) {
            if (this.factory != null) {
                destroy(ref);
            }
            this.numActive--;
            notifyAll();
        } else {
            throw new IllegalStateException("Object to invalidate is not currently part of this pool");
        }
    }

    public synchronized void addObject() throws Exception {
        assertOpen();
        PooledObjectFactory<T> pooledObjectFactory = this.factory;
        if (pooledObjectFactory != null) {
            T obj = pooledObjectFactory.makeObject().getObject();
            this.createCount++;
            PooledSoftReference<T> ref = new PooledSoftReference<>(new SoftReference(obj, this.refQueue));
            this.allReferences.add(ref);
            boolean success = true;
            if (!this.factory.validateObject(ref)) {
                success = false;
            } else {
                this.factory.passivateObject(ref);
            }
            boolean shouldDestroy = !success;
            if (success) {
                this.idleReferences.add(ref);
                notifyAll();
            }
            if (shouldDestroy) {
                try {
                    destroy(ref);
                } catch (Exception e) {
                }
            }
        } else {
            throw new IllegalStateException("Cannot add objects without a factory.");
        }
    }

    public synchronized int getNumIdle() {
        pruneClearedReferences();
        return this.idleReferences.size();
    }

    public synchronized int getNumActive() {
        return this.numActive;
    }

    public synchronized void clear() {
        if (this.factory != null) {
            Iterator<PooledSoftReference<T>> iter = this.idleReferences.iterator();
            while (iter.hasNext()) {
                try {
                    PooledSoftReference<T> ref = iter.next();
                    if (ref.getObject() != null) {
                        this.factory.destroyObject(ref);
                    }
                } catch (Exception e) {
                }
            }
        }
        this.idleReferences.clear();
        pruneClearedReferences();
    }

    public void close() {
        super.close();
        clear();
    }

    public synchronized PooledObjectFactory<T> getFactory() {
        return this.factory;
    }

    private void pruneClearedReferences() {
        removeClearedReferences(this.idleReferences.iterator());
        removeClearedReferences(this.allReferences.iterator());
        do {
        } while (this.refQueue.poll() != null);
    }

    private PooledSoftReference<T> findReference(T obj) {
        Iterator<PooledSoftReference<T>> iterator = this.allReferences.iterator();
        while (iterator.hasNext()) {
            PooledSoftReference<T> reference = iterator.next();
            if (reference.getObject() != null && reference.getObject().equals(obj)) {
                return reference;
            }
        }
        return null;
    }

    private void destroy(PooledSoftReference<T> toDestroy) throws Exception {
        toDestroy.invalidate();
        this.idleReferences.remove(toDestroy);
        this.allReferences.remove(toDestroy);
        try {
            this.factory.destroyObject(toDestroy);
        } finally {
            this.destroyCount++;
            toDestroy.getReference().clear();
        }
    }

    private void removeClearedReferences(Iterator<PooledSoftReference<T>> iterator) {
        while (iterator.hasNext()) {
            PooledSoftReference<T> ref = iterator.next();
            if (ref.getReference() == null || ref.getReference().isEnqueued()) {
                iterator.remove();
            }
        }
    }
}
