package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.amazon.AmazonPurchasingData;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bs\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0015Bw\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0003¢\u0006\u0002\u0010\u0017B{\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aJ\t\u0010:\u001a\u00020\u0003HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010=\u001a\u00020\u0013HÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\t\u0010?\u001a\u00020\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0003HÆ\u0003J\t\u0010B\u001a\u00020\u0003HÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010D\u001a\u00020\u000bHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\rHÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001J\u0010\u0010H\u001a\u00020\u00012\u0006\u0010I\u001a\u00020\u0003H\u0017J\u0012\u0010J\u001a\u00020\u00012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0013\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0002J\b\u0010O\u001a\u00020PH\u0016J\t\u0010Q\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0010\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0014\u0010\u0016\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010 R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\f\u0012\u0004\b)\u0010*\u001a\u0004\b+\u0010\u001eR\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b3\u0010*\u001a\u0004\b4\u0010\u001eR\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b7\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u00109¨\u0006R"}, d2 = {"Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "id", "", "type", "Lcom/revenuecat/purchases/ProductType;", "title", "description", "period", "Lcom/revenuecat/purchases/models/Period;", "price", "Lcom/revenuecat/purchases/models/Price;", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "iconUrl", "freeTrialPeriod", "originalProductJSON", "Lorg/json/JSONObject;", "presentedOfferingIdentifier", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lorg/json/JSONObject;Ljava/lang/String;)V", "name", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lorg/json/JSONObject;Ljava/lang/String;)V", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "()Ljava/lang/String;", "getFreeTrialPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getIconUrl", "getId", "getName", "getOriginalProductJSON", "()Lorg/json/JSONObject;", "getPeriod", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "purchasingData", "Lcom/revenuecat/purchases/amazon/AmazonPurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/amazon/AmazonPurchasingData;", "sku", "getSku$annotations", "getSku", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonStoreProduct.kt */
public final class AmazonStoreProduct implements StoreProduct {
    private final SubscriptionOption defaultOption;
    private final String description;
    private final Period freeTrialPeriod;
    private final String iconUrl;
    private final String id;
    private final String name;
    private final JSONObject originalProductJSON;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Price price;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AmazonStoreProduct(java.lang.String r18, com.revenuecat.purchases.ProductType r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, com.revenuecat.purchases.models.Period r23, com.revenuecat.purchases.models.Price r24, com.revenuecat.purchases.models.SubscriptionOptions r25, com.revenuecat.purchases.models.SubscriptionOption r26, java.lang.String r27, com.revenuecat.purchases.models.Period r28, org.json.JSONObject r29) {
        /*
            r17 = this;
            java.lang.String r0 = "id"
            r2 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "type"
            r3 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "name"
            r4 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "title"
            r5 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "description"
            r6 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "price"
            r8 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "iconUrl"
            r11 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "originalProductJSON"
            r13 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r14 = 0
            r15 = 4096(0x1000, float:5.74E-42)
            r16 = 0
            r1 = r17
            r7 = r23
            r9 = r25
            r10 = r26
            r12 = r28
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonStoreProduct.<init>(java.lang.String, com.revenuecat.purchases.ProductType, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.Price, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, java.lang.String, com.revenuecat.purchases.models.Period, org.json.JSONObject):void");
    }

    public static /* synthetic */ AmazonStoreProduct copy$default(AmazonStoreProduct amazonStoreProduct, String str, ProductType productType, String str2, String str3, String str4, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str5, Period period3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2, int i, Object obj) {
        AmazonStoreProduct amazonStoreProduct2 = amazonStoreProduct;
        int i2 = i;
        return amazonStoreProduct.copy((i2 & 1) != 0 ? amazonStoreProduct.getId() : str, (i2 & 2) != 0 ? amazonStoreProduct.getType() : productType, (i2 & 4) != 0 ? amazonStoreProduct.getName() : str2, (i2 & 8) != 0 ? amazonStoreProduct.getTitle() : str3, (i2 & 16) != 0 ? amazonStoreProduct.getDescription() : str4, (i2 & 32) != 0 ? amazonStoreProduct.getPeriod() : period2, (i2 & 64) != 0 ? amazonStoreProduct.getPrice() : price2, (i2 & 128) != 0 ? amazonStoreProduct.getSubscriptionOptions() : subscriptionOptions2, (i2 & 256) != 0 ? amazonStoreProduct.getDefaultOption() : subscriptionOption, (i2 & 512) != 0 ? amazonStoreProduct2.iconUrl : str5, (i2 & 1024) != 0 ? amazonStoreProduct2.freeTrialPeriod : period3, (i2 & 2048) != 0 ? amazonStoreProduct2.originalProductJSON : jSONObject, (i2 & 4096) != 0 ? amazonStoreProduct.getPresentedOfferingContext() : presentedOfferingContext2);
    }

    @Deprecated(message = "Use presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated(message = "Replaced with id", replaceWith = @ReplaceWith(expression = "id", imports = {}))
    public static /* synthetic */ void getSku$annotations() {
    }

    public final String component1() {
        return getId();
    }

    public final String component10() {
        return this.iconUrl;
    }

    public final Period component11() {
        return this.freeTrialPeriod;
    }

    public final JSONObject component12() {
        return this.originalProductJSON;
    }

    public final PresentedOfferingContext component13() {
        return getPresentedOfferingContext();
    }

    public final ProductType component2() {
        return getType();
    }

    public final String component3() {
        return getName();
    }

    public final String component4() {
        return getTitle();
    }

    public final String component5() {
        return getDescription();
    }

    public final Period component6() {
        return getPeriod();
    }

    public final Price component7() {
        return getPrice();
    }

    public final SubscriptionOptions component8() {
        return getSubscriptionOptions();
    }

    public final SubscriptionOption component9() {
        return getDefaultOption();
    }

    public final AmazonStoreProduct copy(String str, ProductType productType, String str2, String str3, String str4, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str5, Period period3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2) {
        String str6 = str;
        Intrinsics.checkNotNullParameter(str6, "id");
        ProductType productType2 = productType;
        Intrinsics.checkNotNullParameter(productType2, "type");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "name");
        String str8 = str3;
        Intrinsics.checkNotNullParameter(str8, "title");
        String str9 = str4;
        Intrinsics.checkNotNullParameter(str9, b.c);
        Price price3 = price2;
        Intrinsics.checkNotNullParameter(price3, b.x);
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, b.j);
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(jSONObject2, "originalProductJSON");
        return new AmazonStoreProduct(str6, productType2, str7, str8, str9, period2, price3, subscriptionOptions2, subscriptionOption, str10, period3, jSONObject2, presentedOfferingContext2);
    }

