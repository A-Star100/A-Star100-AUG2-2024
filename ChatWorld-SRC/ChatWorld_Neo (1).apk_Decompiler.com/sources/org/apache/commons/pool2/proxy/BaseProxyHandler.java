package org.apache.commons.pool2.proxy;

import java.lang.reflect.Method;
import org.apache.commons.pool2.UsageTracking;

class BaseProxyHandler<T> {
    private volatile T pooledObject;
    private final UsageTracking<T> usageTracking;

    BaseProxyHandler(T pooledObject2, UsageTracking<T> usageTracking2) {
        this.pooledObject = pooledObject2;
        this.usageTracking = usageTracking2;
    }

    /* access modifiers changed from: package-private */
    public T getPooledObject() {
        return this.pooledObject;
    }

    /* access modifiers changed from: package-private */
    public T disableProxy() {
        T result = this.pooledObject;
        this.pooledObject = null;
        return result;
    }

    /* access modifiers changed from: package-private */
    public void validateProxiedObject() {
        if (this.pooledObject == null) {
            throw new IllegalStateException("This object may no longer be used as it has been returned to the Object Pool.");
        }
    }

    /* access modifiers changed from: package-private */
    public Object doInvoke(Method method, Object[] args) throws Throwable {
        validateProxiedObject();
        T object = getPooledObject();
        UsageTracking<T> usageTracking2 = this.usageTracking;
        if (usageTracking2 != null) {
            usageTracking2.use(object);
        }
        return method.invoke(object, args);
    }
}
