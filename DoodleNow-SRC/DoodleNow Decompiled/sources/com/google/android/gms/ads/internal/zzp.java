package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzawn;
import com.google.android.gms.internal.ads.zzawo;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzp implements Callable {
    final /* synthetic */ zzt zza;

    zzp(zzt zzt) {
        this.zza = zzt;
    }

    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzt zzt = this.zza;
        return new zzawo(zzawn.zzt(zzt.zza.afmaVersion, zzt.zzd, false));
    }
}
