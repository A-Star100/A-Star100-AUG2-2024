package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetailsResponseListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryProductDetailsUseCase$$ExternalSyntheticLambda0 implements ProductDetailsResponseListener {
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ QueryProductDetailsUseCase f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Date f$3;
    public final /* synthetic */ ProductDetailsResponseListener f$4;

    public /* synthetic */ QueryProductDetailsUseCase$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean, QueryProductDetailsUseCase queryProductDetailsUseCase, String str, Date date, ProductDetailsResponseListener productDetailsResponseListener) {
        this.f$0 = atomicBoolean;
        this.f$1 = queryProductDetailsUseCase;
        this.f$2 = str;
        this.f$3 = date;
        this.f$4 = productDetailsResponseListener;
    }

    public final void onProductDetailsResponse(BillingResult billingResult, List list) {
        QueryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse$lambda$3(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, billingResult, list);
    }
}
