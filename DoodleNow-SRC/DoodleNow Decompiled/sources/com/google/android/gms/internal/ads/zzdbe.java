package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdbe implements Runnable {
    private final WeakReference zza;

    /* synthetic */ zzdbe(zzdbf zzdbf, zzdbd zzdbd) {
        this.zza = new WeakReference(zzdbf);
    }

    public final void run() {
        zzdbf zzdbf = (zzdbf) this.zza.get();
        if (zzdbf != null) {
            zzdbf.zzq(zzdbc.zza);
        }
    }
}
