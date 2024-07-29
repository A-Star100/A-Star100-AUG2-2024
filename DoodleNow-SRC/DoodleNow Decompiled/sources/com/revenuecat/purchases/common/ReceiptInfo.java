package com.revenuecat.purchases.common;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B[\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020\u0004H\u0016R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u00038@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u0011¨\u0006."}, d2 = {"Lcom/revenuecat/purchases/common/ReceiptInfo;", "", "productIDs", "", "", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "subscriptionOptionId", "storeProduct", "Lcom/revenuecat/purchases/models/StoreProduct;", "price", "", "currency", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Ljava/util/List;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreProduct;Ljava/lang/Double;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "getCurrency", "()Ljava/lang/String;", "duration", "getDuration", "platformProductIds", "Lcom/revenuecat/purchases/common/PlatformProductId;", "getPlatformProductIds$purchases_defaultsRelease", "()Ljava/util/List;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPrice", "()Ljava/lang/Double;", "Ljava/lang/Double;", "pricingPhases", "Lcom/revenuecat/purchases/models/PricingPhase;", "getPricingPhases", "getProductIDs", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getStoreProduct", "()Lcom/revenuecat/purchases/models/StoreProduct;", "subscriptionOption", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "getSubscriptionOptionId", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ReceiptInfo.kt */
public final class ReceiptInfo {
    private final String currency;
    private final String duration;
    private final PresentedOfferingContext presentedOfferingContext;
    private final Double price;
    private final List<PricingPhase> pricingPhases;
    private final List<String> productIDs;
    private final ReplacementMode replacementMode;
    private final StoreProduct storeProduct;
    private final SubscriptionOption subscriptionOption;
    private final String subscriptionOptionId;

    public final String getCurrency() {
        return this.currency;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final Double getPrice() {
        return this.price;
    }

    public final List<PricingPhase> getPricingPhases() {
        return this.pricingPhases;
    }

    public final List<String> getProductIDs() {
        return this.productIDs;
    }

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final StoreProduct getStoreProduct() {
        return this.storeProduct;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x001f, code lost:
        r3 = (r3 = r5.getPeriod()).getIso8601();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ReceiptInfo(java.util.List<java.lang.String> r2, com.revenuecat.purchases.PresentedOfferingContext r3, java.lang.String r4, com.revenuecat.purchases.models.StoreProduct r5, java.lang.Double r6, java.lang.String r7, com.revenuecat.purchases.ReplacementMode r8) {
        /*
            r1 = this;
            java.lang.String r0 = "productIDs"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            r1.<init>()
            r1.productIDs = r2
            r1.presentedOfferingContext = r3
            r1.subscriptionOptionId = r4
            r1.storeProduct = r5
            r1.price = r6
            r1.currency = r7
            r1.replacementMode = r8
            r2 = 0
            if (r5 == 0) goto L_0x002e
            com.revenuecat.purchases.models.Period r3 = r5.getPeriod()
            if (r3 == 0) goto L_0x002e
            java.lang.String r3 = r3.getIso8601()
            if (r3 == 0) goto L_0x002e
            r4 = r3
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            int r4 = r4.length()
            if (r4 != 0) goto L_0x002f
        L_0x002e:
            r3 = r2
        L_0x002f:
            r1.duration = r3
            if (r5 == 0) goto L_0x005d
            com.revenuecat.purchases.models.SubscriptionOptions r3 = r5.getSubscriptionOptions()
            if (r3 == 0) goto L_0x005d
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            java.util.Iterator r3 = r3.iterator()
        L_0x003f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0059
            java.lang.Object r4 = r3.next()
            r5 = r4
            com.revenuecat.purchases.models.SubscriptionOption r5 = (com.revenuecat.purchases.models.SubscriptionOption) r5
            java.lang.String r5 = r5.getId()
            java.lang.String r6 = r1.subscriptionOptionId
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)
            if (r5 == 0) goto L_0x003f
            goto L_0x005a
        L_0x0059:
            r4 = r2
        L_0x005a:
            com.revenuecat.purchases.models.SubscriptionOption r4 = (com.revenuecat.purchases.models.SubscriptionOption) r4
            goto L_0x005e
        L_0x005d:
            r4 = r2
        L_0x005e:
            r1.subscriptionOption = r4
            if (r4 == 0) goto L_0x0066
            java.util.List r2 = r4.getPricingPhases()
        L_0x0066:
            r1.pricingPhases = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.ReceiptInfo.<init>(java.util.List, com.revenuecat.purchases.PresentedOfferingContext, java.lang.String, com.revenuecat.purchases.models.StoreProduct, java.lang.Double, java.lang.String, com.revenuecat.purchases.ReplacementMode):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ReceiptInfo(java.util.List r9, com.revenuecat.purchases.PresentedOfferingContext r10, java.lang.String r11, com.revenuecat.purchases.models.StoreProduct r12, java.lang.Double r13, java.lang.String r14, com.revenuecat.purchases.ReplacementMode r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r8 = this;
            r0 = r16 & 2
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0008
        L_0x0007:
            r0 = r10
        L_0x0008:
            r2 = r16 & 4
            if (r2 == 0) goto L_0x000e
            r2 = r1
            goto L_0x000f
        L_0x000e:
            r2 = r11
        L_0x000f:
            r3 = r16 & 8
            if (r3 == 0) goto L_0x0015
            r3 = r1
            goto L_0x0016
        L_0x0015:
            r3 = r12
        L_0x0016:
            r4 = r16 & 16
            if (r4 == 0) goto L_0x0034
            if (r3 == 0) goto L_0x0032
            com.revenuecat.purchases.models.Price r4 = r3.getPrice()
            if (r4 == 0) goto L_0x0032
            long r4 = r4.getAmountMicros()
            double r4 = (double) r4
            r6 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            double r4 = r4 / r6
            java.lang.Double r4 = java.lang.Double.valueOf(r4)
            goto L_0x0035
        L_0x0032:
            r4 = r1
            goto L_0x0035
        L_0x0034:
            r4 = r13
        L_0x0035:
            r5 = r16 & 32
            if (r5 == 0) goto L_0x0048
            if (r3 == 0) goto L_0x0046
            com.revenuecat.purchases.models.Price r5 = r3.getPrice()
            if (r5 == 0) goto L_0x0046
            java.lang.String r5 = r5.getCurrencyCode()
            goto L_0x0049
        L_0x0046:
            r5 = r1
            goto L_0x0049
        L_0x0048:
            r5 = r14
        L_0x0049:
            r6 = r16 & 64
            if (r6 == 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r1 = r15
        L_0x004f:
            r10 = r8
            r11 = r9
            r12 = r0
            r13 = r2
            r14 = r3
            r15 = r4
            r16 = r5
            r17 = r1
            r10.<init>(r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.common.ReceiptInfo.<init>(java.util.List, com.revenuecat.purchases.PresentedOfferingContext, java.lang.String, com.revenuecat.purchases.models.StoreProduct, java.lang.Double, java.lang.String, com.revenuecat.purchases.ReplacementMode, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.common.ReceiptInfo");
        ReceiptInfo receiptInfo = (ReceiptInfo) obj;
        return Intrinsics.areEqual((Object) this.productIDs, (Object) receiptInfo.productIDs) && Intrinsics.areEqual((Object) this.presentedOfferingContext, (Object) receiptInfo.presentedOfferingContext) && Intrinsics.areEqual((Object) this.storeProduct, (Object) receiptInfo.storeProduct) && Intrinsics.areEqual(this.price, receiptInfo.price) && Intrinsics.areEqual((Object) this.currency, (Object) receiptInfo.currency) && Intrinsics.areEqual((Object) this.subscriptionOptionId, (Object) receiptInfo.subscriptionOptionId);
    }

    public final List<PlatformProductId> getPlatformProductIds$purchases_defaultsRelease() {
        PlatformProductId platformProductId;
        String str;
        SubscriptionOption subscriptionOption2 = this.subscriptionOption;
        if (subscriptionOption2 == null || (platformProductId = ReceiptInfoKt.platformProductId(subscriptionOption2)) == null) {
            StoreProduct storeProduct2 = this.storeProduct;
            platformProductId = storeProduct2 != null ? ReceiptInfoKt.platformProductId(storeProduct2) : null;
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.productIDs) {
            String str2 = (String) next;
            if (platformProductId != null) {
                str = platformProductId.getProductId();
            } else {
                str = null;
            }
            if (!Intrinsics.areEqual((Object) str2, (Object) str)) {
                arrayList.add(next);
            }
        }
        Iterable<String> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (String platformProductId2 : iterable) {
            arrayList2.add(new PlatformProductId(platformProductId2));
        }
        return CollectionsKt.plus((List) arrayList2, CollectionsKt.listOfNotNull(platformProductId));
    }

    public int hashCode() {
        int hashCode = this.productIDs.hashCode() * 31;
        PresentedOfferingContext presentedOfferingContext2 = this.presentedOfferingContext;
        int i = 0;
        int hashCode2 = (hashCode + (presentedOfferingContext2 != null ? presentedOfferingContext2.hashCode() : 0)) * 31;
        StoreProduct storeProduct2 = this.storeProduct;
        int hashCode3 = (hashCode2 + (storeProduct2 != null ? storeProduct2.hashCode() : 0)) * 31;
        String str = this.subscriptionOptionId;
        if (str != null) {
            i = str.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "ReceiptInfo(productIDs='" + CollectionsKt.joinToString$default(this.productIDs, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + "', presentedOfferingContext=" + this.presentedOfferingContext + ", storeProduct=" + this.storeProduct + ", subscriptionOptionId=" + this.subscriptionOptionId + ", pricingPhases=" + this.pricingPhases + ", price=" + this.price + ", currency=" + this.currency + ", duration=" + this.duration + ')';
    }
}
