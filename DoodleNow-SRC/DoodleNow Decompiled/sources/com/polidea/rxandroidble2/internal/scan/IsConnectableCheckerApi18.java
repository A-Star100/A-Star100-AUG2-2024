package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.scan.IsConnectable;

public class IsConnectableCheckerApi18 implements IsConnectableChecker {
    public IsConnectable check(ScanResult scanResult) {
        return IsConnectable.LEGACY_UNKNOWN;
    }
}
