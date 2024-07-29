package com.polidea.rxandroidble2.internal.connection;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleCannotSetCharacteristicNotificationException;
import io.reactivex.Completable;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class NotificationAndIndicationManager$$ExternalSyntheticLambda2 implements Function {
    public final /* synthetic */ BluetoothGattCharacteristic f$0;

    public /* synthetic */ NotificationAndIndicationManager$$ExternalSyntheticLambda2(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        this.f$0 = bluetoothGattCharacteristic;
    }

    public final Object apply(Object obj) {
        return Completable.error((Throwable) new BleCannotSetCharacteristicNotificationException(this.f$0, 3, (Throwable) obj));
    }
}
