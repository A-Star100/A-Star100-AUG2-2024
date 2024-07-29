package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.client.zzm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzu;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzblo implements zzbky {
    private final Object zza = new Object();
    private final Map zzb = new HashMap();

    public final void zza(Object obj, Map map) {
        String str;
        String str2 = (String) map.get("id");
        String str3 = (String) map.get("fail");
        String str4 = (String) map.get("fail_reason");
        String str5 = (String) map.get("fail_stack");
        String str6 = (String) map.get("result");
        if (true == TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            str = "\n".concat(String.valueOf(str5));
        }
        synchronized (this.zza) {
            zzbln zzbln = (zzbln) this.zzb.remove(str2);
            if (zzbln == null) {
                zzm.zzj("Received result for unexpected method invocation: " + str2);
            } else if (!TextUtils.isEmpty(str3)) {
                zzbln.zza(str4 + str);
            } else if (str6 == null) {
                zzbln.zzb((JSONObject) null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zze.zzc()) {
                        String jSONObject2 = jSONObject.toString(2);
                        zze.zza("Result GMSG: " + jSONObject2);
                    }
                    zzbln.zzb(jSONObject);
                } catch (JSONException e) {
                    zzbln.zza(e.getMessage());
                }
            }
        }
    }

    public final ListenableFuture zzb(zzbog zzbog, String str, JSONObject jSONObject) {
        zzcbw zzcbw = new zzcbw();
        zzu.zzp();
        String uuid = UUID.randomUUID().toString();
        zzc(uuid, new zzblm(this, zzcbw));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", uuid);
            jSONObject2.put("args", jSONObject);
            zzbog.zzl(str, jSONObject2);
        } catch (Exception e) {
            zzcbw.zzd(e);
        }
        return zzcbw;
    }

    public final void zzc(String str, zzbln zzbln) {
        synchronized (this.zza) {
            this.zzb.put(str, zzbln);
        }
    }
}
