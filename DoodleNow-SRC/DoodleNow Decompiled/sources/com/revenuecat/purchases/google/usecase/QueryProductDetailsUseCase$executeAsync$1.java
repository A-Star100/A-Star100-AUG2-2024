package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.QueryProductDetailsParams;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryProductDetailsUseCase.kt */
final class QueryProductDetailsUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ Set<String> $nonEmptyProductIds;
    final /* synthetic */ QueryProductDetailsUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryProductDetailsUseCase$executeAsync$1(QueryProductDetailsUseCase queryProductDetailsUseCase, Set<String> set) {
        super(1);
        this.this$0 = queryProductDetailsUseCase;
        this.$nonEmptyProductIds = set;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        String googleProductType = ProductTypeConversionsKt.toGoogleProductType(this.this$0.useCaseParams.getProductType());
        if (googleProductType == null) {
            googleProductType = "inapp";
        }
        QueryProductDetailsParams buildQueryProductDetailsParams = BillingClientParamBuildersKt.buildQueryProductDetailsParams(googleProductType, this.$nonEmptyProductIds);
        QueryProductDetailsUseCase queryProductDetailsUseCase = this.this$0;
        queryProductDetailsUseCase.queryProductDetailsAsyncEnsuringOneResponse(billingClient, googleProductType, buildQueryProductDetailsParams, new QueryProductDetailsUseCase$executeAsync$1$$ExternalSyntheticLambda0(queryProductDetailsUseCase));
    }
}
