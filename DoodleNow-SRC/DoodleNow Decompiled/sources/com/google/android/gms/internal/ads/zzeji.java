package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeji extends zzbsg {
    final /* synthetic */ zzejj zza;
    private final zzegm zzb;

    /* synthetic */ zzeji(zzejj zzejj, zzegm zzegm, zzejh zzejh) {
        this.zza = zzejj;
        this.zzb = zzegm;
    }

    public final void zze(String str) throws RemoteException {
        ((zzeif) this.zzb.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzeif) this.zzb.zzc).zzh(zze);
    }

    public final void zzg(zzbrd zzbrd) throws RemoteException {
        this.zza.zzc = zzbrd;
        ((zzeif) this.zzb.zzc).zzo();
    }
}
