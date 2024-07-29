package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryPurchasesByTypeUseCase$$ExternalSyntheticLambda0 implements PurchasesResponseListener {
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ QueryPurchasesByTypeUseCase f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Date f$3;
    public final /* synthetic */ PurchasesResponseListener f$4;

    public /* synthetic */ QueryPurchasesByTypeUseCase$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean, QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase, String str, Date date, PurchasesResponseListener purchasesResponseListener) {
        this.f$0 = atomicBoolean;
        this.f$1 = queryPurchasesByTypeUseCase;
        this.f$2 = str;
        this.f$3 = date;
        this.f$4 = purchasesResponseListener;
    }

    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        QueryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$0(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, billingResult, list);
    }
}
