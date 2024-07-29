package com.revenuecat.purchases.amazon;

import com.amazon.device.iap.model.FulfillmentResult;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "connectionError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$consumeAndSave$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ StoreTransaction $purchase;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$consumeAndSave$1(AmazonBilling amazonBilling, StoreTransaction storeTransaction) {
        super(1);
        this.this$0 = amazonBilling;
        this.$purchase = storeTransaction;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError == null) {
            this.this$0.purchasingServiceProvider.notifyFulfillment(this.$purchase.getPurchaseToken(), FulfillmentResult.FULFILLED);
        } else {
            LogUtilsKt.errorLog(purchasesError);
        }
    }
}
