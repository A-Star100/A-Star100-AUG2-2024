package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvt extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvt zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";
    private zzguu zze;

    static {
        zzgvt zzgvt = new zzgvt();
        zza = zzgvt;
        zzgzv.zzca(zzgvt.class, zzgvt);
    }

    private zzgvt() {
    }

    public static zzgvs zzc() {
        return (zzgvs) zza.zzaZ();
    }

    public static zzgvt zze() {
        return zza;
    }

    public static zzgvt zzf(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgvt) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzh(zzgvt zzgvt, String str) {
        str.getClass();
        zzgvt.zzd = str;
    }

    static /* synthetic */ void zzi(zzgvt zzgvt, zzguu zzguu) {
        zzguu.getClass();
        zzgvt.zze = zzguu;
        zzgvt.zzc |= 1;
    }

    public final zzguu zza() {
        zzguu zzguu = this.zze;
        return zzguu == null ? zzguu.zze() : zzguu;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgvt();
            case 4:
                return new zzgvs((zzgvr) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvt.class) {
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

    public final String zzg() {
        return this.zzd;
    }
}
