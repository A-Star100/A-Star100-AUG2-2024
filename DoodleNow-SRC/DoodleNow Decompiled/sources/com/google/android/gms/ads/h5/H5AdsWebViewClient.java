package com.google.android.gms.ads.h5;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.internal.ads.zzblt;
import com.google.android.gms.internal.ads.zzbmg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final class H5AdsWebViewClient extends zzblt {
    private final zzbmg zza;

    public H5AdsWebViewClient(Context context, WebView webView) {
        this.zza = new zzbmg(context, webView);
    }

    public void clearAdObjects() {
        this.zza.zza();
    }

    /* access modifiers changed from: protected */
    public WebViewClient getDelegate() {
        return this.zza;
    }

    public WebViewClient getDelegateWebViewClient() {
        return this.zza.getDelegate();
    }

    public void setDelegateWebViewClient(WebViewClient webViewClient) {
        this.zza.zzb(webViewClient);
    }
}
