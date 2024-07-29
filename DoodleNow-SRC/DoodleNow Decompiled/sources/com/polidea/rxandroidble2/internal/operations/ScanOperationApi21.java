package com.polidea.rxandroidble2.internal.operations;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.logger.LoggerUtil;
import com.polidea.rxandroidble2.internal.scan.AndroidScanObjectsConverter;
import com.polidea.rxandroidble2.internal.scan.EmulatedScanFilterMatcher;
import com.polidea.rxandroidble2.internal.scan.InternalScanResultCreator;
import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResult;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import io.reactivex.ObservableEmitter;
import java.util.Arrays;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class ScanOperationApi21 extends ScanOperation<RxBleInternalScanResult, ScanCallback> {
    private final AndroidScanObjectsConverter androidScanObjectsConverter;
    final EmulatedScanFilterMatcher emulatedScanFilterMatcher;
    final InternalScanResultCreator internalScanResultCreator;
    /* access modifiers changed from: private */
    public ObservableEmitter<RxBleInternalScanResult> scanEmitter = null;
    private final ScanFilter[] scanFilters;
    private final ScanSettings scanSettings;

    public ScanOperationApi21(RxBleAdapterWrapper rxBleAdapterWrapper, InternalScanResultCreator internalScanResultCreator2, AndroidScanObjectsConverter androidScanObjectsConverter2, ScanSettings scanSettings2, EmulatedScanFilterMatcher emulatedScanFilterMatcher2, ScanFilter[] scanFilterArr) {
        super(rxBleAdapterWrapper);
        this.internalScanResultCreator = internalScanResultCreator2;
        this.scanSettings = scanSettings2;
        this.emulatedScanFilterMatcher = emulatedScanFilterMatcher2;
        this.scanFilters = scanFilterArr;
        this.androidScanObjectsConverter = androidScanObjectsConverter2;
    }

    /* access modifiers changed from: package-private */
    public ScanCallback createScanCallback(ObservableEmitter<RxBleInternalScanResult> observableEmitter) {
        this.scanEmitter = observableEmitter;
        return new ScanCallback() {
            public void onScanResult(int i, ScanResult scanResult) {
                ObservableEmitter access$000;
                if (!ScanOperationApi21.this.emulatedScanFilterMatcher.isEmpty() && RxBleLog.isAtLeast(3) && RxBleLog.getShouldLogScannedPeripherals()) {
                    ScanRecord scanRecord = scanResult.getScanRecord();
                    Object[] objArr = new Object[4];
                    objArr[0] = LoggerUtil.commonMacMessage(scanResult.getDevice().getAddress());
                    objArr[1] = scanResult.getDevice().getName();
                    objArr[2] = Integer.valueOf(scanResult.getRssi());
                    objArr[3] = LoggerUtil.bytesToHex(scanRecord != null ? scanRecord.getBytes() : null);
                    RxBleLog.d("%s, name=%s, rssi=%d, data=%s", objArr);
                }
                RxBleInternalScanResult create = ScanOperationApi21.this.internalScanResultCreator.create(i, scanResult);
                if (ScanOperationApi21.this.emulatedScanFilterMatcher.matches(create) && (access$000 = ScanOperationApi21.this.scanEmitter) != null) {
                    access$000.onNext(create);
                }
            }

            public void onBatchScanResults(List<ScanResult> list) {
                ObservableEmitter access$000;
                for (ScanResult create : list) {
                    RxBleInternalScanResult create2 = ScanOperationApi21.this.internalScanResultCreator.create(create);
                    if (ScanOperationApi21.this.emulatedScanFilterMatcher.matches(create2) && (access$000 = ScanOperationApi21.this.scanEmitter) != null) {
                        access$000.onNext(create2);
                    }
                }
            }

            public void onScanFailed(int i) {
                ObservableEmitter access$000 = ScanOperationApi21.this.scanEmitter;
                if (access$000 != null) {
                    access$000.tryOnError(new BleScanException(ScanOperationApi21.errorCodeToBleErrorCode(i)));
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    public boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        if (this.emulatedScanFilterMatcher.isEmpty()) {
            RxBleLog.d("No library side filtering —> debug logs of scanned devices disabled", new Object[0]);
        }
        rxBleAdapterWrapper.startLeScan(this.androidScanObjectsConverter.toNativeFilters(this.scanFilters), this.androidScanObjectsConverter.toNativeSettings(this.scanSettings), scanCallback);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, ScanCallback scanCallback) {
        rxBleAdapterWrapper.stopLeScan(scanCallback);
        ObservableEmitter<RxBleInternalScanResult> observableEmitter = this.scanEmitter;
        if (observableEmitter != null) {
            observableEmitter.onComplete();
            this.scanEmitter = null;
        }
    }

    static int errorCodeToBleErrorCode(int i) {
        if (i == 1) {
            return 5;
        }
        if (i == 2) {
            return 6;
        }
        if (i == 3) {
            return 7;
        }
        if (i == 4) {
            return 8;
        }
        if (i == 5) {
            return 9;
        }
        RxBleLog.w("Encountered unknown scanning error code: %d -> check android.bluetooth.le.ScanCallback", new Object[0]);
        return Integer.MAX_VALUE;
    }

    public String toString() {
        String str;
        ScanFilter[] scanFilterArr = this.scanFilters;
        boolean z = scanFilterArr == null || scanFilterArr.length == 0;
        boolean isEmpty = this.emulatedScanFilterMatcher.isEmpty();
        StringBuilder sb = new StringBuilder("ScanOperationApi21{");
        String str2 = "";
        if (z) {
            str = str2;
        } else {
            str = "ANY_MUST_MATCH -> nativeFilters=" + Arrays.toString(this.scanFilters);
        }
        sb.append(str);
        sb.append((z || isEmpty) ? str2 : " and then ");
        if (!isEmpty) {
            str2 = "ANY_MUST_MATCH -> " + this.emulatedScanFilterMatcher;
        }
        sb.append(str2);
        sb.append(AbstractJsonLexerKt.END_OBJ);
        return sb.toString();
    }
}
