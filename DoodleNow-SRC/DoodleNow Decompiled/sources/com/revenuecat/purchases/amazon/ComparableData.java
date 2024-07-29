package com.revenuecat.purchases.amazon;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004Bg\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\t\u0010*\u001a\u00020\u0006HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010-\u001a\u00020\bHÆ\u0003J\t\u0010.\u001a\u00020\u0006HÆ\u0003J\t\u0010/\u001a\u00020\u0006HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0012HÆ\u0003J\t\u00104\u001a\u00020\u0006HÆ\u0003J\u0001\u00105\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÆ\u0001J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020:HÖ\u0001J\t\u0010;\u001a\u00020\u0006HÖ\u0001R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001dR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)¨\u0006<"}, d2 = {"Lcom/revenuecat/purchases/amazon/ComparableData;", "", "amazonStoreProduct", "Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;", "(Lcom/revenuecat/purchases/amazon/AmazonStoreProduct;)V", "id", "", "type", "Lcom/revenuecat/purchases/ProductType;", "title", "description", "period", "Lcom/revenuecat/purchases/models/Period;", "price", "Lcom/revenuecat/purchases/models/Price;", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "iconUrl", "freeTrialPeriod", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Lcom/revenuecat/purchases/ProductType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/SubscriptionOptions;Lcom/revenuecat/purchases/models/SubscriptionOption;Ljava/lang/String;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "()Ljava/lang/String;", "getFreeTrialPeriod", "()Lcom/revenuecat/purchases/models/Period;", "getIconUrl", "getId", "getPeriod", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AmazonStoreProduct.kt */
final class ComparableData {
    private final SubscriptionOption defaultOption;
    private final String description;
    private final Period freeTrialPeriod;
    private final String iconUrl;
    private final String id;
    private final Period period;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Price price;
    private final SubscriptionOptions subscriptionOptions;
    private final String title;
    private final ProductType type;

    public static /* synthetic */ ComparableData copy$default(ComparableData comparableData, String str, ProductType productType, String str2, String str3, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str4, Period period3, PresentedOfferingContext presentedOfferingContext2, int i, Object obj) {
        ComparableData comparableData2 = comparableData;
        int i2 = i;
        return comparableData.copy((i2 & 1) != 0 ? comparableData2.id : str, (i2 & 2) != 0 ? comparableData2.type : productType, (i2 & 4) != 0 ? comparableData2.title : str2, (i2 & 8) != 0 ? comparableData2.description : str3, (i2 & 16) != 0 ? comparableData2.period : period2, (i2 & 32) != 0 ? comparableData2.price : price2, (i2 & 64) != 0 ? comparableData2.subscriptionOptions : subscriptionOptions2, (i2 & 128) != 0 ? comparableData2.defaultOption : subscriptionOption, (i2 & 256) != 0 ? comparableData2.iconUrl : str4, (i2 & 512) != 0 ? comparableData2.freeTrialPeriod : period3, (i2 & 1024) != 0 ? comparableData2.presentedOfferingContext : presentedOfferingContext2);
    }

    public final String component1() {
        return this.id;
    }

    public final Period component10() {
        return this.freeTrialPeriod;
    }

    public final PresentedOfferingContext component11() {
        return this.presentedOfferingContext;
    }

    public final ProductType component2() {
        return this.type;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.description;
    }

    public final Period component5() {
        return this.period;
    }

    public final Price component6() {
        return this.price;
    }

    public final SubscriptionOptions component7() {
        return this.subscriptionOptions;
    }

    public final SubscriptionOption component8() {
        return this.defaultOption;
    }

    public final String component9() {
        return this.iconUrl;
    }

