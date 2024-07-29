package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzguu extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzguu zza;
    private static volatile zzhbt zzb;
    private String zzc = "";
    private zzgyj zzd = zzgyj.zzb;
    /* access modifiers changed from: private */
    public int zze;

    static {
        zzguu zzguu = new zzguu();
        zza = zzguu;
        zzgzv.zzca(zzguu.class, zzguu);
    }

    private zzguu() {
    }

    public static zzgut zza() {
        return (zzgut) zza.zzaZ();
    }

    public static zzgut zzc(zzguu zzguu) {
        return (zzgut) zza.zzba(zzguu);
    }

    public static zzguu zze() {
        return zza;
    }

    public static zzguu zzf(byte[] bArr, zzgzf zzgzf) throws zzhak {
        return (zzguu) zzgzv.zzbx(zza, bArr, zzgzf);
    }

    static /* synthetic */ void zzj(zzguu zzguu, String str) {
        str.getClass();
        zzguu.zzc = str;
    }

    static /* synthetic */ void zzk(zzguu zzguu, zzgyj zzgyj) {
        zzgyj.getClass();
        zzguu.zzd = zzgyj;
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
                return new zzguu();
            case 4:
                return new zzgut((zzgus) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzguu.class) {
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
        zzgvv zzb2 = zzgvv.zzb(this.zze);
        return zzb2 == null ? zzgvv.UNRECOGNIZED : zzb2;
    }

    public final zzgyj zzh() {
        return this.zzd;
    }

    public final String zzi() {
        return this.zzc;
    }
}
