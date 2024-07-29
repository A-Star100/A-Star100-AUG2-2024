package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zzbw;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbjn implements zzbky {
    private final zzbjo zza;

    public zzbjn(zzbjo zzbjo) {
        this.zza = zzbjo;
    }

    public final void zza(Object obj, Map map) {
        if (this.zza != null) {
            String str = (String) map.get("name");
            if (str == null) {
                zzm.zzi("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzbw.zza(new JSONObject((String) map.get("info")));
                } catch (JSONException e) {
                    zzm.zzh("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzm.zzg("Failed to convert ad metadata to Bundle.");
            } else {
                this.zza.zza(str, bundle);
            }
        }
    }
}
