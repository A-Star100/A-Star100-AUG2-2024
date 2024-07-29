package com.bleplx.adapter;

import com.polidea.rxandroidble2.RxBleConnection;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda20 implements Function {
    public final /* synthetic */ RxBleConnection f$0;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda20(RxBleConnection rxBleConnection) {
        this.f$0 = rxBleConnection;
    }

    public final Object apply(Object obj) {
        return BleModule.lambda$safeConnectToDevice$23(this.f$0, (Boolean) obj);
    }
}
