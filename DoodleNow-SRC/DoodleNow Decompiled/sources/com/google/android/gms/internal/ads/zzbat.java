package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbat implements Runnable {
    final /* synthetic */ View zza;
    final /* synthetic */ zzbax zzb;

    zzbat(zzbax zzbax, View view) {
        this.zza = view;
        this.zzb = zzbax;
    }

    public final void run() {
        this.zzb.zzc(this.zza);
    }
}
