package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzatp extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzatp zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private long zzd = -1;

    static {
        zzatp zzatp = new zzatp();
        zza = zzatp;
        zzgzv.zzca(zzatp.class, zzatp);
    }

    private zzatp() {
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
                return zzbR(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဂ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzatp();
            case 4:
                return new zzato((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzatp.class) {
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
