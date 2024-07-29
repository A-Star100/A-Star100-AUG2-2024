package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.android.billingclient.api.ProductDetails;
import com.facebook.hermes.intl.Constants;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bs\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016Bk\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0018B-\b\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0000\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001bB\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010\u001cJ\t\u0010=\u001a\u00020\u0003HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\t\u0010?\u001a\u00020\u0013HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0015HÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010C\u001a\u00020\u0006HÆ\u0003J\t\u0010D\u001a\u00020\bHÆ\u0003J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0003HÆ\u0003J\t\u0010G\u001a\u00020\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÆ\u0001J\u0010\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0003H\u0017J\u0012\u0010M\u001a\u00020\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0013\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QHÖ\u0003J\u0012\u0010R\u001a\u0004\u0018\u00010\u00032\u0006\u0010S\u001a\u00020TH\u0016J\t\u0010U\u001a\u00020VHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0014\u0010\"\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u001eR\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001eR\u0014\u00101\u001a\u0002028VX\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u001a\u00105\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b6\u0010*\u001a\u0004\b7\u0010\u001eR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0014\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b;\u0010<¨\u0006X"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "productId", "", "basePlanId", "type", "Lcom/revenuecat/purchases/ProductType;", "price", "Lcom/revenuecat/purchases/models/Price;", "name", "title", "description", "period", "Lcom/revenuecat/purchases/models/Period;", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "presentedOfferingIdentifier", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;)V", "otherProduct", "subscriptionOptionsWithOfferingId", "(Lcom/revenuecat/purchases/models/GoogleStoreProduct;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Lcom/revenuecat/purchases/models/Price;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getBasePlanId", "()Ljava/lang/String;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "id", "getId", "getName", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku$annotations", "getSku", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "equals", "", "other", "", "formattedPricePerMonth", "locale", "Ljava/util/Locale;", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GoogleStoreProduct.kt */
public final class GoogleStoreProduct implements StoreProduct {
    private final String basePlanId;
    private final SubscriptionOption defaultOption;
    private final String description;
    private final String name;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final String presentedOfferingIdentifier;
    private final Price price;
    private final ProductDetails productDetails;
    private final String productId;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @kotlin.ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleStoreProduct(java.lang.String r18, java.lang.String r19, com.revenuecat.purchases.ProductType r20, com.revenuecat.purchases.models.Price r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, com.revenuecat.purchases.models.Period r25, com.revenuecat.purchases.models.SubscriptionOptions r26, com.revenuecat.purchases.models.SubscriptionOption r27, com.android.billingclient.api.ProductDetails r28) {
        /*
            r17 = this;
            java.lang.String r0 = "productId"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "type"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "price"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "name"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "title"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "description"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "productDetails"
            r12 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r13 = 0
            r14 = 0
            r15 = 6144(0x1800, float:8.61E-42)
            r16 = 0
            r1 = r17
            r3 = r19
            r9 = r25
            r10 = r26
            r11 = r27
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleStoreProduct.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.ProductType, com.revenuecat.purchases.models.Price, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, com.android.billingclient.api.ProductDetails):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @kotlin.ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleStoreProduct(java.lang.String r18, java.lang.String r19, com.revenuecat.purchases.ProductType r20, com.revenuecat.purchases.models.Price r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, com.revenuecat.purchases.models.Period r25, com.revenuecat.purchases.models.SubscriptionOptions r26, com.revenuecat.purchases.models.SubscriptionOption r27, com.android.billingclient.api.ProductDetails r28, java.lang.String r29) {
        /*
            r17 = this;
            java.lang.String r0 = "productId"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "type"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "price"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "name"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "title"
            r7 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "description"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "productDetails"
            r12 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r14 = 0
            r15 = 4096(0x1000, float:5.74E-42)
            r16 = 0
            r1 = r17
            r3 = r19
            r9 = r25
            r10 = r26
            r11 = r27
            r13 = r29
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleStoreProduct.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.ProductType, com.revenuecat.purchases.models.Price, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, com.android.billingclient.api.ProductDetails, java.lang.String):void");
    }

    public static /* synthetic */ GoogleStoreProduct copy$default(GoogleStoreProduct googleStoreProduct, String str, String str2, ProductType productType, Price price2, String str3, String str4, String str5, Period period2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, ProductDetails productDetails2, String str6, PresentedOfferingContext presentedOfferingContext2, int i, Object obj) {
        GoogleStoreProduct googleStoreProduct2 = googleStoreProduct;
        int i2 = i;
        return googleStoreProduct.copy((i2 & 1) != 0 ? googleStoreProduct2.productId : str, (i2 & 2) != 0 ? googleStoreProduct2.basePlanId : str2, (i2 & 4) != 0 ? googleStoreProduct.getType() : productType, (i2 & 8) != 0 ? googleStoreProduct.getPrice() : price2, (i2 & 16) != 0 ? googleStoreProduct.getName() : str3, (i2 & 32) != 0 ? googleStoreProduct.getTitle() : str4, (i2 & 64) != 0 ? googleStoreProduct.getDescription() : str5, (i2 & 128) != 0 ? googleStoreProduct.getPeriod() : period2, (i2 & 256) != 0 ? googleStoreProduct.getSubscriptionOptions() : subscriptionOptions2, (i2 & 512) != 0 ? googleStoreProduct.getDefaultOption() : subscriptionOption, (i2 & 1024) != 0 ? googleStoreProduct2.productDetails : productDetails2, (i2 & 2048) != 0 ? googleStoreProduct.getPresentedOfferingIdentifier() : str6, (i2 & 4096) != 0 ? googleStoreProduct.getPresentedOfferingContext() : presentedOfferingContext2);
    }

    @Deprecated(message = "Use presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated(message = "Replaced with productId", replaceWith = @ReplaceWith(expression = "productId", imports = {}))
    public static /* synthetic */ void getSku$annotations() {
    }

    public final String component1() {
        return this.productId;
    }

    public final SubscriptionOption component10() {
        return getDefaultOption();
    }

    public final ProductDetails component11() {
        return this.productDetails;
    }

    public final String component12() {
        return getPresentedOfferingIdentifier();
    }

    public final PresentedOfferingContext component13() {
        return getPresentedOfferingContext();
    }

    public final String component2() {
        return this.basePlanId;
    }

    public final ProductType component3() {
        return getType();
    }

    public final Price component4() {
        return getPrice();
    }

    public final String component5() {
        return getName();
    }

    public final String component6() {
        return getTitle();
    }

    public final String component7() {
        return getDescription();
    }

    public final Period component8() {
        return getPeriod();
    }

    public final SubscriptionOptions component9() {
        return getSubscriptionOptions();
    }

    public final GoogleStoreProduct copy(String str, String str2, ProductType productType, Price price2, String str3, String str4, String str5, Period period2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, ProductDetails productDetails2, String str6, PresentedOfferingContext presentedOfferingContext2) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str7, "productId");
        ProductType productType2 = productType;
        Intrinsics.checkNotNullParameter(productType2, "type");
        Price price3 = price2;
        Intrinsics.checkNotNullParameter(price3, b.x);
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "name");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, "title");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, b.c);
        ProductDetails productDetails3 = productDetails2;
        Intrinsics.checkNotNullParameter(productDetails3, "productDetails");
        return new GoogleStoreProduct(str7, str2, productType2, price3, str8, str9, str10, period2, subscriptionOptions2, subscriptionOption, productDetails3, str6, presentedOfferingContext2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleStoreProduct)) {
            return false;
        }
        GoogleStoreProduct googleStoreProduct = (GoogleStoreProduct) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) googleStoreProduct.productId) && Intrinsics.areEqual((Object) this.basePlanId, (Object) googleStoreProduct.basePlanId) && getType() == googleStoreProduct.getType() && Intrinsics.areEqual((Object) getPrice(), (Object) googleStoreProduct.getPrice()) && Intrinsics.areEqual((Object) getName(), (Object) googleStoreProduct.getName()) && Intrinsics.areEqual((Object) getTitle(), (Object) googleStoreProduct.getTitle()) && Intrinsics.areEqual((Object) getDescription(), (Object) googleStoreProduct.getDescription()) && Intrinsics.areEqual((Object) getPeriod(), (Object) googleStoreProduct.getPeriod()) && Intrinsics.areEqual((Object) getSubscriptionOptions(), (Object) googleStoreProduct.getSubscriptionOptions()) && Intrinsics.areEqual((Object) getDefaultOption(), (Object) googleStoreProduct.getDefaultOption()) && Intrinsics.areEqual((Object) this.productDetails, (Object) googleStoreProduct.productDetails) && Intrinsics.areEqual((Object) getPresentedOfferingIdentifier(), (Object) googleStoreProduct.getPresentedOfferingIdentifier()) && Intrinsics.areEqual((Object) getPresentedOfferingContext(), (Object) googleStoreProduct.getPresentedOfferingContext());
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    public String getDescription() {
        return this.description;
    }

    public String getName() {
        return this.name;
    }

    public Period getPeriod() {
        return this.period;
    }

    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public String getPresentedOfferingIdentifier() {
        return this.presentedOfferingIdentifier;
    }

    public Price getPrice() {
        return this.price;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final String getProductId() {
        return this.productId;
    }

    public String getSku() {
        return this.productId;
    }

    public SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    public String getTitle() {
        return this.title;
    }

    public ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.productId.hashCode() * 31;
        String str = this.basePlanId;
        int i = 0;
        int hashCode2 = (((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + getType().hashCode()) * 31) + getPrice().hashCode()) * 31) + getName().hashCode()) * 31) + getTitle().hashCode()) * 31) + getDescription().hashCode()) * 31) + (getPeriod() == null ? 0 : getPeriod().hashCode())) * 31) + (getSubscriptionOptions() == null ? 0 : getSubscriptionOptions().hashCode())) * 31) + (getDefaultOption() == null ? 0 : getDefaultOption().hashCode())) * 31) + this.productDetails.hashCode()) * 31) + (getPresentedOfferingIdentifier() == null ? 0 : getPresentedOfferingIdentifier().hashCode())) * 31;
        if (getPresentedOfferingContext() != null) {
            i = getPresentedOfferingContext().hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GoogleStoreProduct(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", type=" + getType() + ", price=" + getPrice() + ", name=" + getName() + ", title=" + getTitle() + ", description=" + getDescription() + ", period=" + getPeriod() + ", subscriptionOptions=" + getSubscriptionOptions() + ", defaultOption=" + getDefaultOption() + ", productDetails=" + this.productDetails + ", presentedOfferingIdentifier=" + getPresentedOfferingIdentifier() + ", presentedOfferingContext=" + getPresentedOfferingContext() + ')';
    }

    @Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    public GoogleStoreProduct(String str, String str2, ProductType productType, Price price2, String str3, String str4, String str5, Period period2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, ProductDetails productDetails2, String str6, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(productType, "type");
        Intrinsics.checkNotNullParameter(price2, b.x);
        Intrinsics.checkNotNullParameter(str3, "name");
        Intrinsics.checkNotNullParameter(str4, "title");
        Intrinsics.checkNotNullParameter(str5, b.c);
        Intrinsics.checkNotNullParameter(productDetails2, "productDetails");
        this.productId = str;
        this.basePlanId = str2;
        this.type = productType;
        this.price = price2;
        this.name = str3;
        this.title = str4;
        this.description = str5;
        this.period = period2;
        this.subscriptionOptions = subscriptionOptions2;
        this.defaultOption = subscriptionOption;
        this.productDetails = productDetails2;
        this.presentedOfferingIdentifier = str6;
        this.presentedOfferingContext = presentedOfferingContext2;
    }

    public Price pricePerMonth(Locale locale) {
        return StoreProduct.DefaultImpls.pricePerMonth(this, locale);
    }

    public Price pricePerWeek(Locale locale) {
        return StoreProduct.DefaultImpls.pricePerWeek(this, locale);
    }

    public Price pricePerYear(Locale locale) {
        return StoreProduct.DefaultImpls.pricePerYear(this, locale);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GoogleStoreProduct(java.lang.String r18, java.lang.String r19, com.revenuecat.purchases.ProductType r20, com.revenuecat.purchases.models.Price r21, java.lang.String r22, java.lang.String r23, java.lang.String r24, com.revenuecat.purchases.models.Period r25, com.revenuecat.purchases.models.SubscriptionOptions r26, com.revenuecat.purchases.models.SubscriptionOption r27, com.android.billingclient.api.ProductDetails r28, java.lang.String r29, com.revenuecat.purchases.PresentedOfferingContext r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
        /*
            r17 = this;
            r0 = r31
            r1 = r0 & 2048(0x800, float:2.87E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r15 = r2
            goto L_0x000b
        L_0x0009:
            r15 = r29
        L_0x000b:
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L_0x0012
            r16 = r2
            goto L_0x0014
        L_0x0012:
            r16 = r30
        L_0x0014:
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r13 = r27
            r14 = r28
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (com.revenuecat.purchases.ProductType) r6, (com.revenuecat.purchases.models.Price) r7, (java.lang.String) r8, (java.lang.String) r9, (java.lang.String) r10, (com.revenuecat.purchases.models.Period) r11, (com.revenuecat.purchases.models.SubscriptionOptions) r12, (com.revenuecat.purchases.models.SubscriptionOption) r13, (com.android.billingclient.api.ProductDetails) r14, (java.lang.String) r15, (com.revenuecat.purchases.PresentedOfferingContext) r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleStoreProduct.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.ProductType, com.revenuecat.purchases.models.Price, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, com.android.billingclient.api.ProductDetails, java.lang.String, com.revenuecat.purchases.PresentedOfferingContext, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price2, String str3, String str4, String str5, Period period2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, ProductDetails productDetails2, PresentedOfferingContext presentedOfferingContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price2, str3, str4, str5, period2, subscriptionOptions2, subscriptionOption, productDetails2, (i & 2048) != 0 ? null : presentedOfferingContext2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleStoreProduct(java.lang.String r16, java.lang.String r17, com.revenuecat.purchases.ProductType r18, com.revenuecat.purchases.models.Price r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.revenuecat.purchases.models.Period r23, com.revenuecat.purchases.models.SubscriptionOptions r24, com.revenuecat.purchases.models.SubscriptionOption r25, com.android.billingclient.api.ProductDetails r26, com.revenuecat.purchases.PresentedOfferingContext r27) {
        /*
            r15 = this;
            java.lang.String r0 = "productId"
            r2 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "type"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "price"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "name"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "title"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "description"
            r8 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "productDetails"
            r12 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            if (r27 == 0) goto L_0x0038
            java.lang.String r0 = r27.getOfferingIdentifier()
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            r13 = r0
            r1 = r15
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r7 = r21
            r8 = r22
            r9 = r23
            r10 = r24
            r11 = r25
            r12 = r26
            r14 = r27
            r1.<init>((java.lang.String) r2, (java.lang.String) r3, (com.revenuecat.purchases.ProductType) r4, (com.revenuecat.purchases.models.Price) r5, (java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r8, (com.revenuecat.purchases.models.Period) r9, (com.revenuecat.purchases.models.SubscriptionOptions) r10, (com.revenuecat.purchases.models.SubscriptionOption) r11, (com.android.billingclient.api.ProductDetails) r12, (java.lang.String) r13, (com.revenuecat.purchases.PresentedOfferingContext) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleStoreProduct.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.ProductType, com.revenuecat.purchases.models.Price, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, com.android.billingclient.api.ProductDetails, com.revenuecat.purchases.PresentedOfferingContext):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoogleStoreProduct(String str, String str2, ProductType productType, Price price2, String str3, String str4, Period period2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, ProductDetails productDetails2, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, productType, price2, str3, str4, period2, subscriptionOptions2, subscriptionOption, productDetails2, (i & 1024) != 0 ? null : str5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Replaced with constructor that takes a name", replaceWith = @kotlin.ReplaceWith(expression = "GoogleStoreProduct(productId, basePlanId, type, price, name, title, description, period, subscriptionOptions, defaultOption, productDetails, presentedOfferingIdentifier)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleStoreProduct(java.lang.String r16, java.lang.String r17, com.revenuecat.purchases.ProductType r18, com.revenuecat.purchases.models.Price r19, java.lang.String r20, java.lang.String r21, com.revenuecat.purchases.models.Period r22, com.revenuecat.purchases.models.SubscriptionOptions r23, com.revenuecat.purchases.models.SubscriptionOption r24, com.android.billingclient.api.ProductDetails r25, java.lang.String r26) {
        /*
            r15 = this;
            r0 = r26
            java.lang.String r1 = "productId"
            r3 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "type"
            r5 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "price"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "title"
            r8 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "description"
            r9 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "productDetails"
            r13 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            if (r0 == 0) goto L_0x0035
            com.revenuecat.purchases.PresentedOfferingContext r1 = new com.revenuecat.purchases.PresentedOfferingContext
            r1.<init>(r0)
            r14 = r1
            goto L_0x0037
        L_0x0035:
            r0 = 0
            r14 = r0
        L_0x0037:
            r2 = r15
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r20
            r9 = r21
            r10 = r22
            r11 = r23
            r12 = r24
            r13 = r25
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (com.revenuecat.purchases.ProductType) r5, (com.revenuecat.purchases.models.Price) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String) r9, (com.revenuecat.purchases.models.Period) r10, (com.revenuecat.purchases.models.SubscriptionOptions) r11, (com.revenuecat.purchases.models.SubscriptionOption) r12, (com.android.billingclient.api.ProductDetails) r13, (com.revenuecat.purchases.PresentedOfferingContext) r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleStoreProduct.<init>(java.lang.String, java.lang.String, com.revenuecat.purchases.ProductType, com.revenuecat.purchases.models.Price, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, com.android.billingclient.api.ProductDetails, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private GoogleStoreProduct(com.revenuecat.purchases.models.GoogleStoreProduct r14, com.revenuecat.purchases.models.SubscriptionOption r15, com.revenuecat.purchases.models.SubscriptionOptions r16, com.revenuecat.purchases.PresentedOfferingContext r17) {
        /*
            r13 = this;
            r0 = r14
            java.lang.String r1 = r0.productId
            java.lang.String r2 = r0.basePlanId
            com.revenuecat.purchases.ProductType r3 = r14.getType()
            com.revenuecat.purchases.models.Price r4 = r14.getPrice()
            java.lang.String r5 = r14.getName()
            java.lang.String r6 = r14.getTitle()
            java.lang.String r7 = r14.getDescription()
            com.revenuecat.purchases.models.Period r8 = r14.getPeriod()
            com.android.billingclient.api.ProductDetails r11 = r0.productDetails
            r0 = r13
            r9 = r16
            r10 = r15
            r12 = r17
            r0.<init>((java.lang.String) r1, (java.lang.String) r2, (com.revenuecat.purchases.ProductType) r3, (com.revenuecat.purchases.models.Price) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (com.revenuecat.purchases.models.Period) r8, (com.revenuecat.purchases.models.SubscriptionOptions) r9, (com.revenuecat.purchases.models.SubscriptionOption) r10, (com.android.billingclient.api.ProductDetails) r11, (com.revenuecat.purchases.PresentedOfferingContext) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleStoreProduct.<init>(com.revenuecat.purchases.models.GoogleStoreProduct, com.revenuecat.purchases.models.SubscriptionOption, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.PresentedOfferingContext):void");
    }

    public String getId() {
        if (this.basePlanId != null) {
            String str = this.productId + AbstractJsonLexerKt.COLON + this.basePlanId;
            if (str != null) {
                return str;
            }
        }
        return this.productId;
    }

    public PurchasingData getPurchasingData() {
        if (getType() != ProductType.SUBS || getDefaultOption() == null) {
            return new GooglePurchasingData.InAppProduct(getId(), this.productDetails);
        }
        return getDefaultOption().getPurchasingData();
    }

    @Deprecated(message = "Use copyWithPresentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "copyWithPresentedOfferingContext(presentedOfferingContext)", imports = {}))
    public StoreProduct copyWithOfferingId(String str) {
        PresentedOfferingContext presentedOfferingContext2;
        Intrinsics.checkNotNullParameter(str, "offeringId");
        PresentedOfferingContext presentedOfferingContext3 = getPresentedOfferingContext();
        if (presentedOfferingContext3 == null || (presentedOfferingContext2 = presentedOfferingContext3.copy(str)) == null) {
            presentedOfferingContext2 = new PresentedOfferingContext(str);
        }
        return copyWithPresentedOfferingContext(presentedOfferingContext2);
    }

    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext2) {
        List list;
        SubscriptionOptions<SubscriptionOption> subscriptionOptions2 = getSubscriptionOptions();
        SubscriptionOptions subscriptionOptions3 = null;
        if (subscriptionOptions2 != null) {
            Collection arrayList = new ArrayList();
            for (SubscriptionOption subscriptionOption : subscriptionOptions2) {
                GoogleSubscriptionOption googleSubscriptionOption = subscriptionOption instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) subscriptionOption : null;
                GoogleSubscriptionOption googleSubscriptionOption2 = googleSubscriptionOption != null ? new GoogleSubscriptionOption(googleSubscriptionOption, presentedOfferingContext2) : null;
                if (googleSubscriptionOption2 != null) {
                    arrayList.add(googleSubscriptionOption2);
                }
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        SubscriptionOption defaultOption2 = getDefaultOption();
        GoogleSubscriptionOption googleSubscriptionOption3 = defaultOption2 instanceof GoogleSubscriptionOption ? (GoogleSubscriptionOption) defaultOption2 : null;
        SubscriptionOption googleSubscriptionOption4 = googleSubscriptionOption3 != null ? new GoogleSubscriptionOption(googleSubscriptionOption3, presentedOfferingContext2) : null;
        if (list != null) {
            subscriptionOptions3 = new SubscriptionOptions(list);
        }
        return new GoogleStoreProduct(this, googleSubscriptionOption4, subscriptionOptions3, presentedOfferingContext2);
    }

    public String formattedPricePerMonth(Locale locale) {
        SubscriptionOption basePlan;
        List<PricingPhase> pricingPhases;
        PricingPhase pricingPhase;
        Intrinsics.checkNotNullParameter(locale, Constants.LOCALE);
        SubscriptionOptions subscriptionOptions2 = getSubscriptionOptions();
        if (subscriptionOptions2 == null || (basePlan = subscriptionOptions2.getBasePlan()) == null || (pricingPhases = basePlan.getPricingPhases()) == null || (pricingPhase = (PricingPhase) CollectionsKt.last(pricingPhases)) == null) {
            return null;
        }
        return pricingPhase.formattedPriceInMonths(locale);
    }
}
