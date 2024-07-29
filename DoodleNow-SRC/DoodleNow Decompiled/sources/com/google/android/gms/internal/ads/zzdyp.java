package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdyp implements Callable {
    public final /* synthetic */ zzawo zza;
    public final /* synthetic */ Context zzb;

    public /* synthetic */ zzdyp(zzawo zzawo, Context context) {
        this.zza = zzawo;
        this.zzb = context;
    }

    public final Object call() {
        return this.zza.zzc().zzg(this.zzb);
    }
}
