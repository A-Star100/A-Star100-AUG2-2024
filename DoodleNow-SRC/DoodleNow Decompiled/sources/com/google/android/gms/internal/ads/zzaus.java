package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaus extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzaus zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private long zzd;
    private String zze = "";
    private zzgyj zzf = zzgyj.zzb;

    static {
        zzaus zzaus = new zzaus();
        zza = zzaus;
        zzgzv.zzca(zzaus.class, zzaus);
    }

    private zzaus() {
    }

    public static zzaus zzd() {
        return zza;
    }

    public final long zza() {
        return this.zzd;
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
                return zzbR(zza, "\u0001\u0003\u0000\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0003ဈ\u0001\u0004ည\u0002", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzaus();
            case 4:
                return new zzaur((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzaus.class) {
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

    public final boolean zze() {
        return (this.zzc & 1) != 0;
    }
}
