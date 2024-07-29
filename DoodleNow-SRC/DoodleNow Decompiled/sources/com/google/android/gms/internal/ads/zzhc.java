package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhc implements zzgu {
    private final Context zza;
    private final zzgu zzb;

    public zzhc(Context context) {
        zzhe zzhe = new zzhe();
        this.zza = context.getApplicationContext();
        this.zzb = zzhe;
    }

    public final /* bridge */ /* synthetic */ zzgv zza() {
        return new zzhd(this.zza, ((zzhe) this.zzb).zza());
    }
}
