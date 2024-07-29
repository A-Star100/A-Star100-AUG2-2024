package com.revenuecat.purchases.models;

import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import java.util.List;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b*\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0001\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u001aJ\u000b\u00100\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0017HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u00104\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\bHÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\fHÆ\u0003J\t\u00108\u001a\u00020\u0006HÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u0010\u001bJ\u000b\u0010;\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0014HÆ\u0003J¤\u0001\u0010=\u001a\u00020\u00002\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010>J\u0013\u0010?\u001a\u00020\u00112\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020BHÖ\u0001J\t\u0010C\u001a\u00020\u0006HÖ\u0001R\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u0010\u0010\u001bR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001eR\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001eR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001eR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006D"}, d2 = {"Lcom/revenuecat/purchases/models/ComparableData;", "", "storeTransaction", "Lcom/revenuecat/purchases/models/StoreTransaction;", "(Lcom/revenuecat/purchases/models/StoreTransaction;)V", "orderId", "", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "purchaseTime", "", "purchaseToken", "purchaseState", "Lcom/revenuecat/purchases/models/PurchaseState;", "isAutoRenewing", "", "signature", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "storeUserID", "purchaseType", "Lcom/revenuecat/purchases/models/PurchaseType;", "marketplace", "subscriptionOptionId", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarketplace", "()Ljava/lang/String;", "getOrderId", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getProductIds", "()Ljava/util/List;", "getPurchaseState", "()Lcom/revenuecat/purchases/models/PurchaseState;", "getPurchaseTime", "()J", "getPurchaseToken", "getPurchaseType", "()Lcom/revenuecat/purchases/models/PurchaseType;", "getSignature", "getStoreUserID", "getSubscriptionOptionId", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/models/ComparableData;", "equals", "other", "hashCode", "", "toString", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StoreTransaction.kt */
final class ComparableData {
    private final Boolean isAutoRenewing;
    private final String marketplace;
    private final String orderId;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<String> productIds;
    private final PurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final PurchaseType purchaseType;
    private final String signature;
    private final String storeUserID;
    private final String subscriptionOptionId;
    private final ProductType type;

    public static /* synthetic */ ComparableData copy$default(ComparableData comparableData, String str, List list, ProductType productType, long j, String str2, PurchaseState purchaseState2, Boolean bool, String str3, PresentedOfferingContext presentedOfferingContext2, String str4, PurchaseType purchaseType2, String str5, String str6, int i, Object obj) {
        ComparableData comparableData2 = comparableData;
        int i2 = i;
        return comparableData.copy((i2 & 1) != 0 ? comparableData2.orderId : str, (i2 & 2) != 0 ? comparableData2.productIds : list, (i2 & 4) != 0 ? comparableData2.type : productType, (i2 & 8) != 0 ? comparableData2.purchaseTime : j, (i2 & 16) != 0 ? comparableData2.purchaseToken : str2, (i2 & 32) != 0 ? comparableData2.purchaseState : purchaseState2, (i2 & 64) != 0 ? comparableData2.isAutoRenewing : bool, (i2 & 128) != 0 ? comparableData2.signature : str3, (i2 & 256) != 0 ? comparableData2.presentedOfferingContext : presentedOfferingContext2, (i2 & 512) != 0 ? comparableData2.storeUserID : str4, (i2 & 1024) != 0 ? comparableData2.purchaseType : purchaseType2, (i2 & 2048) != 0 ? comparableData2.marketplace : str5, (i2 & 4096) != 0 ? comparableData2.subscriptionOptionId : str6);
    }

    public final String component1() {
        return this.orderId;
    }

    public final String component10() {
        return this.storeUserID;
    }

    public final PurchaseType component11() {
        return this.purchaseType;
    }

    public final String component12() {
        return this.marketplace;
    }

    public final String component13() {
        return this.subscriptionOptionId;
    }

    public final List<String> component2() {
        return this.productIds;
    }

    public final ProductType component3() {
        return this.type;
    }

    public final long component4() {
        return this.purchaseTime;
    }

    public final String component5() {
        return this.purchaseToken;
    }

    public final PurchaseState component6() {
        return this.purchaseState;
    }

    public final Boolean component7() {
        return this.isAutoRenewing;
    }

    public final String component8() {
        return this.signature;
    }

    public final PresentedOfferingContext component9() {
        return this.presentedOfferingContext;
    }

