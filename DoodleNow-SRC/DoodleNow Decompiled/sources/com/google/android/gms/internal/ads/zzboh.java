package com.google.android.gms.internal.ads;

import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzboh implements Runnable {
    public final /* synthetic */ zzbpc zza;
    public final /* synthetic */ zzbpb zzb;
    public final /* synthetic */ zzbnx zzc;
    public final /* synthetic */ ArrayList zzd;
    public final /* synthetic */ long zze;

    public /* synthetic */ zzboh(zzbpc zzbpc, zzbpb zzbpb, zzbnx zzbnx, ArrayList arrayList, long j) {
        this.zza = zzbpc;
        this.zzb = zzbpb;
        this.zzc = zzbnx;
        this.zzd = arrayList;
        this.zze = j;
    }

    public final void run() {
        this.zza.zzi(this.zzb, this.zzc, this.zzd, this.zze);
    }
}
