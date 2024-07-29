package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdwb implements Runnable {
    public final /* synthetic */ zzdwk zza;
    public final /* synthetic */ Object zzb;
    public final /* synthetic */ zzcbw zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ long zze;
    public final /* synthetic */ zzfkw zzf;

    public /* synthetic */ zzdwb(zzdwk zzdwk, Object obj, zzcbw zzcbw, String str, long j, zzfkw zzfkw) {
        this.zza = zzdwk;
        this.zzb = obj;
        this.zzc = zzcbw;
        this.zzd = str;
        this.zze = j;
        this.zzf = zzfkw;
    }

    public final void run() {
        this.zza.zzq(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
