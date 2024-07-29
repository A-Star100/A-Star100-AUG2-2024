package com.revenuecat.purchases.models;

import com.android.billingclient.api.ProductDetails;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.common.Constants;
import com.revenuecat.purchases.models.GooglePurchasingData;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BU\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eB\u0019\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0000\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012BY\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0013J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010-\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007HÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0011HÆ\u0003Ji\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0015R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0015R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0015R\u0014\u0010%\u001a\u00020&8VX\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!¨\u0006:"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productId", "", "basePlanId", "offerId", "pricingPhases", "", "Lcom/revenuecat/purchases/models/PricingPhase;", "tags", "productDetails", "Lcom/android/billingclient/api/ProductDetails;", "offerToken", "presentedOfferingId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Ljava/lang/String;)V", "subscriptionOption", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Lcom/revenuecat/purchases/models/GoogleSubscriptionOption;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Lcom/android/billingclient/api/ProductDetails;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getBasePlanId", "()Ljava/lang/String;", "id", "getId", "getOfferId", "getOfferToken", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getPricingPhases", "()Ljava/util/List;", "getProductDetails", "()Lcom/android/billingclient/api/ProductDetails;", "getProductId", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "getTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GoogleSubscriptionOption.kt */
public final class GoogleSubscriptionOption implements SubscriptionOption {
    private final String basePlanId;
    private final String offerId;
    private final String offerToken;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<PricingPhase> pricingPhases;
    private final ProductDetails productDetails;
    private final String productId;
    private final List<String> tags;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleSubscriptionOption(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.util.List<com.revenuecat.purchases.models.PricingPhase> r16, java.util.List<java.lang.String> r17, com.android.billingclient.api.ProductDetails r18, java.lang.String r19) {
        /*
            r12 = this;
            java.lang.String r0 = "productId"
            r2 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "basePlanId"
            r3 = r14
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "pricingPhases"
            r5 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "tags"
            r6 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "productDetails"
            r7 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "offerToken"
            r8 = r19
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r9 = 0
            r10 = 128(0x80, float:1.794E-43)
            r11 = 0
            r1 = r12
            r4 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleSubscriptionOption.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, com.android.billingclient.api.ProductDetails, java.lang.String):void");
    }

    public static /* synthetic */ GoogleSubscriptionOption copy$default(GoogleSubscriptionOption googleSubscriptionOption, String str, String str2, String str3, List list, List list2, ProductDetails productDetails2, String str4, PresentedOfferingContext presentedOfferingContext2, int i, Object obj) {
        GoogleSubscriptionOption googleSubscriptionOption2 = googleSubscriptionOption;
        int i2 = i;
        return googleSubscriptionOption.copy((i2 & 1) != 0 ? googleSubscriptionOption2.productId : str, (i2 & 2) != 0 ? googleSubscriptionOption2.basePlanId : str2, (i2 & 4) != 0 ? googleSubscriptionOption2.offerId : str3, (i2 & 8) != 0 ? googleSubscriptionOption.getPricingPhases() : list, (i2 & 16) != 0 ? googleSubscriptionOption.getTags() : list2, (i2 & 32) != 0 ? googleSubscriptionOption2.productDetails : productDetails2, (i2 & 64) != 0 ? googleSubscriptionOption2.offerToken : str4, (i2 & 128) != 0 ? googleSubscriptionOption.getPresentedOfferingContext() : presentedOfferingContext2);
    }

    @Deprecated(message = "Use presentedOfferingContext instead", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    public final String component1() {
        return this.productId;
    }

    public final String component2() {
        return this.basePlanId;
    }

    public final String component3() {
        return this.offerId;
    }

    public final List<PricingPhase> component4() {
        return getPricingPhases();
    }

    public final List<String> component5() {
        return getTags();
    }

    public final ProductDetails component6() {
        return this.productDetails;
    }

    public final String component7() {
        return this.offerToken;
    }

    public final PresentedOfferingContext component8() {
        return getPresentedOfferingContext();
    }

    public final GoogleSubscriptionOption copy(String str, String str2, String str3, List<PricingPhase> list, List<String> list2, ProductDetails productDetails2, String str4, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "basePlanId");
        Intrinsics.checkNotNullParameter(list, "pricingPhases");
        Intrinsics.checkNotNullParameter(list2, "tags");
        ProductDetails productDetails3 = productDetails2;
        Intrinsics.checkNotNullParameter(productDetails3, "productDetails");
        String str5 = str4;
        Intrinsics.checkNotNullParameter(str5, "offerToken");
        return new GoogleSubscriptionOption(str, str2, str3, list, list2, productDetails3, str5, presentedOfferingContext2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoogleSubscriptionOption)) {
            return false;
        }
        GoogleSubscriptionOption googleSubscriptionOption = (GoogleSubscriptionOption) obj;
        return Intrinsics.areEqual((Object) this.productId, (Object) googleSubscriptionOption.productId) && Intrinsics.areEqual((Object) this.basePlanId, (Object) googleSubscriptionOption.basePlanId) && Intrinsics.areEqual((Object) this.offerId, (Object) googleSubscriptionOption.offerId) && Intrinsics.areEqual((Object) getPricingPhases(), (Object) googleSubscriptionOption.getPricingPhases()) && Intrinsics.areEqual((Object) getTags(), (Object) googleSubscriptionOption.getTags()) && Intrinsics.areEqual((Object) this.productDetails, (Object) googleSubscriptionOption.productDetails) && Intrinsics.areEqual((Object) this.offerToken, (Object) googleSubscriptionOption.offerToken) && Intrinsics.areEqual((Object) getPresentedOfferingContext(), (Object) googleSubscriptionOption.getPresentedOfferingContext());
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final String getOfferId() {
        return this.offerId;
    }

    public final String getOfferToken() {
        return this.offerToken;
    }

    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final ProductDetails getProductDetails() {
        return this.productDetails;
    }

    public final String getProductId() {
        return this.productId;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public int hashCode() {
        int hashCode = ((this.productId.hashCode() * 31) + this.basePlanId.hashCode()) * 31;
        String str = this.offerId;
        int i = 0;
        int hashCode2 = (((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + getPricingPhases().hashCode()) * 31) + getTags().hashCode()) * 31) + this.productDetails.hashCode()) * 31) + this.offerToken.hashCode()) * 31;
        if (getPresentedOfferingContext() != null) {
            i = getPresentedOfferingContext().hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "GoogleSubscriptionOption(productId=" + this.productId + ", basePlanId=" + this.basePlanId + ", offerId=" + this.offerId + ", pricingPhases=" + getPricingPhases() + ", tags=" + getTags() + ", productDetails=" + this.productDetails + ", offerToken=" + this.offerToken + ", presentedOfferingContext=" + getPresentedOfferingContext() + ')';
    }

    public GoogleSubscriptionOption(String str, String str2, String str3, List<PricingPhase> list, List<String> list2, ProductDetails productDetails2, String str4, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "productId");
        Intrinsics.checkNotNullParameter(str2, "basePlanId");
        Intrinsics.checkNotNullParameter(list, "pricingPhases");
        Intrinsics.checkNotNullParameter(list2, "tags");
        Intrinsics.checkNotNullParameter(productDetails2, "productDetails");
        Intrinsics.checkNotNullParameter(str4, "offerToken");
        this.productId = str;
        this.basePlanId = str2;
        this.offerId = str3;
        this.pricingPhases = list;
        this.tags = list2;
        this.productDetails = productDetails2;
        this.offerToken = str4;
        this.presentedOfferingContext = presentedOfferingContext2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoogleSubscriptionOption(String str, String str2, String str3, List list, List list2, ProductDetails productDetails2, String str4, PresentedOfferingContext presentedOfferingContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (List<PricingPhase>) list, (List<String>) list2, productDetails2, str4, (i & 128) != 0 ? null : presentedOfferingContext2);
    }

    public Period getBillingPeriod() {
        return SubscriptionOption.DefaultImpls.getBillingPeriod(this);
    }

    public PricingPhase getFreePhase() {
        return SubscriptionOption.DefaultImpls.getFreePhase(this);
    }

    public PricingPhase getFullPricePhase() {
        return SubscriptionOption.DefaultImpls.getFullPricePhase(this);
    }

    public PricingPhase getIntroPhase() {
        return SubscriptionOption.DefaultImpls.getIntroPhase(this);
    }

    public boolean isBasePlan() {
        return SubscriptionOption.DefaultImpls.isBasePlan(this);
    }

    public boolean isPrepaid() {
        return SubscriptionOption.DefaultImpls.isPrepaid(this);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Use constructor with presentedOfferingContext instead", replaceWith = @kotlin.ReplaceWith(expression = "GoogleSubscriptionOption(productId, basePlanId, offerId, pricingPhases, tags, productDetails, offerToken, PresentedOfferingContext(offeringIdentifier = presentedOfferingId))", imports = {}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GoogleSubscriptionOption(java.lang.String r12, java.lang.String r13, java.lang.String r14, java.util.List<com.revenuecat.purchases.models.PricingPhase> r15, java.util.List<java.lang.String> r16, com.android.billingclient.api.ProductDetails r17, java.lang.String r18, java.lang.String r19) {
        /*
            r11 = this;
            r0 = r19
            java.lang.String r1 = "productId"
            r3 = r12
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "basePlanId"
            r4 = r13
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r1)
            java.lang.String r1 = "pricingPhases"
            r6 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            java.lang.String r1 = "tags"
            r7 = r16
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r1)
            java.lang.String r1 = "productDetails"
            r8 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "offerToken"
            r9 = r18
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "presentedOfferingId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            com.revenuecat.purchases.PresentedOfferingContext r10 = new com.revenuecat.purchases.PresentedOfferingContext
            r10.<init>(r0)
            r2 = r11
            r5 = r14
            r2.<init>((java.lang.String) r3, (java.lang.String) r4, (java.lang.String) r5, (java.util.List<com.revenuecat.purchases.models.PricingPhase>) r6, (java.util.List<java.lang.String>) r7, (com.android.billingclient.api.ProductDetails) r8, (java.lang.String) r9, (com.revenuecat.purchases.PresentedOfferingContext) r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleSubscriptionOption.<init>(java.lang.String, java.lang.String, java.lang.String, java.util.List, java.util.List, com.android.billingclient.api.ProductDetails, java.lang.String, java.lang.String):void");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GoogleSubscriptionOption(GoogleSubscriptionOption googleSubscriptionOption, PresentedOfferingContext presentedOfferingContext2) {
        this(googleSubscriptionOption.productId, googleSubscriptionOption.basePlanId, googleSubscriptionOption.offerId, googleSubscriptionOption.getPricingPhases(), googleSubscriptionOption.getTags(), googleSubscriptionOption.productDetails, googleSubscriptionOption.offerToken, presentedOfferingContext2);
        Intrinsics.checkNotNullParameter(googleSubscriptionOption, "subscriptionOption");
    }

    public String getId() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.basePlanId);
        CharSequence charSequence = this.offerId;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            str = "";
        } else {
            str = Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + this.offerId;
        }
        sb.append(str);
        return sb.toString();
    }

    public String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext2 = getPresentedOfferingContext();
        if (presentedOfferingContext2 != null) {
            return presentedOfferingContext2.getOfferingIdentifier();
        }
        return null;
    }

    public PurchasingData getPurchasingData() {
        return new GooglePurchasingData.Subscription(this.productId, getId(), this.productDetails, this.offerToken);
    }
}
