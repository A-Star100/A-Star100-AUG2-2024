package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzauh extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzauh zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzgyj zzd = zzgyj.zzb;
    private zzgyj zze;
    private zzgyj zzf;
    private zzgyj zzg;

    static {
        zzauh zzauh = new zzauh();
        zza = zzauh;
        zzgzv.zzca(zzauh.class, zzauh);
    }

    private zzauh() {
        zzgyj zzgyj = zzgyj.zzb;
        this.zze = zzgyj;
        this.zzf = zzgyj;
        this.zzg = zzgyj;
    }

    public static zzaug zza() {
        return (zzaug) zza.zzaZ();
    }

    public static zzauh zzd(byte[] bArr, zzgzf zzgzf) throws zzhak {
        return (zzauh) zzgzv.zzbx(zza, bArr, zzgzf);
    }

    static /* synthetic */ void zzi(zzauh zzauh, zzgyj zzgyj) {
        zzauh.zzc |= 1;
        zzauh.zzd = zzgyj;
    }

    static /* synthetic */ void zzj(zzauh zzauh, zzgyj zzgyj) {
        zzauh.zzc |= 2;
        zzauh.zze = zzgyj;
    }

    static /* synthetic */ void zzk(zzauh zzauh, zzgyj zzgyj) {
        zzauh.zzc |= 4;
        zzauh.zzf = zzgyj;
    }

    static /* synthetic */ void zzl(zzauh zzauh, zzgyj zzgyj) {
        zzauh.zzc |= 8;
        zzauh.zzg = zzgyj;
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
                return zzbR(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzauh();
            case 4:
                return new zzaug((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzauh.class) {
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

    public final zzgyj zze() {
        return this.zzd;
    }

    public final zzgyj zzf() {
        return this.zze;
    }

    public final zzgyj zzg() {
        return this.zzg;
    }

    public final zzgyj zzh() {
        return this.zzf;
    }
}