    public final ComparableData copy(String str, ProductType productType, String str2, String str3, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str4, Period period3, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(productType, "type");
        String str5 = str2;
        Intrinsics.checkNotNullParameter(str5, "title");
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str6, b.c);
        Price price3 = price2;
        Intrinsics.checkNotNullParameter(price3, b.x);
        String str7 = str4;
        Intrinsics.checkNotNullParameter(str7, b.j);
        return new ComparableData(str, productType, str5, str6, period2, price3, subscriptionOptions2, subscriptionOption, str7, period3, presentedOfferingContext2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComparableData)) {
            return false;
        }
        ComparableData comparableData = (ComparableData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) comparableData.id) && this.type == comparableData.type && Intrinsics.areEqual((Object) this.title, (Object) comparableData.title) && Intrinsics.areEqual((Object) this.description, (Object) comparableData.description) && Intrinsics.areEqual((Object) this.period, (Object) comparableData.period) && Intrinsics.areEqual((Object) this.price, (Object) comparableData.price) && Intrinsics.areEqual((Object) this.subscriptionOptions, (Object) comparableData.subscriptionOptions) && Intrinsics.areEqual((Object) this.defaultOption, (Object) comparableData.defaultOption) && Intrinsics.areEqual((Object) this.iconUrl, (Object) comparableData.iconUrl) && Intrinsics.areEqual((Object) this.freeTrialPeriod, (Object) comparableData.freeTrialPeriod) && Intrinsics.areEqual((Object) this.presentedOfferingContext, (Object) comparableData.presentedOfferingContext);
    }

    public final SubscriptionOption getDefaultOption() {
        return this.defaultOption;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Period getFreeTrialPeriod() {
        return this.freeTrialPeriod;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getId() {
        return this.id;
    }

    public final Period getPeriod() {
        return this.period;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final Price getPrice() {
        return this.price;
    }

    public final SubscriptionOptions getSubscriptionOptions() {
        return this.subscriptionOptions;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.type.hashCode()) * 31) + this.title.hashCode()) * 31) + this.description.hashCode()) * 31;
        Period period2 = this.period;
        int i = 0;
        int hashCode2 = (((hashCode + (period2 == null ? 0 : period2.hashCode())) * 31) + this.price.hashCode()) * 31;
        SubscriptionOptions subscriptionOptions2 = this.subscriptionOptions;
        int hashCode3 = (hashCode2 + (subscriptionOptions2 == null ? 0 : subscriptionOptions2.hashCode())) * 31;
        SubscriptionOption subscriptionOption = this.defaultOption;
        int hashCode4 = (((hashCode3 + (subscriptionOption == null ? 0 : subscriptionOption.hashCode())) * 31) + this.iconUrl.hashCode()) * 31;
        Period period3 = this.freeTrialPeriod;
        int hashCode5 = (hashCode4 + (period3 == null ? 0 : period3.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext2 = this.presentedOfferingContext;
        if (presentedOfferingContext2 != null) {
            i = presentedOfferingContext2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "ComparableData(id=" + this.id + ", type=" + this.type + ", title=" + this.title + ", description=" + this.description + ", period=" + this.period + ", price=" + this.price + ", subscriptionOptions=" + this.subscriptionOptions + ", defaultOption=" + this.defaultOption + ", iconUrl=" + this.iconUrl + ", freeTrialPeriod=" + this.freeTrialPeriod + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    public ComparableData(String str, ProductType productType, String str2, String str3, Period period2, Price price2, SubscriptionOptions subscriptionOptions2, SubscriptionOption subscriptionOption, String str4, Period period3, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(productType, "type");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, b.c);
        Intrinsics.checkNotNullParameter(price2, b.x);
        Intrinsics.checkNotNullParameter(str4, b.j);
        this.id = str;
        this.type = productType;
        this.title = str2;
        this.description = str3;
        this.period = period2;
        this.price = price2;
        this.subscriptionOptions = subscriptionOptions2;
        this.defaultOption = subscriptionOption;
        this.iconUrl = str4;
        this.freeTrialPeriod = period3;
        this.presentedOfferingContext = presentedOfferingContext2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComparableData(AmazonStoreProduct amazonStoreProduct) {
        this(amazonStoreProduct.getId(), amazonStoreProduct.getType(), amazonStoreProduct.getTitle(), amazonStoreProduct.getDescription(), amazonStoreProduct.getPeriod(), amazonStoreProduct.getPrice(), amazonStoreProduct.getSubscriptionOptions(), amazonStoreProduct.getDefaultOption(), amazonStoreProduct.getIconUrl(), amazonStoreProduct.getFreeTrialPeriod(), amazonStoreProduct.getPresentedOfferingContext());
        Intrinsics.checkNotNullParameter(amazonStoreProduct, "amazonStoreProduct");
    }
}
