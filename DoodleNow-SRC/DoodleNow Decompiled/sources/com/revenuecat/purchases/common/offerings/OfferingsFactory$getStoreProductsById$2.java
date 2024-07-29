package com.revenuecat.purchases.common.offerings;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: OfferingsFactory.kt */
final class OfferingsFactory$getStoreProductsById$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Function1<PurchasesError, Unit> $onError;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    OfferingsFactory$getStoreProductsById$2(Function1<? super PurchasesError, Unit> function1) {
        super(1);
        this.$onError = function1;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "it");
        this.$onError.invoke(purchasesError);
    }
}
