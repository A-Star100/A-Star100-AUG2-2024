package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhev extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhev zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";

    static {
        zzhev zzhev = new zzhev();
        zza = zzhev;
        zzgzv.zzca(zzhev.class, zzhev);
    }

    private zzhev() {
    }

    public static zzheu zzc() {
        return (zzheu) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhev zzhev, String str) {
        zzhev.zzc |= 1;
        zzhev.zzd = str;
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
                return zzbR(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzhev();
            case 4:
                return new zzheu((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhev.class) {
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
