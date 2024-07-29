package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgwb extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgwb zza;
    private static volatile zzhbt zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public zzgyj zzd = zzgyj.zzb;

    static {
        zzgwb zzgwb = new zzgwb();
        zza = zzgwb;
        zzgzv.zzca(zzgwb.class, zzgwb);
    }

    private zzgwb() {
    }

    public static zzgwa zzc() {
        return (zzgwa) zza.zzaZ();
    }

    public static zzgwb zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgwb) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzg() {
        return zza.zzbM();
    }

    public final int zza() {
        return this.zzc;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgwb();
            case 4:
                return new zzgwa((zzgvz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgwb.class) {
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

    public final zzgyj zzf() {
        return this.zzd;
    }
}
