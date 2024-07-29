package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zzbg;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdvs extends zzbg {
    final /* synthetic */ zzdvm zza;
    final /* synthetic */ zzdvt zzb;

    zzdvs(zzdvt zzdvt, zzdvm zzdvm) {
        this.zza = zzdvm;
        this.zzb = zzdvt;
    }

    public final void zzc() throws RemoteException {
        this.zza.zzb(this.zzb.zza);
    }

    public final void zzd() throws RemoteException {
        this.zza.zzc(this.zzb.zza);
    }

    public final void zze(int i) throws RemoteException {
        this.zza.zzd(this.zzb.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        this.zza.zzd(this.zzb.zza, zze.zza);
    }

    public final void zzg() {
    }

    public final void zzh() {
    }

    public final void zzi() throws RemoteException {
        this.zza.zze(this.zzb.zza);
    }

    public final void zzj() throws RemoteException {
        this.zza.zzg(this.zzb.zza);
    }

    public final void zzk() {
    }
}
