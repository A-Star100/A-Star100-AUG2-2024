package com.polidea.rxandroidble2.internal.cache;

import bleshadow.dagger.internal.Factory;

public final class DeviceComponentCache_Factory implements Factory<DeviceComponentCache> {
    public DeviceComponentCache get() {
        return newInstance();
    }

    public static DeviceComponentCache_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static DeviceComponentCache newInstance() {
        return new DeviceComponentCache();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DeviceComponentCache_Factory INSTANCE = new DeviceComponentCache_Factory();

        private InstanceHolder() {
        }
    }
}
