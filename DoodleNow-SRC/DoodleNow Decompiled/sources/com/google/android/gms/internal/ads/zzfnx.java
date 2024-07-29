package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.amazon.a.a.o.b.f;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfnx {
    private static final zzfnx zza = new zzfnx();

    private zzfnx() {
    }

    public static final zzfnx zza() {
        return zza;
    }

    public static final boolean zzj(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            webView.evaluateJavascript(str, (ValueCallback) null);
            return true;
        } catch (IllegalStateException unused) {
            webView.loadUrl("javascript: ".concat(String.valueOf(str)));
            return true;
        }
    }

    public final void zzc(WebView webView, String str) {
        zzb(webView, "finishSession", str);
    }

    public final void zzd(WebView webView, String str, JSONObject jSONObject) {
        zzb(webView, "init", jSONObject, str);
    }

    public final void zze(WebView webView, String str, float f) {
        zzb(webView, "setDeviceVolume", Float.valueOf(f), str);
    }

    public final void zzf(WebView webView, JSONObject jSONObject) {
        zzb(webView, "setLastActivity", jSONObject);
    }

    public final void zzg(WebView webView, String str, String str2) {
        zzb(webView, "setNativeViewHierarchy", str2, str);
    }

    public final void zzh(WebView webView, String str, String str2) {
        zzb(webView, "setState", str2, str);
    }

    public final void zzi(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        zzb(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append("null");
                } else if (obj instanceof String) {
                    String obj2 = obj.toString();
                    if (obj2.startsWith("{")) {
                        sb.append(obj2);
                    } else {
                        sb.append('\"');
                        sb.append(obj2);
                        sb.append('\"');
                    }
                } else {
                    sb.append(obj);
                }
                sb.append(f.a);
            }
            sb.setLength(sb.length() - 1);
            sb.append(")}");
            String sb2 = sb.toString();
            Handler handler = webView.getHandler();
            if (handler == null || Looper.myLooper() == handler.getLooper()) {
                zzj(webView, sb2);
            } else {
                handler.post(new zzfnw(this, webView, sb2));
            }
        } else {
            zzfmv.zza.booleanValue();
        }
    }
}
