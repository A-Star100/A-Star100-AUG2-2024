package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda23 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ Device f$1;
    public final /* synthetic */ SafeExecutor f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda23(BleModule bleModule, Device device, SafeExecutor safeExecutor, String str) {
        this.f$0 = bleModule;
        this.f$1 = device;
        this.f$2 = safeExecutor;
        this.f$3 = str;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$readRSSIForDevice$4(this.f$1, this.f$2, this.f$3, (Integer) obj);
    }
}
