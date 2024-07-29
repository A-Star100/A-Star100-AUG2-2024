package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzfqo extends zzgzv implements zzhbm {
    private static final zzhae zza = new zzfqj();
    /* access modifiers changed from: private */
    public static final zzfqo zzb;
    private static volatile zzhbt zzc;
    private int zzd;
    private zzhad zze = zzbG();
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzfqo zzfqo = new zzfqo();
        zzb = zzfqo;
        zzgzv.zzca(zzfqo.class, zzfqo);
    }

    private zzfqo() {
    }

    public static zzfqn zza() {
        return (zzfqn) zzb.zzaZ();
    }

    static /* synthetic */ void zzd(zzfqo zzfqo, zzfqm zzfqm) {
        zzfqm.getClass();
        zzhad zzhad = zzfqo.zze;
        if (!zzhad.zzc()) {
            zzfqo.zze = zzgzv.zzbH(zzhad);
        }
        zzfqo.zze.zzi(zzfqm.zza());
    }

    static /* synthetic */ void zze(zzfqo zzfqo, String str) {
        str.getClass();
        zzfqo.zzd |= 1;
        zzfqo.zzf = str;
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
                return zzbR(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ࠞ\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzd", "zze", zzfql.zza, "zzf", "zzg", "zzh"});
            case 3:
                return new zzfqo();
            case 4:
                return new zzfqn((zzfqj) null);
            case 5:
                return zzb;
            case 6:
                zzhbt zzhbt = zzc;
                if (zzhbt == null) {
                    synchronized (zzfqo.class) {
                        zzhbt = zzc;
                        if (zzhbt == null) {
                            zzhbt = new zzgzq(zzb);
                            zzc = zzhbt;
                        }
                    }
                }
                return zzhbt;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
