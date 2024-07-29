package com.revenuecat.purchases.google;

import com.android.billingclient.api.QueryProductDetailsParams;
import com.android.billingclient.api.QueryPurchaseHistoryParams;
import com.android.billingclient.api.QueryPurchasesParams;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000\u001a\u000e\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0002H\u0000\u001a\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"buildQueryProductDetailsParams", "Lcom/android/billingclient/api/QueryProductDetailsParams;", "", "productIds", "", "buildQueryPurchaseHistoryParams", "Lcom/android/billingclient/api/QueryPurchaseHistoryParams;", "buildQueryPurchasesParams", "Lcom/android/billingclient/api/QueryPurchasesParams;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: billingClientParamBuilders.kt */
public final class BillingClientParamBuildersKt {
    public static final QueryPurchaseHistoryParams buildQueryPurchaseHistoryParams(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!Intrinsics.areEqual((Object) str, (Object) "inapp") && !Intrinsics.areEqual((Object) str, (Object) "subs")) {
            return null;
        }
        return QueryPurchaseHistoryParams.newBuilder().setProductType(str).build();
    }

    public static final QueryPurchasesParams buildQueryPurchasesParams(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        if (!Intrinsics.areEqual((Object) str, (Object) "inapp") && !Intrinsics.areEqual((Object) str, (Object) "subs")) {
            return null;
        }
        return QueryPurchasesParams.newBuilder().setProductType(str).build();
    }

    public static final QueryProductDetailsParams buildQueryProductDetailsParams(String str, Set<String> set) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(set, "productIds");
        Iterable<String> iterable = set;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String productId : iterable) {
            arrayList.add(QueryProductDetailsParams.Product.newBuilder().setProductId(productId).setProductType(str).build());
        }
        QueryProductDetailsParams build = QueryProductDetailsParams.newBuilder().setProductList((List) arrayList).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…List(productList).build()");
        return build;
    }
}
