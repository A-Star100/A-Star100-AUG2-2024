package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzevo implements Runnable {
    public final /* synthetic */ zzevs zza;
    public final /* synthetic */ zzbsn zzb;
    public final /* synthetic */ Bundle zzc;
    public final /* synthetic */ List zzd;
    public final /* synthetic */ zzemz zze;
    public final /* synthetic */ zzcbw zzf;

    public /* synthetic */ zzevo(zzevs zzevs, zzbsn zzbsn, Bundle bundle, List list, zzemz zzemz, zzcbw zzcbw) {
        this.zza = zzevs;
        this.zzb = zzbsn;
        this.zzc = bundle;
        this.zzd = list;
        this.zze = zzemz;
        this.zzf = zzcbw;
    }

    public final void run() {
        this.zza.zze(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
