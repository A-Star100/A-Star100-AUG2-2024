package com.revenuecat.purchases;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.models.Transaction;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u001c\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002Bu\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\b\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\u0013\u001a\u00020\u0003¢\u0006\u0002\u0010\u0014J$\u0010F\u001a\b\u0012\u0004\u0012\u00020\b0\u00162\u0014\u0010G\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007H\u0002J\t\u0010H\u001a\u00020\u0005HÆ\u0003J\t\u0010I\u001a\u00020\u0003HÂ\u0003J\u0017\u0010J\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007HÆ\u0003J\u0017\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007HÆ\u0003J\t\u0010L\u001a\u00020\tHÆ\u0003J\t\u0010M\u001a\u00020\rHÆ\u0003J\t\u0010N\u001a\u00020\tHÆ\u0003J\t\u0010O\u001a\u00020\bHÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0011HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0001\u0010R\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u00072\b\b\u0002\u0010\u000b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u0013\u001a\u00020\u0003HÆ\u0001J\t\u0010S\u001a\u00020\rHÖ\u0001J\u0013\u0010T\u001a\u00020U2\b\u0010V\u001a\u0004\u0018\u00010WH\u0002J\u0010\u0010X\u001a\u0004\u0018\u00010\t2\u0006\u0010Y\u001a\u00020\bJ\u0010\u0010Z\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020\bJ\u0012\u0010\\\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\bH\u0007J\u0010\u0010^\u001a\u0004\u0018\u00010\t2\u0006\u0010Y\u001a\u00020\bJ\u0010\u0010_\u001a\u0004\u0018\u00010\t2\u0006\u0010[\u001a\u00020\bJ\u0012\u0010`\u001a\u0004\u0018\u00010\t2\u0006\u0010]\u001a\u00020\bH\u0007J\b\u0010a\u001a\u00020\rH\u0016J\b\u0010b\u001a\u00020\bH\u0016J\u0019\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020f2\u0006\u0010g\u001a\u00020\rHÖ\u0001R'\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u00168FX\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR'\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u00168FX\u0002¢\u0006\u0012\n\u0004\b#\u0010\u001c\u0012\u0004\b!\u0010\u0018\u001a\u0004\b\"\u0010\u001aR'\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u00168FX\u0002¢\u0006\u0012\n\u0004\b'\u0010\u001c\u0012\u0004\b%\u0010\u0018\u001a\u0004\b&\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010\u0013\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R#\u0010,\u001a\u0004\u0018\u00010\t8FX\u0002¢\u0006\u0012\n\u0004\b/\u0010\u001c\u0012\u0004\b-\u0010\u0018\u001a\u0004\b.\u0010+R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R'\u00102\u001a\b\u0012\u0004\u0012\u000204038FX\u0002¢\u0006\u0012\n\u0004\b8\u0010\u001c\u0012\u0004\b5\u0010\u0018\u001a\u0004\b6\u00107R\u0011\u0010\u000f\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b;\u0010+R\u001a\u0010<\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b=\u0010\u0018\u001a\u0004\b>\u0010?R\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b@\u0010+R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u001c\u0010C\u001a\n D*\u0004\u0018\u00010\u00030\u0003X\u0004¢\u0006\b\n\u0000\u0012\u0004\bE\u0010\u0018¨\u0006h"}, d2 = {"Lcom/revenuecat/purchases/CustomerInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", "entitlements", "Lcom/revenuecat/purchases/EntitlementInfos;", "allExpirationDatesByProduct", "", "", "Ljava/util/Date;", "allPurchaseDatesByProduct", "requestDate", "schemaVersion", "", "firstSeen", "originalAppUserId", "managementURL", "Landroid/net/Uri;", "originalPurchaseDate", "jsonObject", "(Lcom/revenuecat/purchases/EntitlementInfos;Ljava/util/Map;Ljava/util/Map;Ljava/util/Date;ILjava/util/Date;Ljava/lang/String;Landroid/net/Uri;Ljava/util/Date;Lorg/json/JSONObject;)V", "activeSubscriptions", "", "getActiveSubscriptions$annotations", "()V", "getActiveSubscriptions", "()Ljava/util/Set;", "activeSubscriptions$delegate", "Lkotlin/Lazy;", "getAllExpirationDatesByProduct", "()Ljava/util/Map;", "getAllPurchaseDatesByProduct", "allPurchasedProductIds", "getAllPurchasedProductIds$annotations", "getAllPurchasedProductIds", "allPurchasedProductIds$delegate", "allPurchasedSkus", "getAllPurchasedSkus$annotations", "getAllPurchasedSkus", "allPurchasedSkus$delegate", "getEntitlements", "()Lcom/revenuecat/purchases/EntitlementInfos;", "getFirstSeen", "()Ljava/util/Date;", "latestExpirationDate", "getLatestExpirationDate$annotations", "getLatestExpirationDate", "latestExpirationDate$delegate", "getManagementURL", "()Landroid/net/Uri;", "nonSubscriptionTransactions", "", "Lcom/revenuecat/purchases/models/Transaction;", "getNonSubscriptionTransactions$annotations", "getNonSubscriptionTransactions", "()Ljava/util/List;", "nonSubscriptionTransactions$delegate", "getOriginalAppUserId", "()Ljava/lang/String;", "getOriginalPurchaseDate", "rawData", "getRawData$annotations", "getRawData", "()Lorg/json/JSONObject;", "getRequestDate", "getSchemaVersion", "()I", "subscriberJSONObject", "kotlin.jvm.PlatformType", "getSubscriberJSONObject$annotations", "activeIdentifiers", "expirations", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "", "other", "", "getExpirationDateForEntitlement", "entitlement", "getExpirationDateForProductId", "productId", "getExpirationDateForSku", "sku", "getPurchaseDateForEntitlement", "getPurchaseDateForProductId", "getPurchaseDateForSku", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CustomerInfo.kt */
public final class CustomerInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<CustomerInfo> CREATOR = new Creator();
    private final Lazy activeSubscriptions$delegate = LazyKt.lazy(new CustomerInfo$activeSubscriptions$2(this));
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;
    private final Lazy allPurchasedProductIds$delegate = LazyKt.lazy(new CustomerInfo$allPurchasedProductIds$2(this));
    private final Lazy allPurchasedSkus$delegate = LazyKt.lazy(new CustomerInfo$allPurchasedSkus$2(this));
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final JSONObject jsonObject;
    private final Lazy latestExpirationDate$delegate = LazyKt.lazy(new CustomerInfo$latestExpirationDate$2(this));
    private final Uri managementURL;
    private final Lazy nonSubscriptionTransactions$delegate = LazyKt.lazy(new CustomerInfo$nonSubscriptionTransactions$2(this));
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final Date requestDate;
    private final int schemaVersion;
    /* access modifiers changed from: private */
    public final JSONObject subscriberJSONObject;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CustomerInfo.kt */
    public static final class Creator implements Parcelable.Creator<CustomerInfo> {
        public final CustomerInfo createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            EntitlementInfos createFromParcel = EntitlementInfos.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), parcel.readSerializable());
            }
            Map map = linkedHashMap;
            int readInt2 = parcel.readInt();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(readInt2);
            for (int i2 = 0; i2 != readInt2; i2++) {
                linkedHashMap2.put(parcel.readString(), parcel.readSerializable());
            }
            return new CustomerInfo(createFromParcel, map, linkedHashMap2, (Date) parcel.readSerializable(), parcel.readInt(), (Date) parcel.readSerializable(), parcel.readString(), (Uri) parcel.readParcelable(CustomerInfo.class.getClassLoader()), (Date) parcel.readSerializable(), JSONObjectParceler.INSTANCE.create(parcel));
        }

        public final CustomerInfo[] newArray(int i) {
            return new CustomerInfo[i];
        }
    }

    private final JSONObject component10() {
        return this.jsonObject;
    }

    public static /* synthetic */ CustomerInfo copy$default(CustomerInfo customerInfo, EntitlementInfos entitlementInfos, Map map, Map map2, Date date, int i, Date date2, String str, Uri uri, Date date3, JSONObject jSONObject, int i2, Object obj) {
        CustomerInfo customerInfo2 = customerInfo;
        int i3 = i2;
        return customerInfo.copy((i3 & 1) != 0 ? customerInfo2.entitlements : entitlementInfos, (i3 & 2) != 0 ? customerInfo2.allExpirationDatesByProduct : map, (i3 & 4) != 0 ? customerInfo2.allPurchaseDatesByProduct : map2, (i3 & 8) != 0 ? customerInfo2.requestDate : date, (i3 & 16) != 0 ? customerInfo2.schemaVersion : i, (i3 & 32) != 0 ? customerInfo2.firstSeen : date2, (i3 & 64) != 0 ? customerInfo2.originalAppUserId : str, (i3 & 128) != 0 ? customerInfo2.managementURL : uri, (i3 & 256) != 0 ? customerInfo2.originalPurchaseDate : date3, (i3 & 512) != 0 ? customerInfo2.jsonObject : jSONObject);
    }

    public static /* synthetic */ void getActiveSubscriptions$annotations() {
    }

    public static /* synthetic */ void getAllPurchasedProductIds$annotations() {
    }

    @Deprecated(message = "Use allPurchasedProductIds instead", replaceWith = @ReplaceWith(expression = "allPurchasedProductIds", imports = {}))
    public static /* synthetic */ void getAllPurchasedSkus$annotations() {
    }

    public static /* synthetic */ void getLatestExpirationDate$annotations() {
    }

    public static /* synthetic */ void getNonSubscriptionTransactions$annotations() {
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    private static /* synthetic */ void getSubscriberJSONObject$annotations() {
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

    public final Date component4() {
        return this.requestDate;
    }

    public final int component5() {
        return this.schemaVersion;
    }

    public final Date component6() {
        return this.firstSeen;
    }

    public final String component7() {
        return this.originalAppUserId;
    }

    public final Uri component8() {
        return this.managementURL;
    }

    public final Date component9() {
        return this.originalPurchaseDate;
    }

    public final CustomerInfo copy(EntitlementInfos entitlementInfos, Map<String, ? extends Date> map, Map<String, ? extends Date> map2, Date date, int i, Date date2, String str, Uri uri, Date date3, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(entitlementInfos, CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        Intrinsics.checkNotNullParameter(map, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(map2, "allPurchaseDatesByProduct");
        Date date4 = date;
        Intrinsics.checkNotNullParameter(date4, "requestDate");
        Date date5 = date2;
        Intrinsics.checkNotNullParameter(date5, "firstSeen");
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "originalAppUserId");
        JSONObject jSONObject2 = jSONObject;
        Intrinsics.checkNotNullParameter(jSONObject2, "jsonObject");
        return new CustomerInfo(entitlementInfos, map, map2, date4, i, date5, str2, uri, date3, jSONObject2);
    }

    public int describeContents() {
        return 0;
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

    public final Uri getManagementURL() {
        return this.managementURL;
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public JSONObject getRawData() {
        return this.jsonObject;
    }

    public final Date getRequestDate() {
        return this.requestDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        this.entitlements.writeToParcel(parcel, i);
        Map<String, Date> map = this.allExpirationDatesByProduct;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            parcel.writeSerializable((Serializable) next.getValue());
        }
        Map<String, Date> map2 = this.allPurchaseDatesByProduct;
        parcel.writeInt(map2.size());
        for (Map.Entry next2 : map2.entrySet()) {
            parcel.writeString((String) next2.getKey());
            parcel.writeSerializable((Serializable) next2.getValue());
        }
        parcel.writeSerializable(this.requestDate);
        parcel.writeInt(this.schemaVersion);
        parcel.writeSerializable(this.firstSeen);
        parcel.writeString(this.originalAppUserId);
        parcel.writeParcelable(this.managementURL, i);
        parcel.writeSerializable(this.originalPurchaseDate);
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, i);
    }

    public CustomerInfo(EntitlementInfos entitlementInfos, Map<String, ? extends Date> map, Map<String, ? extends Date> map2, Date date, int i, Date date2, String str, Uri uri, Date date3, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(entitlementInfos, CustomerInfoResponseJsonKeys.ENTITLEMENTS);
        Intrinsics.checkNotNullParameter(map, "allExpirationDatesByProduct");
        Intrinsics.checkNotNullParameter(map2, "allPurchaseDatesByProduct");
        Intrinsics.checkNotNullParameter(date, "requestDate");
        Intrinsics.checkNotNullParameter(date2, "firstSeen");
        Intrinsics.checkNotNullParameter(str, "originalAppUserId");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        this.entitlements = entitlementInfos;
        this.allExpirationDatesByProduct = map;
        this.allPurchaseDatesByProduct = map2;
        this.requestDate = date;
        this.schemaVersion = i;
        this.firstSeen = date2;
        this.originalAppUserId = str;
        this.managementURL = uri;
        this.originalPurchaseDate = date3;
        this.jsonObject = jSONObject;
        this.subscriberJSONObject = jSONObject.getJSONObject(CustomerInfoResponseJsonKeys.SUBSCRIBER);
    }

    public final Set<String> getActiveSubscriptions() {
        return (Set) this.activeSubscriptions$delegate.getValue();
    }

    public final Set<String> getAllPurchasedSkus() {
        return (Set) this.allPurchasedSkus$delegate.getValue();
    }

    public final Set<String> getAllPurchasedProductIds() {
        return (Set) this.allPurchasedProductIds$delegate.getValue();
    }

    public final Date getLatestExpirationDate() {
        return (Date) this.latestExpirationDate$delegate.getValue();
    }

    public final List<Transaction> getNonSubscriptionTransactions() {
        return (List) this.nonSubscriptionTransactions$delegate.getValue();
    }

    @Deprecated(message = "Use getExpirationDateForProductId instead", replaceWith = @ReplaceWith(expression = "getExpirationDateForProductId", imports = {}))
    public final Date getExpirationDateForSku(String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        return this.allExpirationDatesByProduct.get(str);
    }

    public final Date getExpirationDateForProductId(String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        return this.allExpirationDatesByProduct.get(str);
    }

    @Deprecated(message = "Use getPurchaseDateForProductId instead", replaceWith = @ReplaceWith(expression = "getPurchaseDateForProductId", imports = {}))
    public final Date getPurchaseDateForSku(String str) {
        Intrinsics.checkNotNullParameter(str, "sku");
        return this.allPurchaseDatesByProduct.get(str);
    }

    public final Date getPurchaseDateForProductId(String str) {
        Intrinsics.checkNotNullParameter(str, "productId");
        return this.allPurchaseDatesByProduct.get(str);
    }

    public final Date getExpirationDateForEntitlement(String str) {
        Intrinsics.checkNotNullParameter(str, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(str);
        if (entitlementInfo != null) {
            return entitlementInfo.getExpirationDate();
        }
        return null;
    }

    public final Date getPurchaseDateForEntitlement(String str) {
        Intrinsics.checkNotNullParameter(str, "entitlement");
        EntitlementInfo entitlementInfo = this.entitlements.getAll().get(str);
        if (entitlementInfo != null) {
            return entitlementInfo.getLatestPurchaseDate();
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("<CustomerInfo\n latestExpirationDate: ");
        sb.append(getLatestExpirationDate());
        sb.append("\nactiveSubscriptions:  ");
        Iterable<String> activeSubscriptions = getActiveSubscriptions();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(activeSubscriptions, 10));
        for (String str : activeSubscriptions) {
            arrayList.add(TuplesKt.to(str, MapsKt.mapOf(TuplesKt.to("expiresDate", getExpirationDateForProductId(str)))));
        }
        sb.append(MapsKt.toMap((List) arrayList));
        sb.append(",\nactiveEntitlements: ");
        Map<String, EntitlementInfo> active = this.entitlements.getActive();
        Collection arrayList2 = new ArrayList(active.size());
        for (Map.Entry<String, EntitlementInfo> obj : active.entrySet()) {
            arrayList2.add(obj.toString());
        }
        sb.append((List) arrayList2);
        sb.append(",\nentitlements: ");
        Map<String, EntitlementInfo> all = this.entitlements.getAll();
        Collection arrayList3 = new ArrayList(all.size());
        for (Map.Entry<String, EntitlementInfo> obj2 : all.entrySet()) {
            arrayList3.add(obj2.toString());
        }
        sb.append((List) arrayList3);
        sb.append(",\nnonSubscriptionTransactions: ");
        sb.append(getNonSubscriptionTransactions());
        sb.append(",\nrequestDate: ");
        sb.append(this.requestDate);
        sb.append("\n>");
        return sb.toString();
    }

    public boolean equals(Object obj) {
        return (obj instanceof CustomerInfo) && Intrinsics.areEqual((Object) new ComparableData(this), (Object) new ComparableData((CustomerInfo) obj));
    }

    public int hashCode() {
        return new ComparableData(this).hashCode();
    }

    /* access modifiers changed from: private */
    public final Set<String> activeIdentifiers(Map<String, ? extends Date> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (DateHelper.Companion.m1109isDateActiveSxA4cEA$default(DateHelper.Companion, (Date) next.getValue(), this.requestDate, 0, 4, (Object) null).isActive()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        return linkedHashMap.keySet();
    }
}
