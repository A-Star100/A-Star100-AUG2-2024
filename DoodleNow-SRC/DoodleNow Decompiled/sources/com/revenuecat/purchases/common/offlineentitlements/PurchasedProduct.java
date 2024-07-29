package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\bHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\nHÆ\u0003JE\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/revenuecat/purchases/common/offlineentitlements/PurchasedProduct;", "", "productIdentifier", "", "basePlanId", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "entitlements", "", "expiresDate", "Ljava/util/Date;", "(Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/StoreTransaction;Ljava/util/List;Ljava/util/Date;)V", "getBasePlanId", "()Ljava/lang/String;", "getEntitlements", "()Ljava/util/List;", "getExpiresDate", "()Ljava/util/Date;", "getProductIdentifier", "getStoreTransaction", "()Lcom/revenuecat/purchases/models/StoreTransaction;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PurchasedProduct.kt */
public final class PurchasedProduct {
    private final String basePlanId;
    private final List<String> entitlements;
    private final Date expiresDate;
    private final String productIdentifier;
    private final StoreTransaction storeTransaction;

    public static /* synthetic */ PurchasedProduct copy$default(PurchasedProduct purchasedProduct, String str, String str2, StoreTransaction storeTransaction2, List<String> list, Date date, int i, Object obj) {
        if ((i & 1) != 0) {
            str = purchasedProduct.productIdentifier;
        }
        if ((i & 2) != 0) {
            str2 = purchasedProduct.basePlanId;
        }
        String str3 = str2;
        if ((i & 4) != 0) {
            storeTransaction2 = purchasedProduct.storeTransaction;
        }
        StoreTransaction storeTransaction3 = storeTransaction2;
        if ((i & 8) != 0) {
            list = purchasedProduct.entitlements;
        }
        List<String> list2 = list;
        if ((i & 16) != 0) {
            date = purchasedProduct.expiresDate;
        }
        return purchasedProduct.copy(str, str3, storeTransaction3, list2, date);
    }

    public final String component1() {
        return this.productIdentifier;
    }

    public final String component2() {
        return this.basePlanId;
    }

    public final StoreTransaction component3() {
        return this.storeTransaction;
    }

    public final List<String> component4() {
        return this.entitlements;
    }

    public final Date component5() {
        return this.expiresDate;
    }

    public final PurchasedProduct copy(String str, String str2, StoreTransaction storeTransaction2, List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        Intrinsics.checkNotNullParameter(storeTransaction2, "storeTransaction");
        Intrinsics.checkNotNullParameter(list, CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        return new PurchasedProduct(str, str2, storeTransaction2, list, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchasedProduct)) {
            return false;
        }
        PurchasedProduct purchasedProduct = (PurchasedProduct) obj;
        return Intrinsics.areEqual((Object) this.productIdentifier, (Object) purchasedProduct.productIdentifier) && Intrinsics.areEqual((Object) this.basePlanId, (Object) purchasedProduct.basePlanId) && Intrinsics.areEqual((Object) this.storeTransaction, (Object) purchasedProduct.storeTransaction) && Intrinsics.areEqual((Object) this.entitlements, (Object) purchasedProduct.entitlements) && Intrinsics.areEqual((Object) this.expiresDate, (Object) purchasedProduct.expiresDate);
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final List<String> getEntitlements() {
        return this.entitlements;
    }

    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final StoreTransaction getStoreTransaction() {
        return this.storeTransaction;
    }

    public int hashCode() {
        int hashCode = this.productIdentifier.hashCode() * 31;
        String str = this.basePlanId;
        int i = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.storeTransaction.hashCode()) * 31) + this.entitlements.hashCode()) * 31;
        Date date = this.expiresDate;
        if (date != null) {
            i = date.hashCode();
        }
        return hashCode2 + i;
    }

    public String toString() {
        return "PurchasedProduct(productIdentifier=" + this.productIdentifier + ", basePlanId=" + this.basePlanId + ", storeTransaction=" + this.storeTransaction + ", entitlements=" + this.entitlements + ", expiresDate=" + this.expiresDate + ')';
    }

    public PurchasedProduct(String str, String str2, StoreTransaction storeTransaction2, List<String> list, Date date) {
        Intrinsics.checkNotNullParameter(str, "productIdentifier");
        Intrinsics.checkNotNullParameter(storeTransaction2, "storeTransaction");
        Intrinsics.checkNotNullParameter(list, CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        this.productIdentifier = str;
        this.basePlanId = str2;
        this.storeTransaction = storeTransaction2;
        this.entitlements = list;
        this.expiresDate = date;
    }
}
