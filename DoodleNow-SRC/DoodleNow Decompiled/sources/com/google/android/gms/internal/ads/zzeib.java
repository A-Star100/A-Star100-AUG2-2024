package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeib implements Callable {
    public final /* synthetic */ zzeid zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzffn zzc;

    public /* synthetic */ zzeib(zzeid zzeid, zzffz zzffz, zzffn zzffn) {
        this.zza = zzeid;
        this.zzb = zzffz;
        this.zzc = zzffn;
    }

    public final Object call() {
        return this.zza.zzc(this.zzb, this.zzc);
    }
}
