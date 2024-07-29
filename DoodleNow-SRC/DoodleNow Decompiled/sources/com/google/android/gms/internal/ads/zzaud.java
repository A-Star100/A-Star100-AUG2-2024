package com.google.android.gms.internal.ads;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaud extends zzgzv implements zzhbm {
    /* access modifiers changed from: private */
    public static final zzaud zza;
    private static volatile zzhbt zzb;
    private long zzA;
    private long zzB;
    private long zzC;
    private long zzD;
    private long zzE;
    private String zzF = "";
    private String zzG = "D";
    private String zzH = "";
    private long zzI;
    private long zzJ;
    private long zzK;
    private String zzL = "";
    private long zzM;
    private long zzN = -1;
    private long zzO = -1;
    private zzauf zzP;
    private long zzQ = -1;
    private long zzR = -1;
    private long zzS = -1;
    private long zzT = -1;
    private long zzU = -1;
    private long zzV = -1;
    private String zzW = "D";
    private String zzX = "D";
    private long zzY = -1;
    private int zzZ = 1000;
    private int zzaA = 1000;
    private String zzaB = "D";
    private zzhah zzaC = zzbK();
    private int zzaD = 1000;
    private zzhah zzaE = zzbK();
    private zzaty zzaF;
    private String zzaG = "";
    private long zzaH = -1;
    private long zzaI = -1;
    private long zzaJ = -1;
    private long zzaK = -1;
    private long zzaL;
    private long zzaM = -1;
    private String zzaN = "";
    private zzatn zzaO;
    private zzatp zzaP;
    private long zzaQ = -1;
    private long zzaR = -1;
    private int zzaS;
    private long zzaT;
    private String zzaU = "";
    private int zzaV = 2;
    private boolean zzaW;
    private String zzaX = "";
    private long zzaY;
    private zzaus zzaZ;
    private int zzaa = 1000;
    private long zzab = -1;
    private long zzac = -1;
    private long zzad = -1;
    private long zzae = -1;
    private long zzaf = -1;
    private int zzag = 1000;
    private zzaua zzah;
    /* access modifiers changed from: private */
    public zzhah zzai = zzbK();
    private zzauc zzaj;
    private long zzak = -1;
    private long zzal = -1;
    private long zzam = -1;
    private long zzan = -1;
    private long zzao = -1;
    private long zzap = -1;
    private long zzaq = -1;
    private long zzar = -1;
    private String zzas = "D";
    private long zzat = -1;
    private int zzau;
    private int zzav;
    private int zzaw;
    private zzauu zzax;
    private long zzay = -1;
    private int zzaz = 1000;
    private long zzba = -1;
    private String zzbb = "";
    private int zzc;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzu;
    private String zzv = "";
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    static {
        zzaud zzaud = new zzaud();
        zza = zzaud;
        zzgzv.zzca(zzaud.class, zzaud);
    }

    private zzaud() {
    }

    static /* synthetic */ void zzA(zzaud zzaud, long j) {
        zzaud.zzc |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzaud.zzJ = j;
    }

    static /* synthetic */ void zzB(zzaud zzaud, long j) {
        zzaud.zzc |= C.BUFFER_FLAG_FIRST_SAMPLE;
        zzaud.zzK = j;
    }

    static /* synthetic */ void zzC(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzc |= 268435456;
        zzaud.zzL = str;
    }

    static /* synthetic */ void zzD(zzaud zzaud, long j) {
        zzaud.zzc |= 536870912;
        zzaud.zzM = j;
    }

    static /* synthetic */ void zzE(zzaud zzaud, long j) {
        zzaud.zzc |= 1073741824;
        zzaud.zzN = j;
    }

    static /* synthetic */ void zzF(zzaud zzaud, long j) {
        zzaud.zzc |= Integer.MIN_VALUE;
        zzaud.zzO = j;
    }

    static /* synthetic */ void zzG(zzaud zzaud, long j) {
        zzaud.zzd |= 2;
        zzaud.zzQ = j;
    }

    static /* synthetic */ void zzH(zzaud zzaud, long j) {
        zzaud.zzd |= 4;
        zzaud.zzR = j;
    }

    static /* synthetic */ void zzI(zzaud zzaud, long j) {
        zzaud.zzd |= 8;
        zzaud.zzS = j;
    }

    static /* synthetic */ void zzJ(zzaud zzaud, long j) {
        zzaud.zzd |= 16;
        zzaud.zzT = j;
    }

    static /* synthetic */ void zzK(zzaud zzaud, long j) {
        zzaud.zzd |= 32;
        zzaud.zzU = j;
    }

    static /* synthetic */ void zzL(zzaud zzaud, long j) {
        zzaud.zzd |= 64;
        zzaud.zzV = j;
    }

    static /* synthetic */ void zzM(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzd |= 128;
        zzaud.zzW = str;
    }

    static /* synthetic */ void zzN(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzd |= 256;
        zzaud.zzX = str;
    }

    static /* synthetic */ void zzO(zzaud zzaud, zzaun zzaun) {
        zzaud.zzZ = zzaun.zza();
        zzaud.zzd |= 1024;
    }

    static /* synthetic */ void zzP(zzaud zzaud, zzaun zzaun) {
        zzaud.zzaa = zzaun.zza();
        zzaud.zzd |= 2048;
    }

    static /* synthetic */ void zzQ(zzaud zzaud, long j) {
        zzaud.zzd |= 4096;
        zzaud.zzab = j;
    }

    static /* synthetic */ void zzR(zzaud zzaud, long j) {
        zzaud.zzd |= 8192;
        zzaud.zzac = j;
    }

    static /* synthetic */ void zzS(zzaud zzaud, long j) {
        zzaud.zzd |= 16384;
        zzaud.zzad = j;
    }

    static /* synthetic */ void zzT(zzaud zzaud, zzaun zzaun) {
        zzaud.zzag = zzaun.zza();
        zzaud.zzd |= 131072;
    }

    static /* synthetic */ void zzU(zzaud zzaud, zzaua zzaua) {
        zzaua.getClass();
        zzaud.zzah = zzaua;
        zzaud.zzd |= 262144;
    }

    static /* synthetic */ void zzV(zzaud zzaud, zzaua zzaua) {
        zzaua.getClass();
        zzhah zzhah = zzaud.zzai;
        if (!zzhah.zzc()) {
            zzaud.zzai = zzgzv.zzbL(zzhah);
        }
        zzaud.zzai.add(zzaua);
    }

    static /* synthetic */ void zzX(zzaud zzaud, zzauc zzauc) {
        zzauc.getClass();
        zzaud.zzaj = zzauc;
        zzaud.zzd |= 524288;
    }

    static /* synthetic */ void zzY(zzaud zzaud, long j) {
        zzaud.zzd |= 2097152;
        zzaud.zzal = j;
    }

    static /* synthetic */ void zzZ(zzaud zzaud, long j) {
        zzaud.zzd |= 4194304;
        zzaud.zzam = j;
    }

    public static zzata zza() {
        return (zzata) zza.zzaZ();
    }

    static /* synthetic */ void zzaa(zzaud zzaud, long j) {
        zzaud.zzd |= 8388608;
        zzaud.zzan = j;
    }

    static /* synthetic */ void zzab(zzaud zzaud, long j) {
        zzaud.zzd |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzaud.zzaq = j;
    }

    static /* synthetic */ void zzac(zzaud zzaud, long j) {
        zzaud.zzd |= C.BUFFER_FLAG_FIRST_SAMPLE;
        zzaud.zzar = j;
    }

    static /* synthetic */ void zzad(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzd |= 268435456;
        zzaud.zzas = str;
    }

    static /* synthetic */ void zzae(zzaud zzaud, zzaun zzaun) {
        zzaud.zzaz = zzaun.zza();
        zzaud.zze |= 8;
    }

    static /* synthetic */ void zzaf(zzaud zzaud, zzaun zzaun) {
        zzaud.zzaA = zzaun.zza();
        zzaud.zze |= 16;
    }

    static /* synthetic */ void zzag(zzaud zzaud, long j) {
        zzaud.zze |= 512;
        zzaud.zzaH = j;
    }

    static /* synthetic */ void zzah(zzaud zzaud, long j) {
        zzaud.zze |= 1024;
        zzaud.zzaI = j;
    }

    static /* synthetic */ void zzai(zzaud zzaud, long j) {
        zzaud.zze |= 2048;
        zzaud.zzaJ = j;
    }

    static /* synthetic */ void zzaj(zzaud zzaud, long j) {
        zzaud.zze |= 4096;
        zzaud.zzaK = j;
    }

    static /* synthetic */ void zzak(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zze |= 32768;
        zzaud.zzaN = str;
    }

    static /* synthetic */ void zzal(zzaud zzaud, zzats zzats) {
        zzaud.zzaS = zzats.zza();
        zzaud.zze |= 1048576;
    }

    static /* synthetic */ void zzam(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zze |= 4194304;
        zzaud.zzaU = str;
    }

    static /* synthetic */ void zzan(zzaud zzaud, zzati zzati) {
        zzaud.zzaV = zzati.zza();
        zzaud.zze |= 8388608;
    }

    static /* synthetic */ void zzao(zzaud zzaud, boolean z) {
        zzaud.zze |= 16777216;
        zzaud.zzaW = z;
    }

    static /* synthetic */ void zzap(zzaud zzaud, long j) {
        zzaud.zze |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        zzaud.zzaY = j;
    }

    public static zzaud zze() {
        return zza;
    }

    public static zzaud zzf(byte[] bArr, zzgzf zzgzf) throws zzhak {
        return (zzaud) zzgzv.zzbx(zza, bArr, zzgzf);
    }

    static /* synthetic */ void zzj(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzc |= 1;
        zzaud.zzf = str;
    }

    static /* synthetic */ void zzk(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzc |= 2;
        zzaud.zzg = str;
    }

    static /* synthetic */ void zzl(zzaud zzaud, long j) {
        zzaud.zzc |= 4;
        zzaud.zzh = j;
    }

    static /* synthetic */ void zzm(zzaud zzaud, long j) {
        zzaud.zzc |= 16;
        zzaud.zzj = j;
    }

    static /* synthetic */ void zzn(zzaud zzaud, long j) {
        zzaud.zzc |= 32;
        zzaud.zzk = j;
    }

    static /* synthetic */ void zzo(zzaud zzaud, long j) {
        zzaud.zzc |= 1024;
        zzaud.zzp = j;
    }

    static /* synthetic */ void zzp(zzaud zzaud, long j) {
        zzaud.zzc |= 2048;
        zzaud.zzu = j;
    }

    static /* synthetic */ void zzq(zzaud zzaud, long j) {
        zzaud.zzc |= 8192;
        zzaud.zzw = j;
    }

    static /* synthetic */ void zzr(zzaud zzaud, long j) {
        zzaud.zzc |= 16384;
        zzaud.zzx = j;
    }

    static /* synthetic */ void zzs(zzaud zzaud, long j) {
        zzaud.zzc |= 32768;
        zzaud.zzy = j;
    }

    static /* synthetic */ void zzt(zzaud zzaud, long j) {
        zzaud.zzc |= 65536;
        zzaud.zzz = j;
    }

    static /* synthetic */ void zzu(zzaud zzaud, long j) {
        zzaud.zzc |= 524288;
        zzaud.zzC = j;
    }

    static /* synthetic */ void zzv(zzaud zzaud, long j) {
        zzaud.zzc |= 1048576;
        zzaud.zzD = j;
    }

    static /* synthetic */ void zzw(zzaud zzaud, long j) {
        zzaud.zzc |= 2097152;
        zzaud.zzE = j;
    }

    static /* synthetic */ void zzx(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzc |= 4194304;
        zzaud.zzF = str;
    }

    static /* synthetic */ void zzy(zzaud zzaud, String str) {
        str.getClass();
        zzaud.zzc |= 16777216;
        zzaud.zzH = str;
    }

    static /* synthetic */ void zzz(zzaud zzaud, long j) {
        zzaud.zzc |= 33554432;
        zzaud.zzI = j;
    }

    public final boolean zzaq() {
        return this.zzaW;
    }

    public final boolean zzar() {
        return (this.zzc & 4194304) != 0;
    }

    public final boolean zzas() {
        return (this.zze & C.BUFFER_FLAG_FIRST_SAMPLE) != 0;
    }

    public final zzati zzc() {
        zzati zzb2 = zzati.zzb(this.zzaV);
        return zzb2 == null ? zzati.DEVICE_IDENTIFIER_GLOBAL_ID : zzb2;
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
                zzhab zzhab = zzaum.zza;
                zzhab zzhab2 = zzaum.zza;
                return zzbR(zza, "\u0001a\u0000\u0003\u0001Įa\u0000\u0003\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂU\u0016ဂ\u0014\u0017ဂ\u0015\u0018ဈV\u0019ဂZ\u001a᠌W\u001bဈ\u0016\u001cဇX\u001dဈ\u0018\u001eဈY\u001fဂ\u0019 ဂ\u001a!ဂ\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဂ\u001f&ဉ 'ဂ!(ဂ\")ဂ#*ဂ$+\u001b,ဂ%-ဂ&.ဈ'/ဈ(0᠌*1᠌+2ဉ23ဂ,4ဂ-5ဂ.6ဂ/7ဂ08᠌19ဉ3:ဂ4;ဂ5<ဂ6=ဂ7>ဂ:?ဂ;@ဂ=A᠌>B᠌?Cဈ<D᠌@EဉAFဂBGဂ8Hဂ9I᠌CJဂ)Kဈ\u0017L᠌DMဈEN\u001bO᠌FP\u001bQဉGRဈHSဂITဂJUဂKVဂLWဂMXဂNYဈOZဉP[ဉQ\\ဂR]ဂS^᠌TÉဉ[ĭဂ\\Įဈ]", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzA", "zzB", "zzC", "zzaT", "zzD", "zzE", "zzaU", "zzaY", "zzaV", zzath.zza, "zzF", "zzaW", "zzH", "zzaX", "zzI", "zzJ", "zzK", "zzL", "zzM", "zzN", "zzO", "zzP", "zzQ", "zzR", "zzS", "zzT", "zzai", zzaua.class, "zzU", "zzV", "zzW", "zzX", "zzZ", zzaum.zza, "zzaa", zzhab, "zzah", "zzab", "zzac", "zzad", "zzae", "zzaf", "zzag", zzhab, "zzaj", "zzak", "zzal", "zzam", "zzan", "zzaq", "zzar", "zzat", "zzau", zzauj.zza, "zzav", zzaup.zza, "zzas", "zzaw", zzatc.zza, "zzax", "zzay", "zzao", "zzap", "zzaz", zzhab2, "zzY", "zzG", "zzaA", zzhab2, "zzaB", "zzaC", zzatw.class, "zzaD", zzhab2, "zzaE", zzatf.class, "zzaF", "zzaG", "zzaH", "zzaI", "zzaJ", "zzaK", "zzaL", "zzaM", "zzaN", "zzaO", "zzaP", "zzaQ", "zzaR", "zzaS", zzatr.zza, "zzaZ", "zzba", "zzbb"});
            case 3:
                return new zzaud();
            case 4:
                return new zzata((zzasz) null);
            case 5:
                return zza;
            case 6:
                zzhbt zzhbt = zzb;
                if (zzhbt == null) {
                    synchronized (zzaud.class) {
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

    public final zzaus zzg() {
        zzaus zzaus = this.zzaZ;
        return zzaus == null ? zzaus.zzd() : zzaus;
    }

    public final String zzh() {
        return this.zzaU;
    }

    public final String zzi() {
        return this.zzF;
    }
}
