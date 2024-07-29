package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdjb implements zzcty {
    private final Map zza;
    private final Map zzb;
    private final Map zzc;
    private final zzhjm zzd;
    private final zzdlj zze;

    zzdjb(Map map, Map map2, Map map3, zzhjm zzhjm, zzdlj zzdlj) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = zzhjm;
        this.zze = zzdlj;
    }

    public final zzegj zza(int i, String str) {
        zzegj zzegj;
        zzegj zzegj2 = (zzegj) this.zza.get(str);
        if (zzegj2 != null) {
            return zzegj2;
        }
        if (i != 1) {
            if (i != 4) {
                return null;
            }
            zzeix zzeix = (zzeix) this.zzc.get(str);
            if (zzeix != null) {
                return new zzegk(zzeix, zzcua.zza);
            }
            zzegj = (zzegj) this.zzb.get(str);
            if (zzegj == null) {
                return null;
            }
        } else if (this.zze.zze() == null || (zzegj = ((zzcty) this.zzd.zzb()).zza(i, str)) == null) {
            return null;
        }
        return new zzegk(zzegj, zzcub.zza);
    }
}
