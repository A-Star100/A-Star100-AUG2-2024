package com.bleplx.adapter;

import com.bleplx.adapter.utils.RefreshGattCustomOperation;
import com.polidea.rxandroidble2.RxBleConnection;
import io.reactivex.functions.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda29 implements Function {
    public final Object apply(Object obj) {
        return ((RxBleConnection) obj).queue(new RefreshGattCustomOperation()).map(new BleModule$$ExternalSyntheticLambda20((RxBleConnection) obj));
    }
}
