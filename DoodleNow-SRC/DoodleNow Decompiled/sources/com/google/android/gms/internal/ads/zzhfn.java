package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhfn extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhfn zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzhfm zzd;
    private zzhah zze = zzbK();
    private zzgyj zzf = zzgyj.zzb;
    private zzgyj zzg = zzgyj.zzb;
    private int zzh;
    private byte zzi = 2;

    static {
        zzhfn zzhfn = new zzhfn();
        zza = zzhfn;
        zzgzv.zzca(zzhfn.class, zzhfn);
    }

    private zzhfn() {
    }

    public static zzhfk zzc() {
        return (zzhfk) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhfn zzhfn, zzhfj zzhfj) {
        zzhfj.getClass();
        zzhah zzhah = zzhfn.zze;
        if (!zzhah.zzc()) {
            zzhfn.zze = zzgzv.zzbL(zzhah);
        }
        zzhfn.zze.add(zzhfj);
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        byte b = 1;
        switch (zzgzu.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzi);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzi = b;
                return null;
            case 2:
                return zzbR(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", "zze", zzhfj.class, "zzf", "zzg", "zzh"});
            case 3:
                return new zzhfn();
            case 4:
                return new zzhfk((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhfn.class) {
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
