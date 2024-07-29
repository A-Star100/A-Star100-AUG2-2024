package com.revenuecat.purchases.models;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.camera.video.AudioStats;
import com.revenuecat.purchases.common.LogUtilsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 '2\u00020\u0001:\u0002'(B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\t\u0010 \u001a\u00020\u0003HÖ\u0001J\t\u0010!\u001a\u00020\u0007HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108@X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u0006)"}, d2 = {"Lcom/revenuecat/purchases/models/Period;", "Landroid/os/Parcelable;", "value", "", "unit", "Lcom/revenuecat/purchases/models/Period$Unit;", "iso8601", "", "(ILcom/revenuecat/purchases/models/Period$Unit;Ljava/lang/String;)V", "getIso8601", "()Ljava/lang/String;", "getUnit", "()Lcom/revenuecat/purchases/models/Period$Unit;", "getValue", "()I", "valueInMonths", "", "getValueInMonths", "()D", "valueInWeeks", "getValueInWeeks$purchases_defaultsRelease", "valueInYears", "getValueInYears$purchases_defaultsRelease", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Factory", "Unit", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Period.kt */
public final class Period implements Parcelable {
    public static final Parcelable.Creator<Period> CREATOR = new Creator();
    private static final double DAYS_PER_MONTH = 30.0d;
    private static final double DAYS_PER_WEEK = 7.0d;
    private static final double DAYS_PER_YEAR = 365.0d;
    public static final Factory Factory = new Factory((DefaultConstructorMarker) null);
    private static final double MONTHS_PER_YEAR = 12.0d;
    private static final double WEEKS_PER_MONTH = 4.345238095238096d;
    private static final double WEEKS_PER_YEAR = 52.142857142857146d;
    private final String iso8601;
    private final Unit unit;
    private final int value;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Period.kt */
    public static final class Creator implements Parcelable.Creator<Period> {
        public final Period createFromParcel(Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new Period(parcel.readInt(), Unit.valueOf(parcel.readString()), parcel.readString());
        }

        public final Period[] newArray(int i) {
            return new Period[i];
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/models/Period$Unit;", "", "(Ljava/lang/String;I)V", "DAY", "WEEK", "MONTH", "YEAR", "UNKNOWN", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Period.kt */
    public enum Unit {
        DAY,
        WEEK,
        MONTH,
        YEAR,
        UNKNOWN
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Period.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.revenuecat.purchases.models.Period$Unit[] r0 = com.revenuecat.purchases.models.Period.Unit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.DAY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.WEEK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.MONTH     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.YEAR     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.revenuecat.purchases.models.Period$Unit r1 = com.revenuecat.purchases.models.Period.Unit.UNKNOWN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.models.Period.WhenMappings.<clinit>():void");
        }
    }

    public static /* synthetic */ Period copy$default(Period period, int i, Unit unit2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = period.value;
        }
        if ((i2 & 2) != 0) {
            unit2 = period.unit;
        }
        if ((i2 & 4) != 0) {
            str = period.iso8601;
        }
        return period.copy(i, unit2, str);
    }

    public final int component1() {
        return this.value;
    }

    public final Unit component2() {
        return this.unit;
    }

    public final String component3() {
        return this.iso8601;
    }

    public final Period copy(int i, Unit unit2, String str) {
        Intrinsics.checkNotNullParameter(unit2, "unit");
        Intrinsics.checkNotNullParameter(str, "iso8601");
        return new Period(i, unit2, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Period)) {
            return false;
        }
        Period period = (Period) obj;
        return this.value == period.value && this.unit == period.unit && Intrinsics.areEqual((Object) this.iso8601, (Object) period.iso8601);
    }

    public final String getIso8601() {
        return this.iso8601;
    }

    public final Unit getUnit() {
        return this.unit;
    }

    public final int getValue() {
        return this.value;
    }

    public int hashCode() {
        return (((this.value * 31) + this.unit.hashCode()) * 31) + this.iso8601.hashCode();
    }

    public String toString() {
        return "Period(value=" + this.value + ", unit=" + this.unit + ", iso8601=" + this.iso8601 + ')';
    }

    public void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeInt(this.value);
        parcel.writeString(this.unit.name());
        parcel.writeString(this.iso8601);
    }

    public Period(int i, Unit unit2, String str) {
        Intrinsics.checkNotNullParameter(unit2, "unit");
        Intrinsics.checkNotNullParameter(str, "iso8601");
        this.value = i;
        this.unit = unit2;
        this.iso8601 = str;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/revenuecat/purchases/models/Period$Factory;", "", "()V", "DAYS_PER_MONTH", "", "DAYS_PER_WEEK", "DAYS_PER_YEAR", "MONTHS_PER_YEAR", "WEEKS_PER_MONTH", "WEEKS_PER_YEAR", "create", "Lcom/revenuecat/purchases/models/Period;", "iso8601", "", "purchases_defaultsRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Period.kt */
    public static final class Factory {
        public /* synthetic */ Factory(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Factory() {
        }

        public final Period create(String str) {
            Intrinsics.checkNotNullParameter(str, "iso8601");
            Pair access$toPeriod = PeriodKt.toPeriod(str);
            return new Period(((Number) access$toPeriod.getFirst()).intValue(), (Unit) access$toPeriod.getSecond(), str);
        }
    }

    public final double getValueInWeeks$purchases_defaultsRelease() {
        double d;
        double d2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            return ((double) this.value) / DAYS_PER_WEEK;
        }
        if (i == 2) {
            return (double) this.value;
        }
        if (i == 3) {
            d2 = (double) this.value;
            d = WEEKS_PER_MONTH;
        } else if (i == 4) {
            d2 = (double) this.value;
            d = WEEKS_PER_YEAR;
        } else if (i == 5) {
            LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, (Throwable) null, 2, (Object) null);
            return AudioStats.AUDIO_AMPLITUDE_NONE;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return d2 * d;
    }

    public final double getValueInMonths() {
        double d;
        double d2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            d2 = (double) this.value;
            d = DAYS_PER_MONTH;
        } else if (i == 2) {
            d2 = (double) this.value;
            d = WEEKS_PER_MONTH;
        } else if (i == 3) {
            return (double) this.value;
        } else {
            if (i == 4) {
                return ((double) this.value) * MONTHS_PER_YEAR;
            }
            if (i == 5) {
                LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, (Throwable) null, 2, (Object) null);
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            throw new NoWhenBranchMatchedException();
        }
        return d2 / d;
    }

    public final double getValueInYears$purchases_defaultsRelease() {
        double d;
        double d2;
        int i = WhenMappings.$EnumSwitchMapping$0[this.unit.ordinal()];
        if (i == 1) {
            d2 = (double) this.value;
            d = DAYS_PER_YEAR;
        } else if (i == 2) {
            d2 = (double) this.value;
            d = WEEKS_PER_YEAR;
        } else if (i == 3) {
            d2 = (double) this.value;
            d = MONTHS_PER_YEAR;
        } else if (i == 4) {
            return (double) this.value;
        } else {
            if (i == 5) {
                LogUtilsKt.errorLog$default("Unknown period unit trying to get value in months: " + this.unit, (Throwable) null, 2, (Object) null);
                return AudioStats.AUDIO_AMPLITUDE_NONE;
            }
            throw new NoWhenBranchMatchedException();
        }
        return d2 / d;
    }
}
