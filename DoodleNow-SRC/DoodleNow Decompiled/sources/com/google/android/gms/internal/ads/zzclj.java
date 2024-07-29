package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzclj implements zzdvi {
    private final zzckh zza;
    private final zzclp zzb;
    private Long zzc;
    private String zzd;

    /* synthetic */ zzclj(zzckh zzckh, zzclp zzclp, zzcli zzcli) {
        this.zza = zzckh;
        this.zzb = zzclp;
    }

    public final /* synthetic */ zzdvi zza(String str) {
        str.getClass();
        this.zzd = str;
        return this;
    }

    public final /* bridge */ /* synthetic */ zzdvi zzb(long j) {
        this.zzc = Long.valueOf(j);
        return this;
    }

    public final zzdvj zzc() {
        zzhjd.zzc(this.zzc, Long.class);
        zzhjd.zzc(this.zzd, String.class);
        return new zzcll(this.zza, this.zzb, this.zzc, this.zzd, (zzclk) null);
    }
}
