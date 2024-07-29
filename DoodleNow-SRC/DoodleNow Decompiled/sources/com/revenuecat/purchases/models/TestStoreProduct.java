package com.revenuecat.purchases.models;

import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BI\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\fBO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000eJ\n\u00102\u001a\u0004\u0018\u00010*H\u0002J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0003HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\tHÂ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0007HÂ\u0003J_\u0010;\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0010\u0010<\u001a\u00020\u00012\u0006\u0010=\u001a\u00020\u0003H\u0017J\u0012\u0010>\u001a\u00020\u00012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0013\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BHÖ\u0003J\t\u0010C\u001a\u00020DHÖ\u0001J\t\u0010E\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u00108VX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u001a8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0014R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020$8VX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010\u0014R\u0016\u0010)\u001a\u0004\u0018\u00010*8VX\u0004¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u0014R\u0014\u0010.\u001a\u00020/8VX\u0004¢\u0006\u0006\u001a\u0004\b0\u00101¨\u0006F"}, d2 = {"Lcom/revenuecat/purchases/models/TestStoreProduct;", "Lcom/revenuecat/purchases/models/StoreProduct;", "id", "", "title", "description", "price", "Lcom/revenuecat/purchases/models/Price;", "period", "Lcom/revenuecat/purchases/models/Period;", "freeTrialPeriod", "introPrice", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;)V", "name", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/Price;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Period;Lcom/revenuecat/purchases/models/Price;)V", "defaultOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDefaultOption", "()Lcom/revenuecat/purchases/models/SubscriptionOption;", "getDescription", "()Ljava/lang/String;", "getId", "getName", "getPeriod", "()Lcom/revenuecat/purchases/models/Period;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPrice", "()Lcom/revenuecat/purchases/models/Price;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "sku", "getSku", "subscriptionOptions", "Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getSubscriptionOptions", "()Lcom/revenuecat/purchases/models/SubscriptionOptions;", "getTitle", "type", "Lcom/revenuecat/purchases/ProductType;", "getType", "()Lcom/revenuecat/purchases/ProductType;", "buildSubscriptionOptions", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "copyWithOfferingId", "offeringId", "copyWithPresentedOfferingContext", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TestStoreProduct.kt */
public final class TestStoreProduct implements StoreProduct {
    private final String description;
    private final Period freeTrialPeriod;
    private final String id;
    private final Price introPrice;
    private final String name;
    private final Period period;
    private final Price price;
    private final String title;

    private final Period component7() {
        return this.freeTrialPeriod;
    }

    private final Price component8() {
        return this.introPrice;
    }

    public static /* synthetic */ TestStoreProduct copy$default(TestStoreProduct testStoreProduct, String str, String str2, String str3, String str4, Price price2, Period period2, Period period3, Price price3, int i, Object obj) {
        TestStoreProduct testStoreProduct2 = testStoreProduct;
        int i2 = i;
        return testStoreProduct.copy((i2 & 1) != 0 ? testStoreProduct.getId() : str, (i2 & 2) != 0 ? testStoreProduct.getName() : str2, (i2 & 4) != 0 ? testStoreProduct.getTitle() : str3, (i2 & 8) != 0 ? testStoreProduct.getDescription() : str4, (i2 & 16) != 0 ? testStoreProduct.getPrice() : price2, (i2 & 32) != 0 ? testStoreProduct.getPeriod() : period2, (i2 & 64) != 0 ? testStoreProduct2.freeTrialPeriod : period3, (i2 & 128) != 0 ? testStoreProduct2.introPrice : price3);
    }

