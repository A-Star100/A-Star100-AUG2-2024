package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Single;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MtuRequestOperation extends SingleResponseOperation<Integer> {
    private final int mtu;

    @Inject
    MtuRequestOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.ON_MTU_CHANGED, timeoutConfiguration);
        this.mtu = i;
    }

    /* access modifiers changed from: protected */
    public Single<Integer> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnMtuChanged().firstOrError();
    }

    /* access modifiers changed from: protected */
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.requestMtu(this.mtu);
    }

    public String toString() {
        return "MtuRequestOperation{" + super.toString() + ", mtu=" + this.mtu + AbstractJsonLexerKt.END_OBJ;
    }
}
