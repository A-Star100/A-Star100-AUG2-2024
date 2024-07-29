package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import com.polidea.rxandroidble2.RxBleDevice;
import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda34 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ SafeExecutor f$1;
    public final /* synthetic */ RxBleDevice f$2;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda34(BleModule bleModule, SafeExecutor safeExecutor, RxBleDevice rxBleDevice) {
        this.f$0 = bleModule;
        this.f$1 = safeExecutor;
        this.f$2 = rxBleDevice;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$safeConnectToDevice$29(this.f$1, this.f$2, (Throwable) obj);
    }
}
