package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.zze;

/* compiled from: com.google.android.gms:play-services-ads@@23.1.0 */
final class zzeit extends zzbsd {
    private final zzegm zza;

    /* synthetic */ zzeit(zzeiu zzeiu, zzegm zzegm, zzeis zzeis) {
        this.zza = zzegm;
    }

    public final void zze(String str) throws RemoteException {
        ((zzeif) this.zza.zzc).zzi(0, str);
    }

    public final void zzf(zze zze) throws RemoteException {
        ((zzeif) this.zza.zzc).zzh(zze);
    }

    public final void zzg() throws RemoteException {
        ((zzeif) this.zza.zzc).zzo();
    }
}
