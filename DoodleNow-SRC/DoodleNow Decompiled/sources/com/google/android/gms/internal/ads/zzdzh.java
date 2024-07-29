package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdzh {
    private final ScheduledExecutorService zza;
    private final zzgep zzb;
    private final zzgep zzc;
    private final zzdzy zzd;
    private final zzhip zze;

    public zzdzh(ScheduledExecutorService scheduledExecutorService, zzgep zzgep, zzgep zzgep2, zzdzy zzdzy, zzhip zzhip) {
        this.zza = scheduledExecutorService;
        this.zzb = zzgep;
        this.zzc = zzgep2;
        this.zzd = zzdzy;
        this.zze = zzhip;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzeam zza(zzbxd zzbxd) throws Exception {
        return (zzeam) this.zzd.zzb(zzbxd).get((long) ((Integer) zzba.zzc().zza(zzbdz.zzfz)).intValue(), TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbxd zzbxd, int i, Throwable th) throws Exception {
        return zzgee.zzn(((zzecu) this.zze.zzb()).zzd(zzbxd, i), new zzdze(zzbxd), this.zzb);
    }

    public final ListenableFuture zzc(zzbxd zzbxd) {
        ListenableFuture listenableFuture;
        String str = zzbxd.zzd;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgee.zzg(new zzeal(1));
        } else {
            if (((Boolean) zzba.zzc().zza(zzbdz.zzhB)).booleanValue()) {
                listenableFuture = this.zzc.zzb(new zzdzf(this, zzbxd));
            } else {
                listenableFuture = this.zzd.zzb(zzbxd);
            }
        }
        int callingUid = Binder.getCallingUid();
        zzgdv zzu = zzgdv.zzu(listenableFuture);
        zzbdq zzbdq = zzbdz.zzfz;
        return zzgee.zzf((zzgdv) zzgee.zzo(zzu, (long) ((Integer) zzba.zzc().zza(zzbdq)).intValue(), TimeUnit.SECONDS, this.zza), Throwable.class, new zzdzg(this, zzbxd, callingUid), this.zzb);
    }
}
