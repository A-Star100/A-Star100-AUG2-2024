package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.ProrationMode;
import com.revenuecat.purchases.ReplacementMode;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010\u001aB\u0001\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\u0002\u0010\u001dB\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0002\u0010 J\u000b\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u000b\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000f\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0003J\t\u0010K\u001a\u00020\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\fHÆ\u0003J\u0010\u0010O\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010!J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010Q\u001a\u00020\u0011HÆ\u0003Jº\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÆ\u0001¢\u0006\u0002\u0010SJ\t\u0010T\u001a\u00020UHÖ\u0001J\u0013\u0010V\u001a\u00020\u000e2\b\u0010W\u001a\u0004\u0018\u00010XH\u0002J\b\u0010Y\u001a\u00020UH\u0016J\t\u0010Z\u001a\u00020\u0003HÖ\u0001J\u0019\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020UHÖ\u0001R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010\"\u001a\u0004\b\r\u0010!R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00038FX\u0004¢\u0006\f\u0012\u0004\b*\u0010+\u001a\u0004\b,\u0010$R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c8FX\u0004¢\u0006\f\u0012\u0004\b/\u0010+\u001a\u0004\b0\u00101R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010$R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b;\u0010$R \u0010<\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058FX\u0004¢\u0006\f\u0012\u0004\b=\u0010+\u001a\u0004\b>\u0010.R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b?\u0010$R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010$R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\bA\u0010B¨\u0006`"}, d2 = {"Lcom/revenuecat/purchases/models/StoreTransaction;", "Landroid/os/Parcelable;", "orderId", "", "productIds", "", "type", "Lcom/revenuecat/purchases/ProductType;", "purchaseTime", "", "purchaseToken", "purchaseState", "Lcom/revenuecat/purchases/models/PurchaseState;", "isAutoRenewing", "", "signature", "originalJson", "Lorg/json/JSONObject;", "presentedOfferingIdentifier", "storeUserID", "purchaseType", "Lcom/revenuecat/purchases/models/PurchaseType;", "marketplace", "subscriptionOptionId", "replacementMode", "Lcom/revenuecat/purchases/ReplacementMode;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "prorationMode", "Lcom/revenuecat/purchases/ProrationMode;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ProrationMode;)V", "presentedOfferingContext", "Lcom/revenuecat/purchases/PresentedOfferingContext;", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMarketplace", "()Ljava/lang/String;", "getOrderId", "getOriginalJson", "()Lorg/json/JSONObject;", "getPresentedOfferingContext", "()Lcom/revenuecat/purchases/PresentedOfferingContext;", "getPresentedOfferingIdentifier$annotations", "()V", "getPresentedOfferingIdentifier", "getProductIds", "()Ljava/util/List;", "getProrationMode$annotations", "getProrationMode", "()Lcom/revenuecat/purchases/ProrationMode;", "getPurchaseState", "()Lcom/revenuecat/purchases/models/PurchaseState;", "getPurchaseTime", "()J", "getPurchaseToken", "getPurchaseType", "()Lcom/revenuecat/purchases/models/PurchaseType;", "getReplacementMode", "()Lcom/revenuecat/purchases/ReplacementMode;", "getSignature", "skus", "getSkus$annotations", "getSkus", "getStoreUserID", "getSubscriptionOptionId", "getType", "()Lcom/revenuecat/purchases/ProductType;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/revenuecat/purchases/ProductType;JLjava/lang/String;Lcom/revenuecat/purchases/models/PurchaseState;Ljava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;Lcom/revenuecat/purchases/PresentedOfferingContext;Ljava/lang/String;Lcom/revenuecat/purchases/models/PurchaseType;Ljava/lang/String;Ljava/lang/String;Lcom/revenuecat/purchases/ReplacementMode;)Lcom/revenuecat/purchases/models/StoreTransaction;", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: StoreTransaction.kt */
public final class StoreTransaction implements Parcelable {
    public static final Parcelable.Creator<StoreTransaction> CREATOR = new Creator();
    private final Boolean isAutoRenewing;
    private final String marketplace;
    private final String orderId;
    private final JSONObject originalJson;
    private final PresentedOfferingContext presentedOfferingContext;
    private final List<String> productIds;
    private final PurchaseState purchaseState;
    private final long purchaseTime;
    private final String purchaseToken;
    private final PurchaseType purchaseType;
    private final ReplacementMode replacementMode;
    private final String signature;
    private final String storeUserID;
    private final String subscriptionOptionId;
    private final ProductType type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: StoreTransaction.kt */
    public static final class Creator implements Parcelable.Creator<StoreTransaction> {
        public final StoreTransaction createFromParcel(Parcel parcel) {
            Boolean bool;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            String readString = parcel.readString();
            List createStringArrayList = parcel.createStringArrayList();
            ProductType valueOf = ProductType.valueOf(parcel.readString());
            long readLong = parcel.readLong();
            String readString2 = parcel.readString();
            PurchaseState valueOf2 = PurchaseState.valueOf(parcel.readString());
            PresentedOfferingContext presentedOfferingContext = null;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString3 = parcel.readString();
            JSONObject create = JSONObjectParceler.INSTANCE.create(parcel2);
            if (parcel.readInt() != 0) {
                presentedOfferingContext = PresentedOfferingContext.CREATOR.createFromParcel(parcel2);
            }
            return new StoreTransaction(readString, (List<String>) createStringArrayList, valueOf, readLong, readString2, valueOf2, bool, readString3, create, presentedOfferingContext, parcel.readString(), PurchaseType.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), (ReplacementMode) parcel2.readParcelable(StoreTransaction.class.getClassLoader()));
        }

