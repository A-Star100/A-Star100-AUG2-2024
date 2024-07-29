package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.models.RawDataContainer;
import com.revenuecat.purchases.utils.JSONObjectParceler;
import java.util.Date;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0001\b\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003¢\u0006\u0002\u0010\u0019B\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u001b¢\u0006\u0002\u0010\u001cJ\t\u00106\u001a\u00020\u0005HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010;\u001a\u00020\u0017HÆ\u0003J\t\u0010<\u001a\u00020\u0003HÂ\u0003J\t\u0010=\u001a\u00020\u001bHÆ\u0003J\t\u0010>\u001a\u00020\u0007HÆ\u0003J\t\u0010?\u001a\u00020\u0007HÆ\u0003J\t\u0010@\u001a\u00020\nHÆ\u0003J\t\u0010A\u001a\u00020\fHÆ\u0003J\t\u0010B\u001a\u00020\fHÆ\u0003J\u000b\u0010C\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010D\u001a\u00020\u0010HÆ\u0003J\t\u0010E\u001a\u00020\u0005HÆ\u0003J±\u0001\u0010F\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00032\b\b\u0002\u0010\u001a\u001a\u00020\u001bHÆ\u0001J\t\u0010G\u001a\u00020HHÖ\u0001J\u0013\u0010I\u001a\u00020\u00072\b\u0010J\u001a\u0004\u0018\u00010KH\u0002J\b\u0010L\u001a\u00020HH\u0016J\b\u0010M\u001a\u00020\u0005H\u0016J\u0019\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020HHÖ\u0001R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\"R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\"R\u000e\u0010\u0018\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010!R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020\u00038VX\u0004¢\u0006\f\u0012\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001eR\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b5\u0010\"¨\u0006S"}, d2 = {"Lcom/revenuecat/purchases/EntitlementInfo;", "Landroid/os/Parcelable;", "Lcom/revenuecat/purchases/models/RawDataContainer;", "Lorg/json/JSONObject;", "identifier", "", "isActive", "", "willRenew", "periodType", "Lcom/revenuecat/purchases/PeriodType;", "latestPurchaseDate", "Ljava/util/Date;", "originalPurchaseDate", "expirationDate", "store", "Lcom/revenuecat/purchases/Store;", "productIdentifier", "productPlanIdentifier", "isSandbox", "unsubscribeDetectedAt", "billingIssueDetectedAt", "ownershipType", "Lcom/revenuecat/purchases/OwnershipType;", "jsonObject", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lorg/json/JSONObject;)V", "verification", "Lcom/revenuecat/purchases/VerificationResult;", "(Ljava/lang/String;ZZLcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;Ljava/lang/String;Ljava/lang/String;ZLjava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lorg/json/JSONObject;Lcom/revenuecat/purchases/VerificationResult;)V", "getBillingIssueDetectedAt", "()Ljava/util/Date;", "getExpirationDate", "getIdentifier", "()Ljava/lang/String;", "()Z", "getLatestPurchaseDate", "getOriginalPurchaseDate", "getOwnershipType", "()Lcom/revenuecat/purchases/OwnershipType;", "getPeriodType", "()Lcom/revenuecat/purchases/PeriodType;", "getProductIdentifier", "getProductPlanIdentifier", "rawData", "getRawData$annotations", "()V", "getRawData", "()Lorg/json/JSONObject;", "getStore", "()Lcom/revenuecat/purchases/Store;", "getUnsubscribeDetectedAt", "getVerification", "()Lcom/revenuecat/purchases/VerificationResult;", "getWillRenew", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EntitlementInfo.kt */
public final class EntitlementInfo implements Parcelable, RawDataContainer<JSONObject> {
    public static final Parcelable.Creator<EntitlementInfo> CREATOR = new Creator();
    private final Date billingIssueDetectedAt;
    private final Date expirationDate;
    private final String identifier;
    private final boolean isActive;
    private final boolean isSandbox;
    private final JSONObject jsonObject;
    private final Date latestPurchaseDate;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final String productIdentifier;
    private final String productPlanIdentifier;
    private final Store store;
    private final Date unsubscribeDetectedAt;
    private final VerificationResult verification;
    private final boolean willRenew;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EntitlementInfo.kt */
    public static final class Creator implements Parcelable.Creator<EntitlementInfo> {
        public final EntitlementInfo createFromParcel(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            return new EntitlementInfo(parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, PeriodType.valueOf(parcel.readString()), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), Store.valueOf(parcel.readString()), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (Date) parcel.readSerializable(), (Date) parcel.readSerializable(), OwnershipType.valueOf(parcel.readString()), JSONObjectParceler.INSTANCE.create(parcel2), VerificationResult.valueOf(parcel.readString()));
        }

