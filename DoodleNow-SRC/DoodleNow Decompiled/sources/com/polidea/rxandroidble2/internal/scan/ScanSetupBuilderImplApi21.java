package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.internal.operations.ScanOperationApi21;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;

public class ScanSetupBuilderImplApi21 implements ScanSetupBuilder {
    private final AndroidScanObjectsConverter androidScanObjectsConverter;
    private final InternalScanResultCreator internalScanResultCreator;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final ScanSettingsEmulator scanSettingsEmulator;

    @Inject
    ScanSetupBuilderImplApi21(RxBleAdapterWrapper rxBleAdapterWrapper2, InternalScanResultCreator internalScanResultCreator2, ScanSettingsEmulator scanSettingsEmulator2, AndroidScanObjectsConverter androidScanObjectsConverter2) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper2;
        this.internalScanResultCreator = internalScanResultCreator2;
        this.scanSettingsEmulator = scanSettingsEmulator2;
        this.androidScanObjectsConverter = androidScanObjectsConverter2;
    }

    public ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        return new ScanSetup(new ScanOperationApi21(this.rxBleAdapterWrapper, this.internalScanResultCreator, this.androidScanObjectsConverter, scanSettings, new EmulatedScanFilterMatcher(scanFilterArr), (ScanFilter[]) null), this.scanSettingsEmulator.emulateCallbackType(scanSettings.getCallbackType()));
    }
}
