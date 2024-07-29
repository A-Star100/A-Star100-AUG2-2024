package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmb extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzfmb zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzflx zzd;

    static {
        zzfmb zzfmb = new zzfmb();
        zza = zzfmb;
        zzgzv.zzca(zzfmb.class, zzfmb);
    }

    private zzfmb() {
    }

    public static zzfma zza() {
        return (zzfma) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzfmb zzfmb, zzflx zzflx) {
        zzflx.getClass();
        zzfmb.zzd = zzflx;
        zzfmb.zzc |= 1;
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
                return zzbR(zza, "\u0000\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzfmb();
            case 4:
                return new zzfma((zzfly) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzfmb.class) {
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
