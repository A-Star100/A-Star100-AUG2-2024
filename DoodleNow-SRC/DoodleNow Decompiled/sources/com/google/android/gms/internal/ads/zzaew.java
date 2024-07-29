package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzaew implements zzaef {
    final /* synthetic */ zzaez zza;
    private final long zzb;

    public zzaew(zzaez zzaez, long j) {
        this.zza = zzaez;
        this.zzb = j;
    }

    public final long zza() {
        return this.zzb;
    }

    public final zzaed zzg(long j) {
        zzaed zza2 = this.zza.zzh[0].zza(j);
        int i = 1;
        while (true) {
            zzaez zzaez = this.zza;
            if (i >= zzaez.zzh.length) {
                return zza2;
            }
            zzaed zza3 = zzaez.zzh[i].zza(j);
            if (zza3.zza.zzc < zza2.zza.zzc) {
                zza2 = zza3;
            }
            i++;
        }
    }

    public final boolean zzh() {
        return true;
    }
}
