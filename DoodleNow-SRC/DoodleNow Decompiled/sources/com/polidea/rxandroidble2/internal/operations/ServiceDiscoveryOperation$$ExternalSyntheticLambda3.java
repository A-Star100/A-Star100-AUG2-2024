package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import io.reactivex.Scheduler;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServiceDiscoveryOperation$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ BluetoothGatt f$0;
    public final /* synthetic */ Scheduler f$1;

    public /* synthetic */ ServiceDiscoveryOperation$$ExternalSyntheticLambda3(BluetoothGatt bluetoothGatt, Scheduler scheduler) {
        this.f$0 = bluetoothGatt;
        this.f$1 = scheduler;
    }

    public final Object call() {
        return ServiceDiscoveryOperation.lambda$timeoutFallbackProcedure$3(this.f$0, this.f$1);
    }
}
