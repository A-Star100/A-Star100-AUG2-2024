package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdoj implements zzgdl {
    public final /* synthetic */ zzdot zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdoj(zzdot zzdot, JSONObject jSONObject) {
        this.zza = zzdot;
        this.zzb = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzc(this.zzb, (zzcgm) obj);
    }
}
