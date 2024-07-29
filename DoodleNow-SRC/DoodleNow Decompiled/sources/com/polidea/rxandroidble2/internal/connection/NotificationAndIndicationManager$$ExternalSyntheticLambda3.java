package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import io.reactivex.functions.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda3 implements Action {
    public final /* synthetic */ BluetoothGatt f$0;
    public final /* synthetic */ BluetoothGattCharacteristic f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda3(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean z) {
        this.f$0 = bluetoothGatt;
        this.f$1 = bluetoothGattCharacteristic;
        this.f$2 = z;
    }

    public final void run() {
        NotificationAndIndicationManager.lambda$setCharacteristicNotification$3(this.f$0, this.f$1, this.f$2);
    }
}
