package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzbp {
    public static final zzbp zza = new zzar().zzc();
    @Deprecated
    public static final zzn zzb = zzao.zza;
    private static final String zzk = Integer.toString(0, 36);
    private static final String zzl = Integer.toString(1, 36);
    private static final String zzm = Integer.toString(2, 36);
    private static final String zzn = Integer.toString(3, 36);
    private static final String zzo = Integer.toString(4, 36);
    private static final String zzp = Integer.toString(5, 36);
    public final String zzc;
    public final zzbi zzd;
    @Deprecated
    public final zzbi zze;
    public final zzbf zzf;
    public final zzbv zzg;
    public final zzav zzh;
    @Deprecated
    public final zzax zzi;
    public final zzbl zzj;

    /* synthetic */ zzbp(String str, zzax zzax, zzbi zzbi, zzbf zzbf, zzbv zzbv, zzbl zzbl, zzbo zzbo) {
        this.zzc = str;
        this.zzd = zzbi;
        this.zze = zzbi;
        this.zzf = zzbf;
        this.zzg = zzbv;
        this.zzh = zzax;
        this.zzi = zzax;
        this.zzj = zzbl;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbp)) {
            return false;
        }
        zzbp zzbp = (zzbp) obj;
        return zzfx.zzG(this.zzc, zzbp.zzc) && this.zzh.equals(zzbp.zzh) && zzfx.zzG(this.zzd, zzbp.zzd) && zzfx.zzG(this.zzf, zzbp.zzf) && zzfx.zzG(this.zzg, zzbp.zzg) && zzfx.zzG(this.zzj, zzbp.zzj);
    }

    public final int hashCode() {
        int hashCode = this.zzc.hashCode() * 31;
        zzbi zzbi = this.zzd;
        return (((((((hashCode + (zzbi != null ? zzbi.hashCode() : 0)) * 31) + this.zzf.hashCode()) * 31) + this.zzh.hashCode()) * 31) + this.zzg.hashCode()) * 31;
    }
}