        public final EntitlementInfo[] newArray(int i) {
            return new EntitlementInfo[i];
        }
    }

    private final JSONObject component15() {
        return this.jsonObject;
    }

    public static /* synthetic */ EntitlementInfo copy$default(EntitlementInfo entitlementInfo, String str, boolean z, boolean z2, PeriodType periodType2, Date date, Date date2, Date date3, Store store2, String str2, String str3, boolean z3, Date date4, Date date5, OwnershipType ownershipType2, JSONObject jSONObject, VerificationResult verificationResult, int i, Object obj) {
        EntitlementInfo entitlementInfo2 = entitlementInfo;
        int i2 = i;
        return entitlementInfo.copy((i2 & 1) != 0 ? entitlementInfo2.identifier : str, (i2 & 2) != 0 ? entitlementInfo2.isActive : z, (i2 & 4) != 0 ? entitlementInfo2.willRenew : z2, (i2 & 8) != 0 ? entitlementInfo2.periodType : periodType2, (i2 & 16) != 0 ? entitlementInfo2.latestPurchaseDate : date, (i2 & 32) != 0 ? entitlementInfo2.originalPurchaseDate : date2, (i2 & 64) != 0 ? entitlementInfo2.expirationDate : date3, (i2 & 128) != 0 ? entitlementInfo2.store : store2, (i2 & 256) != 0 ? entitlementInfo2.productIdentifier : str2, (i2 & 512) != 0 ? entitlementInfo2.productPlanIdentifier : str3, (i2 & 1024) != 0 ? entitlementInfo2.isSandbox : z3, (i2 & 2048) != 0 ? entitlementInfo2.unsubscribeDetectedAt : date4, (i2 & 4096) != 0 ? entitlementInfo2.billingIssueDetectedAt : date5, (i2 & 8192) != 0 ? entitlementInfo2.ownershipType : ownershipType2, (i2 & 16384) != 0 ? entitlementInfo2.jsonObject : jSONObject, (i2 & 32768) != 0 ? entitlementInfo2.verification : verificationResult);
    }

    public static /* synthetic */ void getRawData$annotations() {
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component10() {
        return this.productPlanIdentifier;
    }

    public final boolean component11() {
        return this.isSandbox;
    }

    public final Date component12() {
        return this.unsubscribeDetectedAt;
    }

    public final Date component13() {
        return this.billingIssueDetectedAt;
    }

    public final OwnershipType component14() {
        return this.ownershipType;
    }

    public final VerificationResult component16() {
        return this.verification;
    }

    public final boolean component2() {
        return this.isActive;
    }

    public final boolean component3() {
        return this.willRenew;
    }

    public final PeriodType component4() {
        return this.periodType;
    }

    public final Date component5() {
        return this.latestPurchaseDate;
    }

    public final Date component6() {
        return this.originalPurchaseDate;
    }

    public final Date component7() {
        return this.expirationDate;
    }

    public final Store component8() {
        return this.store;
    }

    public final String component9() {
        return this.productIdentifier;
    }

    public final EntitlementInfo copy(String str, boolean z, boolean z2, PeriodType periodType2, Date date, Date date2, Date date3, Store store2, String str2, String str3, boolean z3, Date date4, Date date5, OwnershipType ownershipType2, JSONObject jSONObject, VerificationResult verificationResult) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "identifier");
        Intrinsics.checkNotNullParameter(periodType2, "periodType");
        Intrinsics.checkNotNullParameter(date, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(date2, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store2, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str2, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType2, "ownershipType");
        Intrinsics.checkNotNullParameter(jSONObject, "jsonObject");
        Intrinsics.checkNotNullParameter(verificationResult, "verification");
        return new EntitlementInfo(str4, z, z2, periodType2, date, date2, date3, store2, str2, str3, z3, date4, date5, ownershipType2, jSONObject, verificationResult);
    }

    public int describeContents() {
        return 0;
    }

    public final Date getBillingIssueDetectedAt() {
        return this.billingIssueDetectedAt;
    }

    public final Date getExpirationDate() {
        return this.expirationDate;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Date getLatestPurchaseDate() {
        return this.latestPurchaseDate;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public JSONObject getRawData() {
        return this.jsonObject;
    }

    public final Store getStore() {
        return this.store;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    public final VerificationResult getVerification() {
        return this.verification;
    }

    public final boolean getWillRenew() {
        return this.willRenew;
    }

    public final boolean isActive() {
        return this.isActive;
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.identifier);
        parcel.writeInt(this.isActive ? 1 : 0);
        parcel.writeInt(this.willRenew ? 1 : 0);
        parcel.writeString(this.periodType.name());
        parcel.writeSerializable(this.latestPurchaseDate);
        parcel.writeSerializable(this.originalPurchaseDate);
        parcel.writeSerializable(this.expirationDate);
        parcel.writeString(this.store.name());
        parcel.writeString(this.productIdentifier);
        parcel.writeString(this.productPlanIdentifier);
        parcel.writeInt(this.isSandbox ? 1 : 0);
        parcel.writeSerializable(this.unsubscribeDetectedAt);
        parcel.writeSerializable(this.billingIssueDetectedAt);
        parcel.writeString(this.ownershipType.name());
        JSONObjectParceler.INSTANCE.write(this.jsonObject, parcel, i);
        parcel.writeString(this.verification.name());
    }

    public EntitlementInfo(String str, boolean z, boolean z2, PeriodType periodType2, Date date, Date date2, Date date3, Store store2, String str2, String str3, boolean z3, Date date4, Date date5, OwnershipType ownershipType2, JSONObject jSONObject, VerificationResult verificationResult) {
        Date date6 = date;
        Date date7 = date2;
        Store store3 = store2;
        String str4 = str2;
        OwnershipType ownershipType3 = ownershipType2;
        JSONObject jSONObject2 = jSONObject;
        VerificationResult verificationResult2 = verificationResult;
        Intrinsics.checkNotNullParameter(str, "identifier");
        Intrinsics.checkNotNullParameter(periodType2, "periodType");
        Intrinsics.checkNotNullParameter(date6, "latestPurchaseDate");
        Intrinsics.checkNotNullParameter(date7, "originalPurchaseDate");
        Intrinsics.checkNotNullParameter(store3, ProductResponseJsonKeys.STORE);
        Intrinsics.checkNotNullParameter(str4, "productIdentifier");
        Intrinsics.checkNotNullParameter(ownershipType3, "ownershipType");
        Intrinsics.checkNotNullParameter(jSONObject2, "jsonObject");
        Intrinsics.checkNotNullParameter(verificationResult2, "verification");
        this.identifier = str;
        this.isActive = z;
        this.willRenew = z2;
        this.periodType = periodType2;
        this.latestPurchaseDate = date6;
        this.originalPurchaseDate = date7;
        this.expirationDate = date3;
        this.store = store3;
        this.productIdentifier = str4;
        this.productPlanIdentifier = str3;
        this.isSandbox = z3;
        this.unsubscribeDetectedAt = date4;
        this.billingIssueDetectedAt = date5;
        this.ownershipType = ownershipType3;
        this.jsonObject = jSONObject2;
        this.verification = verificationResult2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ EntitlementInfo(java.lang.String r19, boolean r20, boolean r21, com.revenuecat.purchases.PeriodType r22, java.util.Date r23, java.util.Date r24, java.util.Date r25, com.revenuecat.purchases.Store r26, java.lang.String r27, java.lang.String r28, boolean r29, java.util.Date r30, java.util.Date r31, com.revenuecat.purchases.OwnershipType r32, org.json.JSONObject r33, com.revenuecat.purchases.VerificationResult r34, int r35, kotlin.jvm.internal.DefaultConstructorMarker r36) {
        /*
            r18 = this;
            r0 = 32768(0x8000, float:4.5918E-41)
            r0 = r35 & r0
            if (r0 == 0) goto L_0x000c
            com.revenuecat.purchases.VerificationResult r0 = com.revenuecat.purchases.VerificationResult.NOT_REQUESTED
            r17 = r0
            goto L_0x000e
        L_0x000c:
            r17 = r34
        L_0x000e:
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r12 = r29
            r13 = r30
            r14 = r31
            r15 = r32
            r16 = r33
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.EntitlementInfo.<init>(java.lang.String, boolean, boolean, com.revenuecat.purchases.PeriodType, java.util.Date, java.util.Date, java.util.Date, com.revenuecat.purchases.Store, java.lang.String, java.lang.String, boolean, java.util.Date, java.util.Date, com.revenuecat.purchases.OwnershipType, org.json.JSONObject, com.revenuecat.purchases.VerificationResult, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.Deprecated(message = "Use the constructor with the verification parameter", replaceWith = @kotlin.ReplaceWith(expression = "EntitlementInfo(identifier, isActive, willRenew, periodType, latestPurchaseDate, originalPurchaseDate, expirationDate, store, productIdentifier, productPlanIdentifier, isSandbox, unsubscribeDetectedAt, billingIssueDetectedAt, ownershipType, jsonObject, VerificationResult.NOT_REQUESTED)", imports = {"com.revenuecat.purchases.VerificationResult"}))
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public EntitlementInfo(java.lang.String r20, boolean r21, boolean r22, com.revenuecat.purchases.PeriodType r23, java.util.Date r24, java.util.Date r25, java.util.Date r26, com.revenuecat.purchases.Store r27, java.lang.String r28, java.lang.String r29, boolean r30, java.util.Date r31, java.util.Date r32, com.revenuecat.purchases.OwnershipType r33, org.json.JSONObject r34) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r22
            r4 = r23
            r5 = r24
            r6 = r25
            r7 = r26
            r8 = r27
            r9 = r28
            r10 = r29
            r11 = r30
            r12 = r31
            r13 = r32
            r14 = r33
            r15 = r34
            r17 = r0
            java.lang.String r0 = "identifier"
            r18 = r1
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "periodType"
            r1 = r23
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "latestPurchaseDate"
            r1 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "originalPurchaseDate"
            r1 = r25
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "store"
            r1 = r27
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "productIdentifier"
            r1 = r28
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "ownershipType"
            r1 = r33
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "jsonObject"
            r1 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            com.revenuecat.purchases.VerificationResult r16 = com.revenuecat.purchases.VerificationResult.NOT_REQUESTED
            r0 = r17
            r1 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.EntitlementInfo.<init>(java.lang.String, boolean, boolean, com.revenuecat.purchases.PeriodType, java.util.Date, java.util.Date, java.util.Date, com.revenuecat.purchases.Store, java.lang.String, java.lang.String, boolean, java.util.Date, java.util.Date, com.revenuecat.purchases.OwnershipType, org.json.JSONObject):void");
    }

    public String toString() {
        return "EntitlementInfo(identifier='" + this.identifier + "', isActive=" + this.isActive + ", willRenew=" + this.willRenew + ", periodType=" + this.periodType + ", latestPurchaseDate=" + this.latestPurchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expirationDate=" + this.expirationDate + ", store=" + this.store + ", productIdentifier='" + this.productIdentifier + "', productPlanIdentifier='" + this.productPlanIdentifier + "', isSandbox=" + this.isSandbox + ", unsubscribeDetectedAt=" + this.unsubscribeDetectedAt + ", billingIssueDetectedAt=" + this.billingIssueDetectedAt + ", ownershipType=" + this.ownershipType + ", verification=" + this.verification + ')';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfo");
        EntitlementInfo entitlementInfo = (EntitlementInfo) obj;
        return Intrinsics.areEqual((Object) this.identifier, (Object) entitlementInfo.identifier) && this.isActive == entitlementInfo.isActive && this.willRenew == entitlementInfo.willRenew && this.periodType == entitlementInfo.periodType && Intrinsics.areEqual((Object) this.latestPurchaseDate, (Object) entitlementInfo.latestPurchaseDate) && Intrinsics.areEqual((Object) this.originalPurchaseDate, (Object) entitlementInfo.originalPurchaseDate) && Intrinsics.areEqual((Object) this.expirationDate, (Object) entitlementInfo.expirationDate) && this.store == entitlementInfo.store && Intrinsics.areEqual((Object) this.productIdentifier, (Object) entitlementInfo.productIdentifier) && Intrinsics.areEqual((Object) this.productPlanIdentifier, (Object) entitlementInfo.productPlanIdentifier) && this.isSandbox == entitlementInfo.isSandbox && Intrinsics.areEqual((Object) this.unsubscribeDetectedAt, (Object) entitlementInfo.unsubscribeDetectedAt) && Intrinsics.areEqual((Object) this.billingIssueDetectedAt, (Object) entitlementInfo.billingIssueDetectedAt) && this.ownershipType == entitlementInfo.ownershipType && this.verification == entitlementInfo.verification;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.identifier.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.isActive)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.willRenew)) * 31) + this.periodType.hashCode()) * 31) + this.latestPurchaseDate.hashCode()) * 31) + this.originalPurchaseDate.hashCode()) * 31;
        Date date = this.expirationDate;
        int i = 0;
        int hashCode2 = (((((hashCode + (date != null ? date.hashCode() : 0)) * 31) + this.store.hashCode()) * 31) + this.productIdentifier.hashCode()) * 31;
        String str = this.productPlanIdentifier;
        int hashCode3 = (((hashCode2 + (str != null ? str.hashCode() : 0)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.isSandbox)) * 31;
        Date date2 = this.unsubscribeDetectedAt;
        int hashCode4 = (hashCode3 + (date2 != null ? date2.hashCode() : 0)) * 31;
        Date date3 = this.billingIssueDetectedAt;
        if (date3 != null) {
            i = date3.hashCode();
        }
        return ((hashCode4 + i) * 31) + this.ownershipType.hashCode();
    }
}
