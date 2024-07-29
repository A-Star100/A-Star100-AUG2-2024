package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.webkit.WebView;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfoi extends zzfoe {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map zzc;

    public zzfoi(String str, Map map, String str2) {
        super(str);
        this.zzc = map;
    }

    public final void zzc() {
        long j;
        super.zzc();
        if (this.zzb == null) {
            j = 4000;
        } else {
            j = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzfoh(this), Math.max(4000 - j, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.zza = null;
    }

    public final void zzi(zzfnc zzfnc, zzfna zzfna) {
        JSONObject jSONObject = new JSONObject();
        Map zzi = zzfna.zzi();
        Iterator it = zzi.keySet().iterator();
        if (!it.hasNext()) {
            zzj(zzfnc, zzfna, jSONObject);
        } else {
            zzfnj zzfnj = (zzfnj) zzi.get((String) it.next());
            throw null;
        }
    }

    public final void zzn() {
        WebView webView = new WebView(zzfnv.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.zza.getSettings().setAllowContentAccess(false);
        this.zza.getSettings().setAllowFileAccess(false);
        this.zza.setWebViewClient(new zzfog(this));
        zzm(this.zza);
        zzfnx.zzj(this.zza, (String) null);
        Iterator it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzfnj zzfnj = (zzfnj) this.zzc.get((String) it.next());
        throw null;
    }
}
