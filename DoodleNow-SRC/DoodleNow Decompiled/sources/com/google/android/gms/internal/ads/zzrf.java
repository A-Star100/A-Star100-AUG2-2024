package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzrf {
    private final zzdt[] zza;
    private final zzrz zzb;
    private final zzdw zzc;

    public zzrf(zzdt... zzdtArr) {
        zzrz zzrz = new zzrz();
        zzdw zzdw = new zzdw();
        zzdt[] zzdtArr2 = new zzdt[2];
        this.zza = zzdtArr2;
        System.arraycopy(zzdtArr, 0, zzdtArr2, 0, 0);
        this.zzb = zzrz;
        this.zzc = zzdw;
        zzdtArr2[0] = zzrz;
        zzdtArr2[1] = zzdw;
    }

    public final long zza(long j) {
        return this.zzc.zzi(j);
    }

    public final long zzb() {
        return this.zzb.zzo();
    }

    public final zzcg zzc(zzcg zzcg) {
        this.zzc.zzk(zzcg.zzc);
        this.zzc.zzj(zzcg.zzd);
        return zzcg;
    }

    public final boolean zzd(boolean z) {
        this.zzb.zzp(z);
        return z;
    }

    public final zzdt[] zze() {
        return this.zza;
    }
}
