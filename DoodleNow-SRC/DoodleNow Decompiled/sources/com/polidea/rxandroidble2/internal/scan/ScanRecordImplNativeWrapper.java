package com.polidea.rxandroidble2.internal.scan;

import android.os.Build;
import android.os.ParcelUuid;
import android.util.SparseArray;
import com.polidea.rxandroidble2.internal.util.ScanRecordParser;
import com.polidea.rxandroidble2.scan.ScanRecord;
import java.util.List;
import java.util.Map;

public class ScanRecordImplNativeWrapper implements ScanRecord {
    private final android.bluetooth.le.ScanRecord nativeScanRecord;
    private final ScanRecordParser scanRecordParser;

    public ScanRecordImplNativeWrapper(android.bluetooth.le.ScanRecord scanRecord, ScanRecordParser scanRecordParser2) {
        this.nativeScanRecord = scanRecord;
        this.scanRecordParser = scanRecordParser2;
    }

    public int getAdvertiseFlags() {
        return this.nativeScanRecord.getAdvertiseFlags();
    }

    public List<ParcelUuid> getServiceUuids() {
        return this.nativeScanRecord.getServiceUuids();
    }

    public List<ParcelUuid> getServiceSolicitationUuids() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.nativeScanRecord.getServiceSolicitationUuids();
        }
        return this.scanRecordParser.parseFromBytes(this.nativeScanRecord.getBytes()).getServiceSolicitationUuids();
    }

    public SparseArray<byte[]> getManufacturerSpecificData() {
        return this.nativeScanRecord.getManufacturerSpecificData();
    }

    public byte[] getManufacturerSpecificData(int i) {
        return this.nativeScanRecord.getManufacturerSpecificData(i);
    }

    public Map<ParcelUuid, byte[]> getServiceData() {
        return this.nativeScanRecord.getServiceData();
    }

    public byte[] getServiceData(ParcelUuid parcelUuid) {
        return this.nativeScanRecord.getServiceData(parcelUuid);
    }

    public int getTxPowerLevel() {
        return this.nativeScanRecord.getTxPowerLevel();
    }

    public String getDeviceName() {
        return this.nativeScanRecord.getDeviceName();
    }

    public byte[] getBytes() {
        return this.nativeScanRecord.getBytes();
    }
}
