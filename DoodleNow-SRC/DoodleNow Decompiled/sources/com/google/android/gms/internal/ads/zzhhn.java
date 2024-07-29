package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhhn extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzhhn zza;
    private static volatile zzhbt zzb;
    private zzhah zzA = zzgzv.zzbK();
    private zzhah zzB = zzgzv.zzbK();
    private zzhhh zzC;
    private zzhah zzD = zzbK();
    private zzhez zzE;
    private String zzF = "";
    private zzhep zzG;
    private zzhah zzH = zzbK();
    private zzhfy zzI;
    private int zzJ;
    private zzhah zzK = zzbK();
    private zzhah zzL = zzbK();
    private long zzM;
    private zzhhm zzN;
    private zzhgf zzO;
    private byte zzP = 2;
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private zzhev zzi;
    private zzhah zzj = zzbK();
    private zzhah zzk = zzbK();
    private String zzl = "";
    private zzhgp zzm;
    private boolean zzn;
    private zzhah zzo = zzgzv.zzbK();
    private String zzp = "";
    private boolean zzu;
    private boolean zzv;
    private zzgyj zzw = zzgyj.zzb;
    private zzhgz zzx;
    private boolean zzy;
    private String zzz = "";

    static {
        zzhhn zzhhn = new zzhhn();
        zza = zzhhn;
        zzgzv.zzca(zzhhn.class, zzhhn);
    }

    private zzhhn() {
    }

    public static zzhet zzc() {
        return (zzhet) zza.zzaZ();
    }

    static /* synthetic */ void zzi(zzhhn zzhhn, zzhgs zzhgs) {
        zzhhn.zzd = zzhgs.zza();
        zzhhn.zzc |= 1;
    }

    static /* synthetic */ void zzj(zzhhn zzhhn, String str) {
        str.getClass();
        zzhhn.zzc |= 4;
        zzhhn.zzf = str;
    }

    static /* synthetic */ void zzk(zzhhn zzhhn, String str) {
        str.getClass();
        zzhhn.zzc |= 8;
        zzhhn.zzg = str;
    }

    static /* synthetic */ void zzl(zzhhn zzhhn, zzhev zzhev) {
        zzhev.getClass();
        zzhhn.zzi = zzhev;
        zzhhn.zzc |= 32;
    }

    static /* synthetic */ void zzm(zzhhn zzhhn, zzhgx zzhgx) {
        zzhgx.getClass();
        zzhah zzhah = zzhhn.zzj;
        if (!zzhah.zzc()) {
            zzhhn.zzj = zzgzv.zzbL(zzhah);
        }
        zzhhn.zzj.add(zzhgx);
    }

    static /* synthetic */ void zzn(zzhhn zzhhn, String str) {
        zzhhn.zzc |= 64;
        zzhhn.zzl = str;
    }

    static /* synthetic */ void zzo(zzhhn zzhhn) {
        zzhhn.zzc &= -65;
        zzhhn.zzl = zza.zzl;
    }

    static /* synthetic */ void zzp(zzhhn zzhhn, zzhgp zzhgp) {
        zzhgp.getClass();
        zzhhn.zzm = zzhgp;
        zzhhn.zzc |= 128;
    }

    static /* synthetic */ void zzq(zzhhn zzhhn, zzhgz zzhgz) {
        zzhgz.getClass();
        zzhhn.zzx = zzhgz;
        zzhhn.zzc |= 8192;
    }

    static /* synthetic */ void zzr(zzhhn zzhhn, Iterable iterable) {
        zzhah zzhah = zzhhn.zzA;
        if (!zzhah.zzc()) {
            zzhhn.zzA = zzgzv.zzbL(zzhah);
        }
        zzgxq.zzaQ(iterable, zzhhn.zzA);
    }

    static /* synthetic */ void zzs(zzhhn zzhhn, Iterable iterable) {
        zzhah zzhah = zzhhn.zzB;
        if (!zzhah.zzc()) {
            zzhhn.zzB = zzgzv.zzbL(zzhah);
        }
        zzgxq.zzaQ(iterable, zzhhn.zzB);
    }

    /* access modifiers changed from: protected */
    public final Object zzde(zzgzu zzgzu, Object obj, Object obj2) {
        zzgzu zzgzu2 = zzgzu.GET_MEMOIZED_IS_INITIALIZED;
        byte b = 1;
        switch (zzgzu.ordinal()) {
            case 0:
                return Byte.valueOf(this.zzP);
            case 1:
                if (obj == null) {
                    b = 0;
                }
                this.zzP = b;
                return null;
            case 2:
                return zzbR(zza, "\u0001\"\u0000\u0001\u0001\"\"\u0000\t\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\n᠌\u0000\u000b᠌\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0010\u001b\u0011ဉ\r\u0012ဇ\u000e\u0013ဈ\u000f\u0014\u001a\u0015\u001a\u0016ဉ\u0010\u0017\u001b\u0018ဉ\u0011\u0019ဈ\u0012\u001aဉ\u0013\u001b\u001b\u001cဉ\u0014\u001d᠌\u0015\u001e\u001b\u001f\u001b ဂ\u0016!ဉ\u0017\"ဉ\u0018", new Object[]{"zzc", "zzf", "zzg", "zzh", "zzj", zzhgx.class, "zzn", "zzo", "zzp", "zzu", "zzv", "zzd", zzhgr.zza, "zze", zzher.zza, "zzi", "zzl", "zzm", "zzw", "zzk", zzhhr.class, "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzD", zzhib.class, "zzE", "zzF", "zzG", "zzH", zzhfh.class, "zzI", "zzJ", zzhhe.zza, "zzK", zzhgd.class, "zzL", zzhgk.class, "zzM", "zzN", "zzO"});
            case 3:
                return new zzhhn();
            case 4:
                return new zzhet((zzhdx) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzhhn.class) {
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

    public final String zzf() {
        return this.zzl;
    }

    public final String zzg() {
        return this.zzf;
    }

    public final List zzh() {
        return this.zzj;
    }
}
