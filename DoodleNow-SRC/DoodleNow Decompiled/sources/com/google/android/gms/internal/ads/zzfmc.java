package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfmc extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzfmc zza;
    private static volatile zzhbt zzb;
    /* access modifiers changed from: private */
    public zzhah zzc = zzbK();

    static {
        zzfmc zzfmc = new zzfmc();
        zza = zzfmc;
        zzgzv.zzca(zzfmc.class, zzfmc);
    }

    private zzfmc() {
    }

    public static zzflz zzc() {
        return (zzflz) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzfmc zzfmc, zzfmb zzfmb) {
        zzfmb.getClass();
        zzhah zzhah = zzfmc.zzc;
        if (!zzhah.zzc()) {
            zzfmc.zzc = zzgzv.zzbL(zzhah);
        }
        zzfmc.zzc.add(zzfmb);
    }

    public final int zza() {
        return this.zzc.size();
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
                return zzbR(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzfmb.class});
            case 3:
                return new zzfmc();
            case 4:
                return new zzflz((zzfly) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzfmc.class) {
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
