package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.zzba;
import java.lang.ref.WeakReference;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdjq implements zzbky {
    private final WeakReference zza;

    /* synthetic */ zzdjq(zzdjv zzdjv, zzdjp zzdjp) {
        this.zza = new WeakReference(zzdjv);
    }

    public final void zza(Object obj, Map map) {
        zzdjv zzdjv = (zzdjv) this.zza.get();
        if (zzdjv != null && "_ac".equals((String) map.get("eventName"))) {
            zzdjv.zzh.onAdClicked();
            if (((Boolean) zzba.zzc().zza(zzbdz.zzkv)).booleanValue()) {
                zzdjv.zzi.zzdG();
                if (!TextUtils.isEmpty((CharSequence) map.get("sccg"))) {
                    zzdjv.zzi.zzdf();
                }
            }
        }
    }
}
