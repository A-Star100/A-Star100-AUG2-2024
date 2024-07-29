package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcqq implements Runnable {
    public final /* synthetic */ zzcqr zza;
    public final /* synthetic */ JSONObject zzb;

    public /* synthetic */ zzcqq(zzcqr zzcqr, JSONObject jSONObject) {
        this.zza = zzcqr;
        this.zzb = jSONObject;
    }

    public final void run() {
        this.zza.zzd(this.zzb);
    }
}
