package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsManager.kt */
final class OfferingsManager$handleErrorFetchingOfferings$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PurchasesError $error;
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsManager$handleErrorFetchingOfferings$1(Function1<? super PurchasesError, Unit> function1, PurchasesError purchasesError) {
        super(0);
        this.$onError = function1;
        this.$error = purchasesError;
    }

    public final void invoke() {
        Function1<PurchasesError, Unit> function1 = this.$onError;
        if (function1 != null) {
            function1.invoke(this.$error);
        }
    }
}
