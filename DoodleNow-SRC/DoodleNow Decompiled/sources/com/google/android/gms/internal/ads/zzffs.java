package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbw;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzffs {
    public final String zza;
    public final String zzb;
    public final JSONObject zzc;
    public final JSONObject zzd;

    zzffs(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzh = zzbw.zzh(jsonReader);
        this.zzd = zzh;
        this.zza = zzh.optString("ad_html", (String) null);
        this.zzb = zzh.optString("ad_base_url", (String) null);
        this.zzc = zzh.optJSONObject("ad_json");
    }
}
