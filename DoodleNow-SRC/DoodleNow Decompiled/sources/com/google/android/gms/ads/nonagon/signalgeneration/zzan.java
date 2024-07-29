package com.google.android.gms.ads.nonagon.signalgeneration;

import com.google.android.gms.internal.ads.zzbxd;
import com.google.android.gms.internal.ads.zzdzh;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.android.gms.internal.ads.zzgee;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzan implements zzgdl {
    private final Executor zza;
    private final zzdzh zzb;

    public zzan(Executor executor, zzdzh zzdzh) {
        this.zza = executor;
        this.zzb = zzdzh;
    }

    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzbxd zzbxd = (zzbxd) obj;
        return zzgee.zzn(this.zzb.zzc(zzbxd), new zzam(zzbxd), this.zza);
    }
}
