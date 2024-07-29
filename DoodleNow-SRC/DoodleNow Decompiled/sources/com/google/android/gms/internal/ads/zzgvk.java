package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvk extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvk zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzgvn zze;

    static {
        zzgvk zzgvk = new zzgvk();
        zza = zzgvk;
        zzgzv.zzca(zzgvk.class, zzgvk);
    }

    private zzgvk() {
    }

    public static zzgvj zzc() {
        return (zzgvj) zza.zzaZ();
    }

    public static zzgvk zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgvk) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzg() {
        return zza.zzbM();
    }

    static /* synthetic */ void zzh(zzgvk zzgvk, zzgvn zzgvn) {
        zzgvn.getClass();
        zzgvk.zze = zzgvn;
        zzgvk.zzc |= 1;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgvk();
            case 4:
                return new zzgvj((zzgvi) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvk.class) {
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

    public final zzgvn zzf() {
        zzgvn zzgvn = this.zze;
        return zzgvn == null ? zzgvn.zzd() : zzgvn;
    }
}
