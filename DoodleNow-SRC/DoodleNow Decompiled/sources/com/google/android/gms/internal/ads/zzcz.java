package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcz {
    @Deprecated
    public static final zzn zza = zzcy.zza;
    private static final String zze = Integer.toString(0, 36);
    private static final String zzf = Integer.toString(1, 36);
    public final int zzb;
    public final String zzc;
    public final int zzd;
    private final zzam[] zzg;
    private int zzh;

    public zzcz(String str, zzam... zzamArr) {
        int length = zzamArr.length;
        int i = 1;
        zzek.zzd(length > 0);
        this.zzc = str;
        this.zzg = zzamArr;
        this.zzb = length;
        int zzb2 = zzcb.zzb(zzamArr[0].zzm);
        this.zzd = zzb2 == -1 ? zzcb.zzb(zzamArr[0].zzl) : zzb2;
        String zzc2 = zzc(zzamArr[0].zzd);
        int i2 = zzamArr[0].zzf | 16384;
        while (true) {
            zzam[] zzamArr2 = this.zzg;
            if (i >= zzamArr2.length) {
                return;
            }
            if (!zzc2.equals(zzc(zzamArr2[i].zzd))) {
                zzam[] zzamArr3 = this.zzg;
                zzd("languages", zzamArr3[0].zzd, zzamArr3[i].zzd, i);
                return;
            }
            zzam[] zzamArr4 = this.zzg;
            if (i2 != (zzamArr4[i].zzf | 16384)) {
                zzd("role flags", Integer.toBinaryString(zzamArr4[0].zzf), Integer.toBinaryString(this.zzg[i].zzf), i);
                return;
            }
            i++;
        }
    }

    private static String zzc(String str) {
        return (str == null || str.equals(C.LANGUAGE_UNDETERMINED)) ? "" : str;
    }

    private static void zzd(String str, String str2, String str3, int i) {
        zzfe.zzd("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzcz zzcz = (zzcz) obj;
            return this.zzc.equals(zzcz.zzc) && Arrays.equals(this.zzg, zzcz.zzg);
        }
    }

    public final int hashCode() {
        int i = this.zzh;
        if (i != 0) {
            return i;
        }
        int hashCode = ((this.zzc.hashCode() + 527) * 31) + Arrays.hashCode(this.zzg);
        this.zzh = hashCode;
        return hashCode;
    }

    public final int zza(zzam zzam) {
        int i = 0;
        while (true) {
            zzam[] zzamArr = this.zzg;
            if (i >= zzamArr.length) {
                return -1;
            }
            if (zzam == zzamArr[i]) {
                return i;
            }
            i++;
        }
    }

    public final zzam zzb(int i) {
        return this.zzg[i];
    }
}
