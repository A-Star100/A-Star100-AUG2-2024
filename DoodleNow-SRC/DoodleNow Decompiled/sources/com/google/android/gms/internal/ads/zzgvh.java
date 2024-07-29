package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvh extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvh zza;
    private static volatile zzhbt zzb;
    /* access modifiers changed from: private */
    public int zzc;
    private zzhah zzd = zzbK();

    static {
        zzgvh zzgvh = new zzgvh();
        zza = zzgvh;
        zzgzv.zzca(zzgvh.class, zzgvh);
    }

    private zzgvh() {
    }

    public static zzgve zza() {
        return (zzgve) zza.zzaZ();
    }

    static /* synthetic */ void zze(zzgvh zzgvh, zzgvg zzgvg) {
        zzgvg.getClass();
        zzhah zzhah = zzgvh.zzd;
        if (!zzhah.zzc()) {
            zzgvh.zzd = zzgzv.zzbL(zzhah);
        }
        zzgvh.zzd.add(zzgvg);
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzc", "zzd", zzgvg.class});
            case 3:
                return new zzgvh();
            case 4:
                return new zzgve((zzgvd) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvh.class) {
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
