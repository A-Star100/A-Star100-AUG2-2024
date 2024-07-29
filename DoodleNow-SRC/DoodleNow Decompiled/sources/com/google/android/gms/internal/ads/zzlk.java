package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzlk implements Runnable {
    public final /* synthetic */ zzll zza;
    public final /* synthetic */ zzfzk zzb;
    public final /* synthetic */ zzvh zzc;

    public /* synthetic */ zzlk(zzll zzll, zzfzk zzfzk, zzvh zzvh) {
        this.zza = zzll;
        this.zzb = zzfzk;
        this.zzc = zzvh;
    }

    public final void run() {
        this.zza.zzk(this.zzb, this.zzc);
    }
}
