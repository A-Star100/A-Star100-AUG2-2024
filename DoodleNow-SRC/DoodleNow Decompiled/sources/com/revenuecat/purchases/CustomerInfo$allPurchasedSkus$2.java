package com.revenuecat.purchases;

import com.revenuecat.purchases.models.Transaction;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfo.kt */
final class CustomerInfo$allPurchasedSkus$2 extends Lambda implements Function0<Set<? extends String>> {
    final /* synthetic */ CustomerInfo this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CustomerInfo$allPurchasedSkus$2(CustomerInfo customerInfo) {
        super(0);
        this.this$0 = customerInfo;
    }

    public final Set<String> invoke() {
        Iterable<Transaction> nonSubscriptionTransactions = this.this$0.getNonSubscriptionTransactions();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(nonSubscriptionTransactions, 10));
        for (Transaction productIdentifier : nonSubscriptionTransactions) {
            arrayList.add(productIdentifier.getProductIdentifier());
        }
        return SetsKt.plus(CollectionsKt.toSet((List) arrayList), this.this$0.getAllExpirationDatesByProduct().keySet());
    }
}
