package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchasesResponseListener;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryPurchasesByTypeUseCase$executeAsync$1$$ExternalSyntheticLambda0 implements PurchasesResponseListener {
    public final /* synthetic */ QueryPurchasesByTypeUseCase f$0;

    public /* synthetic */ QueryPurchasesByTypeUseCase$executeAsync$1$$ExternalSyntheticLambda0(QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase) {
        this.f$0 = queryPurchasesByTypeUseCase;
    }

    public final void onQueryPurchasesResponse(BillingResult billingResult, List list) {
        QueryPurchasesByTypeUseCase$executeAsync$1.invoke$lambda$1$lambda$0(this.f$0, billingResult, list);
    }
}
