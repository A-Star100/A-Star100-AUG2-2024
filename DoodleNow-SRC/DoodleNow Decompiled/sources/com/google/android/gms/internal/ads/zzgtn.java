package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgtn extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgtn zza;
    private static volatile zzhbt zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private int zzd;

    static {
        zzgtn zzgtn = new zzgtn();
        zza = zzgtn;
        zzgzv.zzca(zzgtn.class, zzgtn);
    }

    private zzgtn() {
    }

    public static zzgtm zzd() {
        return (zzgtm) zza.zzaZ();
    }

    public static zzgtn zzf(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgtn) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzc() {
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgtn();
            case 4:
                return new zzgtm((zzgtl) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgtn.class) {
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
}
