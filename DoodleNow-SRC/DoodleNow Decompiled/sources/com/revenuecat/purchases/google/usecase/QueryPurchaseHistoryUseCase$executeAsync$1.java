package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.PurchaseHistoryResponseListener;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.google.BillingClientParamBuildersKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.strings.RestoreStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryPurchaseHistoryUseCase.kt */
final class QueryPurchaseHistoryUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ QueryPurchaseHistoryUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryPurchaseHistoryUseCase$executeAsync$1(QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase) {
        super(1);
        this.this$0 = queryPurchaseHistoryUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Unit unit;
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        Date now = this.this$0.useCaseParams.getDateProvider().getNow();
        QueryPurchaseHistoryParams buildQueryPurchaseHistoryParams = BillingClientParamBuildersKt.buildQueryPurchaseHistoryParams(this.this$0.useCaseParams.getProductType());
        if (buildQueryPurchaseHistoryParams != null) {
            billingClient.queryPurchaseHistoryAsync(buildQueryPurchaseHistoryParams, (PurchaseHistoryResponseListener) new QueryPurchaseHistoryUseCase$executeAsync$1$$ExternalSyntheticLambda0(atomicBoolean, this.this$0, now));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase = this.this$0;
            String format = String.format(PurchaseStrings.INVALID_PRODUCT_TYPE, Arrays.copyOf(new Object[]{"queryPurchaseHistory"}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogUtilsKt.errorLog$default(format, (Throwable) null, 2, (Object) null);
            BillingResult build = BillingResult.newBuilder().setResponseCode(5).build();
            Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n           …                 .build()");
            BillingClientUseCase.processResult$default(queryPurchaseHistoryUseCase, build, (Object) null, (Function1) null, (Function1) null, 12, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(AtomicBoolean atomicBoolean, QueryPurchaseHistoryUseCase queryPurchaseHistoryUseCase, Date date, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "$hasResponded");
        Intrinsics.checkNotNullParameter(queryPurchaseHistoryUseCase, "this$0");
        Intrinsics.checkNotNullParameter(date, "$requestStartTime");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        if (atomicBoolean.getAndSet(true)) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(RestoreStrings.EXTRA_QUERY_PURCHASE_HISTORY_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return;
        }
        queryPurchaseHistoryUseCase.trackGoogleQueryPurchaseHistoryRequestIfNeeded(queryPurchaseHistoryUseCase.useCaseParams.getProductType(), billingResult, date);
        BillingClientUseCase.processResult$default(queryPurchaseHistoryUseCase, billingResult, list, (Function1) null, (Function1) null, 12, (Object) null);
    }
}
