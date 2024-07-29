package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.PrivFrame;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzahj extends zzahd {
    public static final Parcelable.Creator<zzahj> CREATOR = new zzahi();
    public final String zza;
    public final byte[] zzb;

    zzahj(Parcel parcel) {
        super(PrivFrame.ID);
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zza = readString;
        this.zzb = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahj zzahj = (zzahj) obj;
            return zzfx.zzG(this.zza, zzahj.zza) && Arrays.equals(this.zzb, zzahj.zzb);
        }
    }

    public final int hashCode() {
        String str = this.zza;
        return (((str != null ? str.hashCode() : 0) + 527) * 31) + Arrays.hashCode(this.zzb);
    }

    public final String toString() {
        return this.zzf + ": owner=" + this.zza;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeByteArray(this.zzb);
    }

    public zzahj(String str, byte[] bArr) {
        super(PrivFrame.ID);
        this.zza = str;
        this.zzb = bArr;
    }
}
