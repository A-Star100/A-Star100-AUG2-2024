package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public abstract class zzfkf {
    /* access modifiers changed from: private */
    public static final ListenableFuture zza = zzgee.zzh((Object) null);
    /* access modifiers changed from: private */
    public final zzgep zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    /* access modifiers changed from: private */
    public final zzfkg zzd;

    public zzfkf(zzgep zzgep, ScheduledExecutorService scheduledExecutorService, zzfkg zzfkg) {
        this.zzb = zzgep;
        this.zzc = scheduledExecutorService;
        this.zzd = zzfkg;
    }

    public final zzfjv zza(Object obj, ListenableFuture... listenableFutureArr) {
        return new zzfjv(this, obj, Arrays.asList(listenableFutureArr), (zzfju) null);
    }

    public final zzfke zzb(Object obj, ListenableFuture listenableFuture) {
        return new zzfke(this, obj, (String) null, listenableFuture, Collections.singletonList(listenableFuture), listenableFuture, (zzfkd) null);
    }

    /* access modifiers changed from: protected */
    public abstract String zzf(Object obj);
}
