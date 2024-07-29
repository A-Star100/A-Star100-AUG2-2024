package com.bleplx.adapter;

import com.bleplx.adapter.utils.SafeExecutor;
import io.reactivex.functions.Action;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class BleModule$$ExternalSyntheticLambda11 implements Action {
    public final /* synthetic */ BleModule f$0;
    public final /* synthetic */ Descriptor f$1;
    public final /* synthetic */ byte[] f$2;
    public final /* synthetic */ SafeExecutor f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ BleModule$$ExternalSyntheticLambda11(BleModule bleModule, Descriptor descriptor, byte[] bArr, SafeExecutor safeExecutor, String str) {
        this.f$0 = bleModule;
        this.f$1 = descriptor;
        this.f$2 = bArr;
        this.f$3 = safeExecutor;
        this.f$4 = str;
    }

    public final void run() {
        this.f$0.lambda$safeWriteDescriptorForDevice$13(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
