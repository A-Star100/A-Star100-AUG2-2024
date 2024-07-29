package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import io.reactivex.functions.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda10 implements Consumer {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ Descriptor f$1;
    public final /* synthetic */ SafeExecutor f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda10(BleModule bleModule, Descriptor descriptor, SafeExecutor safeExecutor, String str) {
        this.f$0 = bleModule;
        this.f$1 = descriptor;
        this.f$2 = safeExecutor;
        this.f$3 = str;
    }

    public final void accept(Object obj) {
        this.f$0.lambda$safeReadDescriptorForDevice$10(this.f$1, this.f$2, this.f$3, (byte[]) obj);
    }
}
