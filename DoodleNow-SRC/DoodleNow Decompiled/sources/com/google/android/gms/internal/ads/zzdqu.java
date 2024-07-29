package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbdg;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqu implements zzhiv {
    private final zzhjm zza;

    public zzdqu(zzhjm zzhjm) {
        this.zza = zzhjm;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        zzbdg.zza.C0013zza zza2;
        if (((zzcyh) this.zza).zza().zzo.zza == 3) {
            zza2 = zzbdg.zza.C0013zza.REWARDED_INTERSTITIAL;
        } else {
            zza2 = zzbdg.zza.C0013zza.REWARD_BASED_VIDEO_AD;
        }
        zzhjd.zzb(zza2);
        return zza2;
    }
}
