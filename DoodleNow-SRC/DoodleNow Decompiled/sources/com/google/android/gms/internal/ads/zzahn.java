package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzahn extends zzahd {
    public static final Parcelable.Creator<zzahn> CREATOR = new zzahm();
    public final String zza;
    public final String zzb;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    zzahn(android.os.Parcel r3) {
        /*
            r2 = this;
            java.lang.String r0 = r3.readString()
            int r1 = com.google.android.gms.internal.ads.zzfx.zza
            r2.<init>(r0)
            java.lang.String r0 = r3.readString()
            r2.zza = r0
            java.lang.String r3 = r3.readString()
            r2.zzb = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahn.<init>(android.os.Parcel):void");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzahn zzahn = (zzahn) obj;
            return this.zzf.equals(zzahn.zzf) && zzfx.zzG(this.zza, zzahn.zza) && zzfx.zzG(this.zzb, zzahn.zzb);
        }
    }

    public final int hashCode() {
        int hashCode = this.zzf.hashCode() + 527;
        String str = this.zza;
        int i = 0;
        int hashCode2 = str != null ? str.hashCode() : 0;
        int i2 = hashCode * 31;
        String str2 = this.zzb;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((i2 + hashCode2) * 31) + i;
    }

    public final String toString() {
        return this.zzf + ": url=" + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzf);
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    public zzahn(String str, String str2, String str3) {
        super(str);
        this.zza = str2;
        this.zzb = str3;
    }
}
