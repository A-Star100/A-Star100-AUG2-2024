package com.google.android.gms.internal.ads;

import androidx.collection.ArrayMap;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdmv implements Runnable {
    public final /* synthetic */ zzcgm zza;

    public /* synthetic */ zzdmv(zzcgm zzcgm) {
        this.zza = zzcgm;
    }

    public final void run() {
        this.zza.zzd("onSdkImpression", new ArrayMap());
    }
}
