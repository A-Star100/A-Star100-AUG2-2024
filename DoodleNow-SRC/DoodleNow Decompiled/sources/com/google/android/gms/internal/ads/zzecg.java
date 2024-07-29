package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.common.util.concurrent.ListenableFuture;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzecg implements zzgdl {
    public final /* synthetic */ zzexp zza;
    public final /* synthetic */ zzbxd zzb;

    public /* synthetic */ zzecg(zzexp zzexp, zzbxd zzbxd) {
        this.zza = zzexp;
        this.zzb = zzbxd;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzb().zza(zzay.zzb().zzi((Bundle) obj), this.zzb.zzm);
    }
}
