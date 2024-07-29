package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzchl implements Runnable {
    public final /* synthetic */ zzchm zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;
    public final /* synthetic */ boolean zzd;
    public final /* synthetic */ boolean zze;

    public /* synthetic */ zzchl(zzchm zzchm, int i, int i2, boolean z, boolean z2) {
        this.zza = zzchm;
        this.zzb = i;
        this.zzc = i2;
        this.zzd = z;
        this.zze = z2;
    }

    public final void run() {
        this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
