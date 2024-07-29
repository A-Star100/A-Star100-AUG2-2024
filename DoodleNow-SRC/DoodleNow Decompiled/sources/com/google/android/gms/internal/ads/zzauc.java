package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzauc extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzauc zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;

    static {
        zzauc zzauc = new zzauc();
        zza = zzauc;
        zzgzv.zzca(zzauc.class, zzauc);
    }

    private zzauc() {
    }

    public static zzaub zza() {
        return (zzaub) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzauc zzauc, long j) {
        zzauc.zzc |= 1;
        zzauc.zzd = j;
    }

    static /* synthetic */ void zze(zzauc zzauc, long j) {
        zzauc.zzc |= 4;
        zzauc.zzf = j;
    }

    static /* synthetic */ void zzf(zzauc zzauc, long j) {
        zzauc.zzc |= 8;
        zzauc.zzg = j;
    }

    static /* synthetic */ void zzg(zzauc zzauc, long j) {
        zzauc.zzc |= 16;
        zzauc.zzh = j;
    }

    static /* synthetic */ void zzh(zzauc zzauc, long j) {
        zzauc.zzc |= 32;
        zzauc.zzi = j;
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
                return zzbR(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
            case 3:
                return new zzauc();
            case 4:
                return new zzaub((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzauc.class) {
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
