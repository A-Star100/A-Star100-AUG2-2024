package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdxp implements Runnable {
    public final /* synthetic */ zzdxq zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdxp(zzdxq zzdxq, String str) {
        this.zza = zzdxq;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zzi(this.zzb);
    }
}
