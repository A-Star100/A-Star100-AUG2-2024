package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaua extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzaua zza;
    private static volatile zzhbt zzb;
    private long zzA = -1;
    private long zzB = -1;
    private int zzc;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private long zzh = -1;
    private long zzi = -1;
    private int zzj = 1000;
    private long zzk = -1;
    private long zzl = -1;
    private long zzm = -1;
    private int zzn = 1000;
    private long zzo = -1;
    private long zzp = -1;
    private long zzu = -1;
    private long zzv = -1;
    private long zzw;
    private long zzx;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzaua zzaua = new zzaua();
        zza = zzaua;
        zzgzv.zzca(zzaua.class, zzaua);
    }

    private zzaua() {
    }

    public static zzatz zza() {
        return (zzatz) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzaua zzaua, long j) {
        zzaua.zzc |= 1;
        zzaua.zzd = j;
    }

    static /* synthetic */ void zze(zzaua zzaua, long j) {
        zzaua.zzc |= 2;
        zzaua.zze = j;
    }

    static /* synthetic */ void zzf(zzaua zzaua, long j) {
        zzaua.zzc |= 4;
        zzaua.zzf = j;
    }

    static /* synthetic */ void zzg(zzaua zzaua, long j) {
        zzaua.zzc |= 8;
        zzaua.zzg = j;
    }

    static /* synthetic */ void zzh(zzaua zzaua) {
        zzaua.zzc &= -9;
        zzaua.zzg = -1;
    }

    static /* synthetic */ void zzi(zzaua zzaua, long j) {
        zzaua.zzc |= 16;
        zzaua.zzh = j;
    }

    static /* synthetic */ void zzj(zzaua zzaua, long j) {
        zzaua.zzc |= 32;
        zzaua.zzi = j;
    }

    static /* synthetic */ void zzk(zzaua zzaua, zzaun zzaun) {
        zzaua.zzj = zzaun.zza();
        zzaua.zzc |= 64;
    }

    static /* synthetic */ void zzl(zzaua zzaua, long j) {
        zzaua.zzc |= 128;
        zzaua.zzk = j;
    }

    static /* synthetic */ void zzm(zzaua zzaua, long j) {
        zzaua.zzc |= 256;
        zzaua.zzl = j;
    }

    static /* synthetic */ void zzn(zzaua zzaua, long j) {
        zzaua.zzc |= 512;
        zzaua.zzm = j;
    }

    static /* synthetic */ void zzo(zzaua zzaua, zzaun zzaun) {
        zzaua.zzn = zzaun.zza();
        zzaua.zzc |= 1024;
    }

    static /* synthetic */ void zzp(zzaua zzaua, long j) {
        zzaua.zzc |= 2048;
        zzaua.zzo = j;
    }

    static /* synthetic */ void zzq(zzaua zzaua, long j) {
        zzaua.zzc |= 4096;
        zzaua.zzp = j;
    }

    static /* synthetic */ void zzr(zzaua zzaua, long j) {
        zzaua.zzc |= 8192;
        zzaua.zzu = j;
    }

    static /* synthetic */ void zzs(zzaua zzaua, long j) {
        zzaua.zzc |= 16384;
        zzaua.zzv = j;
    }

    static /* synthetic */ void zzt(zzaua zzaua, long j) {
        zzaua.zzc |= 32768;
        zzaua.zzw = j;
    }

    static /* synthetic */ void zzu(zzaua zzaua, long j) {
        zzaua.zzc |= 65536;
        zzaua.zzx = j;
    }

    static /* synthetic */ void zzv(zzaua zzaua, long j) {
        zzaua.zzc |= 131072;
        zzaua.zzy = j;
    }

    static /* synthetic */ void zzw(zzaua zzaua, long j) {
        zzaua.zzc |= 262144;
        zzaua.zzz = j;
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
                return zzbR(zza, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzaum.zza, "zzk", "zzl", "zzm", "zzn", zzaum.zza, "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB"});
            case 3:
                return new zzaua();
            case 4:
                return new zzatz((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzaua.class) {
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
