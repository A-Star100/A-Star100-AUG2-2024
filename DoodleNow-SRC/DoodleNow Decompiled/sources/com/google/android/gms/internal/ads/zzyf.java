package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzyf extends zzyt implements Comparable {
    private final int zze;
    private final int zzf = this.zzd.zza();

    public zzyf(int i, zzcz zzcz, int i2, zzyl zzyl, int i3) {
        super(i, zzcz, i2);
        this.zze = zzyx.zzo(i3, zzyl.zzT) ? 1 : 0;
    }

    /* renamed from: zza */
    public final int compareTo(zzyf zzyf) {
        return Integer.compare(this.zzf, zzyf.zzf);
    }

    public final int zzb() {
        return this.zze;
    }

    public final /* bridge */ /* synthetic */ boolean zzc(zzyt zzyt) {
        zzyf zzyf = (zzyf) zzyt;
        return false;
    }
}
