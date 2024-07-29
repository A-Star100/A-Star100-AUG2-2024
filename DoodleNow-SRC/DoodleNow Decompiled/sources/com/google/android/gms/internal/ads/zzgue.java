package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgue extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgue zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzguk zze;
    /* access modifiers changed from: private */
    public zzgyj zzf = zzgyj.zzb;

    static {
        zzgue zzgue = new zzgue();
        zza = zzgue;
        zzgzv.zzca(zzgue.class, zzgue);
    }

    private zzgue() {
    }

    public static zzgud zzc() {
        return (zzgud) zza.zzaZ();
    }

    public static zzgue zze() {
        return zza;
    }

    public static zzgue zzf(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgue) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzi() {
        return zza.zzbM();
    }

    static /* synthetic */ void zzj(zzgue zzgue, zzguk zzguk) {
        zzguk.getClass();
        zzgue.zze = zzguk;
        zzgue.zzc |= 1;
    }

    public final int zza() {
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
                return zzbR(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgue();
            case 4:
                return new zzgud((zzguc) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgue.class) {
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

    public final zzguk zzg() {
        zzguk zzguk = this.zze;
        return zzguk == null ? zzguk.zzf() : zzguk;
    }

    public final zzgyj zzh() {
        return this.zzf;
    }
}
