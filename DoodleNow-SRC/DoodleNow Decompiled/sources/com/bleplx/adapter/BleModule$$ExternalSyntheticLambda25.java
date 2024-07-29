package com.bleplx.adapter;

import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda25 implements Function {
    public final /* synthetic */ BleModule f$0;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda25(BleModule bleModule) {
        this.f$0 = bleModule;
    }

    public final Object apply(Object obj) {
        return this.f$0.mapRxBleAdapterStateToLocalBluetoothState((RxBleAdapterStateObservable.BleAdapterState) obj);
    }
}
