package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfqu extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzfqu zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private zzfqo zzg;

    static {
        zzfqu zzfqu = new zzfqu();
        zza = zzfqu;
        zzgzv.zzca(zzfqu.class, zzfqu);
    }

    private zzfqu() {
    }

    public static zzfqq zza() {
        return (zzfqq) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzfqu zzfqu, zzfqt zzfqt) {
        zzfqu.zzd = zzfqt.zza();
        zzfqu.zzc |= 1;
    }

    static /* synthetic */ void zze(zzfqu zzfqu, String str) {
        str.getClass();
        zzfqu.zzc |= 2;
        zzfqu.zze = str;
    }

    static /* synthetic */ void zzf(zzfqu zzfqu, zzfqo zzfqo) {
        zzfqo.getClass();
        zzfqu.zzg = zzfqo;
        zzfqu.zzc |= 8;
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
                return zzbR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzc", "zzd", zzfqs.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzfqu();
            case 4:
                return new zzfqq((zzfqp) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzfqu.class) {
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
