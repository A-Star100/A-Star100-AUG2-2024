package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzelj implements Runnable {
    public final /* synthetic */ zzelk zza;
    public final /* synthetic */ zzffz zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ zzegm zzd;

    public /* synthetic */ zzelj(zzelk zzelk, zzffz zzffz, zzffn zzffn, zzegm zzegm) {
        this.zza = zzelk;
        this.zzb = zzffz;
        this.zzc = zzffn;
        this.zzd = zzegm;
    }

    public final void run() {
        zzelm.zze(this.zzb, this.zzc, this.zzd);
    }
}
