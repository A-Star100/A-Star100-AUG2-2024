package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgsg extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgsg zza;
    private static volatile zzhbt zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public int zzd;
    private zzgsj zze;

    static {
        zzgsg zzgsg = new zzgsg();
        zza = zzgsg;
        zzgzv.zzca(zzgsg.class, zzgsg);
    }

    private zzgsg() {
    }

    public static zzgsf zzc() {
        return (zzgsf) zza.zzaZ();
    }

    public static zzgsg zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgsg) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzh(zzgsg zzgsg, zzgsj zzgsj) {
        zzgsj.getClass();
        zzgsg.zze = zzgsj;
        zzgsg.zzc |= 1;
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
                return new zzgsg();
            case 4:
                return new zzgsf((zzgse) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgsg.class) {
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

    public final zzgsj zzf() {
        zzgsj zzgsj = this.zze;
        return zzgsj == null ? zzgsj.zze() : zzgsj;
    }
}
