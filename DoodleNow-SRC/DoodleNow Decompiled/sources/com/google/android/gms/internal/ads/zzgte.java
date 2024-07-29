package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgte extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgte zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzgth zzd;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgte zzgte = new zzgte();
        zza = zzgte;
        zzgzv.zzca(zzgte.class, zzgte);
    }

    private zzgte() {
    }

    public static zzgtd zzc() {
        return (zzgtd) zza.zzaZ();
    }

    public static zzgte zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgte) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzg(zzgte zzgte, zzgth zzgth) {
        zzgth.getClass();
        zzgte.zzd = zzgth;
        zzgte.zzc |= 1;
    }

    public final int zza() {
        return this.zze;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgte();
            case 4:
                return new zzgtd((zzgtc) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgte.class) {
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

    public final zzgth zzf() {
        zzgth zzgth = this.zzd;
        return zzgth == null ? zzgth.zze() : zzgth;
    }
}
