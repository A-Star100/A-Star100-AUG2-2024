package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzazk extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzazk zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzazn zzd;
    private zzgyj zze = zzgyj.zzb;
    private zzgyj zzf = zzgyj.zzb;

    static {
        zzazk zzazk = new zzazk();
        zza = zzazk;
        zzgzv.zzca(zzazk.class, zzazk);
    }

    private zzazk() {
    }

    public static zzazk zzc(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzazk) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public final zzazn zzd() {
        zzazn zzazn = this.zzd;
        return zzazn == null ? zzazn.zzg() : zzazn;
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzazk();
            case 4:
                return new zzazj((zzazi) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzazk.class) {
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

    public final zzgyj zze() {
        return this.zzf;
    }

    public final zzgyj zzf() {
        return this.zze;
    }
}
