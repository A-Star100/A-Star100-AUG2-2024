package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcuk {
    private final Executor zza;
    private final ScheduledExecutorService zzb;
    private final ListenableFuture zzc;
    private volatile boolean zzd = true;

    public zzcuk(Executor executor, ScheduledExecutorService scheduledExecutorService, ListenableFuture listenableFuture) {
        this.zza = executor;
        this.zzb = scheduledExecutorService;
        this.zzc = listenableFuture;
    }

    static /* bridge */ /* synthetic */ void zzb(zzcuk zzcuk, List list, zzgea zzgea) {
        if (list == null || list.isEmpty()) {
            zzcuk.zza.execute(new zzcuf(zzgea));
            return;
        }
        ListenableFuture zzh = zzgee.zzh((Object) null);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzh = zzgee.zzn(zzgee.zzf(zzh, Throwable.class, new zzcug(zzgea), zzcuk.zza), new zzcuh(zzcuk, zzgea, (ListenableFuture) it.next()), zzcuk.zza);
        }
        zzgee.zzr(zzh, new zzcuj(zzcuk, zzgea), zzcuk.zza);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ListenableFuture zza(zzgea zzgea, ListenableFuture listenableFuture, zzctv zzctv) throws Exception {
        if (zzctv != null) {
            zzgea.zzb(zzctv);
        }
        return zzgee.zzo(listenableFuture, ((Long) zzbgf.zzb.zze()).longValue(), TimeUnit.MILLISECONDS, this.zzb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd() {
        this.zzd = false;
    }

    public final void zze(zzgea zzgea) {
        zzgee.zzr(this.zzc, new zzcui(this, zzgea), this.zza);
    }

    public final boolean zzf() {
        return this.zzd;
    }
}
