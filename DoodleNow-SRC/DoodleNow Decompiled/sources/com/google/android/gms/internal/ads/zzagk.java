package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.amazon.a.a.o.b.f;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzagk implements zzbx {
    public static final Parcelable.Creator<zzagk> CREATOR = new zzagj();
    public final String zza;
    public final String zzb;

    protected zzagk(Parcel parcel) {
        String readString = parcel.readString();
        int i = zzfx.zza;
        this.zza = readString;
        this.zzb = parcel.readString();
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzagk zzagk = (zzagk) obj;
            return this.zza.equals(zzagk.zza) && this.zzb.equals(zzagk.zzb);
        }
    }

    public final int hashCode() {
        return ((this.zza.hashCode() + 527) * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return "VC: " + this.zza + f.b + this.zzb;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zza);
        parcel.writeString(this.zzb);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzbt r7) {
        /*
            r6 = this;
            java.lang.String r0 = r6.zza
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r1) {
                case 62359119: goto L_0x0036;
                case 79833656: goto L_0x002c;
                case 428414940: goto L_0x0022;
                case 1746739798: goto L_0x0018;
                case 1939198791: goto L_0x000e;
                default: goto L_0x000d;
            }
        L_0x000d:
            goto L_0x0040
        L_0x000e:
            java.lang.String r1 = "ARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = r5
            goto L_0x0041
        L_0x0018:
            java.lang.String r1 = "ALBUMARTIST"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = r3
            goto L_0x0041
        L_0x0022:
            java.lang.String r1 = "DESCRIPTION"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = r2
            goto L_0x0041
        L_0x002c:
            java.lang.String r1 = "TITLE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = 0
            goto L_0x0041
        L_0x0036:
            java.lang.String r1 = "ALBUM"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0040
            r0 = r4
            goto L_0x0041
        L_0x0040:
            r0 = -1
        L_0x0041:
            if (r0 == 0) goto L_0x0064
            if (r0 == r5) goto L_0x005e
            if (r0 == r4) goto L_0x0058
            if (r0 == r3) goto L_0x0052
            if (r0 == r2) goto L_0x004c
            return
        L_0x004c:
            java.lang.String r0 = r6.zzb
            r7.zzh(r0)
            return
        L_0x0052:
            java.lang.String r0 = r6.zzb
            r7.zzc(r0)
            return
        L_0x0058:
            java.lang.String r0 = r6.zzb
            r7.zzd(r0)
            return
        L_0x005e:
            java.lang.String r0 = r6.zzb
            r7.zze(r0)
            return
        L_0x0064:
            java.lang.String r0 = r6.zzb
            r7.zzq(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzagk.zza(com.google.android.gms.internal.ads.zzbt):void");
    }

    public zzagk(String str, String str2) {
        this.zza = zzfvx.zzb(str);
        this.zzb = str2;
    }
}
