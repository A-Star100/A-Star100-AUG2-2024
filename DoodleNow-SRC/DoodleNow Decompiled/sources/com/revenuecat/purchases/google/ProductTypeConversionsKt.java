package com.revenuecat.purchases.google;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000\u001a\u000e\u0010\u0003\u001a\u00020\u0002*\u0004\u0018\u00010\u0001H\u0000¨\u0006\u0004"}, d2 = {"toGoogleProductType", "", "Lcom/revenuecat/purchases/ProductType;", "toRevenueCatProductType", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: productTypeConversions.kt */
public final class ProductTypeConversionsKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: productTypeConversions.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.revenuecat.purchases.ProductType[] r0 = com.revenuecat.purchases.ProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.ProductType r1 = com.revenuecat.purchases.ProductType.INAPP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.ProductType r1 = com.revenuecat.purchases.ProductType.SUBS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.google.ProductTypeConversionsKt.WhenMappings.<clinit>():void");
        }
    }

    public static final ProductType toRevenueCatProductType(String str) {
        if (Intrinsics.areEqual((Object) str, (Object) "inapp")) {
            return ProductType.INAPP;
        }
        if (Intrinsics.areEqual((Object) str, (Object) "subs")) {
            return ProductType.SUBS;
        }
        return ProductType.UNKNOWN;
    }

    public static final String toGoogleProductType(ProductType productType) {
        Intrinsics.checkNotNullParameter(productType, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[productType.ordinal()];
        if (i == 1) {
            return "inapp";
        }
        if (i != 2) {
            return null;
        }
        return "subs";
    }
}