    public final ComparableData copy(String str, List<String> list, ProductType productType, long j, String str2, PurchaseState purchaseState2, Boolean bool, String str3, PresentedOfferingContext presentedOfferingContext2, String str4, PurchaseType purchaseType2, String str5, String str6) {
        List<String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "productIds");
        ProductType productType2 = productType;
        Intrinsics.checkNotNullParameter(productType2, "type");
        String str7 = str2;
        Intrinsics.checkNotNullParameter(str7, "purchaseToken");
        PurchaseState purchaseState3 = purchaseState2;
        Intrinsics.checkNotNullParameter(purchaseState3, "purchaseState");
        PurchaseType purchaseType3 = purchaseType2;
        Intrinsics.checkNotNullParameter(purchaseType3, "purchaseType");
        return new ComparableData(str, list2, productType2, j, str7, purchaseState3, bool, str3, presentedOfferingContext2, str4, purchaseType3, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComparableData)) {
            return false;
        }
        ComparableData comparableData = (ComparableData) obj;
        return Intrinsics.areEqual((Object) this.orderId, (Object) comparableData.orderId) && Intrinsics.areEqual((Object) this.productIds, (Object) comparableData.productIds) && this.type == comparableData.type && this.purchaseTime == comparableData.purchaseTime && Intrinsics.areEqual((Object) this.purchaseToken, (Object) comparableData.purchaseToken) && this.purchaseState == comparableData.purchaseState && Intrinsics.areEqual((Object) this.isAutoRenewing, (Object) comparableData.isAutoRenewing) && Intrinsics.areEqual((Object) this.signature, (Object) comparableData.signature) && Intrinsics.areEqual((Object) this.presentedOfferingContext, (Object) comparableData.presentedOfferingContext) && Intrinsics.areEqual((Object) this.storeUserID, (Object) comparableData.storeUserID) && this.purchaseType == comparableData.purchaseType && Intrinsics.areEqual((Object) this.marketplace, (Object) comparableData.marketplace) && Intrinsics.areEqual((Object) this.subscriptionOptionId, (Object) comparableData.subscriptionOptionId);
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final List<String> getProductIds() {
        return this.productIds;
    }

    public final PurchaseState getPurchaseState() {
        return this.purchaseState;
    }

    public final long getPurchaseTime() {
        return this.purchaseTime;
    }

    public final String getPurchaseToken() {
        return this.purchaseToken;
    }

    public final PurchaseType getPurchaseType() {
        return this.purchaseType;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final String getStoreUserID() {
        return this.storeUserID;
    }

    public final String getSubscriptionOptionId() {
        return this.subscriptionOptionId;
    }

    public final ProductType getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.orderId;
        int i = 0;
        int hashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + this.productIds.hashCode()) * 31) + this.type.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.purchaseTime)) * 31) + this.purchaseToken.hashCode()) * 31) + this.purchaseState.hashCode()) * 31;
        Boolean bool = this.isAutoRenewing;
        int hashCode2 = (hashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.signature;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PresentedOfferingContext presentedOfferingContext2 = this.presentedOfferingContext;
        int hashCode4 = (hashCode3 + (presentedOfferingContext2 == null ? 0 : presentedOfferingContext2.hashCode())) * 31;
        String str3 = this.storeUserID;
        int hashCode5 = (((hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.purchaseType.hashCode()) * 31;
        String str4 = this.marketplace;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.subscriptionOptionId;
        if (str5 != null) {
            i = str5.hashCode();
        }
        return hashCode6 + i;
    }

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    public String toString() {
        return "ComparableData(orderId=" + this.orderId + ", productIds=" + this.productIds + ", type=" + this.type + ", purchaseTime=" + this.purchaseTime + ", purchaseToken=" + this.purchaseToken + ", purchaseState=" + this.purchaseState + ", isAutoRenewing=" + this.isAutoRenewing + ", signature=" + this.signature + ", presentedOfferingContext=" + this.presentedOfferingContext + ", storeUserID=" + this.storeUserID + ", purchaseType=" + this.purchaseType + ", marketplace=" + this.marketplace + ", subscriptionOptionId=" + this.subscriptionOptionId + ')';
    }

    public ComparableData(String str, List<String> list, ProductType productType, long j, String str2, PurchaseState purchaseState2, Boolean bool, String str3, PresentedOfferingContext presentedOfferingContext2, String str4, PurchaseType purchaseType2, String str5, String str6) {
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(productType, "type");
        Intrinsics.checkNotNullParameter(str2, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState2, "purchaseState");
        Intrinsics.checkNotNullParameter(purchaseType2, "purchaseType");
        this.orderId = str;
        this.productIds = list;
        this.type = productType;
        this.purchaseTime = j;
        this.purchaseToken = str2;
        this.purchaseState = purchaseState2;
        this.isAutoRenewing = bool;
        this.signature = str3;
        this.presentedOfferingContext = presentedOfferingContext2;
        this.storeUserID = str4;
        this.purchaseType = purchaseType2;
        this.marketplace = str5;
        this.subscriptionOptionId = str6;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ComparableData(StoreTransaction storeTransaction) {
        this(storeTransaction.getOrderId(), storeTransaction.getProductIds(), storeTransaction.getType(), storeTransaction.getPurchaseTime(), storeTransaction.getPurchaseToken(), storeTransaction.getPurchaseState(), storeTransaction.isAutoRenewing(), storeTransaction.getSignature(), storeTransaction.getPresentedOfferingContext(), storeTransaction.getStoreUserID(), storeTransaction.getPurchaseType(), storeTransaction.getMarketplace(), storeTransaction.getSubscriptionOptionId());
        Intrinsics.checkNotNullParameter(storeTransaction, "storeTransaction");
    }
}
