package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcfv implements Runnable {
    public final /* synthetic */ zzcdn zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcfv(zzcdn zzcdn, Map map) {
        this.zza = zzcdn;
        this.zzb = map;
    }

    public final void run() {
        int i = zzcfz.zza;
        this.zza.zzd("onGcacheInfoEvent", this.zzb);
    }
}
