package com.revenuecat.purchases;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\u0019\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u0005¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "Landroid/os/Parcelable;", "code", "Lcom/revenuecat/purchases/PurchasesErrorCode;", "underlyingErrorMessage", "", "(Lcom/revenuecat/purchases/PurchasesErrorCode;Ljava/lang/String;)V", "getCode", "()Lcom/revenuecat/purchases/PurchasesErrorCode;", "message", "getMessage$annotations", "()V", "getMessage", "()Ljava/lang/String;", "getUnderlyingErrorMessage", "describeContents", "", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: errors.kt */
public final class PurchasesError implements Parcelable {
    public static final Parcelable.Creator<PurchasesError> CREATOR = new Creator();
    private final PurchasesErrorCode code;
    private final String message;
    private final String underlyingErrorMessage;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: errors.kt */
    public static final class Creator implements Parcelable.Creator<PurchasesError> {
        public final PurchasesError createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new PurchasesError(PurchasesErrorCode.valueOf(parcel.readString()), parcel.readString());
        }

        public final PurchasesError[] newArray(int i) {
            return new PurchasesError[i];
        }
    }

    public static /* synthetic */ void getMessage$annotations() {
    }

    public int describeContents() {
        return 0;
    }

    public final PurchasesErrorCode getCode() {
        return this.code;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getUnderlyingErrorMessage() {
        return this.underlyingErrorMessage;
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.code.name());
        parcel.writeString(this.underlyingErrorMessage);
    }

    public PurchasesError(PurchasesErrorCode purchasesErrorCode, String str) {
        Intrinsics.checkNotNullParameter(purchasesErrorCode, "code");
        this.code = purchasesErrorCode;
        this.underlyingErrorMessage = str;
        this.message = purchasesErrorCode.getDescription();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PurchasesError(PurchasesErrorCode purchasesErrorCode, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(purchasesErrorCode, (i & 2) != 0 ? null : str);
    }

    public String toString() {
        return "PurchasesError(code=" + this.code + ", underlyingErrorMessage=" + this.underlyingErrorMessage + ", message='" + this.message + "')";
    }
}
