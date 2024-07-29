package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgsm extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgsm zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzgss zze;
    private zzgue zzf;

    static {
        zzgsm zzgsm = new zzgsm();
        zza = zzgsm;
        zzgzv.zzca(zzgsm.class, zzgsm);
    }

    private zzgsm() {
    }

    public static zzgsl zzc() {
        return (zzgsl) zza.zzaZ();
    }

    public static zzgsm zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgsm) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzh() {
        return zza.zzbM();
    }

    static /* synthetic */ void zzi(zzgsm zzgsm, zzgss zzgss) {
        zzgss.getClass();
        zzgsm.zze = zzgss;
        zzgsm.zzc |= 1;
    }

    static /* synthetic */ void zzj(zzgsm zzgsm, zzgue zzgue) {
        zzgue.getClass();
        zzgsm.zzf = zzgue;
        zzgsm.zzc |= 2;
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
                return zzbR(zza, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgsm();
            case 4:
                return new zzgsl((zzgsk) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgsm.class) {
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

    public final zzgss zzf() {
        zzgss zzgss = this.zze;
        return zzgss == null ? zzgss.zze() : zzgss;
    }

    public final zzgue zzg() {
        zzgue zzgue = this.zzf;
        return zzgue == null ? zzgue.zze() : zzgue;
    }
}
