package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.models.PurchaseState;
import com.revenuecat.purchases.models.StoreTransaction;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "response", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$handleReceipt$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
    final /* synthetic */ Receipt $receipt;
    final /* synthetic */ UserData $userData;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$handleReceipt$1(Receipt receipt, PresentedOfferingContext presentedOfferingContext, UserData userData, AmazonBilling amazonBilling) {
        super(1);
        this.$receipt = receipt;
        this.$presentedOfferingContext = presentedOfferingContext;
        this.$userData = userData;
        this.this$0 = amazonBilling;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((JSONObject) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(jSONObject, "response");
        Object obj = jSONObject.get(b.L);
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        StoreTransaction storeTransaction = StoreTransactionConversionsKt.toStoreTransaction(this.$receipt, (String) obj, this.$presentedOfferingContext, PurchaseState.PURCHASED, this.$userData);
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener = this.this$0.getPurchasesUpdatedListener();
        if (purchasesUpdatedListener != null) {
            purchasesUpdatedListener.onPurchasesUpdated(CollectionsKt.listOf(storeTransaction));
        }
    }
}
