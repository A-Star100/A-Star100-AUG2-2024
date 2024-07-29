package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzguh extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzguh zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzguk zzd;
    /* access modifiers changed from: private */
    public int zze;
    private int zzf;

    static {
        zzguh zzguh = new zzguh();
        zza = zzguh;
        zzgzv.zzca(zzguh.class, zzguh);
    }

    private zzguh() {
    }

    public static zzgug zzd() {
        return (zzgug) zza.zzaZ();
    }

    public static zzguh zzf() {
        return zza;
    }

    public static zzguh zzg(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzguh) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzi(zzguh zzguh, zzguk zzguk) {
        zzguk.getClass();
        zzguh.zzd = zzguk;
        zzguh.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzf;
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
                return zzbR(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzguh();
            case 4:
                return new zzgug((zzguf) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzguh.class) {
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

    public final zzguk zzh() {
        zzguk zzguk = this.zzd;
        return zzguk == null ? zzguk.zzf() : zzguk;
    }
}
