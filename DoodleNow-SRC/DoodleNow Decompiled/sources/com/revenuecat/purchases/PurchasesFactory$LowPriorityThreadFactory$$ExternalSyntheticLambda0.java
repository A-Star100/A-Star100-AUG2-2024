package com.revenuecat.purchases;

import com.revenuecat.purchases.PurchasesFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class PurchasesFactory$LowPriorityThreadFactory$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ PurchasesFactory$LowPriorityThreadFactory$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    public final void run() {
        PurchasesFactory.LowPriorityThreadFactory.newThread$lambda$1(this.f$0);
    }
}
