package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzccz implements Runnable {
    final /* synthetic */ zzcdb zza;

    zzccz(zzcdb zzcdb) {
        this.zza = zzcdb;
    }

    public final void run() {
        this.zza.zzK("surfaceDestroyed", new String[0]);
    }
}
