package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final class zzwn implements zzvt {
    private final zzgu zzc;
    private int zzd = 1048576;
    private final zzwm zze;
    private final zzzs zzf;
    private final zzsd zzg;

    public zzwn(zzgu zzgu, zzwm zzwm) {
        zzsd zzsd = new zzsd();
        zzzs zzzs = new zzzs();
        this.zzc = zzgu;
        this.zze = zzwm;
        this.zzg = zzsd;
        this.zzf = zzzs;
    }

    public final zzwn zza(int i) {
        this.zzd = i;
        return this;
    }

    public final zzwp zzb(zzbp zzbp) {
        zzbp.zzd.getClass();
        return new zzwp(zzbp, this.zzc, this.zze, zzsm.zza, this.zzf, this.zzd, (zzwo) null);
    }
}
