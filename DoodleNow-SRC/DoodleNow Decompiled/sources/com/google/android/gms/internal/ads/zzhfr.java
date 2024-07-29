package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhfr extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhfr zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzhfq zzd;
    private zzhah zze = zzbK();
    private zzgyj zzf = zzgyj.zzb;
    private zzgyj zzg;
    private int zzh;
    private zzgyj zzi;
    private byte zzj = 2;

    static {
        zzhfr zzhfr = new zzhfr();
        zza = zzhfr;
        zzgzv.zzca(zzhfr.class, zzhfr);
    }

    private zzhfr() {
        zzgyj zzgyj = zzgyj.zzb;
        this.zzg = zzgyj;
        this.zzi = zzgyj;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        byte b = 1;
        switch (zzgzu.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzj);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzj = b;
                return null;
            case 2:
                return zzbR(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzc", "zzd", "zze", zzhfj.class, "zzf", "zzg", "zzh", "zzi"});
            case 3:
                return new zzhfr();
            case 4:
                return new zzhfo((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhfr.class) {
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
