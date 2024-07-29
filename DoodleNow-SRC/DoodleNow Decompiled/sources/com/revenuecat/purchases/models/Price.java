package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/revenuecat/purchases/models/Price;", "Landroid/os/Parcelable;", "formatted", "", "amountMicros", "", "currencyCode", "(Ljava/lang/String;JLjava/lang/String;)V", "getAmountMicros", "()J", "getCurrencyCode", "()Ljava/lang/String;", "getFormatted", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Price.kt */
public final class Price implements Parcelable {
    public static final Parcelable.Creator<Price> CREATOR = new Creator();
    private final long amountMicros;
    private final String currencyCode;
    private final String formatted;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Price.kt */
    public static final class Creator implements Parcelable.Creator<Price> {
        public final Price createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Price(parcel.readString(), parcel.readLong(), parcel.readString());
        }

        public final Price[] newArray(int i) {
            return new Price[i];
        }
    }

    public static /* synthetic */ Price copy$default(Price price, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = price.formatted;
        }
        if ((i & 2) != 0) {
            j = price.amountMicros;
        }
        if ((i & 4) != 0) {
            str2 = price.currencyCode;
        }
        return price.copy(str, j, str2);
    }

    public final String component1() {
        return this.formatted;
    }

    public final long component2() {
        return this.amountMicros;
    }

    public final String component3() {
        return this.currencyCode;
    }

    public final Price copy(String str, long j, String str2) {
        Intrinsics.checkNotNullParameter(str, "formatted");
        Intrinsics.checkNotNullParameter(str2, "currencyCode");
        return new Price(str, j, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Price)) {
            return false;
        }
        Price price = (Price) obj;
        return Intrinsics.areEqual((Object) this.formatted, (Object) price.formatted) && this.amountMicros == price.amountMicros && Intrinsics.areEqual((Object) this.currencyCode, (Object) price.currencyCode);
    }

    public final long getAmountMicros() {
        return this.amountMicros;
    }

    public final String getCurrencyCode() {
        return this.currencyCode;
    }

    public final String getFormatted() {
        return this.formatted;
    }

    public int hashCode() {
        return (((this.formatted.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.amountMicros)) * 31) + this.currencyCode.hashCode();
    }

    public String toString() {
        return "Price(formatted=" + this.formatted + ", amountMicros=" + this.amountMicros + ", currencyCode=" + this.currencyCode + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.formatted);
        parcel.writeLong(this.amountMicros);
        parcel.writeString(this.currencyCode);
    }

    public Price(String str, long j, String str2) {
        Intrinsics.checkNotNullParameter(str, "formatted");
        Intrinsics.checkNotNullParameter(str2, "currencyCode");
        this.formatted = str;
        this.amountMicros = j;
        this.currencyCode = str2;
    }
}
