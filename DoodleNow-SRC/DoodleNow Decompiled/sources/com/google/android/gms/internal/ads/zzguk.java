package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzguk extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzguk zza;
    private static volatile zzhbt zzb;
    /* access modifiers changed from: private */
    public int zzc;
    /* access modifiers changed from: private */
    public int zzd;

    static {
        zzguk zzguk = new zzguk();
        zza = zzguk;
        zzgzv.zzca(zzguk.class, zzguk);
    }

    private zzguk() {
    }

    public static zzguj zzd() {
        return (zzguj) zza.zzaZ();
    }

    public static zzguk zzf() {
        return zza;
    }

    public final int zza() {
        return this.zzd;
    }

    public final zzgub zzc() {
        zzgub zzb2 = zzgub.zzb(this.zzc);
        return zzb2 == null ? zzgub.UNRECOGNIZED : zzb2;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzguk();
            case 4:
                return new zzguj((zzgui) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzguk.class) {
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
