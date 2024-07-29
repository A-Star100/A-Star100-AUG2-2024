package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeiy implements Callable {
    public final /* synthetic */ zzejd zza;
    public final /* synthetic */ ListenableFuture zzb;
    public final /* synthetic */ ListenableFuture zzc;
    public final /* synthetic */ zzffz zzd;
    public final /* synthetic */ zzffn zze;
    public final /* synthetic */ JSONObject zzf;

    public /* synthetic */ zzeiy(zzejd zzejd, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, zzffz zzffz, zzffn zzffn, JSONObject jSONObject) {
        this.zza = zzejd;
        this.zzb = listenableFuture;
        this.zzc = listenableFuture2;
        this.zzd = zzffz;
        this.zze = zzffn;
        this.zzf = jSONObject;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
