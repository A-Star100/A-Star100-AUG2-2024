package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.GeobFrame;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzagy extends zzahd {
    public static final Parcelable.Creator<zzagy> CREATOR = new zzagx();
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final byte[] zzd;

    zzagy(Parcel parcel) {
        super(GeobFrame.ID);
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagy zzagy = (zzagy) obj;
            return zzfx.zzG(this.zza, zzagy.zza) && zzfx.zzG(this.zzb, zzagy.zzb) && zzfx.zzG(this.zzc, zzagy.zzc) && Arrays.equals(this.zzd, zzagy.zzd);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        String str2 = this.zzb;
        int hashCode2 = str2 != null ? str2.hashCode() : 0;
        int i2 = hashCode + 527;
        String str3 = this.zzc;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return (((((i2 * 31) + hashCode2) * 31) + i) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", filename=" + this.zzb + ", description=" + this.zzc;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeString(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public zzagy(String str, String str2, String str3, byte[] bArr) {
        super(GeobFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = bArr;
    }
}
