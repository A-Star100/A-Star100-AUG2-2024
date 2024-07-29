package com.revenuecat.purchases;

import android.app.Activity;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.ReplaceProductInfo;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "purchaseRecord", "Lcom/revenuecat/purchases/models/StoreTransaction;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$2 extends Lambda implements Function1<StoreTransaction, Unit> {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ String $appUserID;
    final /* synthetic */ GoogleReplacementMode $googleReplacementMode;
    final /* synthetic */ Boolean $isPersonalizedPrice;
    final /* synthetic */ PresentedOfferingContext $presentedOfferingContext;
    final /* synthetic */ Ref.ObjectRef<String> $previousProductId;
    final /* synthetic */ PurchasingData $purchasingData;
    final /* synthetic */ PurchasesOrchestrator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$replaceOldPurchaseWithNewProduct$2(Ref.ObjectRef<String> objectRef, PurchasesOrchestrator purchasesOrchestrator, Activity activity, String str, PurchasingData purchasingData, GoogleReplacementMode googleReplacementMode, PresentedOfferingContext presentedOfferingContext, Boolean bool) {
        super(1);
        this.$previousProductId = objectRef;
        this.this$0 = purchasesOrchestrator;
        this.$activity = activity;
        this.$appUserID = str;
        this.$purchasingData = purchasingData;
        this.$googleReplacementMode = googleReplacementMode;
        this.$presentedOfferingContext = presentedOfferingContext;
        this.$isPersonalizedPrice = bool;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((StoreTransaction) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(StoreTransaction storeTransaction) {
        Intrinsics.checkNotNullParameter(storeTransaction, "purchaseRecord");
        LogIntent logIntent = LogIntent.PURCHASE;
        String format = String.format(PurchaseStrings.FOUND_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{this.$previousProductId.element}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(logIntent, format);
        this.this$0.billing.makePurchaseAsync(this.$activity, this.$appUserID, this.$purchasingData, new ReplaceProductInfo(storeTransaction, this.$googleReplacementMode), this.$presentedOfferingContext, this.$isPersonalizedPrice);
    }
}
