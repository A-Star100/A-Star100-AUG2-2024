package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda39 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ Characteristic f$1;
    public final /* synthetic */ SafeExecutor f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda39(BleModule bleModule, Characteristic characteristic, SafeExecutor safeExecutor, String str) {
        this.f$0 = bleModule;
        this.f$1 = characteristic;
        this.f$2 = safeExecutor;
        this.f$3 = str;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$safeReadCharacteristicForDevice$34(this.f$1, this.f$2, this.f$3, (byte[]) obj);
    }
}
