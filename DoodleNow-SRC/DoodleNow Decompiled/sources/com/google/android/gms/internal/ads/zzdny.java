package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdny implements zzfwf {
    public final /* synthetic */ zzdob zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzdny(zzdob zzdob, JSONObject jSONObject) {
        this.zza = zzdob;
        this.zzb = jSONObject;
    }

    public final Object apply(Object obj) {
        return this.zza.zza(this.zzb, (List) obj);
    }
}
