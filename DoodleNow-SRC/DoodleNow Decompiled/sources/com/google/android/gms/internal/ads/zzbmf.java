package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
public final /* synthetic */ class zzbmf implements OnH5AdsEventListener {
    public final /* synthetic */ WebView zza;

    public /* synthetic */ zzbmf(WebView webView) {
        this.zza = webView;
    }

    public final void onH5AdsEvent(String str) {
        int i = zzbmg.zza;
        this.zza.evaluateJavascript(str, (ValueCallback) null);
    }
}
