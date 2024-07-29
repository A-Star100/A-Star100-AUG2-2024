package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhep extends zzgzv implements zzhbm {
    private static final zzhae zza = new zzhdy();
    private static final zzhae zzb = new zzhdz();
    /* access modifiers changed from: private */
    public static final zzhep zzc;
    private static volatile zzhbt zzd;
    private boolean zzA;
    private zzhad zzB = zzbG();
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = "";
    private zzhah zzi = zzgzv.zzbK();
    private int zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;
    private String zzn = "";
    private int zzo;
    private int zzp;
    private int zzu;
    private boolean zzv;
    private zzhah zzw = zzbK();
    private boolean zzx;
    private long zzy;
    private zzhad zzz = zzbG();

    static {
        zzhep zzhep = new zzhep();
        zzc = zzhep;
        zzgzv.zzca(zzhep.class, zzhep);
    }

    private zzhep() {
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
                return zzbR(zzc, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0004\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004\u001a\u0005᠌\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006\tဈ\u0007\nင\b\u000bင\t\fင\n\rဇ\u000b\u000e\u001b\u000fဇ\f\u0010ဂ\r\u0011ࠬ\u0012ဇ\u000e\u0013ࠬ", new Object[]{"zze", "zzf", zzhen.zza, "zzg", "zzh", "zzi", "zzj", zzheh.zza, "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", zzhef.class, "zzx", "zzy", "zzz", zzhdr.zzb(), "zzA", "zzB", zzhek.zza});
            case 3:
                return new zzhep();
            case 4:
                return new zzhea((zzhdx) null);
            case 5:
                return zzc;
            case 6:
                zzhbt zzhbt = zzd;
                if (zzhbt == null) {
                    synchronized (zzhep.class) {
                        zzhbt = zzd;
                        if (zzhbt == null) {
                            zzhbt = new zzgzq(zzc);
                            zzd = zzhbt;
                        }
                    }
                }
                return zzhbt;
            default:
                throw new UnsupportedOperationException();
        }
    }
}
