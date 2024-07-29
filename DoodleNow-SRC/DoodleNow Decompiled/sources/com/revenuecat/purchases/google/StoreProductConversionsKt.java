package com.revenuecat.purchases.google;

import com.amazon.a.a.o.b;
import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0000\u001a\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001a\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b*\b\u0012\u0004\u0012\u00020\u00020\bH\u0000¨\u0006\u000b"}, d2 = {"createOneTimeProductPrice", "Lcom/revenuecat/purchases/models/Price;", "Lcom/android/billingclient/api/ProductDetails;", "toInAppStoreProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "toStoreProduct", "Lcom/revenuecat/purchases/models/GoogleStoreProduct;", "offerDetails", "", "Lcom/android/billingclient/api/ProductDetails$SubscriptionOfferDetails;", "toStoreProducts", "purchases_defaultsRelease"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: storeProductConversions.kt */
public final class StoreProductConversionsKt {
    public static final StoreProduct toInAppStoreProduct(ProductDetails productDetails) {
        Intrinsics.checkNotNullParameter(productDetails, "<this>");
        return toStoreProduct(productDetails, CollectionsKt.emptyList());
    }

    public static final GoogleStoreProduct toStoreProduct(ProductDetails productDetails, List<ProductDetails.SubscriptionOfferDetails> list) {
        SubscriptionOptions subscriptionOptions;
        Price price;
        SubscriptionOption subscriptionOption;
        PricingPhase fullPricePhase;
        ProductDetails productDetails2 = productDetails;
        List<ProductDetails.SubscriptionOfferDetails> list2 = list;
        Intrinsics.checkNotNullParameter(productDetails, "<this>");
        Intrinsics.checkNotNullParameter(list2, "offerDetails");
        if (ProductTypeConversionsKt.toRevenueCatProductType(productDetails.getProductType()) == ProductType.SUBS) {
            Iterable<ProductDetails.SubscriptionOfferDetails> iterable = list2;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ProductDetails.SubscriptionOfferDetails subscriptionOption2 : iterable) {
                String productId = productDetails.getProductId();
                Intrinsics.checkNotNullExpressionValue(productId, "productId");
                arrayList.add(SubscriptionOptionConversionsKt.toSubscriptionOption(subscriptionOption2, productId, productDetails));
            }
            subscriptionOptions = new SubscriptionOptions((List) arrayList);
        } else {
            subscriptionOptions = null;
        }
        SubscriptionOption basePlan = subscriptionOptions != null ? subscriptionOptions.getBasePlan() : null;
        Price price2 = (basePlan == null || (fullPricePhase = basePlan.getFullPricePhase()) == null) ? null : fullPricePhase.getPrice();
        Price createOneTimeProductPrice = createOneTimeProductPrice(productDetails);
        if (createOneTimeProductPrice != null) {
            price = createOneTimeProductPrice;
        } else if (price2 == null) {
            return null;
        } else {
            price = price2;
        }
        String productId2 = productDetails.getProductId();
        Intrinsics.checkNotNullExpressionValue(productId2, "productId");
        String id = basePlan != null ? basePlan.getId() : null;
        ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(productDetails.getProductType());
        String name = productDetails.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        String title = productDetails.getTitle();
        Intrinsics.checkNotNullExpressionValue(title, "title");
        String description = productDetails.getDescription();
        Intrinsics.checkNotNullExpressionValue(description, b.c);
        Period billingPeriod = basePlan != null ? basePlan.getBillingPeriod() : null;
        if (subscriptionOptions != null) {
            subscriptionOption = subscriptionOptions.getDefaultOffer();
        } else {
            subscriptionOption = null;
        }
        return new GoogleStoreProduct(productId2, id, revenueCatProductType, price, name, title, description, billingPeriod, subscriptionOptions, subscriptionOption, productDetails, (PresentedOfferingContext) null);
    }

    private static final Price createOneTimeProductPrice(ProductDetails productDetails) {
        ProductDetails.OneTimePurchaseOfferDetails oneTimePurchaseOfferDetails;
        if (ProductTypeConversionsKt.toRevenueCatProductType(productDetails.getProductType()) != ProductType.INAPP || (oneTimePurchaseOfferDetails = productDetails.getOneTimePurchaseOfferDetails()) == null) {
            return null;
        }
        String formattedPrice = oneTimePurchaseOfferDetails.getFormattedPrice();
        Intrinsics.checkNotNullExpressionValue(formattedPrice, "it.formattedPrice");
        long priceAmountMicros = oneTimePurchaseOfferDetails.getPriceAmountMicros();
        String priceCurrencyCode = oneTimePurchaseOfferDetails.getPriceCurrencyCode();
        Intrinsics.checkNotNullExpressionValue(priceCurrencyCode, "it.priceCurrencyCode");
        return new Price(formattedPrice, priceAmountMicros, priceCurrencyCode);
    }

    public static final List<StoreProduct> toStoreProducts(List<ProductDetails> list) {
        List<ProductDetails.SubscriptionOfferDetails> list2;
        Map map;
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<StoreProduct> arrayList = new ArrayList<>();
        for (ProductDetails productDetails : list) {
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails = productDetails.getSubscriptionOfferDetails();
            if (subscriptionOfferDetails != null) {
                Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails, "subscriptionOfferDetails");
                Collection arrayList2 = new ArrayList();
                for (Object next : subscriptionOfferDetails) {
                    ProductDetails.SubscriptionOfferDetails subscriptionOfferDetails2 = (ProductDetails.SubscriptionOfferDetails) next;
                    Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails2, "it");
                    if (SubscriptionOptionConversionsKt.isBasePlan(subscriptionOfferDetails2)) {
                        arrayList2.add(next);
                    }
                }
                list2 = (List) arrayList2;
            } else {
                list2 = CollectionsKt.emptyList();
            }
            List<ProductDetails.SubscriptionOfferDetails> subscriptionOfferDetails3 = productDetails.getSubscriptionOfferDetails();
            if (subscriptionOfferDetails3 != null) {
                Intrinsics.checkNotNullExpressionValue(subscriptionOfferDetails3, "subscriptionOfferDetails");
                map = new LinkedHashMap();
                for (Object next2 : subscriptionOfferDetails3) {
                    String basePlanId = ((ProductDetails.SubscriptionOfferDetails) next2).getBasePlanId();
                    Object obj = map.get(basePlanId);
                    if (obj == null) {
                        obj = new ArrayList();
                        map.put(basePlanId, obj);
                    }
                    ((List) obj).add(next2);
                }
            } else {
                map = MapsKt.emptyMap();
            }
            if (list2.isEmpty()) {
                list2 = null;
            }
            if (list2 != null) {
                for (ProductDetails.SubscriptionOfferDetails basePlanId2 : list2) {
                    List list3 = (List) map.get(basePlanId2.getBasePlanId());
                    if (list3 == null) {
                        list3 = CollectionsKt.emptyList();
                    }
                    GoogleStoreProduct storeProduct = toStoreProduct(productDetails, list3);
                    if (storeProduct != null) {
                        arrayList.add(storeProduct);
                    } else {
                        LogIntent logIntent = LogIntent.RC_ERROR;
                        String format = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{productDetails.getProductId()}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
                        LogWrapperKt.log(logIntent, format);
                    }
                }
            } else {
                StoreProduct inAppStoreProduct = toInAppStoreProduct(productDetails);
                if (inAppStoreProduct != null) {
                    arrayList.add(inAppStoreProduct);
                } else {
                    LogIntent logIntent2 = LogIntent.RC_ERROR;
                    String format2 = String.format(PurchaseStrings.INVALID_PRODUCT_NO_PRICE, Arrays.copyOf(new Object[]{productDetails.getProductId()}, 1));
                    Intrinsics.checkNotNullExpressionValue(format2, "format(this, *args)");
                    LogWrapperKt.log(logIntent2, format2);
                }
            }
        }
        return arrayList;
    }
}
