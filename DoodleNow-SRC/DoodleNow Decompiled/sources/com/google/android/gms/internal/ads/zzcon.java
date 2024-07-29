package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcon implements zzcoa {
    zzcon() {
    }

    public final void zza(Map map) {
        if (((Boolean) zzba.zzc().zza(zzbdz.zzkd)).booleanValue() && !map.isEmpty()) {
            String str = (String) map.get("is_topics_ad_personalization_allowed");
            if (!TextUtils.isEmpty(str)) {
                zzu.zzo().zzi().zzG(Boolean.parseBoolean(str));
            }
        }
    }
}
