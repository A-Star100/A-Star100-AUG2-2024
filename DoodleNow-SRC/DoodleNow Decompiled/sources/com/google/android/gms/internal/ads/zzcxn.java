package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcxn implements zzcyq, zzdfs, zzddi, zzczg, zzazy {
    /* access modifiers changed from: private */
    public final zzczi zza;
    private final zzffn zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final zzgex zze = zzgex.zze();
    private ScheduledFuture zzf;
    private final AtomicBoolean zzg = new AtomicBoolean();
    private final String zzh;

    zzcxn(zzczi zzczi, zzffn zzffn, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zza = zzczi;
        this.zzb = zzffn;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zzh = str;
    }

    private final boolean zzm() {
        return this.zzh.equals("com.google.ads.mediation.admob.AdMobAdapter");
    }

    public final void zza() {
    }

    public final void zzb() {
    }

    public final void zzc() {
        zzffn zzffn = this.zzb;
        if (zzffn.zzf != 3) {
            int i = zzffn.zzZ;
            if (i == 0 || i == 1) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzlf)).booleanValue() || !zzm()) {
                    this.zza.zza();
                }
            }
        }
    }

    public final void zzdp(zzazx zzazx) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzlf)).booleanValue() && zzm() && zzazx.zzj && this.zzg.compareAndSet(false, true) && this.zzb.zzf != 3) {
            zze.zza("Full screen 1px impression occurred");
            this.zza.zza();
        }
    }

    public final void zzds(zzbxq zzbxq, String str, String str2) {
    }

    public final void zze() {
    }

    public final void zzf() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh() {
        synchronized (this) {
            if (!this.zze.isDone()) {
                this.zze.zzc(true);
            }
        }
    }

    public final void zzi() {
    }

    public final synchronized void zzj() {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzc(true);
        }
    }

    public final void zzk() {
        if (this.zzb.zzf != 3) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzbw)).booleanValue()) {
                zzffn zzffn = this.zzb;
                if (zzffn.zzZ != 2) {
                    return;
                }
                if (zzffn.zzr == 0) {
                    this.zza.zza();
                    return;
                }
                zzgee.zzr(this.zze, new zzcxm(this), this.zzd);
                this.zzf = this.zzc.schedule(new zzcxl(this), (long) this.zzb.zzr, TimeUnit.MILLISECONDS);
            }
        }
    }

    public final void zzl() {
    }

    public final synchronized void zzq(com.google.android.gms.ads.internal.client.zze zze2) {
        if (!this.zze.isDone()) {
            ScheduledFuture scheduledFuture = this.zzf;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(true);
            }
            this.zze.zzd(new Exception());
        }
    }
}
