package org.apache.commons.pool2.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.Factory;
import org.apache.commons.pool2.UsageTracking;

public class CglibProxySource<T> implements ProxySource<T> {
    private final Class<? extends T> superclass;

    public CglibProxySource(Class<? extends T> superclass2) {
        this.superclass = superclass2;
    }

    public T createProxy(T pooledObject, UsageTracking<T> usageTracking) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.superclass);
        enhancer.setCallback(new CglibProxyHandler<>(pooledObject, usageTracking));
        return enhancer.create();
    }

    public T resolveProxy(T proxy) {
        return ((Factory) proxy).getCallback(0).disableProxy();
    }
}
