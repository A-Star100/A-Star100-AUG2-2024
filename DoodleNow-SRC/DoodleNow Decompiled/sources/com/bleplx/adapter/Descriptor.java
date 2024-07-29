package com.bleplx.adapter;

import android.bluetooth.BluetoothGattDescriptor;
import com.bleplx.adapter.utils.ByteUtils;
import com.bleplx.adapter.utils.IdGenerator;
import com.bleplx.adapter.utils.IdGeneratorKey;
import com.polidea.rxandroidble2.internal.RxBleLog;
import java.util.UUID;

public class Descriptor {
    private final int characteristicId;
    private final UUID characteristicUuid;
    private final BluetoothGattDescriptor descriptor;
    private final String deviceId;
    private final int id;
    private final int serviceId;
    private final UUID serviceUuid;
    private final UUID uuid;
    private byte[] value = null;

    public int getCharacteristicId() {
        return this.characteristicId;
    }

    public UUID getCharacteristicUuid() {
        return this.characteristicUuid;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public int getId() {
        return this.id;
    }

    public BluetoothGattDescriptor getNativeDescriptor() {
        return this.descriptor;
    }

    public int getServiceId() {
        return this.serviceId;
    }

    public UUID getServiceUuid() {
        return this.serviceUuid;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public byte[] getValue() {
        return this.value;
    }

    public void setValue(byte[] bArr) {
        this.value = bArr;
    }

    public Descriptor(Characteristic characteristic, BluetoothGattDescriptor bluetoothGattDescriptor) {
        int id2 = characteristic.getId();
        this.characteristicId = id2;
        this.characteristicUuid = characteristic.getUuid();
        this.serviceId = characteristic.getServiceID();
        this.serviceUuid = characteristic.getServiceUUID();
        this.descriptor = bluetoothGattDescriptor;
        String deviceId2 = characteristic.getDeviceId();
        this.deviceId = deviceId2;
        this.id = IdGenerator.getIdForKey(new IdGeneratorKey(deviceId2, bluetoothGattDescriptor.getUuid(), id2));
        this.uuid = bluetoothGattDescriptor.getUuid();
    }

    public Descriptor(int i, int i2, UUID uuid2, UUID uuid3, String str, BluetoothGattDescriptor bluetoothGattDescriptor, int i3, UUID uuid4) {
        this.characteristicId = i;
        this.serviceId = i2;
        this.characteristicUuid = uuid2;
        this.serviceUuid = uuid3;
        this.deviceId = str;
        this.descriptor = bluetoothGattDescriptor;
        this.id = i3;
        this.uuid = uuid4;
    }

    public Descriptor(Descriptor descriptor2) {
        this.characteristicUuid = descriptor2.characteristicUuid;
        this.characteristicId = descriptor2.characteristicId;
        this.serviceUuid = descriptor2.serviceUuid;
        this.serviceId = descriptor2.serviceId;
        this.deviceId = descriptor2.deviceId;
        this.descriptor = descriptor2.descriptor;
        this.id = descriptor2.id;
        this.uuid = descriptor2.uuid;
        byte[] bArr = descriptor2.value;
        if (bArr != null) {
            this.value = (byte[]) bArr.clone();
        }
    }

    public void setValueFromCache() {
        this.value = this.descriptor.getValue();
    }

    public void logValue(String str, byte[] bArr) {
        if (bArr == null) {
            bArr = this.descriptor.getValue();
        }
        String bytesToHex = bArr != null ? ByteUtils.bytesToHex(bArr) : "(null)";
        RxBleLog.v(str + " Descriptor(uuid: " + this.descriptor.getUuid().toString() + ", id: " + this.id + ", value: " + bytesToHex + ")", new Object[0]);
    }
}
