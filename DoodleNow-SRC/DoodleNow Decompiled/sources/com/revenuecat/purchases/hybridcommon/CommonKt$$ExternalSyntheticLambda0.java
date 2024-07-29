package com.revenuecat.purchases.hybridcommon;

import com.revenuecat.purchases.interfaces.Callback;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonKt$$ExternalSyntheticLambda0 implements Callback {
    public final /* synthetic */ OnResultAny f$0;

    public /* synthetic */ CommonKt$$ExternalSyntheticLambda0(OnResultAny onResultAny) {
        this.f$0 = onResultAny;
    }

    public final void onReceived(Object obj) {
        CommonKt.canMakePayments$lambda$2(this.f$0, (Boolean) obj);
    }
}
