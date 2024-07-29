package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.zze;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfal implements zzewq {
    private final Map zza;

    public zzfal(Map map) {
        this.zza = map;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            ((JSONObject) obj).put("video_decoders", zzay.zzb().zzj(this.zza));
        } catch (JSONException e) {
            zze.zza("Could not encode video decoder properties: ".concat(String.valueOf(e.getMessage())));
        }
    }
}
