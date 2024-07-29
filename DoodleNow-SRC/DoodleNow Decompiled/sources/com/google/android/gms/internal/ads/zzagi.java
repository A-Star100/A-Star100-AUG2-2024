package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzagi implements zzbx {
    public static final Parcelable.Creator<zzagi> CREATOR = new zzagh();
    public final int zza;
    public final String zzb;
    public final String zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;
    public final int zzg;
    public final byte[] zzh;

    public zzagi(int i, String str, String str2, int i2, int i3, int i4, int i5, byte[] bArr) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = i2;
        this.zze = i3;
        this.zzf = i4;
        this.zzg = i5;
        this.zzh = bArr;
    }

    zzagi(Parcel parcel) {
        this.zza = parcel.readInt();
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zzb = readString;
        this.zzc = parcel.readString();
        this.zzd = parcel.readInt();
        this.zze = parcel.readInt();
        this.zzf = parcel.readInt();
        this.zzg = parcel.readInt();
        this.zzh = parcel.createByteArray();
    }

    public static zzagi zzb(zzfo zzfo) {
        int zzg2 = zzfo.zzg();
        String zze2 = zzcb.zze(zzfo.zzA(zzfo.zzg(), zzfwd.zza));
        String zzA = zzfo.zzA(zzfo.zzg(), zzfwd.zzc);
        int zzg3 = zzfo.zzg();
        int zzg4 = zzfo.zzg();
        int zzg5 = zzfo.zzg();
        int zzg6 = zzfo.zzg();
        int zzg7 = zzfo.zzg();
        byte[] bArr = new byte[zzg7];
        zzfo.zzG(bArr, 0, zzg7);
        return new zzagi(zzg2, zze2, zzA, zzg3, zzg4, zzg5, zzg6, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagi zzagi = (zzagi) obj;
            return this.zza == zzagi.zza && this.zzb.equals(zzagi.zzb) && this.zzc.equals(zzagi.zzc) && this.zzd == zzagi.zzd && this.zze == zzagi.zze && this.zzf == zzagi.zzf && this.zzg == zzagi.zzg && Arrays.equals(this.zzh, zzagi.zzh);
        }
    }

    public final int hashCode() {
        return ((((((((((((((this.zza + 527) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode()) * 31) + this.zzd) * 31) + this.zze) * 31) + this.zzf) * 31) + this.zzg) * 31) + Arrays.hashCode(this.zzh);
    }

    public final String toString() {
        return "Picture: mimeType=" + this.zzb + ", description=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeInt(this.zzd);
        parcel.writeInt(this.zze);
        parcel.writeInt(this.zzf);
        parcel.writeInt(this.zzg);
        parcel.writeByteArray(this.zzh);
    }

    public final void zza(zzbt zzbt) {
        zzbt.zza(this.zzh, this.zza);
    }
}
