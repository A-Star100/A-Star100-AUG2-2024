package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcpt implements Runnable {
    public final /* synthetic */ zzcpw zza;
    public final /* synthetic */ int zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzcpt(zzcpw zzcpw, int i, int i2) {
        this.zza = zzcpw;
        this.zzb = i;
        this.zzc = i2;
    }

    public final void run() {
        this.zza.zzp(this.zzb, this.zzc);
    }
}
