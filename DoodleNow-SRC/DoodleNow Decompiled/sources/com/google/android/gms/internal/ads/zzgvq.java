package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvq extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvq zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private zzgvt zze;

    static {
        zzgvq zzgvq = new zzgvq();
        zza = zzgvq;
        zzgzv.zzca(zzgvq.class, zzgvq);
    }

    private zzgvq() {
    }

    public static zzgvp zzc() {
        return (zzgvp) zza.zzaZ();
    }

    public static zzgvq zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgvq) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzg() {
        return zza.zzbM();
    }

    static /* synthetic */ void zzh(zzgvq zzgvq, zzgvt zzgvt) {
        zzgvt.getClass();
        zzgvq.zze = zzgvt;
        zzgvq.zzc |= 1;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgvq();
            case 4:
                return new zzgvp((zzgvo) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvq.class) {
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

    public final zzgvt zzf() {
        zzgvt zzgvt = this.zze;
        return zzgvt == null ? zzgvt.zze() : zzgvt;
    }
}
