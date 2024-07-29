package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgsd extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgsd zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    /* access modifiers changed from: private */
    public zzgyj zze = zzgyj.zzb;
    private zzgsj zzf;

    static {
        zzgsd zzgsd = new zzgsd();
        zza = zzgsd;
        zzgzv.zzca(zzgsd.class, zzgsd);
    }

    private zzgsd() {
    }

    public static zzgsc zzc() {
        return (zzgsc) zza.zzaZ();
    }

    public static zzgsd zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgsd) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzh() {
        return zza.zzbM();
    }

    static /* synthetic */ void zzj(zzgsd zzgsd, zzgsj zzgsj) {
        zzgsj.getClass();
        zzgsd.zzf = zzgsj;
        zzgsd.zzc |= 1;
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
                return zzbR(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgsd();
            case 4:
                return new zzgsc((zzgsb) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgsd.class) {
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

    public final zzgsj zzf() {
        zzgsj zzgsj = this.zzf;
        return zzgsj == null ? zzgsj.zze() : zzgsj;
    }

    public final zzgyj zzg() {
        return this.zze;
    }
}
