package com.bleplx.adapter;

import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda41 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ OnErrorCallback f$1;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda41(BleModule bleModule, OnErrorCallback onErrorCallback) {
        this.f$0 = bleModule;
        this.f$1 = onErrorCallback;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$safeStartDeviceScan$20(this.f$1, (Throwable) obj);
    }
}
