package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzacn {
    public static final zzacn zza = new zzacn(-3, C.TIME_UNSET, -1);
    /* access modifiers changed from: private */
    public final int zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final long zzd;

    private zzacn(int i, long j, long j2) {
        this.zzb = i;
        this.zzc = j;
        this.zzd = j2;
    }

    public static zzacn zzd(long j, long j2) {
        return new zzacn(-1, j, j2);
    }

    public static zzacn zze(long j) {
        return new zzacn(0, C.TIME_UNSET, j);
    }

    public static zzacn zzf(long j, long j2) {
        return new zzacn(-2, j, j2);
    }
}
