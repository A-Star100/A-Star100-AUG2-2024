package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgss extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgss zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzgsy zze;
    /* access modifiers changed from: private */
    public zzgyj zzf = zzgyj.zzb;

    static {
        zzgss zzgss = new zzgss();
        zza = zzgss;
        zzgzv.zzca(zzgss.class, zzgss);
    }

    private zzgss() {
    }

    public static zzgsr zzc() {
        return (zzgsr) zza.zzaZ();
    }

    public static zzgss zze() {
        return zza;
    }

    static /* synthetic */ void zzh(zzgss zzgss, zzgsy zzgsy) {
        zzgsy.getClass();
        zzgss.zze = zzgsy;
        zzgss.zzc |= 1;
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
                return new zzgss();
            case 4:
                return new zzgsr((zzgsq) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgss.class) {
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

    public final zzgsy zzf() {
        zzgsy zzgsy = this.zze;
        return zzgsy == null ? zzgsy.zze() : zzgsy;
    }

    public final zzgyj zzg() {
        return this.zzf;
    }
}
