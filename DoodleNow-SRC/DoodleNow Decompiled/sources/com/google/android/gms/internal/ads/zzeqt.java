package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.appset.AppSet;
import com.google.android.gms.appset.AppSetIdClient;
import com.google.android.gms.appset.AppSetIdInfo;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeqt implements zzewr {
    final zzcbh zza;
    AppSetIdClient zzb;
    private final ScheduledExecutorService zzc;
    private final zzgep zzd;
    private final Context zze;

    zzeqt(Context context, zzcbh zzcbh, ScheduledExecutorService scheduledExecutorService, zzgep zzgep) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzcJ)).booleanValue()) {
            this.zzb = AppSet.getClient(context);
        }
        this.zze = context;
        this.zza = zzcbh;
        this.zzc = scheduledExecutorService;
        this.zzd = zzgep;
    }

    public final int zza() {
        return 11;
    }

    public final ListenableFuture zzb() {
        Task<AppSetIdInfo> task;
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcF)).booleanValue()) {
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzcK)).booleanValue()) {
                if (!((Boolean) zzba.zzc().zza(zzbdz.zzcG)).booleanValue()) {
                    return zzgee.zzm(zzftv.zza(this.zzb.getAppSetIdInfo(), (CancellationTokenSource) null), zzeqq.zza, zzcbr.zzf);
                }
                if (((Boolean) zzba.zzc().zza(zzbdz.zzcJ)).booleanValue()) {
                    task = zzfhn.zza(this.zze);
                } else {
                    task = this.zzb.getAppSetIdInfo();
                }
                if (task == null) {
                    return zzgee.zzh(new zzequ((String) null, -1));
                }
                ListenableFuture zzn = zzgee.zzn(zzftv.zza(task, (CancellationTokenSource) null), zzeqr.zza, zzcbr.zzf);
                if (((Boolean) zzba.zzc().zza(zzbdz.zzcH)).booleanValue()) {
                    zzn = zzgee.zzo(zzn, ((Long) zzba.zzc().zza(zzbdz.zzcI)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
                }
                return zzgee.zze(zzn, Exception.class, new zzeqs(this), this.zzd);
            }
        }
        return zzgee.zzh(new zzequ((String) null, -1));
    }
}
