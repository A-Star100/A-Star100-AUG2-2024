package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import bleshadow.javax.inject.Inject;
import bleshadow.javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

public class AndroidScanObjectsConverter {
    private final int deviceSdk;

    @Inject
    public AndroidScanObjectsConverter(@Named("device-sdk") int i) {
        this.deviceSdk = i;
    }

    public ScanSettings toNativeSettings(com.polidea.rxandroidble2.scan.ScanSettings scanSettings) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        if (this.deviceSdk >= 23) {
            setMarshmallowSettings(scanSettings, builder);
            if (this.deviceSdk >= 26) {
                ScanSettings.Builder unused = builder.setLegacy(scanSettings.getLegacy());
            }
        }
        return builder.setReportDelay(scanSettings.getReportDelayMillis()).setScanMode(scanSettings.getScanMode()).build();
    }

    private static void setMarshmallowSettings(com.polidea.rxandroidble2.scan.ScanSettings scanSettings, ScanSettings.Builder builder) {
        builder.setCallbackType(scanSettings.getCallbackType()).setMatchMode(scanSettings.getMatchMode()).setNumOfMatches(scanSettings.getNumOfMatches());
    }

    public List<ScanFilter> toNativeFilters(com.polidea.rxandroidble2.scan.ScanFilter... scanFilterArr) {
        if (scanFilterArr == null || scanFilterArr.length <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList(scanFilterArr.length);
        for (com.polidea.rxandroidble2.scan.ScanFilter scanFilter : scanFilterArr) {
            arrayList.add(toNative(scanFilter));
        }
        return arrayList;
    }

    private static ScanFilter toNative(com.polidea.rxandroidble2.scan.ScanFilter scanFilter) {
        ScanFilter.Builder builder = new ScanFilter.Builder();
        if (scanFilter.getServiceDataUuid() != null) {
            builder.setServiceData(scanFilter.getServiceDataUuid(), scanFilter.getServiceData(), scanFilter.getServiceDataMask());
        }
        if (scanFilter.getDeviceAddress() != null) {
            builder.setDeviceAddress(scanFilter.getDeviceAddress());
        }
        return builder.setDeviceName(scanFilter.getDeviceName()).setManufacturerData(scanFilter.getManufacturerId(), scanFilter.getManufacturerData(), scanFilter.getManufacturerDataMask()).setServiceUuid(scanFilter.getServiceUuid(), scanFilter.getServiceUuidMask()).build();
    }
}
