package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzhe implements zzgu {
    private final zzhs zza = new zzhs();
    private zzhy zzb;
    private String zzc;
    private int zzd = 8000;
    private int zze = 8000;
    private boolean zzf;

    public final zzhe zzb(boolean z) {
        this.zzf = true;
        return this;
    }

    public final zzhe zzc(int i) {
        this.zzd = i;
        return this;
    }

    public final zzhe zzd(int i) {
        this.zze = i;
        return this;
    }

    public final zzhe zze(zzhy zzhy) {
        this.zzb = zzhy;
        return this;
    }

    public final zzhe zzf(String str) {
        this.zzc = str;
        return this;
    }

    /* renamed from: zzg */
    public final zzhj zza() {
        zzhj zzhj = new zzhj(this.zzc, this.zzd, this.zze, this.zzf, this.zza, (zzfws) null, false, (zzhi) null);
        zzhy zzhy = this.zzb;
        if (zzhy != null) {
            zzhj.zzf(zzhy);
        }
        return zzhj;
    }
}
