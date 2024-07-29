package com.google.android.gms.internal.ads;

import androidx.work.WorkRequest;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzery implements zzhiv {
    private final zzhjm zza;
    private final zzhjm zzb;

    public zzery(zzhjm zzhjm, zzhjm zzhjm2) {
        this.zza = zzhjm;
        this.zzb = zzhjm2;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzerp(((zzerk) this.zza).zzb(), WorkRequest.MIN_BACKOFF_MILLIS, (Clock) this.zzb.zzb());
    }
}
