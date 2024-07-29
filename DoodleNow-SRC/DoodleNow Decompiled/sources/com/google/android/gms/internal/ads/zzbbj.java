package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbbj implements Comparator {
    public zzbbj(zzbbk zzbbk) {
    }

    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbay zzbay = (zzbay) obj;
        zzbay zzbay2 = (zzbay) obj2;
        if (zzbay.zzd() < zzbay2.zzd()) {
            return -1;
        }
        if (zzbay.zzd() <= zzbay2.zzd()) {
            if (zzbay.zzb() < zzbay2.zzb()) {
                return -1;
            }
            if (zzbay.zzb() <= zzbay2.zzb()) {
                float zza = (zzbay.zza() - zzbay.zzd()) * (zzbay.zzc() - zzbay.zzb());
                float zza2 = (zzbay2.zza() - zzbay2.zzd()) * (zzbay2.zzc() - zzbay2.zzb());
                if (zza > zza2) {
                    return -1;
                }
                if (zza >= zza2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
