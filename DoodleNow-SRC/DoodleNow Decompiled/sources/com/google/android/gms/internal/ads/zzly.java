package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzly {
    private static final zzvh zzt = new zzvh(new Object(), -1);
    public final zzcx zza;
    public final zzvh zzb;
    public final long zzc;
    public final long zzd;
    public final int zze;
    public final zziz zzf;
    public final boolean zzg;
    public final zzxk zzh;
    public final zzzg zzi;
    public final List zzj;
    public final zzvh zzk;
    public final boolean zzl;
    public final int zzm;
    public final zzcg zzn;
    public final boolean zzo = false;
    public volatile long zzp;
    public volatile long zzq;
    public volatile long zzr;
    public volatile long zzs;

    public zzly(zzcx zzcx, zzvh zzvh, long j, long j2, int i, zziz zziz, boolean z, zzxk zzxk, zzzg zzzg, List list, zzvh zzvh2, boolean z2, int i2, zzcg zzcg, long j3, long j4, long j5, long j6, boolean z3) {
        this.zza = zzcx;
        this.zzb = zzvh;
        this.zzc = j;
        this.zzd = j2;
        this.zze = i;
        this.zzf = zziz;
        this.zzg = z;
        this.zzh = zzxk;
        this.zzi = zzzg;
        this.zzj = list;
        this.zzk = zzvh2;
        this.zzl = z2;
        this.zzm = i2;
        this.zzn = zzcg;
        this.zzp = j3;
        this.zzq = j4;
        this.zzr = j5;
        this.zzs = j6;
    }

    public static zzly zzg(zzzg zzzg) {
        zzcx zzcx = zzcx.zza;
        zzvh zzvh = zzt;
        return new zzly(zzcx, zzvh, C.TIME_UNSET, 0, 1, (zziz) null, false, zzxk.zza, zzzg, zzfzn.zzm(), zzvh, false, 0, zzcg.zza, 0, 0, 0, 0, false);
    }

    public static zzvh zzh() {
        return zzt;
    }

    public final zzly zza(zzvh zzvh) {
        boolean z = this.zzl;
        int i = this.zzm;
        zzcg zzcg = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, zzvh, z, i, zzcg, j, j2, j3, j4, false);
    }

    public final zzly zzb(zzvh zzvh, long j, long j2, long j3, long j4, zzxk zzxk, zzzg zzzg, List list) {
        long j5 = j2;
        long j6 = j3;
        long j7 = j4;
        zzxk zzxk2 = zzxk;
        zzzg zzzg2 = zzzg;
        List list2 = list;
        zzvh zzvh2 = this.zzk;
        boolean z = this.zzl;
        int i = this.zzm;
        zzcg zzcg = this.zzn;
        long j8 = this.zzp;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = this.zze;
        zziz zziz = this.zzf;
        boolean z2 = this.zzg;
        return new zzly(this.zza, zzvh, j5, j6, i2, zziz, z2, zzxk2, zzzg2, list2, zzvh2, z, i, zzcg, j8, j7, j, elapsedRealtime, false);
    }

    public final zzly zzc(boolean z, int i) {
        zzcg zzcg = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, z, i, zzcg, j, j2, j3, j4, false);
    }

    public final zzly zzd(zziz zziz) {
        boolean z = this.zzg;
        zzxk zzxk = this.zzh;
        zzzg zzzg = this.zzi;
        List list = this.zzj;
        zzvh zzvh = this.zzk;
        boolean z2 = this.zzl;
        int i = this.zzm;
        zzcg zzcg = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, this.zze, zziz, z, zzxk, zzzg, list, zzvh, z2, i, zzcg, j, j2, j3, j4, false);
    }

    public final zzly zze(int i) {
        zziz zziz = this.zzf;
        boolean z = this.zzg;
        zzxk zzxk = this.zzh;
        zzzg zzzg = this.zzi;
        List list = this.zzj;
        zzvh zzvh = this.zzk;
        boolean z2 = this.zzl;
        int i2 = this.zzm;
        zzcg zzcg = this.zzn;
        long j = this.zzp;
        long j2 = this.zzq;
        long j3 = this.zzr;
        long j4 = this.zzs;
        return new zzly(this.zza, this.zzb, this.zzc, this.zzd, i, zziz, z, zzxk, zzzg, list, zzvh, z2, i2, zzcg, j, j2, j3, j4, false);
    }

    public final zzly zzf(zzcx zzcx) {
        return new zzly(zzcx, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzm, this.zzn, this.zzp, this.zzq, this.zzr, this.zzs, false);
    }

    public final boolean zzi() {
        return this.zze == 3 && this.zzl && this.zzm == 0;
    }
}
