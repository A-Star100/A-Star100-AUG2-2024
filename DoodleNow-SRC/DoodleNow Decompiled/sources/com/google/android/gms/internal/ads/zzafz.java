package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzafz extends zzadt {
    private final long zza;

    public zzafz(zzadg zzadg, long j) {
        super(zzadg);
        zzek.zzd(zzadg.zzf() >= j);
        this.zza = j;
    }

    public final long zzd() {
        return super.zzd() - this.zza;
    }

    public final long zze() {
        return super.zze() - this.zza;
    }

    public final long zzf() {
        return super.zzf() - this.zza;
    }
}
