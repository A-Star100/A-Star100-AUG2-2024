package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdyn {
    private final zzgep zza;
    private final zzgep zzb;
    private final zzdzu zzc;
    private final zzhip zzd;

    public zzdyn(zzgep zzgep, zzgep zzgep2, zzdzu zzdzu, zzhip zzhip) {
        this.zza = zzgep;
        this.zzb = zzgep2;
        this.zzc = zzdzu;
        this.zzd = zzhip;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeam zza(zzbxd zzbxd) throws Exception {
        zzcbw zzcbw;
        zzdzu zzdzu = this.zzc;
        synchronized (zzdzu.zzb) {
            if (zzdzu.zzc) {
                zzcbw = zzdzu.zza;
            } else {
                zzdzu.zzc = true;
                zzdzu.zze = zzbxd;
                zzdzu.zzf.checkAvailabilityAndConnect();
                zzdzu.zza.addListener(new zzdzt(zzdzu), zzcbr.zzf);
                zzcbw = zzdzu.zza;
            }
        }
        return (zzeam) zzcbw.get((long) ((Integer) zzba.zzc().zza(zzbdz.zzfz)).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbxd zzbxd, int i, zzeal zzeal) throws Exception {
        return zzgee.zzn(((zzecu) this.zzd.zzb()).zzc(zzbxd, i), new zzdyj(zzbxd), this.zzb);
    }

    public final ListenableFuture zzc(zzbxd zzbxd) {
        ListenableFuture listenableFuture;
        String str = zzbxd.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgee.zzg(new zzeal(1));
        } else {
            listenableFuture = zzgee.zzf(this.zza.zzb(new zzdyk(this, zzbxd)), ExecutionException.class, zzdyl.zza, this.zzb);
        }
        return zzgee.zzf(listenableFuture, zzeal.class, new zzdym(this, zzbxd, Binder.getCallingUid()), this.zzb);
    }
}
