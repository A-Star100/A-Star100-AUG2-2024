package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhfy extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhfy zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzhfx zze;
    private zzhfx zzf;

    static {
        zzhfy zzhfy = new zzhfy();
        zza = zzhfy;
        zzgzv.zzca(zzhfy.class, zzhfy);
    }

    private zzhfy() {
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zzc", "zzd", zzhfu.zza, "zze", "zzf"});
            case 3:
                return new zzhfy();
            case 4:
                return new zzhfs((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhfy.class) {
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
