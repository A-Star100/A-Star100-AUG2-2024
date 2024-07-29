package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzezj implements zzewr {
    final zzgep zza;
    final List zzb;
    final zzbdj zzc;

    public zzezj(zzbdj zzbdj, zzgep zzgep, List list) {
        this.zzc = zzbdj;
        this.zza = zzgep;
        this.zzb = list;
    }

    public final int zza() {
        return 48;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzezi(this));
    }
}
