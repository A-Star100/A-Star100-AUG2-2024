package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.DefaultLoadControl;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzcfk implements zzlc {
    private final zzzo zzb = new zzzo(true, 65536);
    private long zzc = 15000000;
    private long zzd = 30000000;
    private long zze = 2500000;
    private long zzf = 5000000;
    private int zzg;
    private boolean zzh;

    zzcfk() {
    }

    public final long zza(zzpb zzpb) {
        return 0;
    }

    public final void zzb(zzpb zzpb) {
        zzj(false);
    }

    public final void zzc(zzpb zzpb) {
        zzj(true);
    }

    public final void zzd(zzpb zzpb) {
        zzj(true);
    }

    public final void zze(zzpb zzpb, zzcx zzcx, zzvh zzvh, zzmf[] zzmfArr, zzxk zzxk, zzyz[] zzyzArr) {
        int i = 0;
        this.zzg = 0;
        while (true) {
            int length = zzmfArr.length;
            if (i < 2) {
                if (zzyzArr[i] != null) {
                    this.zzg += zzmfArr[i].zzb() != 1 ? DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE : 13107200;
                }
                i++;
            } else {
                this.zzb.zzf(this.zzg);
                return;
            }
        }
    }

    public final boolean zzf(zzpb zzpb) {
        return false;
    }

    public final boolean zzg(zzpb zzpb, zzcx zzcx, zzvh zzvh, long j, long j2, float f) {
        boolean z = true;
        boolean z2 = j2 > this.zzd ? false : j2 < this.zzc ? true : true;
        int zza = this.zzb.zza();
        int i = this.zzg;
        if (!z2 && (!z2 || !this.zzh || zza >= i)) {
            z = false;
        }
        this.zzh = z;
        return z;
    }

    public final boolean zzh(zzpb zzpb, zzcx zzcx, zzvh zzvh, long j, float f, boolean z, long j2) {
        long j3 = z ? this.zzf : this.zze;
        return j3 <= 0 || j >= j3;
    }

    public final zzzo zzi() {
        return this.zzb;
    }

    /* access modifiers changed from: package-private */
    public final void zzj(boolean z) {
        this.zzg = 0;
        this.zzh = false;
        if (z) {
            this.zzb.zze();
        }
    }

    public final synchronized void zzk(int i) {
        this.zze = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zzf = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zzc = ((long) i) * 1000;
    }
}
