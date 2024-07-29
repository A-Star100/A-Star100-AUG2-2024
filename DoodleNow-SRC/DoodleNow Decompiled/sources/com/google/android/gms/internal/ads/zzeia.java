package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeia implements Runnable {
    public final /* synthetic */ zzeid zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzffn zzc;

    public /* synthetic */ zzeia(zzeid zzeid, zzffz zzffz, zzffn zzffn) {
        this.zza = zzeid;
        this.zzb = zzffz;
        this.zzc = zzffn;
    }

    public final void run() {
        this.zza.zzf(this.zzb, this.zzc);
    }
}
