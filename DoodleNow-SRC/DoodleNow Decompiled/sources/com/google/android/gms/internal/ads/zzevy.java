package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.ads.nonagon.signalgeneration.zzae;
import com.google.android.gms.ads.nonagon.signalgeneration.zzi;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzevy implements zzewr {
    private final String zza;
    private final zzgep zzb;
    private final ScheduledExecutorService zzc;
    private final Context zzd;
    private final zzfgi zze;
    private final zzcik zzf;

    zzevy(zzgep zzgep, ScheduledExecutorService scheduledExecutorService, String str, Context context, zzfgi zzfgi, zzcik zzcik) {
        this.zzb = zzgep;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = context;
        this.zze = zzfgi;
        this.zzf = zzcik;
    }

    public static /* synthetic */ ListenableFuture zzc(zzevy zzevy) {
        zzi zzp = zzevy.zzf.zzp();
        zzcxy zzcxy = new zzcxy();
        zzcxy.zze(zzevy.zzd);
        zzfgg zzfgg = new zzfgg();
        zzfgg.zzt("adUnitId");
        zzfgg.zzG(zzevy.zze.zzd);
        zzfgg.zzs(new zzq());
        zzfgg.zzy(true);
        zzcxy.zzi(zzfgg.zzI());
        zzp.zza(zzcxy.zzj());
        zzae zzae = new zzae();
        zzae.zza(zzevy.zza);
        zzp.zzb(zzae.zzb());
        new zzdef();
        return zzgee.zze(zzgee.zzm((zzgdv) zzgee.zzo(zzgdv.zzu(zzp.zzc().zzb()), ((Long) zzba.zzc().zza(zzbdz.zzhj)).longValue(), TimeUnit.MILLISECONDS, zzevy.zzc), zzevv.zza, zzevy.zzb), Exception.class, zzevw.zza, zzevy.zzb);
    }

    public final int zza() {
        return 33;
    }

    public final ListenableFuture zzb() {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzhi)).booleanValue() || this.zze.zzq) {
            return zzgee.zzh(new zzevz((String) null));
        }
        return zzgee.zzk(new zzevx(this), this.zzb);
    }
}
