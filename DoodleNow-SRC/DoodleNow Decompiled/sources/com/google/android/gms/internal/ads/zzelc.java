package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzelc implements zzfwf {
    public final /* synthetic */ zzelg zza;
    public final /* synthetic */ zzcgm zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ zzdqn zzd;

    public /* synthetic */ zzelc(zzelg zzelg, zzcgm zzcgm, zzffn zzffn, zzdqn zzdqn) {
        this.zza = zzelg;
        this.zzb = zzcgm;
        this.zzc = zzffn;
        this.zzd = zzdqn;
    }

    public final Object apply(Object obj) {
        zzcgm zzcgm = this.zzb;
        if (this.zzc.zzN) {
            zzcgm.zzaf();
        }
        zzdqn zzdqn = this.zzd;
        zzcgm.zzZ();
        zzcgm.onPause();
        return zzdqn.zzk();
    }
}
