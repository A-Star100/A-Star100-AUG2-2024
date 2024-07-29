package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.C;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzby implements Parcelable {
    public static final Parcelable.Creator<zzby> CREATOR = new zzbw();
    public final long zza;
    private final zzbx[] zzb;

    public zzby(long j, zzbx... zzbxArr) {
        this.zza = j;
        this.zzb = zzbxArr;
    }

    zzby(Parcel parcel) {
        this.zzb = new zzbx[parcel.readInt()];
        int i = 0;
        while (true) {
            zzbx[] zzbxArr = this.zzb;
            if (i < zzbxArr.length) {
                zzbxArr[i] = (zzbx) parcel.readParcelable(zzbx.class.getClassLoader());
                i++;
            } else {
                this.zza = parcel.readLong();
                return;
            }
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzby zzby = (zzby) obj;
            return Arrays.equals(this.zzb, zzby.zzb) && this.zza == zzby.zza;
        }
    }

    public final int hashCode() {
        long j = this.zza;
        return (Arrays.hashCode(this.zzb) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        String str;
        long j = this.zza;
        int i = (j > C.TIME_UNSET ? 1 : (j == C.TIME_UNSET ? 0 : -1));
        String arrays = Arrays.toString(this.zzb);
        if (i == 0) {
            str = "";
        } else {
            str = ", presentationTimeUs=" + j;
        }
        return "entries=" + arrays + str;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzb.length);
        for (zzbx writeParcelable : this.zzb) {
            parcel.writeParcelable(writeParcelable, 0);
        }
        parcel.writeLong(this.zza);
    }

    public final int zza() {
        return this.zzb.length;
    }

    public final zzbx zzb(int i) {
        return this.zzb[i];
    }

    public final zzby zzc(zzbx... zzbxArr) {
        int length = zzbxArr.length;
        if (length == 0) {
            return this;
        }
        long j = this.zza;
        zzbx[] zzbxArr2 = this.zzb;
        int i = zzfx.zza;
        int length2 = zzbxArr2.length;
        Object[] copyOf = Arrays.copyOf(zzbxArr2, length2 + length);
        System.arraycopy(zzbxArr, 0, copyOf, length2, length);
        return new zzby(j, (zzbx[]) copyOf);
    }

    public final zzby zzd(zzby zzby) {
        return zzby == null ? this : zzc(zzby.zzb);
    }

    public zzby(List list) {
        this(C.TIME_UNSET, (zzbx[]) list.toArray(new zzbx[0]));
    }
}
