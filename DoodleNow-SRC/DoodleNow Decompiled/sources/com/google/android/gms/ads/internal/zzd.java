package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzduh;
import com.google.android.gms.internal.ads.zzfkw;
import com.google.android.gms.internal.ads.zzflk;
import com.google.android.gms.internal.ads.zzgdl;
import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzd implements zzgdl {
    public final /* synthetic */ zzf zza;
    public final /* synthetic */ Long zzb;
    public final /* synthetic */ zzduh zzc;
    public final /* synthetic */ zzflk zzd;
    public final /* synthetic */ zzfkw zze;

    public /* synthetic */ zzd(zzf zzf, Long l, zzduh zzduh, zzflk zzflk, zzfkw zzfkw) {
        this.zza = zzf;
        this.zzb = l;
        this.zzc = zzduh;
        this.zzd = zzflk;
        this.zze = zzfkw;
    }

    public final ListenableFuture zza(Object obj) {
        return zzf.zzd(this.zzb, this.zzc, this.zzd, this.zze, (JSONObject) obj);
    }
}
