package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import com.polidea.rxandroidble2.RxBleDevice;
import io.reactivex.functions.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda28 implements Action {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ SafeExecutor f$1;
    public final /* synthetic */ RxBleDevice f$2;
    public final /* synthetic */ OnEventCallback f$3;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda28(BleModule bleModule, SafeExecutor safeExecutor, RxBleDevice rxBleDevice, OnEventCallback onEventCallback) {
        this.f$0 = bleModule;
        this.f$1 = safeExecutor;
        this.f$2 = rxBleDevice;
        this.f$3 = onEventCallback;
    }

    public final void run() {
        this.f$0.lambda$safeConnectToDevice$22(this.f$1, this.f$2, this.f$3);
    }
}
