package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcda implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcdb zzb;

    zzcda(zzcdb zzcdb, boolean z) {
        this.zza = z;
        this.zzb = zzcdb;
    }

    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
