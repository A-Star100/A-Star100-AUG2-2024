package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzdvv extends zzbyp {
    final /* synthetic */ zzdvx zza;

    zzdvv(zzdvx zzdvx) {
        this.zza = zzdvx;
    }

    public final void zze(int i) throws RemoteException {
        zzdvx zzdvx = this.zza;
        zzdvx.zzb.zzm(zzdvx.zza, i);
    }

    public final void zzf(zze zze) throws RemoteException {
        zzdvx zzdvx = this.zza;
        zzdvx.zzb.zzm(zzdvx.zza, zze.zza);
    }

    public final void zzg() throws RemoteException {
        zzdvx zzdvx = this.zza;
        zzdvx.zzb.zzp(zzdvx.zza);
    }
}
