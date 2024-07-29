package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "type", "Lcom/revenuecat/purchases/ProductType;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$getStoreTransaction$1$2 extends Lambda implements Function1<ProductType, Unit> {
    final /* synthetic */ Function1<StoreTransaction, Unit> $completion;
    final /* synthetic */ Purchase $purchase;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$getStoreTransaction$1$2(Function1<? super StoreTransaction, Unit> function1, Purchase purchase) {
        super(1);
        this.$completion = function1;
        this.$purchase = purchase;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ProductType) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "type");
        this.$completion.invoke(StoreTransactionConversionsKt.toStoreTransaction$default(this.$purchase, productType, (PresentedOfferingContext) null, (String) null, (GoogleReplacementMode) null, 14, (Object) null));
    }
}
