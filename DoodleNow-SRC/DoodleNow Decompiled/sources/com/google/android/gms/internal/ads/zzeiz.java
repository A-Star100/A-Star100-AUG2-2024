package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeiz implements zzgdl {
    public final /* synthetic */ zzejd zza;
    public final /* synthetic */ zzdpx zzb;

    public /* synthetic */ zzeiz(zzejd zzejd, zzdpx zzdpx) {
        this.zza = zzejd;
        this.zzb = zzdpx;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzd(this.zzb, (JSONObject) obj);
    }
}
