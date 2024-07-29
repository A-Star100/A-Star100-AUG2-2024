package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhdw extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhdw zza;
    private static volatile zzhbt zzb;
    private zzhah zzc = zzbK();

    static {
        zzhdw zzhdw = new zzhdw();
        zza = zzhdw;
        zzgzv.zzca(zzhdw.class, zzhdw);
    }

    private zzhdw() {
    }

    public static zzhdv zzc() {
        return (zzhdv) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhdw zzhdw, zzhdu zzhdu) {
        zzhdu.getClass();
        zzhah zzhah = zzhdw.zzc;
        if (!zzhah.zzc()) {
            zzhdw.zzc = zzgzv.zzbL(zzhah);
        }
        zzhdw.zzc.add(zzhdu);
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
                return zzbR(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzhdu.class});
            case 3:
                return new zzhdw();
            case 4:
                return new zzhdv((zzhds) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhdw.class) {
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
