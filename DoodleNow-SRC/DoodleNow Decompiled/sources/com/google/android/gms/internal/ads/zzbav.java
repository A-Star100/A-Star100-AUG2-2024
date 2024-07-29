package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbav implements Runnable {
    final ValueCallback zza;
    final /* synthetic */ zzban zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzbax zze;

    zzbav(zzbax zzbax, zzban zzban, WebView webView, boolean z) {
        this.zzb = zzban;
        this.zzc = webView;
        this.zzd = z;
        this.zze = zzbax;
        this.zza = new zzbau(this, zzban, webView, z);
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                this.zza.onReceiveValue("");
            }
        }
    }
}
