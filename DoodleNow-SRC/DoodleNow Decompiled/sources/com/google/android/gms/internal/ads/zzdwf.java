package com.google.android.gms.internal.ads;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzdwf implements Runnable {
    public final /* synthetic */ zzdwk zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ zzbna zzc;
    public final /* synthetic */ zzfhg zzd;
    public final /* synthetic */ List zze;

    public /* synthetic */ zzdwf(zzdwk zzdwk, String str, zzbna zzbna, zzfhg zzfhg, List list) {
        this.zza = zzdwk;
        this.zzb = str;
        this.zzc = zzbna;
        this.zzd = zzfhg;
        this.zze = list;
    }

    public final void run() {
        this.zza.zzn(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
