package com.revenuecat.purchases.google;

import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "purchases", "", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$queryPurchaseType$1 extends Lambda implements Function1<Map<String, ? extends StoreTransaction>, Unit> {
    final /* synthetic */ String $purchaseToken;
    final /* synthetic */ Function1<Boolean, Unit> $resultHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$queryPurchaseType$1(Function1<? super Boolean, Unit> function1, String str) {
        super(1);
        this.$resultHandler = function1;
        this.$purchaseToken = str;
    }

    public final void invoke(Map<String, StoreTransaction> map) {
        Intrinsics.checkNotNullParameter(map, "purchases");
        Function1<Boolean, Unit> function1 = this.$resultHandler;
        Iterable values = map.values();
        String str = this.$purchaseToken;
        boolean z = false;
        if (!(values instanceof Collection) || !((Collection) values).isEmpty()) {
            Iterator it = values.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (Intrinsics.areEqual((Object) ((StoreTransaction) it.next()).getPurchaseToken(), (Object) str)) {
                        z = true;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        function1.invoke(Boolean.valueOf(z));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, StoreTransaction>) (Map) obj);
        return Unit.INSTANCE;
    }
}
