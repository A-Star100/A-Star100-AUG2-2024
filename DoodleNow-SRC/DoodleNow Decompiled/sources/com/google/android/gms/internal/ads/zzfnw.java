package com.google.android.gms.internal.ads;

import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfnw implements Runnable {
    final /* synthetic */ WebView zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzfnx zzc;

    zzfnw(zzfnx zzfnx, WebView webView, String str) {
        this.zza = webView;
        this.zzb = str;
        this.zzc = zzfnx;
    }

    public final void run() {
        zzfnx.zzj(this.zza, this.zzb);
    }
}
