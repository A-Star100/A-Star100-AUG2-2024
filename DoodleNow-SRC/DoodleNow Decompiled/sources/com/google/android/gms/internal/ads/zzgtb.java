package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgtb extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgtb zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzgth zze;
    /* access modifiers changed from: private */
    public zzgyj zzf = zzgyj.zzb;

    static {
        zzgtb zzgtb = new zzgtb();
        zza = zzgtb;
        zzgzv.zzca(zzgtb.class, zzgtb);
    }

    private zzgtb() {
    }

    public static zzgta zzc() {
        return (zzgta) zza.zzaZ();
    }

    public static zzgtb zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgtb) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzh() {
        return zza.zzbM();
    }

    static /* synthetic */ void zzi(zzgtb zzgtb, zzgth zzgth) {
        zzgth.getClass();
        zzgtb.zze = zzgth;
        zzgtb.zzc |= 1;
    }

    public final int zza() {
        return this.zzd;
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
                return zzbR(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgtb();
            case 4:
                return new zzgta((zzgsz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgtb.class) {
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

    public final zzgth zzf() {
        zzgth zzgth = this.zze;
        return zzgth == null ? zzgth.zze() : zzgth;
    }

    public final zzgyj zzg() {
        return this.zzf;
    }
}
