package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzevp implements zzgdk {
    public final /* synthetic */ zzevs zza;
    public final /* synthetic */ String zzb;
    public final /* synthetic */ List zzc;
    public final /* synthetic */ Bundle zzd;
    public final /* synthetic */ boolean zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzevp(zzevs zzevs, String str, List list, Bundle bundle, boolean z, boolean z2) {
        this.zza = zzevs;
        this.zzb = str;
        this.zzc = list;
        this.zzd = bundle;
        this.zze = z;
        this.zzf = z2;
    }

    public final ListenableFuture zza() {
        return this.zza.zzd(this.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
