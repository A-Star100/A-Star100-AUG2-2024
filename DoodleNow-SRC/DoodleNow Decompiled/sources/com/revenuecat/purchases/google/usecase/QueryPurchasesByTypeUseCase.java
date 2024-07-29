package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.android.billingclient.api.BillingResult;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.PurchasesResponseListener;
import com.android.billingclient.api.QueryPurchasesParams;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.DurationExtensionsKt;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import com.revenuecat.purchases.google.ProductTypeConversionsKt;
import com.revenuecat.purchases.google.StoreTransactionConversionsKt;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.OfferingStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.time.Duration;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B°\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\b\u0012#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\t0\b\u0012H\u0010\u000f\u001aD\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0010j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u001c\u0010\u001f\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J(\u0010!\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J \u0010(\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u00032\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J&\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\b\u0012\u0004\u0012\u00020/0.2\u0006\u0010#\u001a\u00020\u0003H\u0002R\u0014\u0010\u0017\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR)\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u00060"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryPurchasesByTypeUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/QueryPurchasesByTypeUseCaseParams;", "onSuccess", "Lkotlin/Function1;", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/QueryPurchasesByTypeUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnSuccess", "getWithConnectedClient", "executeAsync", "onOk", "received", "queryPurchasesAsyncWithTrackingEnsuringOneResponse", "billingClient", "productType", "queryParams", "Lcom/android/billingclient/api/QueryPurchasesParams;", "listener", "Lcom/android/billingclient/api/PurchasesResponseListener;", "trackGoogleQueryPurchasesRequestIfNeeded", "billingResult", "Lcom/android/billingclient/api/BillingResult;", "requestStartTime", "Ljava/util/Date;", "toMapOfGooglePurchaseWrapper", "", "Lcom/android/billingclient/api/Purchase;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryPurchasesByTypeUseCase.kt */
public final class QueryPurchasesByTypeUseCase extends BillingClientUseCase<Map<String, ? extends StoreTransaction>> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<Map<String, StoreTransaction>, Unit> onSuccess;
    /* access modifiers changed from: private */
    public final QueryPurchasesByTypeUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    public final Function1<PurchasesError, Unit> getOnError() {
        return this.onError;
    }

    public final Function1<Map<String, StoreTransaction>, Unit> getOnSuccess() {
        return this.onSuccess;
    }

    public final Function1<Function1<? super BillingClient, Unit>, Unit> getWithConnectedClient() {
        return this.withConnectedClient;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QueryPurchasesByTypeUseCase(QueryPurchasesByTypeUseCaseParams queryPurchasesByTypeUseCaseParams, Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12, Function1<? super Function1<? super BillingClient, Unit>, Unit> function13, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> function2) {
        super(queryPurchasesByTypeUseCaseParams, function12, function2);
        Intrinsics.checkNotNullParameter(queryPurchasesByTypeUseCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Intrinsics.checkNotNullParameter(function13, "withConnectedClient");
        Intrinsics.checkNotNullParameter(function2, "executeRequestOnUIThread");
        this.useCaseParams = queryPurchasesByTypeUseCaseParams;
        this.onSuccess = function1;
        this.onError = function12;
        this.withConnectedClient = function13;
    }

    public String getErrorMessage() {
        return "Error when querying purchases of type " + this.useCaseParams.getProductType();
    }

    public void executeAsync() {
        this.withConnectedClient.invoke(new QueryPurchasesByTypeUseCase$executeAsync$1(this));
    }

    public void onOk(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "received");
        this.onSuccess.invoke(map);
    }

    /* access modifiers changed from: private */
    public final void queryPurchasesAsyncWithTrackingEnsuringOneResponse(BillingClient billingClient, String str, QueryPurchasesParams queryPurchasesParams, PurchasesResponseListener purchasesResponseListener) {
        billingClient.queryPurchasesAsync(queryPurchasesParams, (PurchasesResponseListener) new QueryPurchasesByTypeUseCase$$ExternalSyntheticLambda0(new AtomicBoolean(false), this, str, this.useCaseParams.getDateProvider().getNow(), purchasesResponseListener));
    }

    /* access modifiers changed from: private */
    public static final void queryPurchasesAsyncWithTrackingEnsuringOneResponse$lambda$0(AtomicBoolean atomicBoolean, QueryPurchasesByTypeUseCase queryPurchasesByTypeUseCase, String str, Date date, PurchasesResponseListener purchasesResponseListener, BillingResult billingResult, List list) {
        Intrinsics.checkNotNullParameter(atomicBoolean, "$hasResponded");
        Intrinsics.checkNotNullParameter(queryPurchasesByTypeUseCase, "this$0");
        Intrinsics.checkNotNullParameter(str, "$productType");
        Intrinsics.checkNotNullParameter(date, "$requestStartTime");
        Intrinsics.checkNotNullParameter(purchasesResponseListener, "$listener");
        Intrinsics.checkNotNullParameter(billingResult, "billingResult");
        Intrinsics.checkNotNullParameter(list, "purchases");
        if (atomicBoolean.getAndSet(true)) {
            LogIntent logIntent = LogIntent.GOOGLE_ERROR;
            String format = String.format(OfferingStrings.EXTRA_QUERY_PURCHASES_RESPONSE, Arrays.copyOf(new Object[]{Integer.valueOf(billingResult.getResponseCode())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
            LogWrapperKt.log(logIntent, format);
            return;
        }
        queryPurchasesByTypeUseCase.trackGoogleQueryPurchasesRequestIfNeeded(str, billingResult, date);
        purchasesResponseListener.onQueryPurchasesResponse(billingResult, list);
    }

    private final void trackGoogleQueryPurchasesRequestIfNeeded(String str, BillingResult billingResult, Date date) {
        DiagnosticsTracker diagnosticsTrackerIfEnabled = this.useCaseParams.getDiagnosticsTrackerIfEnabled();
        if (diagnosticsTrackerIfEnabled != null) {
            int responseCode = billingResult.getResponseCode();
            String debugMessage = billingResult.getDebugMessage();
            Intrinsics.checkNotNullExpressionValue(debugMessage, "billingResult.debugMessage");
            diagnosticsTrackerIfEnabled.m1099trackGoogleQueryPurchasesRequestWn2Vu4Y(str, responseCode, debugMessage, DurationExtensionsKt.between(Duration.Companion, date, this.useCaseParams.getDateProvider().getNow()));
        }
    }

    /* access modifiers changed from: private */
    public final Map<String, StoreTransaction> toMapOfGooglePurchaseWrapper(List<? extends Purchase> list, String str) {
        Iterable<Purchase> iterable = list;
        Map<String, StoreTransaction> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Purchase purchase : iterable) {
            String purchaseToken = purchase.getPurchaseToken();
            Intrinsics.checkNotNullExpressionValue(purchaseToken, "purchase.purchaseToken");
            Pair pair = TuplesKt.to(UtilsKt.sha1(purchaseToken), StoreTransactionConversionsKt.toStoreTransaction$default(purchase, ProductTypeConversionsKt.toRevenueCatProductType(str), (PresentedOfferingContext) null, (String) null, (GoogleReplacementMode) null, 14, (Object) null));
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
