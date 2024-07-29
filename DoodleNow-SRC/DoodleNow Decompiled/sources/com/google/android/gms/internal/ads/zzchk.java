package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzchk implements Runnable {
    public final /* synthetic */ zzchm zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzchk(zzchm zzchm, Map map) {
        this.zza = zzchm;
        this.zzb = map;
    }

    public final void run() {
        this.zza.zzr(this.zzb);
    }
}
