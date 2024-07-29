package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzdg {
    private static final String zzF = Integer.toString(1, 36);
    private static final String zzG = Integer.toString(2, 36);
    private static final String zzH = Integer.toString(3, 36);
    private static final String zzI = Integer.toString(4, 36);
    private static final String zzJ = Integer.toString(5, 36);
    private static final String zzK = Integer.toString(6, 36);
    private static final String zzL = Integer.toString(7, 36);
    private static final String zzM = Integer.toString(8, 36);
    private static final String zzN = Integer.toString(9, 36);
    private static final String zzO = Integer.toString(10, 36);
    private static final String zzP = Integer.toString(11, 36);
    private static final String zzQ = Integer.toString(12, 36);
    private static final String zzR = Integer.toString(13, 36);
    private static final String zzS = Integer.toString(14, 36);
    private static final String zzT = Integer.toString(15, 36);
    private static final String zzU = Integer.toString(16, 36);
    private static final String zzV = Integer.toString(17, 36);
    private static final String zzW = Integer.toString(18, 36);
    private static final String zzX = Integer.toString(19, 36);
    private static final String zzY = Integer.toString(20, 36);
    private static final String zzZ = Integer.toString(21, 36);
    public static final zzdg zza;
    private static final String zzaa = Integer.toString(22, 36);
    private static final String zzab = Integer.toString(23, 36);
    private static final String zzac = Integer.toString(24, 36);
    private static final String zzad = Integer.toString(25, 36);
    private static final String zzae = Integer.toString(26, 36);
    private static final String zzaf = Integer.toString(27, 36);
    private static final String zzag = Integer.toString(28, 36);
    private static final String zzah = Integer.toString(29, 36);
    private static final String zzai = Integer.toString(30, 36);
    private static final String zzaj = Integer.toString(31, 36);
    @Deprecated
    public static final zzdg zzb;
    @Deprecated
    public static final zzn zzc = zzdc.zza;
    public final boolean zzA;
    public final boolean zzB;
    public final boolean zzC;
    public final zzfzq zzD;
    public final zzfzs zzE;
    public final int zzd = Integer.MAX_VALUE;
    public final int zze = Integer.MAX_VALUE;
    public final int zzf = Integer.MAX_VALUE;
    public final int zzg = Integer.MAX_VALUE;
    public final int zzh = 0;
    public final int zzi = 0;
    public final int zzj = 0;
    public final int zzk = 0;
    public final int zzl;
    public final int zzm;
    public final boolean zzn;
    public final zzfzn zzo;
    public final int zzp;
    public final zzfzn zzq;
    public final int zzr;
    public final int zzs;
    public final int zzt;
    public final zzfzn zzu;
    public final zzde zzv;
    public final zzfzn zzw;
    public final int zzx;
    public final int zzy;
    public final boolean zzz;

    static {
        zzdg zzdg = new zzdg(new zzdf());
        zza = zzdg;
        zzb = zzdg;
    }

    protected zzdg(zzdf zzdf) {
        this.zzl = zzdf.zze;
        this.zzm = zzdf.zzf;
        this.zzn = zzdf.zzg;
        this.zzo = zzdf.zzh;
        this.zzp = 0;
        this.zzq = zzdf.zzi;
        this.zzr = 0;
        this.zzs = Integer.MAX_VALUE;
        this.zzt = Integer.MAX_VALUE;
        this.zzu = zzdf.zzl;
        this.zzv = zzdf.zzm;
        this.zzw = zzdf.zzn;
        this.zzx = zzdf.zzo;
        this.zzy = 0;
        this.zzz = false;
        this.zzA = false;
        this.zzB = false;
        this.zzC = false;
        this.zzD = zzfzq.zzc(zzdf.zzp);
        this.zzE = zzfzs.zzl(zzdf.zzq);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzdg zzdg = (zzdg) obj;
            return this.zzn == zzdg.zzn && this.zzl == zzdg.zzl && this.zzm == zzdg.zzm && this.zzo.equals(zzdg.zzo) && this.zzq.equals(zzdg.zzq) && this.zzu.equals(zzdg.zzu) && this.zzv.equals(zzdg.zzv) && this.zzw.equals(zzdg.zzw) && this.zzx == zzdg.zzx && this.zzD.equals(zzdg.zzD) && this.zzE.equals(zzdg.zzE);
        }
    }

    public int hashCode() {
        return (((((((((((((((((((((((((this.zzn ? 1 : 0) - true) * 31) + this.zzl) * 31) + this.zzm) * 31) + this.zzo.hashCode()) * 961) + this.zzq.hashCode()) * 961) + Integer.MAX_VALUE) * 31) + Integer.MAX_VALUE) * 31) + this.zzu.hashCode()) * 31) + 29791) * 31) + this.zzw.hashCode()) * 31) + this.zzx) * 887503681) + this.zzD.hashCode()) * 31) + this.zzE.hashCode();
    }
}
