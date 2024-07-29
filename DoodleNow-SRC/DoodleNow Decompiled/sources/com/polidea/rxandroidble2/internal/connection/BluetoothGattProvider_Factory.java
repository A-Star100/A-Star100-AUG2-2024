package com.polidea.rxandroidble2.internal.connection;

import bleshadow.dagger.internal.Factory;

public final class BluetoothGattProvider_Factory implements Factory<BluetoothGattProvider> {
    public BluetoothGattProvider get() {
        return newInstance();
    }

    public static BluetoothGattProvider_Factory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BluetoothGattProvider newInstance() {
        return new BluetoothGattProvider();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final BluetoothGattProvider_Factory INSTANCE = new BluetoothGattProvider_Factory();

        private InstanceHolder() {
        }
    }
}
