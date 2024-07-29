package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejt extends zzejs {
    private final zzcik zza;
    private final zzcxy zzb;
    private final zzdeh zzc;
    private final zzekd zzd;
    private final zzego zze;

    zzejt(zzcik zzcik, zzcxy zzcxy, zzdeh zzdeh, zzekd zzekd, zzego zzego) {
        this.zza = zzcik;
        this.zzb = zzcxy;
        this.zzc = zzdeh;
        this.zzd = zzekd;
        this.zze = zzego;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfgi zzfgi, Bundle bundle, zzffn zzffn, zzffz zzffz) {
        zzcxy zzcxy = this.zzb;
        zzcxy.zzi(zzfgi);
        zzcxy.zzf(bundle);
        zzcxy.zzg(new zzcxs(zzffz, zzffn, this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdv)).booleanValue()) {
            this.zzb.zzd(this.zze);
        }
        zzcik zzcik = this.zza;
        zzcxy zzcxy2 = this.zzb;
        zzcqz zzd2 = zzcik.zzd();
        zzd2.zzd(zzcxy2.zzj());
        zzd2.zzc(this.zzc);
        zzcvd zzb2 = zzd2.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
