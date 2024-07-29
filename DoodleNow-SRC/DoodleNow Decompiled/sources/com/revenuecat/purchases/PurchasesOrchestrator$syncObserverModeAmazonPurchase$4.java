package com.revenuecat.purchases;

import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "error", "Lcom/revenuecat/purchases/PurchasesError;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasesOrchestrator.kt */
final class PurchasesOrchestrator$syncObserverModeAmazonPurchase$4 extends Lambda implements Function1<PurchasesError, Unit> {
    final /* synthetic */ String $amazonUserID;
    final /* synthetic */ String $receiptID;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PurchasesOrchestrator$syncObserverModeAmazonPurchase$4(String str, String str2) {
        super(1);
        this.$receiptID = str;
        this.$amazonUserID = str2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PurchasesError) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PurchasesError purchasesError) {
        Intrinsics.checkNotNullParameter(purchasesError, "error");
        String format = String.format(PurchaseStrings.SYNCING_PURCHASE_ERROR_DETAILS_USER_ID, Arrays.copyOf(new Object[]{this.$receiptID, this.$amazonUserID, purchasesError}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        LogWrapperKt.log(LogIntent.RC_ERROR, format);
    }
}
