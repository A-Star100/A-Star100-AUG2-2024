package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhfj extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhfj zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzgyj zzd = zzgyj.zzb;
    private zzgyj zze = zzgyj.zzb;
    private byte zzf = 2;

    static {
        zzhfj zzhfj = new zzhfj();
        zza = zzhfj;
        zzgzv.zzca(zzhfj.class, zzhfj);
    }

    private zzhfj() {
    }

    public static zzhfi zzc() {
        return (zzhfi) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhfj zzhfj, zzgyj zzgyj) {
        zzhfj.zzc |= 1;
        zzhfj.zzd = zzgyj;
    }

    static /* synthetic */ void zzg(zzhfj zzhfj, zzgyj zzgyj) {
        zzhfj.zzc |= 2;
        zzhfj.zze = zzgyj;
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        byte b = 1;
        switch (zzgzu.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzf);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzf = b;
                return null;
            case 2:
                return zzbR(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzhfj();
            case 4:
                return new zzhfi((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhfj.class) {
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
