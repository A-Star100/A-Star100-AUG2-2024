package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzebd {
    private final zzgep zza;
    private final zzgep zzb;
    private final zzeby zzc;
    private final zzhip zzd;

    zzebd(zzgep zzgep, zzgep zzgep2, zzeby zzeby, zzhip zzhip) {
        this.zza = zzgep;
        this.zzb = zzgep2;
        this.zzc = zzeby;
        this.zzd = zzhip;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzbwi zzbwi) throws Exception {
        return this.zzc.zza(zzbwi, ((Long) zzba.zzc().zza(zzbdz.zzlm)).longValue());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zzb(zzbwi zzbwi, int i, zzeal zzeal) throws Exception {
        return ((zzede) this.zzd.zzb()).zzb(zzbwi, i);
    }

    public final ListenableFuture zzc(zzbwi zzbwi) {
        ListenableFuture listenableFuture;
        String str = zzbwi.zzf;
        zzu.zzp();
        if (zzt.zzC(str)) {
            listenableFuture = zzgee.zzg(new zzeal(1, "Ads service proxy force local"));
        } else {
            listenableFuture = zzgee.zzf(zzgee.zzk(new zzeba(this, zzbwi), this.zza), ExecutionException.class, zzebb.zza, this.zzb);
        }
        return zzgee.zzf(listenableFuture, zzeal.class, new zzebc(this, zzbwi, Binder.getCallingUid()), this.zzb);
    }
}
