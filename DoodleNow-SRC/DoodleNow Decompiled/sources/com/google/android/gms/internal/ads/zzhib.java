package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhib extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhib zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private String zzd = "";
    private String zze = "";
    private int zzf = 4;
    private zzhah zzg = zzgzv.zzbK();
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;
    private zzhah zzl = zzbK();
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzu;

    static {
        zzhib zzhib = new zzhib();
        zza = zzhib;
        zzgzv.zzca(zzhib.class, zzhib);
    }

    private zzhib() {
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
                return zzbR(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0002\u0000\u0001ဈ\u0000\u0002᠌\u0002\u0003\u001a\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဇ\u0005\u0007က\u0006\b\u001b\tဈ\u0001\n᠌\u0007\u000bဇ\b\fဇ\t\rဇ\n\u000eဇ\u000b", new Object[]{"zzc", "zzd", "zzf", zzhhz.zza, "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", zzhhx.class, "zze", "zzm", zzhhu.zza, "zzn", "zzo", "zzp", "zzu"});
            case 3:
                return new zzhib();
            case 4:
                return new zzhhs((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhib.class) {
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
