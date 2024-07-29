package com.google.android.gms.internal.ads;

import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzdqj implements zzblp {
    private final zzczx zza;
    private final zzbyc zzb;
    private final String zzc;
    private final String zzd;

    public zzdqj(zzczx zzczx, zzffn zzffn) {
        this.zza = zzczx;
        this.zzb = zzffn.zzm;
        this.zzc = zzffn.zzk;
        this.zzd = zzffn.zzl;
    }

    @ParametersAreNonnullByDefault
    public final void zza(zzbyc zzbyc) {
        int i;
        String str;
        zzbyc zzbyc2 = this.zzb;
        if (zzbyc2 != null) {
            zzbyc = zzbyc2;
        }
        if (zzbyc != null) {
            str = zzbyc.zza;
            i = zzbyc.zzb;
        } else {
            i = 1;
            str = "";
        }
        this.zza.zzd(new zzbxn(str, i), this.zzc, this.zzd);
    }

    public final void zzb() {
        this.zza.zze();
    }

    public final void zzc() {
        this.zza.zzf();
    }
}
