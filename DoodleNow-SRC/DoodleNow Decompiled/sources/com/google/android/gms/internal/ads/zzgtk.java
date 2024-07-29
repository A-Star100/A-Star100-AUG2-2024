package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzgtk extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzgtk zza;
    private static volatile zzhbt zzb;
    private int zzc;
    /* access modifiers changed from: private */
    public zzgyj zzd = zzgyj.zzb;

    static {
        zzgtk zzgtk = new zzgtk();
        zza = zzgtk;
        zzgzv.zzca(zzgtk.class, zzgtk);
    }

    private zzgtk() {
    }

    public static zzgtj zzc() {
        return (zzgtj) zza.zzaZ();
    }

    public static zzgtk zze(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzgtk) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    public static zzhbt zzg() {
        return zza.zzbM();
    }

    public final int zza() {
        return this.zzc;
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
                return zzbR(zza, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zzc", "zzd"});
            case 3:
                return new zzgtk();
            case 4:
                return new zzgtj((zzgti) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzgtk.class) {
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
}
