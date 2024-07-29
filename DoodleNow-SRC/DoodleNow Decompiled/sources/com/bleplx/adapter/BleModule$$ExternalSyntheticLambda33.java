package com.bleplx.adapter;

import com.polidea.rxandroidble2.scan.ScanResult;
import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda33 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ OnEventCallback f$1;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda33(BleModule bleModule, OnEventCallback onEventCallback) {
        this.f$0 = bleModule;
        this.f$1 = onEventCallback;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$safeStartDeviceScan$19(this.f$1, (ScanResult) obj);
    }
}
