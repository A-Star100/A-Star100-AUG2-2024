package com.revenuecat.purchases.amazon;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toRevenueCatProductType", "Lcom/revenuecat/purchases/ProductType;", "Lcom/amazon/device/iap/model/ProductType;", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: productTypeConversions.kt */
public final class ProductTypeConversionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: productTypeConversions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.amazon.device.iap.model.ProductType[] r0 = com.amazon.device.iap.model.ProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.amazon.device.iap.model.ProductType r1 = com.amazon.device.iap.model.ProductType.CONSUMABLE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.amazon.device.iap.model.ProductType r1 = com.amazon.device.iap.model.ProductType.ENTITLED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.amazon.device.iap.model.ProductType r1 = com.amazon.device.iap.model.ProductType.SUBSCRIPTION     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.ProductTypeConversionsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final ProductType toRevenueCatProductType(com.amazon.device.iap.model.ProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return ProductType.INAPP;
        }
        if (i == 2) {
            return ProductType.INAPP;
        }
        if (i == 3) {
            return ProductType.SUBS;
        }
        throw new NoWhenBranchMatchedException();
    }
}
