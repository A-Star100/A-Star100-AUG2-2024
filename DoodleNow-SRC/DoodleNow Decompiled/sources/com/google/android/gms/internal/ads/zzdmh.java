package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdmh implements zzbky {
    public final /* synthetic */ zzdmk zza;

    public /* synthetic */ zzdmh(zzdmk zzdmk) {
        this.zza = zzdmk;
    }

    public final void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        zzcgm.zzN().zzB(new zzdme(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcgm.loadData(str, "text/html", "UTF-8");
        } else {
            zzcgm.loadDataWithBaseURL(str2, str, "text/html", "UTF-8", (String) null);
        }
    }
}
