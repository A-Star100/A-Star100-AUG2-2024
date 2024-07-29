package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzff;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbzt {
    private final Clock zza;
    private final zzbzr zzb;

    zzbzt(Clock clock, zzbzr zzbzr) {
        this.zza = clock;
        this.zzb = zzbzr;
    }

    public static zzbzt zza(Context context) {
        return zzcae.zzd(context).zzb();
    }

    public final void zzb(int i, long j) {
        this.zzb.zza(i, j);
    }

    public final void zzc(zzff zzff) {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }

    public final void zzd() {
        this.zzb.zza(-1, this.zza.currentTimeMillis());
    }
}
