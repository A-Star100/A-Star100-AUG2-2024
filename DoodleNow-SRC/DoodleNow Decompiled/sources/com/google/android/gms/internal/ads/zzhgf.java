package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhgf extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhgf zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";
    private long zze;

    static {
        zzhgf zzhgf = new zzhgf();
        zza = zzhgf;
        zzgzv.zzca(zzhgf.class, zzhgf);
    }

    private zzhgf() {
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
                return zzbR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzhgf();
            case 4:
                return new zzhge((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhgf.class) {
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
