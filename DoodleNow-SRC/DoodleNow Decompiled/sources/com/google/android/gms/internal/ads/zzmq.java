package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzmq {
    public final long zza;
    public final zzcx zzb;
    public final int zzc;
    public final zzvh zzd;
    public final long zze;
    public final zzcx zzf;
    public final int zzg;
    public final zzvh zzh;
    public final long zzi;
    public final long zzj;

    public zzmq(long j, zzcx zzcx, int i, zzvh zzvh, long j2, zzcx zzcx2, int i2, zzvh zzvh2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzcx;
        this.zzc = i;
        this.zzd = zzvh;
        this.zze = j2;
        this.zzf = zzcx2;
        this.zzg = i2;
        this.zzh = zzvh2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmq zzmq = (zzmq) obj;
            return this.zza == zzmq.zza && this.zzc == zzmq.zzc && this.zze == zzmq.zze && this.zzg == zzmq.zzg && this.zzi == zzmq.zzi && this.zzj == zzmq.zzj && zzfwl.zza(this.zzb, zzmq.zzb) && zzfwl.zza(this.zzd, zzmq.zzd) && zzfwl.zza(this.zzf, zzmq.zzf) && zzfwl.zza(this.zzh, zzmq.zzh);
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj)});
    }
}
