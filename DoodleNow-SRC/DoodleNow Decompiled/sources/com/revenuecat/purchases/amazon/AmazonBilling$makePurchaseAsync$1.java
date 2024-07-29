package com.revenuecat.purchases.amazon;

import android.app.Activity;
import com.amazon.a.a.o.b;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.UserData;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.PurchasesError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "connectionError", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonBilling.kt */
final class AmazonBilling$makePurchaseAsync$1 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
    final /* synthetic */ AmazonStoreProduct $storeProduct;
    final /* synthetic */ AmazonBilling this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AmazonBilling$makePurchaseAsync$1(AmazonBilling amazonBilling, Activity activity, String str, AmazonStoreProduct amazonStoreProduct, PresentedOfferingContext presentedOfferingContext) {
        super(1);
        this.this$0 = amazonBilling;
        this.$activity = activity;
        this.$appUserID = str;
        this.$storeProduct = amazonStoreProduct;
        this.$presentedOfferingContext = presentedOfferingContext;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        if (purchasesError == null) {
            final AmazonBilling amazonBilling = this.this$0;
            final AmazonStoreProduct amazonStoreProduct = this.$storeProduct;
            final PresentedOfferingContext presentedOfferingContext = this.$presentedOfferingContext;
            final AmazonBilling amazonBilling2 = this.this$0;
            this.this$0.purchaseHandler.purchase(this.this$0.mainHandler, this.$activity, this.$appUserID, this.$storeProduct, new Function2<Receipt, UserData, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Receipt) obj, (UserData) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Receipt receipt, UserData userData) {
                    Intrinsics.checkNotNullParameter(receipt, b.D);
                    Intrinsics.checkNotNullParameter(userData, "userData");
                    amazonBilling.handleReceipt(receipt, userData, amazonStoreProduct, presentedOfferingContext);
                }
            }, new Function1<PurchasesError, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((PurchasesError) obj);
                    return Unit.INSTANCE;
                }

                public final void invoke(PurchasesError purchasesError) {
                    Intrinsics.checkNotNullParameter(purchasesError, "it");
                    amazonBilling2.onPurchaseError(purchasesError);
                }
            });
            return;
        }
        this.this$0.onPurchaseError(purchasesError);
    }
}
