package com.bleplx.adapter;

import com.polidea.rxandroidble2.RxBleConnection;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ Characteristic f$0;
    public final /* synthetic */ RxBleConnection f$1;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda2(Characteristic characteristic, RxBleConnection rxBleConnection) {
        this.f$0 = characteristic;
        this.f$1 = rxBleConnection;
    }

    public final Object call() {
        return BleModule.lambda$safeMonitorCharacteristicForDevice$39(this.f$0, this.f$1);
    }
}
