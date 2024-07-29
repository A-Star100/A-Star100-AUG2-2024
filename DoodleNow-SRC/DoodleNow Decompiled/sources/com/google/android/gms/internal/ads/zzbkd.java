package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbkd implements zzbky {
    zzbkd() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zza;
        zzcgm zzcgm = (zzcgm) obj;
        zzbgs zzK = zzcgm.zzK();
        if (zzK == null || (zza = zzK.zza()) == null) {
            zzcgm.zze("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcgm.zze("nativeAdViewSignalsReady", zza);
        }
    }
}
