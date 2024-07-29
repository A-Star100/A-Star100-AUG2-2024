package com.google.android.gms.internal.ads;

import android.os.SystemClock;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzmm implements zzlh {
    private final zzel zza;
    private boolean zzb;
    private long zzc;
    private long zzd;
    private zzcg zze = zzcg.zza;

    public zzmm(zzel zzel) {
        this.zza = zzel;
    }

    public final long zza() {
        long j;
        long j2 = this.zzc;
        if (!this.zzb) {
            return j2;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.zzd;
        zzcg zzcg = this.zze;
        if (zzcg.zzc == 1.0f) {
            j = zzfx.zzr(elapsedRealtime);
        } else {
            j = zzcg.zza(elapsedRealtime);
        }
        return j2 + j;
    }

    public final void zzb(long j) {
        this.zzc = j;
        if (this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
        }
    }

    public final zzcg zzc() {
        return this.zze;
    }

    public final void zzd() {
        if (!this.zzb) {
            this.zzd = SystemClock.elapsedRealtime();
            this.zzb = true;
        }
    }

    public final void zze() {
        if (this.zzb) {
            zzb(zza());
            this.zzb = false;
        }
    }

    public final void zzg(zzcg zzcg) {
        if (this.zzb) {
            zzb(zza());
        }
        this.zze = zzcg;
    }

    public final /* synthetic */ boolean zzj() {
        throw null;
    }
}
