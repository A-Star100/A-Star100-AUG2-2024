package com.revenuecat.purchases.google;

import com.android.billingclient.api.Purchase;
import com.revenuecat.purchases.common.PurchaseExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/android/billingclient/api/Purchase;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: BillingWrapper.kt */
final class BillingWrapper$onPurchasesUpdated$3$1 extends Lambda implements Function1<Purchase, CharSequence> {
    public static final BillingWrapper$onPurchasesUpdated$3$1 INSTANCE = new BillingWrapper$onPurchasesUpdated$3$1();

    BillingWrapper$onPurchasesUpdated$3$1() {
        super(1);
    }

    public final CharSequence invoke(Purchase purchase) {
        Intrinsics.checkNotNullParameter(purchase, "it");
        return PurchaseExtensionsKt.toHumanReadableDescription(purchase);
    }
}
