package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzejn {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final zzcty zzc;
    private final zzekd zzd;
    private final zzfmp zze;
    private final zzgex zzf = zzgex.zze();
    private final AtomicBoolean zzg = new AtomicBoolean();
    /* access modifiers changed from: private */
    public zzejo zzh;
    private zzffz zzi;

    zzejn(Executor executor, ScheduledExecutorService scheduledExecutorService, zzcty zzcty, zzekd zzekd, zzfmp zzfmp) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = zzcty;
        this.zzd = zzekd;
        this.zze = zzfmp;
    }

    private final synchronized ListenableFuture zzd(zzffn zzffn) {
        for (String zza2 : zzffn.zza) {
            zzegj zza3 = this.zzc.zza(zzffn.zzb, zza2);
            if (zza3 != null && zza3.zzb(this.zzi, zzffn)) {
                ListenableFuture zza4 = zza3.zza(this.zzi, zzffn);
                int i = zzffn.zzS;
                return zzgee.zzo(zza4, (long) i, TimeUnit.MILLISECONDS, this.zzb);
            }
        }
        return zzgee.zzg(new zzdyi(3));
    }

    /* access modifiers changed from: private */
    public final void zze(zzffn zzffn) {
        if (zzffn != null) {
            ListenableFuture zzd2 = zzd(zzffn);
            this.zzd.zzf(this.zzi, zzffn, zzd2, this.zze);
            zzgee.zzr(zzd2, new zzejm(this, zzffn), this.zza);
        }
    }

    public final synchronized ListenableFuture zzb(zzffz zzffz) {
        if (!this.zzg.getAndSet(true)) {
            if (zzffz.zzb.zza.isEmpty()) {
                this.zzf.zzd(new zzekh(3, zzekk.zzc(zzffz)));
            } else {
                this.zzi = zzffz;
                this.zzh = new zzejo(zzffz, this.zzd, this.zzf);
                this.zzd.zzk(zzffz.zzb.zza);
                while (this.zzh.zze()) {
                    zze(this.zzh.zza());
                }
            }
        }
        return this.zzf;
    }
}