    @Deprecated(message = "Use presentedOfferingContext", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public final String component1() {
        return getId();
    }

    public final String component2() {
        return getName();
    }

    public final String component3() {
        return getTitle();
    }

    public final String component4() {
        return getDescription();
    }

    public final Price component5() {
        return getPrice();
    }

    public final Period component6() {
        return getPeriod();
    }

    public final TestStoreProduct copy(String str, String str2, String str3, String str4, Price price2, Period period2, Period period3, Price price3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, b.c);
        Intrinsics.checkNotNullParameter(price2, b.x);
        return new TestStoreProduct(str, str2, str3, str4, price2, period2, period3, price3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TestStoreProduct)) {
            return false;
        }
        TestStoreProduct testStoreProduct = (TestStoreProduct) obj;
        return Intrinsics.areEqual((Object) getId(), (Object) testStoreProduct.getId()) && Intrinsics.areEqual((Object) getName(), (Object) testStoreProduct.getName()) && Intrinsics.areEqual((Object) getTitle(), (Object) testStoreProduct.getTitle()) && Intrinsics.areEqual((Object) getDescription(), (Object) testStoreProduct.getDescription()) && Intrinsics.areEqual((Object) getPrice(), (Object) testStoreProduct.getPrice()) && Intrinsics.areEqual((Object) getPeriod(), (Object) testStoreProduct.getPeriod()) && Intrinsics.areEqual((Object) this.freeTrialPeriod, (Object) testStoreProduct.freeTrialPeriod) && Intrinsics.areEqual((Object) this.introPrice, (Object) testStoreProduct.introPrice);
    }

    public String getDescription() {
        return this.description;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public Period getPeriod() {
        return this.period;
    }

    public PresentedOfferingContext getPresentedOfferingContext() {
        return null;
    }

    public Price getPrice() {
        return this.price;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((((((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getTitle().hashCode()) * 31) + getDescription().hashCode()) * 31) + getPrice().hashCode()) * 31) + (getPeriod() == null ? 0 : getPeriod().hashCode())) * 31;
        Period period2 = this.freeTrialPeriod;
        int hashCode2 = (hashCode + (period2 == null ? 0 : period2.hashCode())) * 31;
        Price price2 = this.introPrice;
        if (price2 != null) {
            i = price2.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "TestStoreProduct(id=" + getId() + ", name=" + getName() + ", title=" + getTitle() + ", description=" + getDescription() + ", price=" + getPrice() + ", period=" + getPeriod() + ", freeTrialPeriod=" + this.freeTrialPeriod + ", introPrice=" + this.introPrice + ')';
    }

    public TestStoreProduct(String str, String str2, String str3, String str4, Price price2, Period period2, Period period3, Price price3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, b.c);
        Intrinsics.checkNotNullParameter(price2, b.x);
        this.id = str;
        this.name = str2;
        this.title = str3;
        this.description = str4;
        this.price = price2;
        this.period = period2;
        this.freeTrialPeriod = period3;
        this.introPrice = price3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TestStoreProduct(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.String r16, com.revenuecat.purchases.models.Price r17, com.revenuecat.purchases.models.Period r18, com.revenuecat.purchases.models.Period r19, com.revenuecat.purchases.models.Price r20, int r21, kotlin.jvm.internal.DefaultConstructorMarker r22) {
        /*
            r12 = this;
            r0 = r21
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r10 = r2
            goto L_0x000b
        L_0x0009:
            r10 = r19
        L_0x000b:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0011
            r11 = r2
            goto L_0x0013
        L_0x0011:
            r11 = r20
        L_0x0013:
            r3 = r12
            r4 = r13
            r5 = r14
            r6 = r15
            r7 = r16
            r8 = r17
            r9 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.TestStoreProduct.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.revenuecat.purchases.models.Price, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.Period, com.revenuecat.purchases.models.Price, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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
    public /* synthetic */ TestStoreProduct(String str, String str2, String str3, Price price2, Period period2, Period period3, Price price3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, price2, period2, (i & 32) != 0 ? null : period3, (i & 64) != 0 ? null : price3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Replaced with constructor that takes a name", replaceWith = @ReplaceWith(expression = "TestStoreProduct(id, name, title, description, price, period, freeTrialPeriod, introPrice)", imports = {}))
    public TestStoreProduct(String str, String str2, String str3, Price price2, Period period2, Period period3, Price price3) {
        this(str, str2, str2, str3, price2, period2, period3, price3);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, b.c);
        Intrinsics.checkNotNullParameter(price2, b.x);
    }

    public ProductType getType() {
        return getPeriod() == null ? ProductType.INAPP : ProductType.SUBS;
    }

    public SubscriptionOptions getSubscriptionOptions() {
        return buildSubscriptionOptions();
    }

    public SubscriptionOption getDefaultOption() {
        SubscriptionOptions subscriptionOptions = getSubscriptionOptions();
        if (subscriptionOptions != null) {
            return subscriptionOptions.getDefaultOffer();
        }
        return null;
    }

    public PurchasingData getPurchasingData() {
        return new TestStoreProduct$purchasingData$1(this);
    }

    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext = getPresentedOfferingContext();
        if (presentedOfferingContext != null) {
            return presentedOfferingContext.getOfferingIdentifier();
        }
        return null;
    }

    public String getSku() {
        return getId();
    }

    @Deprecated(message = "Use copyWithPresentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "copyWithPresentedOfferingContext(PresentedOfferingContext(offeringId))", imports = {}))
    public StoreProduct copyWithOfferingId(String str) {
        Intrinsics.checkNotNullParameter(str, "offeringId");
        return copyWithPresentedOfferingContext(new PresentedOfferingContext(str));
    }

    public StoreProduct copyWithPresentedOfferingContext(PresentedOfferingContext presentedOfferingContext) {
        return this;
    }

    private final SubscriptionOptions buildSubscriptionOptions() {
        TestSubscriptionOption testSubscriptionOption = null;
        if (getPeriod() == null) {
            return null;
        }
        Period period2 = this.freeTrialPeriod;
        PricingPhase pricingPhase = period2 != null ? new PricingPhase(period2, RecurrenceMode.FINITE_RECURRING, 1, new Price("Free", 0, getPrice().getCurrencyCode())) : null;
        Price price2 = this.introPrice;
        PricingPhase pricingPhase2 = price2 != null ? new PricingPhase(new Period(1, Period.Unit.MONTH, "P1M"), RecurrenceMode.FINITE_RECURRING, 1, price2) : null;
        PricingPhase pricingPhase3 = new PricingPhase(getPeriod(), RecurrenceMode.INFINITE_RECURRING, (Integer) null, getPrice());
        TestSubscriptionOption[] testSubscriptionOptionArr = new TestSubscriptionOption[2];
        TestSubscriptionOption testSubscriptionOption2 = new TestSubscriptionOption(getId(), CollectionsKt.listOfNotNull((T[]) new PricingPhase[]{pricingPhase, pricingPhase2, pricingPhase3}), (String) null, (List) null, (PresentedOfferingContext) null, 28, (DefaultConstructorMarker) null);
        if (!(this.freeTrialPeriod == null && pricingPhase2 == null)) {
            testSubscriptionOption = testSubscriptionOption2;
        }
        testSubscriptionOptionArr[0] = testSubscriptionOption;
        testSubscriptionOptionArr[1] = new TestSubscriptionOption(getId(), CollectionsKt.listOf(pricingPhase3), (String) null, (List) null, (PresentedOfferingContext) null, 28, (DefaultConstructorMarker) null);
        return new SubscriptionOptions(CollectionsKt.listOfNotNull((T[]) testSubscriptionOptionArr));
    }
}
