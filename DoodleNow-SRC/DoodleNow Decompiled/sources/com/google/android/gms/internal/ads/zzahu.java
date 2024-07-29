package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzahu implements Parcelable {
    public static final Parcelable.Creator<zzahu> CREATOR = new zzaht();
    public static final Comparator zza = zzahs.zza;
    public final long zzb;
    public final long zzc;
    public final int zzd;

    public zzahu(long j, long j2, int i) {
        zzek.zzd(j < j2);
        this.zzb = j;
        this.zzc = j2;
        this.zzd = i;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahu zzahu = (zzahu) obj;
            return this.zzb == zzahu.zzb && this.zzc == zzahu.zzc && this.zzd == zzahu.zzd;
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final String toString() {
        return String.format(Locale.US, "Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", new Object[]{Long.valueOf(this.zzb), Long.valueOf(this.zzc), Integer.valueOf(this.zzd)});
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeInt(this.zzd);
    }
}
