package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzxc extends zzcx {
    private static final Object zzc = new Object();
    private static final zzbp zzd;
    private final long zze;
    private final long zzf;
    private final boolean zzg;
    private final zzbp zzh;
    private final zzbf zzi;

    static {
        zzar zzar = new zzar();
        zzar.zza("SinglePeriodTimeline");
        zzar.zzb(Uri.EMPTY);
        zzd = zzar.zzc();
    }

    public zzxc(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, Object obj, zzbp zzbp, zzbf zzbf) {
        this.zze = j4;
        this.zzf = j5;
        this.zzg = z;
        zzbp.getClass();
        this.zzh = zzbp;
        this.zzi = zzbf;
    }

    public final int zza(Object obj) {
        return zzc.equals(obj) ? 0 : -1;
    }

    public final int zzb() {
        return 1;
    }

    public final int zzc() {
        return 1;
    }

    public final zzcu zzd(int i, zzcu zzcu, boolean z) {
        zzek.zza(i, 0, 1);
        zzcu.zzl((Object) null, z ? zzc : null, 0, this.zze, 0, zzd.zza, false);
        return zzcu;
    }

    public final zzcw zze(int i, zzcw zzcw, long j) {
        zzek.zza(i, 0, 1);
        zzbf zzbf = this.zzi;
        zzcw.zza(zzcw.zza, this.zzh, (Object) null, C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, this.zzg, false, zzbf, 0, this.zzf, 0, 0, 0);
        return zzcw;
    }

    public final Object zzf(int i) {
        zzek.zza(i, 0, 1);
        return zzc;
    }
}
