package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzatn extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzatn zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private long zzd = -1;
    private int zze = 1000;
    private int zzf = 1000;

    static {
        zzatn zzatn = new zzatn();
        zza = zzatn;
        zzgzv.zzca(zzatn.class, zzatn);
    }

    private zzatn() {
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzc", "zzd", "zze", zzaum.zza, "zzf", zzaum.zza});
            case 3:
                return new zzatn();
            case 4:
                return new zzatm((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzatn.class) {
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
