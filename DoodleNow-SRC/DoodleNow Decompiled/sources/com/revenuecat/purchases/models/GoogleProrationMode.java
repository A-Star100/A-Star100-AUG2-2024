package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import com.revenuecat.purchases.ProrationMode;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001\u0016B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0016R\u0014\u0010\u0006\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0017"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleProrationMode;", "", "Lcom/revenuecat/purchases/ProrationMode;", "playBillingClientMode", "", "(Ljava/lang/String;II)V", "asGoogleReplacementMode", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getAsGoogleReplacementMode$purchases_defaultsRelease", "()Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "getPlayBillingClientMode", "()I", "describeContents", "writeToParcel", "", "out", "Landroid/os/Parcel;", "flags", "IMMEDIATE_WITHOUT_PRORATION", "IMMEDIATE_WITH_TIME_PRORATION", "IMMEDIATE_AND_CHARGE_FULL_PRICE", "IMMEDIATE_AND_CHARGE_PRORATED_PRICE", "CREATOR", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Deprecated(message = "Replaced with GoogleReplacementMode", replaceWith = @ReplaceWith(expression = "GoogleReplacementMode", imports = {}))
/* compiled from: GoogleProrationMode.kt */
public enum GoogleProrationMode implements ProrationMode {
    IMMEDIATE_WITHOUT_PRORATION(3),
    IMMEDIATE_WITH_TIME_PRORATION(1),
    IMMEDIATE_AND_CHARGE_FULL_PRICE(5),
    IMMEDIATE_AND_CHARGE_PRORATED_PRICE(2);
    
    public static final CREATOR CREATOR = null;
    private final int playBillingClientMode;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GoogleProrationMode.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.revenuecat.purchases.models.GoogleProrationMode[] r0 = com.revenuecat.purchases.models.GoogleProrationMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.models.GoogleProrationMode r1 = com.revenuecat.purchases.models.GoogleProrationMode.IMMEDIATE_WITHOUT_PRORATION     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.models.GoogleProrationMode r1 = com.revenuecat.purchases.models.GoogleProrationMode.IMMEDIATE_WITH_TIME_PRORATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.models.GoogleProrationMode r1 = com.revenuecat.purchases.models.GoogleProrationMode.IMMEDIATE_AND_CHARGE_FULL_PRICE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.revenuecat.purchases.models.GoogleProrationMode r1 = com.revenuecat.purchases.models.GoogleProrationMode.IMMEDIATE_AND_CHARGE_PRORATED_PRICE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.GoogleProrationMode.WhenMappings.<clinit>():void");
        }
    }

    public int describeContents() {
        return 0;
    }

    public final int getPlayBillingClientMode() {
        return this.playBillingClientMode;
    }

    private GoogleProrationMode(int i) {
        this.playBillingClientMode = i;
    }

    static {
        CREATOR = new CREATOR((DefaultConstructorMarker) null);
    }

    public final GoogleReplacementMode getAsGoogleReplacementMode$purchases_defaultsRelease() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return GoogleReplacementMode.WITHOUT_PRORATION;
        }
        if (i == 2) {
            return GoogleReplacementMode.WITH_TIME_PRORATION;
        }
        if (i == 3) {
            return GoogleReplacementMode.CHARGE_FULL_PRICE;
        }
        if (i == 4) {
            return GoogleReplacementMode.CHARGE_PRORATED_PRICE;
        }
        throw new NoWhenBranchMatchedException();
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(name());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0003\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0017\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/revenuecat/purchases/models/GoogleProrationMode$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/revenuecat/purchases/models/GoogleProrationMode;", "()V", "createFromParcel", "in", "Landroid/os/Parcel;", "fromPlayBillingClientMode", "playBillingClientMode", "", "(Ljava/lang/Integer;)Lcom/revenuecat/purchases/models/GoogleProrationMode;", "newArray", "", "size", "(I)[Lcom/revenuecat/purchases/models/GoogleProrationMode;", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: GoogleProrationMode.kt */
    public static final class CREATOR implements Parcelable.Creator<GoogleProrationMode> {
        public /* synthetic */ CREATOR(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private CREATOR() {
        }

        public final GoogleProrationMode fromPlayBillingClientMode(Integer num) {
            if (num == null) {
                return null;
            }
            num.intValue();
            for (GoogleProrationMode googleProrationMode : GoogleProrationMode.values()) {
                if (num.intValue() == googleProrationMode.getPlayBillingClientMode()) {
                    return googleProrationMode;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        public GoogleProrationMode createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            if (readString != null) {
                return GoogleProrationMode.valueOf(readString);
            }
            return null;
        }

        public GoogleProrationMode[] newArray(int i) {
            return new GoogleProrationMode[i];
        }
    }
}
