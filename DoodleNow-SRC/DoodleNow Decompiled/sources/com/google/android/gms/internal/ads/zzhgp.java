package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhgp extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhgp zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzgyj zzf = zzgyj.zzb;
    private zzgyj zzg = zzgyj.zzb;

    static {
        zzhgp zzhgp = new zzhgp();
        zza = zzhgp;
        zzgzv.zzca(zzhgp.class, zzhgp);
    }

    private zzhgp() {
    }

    public static zzhgl zzc() {
        return (zzhgl) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhgp zzhgp, zzhgo zzhgo) {
        zzhgp.zzd = zzhgo.zza();
        zzhgp.zzc |= 1;
    }

    static /* synthetic */ void zzg(zzhgp zzhgp, String str) {
        zzhgp.zzc |= 2;
        zzhgp.zze = "image/png";
    }

    static /* synthetic */ void zzh(zzhgp zzhgp, zzgyj zzgyj) {
        zzgyj.getClass();
        zzhgp.zzc |= 4;
        zzhgp.zzf = zzgyj;
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
                return zzbR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", zzhgn.zza, "zze", "zzf", "zzg"});
            case 3:
                return new zzhgp();
            case 4:
                return new zzhgl((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhgp.class) {
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
