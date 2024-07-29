package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeyt implements zzewr {
    private final Context zza;
    private final zzcbh zzb;
    private final ScheduledExecutorService zzc;
    private final Executor zzd;
    private final String zze;
    private final zzcay zzf;

    public zzeyt(zzcay zzcay, int i, Context context, zzcbh zzcbh, ScheduledExecutorService scheduledExecutorService, Executor executor, String str) {
        this.zzf = zzcay;
        this.zza = context;
        this.zzb = zzcbh;
        this.zzc = scheduledExecutorService;
        this.zzd = executor;
        this.zze = str;
    }

    public final int zza() {
        return 44;
    }

    public final ListenableFuture zzb() {
        return zzgee.zze((zzgdv) zzgee.zzo(zzgee.zzm(zzgdv.zzu(zzgee.zzk(new zzeyq(this), this.zzd)), zzeyr.zza, this.zzd), ((Long) zzba.zzc().zza(zzbdz.zzaV)).longValue(), TimeUnit.MILLISECONDS, this.zzc), Exception.class, new zzeys(this), zzgev.zzb());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeyu zzc(Exception exc) {
        this.zzb.zzw(exc, "AttestationTokenSignal");
        return null;
    }
}
