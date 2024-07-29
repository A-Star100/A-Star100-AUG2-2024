package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeyx implements zzewr {
    final zzgep zza;
    final Context zzb;
    final zzbcm zzc;

    public zzeyx(zzbcm zzbcm, zzgep zzgep, Context context) {
        this.zzc = zzbcm;
        this.zza = zzgep;
        this.zzb = context;
    }

    public final int zza() {
        return 45;
    }

    public final ListenableFuture zzb() {
        return this.zza.zzb(new zzeyw(this));
    }
}
