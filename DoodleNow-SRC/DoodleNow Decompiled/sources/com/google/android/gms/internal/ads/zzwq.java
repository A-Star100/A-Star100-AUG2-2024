package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzwq implements zzzi {
    public long zza;
    public long zzb;
    public zzzh zzc;
    public zzwq zzd;

    public zzwq(long j, int i) {
        zze(j, 65536);
    }

    public final int zza(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzwq zzb() {
        this.zzc = null;
        zzwq zzwq = this.zzd;
        this.zzd = null;
        return zzwq;
    }

    public final zzzh zzc() {
        zzzh zzzh = this.zzc;
        zzzh.getClass();
        return zzzh;
    }

    public final zzzi zzd() {
        zzwq zzwq = this.zzd;
        if (zzwq == null || zzwq.zzc == null) {
            return null;
        }
        return zzwq;
    }

    public final void zze(long j, int i) {
        zzek.zzf(this.zzc == null);
        this.zza = j;
        this.zzb = j + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }
}
