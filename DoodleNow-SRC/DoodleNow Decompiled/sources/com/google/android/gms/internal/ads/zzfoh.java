package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfoh implements Runnable {
    final /* synthetic */ zzfoi zza;
    private final WebView zzb;

    zzfoh(zzfoi zzfoi) {
        this.zza = zzfoi;
        this.zzb = zzfoi.zza;
    }

    public final void run() {
        this.zzb.destroy();
    }
}
