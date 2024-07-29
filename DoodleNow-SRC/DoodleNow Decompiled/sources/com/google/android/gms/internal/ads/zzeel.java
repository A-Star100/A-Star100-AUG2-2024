package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeel implements zzfko {
    private final zzedz zza;
    private final zzeed zzb;

    zzeel(zzedz zzedz, zzeed zzeed) {
        this.zza = zzedz;
        this.zzb = zzeed;
    }

    public final void zzd(zzfkh zzfkh, String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue() && zzfkh.RENDERER == zzfkh && this.zza.zzc() != 0) {
            this.zza.zzf(zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdC(zzfkh zzfkh, String str) {
    }

    public final void zzdD(zzfkh zzfkh, String str, Throwable th) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue() && zzfkh.RENDERER == zzfkh && this.zza.zzc() != 0) {
            this.zza.zzf(zzu.zzB().elapsedRealtime() - this.zza.zzc());
        }
    }

    public final void zzdE(zzfkh zzfkh, String str) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzgm)).booleanValue()) {
            if (zzfkh.RENDERER == zzfkh) {
                this.zza.zzg(zzu.zzB().elapsedRealtime());
            } else if (zzfkh.PRELOADED_LOADER == zzfkh || zzfkh.SERVER_TRANSACTION == zzfkh) {
                this.zza.zzh(zzu.zzB().elapsedRealtime());
                zzeed zzeed = this.zzb;
                zzeed.zza.zza(new zzeec(zzeed, this.zza.zzd()));
            }
        }
    }
}