    public SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    public String getDescription() {
        return this.description;
    }

    public final Period getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public final JSONObject getOriginalProductJSON() {
        return this.originalProductJSON;
    }

    public Period getPeriod() {
        return this.period;
    }

    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public Price getPrice() {
        return this.price;
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

    public String toString() {
        return "AmazonStoreProduct(id=" + getId() + ", type=" + getType() + ", name=" + getName() + ", title=" + getTitle() + ", description=" + getDescription() + ", period=" + getPeriod() + ", price=" + getPrice() + ", subscriptionOptions=" + getSubscriptionOptions() + ", defaultOption=" + getDefaultOption() + ", iconUrl=" + this.iconUrl + ", freeTrialPeriod=" + this.freeTrialPeriod + ", originalProductJSON=" + this.originalProductJSON + ", presentedOfferingContext=" + getPresentedOfferingContext() + ')';
    }

    public AmazonStoreProduct(String str, ProductType productType, String str2, String str3, String str4, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str5, Period period3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(productType, "type");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, b.c);
        Intrinsics.checkNotNullParameter(price2, b.x);
        Intrinsics.checkNotNullParameter(str5, b.j);
        Intrinsics.checkNotNullParameter(jSONObject, "originalProductJSON");
        this.id = str;
        this.type = productType;
        this.name = str2;
        this.title = str3;
        this.description = str4;
        this.period = period2;
        this.price = price2;
        this.subscriptionOptions = subscriptionOptions2;
        this.defaultOption = subscriptionOption;
        this.iconUrl = str5;
        this.freeTrialPeriod = period3;
        this.originalProductJSON = jSONObject;
        this.presentedOfferingContext = presentedOfferingContext2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmazonStoreProduct(String str, ProductType productType, String str2, String str3, String str4, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str5, Period period3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, productType, str2, str3, str4, period2, price2, subscriptionOptions2, subscriptionOption, str5, period3, jSONObject, (i & 4096) != 0 ? null : presentedOfferingContext2);
    }

