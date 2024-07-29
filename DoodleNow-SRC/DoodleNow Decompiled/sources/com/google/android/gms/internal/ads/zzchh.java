package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzchh implements zzbky {
    final /* synthetic */ zzchj zza;

    zzchh(zzchj zzchj) {
        this.zza = zzchj;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        zzchj zzchj = this.zza;
                        if (zzchj.zzH != parseInt) {
                            zzchj.zzH = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzm.zzk("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
