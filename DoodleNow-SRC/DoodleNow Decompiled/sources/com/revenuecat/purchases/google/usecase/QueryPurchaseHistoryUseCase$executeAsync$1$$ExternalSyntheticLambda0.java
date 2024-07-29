package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryPurchaseHistoryUseCase$executeAsync$1$$ExternalSyntheticLambda0 implements PurchaseHistoryResponseListener {
    public final /* synthetic */ AtomicBoolean f$0;
    public final /* synthetic */ QueryPurchaseHistoryUseCase f$1;
    public final /* synthetic */ Date f$2;

    public /* synthetic */ QueryPurchaseHistoryUseCase$executeAsync$1$$ExternalSyntheticLambda0(AtomicBoolean atomicBoolean, QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase, Date date) {
        this.f$0 = atomicBoolean;
        this.f$1 = queryPurchaseHistoryUseCase;
        this.f$2 = date;
    }

    public final void onPurchaseHistoryResponse(BillingResult billingResult, List list) {
        QueryPurchaseHistoryUseCase$executeAsync$1.invoke$lambda$1$lambda$0(this.f$0, this.f$1, this.f$2, billingResult, list);
    }
}
