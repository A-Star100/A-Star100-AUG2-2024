package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejx extends zzejs {
    private final zzcik zza;
    private final zzcxy zzb;
    private final zzemj zzc;
    private final zzdeh zzd;
    private final zzekd zze;
    private final zzego zzf;

    public zzejx(zzcik zzcik, zzcxy zzcxy, zzemj zzemj, zzdeh zzdeh, zzekd zzekd, zzego zzego) {
        this.zza = zzcik;
        this.zzb = zzcxy;
        this.zzc = zzemj;
        this.zzd = zzdeh;
        this.zze = zzekd;
        this.zzf = zzego;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfgi zzfgi, Bundle bundle, zzffn zzffn, zzffz zzffz) {
        zzcxy zzcxy = this.zzb;
        zzcxy.zzi(zzfgi);
        zzcxy.zzf(bundle);
        zzcxy.zzg(new zzcxs(zzffz, zzffn, this.zze));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdv)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcik zzcik = this.zza;
        zzcxy zzcxy2 = this.zzb;
        zzdil zzg = zzcik.zzg();
        zzg.zze(zzcxy2.zzj());
        zzg.zzd(this.zzd);
        zzg.zzc(this.zzc);
        zzcvd zza2 = zzg.zzf().zza();
        return zza2.zzi(zza2.zzj());
    }
}
