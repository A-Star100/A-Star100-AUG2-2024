package com.polidea.rxandroidble2.internal;

import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.polidea.rxandroidble2.RxBleConnection;

public final class DeviceModule_ProvideConnectionStateRelayFactory implements Factory<BehaviorRelay<RxBleConnection.RxBleConnectionState>> {
    public BehaviorRelay<RxBleConnection.RxBleConnectionState> get() {
        return provideConnectionStateRelay();
    }

    public static DeviceModule_ProvideConnectionStateRelayFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BehaviorRelay<RxBleConnection.RxBleConnectionState> provideConnectionStateRelay() {
        return (BehaviorRelay) Preconditions.checkNotNullFromProvides(DeviceModule.provideConnectionStateRelay());
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final DeviceModule_ProvideConnectionStateRelayFactory INSTANCE = new DeviceModule_ProvideConnectionStateRelayFactory();

        private InstanceHolder() {
        }
    }
}
