package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Single;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ReadRssiOperation extends SingleResponseOperation<Integer> {
    @Inject
    ReadRssiOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, @Named("operation-timeout") TimeoutConfiguration timeoutConfiguration) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.READ_RSSI, timeoutConfiguration);
    }

    /* access modifiers changed from: protected */
    public Single<Integer> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnRssiRead().firstOrError();
    }

    /* access modifiers changed from: protected */
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        return bluetoothGatt.readRemoteRssi();
    }

    public String toString() {
        return "ReadRssiOperation{" + super.toString() + AbstractJsonLexerKt.END_OBJ;
    }
}
