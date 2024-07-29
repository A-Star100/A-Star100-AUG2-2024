package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.internal.ScanResultInterface;
import com.polidea.rxandroidble2.scan.IsConnectable;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import com.polidea.rxandroidble2.scan.ScanRecord;

public class RxBleInternalScanResult implements ScanResultInterface {
    private final BluetoothDevice bluetoothDevice;
    private final IsConnectable isConnectable;
    private final int rssi;
    private final ScanCallbackType scanCallbackType;
    private final ScanRecord scanRecord;
    private final long timestampNanos;

    public BluetoothDevice getBluetoothDevice() {
        return this.bluetoothDevice;
    }

    public int getRssi() {
        return this.rssi;
    }

    public ScanCallbackType getScanCallbackType() {
        return this.scanCallbackType;
    }

    public ScanRecord getScanRecord() {
        return this.scanRecord;
    }

    public long getTimestampNanos() {
        return this.timestampNanos;
    }

    public IsConnectable isConnectable() {
        return this.isConnectable;
    }

    public RxBleInternalScanResult(BluetoothDevice bluetoothDevice2, int i, long j, ScanRecord scanRecord2, ScanCallbackType scanCallbackType2, IsConnectable isConnectable2) {
        this.bluetoothDevice = bluetoothDevice2;
        this.rssi = i;
        this.timestampNanos = j;
        this.scanRecord = scanRecord2;
        this.scanCallbackType = scanCallbackType2;
        this.isConnectable = isConnectable2;
    }

    public String getAddress() {
        return this.bluetoothDevice.getAddress();
    }

    public String getDeviceName() {
        BluetoothDevice bluetoothDevice2 = getBluetoothDevice();
        if (bluetoothDevice2 == null) {
            return null;
        }
        return bluetoothDevice2.getName();
    }
}
