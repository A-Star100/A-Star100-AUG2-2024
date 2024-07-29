package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbke implements zzbky {
    zzbke() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject zzb;
        zzcgm zzcgm = (zzcgm) obj;
        zzbgs zzK = zzcgm.zzK();
        if (zzK == null || (zzb = zzK.zzb()) == null) {
            zzcgm.zze("nativeClickMetaReady", new JSONObject());
        } else {
            zzcgm.zze("nativeClickMetaReady", zzb);
        }
    }
}
