package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.WebSettings;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzftg;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzk implements Callable {
    public final /* synthetic */ WebSettings zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzk(WebSettings webSettings, Context context) {
        this.zza = webSettings;
        this.zzb = context;
    }

    public final Object call() {
        zzftg zzftg = zzt.zza;
        String absolutePath = this.zzb.getDatabasePath("com.google.android.gms.ads.db").getAbsolutePath();
        WebSettings webSettings = this.zza;
        webSettings.setDatabasePath(absolutePath);
        webSettings.setDatabaseEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setDisplayZoomControls(false);
        webSettings.setBuiltInZoomControls(true);
        webSettings.setSupportZoom(true);
        if (((Boolean) zzba.zzc().zza(zzbdz.zzaK)).booleanValue()) {
            webSettings.setTextZoom(100);
        }
        webSettings.setAllowContentAccess(false);
        return true;
    }
}
