package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhfq extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhfq zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzgyj zze = zzgyj.zzb;
    private zzgyj zzf = zzgyj.zzb;

    static {
        zzhfq zzhfq = new zzhfq();
        zza = zzhfq;
        zzgzv.zzca(zzhfq.class, zzhfq);
    }

    private zzhfq() {
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzhfq();
            case 4:
                return new zzhfp((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhfq.class) {
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
