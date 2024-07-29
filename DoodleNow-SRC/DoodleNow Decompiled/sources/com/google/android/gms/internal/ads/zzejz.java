package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejz extends zzejs {
    private final zzcik zza;
    private final zzcxy zzb;
    private final zzdeh zzc;
    private final zzekd zzd;
    @Nullable
    private final zzfga zze;
    private final zzego zzf;

    public zzejz(zzcik zzcik, zzcxy zzcxy, zzdeh zzdeh, @Nullable zzfga zzfga, zzekd zzekd, zzego zzego) {
        this.zza = zzcik;
        this.zzb = zzcxy;
        this.zzc = zzdeh;
        this.zze = zzfga;
        this.zzd = zzekd;
        this.zzf = zzego;
    }

    /* access modifiers changed from: protected */
    public final ListenableFuture zzc(zzfgi zzfgi, Bundle bundle, zzffn zzffn, zzffz zzffz) {
        zzfga zzfga;
        zzcxy zzcxy = this.zzb;
        zzcxy.zzi(zzfgi);
        zzcxy.zzf(bundle);
        zzcxy.zzg(new zzcxs(zzffz, zzffn, this.zzd));
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdu)).booleanValue() && (zzfga = this.zze) != null) {
            this.zzb.zzh(zzfga);
        }
        if (((Boolean) zzba.zzc().zza(zzbdz.zzdv)).booleanValue()) {
            this.zzb.zzd(this.zzf);
        }
        zzcik zzcik = this.zza;
        zzcxy zzcxy2 = this.zzb;
        zzdqq zzi = zzcik.zzi();
        zzi.zzd(zzcxy2.zzj());
        zzi.zzc(this.zzc);
        zzcvd zzb2 = zzi.zze().zzb();
        return zzb2.zzi(zzb2.zzj());
    }
}
