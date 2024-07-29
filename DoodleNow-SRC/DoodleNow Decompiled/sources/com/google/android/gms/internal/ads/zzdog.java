package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdog {
    private final Executor zza;
    private final zzdob zzb;

    public zzdog(Executor executor, zzdob zzdob) {
        this.zza = executor;
        this.zzb = zzdob;
    }

    public final ListenableFuture zza(JSONObject jSONObject, String str) {
        ListenableFuture listenableFuture;
        JSONArray optJSONArray = jSONObject.optJSONArray("custom_assets");
        if (optJSONArray == null) {
            return zzgee.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                listenableFuture = zzgee.zzh((Object) null);
            } else {
                String optString = optJSONObject.optString("name");
                if (optString == null) {
                    listenableFuture = zzgee.zzh((Object) null);
                } else {
                    String optString2 = optJSONObject.optString("type");
                    if ("string".equals(optString2)) {
                        listenableFuture = zzgee.zzh(new zzdof(optString, optJSONObject.optString("string_value")));
                    } else if ("image".equals(optString2)) {
                        listenableFuture = zzgee.zzm(this.zzb.zze(optJSONObject, "image_value"), new zzdod(optString), this.zza);
                    } else {
                        listenableFuture = zzgee.zzh((Object) null);
                    }
                }
            }
            arrayList.add(listenableFuture);
        }
        return zzgee.zzm(zzgee.zzd(arrayList), zzdoe.zza, this.zza);
    }
}
