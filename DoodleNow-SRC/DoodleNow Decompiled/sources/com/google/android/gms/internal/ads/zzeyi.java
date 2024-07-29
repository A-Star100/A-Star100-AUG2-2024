package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeyi implements zzewr {
    private final Context zza;
    private final String zzb;
    private final zzgep zzc;

    public zzeyi(zzbxf zzbxf, Context context, String str, zzgep zzgep) {
        this.zza = context;
        this.zzb = str;
        this.zzc = zzgep;
    }

    public final int zza() {
        return 42;
    }

    public final ListenableFuture zzb() {
        return this.zzc.zzb(new zzeyh(this));
    }
}
