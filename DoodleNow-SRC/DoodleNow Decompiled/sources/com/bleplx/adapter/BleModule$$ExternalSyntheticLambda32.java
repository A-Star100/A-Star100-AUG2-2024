package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import com.polidea.rxandroidble2.RxBleConnection;
import com.polidea.rxandroidble2.RxBleDevice;
import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda32 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ RxBleDevice f$1;
    public final /* synthetic */ OnEventCallback f$2;
    public final /* synthetic */ SafeExecutor f$3;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda32(BleModule bleModule, RxBleDevice rxBleDevice, OnEventCallback onEventCallback, SafeExecutor safeExecutor) {
        this.f$0 = bleModule;
        this.f$1 = rxBleDevice;
        this.f$2 = onEventCallback;
        this.f$3 = safeExecutor;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$safeConnectToDevice$28(this.f$1, this.f$2, this.f$3, (RxBleConnection) obj);
    }
}
