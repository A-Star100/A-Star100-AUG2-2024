package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeid implements zzegj {
    /* access modifiers changed from: private */
    public final zzcsm zza;
    private final zzehk zzb;
    private final zzgep zzc;
    /* access modifiers changed from: private */
    public final zzcys zzd;
    private final ScheduledExecutorService zze;
    private final zzduc zzf;

    public zzeid(zzcsm zzcsm, zzehk zzehk, zzcys zzcys, ScheduledExecutorService scheduledExecutorService, zzgep zzgep, zzduc zzduc) {
        this.zza = zzcsm;
        this.zzb = zzehk;
        this.zzd = zzcys;
        this.zze = scheduledExecutorService;
        this.zzc = zzgep;
        this.zzf = zzduc;
    }

    public final ListenableFuture zza(zzffz zzffz, zzffn zzffn) {
        return this.zzc.zzb(new zzeib(this, zzffz, zzffn));
    }

    public final boolean zzb(zzffz zzffz, zzffn zzffn) {
        zzbiv zza2 = zzffz.zza.zza.zza();
        boolean zzb2 = this.zzb.zzb(zzffz, zzffn);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlE)).booleanValue()) {
            String str = "1";
            this.zzf.zzb().put("has_dbl", zza2 != null ? str : SessionDescription.SUPPORTED_SDP_VERSION);
            zzduc zzduc = this.zzf;
            if (true != zzb2) {
                str = SessionDescription.SUPPORTED_SDP_VERSION;
            }
            zzduc.zzb().put("crdb", str);
        }
        if (zza2 == null || !zzb2) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcrm zzc(zzffz zzffz, zzffn zzffn) throws Exception {
        return this.zza.zzb(new zzcul(zzffz, zzffn, (String) null), new zzctd(zzffz.zza.zza.zza(), new zzeia(this, zzffz, zzffn))).zza();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(zzffz zzffz, zzffn zzffn) {
        zzgee.zzr(zzgee.zzo(this.zzb.zza(zzffz, zzffn), (long) zzffn.zzS, TimeUnit.SECONDS, this.zze), new zzeic(this), this.zzc);
    }
}
