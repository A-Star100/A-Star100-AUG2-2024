package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcrz implements zzhiv {
    private final zzcrt zza;
    private final zzhjm zzb;

    public zzcrz(zzcrt zzcrt, zzhjm zzhjm) {
        this.zza = zzcrt;
        this.zzb = zzhjm;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzs zzfzs;
        zzcsx zza2 = ((zzcsy) this.zzb).zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzmi)).booleanValue()) {
            zzfzs = zzfzs.zzo(new zzdgf(zza2, zzcbr.zza));
        } else {
            zzfzs = zzfzs.zzn();
        }
        zzhjd.zzb(zzfzs);
        return zzfzs;
    }
}
