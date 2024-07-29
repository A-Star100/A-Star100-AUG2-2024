package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmm extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzfmm zza;
    private static volatile zzhbt zzb;
    private zzhah zzc = zzbK();

    static {
        zzfmm zzfmm = new zzfmm();
        zza = zzfmm;
        zzgzv.zzca(zzfmm.class, zzfmm);
    }

    private zzfmm() {
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
                return zzbR(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfmj.class});
            case 3:
                return new zzfmm();
            case 4:
                return new zzfml((zzfmk) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzfmm.class) {
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
