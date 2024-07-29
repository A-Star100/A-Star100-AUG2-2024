package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzu;
import com.onesignal.location.internal.common.LocationConstants;
import com.revenuecat.purchases.common.Constants;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcgl extends WebChromeClient {
    private final zzcgm zza;

    public zzcgl(zzcgm zzcgm) {
        this.zza = zzcgm;
    }

    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcgm)) {
            return webView.getContext();
        }
        zzcgm zzcgm = (zzcgm) webView;
        Activity zzi = zzcgm.zzi();
        if (zzi != null) {
            return zzi;
        }
        return zzcgm.getContext();
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcgm)) {
            zzm.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzm zzL = ((zzcgm) webView).zzL();
        if (zzL == null) {
            zzm.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzL.zzb();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String str = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR + consoleMessage.lineNumber() + ")";
        if (str.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i = zzcgk.zza[consoleMessage.messageLevel().ordinal()];
        if (i == 1) {
            zzm.zzg(str);
        } else if (i == 2) {
            zzm.zzj(str);
        } else if (i == 3 || i == 4) {
            zzm.zzi(str);
        } else if (i != 5) {
            zzm.zzi(str);
        } else {
            zzm.zze(str);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzH() != null) {
            webView2.setWebViewClient(this.zza.zzH());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
        long j4 = CacheDataSink.DEFAULT_FRAGMENT_SIZE - j3;
        if (j4 <= 0) {
            quotaUpdater.updateQuota(j);
            return;
        }
        if (j == 0) {
            if (j2 > j4 || j2 > 1048576) {
                j2 = 0;
            }
        } else if (j2 == 0) {
            j2 = Math.min(j + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j4), 1048576);
        } else {
            if (j2 <= Math.min(1048576 - j, j4)) {
                j += j2;
            }
            j2 = j;
        }
        quotaUpdater.updateQuota(j2);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z;
        if (callback != null) {
            zzcgm zzcgm = this.zza;
            zzu.zzp();
            if (!zzt.zzA(zzcgm.getContext(), LocationConstants.ANDROID_FINE_LOCATION_PERMISSION_STRING)) {
                zzcgm zzcgm2 = this.zza;
                zzu.zzp();
                if (!zzt.zzA(zzcgm2.getContext(), LocationConstants.ANDROID_COARSE_LOCATION_PERMISSION_STRING)) {
                    z = false;
                    callback.invoke(str, z, true);
                }
            }
            z = true;
            callback.invoke(str, z, true);
        }
    }

    public final void onHideCustomView() {
        com.google.android.gms.ads.internal.overlay.zzm zzL = this.zza.zzL();
        if (zzL == null) {
            zzm.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzL.zzg();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    @Deprecated
    public final void onShowCustomView(View view, int i, WebChromeClient.CustomViewCallback customViewCallback) {
        com.google.android.gms.ads.internal.overlay.zzm zzL = this.zza.zzL();
        if (zzL == null) {
            zzm.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzL.zzC(view, customViewCallback);
        zzL.zzA(i);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z) {
        zzb zzd;
        try {
            zzcgm zzcgm = this.zza;
            if (zzcgm == null || zzcgm.zzN() == null || this.zza.zzN().zzd() == null || (zzd = this.zza.zzN().zzd()) == null || zzd.zzc()) {
                zzu.zzp();
                AlertDialog.Builder zzK = zzt.zzK(context);
                zzK.setTitle(str2);
                if (z) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    zzK.setView(linearLayout).setPositiveButton(17039370, new zzcgj(jsPromptResult, editText)).setNegativeButton(17039360, new zzcgi(jsPromptResult)).setOnCancelListener(new zzcgh(jsPromptResult)).create().show();
                } else {
                    zzK.setMessage(str3).setPositiveButton(17039370, new zzcgg(jsResult)).setNegativeButton(17039360, new zzcgf(jsResult)).setOnCancelListener(new zzcge(jsResult)).create().show();
                }
                return true;
            }
            zzd.zzb("window." + str + "('" + str3 + "')");
            return false;
        } catch (WindowManager.BadTokenException e) {
            zzm.zzk("Fail to display Dialog.", e);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
