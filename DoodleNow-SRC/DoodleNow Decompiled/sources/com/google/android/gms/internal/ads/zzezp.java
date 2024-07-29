package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzezp implements zzewr {
    final ScheduledExecutorService zza;
    final Context zzb;
    final zzbut zzc;

    public zzezp(zzbut zzbut, ScheduledExecutorService scheduledExecutorService, Context context) {
        this.zzc = zzbut;
        this.zza = scheduledExecutorService;
        this.zzb = context;
    }

    public final int zza() {
        return 49;
    }

    public final ListenableFuture zzb() {
        return zzgee.zzm(zzgee.zzo(zzgee.zzh(new Bundle()), ((Long) zzba.zzc().zza(zzbdz.zzeb)).longValue(), TimeUnit.MILLISECONDS, this.zza), zzezo.zza, zzcbr.zza);
    }
}
