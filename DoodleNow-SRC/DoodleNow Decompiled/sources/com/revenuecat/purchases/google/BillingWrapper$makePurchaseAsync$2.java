package com.revenuecat.purchases.google;

import android.app.Activity;
import com.android.billingclient.api.BillingFlowParams;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.common.BillingAbstract;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.utils.Result;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$makePurchaseAsync$2 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ Boolean $isPersonalizedPrice;
    final /* synthetic */ PurchasingData $purchasingData;
    final /* synthetic */ ReplaceProductInfo $replaceProductInfo;
    final /* synthetic */ BillingWrapper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BillingWrapper$makePurchaseAsync$2(BillingWrapper billingWrapper, PurchasingData purchasingData, ReplaceProductInfo replaceProductInfo, String str, Boolean bool, Activity activity) {
        super(1);
        this.this$0 = billingWrapper;
        this.$purchasingData = purchasingData;
        this.$replaceProductInfo = replaceProductInfo;
        this.$appUserID = str;
        this.$isPersonalizedPrice = bool;
        this.$activity = activity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        BillingAbstract.PurchasesUpdatedListener purchasesUpdatedListener;
        Result access$buildPurchaseParams = this.this$0.buildPurchaseParams((GooglePurchasingData) this.$purchasingData, this.$replaceProductInfo, this.$appUserID, this.$isPersonalizedPrice);
        if (access$buildPurchaseParams instanceof Result.Success) {
            this.this$0.launchBillingFlow(this.$activity, (BillingFlowParams) ((Result.Success) access$buildPurchaseParams).getValue());
        } else if ((access$buildPurchaseParams instanceof Result.Error) && (purchasesUpdatedListener = this.this$0.getPurchasesUpdatedListener()) != null) {
            purchasesUpdatedListener.onPurchasesFailedToUpdate((PurchasesError) ((Result.Error) access$buildPurchaseParams).getValue());
        }
    }
}
