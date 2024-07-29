package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgtw extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgtw zza;
    private static volatile zzhbt zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public zzgyj zzd = zzgyj.zzb;

    static {
        zzgtw zzgtw = new zzgtw();
        zza = zzgtw;
        zzgzv.zzca(zzgtw.class, zzgtw);
    }

    private zzgtw() {
    }

    public static zzgtv zzc() {
        return (zzgtv) zza.zzaZ();
    }

    public static zzgtw zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgtw) zzgzv.zzbr(zza, zzgyj, zzgzf);
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgtw();
            case 4:
                return new zzgtv((zzgtu) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgtw.class) {
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
