package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzcab implements Callable {
    public final /* synthetic */ zzcad zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzcab(zzcad zzcad, Context context) {
        this.zza = zzcad;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zze(this.zzb);
    }
}
