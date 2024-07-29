package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0000\u0018\u00002\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001B°\u0001\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\b\u0012#\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\t0\b\u0012H\u0010\u000f\u001aD\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\u0004\u0012\u00020\t0\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\t0\u0010j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u001e\u001a\u00020\tH\u0016J\u001c\u0010\u001f\u001a\u00020\t2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J<\u0010!\u001a\u00020\t2\u001e\u0010\"\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\bH\u0002J<\u0010$\u001a\u00020\t2\u001e\u0010%\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\t0\b2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\bH\u0002R\u0014\u0010\u0017\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR)\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R.\u0010\f\u001a\u001f\u0012\u0015\u0012\u0013\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\u000e\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001b¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/google/usecase/QueryPurchasesUseCase;", "Lcom/revenuecat/purchases/google/usecase/BillingClientUseCase;", "", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "useCaseParams", "Lcom/revenuecat/purchases/google/usecase/QueryPurchasesUseCaseParams;", "onSuccess", "Lkotlin/Function1;", "", "onError", "Lcom/revenuecat/purchases/PurchasesError;", "withConnectedClient", "Lcom/android/billingclient/api/BillingClient;", "Lkotlin/ExtensionFunctionType;", "executeRequestOnUIThread", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "delayInMillis", "Lcom/revenuecat/purchases/google/usecase/ExecuteRequestOnUIThreadFunction;", "(Lcom/revenuecat/purchases/google/usecase/QueryPurchasesUseCaseParams;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "errorMessage", "getErrorMessage", "()Ljava/lang/String;", "getOnError", "()Lkotlin/jvm/functions/Function1;", "getOnSuccess", "getWithConnectedClient", "executeAsync", "onOk", "received", "queryInApps", "onQueryInAppsSuccess", "onQueryInAppsError", "querySubscriptions", "onQuerySubscriptionsSuccess", "onQuerySubscriptionsError", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryPurchasesUseCase.kt */
public final class QueryPurchasesUseCase extends BillingClientUseCase<Map<String, ? extends StoreTransaction>> {
    private final Function1<PurchasesError, Unit> onError;
    private final Function1<Map<String, StoreTransaction>, Unit> onSuccess;
    private final QueryPurchasesUseCaseParams useCaseParams;
    private final Function1<Function1<? super BillingClient, Unit>, Unit> withConnectedClient;

    public String getErrorMessage() {
        return "Error when querying purchases";
    }

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
    public QueryPurchasesUseCase(QueryPurchasesUseCaseParams queryPurchasesUseCaseParams, Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12, Function1<? super Function1<? super BillingClient, Unit>, Unit> function13, Function2<? super Long, ? super Function1<? super PurchasesError, Unit>, Unit> function2) {
        super(queryPurchasesUseCaseParams, function12, function2);
        Intrinsics.checkNotNullParameter(queryPurchasesUseCaseParams, "useCaseParams");
        Intrinsics.checkNotNullParameter(function1, "onSuccess");
        Intrinsics.checkNotNullParameter(function12, "onError");
        Intrinsics.checkNotNullParameter(function13, "withConnectedClient");
        Intrinsics.checkNotNullParameter(function2, "executeRequestOnUIThread");
        this.useCaseParams = queryPurchasesUseCaseParams;
        this.onSuccess = function1;
        this.onError = function12;
        this.withConnectedClient = function13;
    }

    /* access modifiers changed from: private */
    public final void queryInApps(Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.useCaseParams.getDateProvider(), this.useCaseParams.getDiagnosticsTrackerIfEnabled(), this.useCaseParams.getAppInBackground(), "inapp"), function1, function12, this.withConnectedClient, getExecuteRequestOnUIThread()), 0, 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void querySubscriptions(Function1<? super Map<String, StoreTransaction>, Unit> function1, Function1<? super PurchasesError, Unit> function12) {
        BillingClientUseCase.run$default(new QueryPurchasesByTypeUseCase(new QueryPurchasesByTypeUseCaseParams(this.useCaseParams.getDateProvider(), this.useCaseParams.getDiagnosticsTrackerIfEnabled(), this.useCaseParams.getAppInBackground(), "subs"), function1, function12, this.withConnectedClient, getExecuteRequestOnUIThread()), 0, 1, (Object) null);
    }

    public void executeAsync() {
        this.withConnectedClient.invoke(new QueryPurchasesUseCase$executeAsync$1(this));
    }

    public void onOk(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "received");
        this.onSuccess.invoke(map);
    }
}
