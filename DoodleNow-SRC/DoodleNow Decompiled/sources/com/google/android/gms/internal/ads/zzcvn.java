package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcvn implements zzhiv {
    private final zzhjm zza;

    public zzcvn(zzhjm zzhjm) {
        this.zza = zzhjm;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfzs zzfzs;
        zzcwa zzcwa = (zzcwa) this.zza.zzb();
        if (((Boolean) zzba.zzc().zza(zzbdz.zzfE)).booleanValue()) {
            zzfzs = zzfzs.zzo(new zzdgf(zzcwa, zzcbr.zzf));
        } else {
            zzfzs = zzfzs.zzn();
        }
        zzhjd.zzb(zzfzs);
        return zzfzs;
    }
}
