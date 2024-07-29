package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzcll implements zzdvj {
    private final Long zza;
    private final String zzb;
    private final zzckh zzc;
    private final zzclp zzd;
    private final zzcll zze = this;

    /* synthetic */ zzcll(zzckh zzckh, zzclp zzclp, Long l, String str, zzclk zzclk) {
        this.zzc = zzckh;
        this.zzd = zzclp;
        this.zza = l;
        this.zzb = str;
    }

    public final zzdvt zza() {
        zzclp zzclp = this.zzd;
        return zzdvu.zza(this.zza.longValue(), zzclp.zza, zzdvn.zzc(zzclp.zzb), this.zzc, this.zzb);
    }

    public final zzdvx zzb() {
        zzclp zzclp = this.zzd;
        return zzdvy.zza(this.zza.longValue(), zzclp.zza, zzdvn.zzc(zzclp.zzb), this.zzc, this.zzb);
    }
}
