package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgvb extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgvb zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private zzgup zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public int zzf;
    /* access modifiers changed from: private */
    public int zzg;

    static {
        zzgvb zzgvb = new zzgvb();
        zza = zzgvb;
        zzgzv.zzca(zzgvb.class, zzgvb);
    }

    private zzgvb() {
    }

    public static zzgva zze() {
        return (zzgva) zza.zzaZ();
    }

    static /* synthetic */ void zzh(zzgvb zzgvb, zzgup zzgup) {
        zzgup.getClass();
        zzgvb.zzd = zzgup;
        zzgvb.zzc |= 1;
    }

    public final int zza() {
        return this.zzf;
    }

    public final zzgup zzc() {
        zzgup zzgup = this.zzd;
        return zzgup == null ? zzgup.zze() : zzgup;
    }

    public final zzgur zzd() {
        zzgur zzb2 = zzgur.zzb(this.zze);
        return zzb2 == null ? zzgur.UNRECOGNIZED : zzb2;
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
                return zzbR(zza, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002\f\u0003\u000b\u0004\f", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
            case 3:
                return new zzgvb();
            case 4:
                return new zzgva((zzguy) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgvb.class) {
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

    public final zzgvv zzg() {
        zzgvv zzb2 = zzgvv.zzb(this.zzg);
        return zzb2 == null ? zzgvv.UNRECOGNIZED : zzb2;
    }

    public final boolean zzl() {
        return (this.zzc & 1) != 0;
    }
}
