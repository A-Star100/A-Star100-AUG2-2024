package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public final /* synthetic */ class zzvn implements Runnable {
    public final /* synthetic */ zzvq zza;
    public final /* synthetic */ zzvr zzb;
    public final /* synthetic */ zzuy zzc;
    public final /* synthetic */ zzvd zzd;
    public final /* synthetic */ IOException zze;
    public final /* synthetic */ boolean zzf;

    public /* synthetic */ zzvn(zzvq zzvq, zzvr zzvr, zzuy zzuy, zzvd zzvd, IOException iOException, boolean z) {
        this.zza = zzvq;
        this.zzb = zzvr;
        this.zzc = zzuy;
        this.zzd = zzvd;
        this.zze = iOException;
        this.zzf = z;
    }

    public final void run() {
        this.zzb.zzah(0, this.zza.zzb, this.zzc, this.zzd, this.zze, this.zzf);
    }
}
