package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import bleshadow.javax.inject.Named;
import com.polidea.rxandroidble2.exceptions.BleGattOperationType;
import com.polidea.rxandroidble2.internal.SingleResponseOperation;
import com.polidea.rxandroidble2.internal.connection.RxBleGattCallback;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.util.ByteAssociationUtil;
import io.reactivex.Single;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class DescriptorWriteOperation extends SingleResponseOperation<byte[]> {
    private final int bluetoothGattCharacteristicDefaultWriteType;
    private final BluetoothGattDescriptor bluetoothGattDescriptor;
    private final byte[] data;

    DescriptorWriteOperation(RxBleGattCallback rxBleGattCallback, BluetoothGatt bluetoothGatt, @Named("operation-timeout") TimeoutConfiguration timeoutConfiguration, int i, BluetoothGattDescriptor bluetoothGattDescriptor2, byte[] bArr) {
        super(bluetoothGatt, rxBleGattCallback, BleGattOperationType.DESCRIPTOR_WRITE, timeoutConfiguration);
        this.bluetoothGattCharacteristicDefaultWriteType = i;
        this.bluetoothGattDescriptor = bluetoothGattDescriptor2;
        this.data = bArr;
    }

    /* access modifiers changed from: protected */
    public Single<byte[]> getCallback(RxBleGattCallback rxBleGattCallback) {
        return rxBleGattCallback.getOnDescriptorWrite().filter(ByteAssociationUtil.descriptorPredicate(this.bluetoothGattDescriptor)).firstOrError().map(ByteAssociationUtil.getBytesFromAssociation());
    }

    /* access modifiers changed from: protected */
    public boolean startOperation(BluetoothGatt bluetoothGatt) {
        this.bluetoothGattDescriptor.setValue(this.data);
        BluetoothGattCharacteristic characteristic = this.bluetoothGattDescriptor.getCharacteristic();
        int writeType = characteristic.getWriteType();
        characteristic.setWriteType(this.bluetoothGattCharacteristicDefaultWriteType);
        boolean writeDescriptor = bluetoothGatt.writeDescriptor(this.bluetoothGattDescriptor);
        characteristic.setWriteType(writeType);
        return writeDescriptor;
    }

    public String toString() {
        return "DescriptorWriteOperation{" + super.toString() + ", descriptor=" + new LoggerUtil.AttributeLogWrapper(this.bluetoothGattDescriptor.getUuid(), this.data, true) + AbstractJsonLexerKt.END_OBJ;
    }
}
