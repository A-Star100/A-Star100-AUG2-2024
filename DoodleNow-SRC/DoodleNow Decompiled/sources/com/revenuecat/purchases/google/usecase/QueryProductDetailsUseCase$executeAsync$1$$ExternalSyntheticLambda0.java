package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.ProductDetailsResponseListener;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class QueryProductDetailsUseCase$executeAsync$1$$ExternalSyntheticLambda0 implements ProductDetailsResponseListener {
    public final /* synthetic */ QueryProductDetailsUseCase f$0;

    public /* synthetic */ QueryProductDetailsUseCase$executeAsync$1$$ExternalSyntheticLambda0(QueryProductDetailsUseCase queryProductDetailsUseCase) {
        this.f$0 = queryProductDetailsUseCase;
    }

    public final void onProductDetailsResponse(BillingResult billingResult, List list) {
        BillingClientUseCase.processResult$default(this.f$0, billingResult, list, (Function1) null, (Function1) null, 12, (Object) null);
    }
}
