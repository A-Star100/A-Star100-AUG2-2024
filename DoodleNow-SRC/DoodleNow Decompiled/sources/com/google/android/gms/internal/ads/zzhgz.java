package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhgz extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhgz zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private boolean zzf;
    private int zzg;
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;

    static {
        zzhgz zzhgz = new zzhgz();
        zza = zzhgz;
        zzgzv.zzca(zzhgz.class, zzhgz);
    }

    private zzhgz() {
    }

    public static zzhgy zzc() {
        return (zzhgy) zza.zzaZ();
    }

    static /* synthetic */ void zzf(zzhgz zzhgz, String str) {
        zzhgz.zzc |= 1;
        zzhgz.zzd = str;
    }

    static /* synthetic */ void zzg(zzhgz zzhgz, long j) {
        zzhgz.zzc |= 2;
        zzhgz.zze = j;
    }

    static /* synthetic */ void zzh(zzhgz zzhgz, boolean z) {
        zzhgz.zzc |= 4;
        zzhgz.zzf = z;
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
                return zzbR(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002\u0004᠌\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", zzhhb.zza, "zzh", "zzi", "zzj"});
            case 3:
                return new zzhgz();
            case 4:
                return new zzhgy((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhgz.class) {
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
