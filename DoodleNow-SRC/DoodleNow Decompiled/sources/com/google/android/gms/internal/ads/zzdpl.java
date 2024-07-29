package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdpl implements zzgdl {
    public final /* synthetic */ zzdpx zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ JSONObject zzc;

    public /* synthetic */ zzdpl(zzdpx zzdpx, String str, JSONObject jSONObject) {
        this.zza = zzdpx;
        this.zzb = str;
        this.zzc = jSONObject;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (zzcgm) obj);
    }
}
