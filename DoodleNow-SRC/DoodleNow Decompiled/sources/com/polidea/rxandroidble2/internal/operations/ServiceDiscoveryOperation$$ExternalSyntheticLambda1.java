package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import io.reactivex.Single;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ServiceDiscoveryOperation$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ BluetoothGatt f$0;

    public /* synthetic */ ServiceDiscoveryOperation$$ExternalSyntheticLambda1(BluetoothGatt bluetoothGatt) {
        this.f$0 = bluetoothGatt;
    }

    public final Object apply(Object obj) {
        return Single.fromCallable(new ServiceDiscoveryOperation$$ExternalSyntheticLambda0(this.f$0));
    }
}
