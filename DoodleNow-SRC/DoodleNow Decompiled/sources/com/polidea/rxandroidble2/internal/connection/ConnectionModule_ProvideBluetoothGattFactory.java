package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import bleshadow.dagger.internal.Factory;
import bleshadow.dagger.internal.Preconditions;
import bleshadow.javax.inject.Provider;

public final class ConnectionModule_ProvideBluetoothGattFactory implements Factory<BluetoothGatt> {
    private final Provider<BluetoothGattProvider> bluetoothGattProvider;

    public ConnectionModule_ProvideBluetoothGattFactory(Provider<BluetoothGattProvider> provider) {
        this.bluetoothGattProvider = provider;
    }

    public BluetoothGatt get() {
        return provideBluetoothGatt(this.bluetoothGattProvider.get());
    }

    public static ConnectionModule_ProvideBluetoothGattFactory create(Provider<BluetoothGattProvider> provider) {
        return new ConnectionModule_ProvideBluetoothGattFactory(provider);
    }

    public static BluetoothGatt provideBluetoothGatt(BluetoothGattProvider bluetoothGattProvider2) {
        return (BluetoothGatt) Preconditions.checkNotNullFromProvides(ConnectionModule.provideBluetoothGatt(bluetoothGattProvider2));
    }
}
