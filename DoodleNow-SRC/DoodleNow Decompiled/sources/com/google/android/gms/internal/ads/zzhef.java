package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhef extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhef zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private long zze;
    private zzgyj zzf = zzgyj.zzb;

    static {
        zzhef zzhef = new zzhef();
        zza = zzhef;
        zzgzv.zzca(zzhef.class, zzhef);
    }

    private zzhef() {
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zzc", "zzd", zzhed.zza, "zze", "zzf"});
            case 3:
                return new zzhef();
            case 4:
                return new zzheb((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhef.class) {
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
