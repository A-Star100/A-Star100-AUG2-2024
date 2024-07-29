package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcwu implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzcwu(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzs zzfzs;
        zzcvy zzcvy = (zzcvy) this.zza.zzb();
        zzgep zzgep = zzcbr.zza;
        zzhjd.zzb(zzgep);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfE)).booleanValue()) {
            zzfzs = zzfzs.zzo(new zzdgf(zzcvy, zzgep));
        } else {
            zzfzs = zzfzs.zzn();
        }
        zzhjd.zzb(zzfzs);
        return zzfzs;
    }
}
