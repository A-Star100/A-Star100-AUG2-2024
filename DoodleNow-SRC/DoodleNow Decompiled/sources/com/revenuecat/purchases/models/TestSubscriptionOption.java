package com.revenuecat.purchases.models;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u0014\u0010\u0017\u001a\u00020\u00188VX\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/revenuecat/purchases/models/TestSubscriptionOption;", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "productIdentifier", "", "pricingPhases", "", "Lcom/revenuecat/purchases/models/PricingPhase;", "basePlanId", "tags", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/PresentedOfferingContext;)V", "getBasePlanId", "()Ljava/lang/String;", "id", "getId", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "presentedOfferingIdentifier", "getPresentedOfferingIdentifier", "getPricingPhases", "()Ljava/util/List;", "getProductIdentifier", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData", "()Lcom/revenuecat/purchases/models/PurchasingData;", "getTags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TestStoreProduct.kt */
final class TestSubscriptionOption implements SubscriptionOption {
    private final String basePlanId;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<PricingPhase> pricingPhases;
    private final String productIdentifier;
    private final List<String> tags;

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public TestSubscriptionOption(String str, List<PricingPhase> list, String str2, List<String> list2, PresentedOfferingContext presentedOfferingContext2) {
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        Intrinsics.checkNotNullParameter(list, "pricingPhases");
        Intrinsics.checkNotNullParameter(str2, "basePlanId");
        Intrinsics.checkNotNullParameter(list2, "tags");
        Intrinsics.checkNotNullParameter(presentedOfferingContext2, "presentedOfferingContext");
        this.productIdentifier = str;
        this.pricingPhases = list;
        this.basePlanId = str2;
        this.tags = list2;
        this.presentedOfferingContext = presentedOfferingContext2;
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

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TestSubscriptionOption(String str, List list, String str2, List list2, PresentedOfferingContext presentedOfferingContext2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, list, (i & 4) != 0 ? "testBasePlanId" : str2, (i & 8) != 0 ? CollectionsKt.emptyList() : list2, (i & 16) != 0 ? new PresentedOfferingContext("offering") : presentedOfferingContext2);
    }

    public String getId() {
        if (getPricingPhases().size() == 1) {
            return this.basePlanId;
        }
        return this.basePlanId + ":testOfferId";
    }

    public String getPresentedOfferingIdentifier() {
        return getPresentedOfferingContext().getOfferingIdentifier();
    }

    public PurchasingData getPurchasingData() {
        return new TestSubscriptionOption$purchasingData$1(this);
    }
}
