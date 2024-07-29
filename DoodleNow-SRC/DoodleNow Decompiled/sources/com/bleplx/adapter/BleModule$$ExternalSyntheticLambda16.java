package com.bleplx.adapter;

import com.polidea.rxandroidble2.RxBleAdapterStateObservable;
import io.reactivex.functions.Predicate;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda16 implements Predicate {
    public final /* synthetic */ RxBleAdapterStateObservable.BleAdapterState f$0;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda16(RxBleAdapterStateObservable.BleAdapterState bleAdapterState) {
        this.f$0 = bleAdapterState;
    }

    public final boolean test(Object obj) {
        return BleModule.lambda$changeAdapterState$15(this.f$0, (RxBleAdapterStateObservable.BleAdapterState) obj);
    }
}
