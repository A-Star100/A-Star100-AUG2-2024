package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeqo implements zzewr {
    private final Executor zza;
    private final zzcbh zzb;

    zzeqo(Executor executor, zzcbh zzcbh) {
        this.zza = executor;
        this.zzb = zzcbh;
    }

    public final int zza() {
        return 10;
    }

    public final ListenableFuture zzb() {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzcE)).booleanValue()) {
            return zzgee.zzh((Object) null);
        }
        zzcbh zzcbh = this.zzb;
        return zzgee.zzm(zzcbh.zzk(), zzeqn.zza, this.zza);
    }
}
