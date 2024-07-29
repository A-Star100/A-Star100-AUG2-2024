package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhgx extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhgx zza;
    private static volatile zzhbt zzb;
    private int zzc;
    private int zzd;
    private String zze = "";
    private zzhfn zzf;
    private zzhfr zzg;
    private int zzh;
    private zzhad zzi = zzbG();
    private String zzj = "";
    private int zzk;
    private zzhah zzl = zzgzv.zzbK();
    private byte zzm = 2;

    static {
        zzhgx zzhgx = new zzhgx();
        zza = zzhgx;
        zzgzv.zzca(zzhgx.class, zzhgx);
    }

    private zzhgx() {
    }

    public static zzhgw zze() {
        return (zzhgw) zza.zzaZ();
    }

    static /* synthetic */ void zzh(zzhgx zzhgx, int i) {
        zzhgx.zzc |= 1;
        zzhgx.zzd = i;
    }

    static /* synthetic */ void zzi(zzhgx zzhgx, String str) {
        str.getClass();
        zzhgx.zzc |= 2;
        zzhgx.zze = str;
    }

    static /* synthetic */ void zzj(zzhgx zzhgx, zzhfn zzhfn) {
        zzhfn.getClass();
        zzhgx.zzf = zzhfn;
        zzhgx.zzc |= 4;
    }

    static /* synthetic */ void zzk(zzhgx zzhgx, zzhgv zzhgv) {
        zzhgx.zzk = zzhgv.zza();
        zzhgx.zzc |= 64;
    }

    static /* synthetic */ void zzl(zzhgx zzhgx, String str) {
        str.getClass();
        zzhah zzhah = zzhgx.zzl;
        if (!zzhah.zzc()) {
            zzhgx.zzl = zzgzv.zzbL(zzhah);
        }
        zzhgx.zzl.add(str);
    }

    public final int zzc() {
        return this.zzl.size();
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        byte b = 1;
        switch (zzgzu.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzm);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzm = b;
                return null;
            case 2:
                return zzbR(zza, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\b᠌\u0006\t\u001a", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", zzhgu.zza, "zzl"});
            case 3:
                return new zzhgx();
            case 4:
                return new zzhgw((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhgx.class) {
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

    public final String zzg() {
        return this.zze;
    }
}
