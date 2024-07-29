package com.google.android.gms.internal.ads;

import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzfog extends WebViewClient {
    final /* synthetic */ zzfoi zza;

    zzfog(zzfoi zzfoi) {
        this.zza = zzfoi;
    }

    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        String obj = renderProcessGoneDetail.toString();
        String valueOf = String.valueOf(webView);
        Log.w("NativeBridge", "WebView renderer gone: " + obj + "for WebView: " + valueOf);
        if (this.zza.zza() == webView) {
            Log.w("NativeBridge", "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            this.zza.zzm((WebView) null);
        }
        webView.destroy();
        return true;
    }
}
