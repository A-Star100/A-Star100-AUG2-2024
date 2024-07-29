package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfke {
    final /* synthetic */ zzfkf zza;
    private final Object zzb;
    private final String zzc;
    private final ListenableFuture zzd;
    private final List zze;
    private final ListenableFuture zzf;

    private zzfke(zzfkf zzfkf, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2) {
        this.zza = zzfkf;
        this.zzb = obj;
        this.zzc = str;
        this.zzd = listenableFuture;
        this.zze = list;
        this.zzf = listenableFuture2;
    }

    /* synthetic */ zzfke(zzfkf zzfkf, Object obj, String str, ListenableFuture listenableFuture, List list, ListenableFuture listenableFuture2, zzfkd zzfkd) {
        this(zzfkf, obj, (String) null, listenableFuture, list, listenableFuture2);
    }

    public final zzfjs zza() {
        Object obj = this.zzb;
        String str = this.zzc;
        if (str == null) {
            str = this.zza.zzf(obj);
        }
        zzfjs zzfjs = new zzfjs(obj, str, this.zzf);
        this.zza.zzd.zza(zzfjs);
        this.zzd.addListener(new zzfkb(this, zzfjs), zzcbr.zzf);
        zzgee.zzr(zzfjs, new zzfkc(this, zzfjs), zzcbr.zzf);
        return zzfjs;
    }

    public final zzfke zzb(Object obj) {
        return this.zza.zzb(obj, zza());
    }

    public final zzfke zzc(Class cls, zzgdl zzgdl) {
        return new zzfke(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgee.zzf(this.zzf, cls, zzgdl, this.zza.zzb));
    }

    public final zzfke zzd(ListenableFuture listenableFuture) {
        return zzg(new zzfka(listenableFuture), zzcbr.zzf);
    }

    public final zzfke zze(zzfjq zzfjq) {
        return zzf(new zzfjz(zzfjq));
    }

    public final zzfke zzf(zzgdl zzgdl) {
        return zzg(zzgdl, this.zza.zzb);
    }

    public final zzfke zzg(zzgdl zzgdl, Executor executor) {
        return new zzfke(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgee.zzn(this.zzf, zzgdl, executor));
    }

    public final zzfke zzh(String str) {
        return new zzfke(this.zza, this.zzb, str, this.zzd, this.zze, this.zzf);
    }

    public final zzfke zzi(long j, TimeUnit timeUnit) {
        return new zzfke(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zzgee.zzo(this.zzf, j, timeUnit, this.zza.zzc));
    }
}