    public String formattedPricePerMonth(Locale locale) {
        return StoreProduct.DefaultImpls.formattedPricePerMonth(this, locale);
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AmazonStoreProduct(String str, ProductType productType, String str2, String str3, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str4, Period period3, JSONObject jSONObject, String str5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, productType, str2, str3, period2, price2, subscriptionOptions2, subscriptionOption, str4, period3, jSONObject, (i & 2048) != 0 ? null : str5);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Replaced with constructor that takes a name", replaceWith = @kotlin.ReplaceWith(expression = "AmazonStoreProduct(productId, type, name, title, description, period, price, subscriptionOptions, defaultOption, iconUrl, freeTrialPeriod, originalProductJSON, presentedOfferingIdentifier)", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AmazonStoreProduct(java.lang.String r17, com.revenuecat.purchases.ProductType r18, java.lang.String r19, java.lang.String r20, com.revenuecat.purchases.models.Period r21, com.revenuecat.purchases.models.Price r22, com.revenuecat.purchases.models.SubscriptionOptions r23, com.revenuecat.purchases.models.SubscriptionOption r24, java.lang.String r25, com.revenuecat.purchases.models.Period r26, org.json.JSONObject r27, java.lang.String r28) {
        /*
            r16 = this;
            r0 = r28
            java.lang.String r1 = "id"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "type"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "title"
            r6 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "description"
            r7 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "price"
            r9 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "iconUrl"
            r12 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "originalProductJSON"
            r14 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            if (r0 == 0) goto L_0x003c
            com.revenuecat.purchases.PresentedOfferingContext r1 = new com.revenuecat.purchases.PresentedOfferingContext
            r1.<init>(r0)
            r15 = r1
            goto L_0x003e
        L_0x003c:
            r0 = 0
            r15 = r0
        L_0x003e:
            r2 = r16
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r14 = r27
            r2.<init>((java.lang.String) r3, (com.revenuecat.purchases.ProductType) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (com.revenuecat.purchases.models.Period) r8, (com.revenuecat.purchases.models.Price) r9, (com.revenuecat.purchases.models.SubscriptionOptions) r10, (com.revenuecat.purchases.models.SubscriptionOption) r11, (java.lang.String) r12, (com.revenuecat.purchases.models.Period) r13, (org.json.JSONObject) r14, (com.revenuecat.purchases.PresentedOfferingContext) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonStoreProduct.<init>(java.lang.String, com.revenuecat.purchases.ProductType, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.Price, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, java.lang.String, com.revenuecat.purchases.models.Period, org.json.JSONObject, java.lang.String):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Replaced with constructor that takes a presentedOfferingContext", replaceWith = @kotlin.ReplaceWith(expression = "AmazonStoreProduct(productId, type, name, title, description, period, price, subscriptionOptions, defaultOption, iconUrl, freeTrialPeriod, originalProductJSON, PresentedOfferingContext(presentedOfferingIdentifier))", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AmazonStoreProduct(java.lang.String r17, com.revenuecat.purchases.ProductType r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.revenuecat.purchases.models.Period r22, com.revenuecat.purchases.models.Price r23, com.revenuecat.purchases.models.SubscriptionOptions r24, com.revenuecat.purchases.models.SubscriptionOption r25, java.lang.String r26, com.revenuecat.purchases.models.Period r27, org.json.JSONObject r28, java.lang.String r29) {
        /*
            r16 = this;
            r0 = r29
            java.lang.String r1 = "id"
            r3 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r1)
            java.lang.String r1 = "type"
            r4 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "name"
            r5 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "title"
            r6 = r20
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            java.lang.String r1 = "description"
            r7 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "price"
            r9 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "iconUrl"
            r12 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "originalProductJSON"
            r14 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r1)
            java.lang.String r1 = "presentedOfferingIdentifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.revenuecat.purchases.PresentedOfferingContext r15 = new com.revenuecat.purchases.PresentedOfferingContext
            r15.<init>(r0)
            r2 = r16
            r8 = r22
            r10 = r24
            r11 = r25
            r13 = r27
            r2.<init>((java.lang.String) r3, (com.revenuecat.purchases.ProductType) r4, (java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r7, (com.revenuecat.purchases.models.Period) r8, (com.revenuecat.purchases.models.Price) r9, (com.revenuecat.purchases.models.SubscriptionOptions) r10, (com.revenuecat.purchases.models.SubscriptionOption) r11, (java.lang.String) r12, (com.revenuecat.purchases.models.Period) r13, (org.json.JSONObject) r14, (com.revenuecat.purchases.PresentedOfferingContext) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.amazon.AmazonStoreProduct.<init>(java.lang.String, com.revenuecat.purchases.ProductType, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.Price, com.revenuecat.purchases.models.SubscriptionOptions, com.revenuecat.purchases.models.SubscriptionOption, java.lang.String, com.revenuecat.purchases.models.Period, org.json.JSONObject, java.lang.String):void");
    }

    public AmazonPurchasingData getPurchasingData() {
        return new AmazonPurchasingData.Product(this);
    }

    public String getSku() {
        return getId();
    }

    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext2 = getPresentedOfferingContext();
        if (presentedOfferingContext2 != null) {
            return presentedOfferingContext2.getOfferingIdentifier();
        }
        return null;
    }

    @Deprecated(message = "Replaced with copyWithPresentedOfferingContext", replaceWith = @ReplaceWith(expression = "copyWithPresentedOfferingContext(PresentedOfferingContext(offeringId))", imports = {}))
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
        return new AmazonStoreProduct(getId(), getType(), getName(), getTitle(), getDescription(), getPeriod(), getPrice(), getSubscriptionOptions(), getDefaultOption(), this.iconUrl, this.freeTrialPeriod, this.originalProductJSON, presentedOfferingContext2);
    }

    public boolean equals(Object obj) {
        return (obj instanceof AmazonStoreProduct) && Intrinsics.areEqual((Object) new ComparableData(this), (Object) new ComparableData((AmazonStoreProduct) obj));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }
}
