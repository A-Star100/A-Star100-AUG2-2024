package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.internal.ads.zzbcx;
import com.google.android.gms.internal.ads.zzcgm;
import com.google.android.gms.internal.ads.zzcgu;
import com.google.android.gms.internal.ads.zzcht;
import com.google.android.gms.internal.ads.zzefo;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzu extends zzab {
    public zzu() {
        super((zzaa) null);
    }

    public final CookieManager zza(Context context) {
        com.google.android.gms.ads.internal.zzu.zzp();
        if (zzt.zzF()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzm.zzh("Failed to obtain CookieManager.", th);
            com.google.android.gms.ads.internal.zzu.zzo().zzv(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final WebResourceResponse zzb(String str, String str2, int i, String str3, Map map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }

    public final zzcgu zzc(zzcgm zzcgm, zzbcx zzbcx, boolean z, zzefo zzefo) {
        return new zzcht(zzcgm, zzbcx, z, zzefo);
    }
}
