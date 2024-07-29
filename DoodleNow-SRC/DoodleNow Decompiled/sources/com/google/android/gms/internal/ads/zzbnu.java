package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.util.client.zzm;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzbnu {
    public static void zza(zzbnv zzbnv, String str, Map map) {
        try {
            zzbnv.zze(str, zzay.zzb().zzj(map));
        } catch (JSONException unused) {
            zzm.zzj("Could not convert parameters to JSON.");
        }
    }

    public static void zzb(zzbnv zzbnv, String str, JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("',");
        sb.append(jSONObject2);
        sb.append(");");
        zzm.zze("Dispatching AFMA event: ".concat(sb.toString()));
        zzbnv.zza(sb.toString());
    }

    public static void zzc(zzbnv zzbnv, String str, String str2) {
        zzbnv.zza(str + "(" + str2 + ");");
    }

    public static void zzd(zzbnv zzbnv, String str, JSONObject jSONObject) {
        zzbnv.zzb(str, jSONObject.toString());
    }
}
