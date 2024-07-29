package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.scan.ScanFilter;
import com.polidea.rxandroidble2.scan.ScanSettings;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RxBleClientImpl$$ExternalSyntheticLambda7 implements Callable {
    public final /* synthetic */ RxBleClientImpl f$0;
    public final /* synthetic */ ScanSettings f$1;
    public final /* synthetic */ ScanFilter[] f$2;

    public /* synthetic */ RxBleClientImpl$$ExternalSyntheticLambda7(RxBleClientImpl rxBleClientImpl, ScanSettings scanSettings, ScanFilter[] scanFilterArr) {
        this.f$0 = rxBleClientImpl;
        this.f$1 = scanSettings;
        this.f$2 = scanFilterArr;
    }

    public final Object call() {
        return this.f$0.m1049lambda$scanBleDevices$1$compolidearxandroidble2RxBleClientImpl(this.f$1, this.f$2);
    }
}
