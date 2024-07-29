package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdun implements Runnable {
    public final /* synthetic */ zzdup zza;
    public final /* synthetic */ String zzb;

    public /* synthetic */ zzdun(zzdup zzdup, String str) {
        this.zza = zzdup;
        this.zzb = str;
    }

    public final void run() {
        this.zza.zze.zza(this.zzb);
    }
}
