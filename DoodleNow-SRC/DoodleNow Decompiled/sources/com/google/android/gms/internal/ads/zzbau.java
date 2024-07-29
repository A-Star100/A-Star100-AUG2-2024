package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbau implements ValueCallback {
    public final /* synthetic */ zzbav zza;
    public final /* synthetic */ zzban zzb;
    public final /* synthetic */ WebView zzc;
    public final /* synthetic */ boolean zzd;

    public /* synthetic */ zzbau(zzbav zzbav, zzban zzban, WebView webView, boolean z) {
        this.zza = zzbav;
        this.zzb = zzban;
        this.zzc = webView;
        this.zzd = z;
    }

    public final void onReceiveValue(Object obj) {
        this.zza.zze.zzd(this.zzb, this.zzc, (String) obj, this.zzd);
    }
}
