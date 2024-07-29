package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzagw extends zzahd {
    public static final Parcelable.Creator<zzagw> CREATOR = new zzagv();
    public final String zza;
    public final String zzb;
    public final String zzc;

    zzagw(Parcel parcel) {
        super(CommentFrame.ID);
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
        this.zzc = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagw zzagw = (zzagw) obj;
            return zzfx.zzG(this.zzb, zzagw.zzb) && zzfx.zzG(this.zza, zzagw.zza) && zzfx.zzG(this.zzc, zzagw.zzc);
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
        return (((i2 * 31) + hashCode2) * 31) + i;
    }

    public final String toString() {
        return this.zzf + ": language=" + this.zza + ", description=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzc);
    }

    public zzagw(String str, String str2, String str3) {
        super(CommentFrame.ID);
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
    }
}
