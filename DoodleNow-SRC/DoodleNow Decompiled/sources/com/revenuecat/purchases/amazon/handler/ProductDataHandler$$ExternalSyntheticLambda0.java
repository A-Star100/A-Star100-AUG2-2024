package com.revenuecat.purchases.amazon.handler;

import com.amazon.device.iap.model.RequestId;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProductDataHandler$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ProductDataHandler f$0;
    public final /* synthetic */ RequestId f$1;

    public /* synthetic */ ProductDataHandler$$ExternalSyntheticLambda0(ProductDataHandler productDataHandler, RequestId requestId) {
        this.f$0 = productDataHandler;
        this.f$1 = requestId;
    }

    public final void run() {
        ProductDataHandler.addTimeoutToProductDataRequest$lambda$6(this.f$0, this.f$1);
    }
}
