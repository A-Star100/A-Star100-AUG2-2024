package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejq extends zzejs {
    private final zzcik zza;
    private final zzdjd zzb;
    private final zzcxy zzc;
    private final zzdeh zzd;
    private final zzekd zze;
    private final zzego zzf;

    public zzejq(zzcik zzcik, zzdjd zzdjd, zzcxy zzcxy, zzdeh zzdeh, zzekd zzekd, zzego zzego) {
        this.zza = zzcik;
        this.zzb = zzdjd;
        this.zzc = zzcxy;
        this.zzd = zzdeh;
        this.zze = zzekd;
        this.zzf = zzego;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfgi zzfgi, Bundle bundle, zzffn zzffn, zzffz zzffz) {
        zzcxy zzcxy = this.zzc;
        zzcxy.zzi(zzfgi);
        zzcxy.zzf(bundle);
        zzcxy.zzg(new zzcxs(zzffz, zzffn, this.zze));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdv)).booleanValue()) {
            this.zzc.zzd(this.zzf);
        }
        zzcik zzcik = this.zza;
        zzcxy zzcxy2 = this.zzc;
        zzdjh zzh = zzcik.zzh();
        zzh.zzf(zzcxy2.zzj());
        zzh.zze(this.zzd);
        zzh.zzd(this.zzb);
        zzh.zzc(new zzcrj((ViewGroup) null));
        zzcvd zza2 = zzh.zzg().zza();
        return zza2.zzi(zza2.zzj());
    }
}
