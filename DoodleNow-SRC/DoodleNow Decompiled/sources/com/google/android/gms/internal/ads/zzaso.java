package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaso extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzaso zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";
    private long zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private long zzj;
    private String zzk = "";
    private long zzl;
    private String zzm = "";
    private String zzn = "";
    private zzhah zzo = zzbK();
    private int zzp;

    static {
        zzaso zzaso = new zzaso();
        zza = zzaso;
        zzgzv.zzca(zzaso.class, zzaso);
    }

    private zzaso() {
    }

    public static zzasi zza() {
        return (zzasi) zza.zzaZ();
    }

    static /* synthetic */ void zzd(zzaso zzaso, long j) {
        zzaso.zzc |= 2;
        zzaso.zze = j;
    }

    static /* synthetic */ void zze(zzaso zzaso, String str) {
        str.getClass();
        zzaso.zzc |= 4;
        zzaso.zzf = str;
    }

    static /* synthetic */ void zzf(zzaso zzaso, String str) {
        str.getClass();
        zzaso.zzc |= 8;
        zzaso.zzg = str;
    }

    static /* synthetic */ void zzg(zzaso zzaso, String str) {
        zzaso.zzc |= 16;
        zzaso.zzh = str;
    }

    static /* synthetic */ void zzh(zzaso zzaso, String str) {
        zzaso.zzc |= 1024;
        zzaso.zzn = str;
    }

    static /* synthetic */ void zzi(zzaso zzaso, zzasn zzasn) {
        zzaso.zzp = zzasn.zza();
        zzaso.zzc |= 2048;
    }

    static /* synthetic */ void zzj(zzaso zzaso, String str) {
        str.getClass();
        zzaso.zzc |= 1;
        zzaso.zzd = str;
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
                return zzbR(zza, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", zzask.class, "zzp", zzasm.zza});
            case 3:
                return new zzaso();
            case 4:
                return new zzasi((zzash) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzaso.class) {
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
