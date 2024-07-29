package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzeii implements zzfwf {
    public final /* synthetic */ zzeim zza;
    public final /* synthetic */ zzcgm zzb;
    public final /* synthetic */ zzffn zzc;
    public final /* synthetic */ zzdhm zzd;

    public /* synthetic */ zzeii(zzeim zzeim, zzcgm zzcgm, zzffn zzffn, zzdhm zzdhm) {
        this.zza = zzeim;
        this.zzb = zzcgm;
        this.zzc = zzffn;
        this.zzd = zzdhm;
    }

    public final Object apply(Object obj) {
        zzcgm zzcgm = this.zzb;
        if (this.zzc.zzN) {
            zzcgm.zzaf();
        }
        zzdhm zzdhm = this.zzd;
        zzcgm.zzZ();
        zzcgm.onPause();
        return zzdhm.zzg();
    }
}
