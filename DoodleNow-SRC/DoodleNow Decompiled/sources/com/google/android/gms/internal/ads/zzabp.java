package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzabp implements Runnable {
    public final /* synthetic */ zzabu zza;
    public final /* synthetic */ Exception zzb;

    public /* synthetic */ zzabp(zzabu zzabu, Exception exc) {
        this.zza = zzabu;
        this.zzb = exc;
    }

    public final void run() {
        this.zza.zzo(this.zzb);
    }
}
