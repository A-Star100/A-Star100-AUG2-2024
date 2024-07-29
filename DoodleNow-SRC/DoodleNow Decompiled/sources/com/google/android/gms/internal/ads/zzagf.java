package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzagf implements zzbx {
    public static final Parcelable.Creator<zzagf> CREATOR = new zzage();
    private static final zzam zzf;
    private static final zzam zzg;
    public final String zza;
    public final String zzb;
    public final long zzc;
    public final long zzd;
    public final byte[] zze;
    private int zzh;

    static {
        zzak zzak = new zzak();
        zzak.zzW(MimeTypes.APPLICATION_ID3);
        zzf = zzak.zzac();
        zzak zzak2 = new zzak();
        zzak2.zzW(MimeTypes.APPLICATION_SCTE35);
        zzg = zzak2.zzac();
    }

    zzagf(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readLong();
        this.zzd = parcel.readLong();
        this.zze = parcel.createByteArray();
    }

    public zzagf(String str, String str2, long j, long j2, byte[] bArr) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = j;
        this.zzd = j2;
        this.zze = bArr;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagf zzagf = (zzagf) obj;
            return this.zzc == zzagf.zzc && this.zzd == zzagf.zzd && zzfx.zzG(this.zza, zzagf.zza) && zzfx.zzG(this.zzb, zzagf.zzb) && Arrays.equals(this.zze, zzagf.zze);
        }
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        String str = this.zza;
        int i2 = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.zzb;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        long j = this.zzc;
        long j2 = this.zzd;
        int hashCode2 = ((((((((hashCode + 527) * 31) + i2) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Arrays.hashCode(this.zze);
        this.zzh = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        return "EMSG: scheme=" + this.zza + ", id=" + this.zzd + ", durationMs=" + this.zzc + ", value=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeLong(this.zzc);
        parcel.writeLong(this.zzd);
        parcel.writeByteArray(this.zze);
    }

    public final /* synthetic */ void zza(zzbt zzbt) {
    }
}
