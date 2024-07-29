package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
public class zzekw extends zzelx {
    private final zzdgw zza;

    public zzekw(zzcyo zzcyo, zzdgl zzdgl, zzczi zzczi, zzczx zzczx, zzdac zzdac, zzczd zzczd, zzddk zzddk, zzdhi zzdhi, zzdaw zzdaw, zzdgw zzdgw, zzddg zzddg) {
        super(zzcyo, zzdgl, zzczi, zzczx, zzdac, zzddk, zzdaw, zzdhi, zzddg, zzczd);
        this.zza = zzdgw;
    }

    public final void zzs(zzbyc zzbyc) {
        this.zza.zza(zzbyc);
    }

    public final void zzt(zzbyg zzbyg) throws RemoteException {
        this.zza.zza(new zzbyc(zzbyg.zzf(), zzbyg.zze()));
    }

    public final void zzu() throws RemoteException {
        this.zza.zzb();
    }

    public final void zzv() {
        this.zza.zzb();
    }

    public final void zzy() {
        this.zza.zzc();
    }
}
