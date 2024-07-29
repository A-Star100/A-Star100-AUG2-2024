package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.internal.scan.RxBleInternalScanResultLegacy;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RxBleClientImpl$$ExternalSyntheticLambda5 implements Function {
    public final /* synthetic */ RxBleClientImpl f$0;

    public /* synthetic */ RxBleClientImpl$$ExternalSyntheticLambda5(RxBleClientImpl rxBleClientImpl) {
        this.f$0 = rxBleClientImpl;
    }

    public final Object apply(Object obj) {
        return this.f$0.convertToPublicScanResult((RxBleInternalScanResultLegacy) obj);
    }
}
