package com.polidea.rxandroidble2.scan;

import com.polidea.rxandroidble2.RxBleDevice;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ScanResult {
    private final RxBleDevice bleDevice;
    private final ScanCallbackType callbackType;
    private final IsConnectable isConnectable;
    private final int rssi;
    private final ScanRecord scanRecord;
    private final long timestampNanos;

    public RxBleDevice getBleDevice() {
        return this.bleDevice;
    }

    public ScanCallbackType getCallbackType() {
        return this.callbackType;
    }

    public int getRssi() {
        return this.rssi;
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

    public ScanResult(RxBleDevice rxBleDevice, int i, long j, ScanCallbackType scanCallbackType, ScanRecord scanRecord2, IsConnectable isConnectable2) {
        this.bleDevice = rxBleDevice;
        this.rssi = i;
        this.timestampNanos = j;
        this.callbackType = scanCallbackType;
        this.scanRecord = scanRecord2;
        this.isConnectable = isConnectable2;
    }

    public String toString() {
        return "ScanResult{bleDevice=" + this.bleDevice + ", rssi=" + this.rssi + ", timestampNanos=" + this.timestampNanos + ", callbackType=" + this.callbackType + ", scanRecord=" + LoggerUtil.bytesToHex(this.scanRecord.getBytes()) + ", isConnectable=" + this.isConnectable + AbstractJsonLexerKt.END_OBJ;
    }
}
