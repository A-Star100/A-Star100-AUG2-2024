package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServiceDiscoveryOperation$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ BluetoothGatt f$0;

    public /* synthetic */ ServiceDiscoveryOperation$$ExternalSyntheticLambda0(BluetoothGatt bluetoothGatt) {
        this.f$0 = bluetoothGatt;
    }

    public final Object call() {
        return ServiceDiscoveryOperation.lambda$timeoutFallbackProcedure$1(this.f$0);
    }
}
