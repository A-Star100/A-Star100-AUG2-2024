package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcw {
    private static final String zzA = Integer.toString(8, 36);
    private static final String zzB = Integer.toString(9, 36);
    private static final String zzC = Integer.toString(10, 36);
    private static final String zzD = Integer.toString(11, 36);
    private static final String zzE = Integer.toString(12, 36);
    private static final String zzF = Integer.toString(13, 36);
    public static final Object zza = new Object();
    @Deprecated
    public static final zzn zzb = zzcv.zza;
    private static final Object zzr = new Object();
    private static final zzbp zzs;
    private static final String zzt = Integer.toString(1, 36);
    private static final String zzu = Integer.toString(2, 36);
    private static final String zzv = Integer.toString(3, 36);
    private static final String zzw = Integer.toString(4, 36);
    private static final String zzx = Integer.toString(5, 36);
    private static final String zzy = Integer.toString(6, 36);
    private static final String zzz = Integer.toString(7, 36);
    public Object zzc = zza;
    @Deprecated
    public Object zzd;
    public zzbp zze = zzs;
    public long zzf;
    public long zzg;
    public long zzh;
    public boolean zzi;
    public boolean zzj;
    @Deprecated
    public boolean zzk;
    public zzbf zzl;
    public boolean zzm;
    public long zzn;
    public long zzo;
    public int zzp;
    public int zzq;

    static {
        zzar zzar = new zzar();
        zzar.zza("androidx.media3.common.Timeline");
        zzar.zzb(Uri.EMPTY);
        zzs = zzar.zzc();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass().equals(obj.getClass())) {
            zzcw zzcw = (zzcw) obj;
            return zzfx.zzG(this.zzc, zzcw.zzc) && zzfx.zzG(this.zze, zzcw.zze) && zzfx.zzG((Object) null, (Object) null) && zzfx.zzG(this.zzl, zzcw.zzl) && this.zzf == zzcw.zzf && this.zzg == zzcw.zzg && this.zzh == zzcw.zzh && this.zzi == zzcw.zzi && this.zzj == zzcw.zzj && this.zzm == zzcw.zzm && this.zzo == zzcw.zzo && this.zzp == zzcw.zzp && this.zzq == zzcw.zzq;
        }
    }

    public final int hashCode() {
        int i;
        int hashCode = ((this.zzc.hashCode() + JfifUtil.MARKER_EOI) * 31) + this.zze.hashCode();
        zzbf zzbf = this.zzl;
        if (zzbf == null) {
            i = 0;
        } else {
            i = zzbf.hashCode();
        }
        long j = this.zzf;
        long j2 = this.zzg;
        long j3 = this.zzh;
        int i2 = (((((((((((((hashCode * 961) + i) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + ((int) (j3 ^ (j3 >>> 32)))) * 31) + (this.zzi ? 1 : 0)) * 31) + (this.zzj ? 1 : 0)) * 31) + (this.zzm ? 1 : 0);
        long j4 = this.zzo;
        return ((((((i2 * 961) + ((int) (j4 ^ (j4 >>> 32)))) * 31) + this.zzp) * 31) + this.zzq) * 31;
    }

    public final zzcw zza(Object obj, zzbp zzbp, Object obj2, long j, long j2, long j3, boolean z, boolean z2, zzbf zzbf, long j4, long j5, int i, int i2, long j6) {
        zzbf zzbf2 = zzbf;
        this.zzc = obj;
        this.zze = zzbp == null ? zzs : zzbp;
        this.zzd = null;
        this.zzf = C.TIME_UNSET;
        this.zzg = C.TIME_UNSET;
        this.zzh = C.TIME_UNSET;
        this.zzi = z;
        this.zzj = z2;
        this.zzk = zzbf2 != null;
        this.zzl = zzbf2;
        this.zzn = 0;
        this.zzo = j5;
        this.zzp = 0;
        this.zzq = 0;
        this.zzm = false;
        return this;
    }

    public final boolean zzb() {
        zzek.zzf(this.zzk == (this.zzl != null));
        return this.zzl != null;
    }
}