        public final StoreTransaction[] newArray(int i) {
            return new StoreTransaction[i];
        }
    }

    public static /* synthetic */ StoreTransaction copy$default(StoreTransaction storeTransaction, String str, List list, ProductType productType, long j, String str2, PurchaseState purchaseState2, Boolean bool, String str3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2, String str4, PurchaseType purchaseType2, String str5, String str6, ReplacementMode replacementMode2, int i, Object obj) {
        StoreTransaction storeTransaction2 = storeTransaction;
        int i2 = i;
        return storeTransaction.copy((i2 & 1) != 0 ? storeTransaction2.orderId : str, (i2 & 2) != 0 ? storeTransaction2.productIds : list, (i2 & 4) != 0 ? storeTransaction2.type : productType, (i2 & 8) != 0 ? storeTransaction2.purchaseTime : j, (i2 & 16) != 0 ? storeTransaction2.purchaseToken : str2, (i2 & 32) != 0 ? storeTransaction2.purchaseState : purchaseState2, (i2 & 64) != 0 ? storeTransaction2.isAutoRenewing : bool, (i2 & 128) != 0 ? storeTransaction2.signature : str3, (i2 & 256) != 0 ? storeTransaction2.originalJson : jSONObject, (i2 & 512) != 0 ? storeTransaction2.presentedOfferingContext : presentedOfferingContext2, (i2 & 1024) != 0 ? storeTransaction2.storeUserID : str4, (i2 & 2048) != 0 ? storeTransaction2.purchaseType : purchaseType2, (i2 & 4096) != 0 ? storeTransaction2.marketplace : str5, (i2 & 8192) != 0 ? storeTransaction2.subscriptionOptionId : str6, (i2 & 16384) != 0 ? storeTransaction2.replacementMode : replacementMode2);
    }

    @Deprecated(message = "Use presentedOfferingContext", replaceWith = @ReplaceWith(expression = "presentedOfferingContext.offeringIdentifier", imports = {}))
    public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
    }

    @Deprecated(message = "Use replacementMode", replaceWith = @ReplaceWith(expression = "replacementMode()", imports = {}))
    public static /* synthetic */ void getProrationMode$annotations() {
    }

    @Deprecated(message = "Replaced with productIds", replaceWith = @ReplaceWith(expression = "productIds", imports = {}))
    public static /* synthetic */ void getSkus$annotations() {
    }

    public final String component1() {
        return this.orderId;
    }

    public final PresentedOfferingContext component10() {
        return this.presentedOfferingContext;
    }

    public final String component11() {
        return this.storeUserID;
    }

    public final PurchaseType component12() {
        return this.purchaseType;
    }

    public final String component13() {
        return this.marketplace;
    }

    public final String component14() {
        return this.subscriptionOptionId;
    }

    public final ReplacementMode component15() {
        return this.replacementMode;
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

    public final JSONObject component9() {
        return this.originalJson;
    }

    public final StoreTransaction copy(String str, List<String> list, ProductType productType, long j, String str2, PurchaseState purchaseState2, Boolean bool, String str3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2, String str4, PurchaseType purchaseType2, String str5, String str6, ReplacementMode replacementMode2) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(productType, "type");
        Intrinsics.checkNotNullParameter(str2, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState2, "purchaseState");
        Intrinsics.checkNotNullParameter(jSONObject, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType2, "purchaseType");
        return new StoreTransaction(str, list, productType, j, str2, purchaseState2, bool, str3, jSONObject, presentedOfferingContext2, str4, purchaseType2, str5, str6, replacementMode2);
    }

    public int describeContents() {
        return 0;
    }

    public final String getMarketplace() {
        return this.marketplace;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final JSONObject getOriginalJson() {
        return this.originalJson;
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

    public final ReplacementMode getReplacementMode() {
        return this.replacementMode;
    }

    public final String getSignature() {
        return this.signature;
    }

    public final List<String> getSkus() {
        return this.productIds;
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

    public final Boolean isAutoRenewing() {
        return this.isAutoRenewing;
    }

    public String toString() {
        return "StoreTransaction(orderId=" + this.orderId + ", productIds=" + this.productIds + ", type=" + this.type + ", purchaseTime=" + this.purchaseTime + ", purchaseToken=" + this.purchaseToken + ", purchaseState=" + this.purchaseState + ", isAutoRenewing=" + this.isAutoRenewing + ", signature=" + this.signature + ", originalJson=" + this.originalJson + ", presentedOfferingContext=" + this.presentedOfferingContext + ", storeUserID=" + this.storeUserID + ", purchaseType=" + this.purchaseType + ", marketplace=" + this.marketplace + ", subscriptionOptionId=" + this.subscriptionOptionId + ", replacementMode=" + this.replacementMode + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.orderId);
        parcel.writeStringList(this.productIds);
        parcel.writeString(this.type.name());
        parcel.writeLong(this.purchaseTime);
        parcel.writeString(this.purchaseToken);
        parcel.writeString(this.purchaseState.name());
        Boolean bool = this.isAutoRenewing;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.signature);
        JSONObjectParceler.INSTANCE.write(this.originalJson, parcel, i);
        PresentedOfferingContext presentedOfferingContext2 = this.presentedOfferingContext;
        if (presentedOfferingContext2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            presentedOfferingContext2.writeToParcel(parcel, i);
        }
        parcel.writeString(this.storeUserID);
        parcel.writeString(this.purchaseType.name());
        parcel.writeString(this.marketplace);
        parcel.writeString(this.subscriptionOptionId);
        parcel.writeParcelable(this.replacementMode, i);
    }

    public StoreTransaction(String str, List<String> list, ProductType productType, long j, String str2, PurchaseState purchaseState2, Boolean bool, String str3, JSONObject jSONObject, PresentedOfferingContext presentedOfferingContext2, String str4, PurchaseType purchaseType2, String str5, String str6, ReplacementMode replacementMode2) {
        JSONObject jSONObject2 = jSONObject;
        PurchaseType purchaseType3 = purchaseType2;
        Intrinsics.checkNotNullParameter(list, "productIds");
        Intrinsics.checkNotNullParameter(productType, "type");
        Intrinsics.checkNotNullParameter(str2, "purchaseToken");
        Intrinsics.checkNotNullParameter(purchaseState2, "purchaseState");
        Intrinsics.checkNotNullParameter(jSONObject2, "originalJson");
        Intrinsics.checkNotNullParameter(purchaseType3, "purchaseType");
        this.orderId = str;
        this.productIds = list;
        this.type = productType;
        this.purchaseTime = j;
        this.purchaseToken = str2;
        this.purchaseState = purchaseState2;
        this.isAutoRenewing = bool;
        this.signature = str3;
        this.originalJson = jSONObject2;
        this.presentedOfferingContext = presentedOfferingContext2;
        this.storeUserID = str4;
        this.purchaseType = purchaseType3;
        this.marketplace = str5;
        this.subscriptionOptionId = str6;
        this.replacementMode = replacementMode2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Use constructor with presentedOfferingContext instead")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StoreTransaction(java.lang.String r20, java.util.List<java.lang.String> r21, com.revenuecat.purchases.ProductType r22, long r23, java.lang.String r25, com.revenuecat.purchases.models.PurchaseState r26, java.lang.Boolean r27, java.lang.String r28, org.json.JSONObject r29, java.lang.String r30, java.lang.String r31, com.revenuecat.purchases.models.PurchaseType r32, java.lang.String r33, java.lang.String r34, com.revenuecat.purchases.ReplacementMode r35) {
        /*
            r19 = this;
            r0 = r30
            java.lang.String r1 = "productIds"
            r4 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r1)
            java.lang.String r1 = "type"
            r5 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r1)
            java.lang.String r1 = "purchaseToken"
            r8 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r1)
            java.lang.String r1 = "purchaseState"
            r9 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            java.lang.String r1 = "originalJson"
            r12 = r29
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r1)
            java.lang.String r1 = "purchaseType"
            r15 = r32
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r1)
            if (r0 == 0) goto L_0x0035
            com.revenuecat.purchases.PresentedOfferingContext r1 = new com.revenuecat.purchases.PresentedOfferingContext
            r1.<init>(r0)
            r13 = r1
            goto L_0x0037
        L_0x0035:
            r0 = 0
            r13 = r0
        L_0x0037:
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r14 = r31
            r15 = r32
            r16 = r33
            r17 = r34
            r18 = r35
            r2.<init>((java.lang.String) r3, (java.util.List<java.lang.String>) r4, (com.revenuecat.purchases.ProductType) r5, (long) r6, (java.lang.String) r8, (com.revenuecat.purchases.models.PurchaseState) r9, (java.lang.Boolean) r10, (java.lang.String) r11, (org.json.JSONObject) r12, (com.revenuecat.purchases.PresentedOfferingContext) r13, (java.lang.String) r14, (com.revenuecat.purchases.models.PurchaseType) r15, (java.lang.String) r16, (java.lang.String) r17, (com.revenuecat.purchases.ReplacementMode) r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.StoreTransaction.<init>(java.lang.String, java.util.List, com.revenuecat.purchases.ProductType, long, java.lang.String, com.revenuecat.purchases.models.PurchaseState, java.lang.Boolean, java.lang.String, org.json.JSONObject, java.lang.String, java.lang.String, com.revenuecat.purchases.models.PurchaseType, java.lang.String, java.lang.String, com.revenuecat.purchases.ReplacementMode):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "prorationMode is deprecated, use constructor with replacementMode")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public StoreTransaction(java.lang.String r21, java.util.List<java.lang.String> r22, com.revenuecat.purchases.ProductType r23, long r24, java.lang.String r26, com.revenuecat.purchases.models.PurchaseState r27, java.lang.Boolean r28, java.lang.String r29, org.json.JSONObject r30, java.lang.String r31, java.lang.String r32, com.revenuecat.purchases.models.PurchaseType r33, java.lang.String r34, java.lang.String r35, com.revenuecat.purchases.ProrationMode r36) {
        /*
            r20 = this;
            r0 = r31
            r1 = r36
            java.lang.String r2 = "productIds"
            r5 = r22
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r2)
            java.lang.String r2 = "type"
            r6 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r2)
            java.lang.String r2 = "purchaseToken"
            r9 = r26
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r2)
            java.lang.String r2 = "purchaseState"
            r10 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r2)
            java.lang.String r2 = "originalJson"
            r13 = r30
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r2)
            java.lang.String r2 = "purchaseType"
            r15 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r2)
            r2 = 0
            if (r0 == 0) goto L_0x0038
            com.revenuecat.purchases.PresentedOfferingContext r3 = new com.revenuecat.purchases.PresentedOfferingContext
            r3.<init>(r0)
            r14 = r3
            goto L_0x0039
        L_0x0038:
            r14 = r2
        L_0x0039:
            boolean r0 = r1 instanceof com.revenuecat.purchases.models.GoogleProrationMode
            if (r0 == 0) goto L_0x0041
            r0 = r1
            com.revenuecat.purchases.models.GoogleProrationMode r0 = (com.revenuecat.purchases.models.GoogleProrationMode) r0
            goto L_0x0042
        L_0x0041:
            r0 = r2
        L_0x0042:
            if (r0 == 0) goto L_0x0048
            com.revenuecat.purchases.models.GoogleReplacementMode r2 = r0.getAsGoogleReplacementMode$purchases_defaultsRelease()
        L_0x0048:
            r19 = r2
            com.revenuecat.purchases.ReplacementMode r19 = (com.revenuecat.purchases.ReplacementMode) r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r15 = r32
            r16 = r33
            r17 = r34
            r18 = r35
            r3.<init>((java.lang.String) r4, (java.util.List<java.lang.String>) r5, (com.revenuecat.purchases.ProductType) r6, (long) r7, (java.lang.String) r9, (com.revenuecat.purchases.models.PurchaseState) r10, (java.lang.Boolean) r11, (java.lang.String) r12, (org.json.JSONObject) r13, (com.revenuecat.purchases.PresentedOfferingContext) r14, (java.lang.String) r15, (com.revenuecat.purchases.models.PurchaseType) r16, (java.lang.String) r17, (java.lang.String) r18, (com.revenuecat.purchases.ReplacementMode) r19)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.StoreTransaction.<init>(java.lang.String, java.util.List, com.revenuecat.purchases.ProductType, long, java.lang.String, com.revenuecat.purchases.models.PurchaseState, java.lang.Boolean, java.lang.String, org.json.JSONObject, java.lang.String, java.lang.String, com.revenuecat.purchases.models.PurchaseType, java.lang.String, java.lang.String, com.revenuecat.purchases.ProrationMode):void");
    }

    public final ProrationMode getProrationMode() {
        ReplacementMode replacementMode2 = this.replacementMode;
        GoogleProrationMode googleProrationMode = null;
        GoogleReplacementMode googleReplacementMode = replacementMode2 instanceof GoogleReplacementMode ? (GoogleReplacementMode) replacementMode2 : null;
        if (googleReplacementMode != null) {
            googleProrationMode = googleReplacementMode.getAsGoogleProrationMode$purchases_defaultsRelease();
        }
        return googleProrationMode;
    }

    public final String getPresentedOfferingIdentifier() {
        PresentedOfferingContext presentedOfferingContext2 = this.presentedOfferingContext;
        if (presentedOfferingContext2 != null) {
            return presentedOfferingContext2.getOfferingIdentifier();
        }
        return null;
    }

    public boolean equals(Object obj) {
        return (obj instanceof StoreTransaction) && Intrinsics.areEqual((Object) new ComparableData(this), (Object) new ComparableData((StoreTransaction) obj));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }
}
