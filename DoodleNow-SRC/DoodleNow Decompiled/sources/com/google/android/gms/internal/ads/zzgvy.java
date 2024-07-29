package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvy extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvy zza;
    private static volatile zzhbt zzb;
    private String zzc = "";
    private zzhah zzd = zzbK();

    static {
        zzgvy zzgvy = new zzgvy();
        zza = zzgvy;
        zzgzv.zzca(zzgvy.class, zzgvy);
    }

    private zzgvy() {
    }

    public static zzgvy zzc() {
        return zza;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzc", "zzd", zzgux.class});
            case 3:
                return new zzgvy();
            case 4:
                return new zzgvx((zzgvw) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvy.class) {
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
