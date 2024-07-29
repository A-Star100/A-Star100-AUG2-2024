package com.revenuecat.purchases.hybridcommon.mappers;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.models.OfferPaymentMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\u0005\u001a$\u0010#\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$0&*\b\u0012\u0004\u0012\u00020\u00050&\u001a\u001c\u0010'\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\u0005H\u0001\u001a\u001c\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\tH\u0002\u001a\u001c\u0010)\u001a\u0012\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%\u0018\u00010$*\u00020\tH\u0002\u001a\u001a\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020+H\u0002\u001a\u001a\u0010,\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u00020\rH\u0002\u001a\f\u0010-\u001a\u00020.*\u00020\u0005H\u0001\u001a\f\u0010/\u001a\u00020\u0011*\u00020\u0005H\u0001\u001a\"\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0006\u0012\u0004\u0018\u00010%0$*\u0002012\u0006\u00102\u001a\u00020\u0005H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u0017\u0010\u0004\u001a\u0004\u0018\u00010\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u0017\u0010\b\u001a\u0004\u0018\u00010\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u001a\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u00058BX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0014\u001a\u00020\u0015*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0001*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\"\u0017\u0010\u001b\u001a\u0004\u0018\u00010\t*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u000b\"\u0015\u0010\u001d\u001a\u00020\u0015*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0017\"\u0015\u0010\u001f\u001a\u00020\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b \u0010\u0013\"\u0015\u0010!\u001a\u00020\u0011*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\"\u0010\u0013¨\u00063"}, d2 = {"DAYS_PER_WEEK", "", "MICROS_CONVERSION_METRIC", "", "freeTrialCycles", "Lcom/revenuecat/purchases/models/StoreProduct;", "getFreeTrialCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/Integer;", "freeTrialPeriod", "Lcom/revenuecat/purchases/models/Period;", "getFreeTrialPeriod", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/Period;", "introductoryPhase", "Lcom/revenuecat/purchases/models/PricingPhase;", "getIntroductoryPhase", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/PricingPhase;", "introductoryPrice", "", "getIntroductoryPrice", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/String;", "introductoryPriceAmountMicros", "", "getIntroductoryPriceAmountMicros", "(Lcom/revenuecat/purchases/models/StoreProduct;)J", "introductoryPriceCycles", "getIntroductoryPriceCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)I", "introductoryPricePeriod", "getIntroductoryPricePeriod", "priceAmountMicros", "getPriceAmountMicros", "priceCurrencyCode", "getPriceCurrencyCode", "priceString", "getPriceString", "map", "", "", "", "mapIntroPrice", "mapPeriod", "mapPeriodForStoreProduct", "mapPrice", "Lcom/revenuecat/purchases/models/Price;", "mapPricingPhase", "mapProductCategory", "Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "mapProductType", "mapSubscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "storeProduct", "hybridcommon_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: StoreProductMapper.kt */
public final class StoreProductMapperKt {
    private static final int DAYS_PER_WEEK = 7;
    private static final double MICROS_CONVERSION_METRIC = 1000000.0d;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: StoreProductMapper.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(19:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|20|21|22|23|25) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x004c */
        static {
            /*
                com.revenuecat.purchases.ProductType[] r0 = com.revenuecat.purchases.ProductType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.revenuecat.purchases.ProductType r2 = com.revenuecat.purchases.ProductType.INAPP     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.revenuecat.purchases.ProductType r3 = com.revenuecat.purchases.ProductType.SUBS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.revenuecat.purchases.ProductType r4 = com.revenuecat.purchases.ProductType.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.revenuecat.purchases.models.Period$Unit[] r0 = com.revenuecat.purchases.models.Period.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.models.Period$Unit r4 = com.revenuecat.purchases.models.Period.Unit.DAY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.WEEK     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.MONTH     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.YEAR     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0055 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0055 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0055 }
            L_0x0055:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt.WhenMappings.<clinit>():void");
        }
    }

    public static final long getPriceAmountMicros(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getAmountMicros();
    }

    public static final String getPriceString(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getFormatted();
    }

    public static final String getPriceCurrencyCode(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        return storeProduct.getPrice().getCurrencyCode();
    }

    public static final Period getFreeTrialPeriod(StoreProduct storeProduct) {
        PricingPhase freePhase;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingPeriod();
    }

    public static final Integer getFreeTrialCycles(StoreProduct storeProduct) {
        PricingPhase freePhase;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingCycleCount();
    }

    private static final PricingPhase getIntroductoryPhase(StoreProduct storeProduct) {
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    public static final String getIntroductoryPrice(StoreProduct storeProduct) {
        Price price;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase == null || (price = introductoryPhase.getPrice()) == null) {
            return null;
        }
        return price.getFormatted();
    }

    public static final Period getIntroductoryPricePeriod(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase != null) {
            return introductoryPhase.getBillingPeriod();
        }
        return null;
    }

    public static final long getIntroductoryPriceAmountMicros(StoreProduct storeProduct) {
        Price price;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase == null || (price = introductoryPhase.getPrice()) == null) {
            return 0;
        }
        return price.getAmountMicros();
    }

    public static final int getIntroductoryPriceCycles(StoreProduct storeProduct) {
        Integer billingCycleCount;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        PricingPhase introductoryPhase = getIntroductoryPhase(storeProduct);
        if (introductoryPhase == null || (billingCycleCount = introductoryPhase.getBillingCycleCount()) == null) {
            return 0;
        }
        return billingCycleCount.intValue();
    }

    public static final Map<String, Object> map(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        Pair[] pairArr = new Pair[14];
        pairArr[0] = TuplesKt.to("identifier", storeProduct.getId());
        pairArr[1] = TuplesKt.to(b.c, storeProduct.getDescription());
        pairArr[2] = TuplesKt.to("title", storeProduct.getTitle());
        pairArr[3] = TuplesKt.to(b.x, Double.valueOf(((double) getPriceAmountMicros(storeProduct)) / MICROS_CONVERSION_METRIC));
        pairArr[4] = TuplesKt.to("priceString", getPriceString(storeProduct));
        pairArr[5] = TuplesKt.to("currencyCode", getPriceCurrencyCode(storeProduct));
        pairArr[6] = TuplesKt.to("introPrice", mapIntroPrice(storeProduct));
        List list = null;
        pairArr[7] = TuplesKt.to("discounts", null);
        pairArr[8] = TuplesKt.to("productCategory", mapProductCategory(storeProduct).getValue());
        pairArr[9] = TuplesKt.to("productType", mapProductType(storeProduct));
        Period period = storeProduct.getPeriod();
        pairArr[10] = TuplesKt.to(b.o, period != null ? period.getIso8601() : null);
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        pairArr[11] = TuplesKt.to("defaultOption", defaultOption != null ? mapSubscriptionOption(defaultOption, storeProduct) : null);
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        if (subscriptionOptions != null) {
            Iterable<SubscriptionOption> iterable = subscriptionOptions;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SubscriptionOption mapSubscriptionOption : iterable) {
                arrayList.add(mapSubscriptionOption(mapSubscriptionOption, storeProduct));
            }
            list = (List) arrayList;
        }
        pairArr[12] = TuplesKt.to("subscriptionOptions", list);
        pairArr[13] = TuplesKt.to("presentedOfferingIdentifier", storeProduct.getPresentedOfferingIdentifier());
        return MapsKt.mapOf(pairArr);
    }

    public static final List<Map<String, Object>> map(List<? extends StoreProduct> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Iterable<StoreProduct> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (StoreProduct map : iterable) {
            arrayList.add(map(map));
        }
        return (List) arrayList;
    }

    public static final MappedProductCategory mapProductCategory(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i == 1) {
            return MappedProductCategory.NON_SUBSCRIPTION;
        }
        if (i == 2) {
            return MappedProductCategory.SUBSCRIPTION;
        }
        if (i == 3) {
            return MappedProductCategory.UNKNOWN;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String mapProductType(StoreProduct storeProduct) {
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i == 1) {
            return "CONSUMABLE";
        }
        if (i == 2) {
            SubscriptionOption defaultOption = storeProduct.getDefaultOption();
            return (defaultOption == null || !defaultOption.isPrepaid()) ? "AUTO_RENEWABLE_SUBSCRIPTION" : "PREPAID_SUBSCRIPTION";
        } else if (i == 3) {
            return "UNKNOWN";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final Map<String, Object> mapIntroPrice(StoreProduct storeProduct) {
        Period introductoryPricePeriod;
        Map<String, Object> mapPeriodForStoreProduct;
        Map<String, Object> mapPeriodForStoreProduct2;
        Intrinsics.checkNotNullParameter(storeProduct, "<this>");
        int i = 1;
        String str = null;
        if (getFreeTrialPeriod(storeProduct) != null) {
            Period freeTrialPeriod = getFreeTrialPeriod(storeProduct);
            if (freeTrialPeriod == null || (mapPeriodForStoreProduct2 = mapPeriodForStoreProduct(freeTrialPeriod)) == null) {
                return null;
            }
            Pair[] pairArr = new Pair[4];
            pairArr[0] = TuplesKt.to(b.x, 0);
            pairArr[1] = TuplesKt.to("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0));
            Period freeTrialPeriod2 = getFreeTrialPeriod(storeProduct);
            if (freeTrialPeriod2 != null) {
                str = freeTrialPeriod2.getIso8601();
            }
            pairArr[2] = TuplesKt.to("period", str);
            Integer freeTrialCycles = getFreeTrialCycles(storeProduct);
            if (freeTrialCycles != null) {
                i = freeTrialCycles.intValue();
            }
            pairArr[3] = TuplesKt.to("cycles", Integer.valueOf(i));
            return MapsKt.plus(MapsKt.mapOf(pairArr), (Map) mapPeriodForStoreProduct2);
        } else if (getIntroductoryPrice(storeProduct) == null || (introductoryPricePeriod = getIntroductoryPricePeriod(storeProduct)) == null || (mapPeriodForStoreProduct = mapPeriodForStoreProduct(introductoryPricePeriod)) == null) {
            return null;
        } else {
            Pair[] pairArr2 = new Pair[4];
            pairArr2[0] = TuplesKt.to(b.x, Double.valueOf(((double) getIntroductoryPriceAmountMicros(storeProduct)) / MICROS_CONVERSION_METRIC));
            pairArr2[1] = TuplesKt.to("priceString", getIntroductoryPrice(storeProduct));
            Period introductoryPricePeriod2 = getIntroductoryPricePeriod(storeProduct);
            if (introductoryPricePeriod2 != null) {
                str = introductoryPricePeriod2.getIso8601();
            }
            pairArr2[2] = TuplesKt.to("period", str);
            pairArr2[3] = TuplesKt.to("cycles", Integer.valueOf(getIntroductoryPriceCycles(storeProduct)));
            return MapsKt.plus(MapsKt.mapOf(pairArr2), (Map) mapPeriodForStoreProduct);
        }
    }

    private static final Map<String, Object> mapPeriodForStoreProduct(Period period) {
        int i = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i == 1) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        } else if (i == 2) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue() * 7)));
        } else if (i == 3) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "MONTH"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        } else if (i == 4) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "YEAR"), TuplesKt.to("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        } else if (i == 5) {
            return MapsKt.mapOf(TuplesKt.to("periodUnit", "DAY"), TuplesKt.to("periodNumberOfUnits", 0));
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private static final Map<String, Object> mapPeriod(Period period) {
        Map map;
        int i = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i == 1) {
            map = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 2) {
            map = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", Integer.valueOf(period.getValue() * 7)));
        } else if (i == 3) {
            map = MapsKt.mapOf(TuplesKt.to("unit", "MONTH"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 4) {
            map = MapsKt.mapOf(TuplesKt.to("unit", "YEAR"), TuplesKt.to("value", Integer.valueOf(period.getValue())));
        } else if (i == 5) {
            map = MapsKt.mapOf(TuplesKt.to("unit", "DAY"), TuplesKt.to("value", 0));
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return MapsKt.plus(map, MapsKt.mapOf(TuplesKt.to("iso8601", period.getIso8601())));
    }

    private static final Map<String, Object> mapSubscriptionOption(SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
        Pair[] pairArr = new Pair[12];
        pairArr[0] = TuplesKt.to("id", subscriptionOption.getId());
        pairArr[1] = TuplesKt.to("storeProductId", storeProduct.getId());
        pairArr[2] = TuplesKt.to("productId", storeProduct.getPurchasingData().getProductId());
        Iterable<PricingPhase> pricingPhases = subscriptionOption.getPricingPhases();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(pricingPhases, 10));
        for (PricingPhase mapPricingPhase : pricingPhases) {
            arrayList.add(mapPricingPhase(mapPricingPhase));
        }
        pairArr[3] = TuplesKt.to("pricingPhases", (List) arrayList);
        pairArr[4] = TuplesKt.to("tags", subscriptionOption.getTags());
        pairArr[5] = TuplesKt.to("isBasePlan", Boolean.valueOf(subscriptionOption.isBasePlan()));
        Period billingPeriod = subscriptionOption.getBillingPeriod();
        Map<String, Object> map = null;
        pairArr[6] = TuplesKt.to("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        pairArr[7] = TuplesKt.to("isPrepaid", Boolean.valueOf(subscriptionOption.isPrepaid()));
        PricingPhase fullPricePhase = subscriptionOption.getFullPricePhase();
        pairArr[8] = TuplesKt.to("fullPricePhase", fullPricePhase != null ? mapPricingPhase(fullPricePhase) : null);
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        pairArr[9] = TuplesKt.to("freePhase", freePhase != null ? mapPricingPhase(freePhase) : null);
        PricingPhase introPhase = subscriptionOption.getIntroPhase();
        if (introPhase != null) {
            map = mapPricingPhase(introPhase);
        }
        pairArr[10] = TuplesKt.to("introPhase", map);
        pairArr[11] = TuplesKt.to("presentedOfferingIdentifier", subscriptionOption.getPresentedOfferingIdentifier());
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, Object> mapPricingPhase(PricingPhase pricingPhase) {
        Pair[] pairArr = new Pair[5];
        Period billingPeriod = pricingPhase.getBillingPeriod();
        String str = null;
        pairArr[0] = TuplesKt.to("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        pairArr[1] = TuplesKt.to("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier());
        pairArr[2] = TuplesKt.to("billingCycleCount", pricingPhase.getBillingCycleCount());
        pairArr[3] = TuplesKt.to(b.x, mapPrice(pricingPhase.getPrice()));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        if (offerPaymentMode != null) {
            str = offerPaymentMode.toString();
        }
        pairArr[4] = TuplesKt.to("offerPaymentMode", str);
        return MapsKt.mapOf(pairArr);
    }

    private static final Map<String, Object> mapPrice(Price price) {
        return MapsKt.mapOf(TuplesKt.to("formatted", price.getFormatted()), TuplesKt.to("amountMicros", Long.valueOf(price.getAmountMicros())), TuplesKt.to("currencyCode", price.getCurrencyCode()));
    }
}
