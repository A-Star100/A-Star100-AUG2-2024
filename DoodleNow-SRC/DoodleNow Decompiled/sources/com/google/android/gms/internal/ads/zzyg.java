package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzyg implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzyg(zzam zzam, int i) {
        this.zza = 1 != (zzam.zze & 1) ? false : true;
        this.zzb = zzyx.zzo(i, false);
    }

    /* renamed from: zza */
    public final int compareTo(zzyg zzyg) {
        return zzfzc.zzk().zze(this.zzb, zzyg.zzb).zze(this.zza, zzyg.zza).zza();
    }
}
