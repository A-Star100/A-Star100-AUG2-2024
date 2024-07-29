package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcqf implements Runnable {
    public final /* synthetic */ zzcgm zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcqf(zzcgm zzcgm, JSONObject jSONObject) {
        this.zza = zzcgm;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzl("AFMA_updateActiveView", this.zzb);
    }
}
