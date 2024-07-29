package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfjx {
    public static final zzfke zza(Callable callable, Object obj, zzfkf zzfkf) {
        return zzb(callable, zzfkf.zzb, obj, zzfkf);
    }

    public static final zzfke zzb(Callable callable, zzgep zzgep, Object obj, zzfkf zzfkf) {
        return new zzfke(zzfkf, obj, (String) null, zzfkf.zza, Collections.emptyList(), zzgep.zzb(callable), (zzfkd) null);
    }

    public static final zzfke zzc(ListenableFuture listenableFuture, Object obj, zzfkf zzfkf) {
        return new zzfke(zzfkf, obj, (String) null, zzfkf.zza, Collections.emptyList(), listenableFuture, (zzfkd) null);
    }

    public static final zzfke zzd(zzfjr zzfjr, zzgep zzgep, Object obj, zzfkf zzfkf) {
        return zzb(new zzfjw(zzfjr), zzgep, obj, zzfkf);
    }
}
