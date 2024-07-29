package com.bleplx.adapter;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ScanResult {
    private AdvertisementData advertisementData;
    private String deviceId;
    private String deviceName;
    private boolean isConnectable;
    private int mtu;
    private UUID[] overflowServiceUUIDs;
    private int rssi;

    public AdvertisementData getAdvertisementData() {
        return this.advertisementData;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getMtu() {
        return this.mtu;
    }

    public UUID[] getOverflowServiceUUIDs() {
        return this.overflowServiceUUIDs;
    }

    public int getRssi() {
        return this.rssi;
    }

    public boolean isConnectable() {
        return this.isConnectable;
    }

    public void setAdvertisementData(AdvertisementData advertisementData2) {
        this.advertisementData = advertisementData2;
    }

    public void setConnectable(boolean z) {
        this.isConnectable = z;
    }

    public void setDeviceId(String str) {
        this.deviceId = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setMtu(int i) {
        this.mtu = i;
    }

    public void setOverflowServiceUUIDs(UUID[] uuidArr) {
        this.overflowServiceUUIDs = uuidArr;
    }

    public void setRssi(int i) {
        this.rssi = i;
    }

    public ScanResult(String str, String str2, int i, int i2, boolean z, UUID[] uuidArr, AdvertisementData advertisementData2) {
        this.deviceId = str;
        this.deviceName = str2;
        this.rssi = i;
        this.mtu = i2;
        this.isConnectable = z;
        this.overflowServiceUUIDs = uuidArr;
        this.advertisementData = advertisementData2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ScanResult scanResult = (ScanResult) obj;
        if (this.rssi == scanResult.rssi && this.mtu == scanResult.mtu && this.isConnectable == scanResult.isConnectable && this.deviceId.equals(scanResult.deviceId) && Objects.equals(this.deviceName, scanResult.deviceName) && Arrays.equals(this.overflowServiceUUIDs, scanResult.overflowServiceUUIDs)) {
            return Objects.equals(this.advertisementData, scanResult.advertisementData);
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.deviceId.hashCode() * 31;
        String str = this.deviceName;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (str != null ? str.hashCode() : 0)) * 31) + this.rssi) * 31) + this.mtu) * 31) + (this.isConnectable ? 1 : 0)) * 31) + Arrays.hashCode(this.overflowServiceUUIDs)) * 31;
        AdvertisementData advertisementData2 = this.advertisementData;
        if (advertisementData2 != null) {
            i = advertisementData2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "ScanResult{deviceId='" + this.deviceId + "', deviceName='" + this.deviceName + "', rssi=" + this.rssi + ", mtu=" + this.mtu + ", isConnectable=" + this.isConnectable + ", overflowServiceUUIDs=" + Arrays.toString(this.overflowServiceUUIDs) + ", advertisementData=" + this.advertisementData + AbstractJsonLexerKt.END_OBJ;
    }
}
