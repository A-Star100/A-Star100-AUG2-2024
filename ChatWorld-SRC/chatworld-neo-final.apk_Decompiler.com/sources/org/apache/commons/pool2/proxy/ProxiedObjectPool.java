package org.apache.commons.pool2.proxy;

import org.apache.commons.pool2.ObjectPool;

public class ProxiedObjectPool<T> implements ObjectPool<T> {
    private final ObjectPool<T> pool;
    private final ProxySource<T> proxySource;

    public ProxiedObjectPool(ObjectPool<T> pool2, ProxySource<T> proxySource2) {
        this.pool = pool2;
        this.proxySource = proxySource2;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [org.apache.commons.pool2.ObjectPool<T>, org.apache.commons.pool2.ObjectPool] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T borrowObject() throws java.lang.Exception, java.util.NoSuchElementException, java.lang.IllegalStateException {
        /*
            r3 = this;
            r0 = 0
            org.apache.commons.pool2.ObjectPool<T> r1 = r3.pool
            boolean r2 = r1 instanceof org.apache.commons.pool2.UsageTracking
            if (r2 == 0) goto L_0x000a
            r0 = r1
            org.apache.commons.pool2.UsageTracking r0 = (org.apache.commons.pool2.UsageTracking) r0
        L_0x000a:
            java.lang.Object r1 = r1.borrowObject()
            org.apache.commons.pool2.proxy.ProxySource<T> r2 = r3.proxySource
            java.lang.Object r2 = r2.createProxy(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.pool2.proxy.ProxiedObjectPool.borrowObject():java.lang.Object");
    }

    public void returnObject(T proxy) throws Exception {
        this.pool.returnObject(this.proxySource.resolveProxy(proxy));
    }

    public void invalidateObject(T proxy) throws Exception {
        this.pool.invalidateObject(this.proxySource.resolveProxy(proxy));
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
        this.pool.close();
    }
}
