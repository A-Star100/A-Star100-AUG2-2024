package com.polidea.rxandroidble2.internal;

import bleshadow.dagger.internal.Factory;
import bleshadow.javax.inject.Provider;
import com.polidea.rxandroidble2.internal.DeviceComponent;
import com.polidea.rxandroidble2.internal.cache.DeviceComponentCache;

public final class RxBleDeviceProvider_Factory implements Factory<RxBleDeviceProvider> {
    private final Provider<DeviceComponent.Builder> deviceComponentBuilderProvider;
    private final Provider<DeviceComponentCache> deviceComponentCacheProvider;

    public RxBleDeviceProvider_Factory(Provider<DeviceComponentCache> provider, Provider<DeviceComponent.Builder> provider2) {
        this.deviceComponentCacheProvider = provider;
        this.deviceComponentBuilderProvider = provider2;
    }

    public RxBleDeviceProvider get() {
        return newInstance(this.deviceComponentCacheProvider.get(), this.deviceComponentBuilderProvider);
    }

    public static RxBleDeviceProvider_Factory create(Provider<DeviceComponentCache> provider, Provider<DeviceComponent.Builder> provider2) {
        return new RxBleDeviceProvider_Factory(provider, provider2);
    }

    public static RxBleDeviceProvider newInstance(DeviceComponentCache deviceComponentCache, Provider<DeviceComponent.Builder> provider) {
        return new RxBleDeviceProvider(deviceComponentCache, provider);
    }
}
