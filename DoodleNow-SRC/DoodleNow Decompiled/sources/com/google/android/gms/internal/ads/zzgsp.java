package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgsp extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgsp zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzgsv zzd;
    private zzguh zze;

    static {
        zzgsp zzgsp = new zzgsp();
        zza = zzgsp;
        zzgzv.zzca(zzgsp.class, zzgsp);
    }

    private zzgsp() {
    }

    public static zzgso zza() {
        return (zzgso) zza.zzaZ();
    }

    public static zzgsp zzd(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgsp) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzg(zzgsp zzgsp, zzgsv zzgsv) {
        zzgsv.getClass();
        zzgsp.zzd = zzgsv;
        zzgsp.zzc |= 1;
    }

    static /* synthetic */ void zzh(zzgsp zzgsp, zzguh zzguh) {
        zzguh.getClass();
        zzgsp.zze = zzguh;
        zzgsp.zzc |= 2;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgsp();
            case 4:
                return new zzgso((zzgsn) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgsp.class) {
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

    public final zzgsv zze() {
        zzgsv zzgsv = this.zzd;
        return zzgsv == null ? zzgsv.zze() : zzgsv;
    }

    public final zzguh zzf() {
        zzguh zzguh = this.zze;
        return zzguh == null ? zzguh.zzf() : zzguh;
    }
}
