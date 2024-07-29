package com.bleplx.adapter.utils;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RefreshGattCustomOperation$$ExternalSyntheticLambda0 implements Callable {
    public final /* synthetic */ BluetoothGatt f$0;

    public /* synthetic */ RefreshGattCustomOperation$$ExternalSyntheticLambda0(BluetoothGatt bluetoothGatt) {
        this.f$0 = bluetoothGatt;
    }

    public final Object call() {
        return RefreshGattCustomOperation.lambda$asObservable$0(this.f$0);
    }
}
