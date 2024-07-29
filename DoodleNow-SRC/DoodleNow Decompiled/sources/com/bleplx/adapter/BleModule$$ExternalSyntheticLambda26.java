package com.bleplx.adapter;

import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda26 implements Consumer {
    public final /* synthetic */ OnEventCallback f$0;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda26(OnEventCallback onEventCallback) {
        this.f$0 = onEventCallback;
    }

    public final void accept(Object obj) {
        this.f$0.onEvent((String) obj);
    }
}
