package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.google.android.gms.ads.internal.zzu;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbko implements zzbky {
    zzbko() {
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgm zzcgm = (zzcgm) obj;
        try {
            JSONArray jSONArray = new JSONArray((String) map.get("args"));
            SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(zzcgm.getContext()).edit();
            for (int i = 0; i < jSONArray.length(); i++) {
                edit.remove(jSONArray.getString(i));
            }
            edit.apply();
        } catch (JSONException e) {
            zzu.zzo().zzw(e, "GMSG clear local storage keys handler");
        }
    }
}
