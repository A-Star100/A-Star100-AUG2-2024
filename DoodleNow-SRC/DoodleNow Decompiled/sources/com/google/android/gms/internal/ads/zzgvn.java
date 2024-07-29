package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvn extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvn zza;
    private static volatile zzhbt zzb;
    private String zzc = "";

    static {
        zzgvn zzgvn = new zzgvn();
        zza = zzgvn;
        zzgzv.zzca(zzgvn.class, zzgvn);
    }

    private zzgvn() {
    }

    public static zzgvm zza() {
        return (zzgvm) zza.zzaZ();
    }

    public static zzgvn zzd() {
        return zza;
    }

    public static zzgvn zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgvn) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzg(zzgvn zzgvn, String str) {
        str.getClass();
        zzgvn.zzc = str;
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
                return zzbR(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzc"});
            case 3:
                return new zzgvn();
            case 4:
                return new zzgvm((zzgvl) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvn.class) {
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

    public final String zzf() {
        return this.zzc;
    }
}
