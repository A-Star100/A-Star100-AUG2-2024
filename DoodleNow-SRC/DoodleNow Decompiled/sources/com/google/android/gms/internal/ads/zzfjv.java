package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfjv {
    final /* synthetic */ zzfkf zza;
    private final Object zzb;
    private final List zzc;

    /* synthetic */ zzfjv(zzfkf zzfkf, Object obj, List list, zzfju zzfju) {
        this.zza = zzfkf;
        this.zzb = obj;
        this.zzc = list;
    }

    public final zzfke zza(Callable callable) {
        zzged zzb2 = zzgee.zzb(this.zzc);
        ListenableFuture zza2 = zzb2.zza(zzfjt.zza, zzcbr.zzf);
        ListenableFuture zza3 = zzb2.zza(callable, this.zza.zzb);
        return new zzfke(this.zza, this.zzb, (String) null, zza2, this.zzc, zza3, (zzfkd) null);
    }
}
