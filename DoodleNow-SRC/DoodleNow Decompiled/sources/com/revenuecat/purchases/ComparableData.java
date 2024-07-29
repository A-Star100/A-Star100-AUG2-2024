package com.revenuecat.purchases;

import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import java.util.Date;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B[\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0012\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\u0006\u0010\u000f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bHÆ\u0003J\u0017\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\bHÆ\u0003J\t\u0010!\u001a\u00020\rHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J\t\u0010#\u001a\u00020\tHÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\nHÆ\u0003Jm\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u000f\u001a\u00020\t2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\rHÖ\u0001J\t\u0010*\u001a\u00020\tHÖ\u0001R\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001f\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\n0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006+"}, d2 = {"Lcom/revenuecat/purchases/ComparableData;", "", "customerInfo", "Lcom/revenuecat/purchases/CustomerInfo;", "(Lcom/revenuecat/purchases/CustomerInfo;)V", "entitlements", "Lcom/revenuecat/purchases/EntitlementInfos;", "allExpirationDatesByProduct", "", "", "Ljava/util/Date;", "allPurchaseDatesByProduct", "schemaVersion", "", "firstSeen", "originalAppUserId", "originalPurchaseDate", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Map;Ljava/util/Map;ILjava/util/Date;Ljava/lang/String;Ljava/util/Date;)V", "getAllExpirationDatesByProduct", "()Ljava/util/Map;", "getAllPurchaseDatesByProduct", "getEntitlements", "()Lcom/revenuecat/purchases/EntitlementInfos;", "getFirstSeen", "()Ljava/util/Date;", "getOriginalAppUserId", "()Ljava/lang/String;", "getOriginalPurchaseDate", "getSchemaVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfo.kt */
final class ComparableData {
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final int schemaVersion;

    public static /* synthetic */ ComparableData copy$default(ComparableData comparableData, EntitlementInfos entitlementInfos, Map<String, Date> map, Map<String, Date> map2, int i, Date date, String str, Date date2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            entitlementInfos = comparableData.entitlements;
        }
        if ((i2 & 2) != 0) {
            map = comparableData.allExpirationDatesByProduct;
        }
        Map<String, Date> map3 = map;
        if ((i2 & 4) != 0) {
            map2 = comparableData.allPurchaseDatesByProduct;
        }
        Map<String, Date> map4 = map2;
        if ((i2 & 8) != 0) {
            i = comparableData.schemaVersion;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            date = comparableData.firstSeen;
        }
        Date date3 = date;
        if ((i2 & 32) != 0) {
            str = comparableData.originalAppUserId;
        }
        String str2 = str;
        if ((i2 & 64) != 0) {
            date2 = comparableData.originalPurchaseDate;
        }
        return comparableData.copy(entitlementInfos, map3, map4, i3, date3, str2, date2);
    }

    public final EntitlementInfos component1() {
        return this.entitlements;
    }

    public final Map<String, Date> component2() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> component3() {
        return this.allPurchaseDatesByProduct;
    }

    public final int component4() {
        return this.schemaVersion;
    }

    public final Date component5() {
        return this.firstSeen;
    }

    public final String component6() {
        return this.originalAppUserId;
    }

    public final Date component7() {
        return this.originalPurchaseDate;
    }

    public final ComparableData copy(EntitlementInfos entitlementInfos, Map<String, ? extends Date> map, Map<String, ? extends Date> map2, int i, Date date, String str, Date date2) {
        Intrinsics.checkNotNullParameter(entitlementInfos, CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        Intrinsics.checkNotNullParameter(map, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(map2, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(date, "firstSeen");
        Intrinsics.checkNotNullParameter(str, "originalAppUserId");
        return new ComparableData(entitlementInfos, map, map2, i, date, str, date2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComparableData)) {
            return false;
        }
        ComparableData comparableData = (ComparableData) obj;
        return Intrinsics.areEqual((Object) this.entitlements, (Object) comparableData.entitlements) && Intrinsics.areEqual((Object) this.allExpirationDatesByProduct, (Object) comparableData.allExpirationDatesByProduct) && Intrinsics.areEqual((Object) this.allPurchaseDatesByProduct, (Object) comparableData.allPurchaseDatesByProduct) && this.schemaVersion == comparableData.schemaVersion && Intrinsics.areEqual((Object) this.firstSeen, (Object) comparableData.firstSeen) && Intrinsics.areEqual((Object) this.originalAppUserId, (Object) comparableData.originalAppUserId) && Intrinsics.areEqual((Object) this.originalPurchaseDate, (Object) comparableData.originalPurchaseDate);
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.entitlements.hashCode() * 31) + this.allExpirationDatesByProduct.hashCode()) * 31) + this.allPurchaseDatesByProduct.hashCode()) * 31) + this.schemaVersion) * 31) + this.firstSeen.hashCode()) * 31) + this.originalAppUserId.hashCode()) * 31;
        Date date = this.originalPurchaseDate;
        return hashCode + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "ComparableData(entitlements=" + this.entitlements + ", allExpirationDatesByProduct=" + this.allExpirationDatesByProduct + ", allPurchaseDatesByProduct=" + this.allPurchaseDatesByProduct + ", schemaVersion=" + this.schemaVersion + ", firstSeen=" + this.firstSeen + ", originalAppUserId=" + this.originalAppUserId + ", originalPurchaseDate=" + this.originalPurchaseDate + ')';
    }

    public ComparableData(EntitlementInfos entitlementInfos, Map<String, ? extends Date> map, Map<String, ? extends Date> map2, int i, Date date, String str, Date date2) {
        Intrinsics.checkNotNullParameter(entitlementInfos, CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        Intrinsics.checkNotNullParameter(map, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(map2, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(date, "firstSeen");
        Intrinsics.checkNotNullParameter(str, "originalAppUserId");
        this.entitlements = entitlementInfos;
        this.allExpirationDatesByProduct = map;
        this.allPurchaseDatesByProduct = map2;
        this.schemaVersion = i;
        this.firstSeen = date;
        this.originalAppUserId = str;
        this.originalPurchaseDate = date2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComparableData(CustomerInfo customerInfo) {
        this(customerInfo.getEntitlements(), customerInfo.getAllExpirationDatesByProduct(), customerInfo.getAllPurchaseDatesByProduct(), customerInfo.getSchemaVersion(), customerInfo.getFirstSeen(), customerInfo.getOriginalAppUserId(), customerInfo.getOriginalPurchaseDate());
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
    }
}
