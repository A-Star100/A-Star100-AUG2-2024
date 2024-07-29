package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvg extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvg zza;
    private static volatile zzhbt zzb;
    private String zzc = "";
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;

    static {
        zzgvg zzgvg = new zzgvg();
        zza = zzgvg;
        zzgzv.zzca(zzgvg.class, zzgvg);
    }

    private zzgvg() {
    }

    public static zzgvf zza() {
        return (zzgvf) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzgvg zzgvg, String str) {
        str.getClass();
        zzgvg.zzc = str;
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
                return zzbR(zza, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf"});
            case 3:
                return new zzgvg();
            case 4:
                return new zzgvf((zzgvd) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvg.class) {
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
