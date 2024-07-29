package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzazn extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzazn zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private long zzf;
    private long zzg;
    private long zzh;

    static {
        zzazn zzazn = new zzazn();
        zza = zzazn;
        zzgzv.zzca(zzazn.class, zzazn);
    }

    private zzazn() {
    }

    public static zzazm zze() {
        return (zzazm) zza.zzaZ();
    }

    public static zzazn zzg() {
        return zza;
    }

    public static zzazn zzh(zzgyj zzgyj) throws zzhak {
        return (zzazn) zzgzv.zzbm(zza, zzgyj);
    }

    public static zzazn zzi(zzgyj zzgyj, zzgzf zzgzf) throws zzhak {
        return (zzazn) zzgzv.zzbr(zza, zzgyj, zzgzf);
    }

    static /* synthetic */ void zzl(zzazn zzazn, String str) {
        str.getClass();
        zzazn.zzc |= 1;
        zzazn.zzd = str;
    }

    static /* synthetic */ void zzm(zzazn zzazn, long j) {
        zzazn.zzc |= 16;
        zzazn.zzh = j;
    }

    static /* synthetic */ void zzn(zzazn zzazn, String str) {
        str.getClass();
        zzazn.zzc |= 2;
        zzazn.zze = str;
    }

    static /* synthetic */ void zzo(zzazn zzazn, long j) {
        zzazn.zzc |= 4;
        zzazn.zzf = j;
    }

    static /* synthetic */ void zzp(zzazn zzazn, long j) {
        zzazn.zzc |= 8;
        zzazn.zzg = j;
    }

    public final long zza() {
        return this.zzg;
    }

    public final long zzc() {
        return this.zzf;
    }

    public final long zzd() {
        return this.zzh;
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
                return zzbR(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh"});
            case 3:
                return new zzazn();
            case 4:
                return new zzazm((zzazl) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzazn.class) {
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

    public final String zzj() {
        return this.zze;
    }

    public final String zzk() {
        return this.zzd;
    }
}
