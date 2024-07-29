package com.revenuecat.purchases.google;

import com.revenuecat.purchases.models.PurchaseState;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0002*\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"toGooglePurchaseState", "", "Lcom/revenuecat/purchases/models/PurchaseState;", "toRevenueCatPurchaseState", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: purchaseStateConversions.kt */
public final class PurchaseStateConversionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: purchaseStateConversions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.revenuecat.purchases.models.PurchaseState[] r0 = com.revenuecat.purchases.models.PurchaseState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.models.PurchaseState r1 = com.revenuecat.purchases.models.PurchaseState.UNSPECIFIED_STATE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.models.PurchaseState r1 = com.revenuecat.purchases.models.PurchaseState.PURCHASED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.models.PurchaseState r1 = com.revenuecat.purchases.models.PurchaseState.PENDING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.PurchaseStateConversionsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final PurchaseState toRevenueCatPurchaseState(int i) {
        if (i == 0) {
            return PurchaseState.UNSPECIFIED_STATE;
        }
        if (i == 1) {
            return PurchaseState.PURCHASED;
        }
        if (i != 2) {
            return PurchaseState.UNSPECIFIED_STATE;
        }
        return PurchaseState.PENDING;
    }

    public static final int toGooglePurchaseState(PurchaseState purchaseState) {
        Intrinsics.checkNotNullParameter(purchaseState, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[purchaseState.ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 1;
        }
        if (i == 3) {
            return 2;
        }
        throw new NoWhenBranchMatchedException();
    }
}
