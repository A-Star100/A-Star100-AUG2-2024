package com.revenuecat.purchases;

import android.app.Activity;
import com.revenuecat.purchases.models.GoogleProrationMode;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PurchasingData;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.TestStoreProduct;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001&B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00068@X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u0010¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u000f\u0010\u0011R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00188@X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\u00020\u001c8@X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006'"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams;", "", "builder", "Lcom/revenuecat/purchases/PurchaseParams$Builder;", "(Lcom/revenuecat/purchases/PurchaseParams$Builder;)V", "activity", "Landroid/app/Activity;", "getActivity$purchases_defaultsRelease", "()Landroid/app/Activity;", "getBuilder", "()Lcom/revenuecat/purchases/PurchaseParams$Builder;", "googleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getGoogleReplacementMode", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "isPersonalizedPrice", "", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "oldProductId", "", "getOldProductId", "()Ljava/lang/String;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingContext$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "getPurchasingData$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/PurchasingData;", "component1", "copy", "equals", "other", "hashCode", "", "toString", "Builder", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchaseParams.kt */
public final class PurchaseParams {
    private final Activity activity;
    private final Builder builder;
    private final GoogleReplacementMode googleReplacementMode;
    private final Boolean isPersonalizedPrice;
    private final String oldProductId;
    private final PresentedOfferingContext presentedOfferingContext;
    private final PurchasingData purchasingData;

    public static /* synthetic */ PurchaseParams copy$default(PurchaseParams purchaseParams, Builder builder2, int i, Object obj) {
        if ((i & 1) != 0) {
            builder2 = purchaseParams.builder;
        }
        return purchaseParams.copy(builder2);
    }

    public final Builder component1() {
        return this.builder;
    }

    public final PurchaseParams copy(Builder builder2) {
        Intrinsics.checkNotNullParameter(builder2, "builder");
        return new PurchaseParams(builder2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof PurchaseParams) && Intrinsics.areEqual((Object) this.builder, (Object) ((PurchaseParams) obj).builder);
    }

    public final /* synthetic */ Activity getActivity$purchases_defaultsRelease() {
        return this.activity;
    }

    public final Builder getBuilder() {
        return this.builder;
    }

    public final GoogleReplacementMode getGoogleReplacementMode() {
        return this.googleReplacementMode;
    }

    public final String getOldProductId() {
        return this.oldProductId;
    }

    public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext$purchases_defaultsRelease() {
        return this.presentedOfferingContext;
    }

    public final /* synthetic */ PurchasingData getPurchasingData$purchases_defaultsRelease() {
        return this.purchasingData;
    }

    public int hashCode() {
        return this.builder.hashCode();
    }

    public final Boolean isPersonalizedPrice() {
        return this.isPersonalizedPrice;
    }

    public String toString() {
        return "PurchaseParams(builder=" + this.builder + ')';
    }

