package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzebq implements zzfjq {
    public final /* synthetic */ JSONObject zza;
    public final /* synthetic */ zzbxg zzb;

    public /* synthetic */ zzebq(JSONObject jSONObject, zzbxg zzbxg) {
        this.zza = jSONObject;
        this.zzb = zzbxg;
    }

    public final Object zza(Object obj) {
        return new zzect(zzedh.zza(new InputStreamReader((InputStream) obj)), this.zza, this.zzb);
    }
}
