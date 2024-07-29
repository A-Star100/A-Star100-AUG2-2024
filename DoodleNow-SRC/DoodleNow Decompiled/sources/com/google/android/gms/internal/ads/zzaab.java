package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzaab {
    public static final zzzv zza = new zzzv(0, C.TIME_UNSET, (zzzu) null);
    public static final zzzv zzb = new zzzv(1, C.TIME_UNSET, (zzzu) null);
    public static final zzzv zzc = new zzzv(2, C.TIME_UNSET, (zzzu) null);
    public static final zzzv zzd = new zzzv(3, C.TIME_UNSET, (zzzu) null);
    /* access modifiers changed from: private */
    public final ExecutorService zze = zzfx.zzE("ExoPlayer:Loader:ProgressiveMediaPeriod");
    /* access modifiers changed from: private */
    public zzzw zzf;
    /* access modifiers changed from: private */
    public IOException zzg;

    public zzaab(String str) {
    }

    public static zzzv zzb(boolean z, long j) {
        return new zzzv(z ? 1 : 0, j, (zzzu) null);
    }

    public final long zza(zzzx zzzx, zzzt zzzt, int i) {
        Looper myLooper = Looper.myLooper();
        zzek.zzb(myLooper);
        this.zzg = null;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzzw(this, myLooper, zzzx, zzzt, i, elapsedRealtime).zzc(0);
        return elapsedRealtime;
    }

    public final void zzg() {
        zzzw zzzw = this.zzf;
        zzek.zzb(zzzw);
        zzzw.zza(false);
    }

    public final void zzh() {
        this.zzg = null;
    }

    public final void zzj(zzzy zzzy) {
        zzzw zzzw = this.zzf;
        if (zzzw != null) {
            zzzw.zza(true);
        }
        this.zze.execute(new zzzz(zzzy));
        this.zze.shutdown();
    }

    public final boolean zzk() {
        return this.zzg != null;
    }

    public final boolean zzl() {
        return this.zzf != null;
    }

    public final void zzi(int i) throws IOException {
        IOException iOException = this.zzg;
        if (iOException == null) {
            zzzw zzzw = this.zzf;
            if (zzzw != null) {
                zzzw.zzb(i);
                return;
            }
            return;
        }
        throw iOException;
    }
}
