package com.google.android.gms.internal.ads;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcht extends zzchs {
    public zzcht(zzcgm zzcgm, zzbcx zzbcx, boolean z, zzefo zzefo) {
        super(zzcgm, zzbcx, z, zzefo);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (webResourceRequest == null || webResourceRequest.getUrl() == null) {
            return null;
        }
        return zzS(webView, webResourceRequest.getUrl().toString(), webResourceRequest.getRequestHeaders());
    }
}
