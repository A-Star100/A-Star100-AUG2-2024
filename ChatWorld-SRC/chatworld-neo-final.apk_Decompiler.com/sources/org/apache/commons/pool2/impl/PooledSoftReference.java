package org.apache.commons.pool2.impl;

import java.lang.ref.SoftReference;

public class PooledSoftReference<T> extends DefaultPooledObject<T> {
    private volatile SoftReference<T> reference;

    public PooledSoftReference(SoftReference<T> reference2) {
        super(null);
        this.reference = reference2;
    }

    public T getObject() {
        return this.reference.get();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Referenced Object: ");
        result.append(getObject().toString());
        result.append(", State: ");
        synchronized (this) {
            result.append(getState().toString());
        }
        return result.toString();
    }

    public synchronized SoftReference<T> getReference() {
        return this.reference;
    }

    public synchronized void setReference(SoftReference<T> reference2) {
        this.reference = reference2;
    }
}
