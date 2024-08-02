package org.apache.commons.pool2.proxy;

import org.apache.commons.pool2.KeyedObjectPool;

public class ProxiedKeyedObjectPool<K, V> implements KeyedObjectPool<K, V> {
    private final KeyedObjectPool<K, V> pool;
    private final ProxySource<V> proxySource;

    public ProxiedKeyedObjectPool(KeyedObjectPool<K, V> pool2, ProxySource<V> proxySource2) {
        this.pool = pool2;
        this.proxySource = proxySource2;
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [org.apache.commons.pool2.KeyedObjectPool, org.apache.commons.pool2.KeyedObjectPool<K, V>] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public V borrowObject(K r4) throws java.lang.Exception, java.util.NoSuchElementException, java.lang.IllegalStateException {
        /*
            r3 = this;
            r0 = 0
            org.apache.commons.pool2.KeyedObjectPool<K, V> r1 = r3.pool
            boolean r2 = r1 instanceof org.apache.commons.pool2.UsageTracking
            if (r2 == 0) goto L_0x000a
            r0 = r1
            org.apache.commons.pool2.UsageTracking r0 = (org.apache.commons.pool2.UsageTracking) r0
        L_0x000a:
            java.lang.Object r1 = r1.borrowObject(r4)
            org.apache.commons.pool2.proxy.ProxySource<V> r2 = r3.proxySource
            java.lang.Object r2 = r2.createProxy(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.commons.pool2.proxy.ProxiedKeyedObjectPool.borrowObject(java.lang.Object):java.lang.Object");
    }

    public void returnObject(K key, V proxy) throws Exception {
        this.pool.returnObject(key, this.proxySource.resolveProxy(proxy));
    }

    public void invalidateObject(K key, V proxy) throws Exception {
        this.pool.invalidateObject(key, this.proxySource.resolveProxy(proxy));
    }

    public void addObject(K key) throws Exception, IllegalStateException, UnsupportedOperationException {
        this.pool.addObject(key);
    }

    public int getNumIdle(K key) {
        return this.pool.getNumIdle(key);
    }

    public int getNumActive(K key) {
        return this.pool.getNumActive(key);
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

    public void clear(K key) throws Exception, UnsupportedOperationException {
        this.pool.clear(key);
    }

    public void close() {
        this.pool.close();
    }
}
