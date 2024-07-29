package com.polidea.rxandroidble2.internal.scan;

import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.scan.IsConnectable;

public class IsConnectableCheckerApi26 implements IsConnectableChecker {
    public IsConnectable check(ScanResult scanResult) {
        return scanResult.isConnectable() ? IsConnectable.CONNECTABLE : IsConnectable.NOT_CONNECTABLE;
    }
}
