package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\b\u0017\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006B!\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0017\u001a\u00020\u0004H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0011HÖ\u0001R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/EntitlementInfos;", "Landroid/os/Parcelable;", "all", "", "", "Lcom/revenuecat/purchases/EntitlementInfo;", "(Ljava/util/Map;)V", "verification", "Lcom/revenuecat/purchases/VerificationResult;", "(Ljava/util/Map;Lcom/revenuecat/purchases/VerificationResult;)V", "active", "getActive", "()Ljava/util/Map;", "getAll", "getVerification", "()Lcom/revenuecat/purchases/VerificationResult;", "describeContents", "", "equals", "", "other", "", "get", "s", "hashCode", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EntitlementInfos.kt */
public final class EntitlementInfos implements Parcelable {
    public static final Parcelable.Creator<EntitlementInfos> CREATOR = new Creator();
    private final Map<String, EntitlementInfo> active;
    private final Map<String, EntitlementInfo> all;
    private final VerificationResult verification;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EntitlementInfos.kt */
    public static final class Creator implements Parcelable.Creator<EntitlementInfos> {
        public final EntitlementInfos createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            for (int i = 0; i != readInt; i++) {
                linkedHashMap.put(parcel.readString(), EntitlementInfo.CREATOR.createFromParcel(parcel));
            }
            return new EntitlementInfos(linkedHashMap, VerificationResult.valueOf(parcel.readString()));
        }

        public final EntitlementInfos[] newArray(int i) {
            return new EntitlementInfos[i];
        }
    }

    public int describeContents() {
        return 0;
    }

    public final Map<String, EntitlementInfo> getActive() {
        return this.active;
    }

    public final Map<String, EntitlementInfo> getAll() {
        return this.all;
    }

    public final VerificationResult getVerification() {
        return this.verification;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Map<String, EntitlementInfo> map = this.all;
        parcel.writeInt(map.size());
        for (Map.Entry next : map.entrySet()) {
            parcel.writeString((String) next.getKey());
            ((EntitlementInfo) next.getValue()).writeToParcel(parcel, i);
        }
        parcel.writeString(this.verification.name());
    }

    public EntitlementInfos(Map<String, EntitlementInfo> map, VerificationResult verificationResult) {
        Intrinsics.checkNotNullParameter(map, TtmlNode.COMBINE_ALL);
        Intrinsics.checkNotNullParameter(verificationResult, "verification");
        this.all = map;
        this.verification = verificationResult;
        Map<String, EntitlementInfo> linkedHashMap = new LinkedHashMap<>();
        for (Map.Entry next : map.entrySet()) {
            if (((EntitlementInfo) next.getValue()).isActive()) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        this.active = linkedHashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated(message = "Use the constructor with the verification parameter", replaceWith = @ReplaceWith(expression = "EntitlementInfos(all, verification)", imports = {}))
    public EntitlementInfos(Map<String, EntitlementInfo> map) {
        this(map, VerificationResult.NOT_REQUESTED);
        Intrinsics.checkNotNullParameter(map, TtmlNode.COMBINE_ALL);
    }

    public final EntitlementInfo get(String str) {
        Intrinsics.checkNotNullParameter(str, "s");
        return this.all.get(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.revenuecat.purchases.EntitlementInfos");
        EntitlementInfos entitlementInfos = (EntitlementInfos) obj;
        return Intrinsics.areEqual((Object) this.all, (Object) entitlementInfos.all) && Intrinsics.areEqual((Object) this.active, (Object) entitlementInfos.active) && this.verification == entitlementInfos.verification;
    }

    public int hashCode() {
        return (this.all.hashCode() * 31) + this.active.hashCode();
    }
}
