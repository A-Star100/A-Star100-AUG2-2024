package org.apache.commons.pool2.proxy;

import org.apache.commons.pool2.UsageTracking;

interface ProxySource<T> {
    T createProxy(T t, UsageTracking<T> usageTracking);

    T resolveProxy(T t);
}
