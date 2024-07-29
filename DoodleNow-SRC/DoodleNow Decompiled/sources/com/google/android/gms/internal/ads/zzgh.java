package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgh implements zzbx {
    public static final Parcelable.Creator<zzgh> CREATOR = new zzgf();
    public final long zza;
    public final long zzb;
    public final long zzc;

    public zzgh(long j, long j2, long j3) {
        this.zza = j;
        this.zzb = j2;
        this.zzc = j3;
    }

    /* synthetic */ zzgh(Parcel parcel, zzgg zzgg) {
        this.zza = parcel.readLong();
        this.zzb = parcel.readLong();
        this.zzc = parcel.readLong();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgh)) {
            return false;
        }
        zzgh zzgh = (zzgh) obj;
        return this.zza == zzgh.zza && this.zzb == zzgh.zzb && this.zzc == zzgh.zzc;
    }

    public final int hashCode() {
        long j = this.zzc;
        long j2 = this.zza;
        long j3 = j ^ (j >>> 32);
        long j4 = this.zzb;
        return ((((((int) (j2 ^ (j2 >>> 32))) + 527) * 31) + ((int) ((j4 >>> 32) ^ j4))) * 31) + ((int) j3);
    }

    public final String toString() {
        return "Mp4Timestamp: creation time=" + this.zza + ", modification time=" + this.zzb + ", timescale=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.zza);
        parcel.writeLong(this.zzb);
        parcel.writeLong(this.zzc);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
