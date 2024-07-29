package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@23.1.0 */
final class zzgzs implements zzgzj {
    final zzhaa zza;
    final int zzb;
    final zzhdn zzc;
    final boolean zzd;
    final boolean zze;

    zzgzs(zzhaa zzhaa, int i, zzhdn zzhdn, boolean z, boolean z2) {
        this.zza = zzhaa;
        this.zzb = i;
        this.zzc = zzhdn;
        this.zzd = z;
        this.zze = z2;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return this.zzb - ((zzgzs) obj).zzb;
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhbk zzb(zzhbk zzhbk, zzhbl zzhbl) {
        ((zzgzp) zzhbk).zzbj((zzgzv) zzhbl);
        return zzhbk;
    }

    public final zzhbq zzc(zzhbq zzhbq, zzhbq zzhbq2) {
        throw new UnsupportedOperationException();
    }

    public final zzhdn zzd() {
        return this.zzc;
    }

    public final zzhdo zze() {
        return this.zzc.zza();
    }

    public final boolean zzf() {
        return this.zze;
    }

    public final boolean zzg() {
        return this.zzd;
    }
}
