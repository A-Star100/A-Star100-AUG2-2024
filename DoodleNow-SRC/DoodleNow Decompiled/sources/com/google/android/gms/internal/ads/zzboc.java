package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzboc implements Runnable {
    public final /* synthetic */ zzbof zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzboc(zzbof zzbof, String str) {
        this.zza = zzbof;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzn(this.zzb);
    }
}
