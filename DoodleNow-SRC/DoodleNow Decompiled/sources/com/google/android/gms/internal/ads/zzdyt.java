package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzu;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdyt implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzdyt(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        CookieManager zza2 = zzu.zzq().zza((Context) this.zzb.zzb());
        zzfkh zzfkh = zzfkh.WEBVIEW_COOKIE;
        return zzfjx.zza(new zzdyq(zza2), zzfkh, (zzfkn) this.zza.zzb()).zzi(1, TimeUnit.SECONDS).zzc(Exception.class, new zzfjy(zzdyr.zza)).zza();
    }
}