    public PurchaseParams(Builder builder2) {
        Intrinsics.checkNotNullParameter(builder2, "builder");
        this.builder = builder2;
        this.isPersonalizedPrice = builder2.isPersonalizedPrice$purchases_defaultsRelease();
        this.oldProductId = builder2.getOldProductId$purchases_defaultsRelease();
        this.googleReplacementMode = builder2.getGoogleReplacementMode$purchases_defaultsRelease();
        this.purchasingData = builder2.getPurchasingData$purchases_defaultsRelease();
        this.activity = builder2.getActivity$purchases_defaultsRelease();
        this.presentedOfferingContext = builder2.getPresentedOfferingContext$purchases_defaultsRelease();
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\b\u0010/\u001a\u000200H\u0016J\u0010\u00101\u001a\u0002022\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0010\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u000204H\u0007J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001cJ\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020#R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168@@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR,\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u001c8@@@X\u000e¢\u0006\u0010\n\u0002\u0010\"\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0015\u001a\u0004\u0018\u00010#8@@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0014\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.¨\u00065"}, d2 = {"Lcom/revenuecat/purchases/PurchaseParams$Builder;", "", "activity", "Landroid/app/Activity;", "packageToPurchase", "Lcom/revenuecat/purchases/Package;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/Package;)V", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/StoreProduct;)V", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/SubscriptionOption;)V", "purchasingData", "Lcom/revenuecat/purchases/models/PurchasingData;", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "product", "(Landroid/app/Activity;Lcom/revenuecat/purchases/models/PurchasingData;Lcom/revenuecat/purchases/PresentedOfferingContext;Lcom/revenuecat/purchases/models/StoreProduct;)V", "getActivity$purchases_defaultsRelease", "()Landroid/app/Activity;", "<set-?>", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "googleReplacementMode", "getGoogleReplacementMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "setGoogleReplacementMode$purchases_defaultsRelease", "(Lcom/revenuecat/purchases/models/GoogleReplacementMode;)V", "", "isPersonalizedPrice", "isPersonalizedPrice$purchases_defaultsRelease", "()Ljava/lang/Boolean;", "setPersonalizedPrice$purchases_defaultsRelease", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "", "oldProductId", "getOldProductId$purchases_defaultsRelease", "()Ljava/lang/String;", "setOldProductId$purchases_defaultsRelease", "(Ljava/lang/String;)V", "getPresentedOfferingContext$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProduct$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/StoreProduct;", "getPurchasingData$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/PurchasingData;", "build", "Lcom/revenuecat/purchases/PurchaseParams;", "ensureNoTestProduct", "", "googleProrationMode", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PurchaseParams.kt */
    public static class Builder {
        private final Activity activity;
        private GoogleReplacementMode googleReplacementMode;
        private Boolean isPersonalizedPrice;
        private String oldProductId;
        private final PresentedOfferingContext presentedOfferingContext;
        private final StoreProduct product;
        private final PurchasingData purchasingData;

        public final /* synthetic */ Activity getActivity$purchases_defaultsRelease() {
            return this.activity;
        }

        public final /* synthetic */ GoogleReplacementMode getGoogleReplacementMode$purchases_defaultsRelease() {
            return this.googleReplacementMode;
        }

        public final /* synthetic */ String getOldProductId$purchases_defaultsRelease() {
            return this.oldProductId;
        }

        public final /* synthetic */ PresentedOfferingContext getPresentedOfferingContext$purchases_defaultsRelease() {
            return this.presentedOfferingContext;
        }

        public final /* synthetic */ StoreProduct getProduct$purchases_defaultsRelease() {
            return this.product;
        }

        public final /* synthetic */ PurchasingData getPurchasingData$purchases_defaultsRelease() {
            return this.purchasingData;
        }

        public final /* synthetic */ Boolean isPersonalizedPrice$purchases_defaultsRelease() {
            return this.isPersonalizedPrice;
        }

        public final /* synthetic */ void setGoogleReplacementMode$purchases_defaultsRelease(GoogleReplacementMode googleReplacementMode2) {
            Intrinsics.checkNotNullParameter(googleReplacementMode2, "<set-?>");
            this.googleReplacementMode = googleReplacementMode2;
        }

        public final /* synthetic */ void setOldProductId$purchases_defaultsRelease(String str) {
            this.oldProductId = str;
        }

        public final /* synthetic */ void setPersonalizedPrice$purchases_defaultsRelease(Boolean bool) {
            this.isPersonalizedPrice = bool;
        }

        private Builder(Activity activity2, PurchasingData purchasingData2, PresentedOfferingContext presentedOfferingContext2, StoreProduct storeProduct) {
            this.activity = activity2;
            this.purchasingData = purchasingData2;
            this.presentedOfferingContext = presentedOfferingContext2;
            this.product = storeProduct;
            this.googleReplacementMode = GoogleReplacementMode.WITHOUT_PRORATION;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity2, Package packageR) {
            this(activity2, packageR.getProduct().getPurchasingData(), packageR.getPresentedOfferingContext(), packageR.getProduct());
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Intrinsics.checkNotNullParameter(packageR, "packageToPurchase");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity2, StoreProduct storeProduct) {
            this(activity2, storeProduct.getPurchasingData(), storeProduct.getPresentedOfferingContext(), storeProduct);
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Intrinsics.checkNotNullParameter(storeProduct, "storeProduct");
        }

        private final void ensureNoTestProduct(StoreProduct storeProduct) {
            if (storeProduct instanceof TestStoreProduct) {
                PurchasesErrorCode purchasesErrorCode = PurchasesErrorCode.ProductNotAvailableForPurchaseError;
                throw new PurchasesException(new PurchasesError(purchasesErrorCode, "Cannot purchase " + storeProduct));
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(Activity activity2, SubscriptionOption subscriptionOption) {
            this(activity2, subscriptionOption.getPurchasingData(), subscriptionOption.getPresentedOfferingContext(), (StoreProduct) null);
            Intrinsics.checkNotNullParameter(activity2, "activity");
            Intrinsics.checkNotNullParameter(subscriptionOption, "subscriptionOption");
        }

        public final Builder isPersonalizedPrice(boolean z) {
            Builder builder = this;
            this.isPersonalizedPrice = Boolean.valueOf(z);
            return this;
        }

        public final Builder oldProductId(String str) {
            Intrinsics.checkNotNullParameter(str, "oldProductId");
            Builder builder = this;
            this.oldProductId = str;
            return this;
        }

        @Deprecated(message = "Use googleReplacementMode()", replaceWith = @ReplaceWith(expression = "googleReplacementMode()", imports = {}))
        public final Builder googleProrationMode(GoogleProrationMode googleProrationMode) {
            Intrinsics.checkNotNullParameter(googleProrationMode, "googleProrationMode");
            Builder builder = this;
            this.googleReplacementMode = googleProrationMode.getAsGoogleReplacementMode$purchases_defaultsRelease();
            return this;
        }

        public final Builder googleReplacementMode(GoogleReplacementMode googleReplacementMode2) {
            Intrinsics.checkNotNullParameter(googleReplacementMode2, "googleReplacementMode");
            Builder builder = this;
            this.googleReplacementMode = googleReplacementMode2;
            return this;
        }

        public PurchaseParams build() {
            StoreProduct storeProduct = this.product;
            if (storeProduct != null) {
                ensureNoTestProduct(storeProduct);
            }
            return new PurchaseParams(this);
        }
    }
}
