package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzebj {
    private final zzgep zza;
    private final zzgep zzb;
    private final zzecb zzc;

    zzebj(zzgep zzgep, zzgep zzgep2, zzecb zzecb) {
        this.zza = zzgep;
        this.zzb = zzgep2;
        this.zzc = zzecb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbwe zzbwe) throws Exception {
        return this.zzc.zza(zzbwe, ((Long) zzba.zzc().zza(zzbdz.zzll)).longValue());
    }

    public final ListenableFuture zzb(zzbwe zzbwe) {
        ListenableFuture listenableFuture;
        String str = zzbwe.zzb;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgee.zzg(new zzeal(1, "Ads signal service force local"));
        } else {
            listenableFuture = zzgee.zzf(zzgee.zzk(new zzebf(this, zzbwe), this.zza), ExecutionException.class, zzebg.zza, this.zzb);
        }
        return zzgee.zzn(zzgee.zzf(zzgdv.zzu(listenableFuture), zzeal.class, zzebh.zza, this.zzb), zzebi.zza, this.zzb);
    }
}
