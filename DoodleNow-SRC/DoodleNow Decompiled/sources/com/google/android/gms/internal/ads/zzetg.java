package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzetg implements zzewr {
    private final Context zza;
    private final zzgep zzb;

    public zzetg(Context context, zzgep zzgep) {
        this.zza = context;
        this.zzb = zzgep;
    }

    public final int zza() {
        return 19;
    }

    public final ListenableFuture zzb() {
        return this.zzb.zzb(new zzetf(this));
    }
}
