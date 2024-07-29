package com.revenuecat.purchases.hybridcommon.mappers;

import com.revenuecat.purchases.ProductType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "toProductType", "Lcom/revenuecat/purchases/ProductType;", "getToProductType", "()Lcom/revenuecat/purchases/ProductType;", "getValue", "()Ljava/lang/String;", "SUBSCRIPTION", "NON_SUBSCRIPTION", "UNKNOWN", "hybridcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StoreProductMapper.kt */
public enum MappedProductCategory {
    SUBSCRIPTION("SUBSCRIPTION"),
    NON_SUBSCRIPTION("NON_SUBSCRIPTION"),
    UNKNOWN("UNKNOWN");
    
    private final String value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: StoreProductMapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory[] r0 = com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory r1 = com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory.NON_SUBSCRIPTION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory r1 = com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory.SUBSCRIPTION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory r1 = com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.hybridcommon.mappers.MappedProductCategory.WhenMappings.<clinit>():void");
        }
    }

    public final String getValue() {
        return this.value;
    }

    private MappedProductCategory(String str) {
        this.value = str;
    }

    public final ProductType getToProductType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return ProductType.INAPP;
        }
        if (i == 2) {
            return ProductType.SUBS;
        }
        if (i == 3) {
            return ProductType.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }
}
