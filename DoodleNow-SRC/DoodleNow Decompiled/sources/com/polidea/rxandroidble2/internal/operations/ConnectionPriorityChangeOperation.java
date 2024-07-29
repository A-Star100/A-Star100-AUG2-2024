package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.exceptions.BleGattCannotStartException;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import io.reactivex.Single;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ConnectionPriorityChangeOperation extends SingleResponseOperation<Long> {
    private final int connectionPriority;
    private final TimeoutConfiguration successTimeoutConfiguration;

    private static String connectionPriorityToString(int i) {
        return i != 0 ? i != 2 ? "CONNECTION_PRIORITY_HIGH" : "CONNECTION_PRIORITY_LOW_POWER" : "CONNECTION_PRIORITY_BALANCED";
    }

    @Inject
    ConnectionPriorityChangeOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, TimeoutConfiguration timeoutConfiguration, int i, TimeoutConfiguration timeoutConfiguration2) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.CONNECTION_PRIORITY_CHANGE, timeoutConfiguration);
        this.connectionPriority = i;
        this.successTimeoutConfiguration = timeoutConfiguration2;
    }

    /* access modifiers changed from: protected */
    public Single<Long> getCallback(RxBleGattCallback rxBleGattCallback) {
        return Single.timer(this.successTimeoutConfiguration.timeout, this.successTimeoutConfiguration.timeoutTimeUnit, this.successTimeoutConfiguration.timeoutScheduler);
    }

    /* access modifiers changed from: protected */
    public boolean startOperation(BluetoothGatt bluetoothGatt) throws IllegalArgumentException, BleGattCannotStartException {
        return bluetoothGatt.requestConnectionPriority(this.connectionPriority);
    }

    public String toString() {
        return "ConnectionPriorityChangeOperation{" + super.toString() + ", connectionPriority=" + connectionPriorityToString(this.connectionPriority) + ", successTimeout=" + this.successTimeoutConfiguration + AbstractJsonLexerKt.END_OBJ;
    }
}
