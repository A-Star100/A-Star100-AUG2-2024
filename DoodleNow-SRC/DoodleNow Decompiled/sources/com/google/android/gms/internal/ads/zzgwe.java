package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgwe extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgwe zza;
    private static volatile zzhbt zzb;
    private int zzc;

    static {
        zzgwe zzgwe = new zzgwe();
        zza = zzgwe;
        zzgzv.zzca(zzgwe.class, zzgwe);
    }

    private zzgwe() {
    }

    public static zzgwe zzd() {
        return zza;
    }

    public static zzgwe zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgwe) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public final int zza() {
        return this.zzc;
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
                return zzbR(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzc"});
            case 3:
                return new zzgwe();
            case 4:
                return new zzgwd((zzgwc) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgwe.class) {
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
