package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zzu;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzchs extends zzcgu {
    public zzchs(zzcgm zzcgm, zzbcx zzbcx, boolean z, zzefo zzefo) {
        super(zzcgm, zzbcx, z, new zzbtr(zzcgm, zzcgm.zzE(), new zzbdi(zzcgm.getContext())), (zzbtm) null, zzefo);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzS(WebView webView, String str, Map map) {
        String str2;
        if (!(webView instanceof zzcgm)) {
            zzm.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcgm zzcgm = (zzcgm) webView;
        zzbzo zzbzo = this.zza;
        if (zzbzo != null) {
            zzbzo.zzd(str, map, 1);
        }
        zzfsk zzfsk = zzfsk.zza;
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcgm.zzN() != null) {
            zzcgm.zzN().zzF();
        }
        if (zzcgm.zzO().zzi()) {
            str2 = (String) zzba.zzc().zza(zzbdz.zzO);
        } else if (zzcgm.zzaC()) {
            str2 = (String) zzba.zzc().zza(zzbdz.zzN);
        } else {
            str2 = (String) zzba.zzc().zza(zzbdz.zzM);
        }
        zzu.zzp();
        return zzt.zzx(zzcgm.getContext(), zzcgm.zzn().afmaVersion, str2);
    }
}
