package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzbw;
import com.google.android.gms.ads.internal.util.zze;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzeyu implements zzewq {
    private final String zza;

    public zzeyu(String str) {
        this.zza = str;
    }

    public final /* bridge */ /* synthetic */ void zzj(Object obj) {
        try {
            JSONObject zzf = zzbw.zzf((JSONObject) obj, "pii");
            if (!TextUtils.isEmpty(this.zza)) {
                zzf.put("attok", this.zza);
            }
        } catch (JSONException e) {
            zze.zzb("Failed putting attestation token.", e);
        }
    }
}
