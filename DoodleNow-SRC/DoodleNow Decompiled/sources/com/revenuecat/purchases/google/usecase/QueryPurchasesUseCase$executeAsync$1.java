package com.revenuecat.purchases.google.usecase;

import com.android.billingclient.api.BillingClient;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lcom/android/billingclient/api/BillingClient;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: QueryPurchasesUseCase.kt */
final class QueryPurchasesUseCase$executeAsync$1 extends Lambda implements Function1<BillingClient, Unit> {
    final /* synthetic */ QueryPurchasesUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    QueryPurchasesUseCase$executeAsync$1(QueryPurchasesUseCase queryPurchasesUseCase) {
        super(1);
        this.this$0 = queryPurchasesUseCase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BillingClient) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(BillingClient billingClient) {
        Intrinsics.checkNotNullParameter(billingClient, "$this$invoke");
        QueryPurchasesUseCase queryPurchasesUseCase = this.this$0;
        final QueryPurchasesUseCase queryPurchasesUseCase2 = this.this$0;
        queryPurchasesUseCase.querySubscriptions(new Function1<Map<String, ? extends StoreTransaction>, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Map<String, StoreTransaction>) (Map) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(final Map<String, StoreTransaction> map) {
                Intrinsics.checkNotNullParameter(map, "activeSubs");
                QueryPurchasesUseCase queryPurchasesUseCase = queryPurchasesUseCase2;
                final QueryPurchasesUseCase queryPurchasesUseCase2 = queryPurchasesUseCase2;
                queryPurchasesUseCase.queryInApps(new Function1<Map<String, ? extends StoreTransaction>, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Map<String, StoreTransaction>) (Map) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Map<String, StoreTransaction> map) {
                        Intrinsics.checkNotNullParameter(map, "unconsumedInApps");
                        queryPurchasesUseCase2.onOk(MapsKt.plus(map, map));
                    }
                }, queryPurchasesUseCase2.getOnError());
            }
        }, this.this$0.getOnError());
    }
}
