package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.client.zzay;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzebn implements zzfwf {
    public final /* synthetic */ zzebo zza;
    public final /* synthetic */ zzbxd zzb;

    public /* synthetic */ zzebn(zzebo zzebo, zzbxd zzbxd) {
        this.zza = zzebo;
        this.zzb = zzbxd;
    }

    public final Object apply(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        Bundle bundle = this.zzb.zza;
        if (bundle == null) {
            return jSONObject;
        }
        try {
            JSONObject zzi = zzay.zzb().zzi(bundle);
            try {
                zzay.zzb().zzl(jSONObject, zzi);
                return jSONObject;
            } catch (JSONException unused) {
                return zzi;
            }
        } catch (JSONException unused2) {
            return jSONObject;
        }
    }
}
