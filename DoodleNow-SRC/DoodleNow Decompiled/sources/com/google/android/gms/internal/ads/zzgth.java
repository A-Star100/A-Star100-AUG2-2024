package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgth extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgth zza;
    private static volatile zzhbt zzb;
    /* access modifiers changed from: private */
    public int zzc;

    static {
        zzgth zzgth = new zzgth();
        zza = zzgth;
        zzgzv.zzca(zzgth.class, zzgth);
    }

    private zzgth() {
    }

    public static zzgtg zzc() {
        return (zzgtg) zza.zzaZ();
    }

    public static zzgth zze() {
        return zza;
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
                return new zzgth();
            case 4:
                return new zzgtg((zzgtf) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgth.class) {
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
