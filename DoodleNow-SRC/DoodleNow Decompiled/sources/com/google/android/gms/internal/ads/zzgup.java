package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgup extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgup zza;
    private static volatile zzhbt zzb;
    private String zzc = "";
    private zzgyj zzd = zzgyj.zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzgup zzgup = new zzgup();
        zza = zzgup;
        zzgzv.zzca(zzgup.class, zzgup);
    }

    private zzgup() {
    }

    public static zzgum zza() {
        return (zzgum) zza.zzaZ();
    }

    public static zzgup zze() {
        return zza;
    }

    static /* synthetic */ void zzh(zzgup zzgup, String str) {
        str.getClass();
        zzgup.zzc = str;
    }

    static /* synthetic */ void zzi(zzgup zzgup, zzgyj zzgyj) {
        zzgyj.getClass();
        zzgup.zzd = zzgyj;
    }

    public final zzguo zzc() {
        zzguo zzb2 = zzguo.zzb(this.zze);
        return zzb2 == null ? zzguo.UNRECOGNIZED : zzb2;
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
                return zzbR(zza, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzc", "zzd", "zze"});
            case 3:
                return new zzgup();
            case 4:
                return new zzgum((zzgul) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgup.class) {
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

    public final zzgyj zzf() {
        return this.zzd;
    }

    public final String zzg() {
        return this.zzc;
    }
}
