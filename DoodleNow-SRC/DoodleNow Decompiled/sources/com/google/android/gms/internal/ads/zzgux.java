package com.google.android.gms.internal.ads;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgux extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgux zza;
    private static volatile zzhbt zzb;
    private String zzc = "";
    private String zzd = "";
    private int zze;
    private boolean zzf;
    private String zzg = "";

    static {
        zzgux zzgux = new zzgux();
        zza = zzgux;
        zzgzv.zzca(zzgux.class, zzgux);
    }

    private zzgux() {
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
                return zzbR(zza, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u000b\u0004\u0007\u0005Ȉ", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzgux();
            case 4:
                return new zzguw((zzguv) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgux.class) {
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
