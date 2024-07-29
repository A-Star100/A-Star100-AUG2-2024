package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzauw extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzauw zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzhah zzd = zzbK();
    private zzgyj zze = zzgyj.zzb;
    private int zzf = 1;
    private int zzg = 1;

    static {
        zzauw zzauw = new zzauw();
        zza = zzauw;
        zzgzv.zzca(zzauw.class, zzauw);
    }

    private zzauw() {
    }

    public static zzauv zza() {
        return (zzauv) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzauw zzauw, zzgyj zzgyj) {
        zzhah zzhah = zzauw.zzd;
        if (!zzhah.zzc()) {
            zzauw.zzd = zzgzv.zzbL(zzhah);
        }
        zzauw.zzd.add(zzgyj);
    }

    static /* synthetic */ void zze(zzauw zzauw, zzgyj zzgyj) {
        zzauw.zzc |= 1;
        zzauw.zze = zzgyj;
    }

    static /* synthetic */ void zzf(zzauw zzauw, zzauk zzauk) {
        zzauw.zzg = zzauk.zza();
        zzauw.zzc |= 4;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        switch (zzgzu.ordinal()) {
            case 0:
                return (byte) 1;
            case 1:
                return null;
            case 2:
                return zzbR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zzc", "zzd", "zze", "zzf", zzaup.zza, "zzg", zzauj.zza});
            case 3:
                return new zzauw();
            case 4:
                return new zzauv((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzauw.class) {
                        zzhbt = zzb;
                        if (zzhbt == null) {
                            zzhbt = new zzgzq(zza);
                            zzb = zzhbt;
                        }
                    }
                }
                return zzhbt;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
