package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import org.json.JSONArray;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzejb implements zzgdl {
    public final /* synthetic */ zzejd zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzffn zzc;

    public /* synthetic */ zzejb(zzejd zzejd, zzffz zzffz, zzffn zzffn) {
        this.zza = zzejd;
        this.zzb = zzffz;
        this.zzc = zzffn;
    }

    public final ListenableFuture zza(Object obj) {
        return this.zza.zzf(this.zzb, this.zzc, (JSONArray) obj);
    }
}
