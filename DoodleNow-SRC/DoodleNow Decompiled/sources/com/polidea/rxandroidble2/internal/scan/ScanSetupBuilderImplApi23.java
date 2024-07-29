package com.polidea.rxandroidble2.internal.scan;

import bleshadow.javax.inject.Inject;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.operations.ScanOperationApi21;
import com.polidea.rxandroidble2.internal.util.ObservableUtil;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.ObservableTransformer;

public class ScanSetupBuilderImplApi23 implements ScanSetupBuilder {
    private final AndroidScanObjectsConverter androidScanObjectsConverter;
    private final InternalScanResultCreator internalScanResultCreator;
    private final RxBleAdapterWrapper rxBleAdapterWrapper;
    private final ScanSettingsEmulator scanSettingsEmulator;

    @Inject
    ScanSetupBuilderImplApi23(RxBleAdapterWrapper rxBleAdapterWrapper2, InternalScanResultCreator internalScanResultCreator2, ScanSettingsEmulator scanSettingsEmulator2, AndroidScanObjectsConverter androidScanObjectsConverter2) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper2;
        this.internalScanResultCreator = internalScanResultCreator2;
        this.scanSettingsEmulator = scanSettingsEmulator2;
        this.androidScanObjectsConverter = androidScanObjectsConverter2;
    }

    public ScanSetup build(ScanSettings scanSettings, ScanFilter... scanFilterArr) {
        boolean areFiltersSpecified = areFiltersSpecified(scanFilterArr);
        boolean z = scanSettings.getCallbackType() != 1;
        ObservableTransformer<RxBleInternalScanResult, RxBleInternalScanResult> identityTransformer = ObservableUtil.identityTransformer();
        if (z && !areFiltersSpecified) {
            RxBleLog.d("ScanSettings.callbackType != CALLBACK_TYPE_ALL_MATCHES but no (or only empty) filters are specified. Falling back to callbackType emulation.", new Object[0]);
            identityTransformer = this.scanSettingsEmulator.emulateCallbackType(scanSettings.getCallbackType());
            scanSettings = scanSettings.copyWithCallbackType(1);
        }
        return new ScanSetup(new ScanOperationApi21(this.rxBleAdapterWrapper, this.internalScanResultCreator, this.androidScanObjectsConverter, scanSettings, new EmulatedScanFilterMatcher(new ScanFilterInterface[0]), scanFilterArr), identityTransformer);
    }

    private static boolean areFiltersSpecified(ScanFilter[] scanFilterArr) {
        boolean z = true;
        for (ScanFilter isAllFieldsEmpty : scanFilterArr) {
            z &= isAllFieldsEmpty.isAllFieldsEmpty();
        }
        return !z;
    }
}
