package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryPurchasesByTypeUseCase.kt */
final class QueryPurchasesByTypeUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ QueryPurchasesByTypeUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryPurchasesByTypeUseCase$executeAsync$1(QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase) {
        super(1);
        this.this$0 = queryPurchasesByTypeUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Unit unit;
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        QueryPurchasesParams buildQueryPurchasesParams = BillingClientParamBuildersKt.buildQueryPurchasesParams(this.this$0.useCaseParams.getProductType());
        if (buildQueryPurchasesParams != null) {
            QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase = this.this$0;
            queryPurchasesByTypeUseCase.queryPurchasesAsyncWithTrackingEnsuringOneResponse(billingClient, queryPurchasesByTypeUseCase.useCaseParams.getProductType(), buildQueryPurchasesParams, new QueryPurchasesByTypeUseCase$executeAsync$1$$ExternalSyntheticLambda0(queryPurchasesByTypeUseCase));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase2 = this.this$0;
            String format = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchasesByType"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
            BillingResult build = BillingResult.newBuilder().setResponseCode(5).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …                 .build()");
            BillingClientUseCase.processResult$default(queryPurchasesByTypeUseCase2, build, MapsKt.emptyMap(), (Function1) null, (Function1) null, 12, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(queryPurchasesByTypeUseCase, "this$0");
        Intrinsics.checkNotNullParameter(billingResult, "result");
        Intrinsics.checkNotNullParameter(list, "purchases");
        BillingClientUseCase.processResult$default(queryPurchasesByTypeUseCase, billingResult, queryPurchasesByTypeUseCase.toMapOfGooglePurchaseWrapper(list, queryPurchasesByTypeUseCase.useCaseParams.getProductType()), (Function1) null, (Function1) null, 12, (Object) null);
    }
}
