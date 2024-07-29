package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
/* synthetic */ class AmazonBilling$handleReceipt$2 extends FunctionReferenceImpl implements Function1<PurchasesError, Unit> {
    AmazonBilling$handleReceipt$2(Object obj) {
        super(1, obj, AmazonBilling.class, "onPurchaseError", "onPurchaseError(Lcom/revenuecat/purchases/PurchasesError;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "p0");
        ((AmazonBilling) this.receiver).onPurchaseError(purchasesError);
    }
}
