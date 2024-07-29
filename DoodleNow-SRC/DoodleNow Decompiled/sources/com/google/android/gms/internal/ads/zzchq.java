package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.webkit.JavascriptInterface;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzchq {
    private final zzchr zza;
    private final zzchp zzb;

    public zzchq(zzchr zzchr, zzchp zzchp) {
        this.zzb = zzchp;
        this.zza = zzchr;
    }

    /* JADX WARNING: type inference failed for: r0v1, types: [com.google.android.gms.internal.ads.zzchx, com.google.android.gms.internal.ads.zzchr] */
    @JavascriptInterface
    public String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zze.zza("Click string is empty, not proceeding.");
            return "";
        }
        ? r0 = this.zza;
        zzawo zzI = r0.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzawk zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzchr zzchr = this.zza;
            return zzc.zzf(zzchr.getContext(), str, (View) zzchr, zzchr.zzi());
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.android.gms.internal.ads.zzchx, com.google.android.gms.internal.ads.zzchr] */
    @JavascriptInterface
    public String getViewSignals() {
        ? r0 = this.zza;
        zzawo zzI = r0.zzI();
        if (zzI == null) {
            zze.zza("Signal utils is empty, ignoring.");
            return "";
        }
        zzawk zzc = zzI.zzc();
        if (zzc == null) {
            zze.zza("Signals object is empty, ignoring.");
            return "";
        } else if (r0.getContext() == null) {
            zze.zza("Context is null, ignoring.");
            return "";
        } else {
            zzchr zzchr = this.zza;
            return zzc.zzh(zzchr.getContext(), (View) zzchr, zzchr.zzi());
        }
    }

    @JavascriptInterface
    public void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzm.zzj("URL is empty, ignoring message");
        } else {
            zzt.zza.post(new zzcho(this, str));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(String str) {
        Uri parse = Uri.parse(str);
        zzcgu zzaL = ((zzchj) this.zzb.zza).zzaL();
        if (zzaL == null) {
            zzm.zzg("Unable to pass GMSG, no AdWebViewClient for AdWebView!");
        } else {
            zzaL.zzj(parse);
        }
    }
}
