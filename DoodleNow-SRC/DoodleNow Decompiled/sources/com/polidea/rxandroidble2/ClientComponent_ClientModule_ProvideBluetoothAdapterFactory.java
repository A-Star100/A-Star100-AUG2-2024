package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothAdapter;
import bleshadow.dagger.internal.Factory;
import com.polidea.rxandroidble2.ClientComponent;

public final class ClientComponent_ClientModule_ProvideBluetoothAdapterFactory implements Factory<BluetoothAdapter> {
    public BluetoothAdapter get() {
        return provideBluetoothAdapter();
    }

    public static ClientComponent_ClientModule_ProvideBluetoothAdapterFactory create() {
        return InstanceHolder.INSTANCE;
    }

    public static BluetoothAdapter provideBluetoothAdapter() {
        return ClientComponent.ClientModule.provideBluetoothAdapter();
    }

    private static final class InstanceHolder {
        /* access modifiers changed from: private */
        public static final ClientComponent_ClientModule_ProvideBluetoothAdapterFactory INSTANCE = new ClientComponent_ClientModule_ProvideBluetoothAdapterFactory();

        private InstanceHolder() {
        }
    }
}
