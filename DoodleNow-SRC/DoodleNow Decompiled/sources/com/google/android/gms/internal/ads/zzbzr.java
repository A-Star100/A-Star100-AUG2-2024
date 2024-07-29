package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.util.zzg;
import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzbzr {
    private final Clock zza;
    private final zzg zzb;
    private final zzcad zzc;

    zzbzr(Clock clock, zzg zzg, zzcad zzcad) {
        this.zza = clock;
        this.zzb = zzg;
        this.zzc = zzcad;
    }

    public final void zza(int i, long j) {
        if (!((Boolean) zzba.zzc().zza(zzbdz.zzap)).booleanValue()) {
            if (j - this.zzb.zze() < 0) {
                zze.zza("Receiving npa decision in the past, ignoring.");
                return;
            }
            if (!((Boolean) zzba.zzc().zza(zzbdz.zzaq)).booleanValue()) {
                this.zzb.zzJ(-1);
                this.zzb.zzK(j);
                return;
            }
            this.zzb.zzJ(i);
            this.zzb.zzK(j);
        }
    }
}
