package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcuz implements zzgdl {
    public final /* synthetic */ zzcvd zza;
    public final /* synthetic */ zzfid zzb;

    public /* synthetic */ zzcuz(zzcvd zzcvd, zzfid zzfid) {
        this.zza = zzcvd;
        this.zzb = zzfid;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, (zzbxd) obj);
    }
}
