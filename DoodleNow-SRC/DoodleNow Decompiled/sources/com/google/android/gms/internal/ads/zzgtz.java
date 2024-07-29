package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgtz extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgtz zza;
    private static volatile zzhbt zzb;

    static {
        zzgtz zzgtz = new zzgtz();
        zza = zzgtz;
        zzgzv.zzca(zzgtz.class, zzgtz);
    }

    private zzgtz() {
    }

    public static zzgtz zzc() {
        return zza;
    }

    public static zzgtz zzd(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgtz) zzgzv.zzbr(zza, zzgyj, zzgzf);
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
                return zzbR(zza, "\u0000\u0000", (Object[]) null);
            case 3:
                return new zzgtz();
            case 4:
                return new zzgty((zzgtx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgtz.class) {
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
