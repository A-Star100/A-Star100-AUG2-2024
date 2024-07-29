package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzegt implements zzfwf {
    public final /* synthetic */ zzegu zza;
    public final /* synthetic */ zzcgm zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ zzcqx zzd;

    public /* synthetic */ zzegt(zzegu zzegu, zzcgm zzcgm, zzffn zzffn, zzcqx zzcqx) {
        this.zza = zzegu;
        this.zzb = zzcgm;
        this.zzc = zzffn;
        this.zzd = zzcqx;
    }

    public final Object apply(Object obj) {
        zzcgm zzcgm = this.zzb;
        if (this.zzc.zzN) {
            zzcgm.zzaf();
        }
        zzcqx zzcqx = this.zzd;
        zzcgm.zzZ();
        zzcgm.onPause();
        return zzcqx.zza();
    }
}
