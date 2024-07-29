package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Tasks;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeyn implements zzewr {
    private final zzcbh zza;
    private final String zzb;
    private final ScheduledExecutorService zzc;
    private final zzgep zzd;
    private final zzbca zze;

    zzeyn(String str, zzbca zzbca, zzcbh zzcbh, ScheduledExecutorService scheduledExecutorService, zzgep zzgep) {
        this.zzb = str;
        this.zze = zzbca;
        this.zza = zzcbh;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgep;
    }

    public final int zza() {
        return 43;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcF)).booleanValue()) {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzcK)).booleanValue()) {
                ListenableFuture zzn = zzgee.zzn(zzftv.zza(Tasks.forResult(null), (CancellationTokenSource) null), zzeyl.zza, this.zzd);
                if (((Boolean) zzbfi.zza.zze()).booleanValue()) {
                    zzn = zzgee.zzo(zzn, ((Long) zzbfi.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgee.zze(zzn, Exception.class, new zzeym(this), this.zzd);
            }
        }
        return zzgee.zzh(new zzeyo((String) null, -1));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeyo zzc(Exception exc) {
        this.zza.zzw(exc, "AppSetIdInfoGmscoreSignal");
        return new zzeyo((String) null, -1);
    }
}
