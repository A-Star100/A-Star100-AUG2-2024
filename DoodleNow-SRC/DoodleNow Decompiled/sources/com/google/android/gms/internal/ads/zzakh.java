package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzakh implements zzaef {
    final /* synthetic */ zzaki zza;

    /* synthetic */ zzakh(zzaki zzaki, zzakg zzakg) {
        this.zza = zzaki;
    }

    public final long zza() {
        zzaki zzaki = this.zza;
        return zzaki.zzd.zzf(zzaki.zzf);
    }

    public final zzaed zzg(long j) {
        zzaki zzaki = this.zza;
        long zzg = zzaki.zzd.zzg(j);
        long zzb = zzaki.zzb;
        BigInteger valueOf = BigInteger.valueOf(zzg);
        zzaki zzaki2 = this.zza;
        long longValue = zzb + valueOf.multiply(BigInteger.valueOf(zzaki2.zzc - zzaki2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzaki zzaki3 = this.zza;
        zzaeg zzaeg = new zzaeg(j, Math.max(zzaki3.zzb, Math.min(longValue - 30000, zzaki3.zzc - 1)));
        return new zzaed(zzaeg, zzaeg);
    }

    public final boolean zzh() {
        return true;
    }
}
