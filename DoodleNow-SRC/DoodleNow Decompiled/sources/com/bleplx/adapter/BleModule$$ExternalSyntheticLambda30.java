package com.bleplx.adapter;

import com.polidea.rxandroidble2.RxBleConnection;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeUnit;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda30 implements Function {
    public final /* synthetic */ int f$0;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda30(int i) {
        this.f$0 = i;
    }

    public final Object apply(Object obj) {
        return ((RxBleConnection) obj).requestConnectionPriority(this.f$0, 1, TimeUnit.MILLISECONDS).andThen(Observable.just((RxBleConnection) obj));
    }
}
