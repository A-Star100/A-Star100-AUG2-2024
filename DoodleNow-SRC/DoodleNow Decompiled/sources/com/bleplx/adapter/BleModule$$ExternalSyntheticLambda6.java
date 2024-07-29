package com.bleplx.adapter;

import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda6 implements Consumer {
    public final /* synthetic */ Characteristic f$0;
    public final /* synthetic */ OnEventCallback f$1;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda6(Characteristic characteristic, OnEventCallback onEventCallback) {
        this.f$0 = characteristic;
        this.f$1 = onEventCallback;
    }

    public final void accept(Object obj) {
        BleModule.lambda$safeMonitorCharacteristicForDevice$43(this.f$0, this.f$1, (byte[]) obj);
    }
}
