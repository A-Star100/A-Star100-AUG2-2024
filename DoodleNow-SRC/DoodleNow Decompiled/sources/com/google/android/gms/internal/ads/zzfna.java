package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfna {
    private final zzfni zza;
    private final WebView zzb;
    private final List zzc = new ArrayList();
    private final Map zzd = new HashMap();
    private final String zze;
    private final String zzf;
    private final zzfnb zzg;

    private zzfna(zzfni zzfni, WebView webView, String str, List list, String str2, String str3, zzfnb zzfnb) {
        this.zza = zzfni;
        this.zzb = webView;
        this.zzg = zzfnb;
        this.zzf = str2;
        this.zze = "";
    }

    public static zzfna zzb(zzfni zzfni, WebView webView, String str, String str2) {
        return new zzfna(zzfni, webView, (String) null, (List) null, str, "", zzfnb.HTML);
    }

    public static zzfna zzc(zzfni zzfni, WebView webView, String str, String str2) {
        return new zzfna(zzfni, webView, (String) null, (List) null, str, "", zzfnb.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfnb zzd() {
        return this.zzg;
    }

    public final zzfni zze() {
        return this.zza;
    }

    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
