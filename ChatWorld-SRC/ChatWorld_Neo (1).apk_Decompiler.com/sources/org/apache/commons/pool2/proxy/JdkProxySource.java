package org.apache.commons.pool2.proxy;

import java.lang.reflect.Proxy;
import org.apache.commons.pool2.UsageTracking;

public class JdkProxySource<T> implements ProxySource<T> {
    private final ClassLoader classLoader;
    private final Class<?>[] interfaces;

    public JdkProxySource(ClassLoader classLoader2, Class<?>[] interfaces2) {
        this.classLoader = classLoader2;
        Class<?>[] clsArr = new Class[interfaces2.length];
        this.interfaces = clsArr;
        System.arraycopy(interfaces2, 0, clsArr, 0, interfaces2.length);
    }

    public T createProxy(T pooledObject, UsageTracking<T> usageTracking) {
        return Proxy.newProxyInstance(this.classLoader, this.interfaces, new JdkProxyHandler(pooledObject, usageTracking));
    }

    public T resolveProxy(T proxy) {
        return ((JdkProxyHandler) Proxy.getInvocationHandler(proxy)).disableProxy();
    }
}
