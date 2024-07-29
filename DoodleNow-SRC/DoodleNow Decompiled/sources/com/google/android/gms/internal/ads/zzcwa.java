package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcwa implements zzdeb, zzdae {
    private final Clock zza;
    private final zzcwc zzb;
    private final zzfgi zzc;
    private final String zzd;

    zzcwa(Clock clock, zzcwc zzcwc, zzfgi zzfgi, String str) {
        this.zza = clock;
        this.zzb = zzcwc;
        this.zzc = zzfgi;
        this.zzd = str;
    }

    public final void zza() {
        this.zzb.zze(this.zzd, this.zza.elapsedRealtime());
    }

    public final void zzs() {
        zzfgi zzfgi = this.zzc;
        this.zzb.zzd(zzfgi.zzf, this.zzd, this.zza.elapsedRealtime());
    }
}
