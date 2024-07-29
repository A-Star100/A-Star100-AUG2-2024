package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzago extends zzahd {
    public static final Parcelable.Creator<zzago> CREATOR = new zzagn();
    public final String zza;
    public final String zzb;
    public final int zzc;
    public final byte[] zzd;

    zzago(Parcel parcel) {
        super(ApicFrame.ID);
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readInt();
        this.zzd = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzago zzago = (zzago) obj;
            return this.zzc == zzago.zzc && zzfx.zzG(this.zza, zzago.zza) && zzfx.zzG(this.zzb, zzago.zzb) && Arrays.equals(this.zzd, zzago.zzd);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        int i = 0;
        int hashCode = str != null ? str.hashCode() : 0;
        int i2 = this.zzc;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((i2 + 527) * 31) + hashCode) * 31) + i) * 31) + Arrays.hashCode(this.zzd);
    }

    public final String toString() {
        return this.zzf + ": mimeType=" + this.zza + ", description=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
        parcel.writeInt(this.zzc);
        parcel.writeByteArray(this.zzd);
    }

    public final void zza(zzbt zzbt) {
        zzbt.zza(this.zzd, this.zzc);
    }

    public zzago(String str, String str2, int i, byte[] bArr) {
        super(ApicFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = i;
        this.zzd = bArr;
    }
}
